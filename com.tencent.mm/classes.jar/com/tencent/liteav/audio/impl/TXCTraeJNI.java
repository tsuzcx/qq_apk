package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXCSoundEffectPlayer;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCTraeJNI
{
  private static Context mContext;
  private static WeakReference<e> mTraeRecordListener;
  
  static
  {
    AppMethodBeat.i(16474);
    d.f();
    nativeCacheClassForNative();
    mTraeRecordListener = null;
    AppMethodBeat.o(16474);
  }
  
  public static void InitTraeEngineLibrary(Context paramContext)
  {
    AppMethodBeat.i(16463);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioJNI", "nativeInitTraeEngine failed, context is null!");
      AppMethodBeat.o(16463);
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationInfo();
      String str2 = paramContext.nativeLibraryDir;
      String str3 = paramContext.dataDir + "/lib";
      String str4 = "/data/data/" + paramContext.packageName + "/lib";
      String str1 = d.g();
      paramContext = str1;
      if (str1 == null) {
        paramContext = "";
      }
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str2)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str3)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str4)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(16463);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      AppMethodBeat.o(16463);
    }
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext)
  {
    AppMethodBeat.i(16464);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioJNI", "nativeCheckTraeEngine failed, context is null!");
      AppMethodBeat.o(16464);
      return false;
    }
    if (d.a("traeimp-rtmp"))
    {
      TXCLog.e("TXCAudioJNI", "link traeimp-rtmp success !");
      AppMethodBeat.o(16464);
      return true;
    }
    paramContext = paramContext.getApplicationInfo();
    String str2 = paramContext.nativeLibraryDir;
    String str3 = paramContext.dataDir + "/lib";
    String str4 = "/data/data/" + paramContext.packageName + "/lib";
    String str1 = d.g();
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
      AppMethodBeat.o(16464);
      return true;
      TXCLog.w("TXCAudioJNI", "nativeCheckTraeEngine load so error " + str2 + "/libtraeimp-rtmp.so");
      if (new File(str3 + "/libtraeimp-rtmp.so").exists())
      {
        i = 1;
      }
      else
      {
        TXCLog.w("TXCAudioJNI", "nativeCheckTraeEngine load so error " + str3 + "/libtraeimp-rtmp.so");
        if (new File(str4 + "/libtraeimp-rtmp.so").exists())
        {
          i = 1;
        }
        else
        {
          TXCLog.w("TXCAudioJNI", "nativeCheckTraeEngine load so error " + str4 + "/libtraeimp-rtmp.so");
          if (new File(paramContext + "/libtraeimp-rtmp.so").exists())
          {
            i = 1;
          }
          else
          {
            TXCLog.w("TXCAudioJNI", "nativeCheckTraeEngine load so error " + paramContext + "/libtraeimp-rtmp.so");
            i = 0;
          }
        }
      }
    }
    TXCLog.e("TXCAudioJNI", "nativeCheckTraeEngine failed, can not find trae libs !");
    AppMethodBeat.o(16464);
    return false;
  }
  
  public static native void nativeDeleteAudioSessionDuplicate();
  
  public static native void nativeEncodeAfterCallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void nativeInitBeforeEngineCreate(Context paramContext);
  
  public static native void nativeNewAudioSessionDuplicate(Context paramContext);
  
  public static native void nativeSendCustomPCMData(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  public static native void nativeSetAudioMode(int paramInt);
  
  public static native void nativeSetAudioRoute(int paramInt);
  
  public static native void nativeSetEncInfo(int paramInt1, int paramInt2);
  
  public static native void nativeSetFecRatio(float paramFloat);
  
  public static native void nativeSetTraeAEC(boolean paramBoolean, int paramInt);
  
  public static native void nativeSetTraeAGC(boolean paramBoolean, int paramInt);
  
  public static native void nativeSetTraeANS(boolean paramBoolean, int paramInt);
  
  public static native void nativeSetTraeConfig(String paramString);
  
  public static native void nativeSetTraeRecordListener(boolean paramBoolean);
  
  public static native int nativeTraeChangeVolumeType(int paramInt);
  
  public static native void nativeTraeEnableEosMode(boolean paramBoolean);
  
  public static native void nativeTraeEnableVolumeLevel(boolean paramBoolean);
  
  public static native int nativeTraeGetVolumeLevel();
  
  public static native boolean nativeTraeIsPlaying();
  
  public static native boolean nativeTraeIsRecording();
  
  public static native void nativeTraePauseAuioRecord(boolean paramBoolean);
  
  public static native void nativeTraeResumeAuioRecord();
  
  public static native void nativeTraeSetChangerType(int paramInt1, int paramInt2);
  
  public static native void nativeTraeSetDevState(int paramInt);
  
  public static native void nativeTraeSetIsCustomRecord(boolean paramBoolean);
  
  public static native void nativeTraeSetPlayoutVolume(float paramFloat);
  
  public static native void nativeTraeSetRecordMute(boolean paramBoolean);
  
  public static native void nativeTraeSetRecordReverb(int paramInt);
  
  public static native void nativeTraeSetRecordVolume(float paramFloat);
  
  public static native void nativeTraeSetSilence(boolean paramBoolean);
  
  private static native void nativeTraeStartPlay(Context paramContext);
  
  public static native void nativeTraeStartRecord(Context paramContext, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeTraeStopPlay();
  
  public static native void nativeTraeStopRecord();
  
  public static native void nativeUnInitEngine();
  
  public static native int nativesetAudioEarMonitoring(boolean paramBoolean);
  
  public static void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16461);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).onRecordEncData(paramArrayOfByte, paramLong, paramInt1, paramInt2, 16);
    }
    AppMethodBeat.o(16461);
  }
  
  public static void onRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(16462);
    TXCLog.e("TXCAudioJNI", "trae audio record error: " + paramInt + ", " + paramString);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).onRecordError(paramInt, paramString);
    }
    AppMethodBeat.o(16462);
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16460);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    nativeEncodeAfterCallback(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(16460);
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16459);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, false);
    }
    AppMethodBeat.o(16459);
  }
  
  public static void sendCustomPCMData(a parama)
  {
    AppMethodBeat.i(16473);
    nativeSendCustomPCMData(parama.f, parama.f.length, parama.e);
    AppMethodBeat.o(16473);
  }
  
  public static void sendCustomPCMData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16472);
    nativeSendCustomPCMData(paramArrayOfByte, paramArrayOfByte.length, 0L);
    AppMethodBeat.o(16472);
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static void setIsCustomRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16471);
    nativeTraeSetIsCustomRecord(paramBoolean);
    AppMethodBeat.o(16471);
  }
  
  public static void setTraeRecordListener(WeakReference<e> paramWeakReference)
  {
    AppMethodBeat.i(16458);
    mTraeRecordListener = paramWeakReference;
    if (paramWeakReference == null) {}
    for (boolean bool = false;; bool = true)
    {
      nativeSetTraeRecordListener(bool);
      AppMethodBeat.o(16458);
      return;
    }
  }
  
  public static void traePauseAuioRecord(boolean paramBoolean)
  {
    AppMethodBeat.i(16468);
    nativeTraePauseAuioRecord(paramBoolean);
    AppMethodBeat.o(16468);
  }
  
  public static void traeResumeAuioRecord()
  {
    AppMethodBeat.i(16469);
    nativeTraeResumeAuioRecord();
    AppMethodBeat.o(16469);
  }
  
  public static void traeSetSilence(boolean paramBoolean)
  {
    AppMethodBeat.i(16470);
    nativeTraeSetSilence(paramBoolean);
    AppMethodBeat.o(16470);
  }
  
  public static boolean traeStartPlay(Context paramContext)
  {
    AppMethodBeat.i(16466);
    if ((!TXCJitter.nativeIsTracksEmpty()) || (TXCLiveBGMPlayer.getInstance().isPlaying()) || (TXCSoundEffectPlayer.getInstance().isPlaying()))
    {
      InitTraeEngineLibrary(paramContext);
      nativeTraeStartPlay(paramContext);
      AppMethodBeat.o(16466);
      return true;
    }
    AppMethodBeat.o(16466);
    return false;
  }
  
  public static boolean traeStopPlay()
  {
    AppMethodBeat.i(16467);
    if ((TXCJitter.nativeIsTracksEmpty()) && (!TXCLiveBGMPlayer.getInstance().isPlaying()) && (!TXCSoundEffectPlayer.getInstance().isPlaying()))
    {
      nativeTraeStopPlay();
      AppMethodBeat.o(16467);
      return true;
    }
    AppMethodBeat.o(16467);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCTraeJNI
 * JD-Core Version:    0.7.0.1
 */