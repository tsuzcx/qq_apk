package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCAudioEngineJNI
{
  private static final String TAG = "TXCAudioEngineJNI";
  private static WeakReference<e> mAudioCaptureDataListener;
  private static a mAudioDumpingListener;
  
  static
  {
    AppMethodBeat.i(221897);
    f.f();
    nativeCacheClassForNative();
    mAudioDumpingListener = null;
    mAudioCaptureDataListener = null;
    AppMethodBeat.o(221897);
  }
  
  public static void InitTraeEngineLibrary(Context paramContext)
  {
    AppMethodBeat.i(221890);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioEngineJNI", "InitTraeEngineLibrary failed, context is null!");
      AppMethodBeat.o(221890);
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationInfo();
      String str2 = paramContext.nativeLibraryDir;
      String str3 = paramContext.dataDir + "/lib";
      String str4 = "/data/data/" + paramContext.packageName + "/lib";
      String str1 = f.g();
      paramContext = str1;
      if (str1 == null) {
        paramContext = "";
      }
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str2)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str3)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str4)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(221890);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      TXCLog.e("TXCAudioEngineJNI", "init trae engine library failed.", paramContext);
      AppMethodBeat.o(221890);
    }
  }
  
  public static void SetAudioDumpingListener(a parama)
  {
    mAudioDumpingListener = parama;
  }
  
  public static StatusBucket getStatus(int paramInt)
  {
    AppMethodBeat.i(221896);
    StatusBucket localStatusBucket = nativeGetStatus(paramInt);
    AppMethodBeat.o(221896);
    return localStatusBucket;
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext)
  {
    AppMethodBeat.i(221891);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, context is null!");
      AppMethodBeat.o(221891);
      return false;
    }
    if (f.a("traeimp-rtmp"))
    {
      TXCLog.e("TXCAudioEngineJNI", "link traeimp-rtmp success !");
      AppMethodBeat.o(221891);
      return true;
    }
    paramContext = paramContext.getApplicationInfo();
    String str2 = paramContext.nativeLibraryDir;
    String str3 = paramContext.dataDir + "/lib";
    String str4 = "/data/data/" + paramContext.packageName + "/lib";
    String str1 = f.g();
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
      AppMethodBeat.o(221891);
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
    AppMethodBeat.o(221891);
    return false;
  }
  
  public static native void nativeClean();
  
  public static native void nativeDeleteAudioSessionDuplicate();
  
  public static native void nativeEnableAudioEarMonitoring(boolean paramBoolean);
  
  public static native void nativeEnableAudioVolumeEvaluation(boolean paramBoolean, int paramInt);
  
  public static native void nativeEnableAutoRestartDevice(boolean paramBoolean);
  
  public static native void nativeEnableCaptureEOSMode(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean);
  
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
  
  public static native boolean nativeIsRemoteAudioPlaying(String paramString);
  
  public static native void nativeMuteLocalAudio(boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudio(String paramString, boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudioInSpeaker(String paramString, boolean paramBoolean);
  
  public static native void nativeNewAudioSessionDuplicate(Context paramContext);
  
  public static native void nativePauseAudioCapture(boolean paramBoolean);
  
  public static native void nativePauseLocalAudio();
  
  public static native void nativeResumeAudioCapture();
  
  public static native void nativeResumeLocalAudio();
  
  public static native void nativeSendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public static native void nativeSetAudioEarMonitoringVolume(int paramInt);
  
  public static native void nativeSetAudioEncoderParam(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioEngineCaptureDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineCaptureRawDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineEncodedDataCallback(boolean paramBoolean);
  
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
  
  public static native void nativeSetSystemVolumeType(int paramInt);
  
  public static native void nativeSetTRAEConfig(String paramString);
  
  public static native void nativeStartLocalAudio(int paramInt, boolean paramBoolean);
  
  public static native int nativeStartLocalAudioDumping(int paramInt1, int paramInt2, String paramString);
  
  public static native String nativeStartRemoteAudio(TXCAudioEngine paramTXCAudioEngine, boolean paramBoolean, String paramString);
  
  public static native void nativeStopLocalAudio();
  
  public static native void nativeStopLocalAudioDumping();
  
  public static native void nativeStopRemoteAudio(String paramString);
  
  public static native void nativeUnInitEngine();
  
  public static native void nativeUseSysAudioDevice(boolean paramBoolean);
  
  public static void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221888);
    TXCAudioEngine.getInstance().onError(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(221888);
  }
  
  public static void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221887);
    TXCAudioEngine.getInstance().onEvent(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(221887);
  }
  
  public static void onLocalAudioWriteFail()
  {
    AppMethodBeat.i(221889);
    if (mAudioDumpingListener != null) {
      mAudioDumpingListener.onLocalAudioWriteFailed();
    }
    AppMethodBeat.o(221889);
  }
  
  public static void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221885);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((e)mAudioCaptureDataListener.get()).onRecordEncData(paramArrayOfByte, paramLong, paramInt1, paramInt2, 16);
    }
    AppMethodBeat.o(221885);
  }
  
  public static void onRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(221886);
    TXCLog.e("TXCAudioEngineJNI", "onRecordError: " + paramInt + ", " + paramString);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((e)mAudioCaptureDataListener.get()).onRecordError(paramInt, paramString);
    }
    AppMethodBeat.o(221886);
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221884);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((e)mAudioCaptureDataListener.get()).onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(221884);
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221883);
    if ((mAudioCaptureDataListener != null) && (mAudioCaptureDataListener.get() != null)) {
      ((e)mAudioCaptureDataListener.get()).onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, false);
    }
    AppMethodBeat.o(221883);
  }
  
  public static void pauseAudioCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(221892);
    nativePauseAudioCapture(paramBoolean);
    AppMethodBeat.o(221892);
  }
  
  public static void resumeAudioCapture()
  {
    AppMethodBeat.i(221893);
    nativeResumeAudioCapture();
    AppMethodBeat.o(221893);
  }
  
  public static void sendCustomPCMData(a parama)
  {
    AppMethodBeat.i(221895);
    nativeSendCustomPCMData(parama.f, parama.f.length, parama.e, parama.a, parama.b);
    AppMethodBeat.o(221895);
  }
  
  public static void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221894);
    nativeSendCustomPCMData(paramArrayOfByte, paramArrayOfByte.length, 0L, paramInt1, paramInt2);
    AppMethodBeat.o(221894);
  }
  
  public static void setAudioCaptureDataListener(WeakReference<e> paramWeakReference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(221882);
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
      AppMethodBeat.o(221882);
      return;
      bool1 = true;
      break;
      bool1 = true;
      break label30;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLocalAudioWriteFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCAudioEngineJNI
 * JD-Core Version:    0.7.0.1
 */