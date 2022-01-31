package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCTraeJNI
{
  private static Context mContext;
  private static WeakReference<d> mTraeRecordListener;
  
  static
  {
    AppMethodBeat.i(66566);
    b.f();
    nativeCacheClassForNative();
    AppMethodBeat.o(66566);
  }
  
  public static void InitTraeEngineLibrary(Context paramContext)
  {
    AppMethodBeat.i(66562);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioJNI", "nativeInitTraeEngine failed, context is null!");
      AppMethodBeat.o(66562);
      return;
    }
    try
    {
      Object localObject = paramContext.getApplicationInfo();
      paramContext = ((ApplicationInfo)localObject).nativeLibraryDir;
      String str = ((ApplicationInfo)localObject).dataDir + "/lib";
      localObject = "/data/data/" + ((ApplicationInfo)localObject).packageName + "/lib";
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(paramContext)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str)));
      nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(66562);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      AppMethodBeat.o(66562);
    }
  }
  
  public static void SetAudioMode(int paramInt)
  {
    AppMethodBeat.i(66561);
    a.a().b(paramInt);
    AppMethodBeat.o(66561);
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext)
  {
    AppMethodBeat.i(66563);
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioJNI", "nativeCheckTraeEngine failed, context is null!");
      AppMethodBeat.o(66563);
      return false;
    }
    paramContext = paramContext.getApplicationInfo();
    String str2 = paramContext.nativeLibraryDir;
    String str3 = paramContext.dataDir + "/lib";
    String str4 = "/data/data/" + paramContext.packageName + "/lib";
    String str1 = b.g();
    paramContext = str1;
    if (str1 == null) {
      paramContext = "";
    }
    int i;
    if (new File(str2 + "/libTRAECodec.so").exists()) {
      i = 1;
    }
    for (;;)
    {
      int j;
      if (new File(str2 + "/libtraeimp-rtmp.so").exists()) {
        j = 1;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0))
        {
          AppMethodBeat.o(66563);
          return true;
          if (new File(str3 + "/libTRAECodec.so").exists())
          {
            i = 1;
            break;
          }
          if (new File(str4 + "/libTRAECodec.so").exists())
          {
            i = 1;
            break;
          }
          if (!new File(paramContext + "/libTRAECodec.so").exists()) {
            break label427;
          }
          i = 1;
          break;
          if (new File(str3 + "/libtraeimp-rtmp.so").exists())
          {
            j = 1;
            continue;
          }
          if (new File(str4 + "/libtraeimp-rtmp.so").exists())
          {
            j = 1;
            continue;
          }
          if (!new File(paramContext + "/libtraeimp-rtmp.so").exists()) {
            break label422;
          }
          j = 1;
          continue;
        }
        TXCLog.e("TXCAudioJNI", "nativeCheckTraeEngine failed, can not find trae libs !");
        AppMethodBeat.o(66563);
        return false;
        label422:
        j = 0;
      }
      label427:
      i = 0;
    }
  }
  
  public static native void nativeSetAudioMode(int paramInt);
  
  public static native void nativeSetEncBitRate(int paramInt);
  
  public static native void nativeSetEncFrameLenMs(int paramInt);
  
  public static native void nativeSetEncInfo(int paramInt1, int paramInt2);
  
  public static native void nativeSetFecRatio(float paramFloat);
  
  public static native void nativeSetTraeConfig(String paramString);
  
  public static native int nativeTraeGetVolumeLevel();
  
  public static native boolean nativeTraeIsPlaying();
  
  public static native boolean nativeTraeIsRecording();
  
  public static native void nativeTraeSetChangerType(int paramInt1, int paramInt2);
  
  public static native void nativeTraeSetEnableVolumeLevel(boolean paramBoolean);
  
  public static native void nativeTraeSetRecordMute(boolean paramBoolean);
  
  public static native void nativeTraeSetRecordReverb(int paramInt);
  
  public static native void nativeTraeSetVolume(float paramFloat);
  
  private static native void nativeTraeStartPlay(Context paramContext);
  
  public static native void nativeTraeStartRecord(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native void nativeTraeStopPlay();
  
  public static native void nativeTraeStopRecord(boolean paramBoolean);
  
  public static void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66559);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((d)mTraeRecordListener.get()).b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(66559);
  }
  
  public static void onRecordError(int paramInt, String paramString)
  {
    AppMethodBeat.i(66560);
    TXCLog.e("TXCAudioJNI", "trae audio record error: " + paramInt + ", " + paramString);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((d)mTraeRecordListener.get()).a(paramInt, paramString);
    }
    AppMethodBeat.o(66560);
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66558);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((d)mTraeRecordListener.get()).a(paramArrayOfByte, TXCTimeUtil.getTimeTick(), paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(66558);
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66557);
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((d)mTraeRecordListener.get()).a(paramArrayOfByte, TXCTimeUtil.getTimeTick(), paramInt1, paramInt2, paramInt3, false);
    }
    AppMethodBeat.o(66557);
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static void setTraeRecordListener(WeakReference<d> paramWeakReference)
  {
    mTraeRecordListener = paramWeakReference;
  }
  
  public static boolean traeStartPlay(Context paramContext)
  {
    AppMethodBeat.i(66564);
    if ((!TXCAudioBasePlayController.nativeIsTracksEmpty()) || (TXCLiveBGMPlayer.getInstance().isPlaying()))
    {
      InitTraeEngineLibrary(paramContext);
      nativeTraeStartPlay(paramContext);
      AppMethodBeat.o(66564);
      return true;
    }
    AppMethodBeat.o(66564);
    return false;
  }
  
  public static boolean traeStopPlay()
  {
    AppMethodBeat.i(66565);
    if ((TXCAudioBasePlayController.nativeIsTracksEmpty()) && (!TXCLiveBGMPlayer.getInstance().isPlaying()))
    {
      nativeTraeStopPlay();
      AppMethodBeat.o(66565);
      return true;
    }
    AppMethodBeat.o(66565);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCTraeJNI
 * JD-Core Version:    0.7.0.1
 */