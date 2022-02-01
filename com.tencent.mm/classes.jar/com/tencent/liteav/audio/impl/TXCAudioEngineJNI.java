package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCAudioEngineJNI
{
  private static final String TAG = "TXCAudioEngineJNI";
  private static WeakReference<g> mAudioCaptureDataListener;
  private static a mAudioDumpingListener;
  private static WeakReference<e> mMixedAllDataListener;
  private static AudioManager sAudioManager;
  
  static
  {
    AppMethodBeat.i(246378);
    sAudioManager = null;
    h.f();
    nativeCacheClassForNative();
    mAudioDumpingListener = null;
    mAudioCaptureDataListener = null;
    mMixedAllDataListener = new WeakReference(null);
    AppMethodBeat.o(246378);
  }
  
  public static void InitTraeEngineLibrary(Context paramContext)
  {
    AppMethodBeat.i(246344);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioEngineJNI", "InitTraeEngineLibrary failed, context is null!");
      AppMethodBeat.o(246344);
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationInfo();
      String str2 = paramContext.nativeLibraryDir;
      String str3 = paramContext.dataDir + "/lib";
      String str4 = "/data/data/" + paramContext.packageName + "/lib";
      String str1 = h.g();
      paramContext = str1;
      if (str1 == null) {
        paramContext = "";
      }
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str2)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str3)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str4)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(246344);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      TXCLog.e("TXCAudioEngineJNI", "init trae engine library failed.", paramContext);
      AppMethodBeat.o(246344);
    }
  }
  
  public static void SetAudioDumpingListener(a parama)
  {
    mAudioDumpingListener = parama;
  }
  
  private static AudioManager getAudioManager()
  {
    AppMethodBeat.i(246355);
    if (sAudioManager == null) {
      sAudioManager = (AudioManager)TXCAudioEngine.getInstance().getAppContext().getSystemService("audio");
    }
    AudioManager localAudioManager = sAudioManager;
    AppMethodBeat.o(246355);
    return localAudioManager;
  }
  
  public static int getAudioMode()
  {
    AppMethodBeat.i(246352);
    try
    {
      AudioManager localAudioManager = getAudioManager();
      if (localAudioManager != null)
      {
        int i = localAudioManager.getMode();
        AppMethodBeat.o(246352);
        return i;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(246352);
    }
    return -1;
  }
  
  public static StatusBucket getStatus(int paramInt)
  {
    AppMethodBeat.i(246350);
    StatusBucket localStatusBucket = nativeGetStatus(paramInt);
    AppMethodBeat.o(246350);
    return localStatusBucket;
  }
  
  public static int getSystemVolume()
  {
    AppMethodBeat.i(246353);
    try
    {
      if (getAudioMode() == 0) {}
      for (int i = 3;; i = 0)
      {
        AudioManager localAudioManager = getAudioManager();
        if (localAudioManager == null) {
          break;
        }
        i = localAudioManager.getStreamVolume(i);
        AppMethodBeat.o(246353);
        return i;
      }
      return -1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(246353);
    }
  }
  
  public static boolean isAppInBackground()
  {
    AppMethodBeat.i(246351);
    boolean bool = h.a(TXCAudioEngine.getInstance().getAppContext());
    AppMethodBeat.o(246351);
    return bool;
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext)
  {
    AppMethodBeat.i(246345);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, context is null!");
      AppMethodBeat.o(246345);
      return false;
    }
    if (h.a("traeimp-rtmp"))
    {
      TXCLog.e("TXCAudioEngineJNI", "link traeimp-rtmp success !");
      AppMethodBeat.o(246345);
      return true;
    }
    paramContext = paramContext.getApplicationInfo();
    String str2 = paramContext.nativeLibraryDir;
    String str3 = paramContext.dataDir + "/lib";
    String str4 = "/data/data/" + paramContext.packageName + "/lib";
    String str1 = h.g();
    paramContext = str1;
    if (str1 == null) {
      paramContext = "";
    }
    int i;
    if (new File(str2 + "/libtraeimp-rtmp.so").exists()) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(246345);
      return true;
      TXCLog.w("TXCAudioEngineJNI", "nativeCheckTraeEngine load so error " + str2 + "/libtraeimp-rtmp.so");
      if (new File(str3 + "/libtraeimp-rtmp.so").exists())
      {
        i = 1;
      }
      else
      {
        TXCLog.w("TXCAudioEngineJNI", "nativeCheckTraeEngine load so error " + str3 + "/libtraeimp-rtmp.so");
        if (new File(str4 + "/libtraeimp-rtmp.so").exists())
        {
          i = 1;
        }
        else
        {
          TXCLog.w("TXCAudioEngineJNI", "nativeCheckTraeEngine load so error " + str4 + "/libtraeimp-rtmp.so");
          if (new File(paramContext + "/libtraeimp-rtmp.so").exists())
          {
            i = 1;
          }
          else
          {
            TXCLog.w("TXCAudioEngineJNI", "nativeCheckTraeEngine load so error " + paramContext + "/libtraeimp-rtmp.so");
            i = 0;
          }
        }
      }
    }
    TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, can not find trae libs !");
    AppMethodBeat.o(246345);
    return false;
  }
  
  public static native void nativeClean();
  
  public static native void nativeCloseAudioTunnel(int paramInt);
  
  public static native void nativeDeleteAudioSessionDuplicate();
  
  public static native void nativeEnableAudioEarMonitoring(boolean paramBoolean);
  
  public static native void nativeEnableAudioVolumeEvaluation(boolean paramBoolean, int paramInt);
  
  public static native void nativeEnableAutoRestartDevice(boolean paramBoolean);
  
  public static native void nativeEnableCaptureEOSMode(boolean paramBoolean);
  
  public static native void nativeEnableDeviceAbnormalDetection(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean);
  
  public static native void nativeEnableInbandFEC(boolean paramBoolean);
  
  public static native void nativeEnableMixMode(boolean paramBoolean);
  
  public static native void nativeForceCallbackMixedPlayAudioFrame(boolean paramBoolean);
  
  public static native int nativeGetEncoderChannels();
  
  public static native TXCAudioEncoderConfig nativeGetEncoderConfig();
  
  public static native int nativeGetEncoderSampleRate();
  
  public static native int nativeGetMixingPlayoutVolumeLevel();
  
  public static native int nativeGetRemotePlayoutVolumeLevel(String paramString);
  
  public static native int nativeGetSoftwareCaptureVolumeLevel();
  
  public static native StatusBucket nativeGetStatus(int paramInt);
  
  public static native void nativeInitAudioDevice();
  
  public static native void nativeInitBeforeEngineCreate(Context paramContext);
  
  public static native boolean nativeIsAudioDeviceCapturing();
  
  public static native boolean nativeIsAudioDevicePlaying();
  
  public static native boolean nativeIsDataCallbackFormatInvalid(int paramInt1, int paramInt2, int paramInt3);
  
  public static native boolean nativeIsRemoteAudioPlaying(String paramString);
  
  public static native void nativeMuteLocalAudio(boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudio(String paramString, boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudioInSpeaker(String paramString, boolean paramBoolean);
  
  public static native void nativeNewAudioSessionDuplicate(Context paramContext);
  
  public static native void nativeNotifySystemEarMonitoringInitializing();
  
  public static native int nativeOpenAudioTunnel(boolean paramBoolean);
  
  public static native void nativePauseAudioCapture(boolean paramBoolean);
  
  public static native void nativePauseLocalAudio();
  
  public static native void nativeResumeAudioCapture();
  
  public static native void nativeResumeLocalAudio();
  
  public static native void nativeSendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public static native void nativeSetAudioCacheParams(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioEarMonitoringVolume(int paramInt);
  
  public static native void nativeSetAudioEncoderParam(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioEngineCaptureDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineCaptureRawDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineMixedAllDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineRemoteStreamDataListener(String paramString, boolean paramBoolean);
  
  public static native void nativeSetAudioPlayoutTunnelEnabled(boolean paramBoolean);
  
  public static native void nativeSetAudioQuality(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioRoute(int paramInt);
  
  public static native void nativeSetCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetCaptureVoiceChanger(int paramInt);
  
  public static native void nativeSetEncoderChannels(int paramInt);
  
  public static native void nativeSetEncoderFECPercent(float paramFloat);
  
  public static native void nativeSetEncoderSampleRate(int paramInt);
  
  public static native void nativeSetEventCallbackEnabled(boolean paramBoolean);
  
  public static native void nativeSetLocalProcessedDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetMaxSelectedPlayStreams(int paramInt);
  
  public static native void nativeSetMixingPlayoutVolume(float paramFloat);
  
  public static native void nativeSetPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetPlayoutDataListener(boolean paramBoolean);
  
  public static native void nativeSetPlayoutDevice(int paramInt);
  
  public static native void nativeSetRecordReverb(int paramInt);
  
  public static native void nativeSetRemoteAudioBlockThreshold(String paramString, long paramLong);
  
  public static native void nativeSetRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetRemoteAudioJitterCycle(String paramString, long paramLong);
  
  public static native void nativeSetRemotePlayoutVolume(String paramString, int paramInt);
  
  public static native void nativeSetRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetSoftAEC(int paramInt);
  
  public static native void nativeSetSoftAGC(int paramInt);
  
  public static native void nativeSetSoftANS(int paramInt);
  
  public static native void nativeSetSoftwareCaptureVolume(float paramFloat);
  
  public static native void nativeSetSystemEarMonitoring(TXSystemAudioKit paramTXSystemAudioKit);
  
  public static native void nativeSetSystemVolumeType(int paramInt);
  
  public static native void nativeSetTRAEConfig(String paramString);
  
  public static native void nativeStartLocalAudio(int paramInt, boolean paramBoolean);
  
  public static native int nativeStartLocalAudioDumping(int paramInt1, int paramInt2, String paramString);
  
  public static native String nativeStartRemoteAudio(TXCAudioEngine paramTXCAudioEngine, boolean paramBoolean, String paramString);
  
  public static native void nativeStopLocalAudio();
  
  public static native void nativeStopLocalAudioDumping();
  
  public static native void nativeStopRemoteAudio(String paramString);
  
  public static native void nativeUnInitAudioDevice();
  
  public static native void nativeUseSysAudioDevice(boolean paramBoolean);
  
  public static native void nativeWriteDataToTunnel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte);
  
  public static void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246340);
    TXCAudioEngine.getInstance().onError(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(246340);
  }
  
  public static void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246338);
    TXCAudioEngine.getInstance().onEvent(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(246338);
  }
  
  public static void onLocalAudioWriteFail()
  {
    AppMethodBeat.i(246343);
    if (mAudioDumpingListener != null) {
      mAudioDumpingListener.onLocalAudioWriteFailed();
    }
    AppMethodBeat.o(246343);
  }
  
  public static void onMixedAllData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246342);
    e locale = (e)mMixedAllDataListener.get();
    if (locale != null) {
      locale.onMixedAllData(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(246342);
  }
  
  public static void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246336);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordEncData(paramArrayOfByte, paramLong, paramInt1, paramInt2, 16);
    }
    AppMethodBeat.o(246336);
  }
  
  public static void onRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(246337);
    TXCLog.e("TXCAudioEngineJNI", "onRecordError: " + paramInt + ", " + paramString);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordError(paramInt, paramString);
    }
    AppMethodBeat.o(246337);
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246335);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(246335);
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246334);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, false);
    }
    AppMethodBeat.o(246334);
  }
  
  public static void onWarning(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246339);
    TXCAudioEngine.getInstance().onWarning(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(246339);
  }
  
  public static void pauseAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(246346);
    nativePauseAudioCapture(paramBoolean);
    AppMethodBeat.o(246346);
  }
  
  public static void resumeAudioCapture()
  {
    AppMethodBeat.i(246347);
    nativeResumeAudioCapture();
    AppMethodBeat.o(246347);
  }
  
  public static void sendCustomPCMData(a parama)
  {
    AppMethodBeat.i(246349);
    nativeSendCustomPCMData(parama.f, parama.f.length, parama.e, parama.a, parama.b);
    AppMethodBeat.o(246349);
  }
  
  public static void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246348);
    nativeSendCustomPCMData(paramArrayOfByte, paramArrayOfByte.length, 0L, paramInt1, paramInt2);
    AppMethodBeat.o(246348);
  }
  
  public static void setAudioCaptureDataListener(WeakReference<g> paramWeakReference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(246333);
    mAudioCaptureDataListener = paramWeakReference;
    if (paramWeakReference == null)
    {
      bool1 = false;
      nativeSetAudioEngineCaptureDataCallback(bool1);
      if (mAudioCaptureDataListener != null) {
        break label58;
      }
      bool1 = false;
      label30:
      nativeSetAudioEngineCaptureRawDataCallback(bool1);
      if (mAudioCaptureDataListener != null) {
        break label63;
      }
    }
    label58:
    label63:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      nativeSetAudioEngineEncodedDataCallback(bool1);
      AppMethodBeat.o(246333);
      return;
      bool1 = true;
      break;
      bool1 = true;
      break label30;
    }
  }
  
  public static void setMixedAllDataListener(e parame)
  {
    AppMethodBeat.i(246341);
    mMixedAllDataListener = new WeakReference(parame);
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      nativeSetAudioEngineMixedAllDataCallback(bool);
      AppMethodBeat.o(246341);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLocalAudioWriteFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCAudioEngineJNI
 * JD-Core Version:    0.7.0.1
 */