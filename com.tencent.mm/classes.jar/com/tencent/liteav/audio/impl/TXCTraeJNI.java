package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCTraeJNI
{
  private static Context mContext;
  private static WeakReference<e> mTraeRecordListener;
  
  static
  {
    com.tencent.liteav.basic.util.a.d();
    nativeCacheClassForNative();
  }
  
  public static void InitTraeEngineLibrary(Context paramContext)
  {
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioJNI", "nativeInitTraeEngine failed, context is null!");
      return;
    }
    try
    {
      Object localObject = paramContext.getApplicationInfo();
      paramContext = ((ApplicationInfo)localObject).nativeLibraryDir;
      String str = ((ApplicationInfo)localObject).dataDir + "/lib";
      localObject = "/data/data/" + ((ApplicationInfo)localObject).packageName + "/lib";
      nativeAppendLibraryPath("add_libpath:" + paramContext);
      nativeAppendLibraryPath("add_libpath:" + str);
      nativeAppendLibraryPath("add_libpath:" + (String)localObject);
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  public static void SetAudioMode(int paramInt)
  {
    com.tencent.liteav.audio.a.a(mContext, paramInt);
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext)
  {
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioJNI", "nativeCheckTraeEngine failed, context is null!");
      return false;
    }
    paramContext = paramContext.getApplicationInfo();
    String str2 = paramContext.nativeLibraryDir;
    String str3 = paramContext.dataDir + "/lib";
    String str4 = "/data/data/" + paramContext.packageName + "/lib";
    String str1 = com.tencent.liteav.basic.util.a.e();
    paramContext = str1;
    if (str1 == null) {
      paramContext = "";
    }
    if (new File(str2 + "/libtraeimp-rtmp-armeabi-v7a.so").exists()) {
      return true;
    }
    if (new File(str3 + "/libtraeimp-rtmp-armeabi-v7a.so").exists()) {
      return true;
    }
    if (new File(str4 + "/libtraeimp-rtmp-armeabi-v7a.so").exists()) {
      return true;
    }
    if (new File(paramContext + "/libtraeimp-rtmp-armeabi-v7a.so").exists()) {
      return true;
    }
    if (new File(str2 + "/libtraeimp-rtmp-armeabi.so").exists()) {
      return true;
    }
    if (new File(str3 + "/libtraeimp-rtmp-armeabi.so").exists()) {
      return true;
    }
    if (new File(str4 + "/libtraeimp-rtmp-armeabi.so").exists()) {
      return true;
    }
    return new File(paramContext + "/libtraeimp-rtmp-armeabi.so").exists();
  }
  
  public static native void nativeSetAudioMode(int paramInt);
  
  public static native void nativeSetTraeConfig(String paramString);
  
  public static native boolean nativeTraeIsPlaying();
  
  public static native boolean nativeTraeIsRecording();
  
  public static native void nativeTraeSetChangerType(int paramInt1, int paramInt2);
  
  public static native void nativeTraeSetRecordMute(boolean paramBoolean);
  
  public static native void nativeTraeSetRecordReverb(int paramInt);
  
  public static native void nativeTraeSetVolume(float paramFloat);
  
  public static native void nativeTraeStartPlay(Context paramContext);
  
  public static native void nativeTraeStartRecord(Context paramContext, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeTraeStopPlay();
  
  public static native void nativeTraeStopRecord(boolean paramBoolean);
  
  public static void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).b(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public static void onRecordError(int paramInt, String paramString)
  {
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).a(paramInt, paramString);
    }
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).a(paramArrayOfByte, TXCTimeUtil.getTimeTick(), paramInt1, paramInt2, paramInt3);
    }
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((mTraeRecordListener != null) && (mTraeRecordListener.get() != null)) {
      ((e)mTraeRecordListener.get()).a(paramArrayOfByte, TXCTimeUtil.getTimeTick(), paramInt1, paramInt2, paramInt3, false);
    }
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static void setTraeRecordListener(WeakReference<e> paramWeakReference)
  {
    mTraeRecordListener = paramWeakReference;
  }
  
  public static boolean traeStartPlay(Context paramContext)
  {
    if ((!TXCAudioBasePlayController.nativeIsTracksEmpty()) || (TXCLiveBGMPlayer.getInstance().isPlaying()))
    {
      InitTraeEngineLibrary(paramContext);
      nativeTraeStartPlay(paramContext);
      return true;
    }
    return false;
  }
  
  public static boolean traeStopPlay()
  {
    if ((TXCAudioBasePlayController.nativeIsTracksEmpty()) && (!TXCLiveBGMPlayer.getInstance().isPlaying()))
    {
      nativeTraeStopPlay();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCTraeJNI
 * JD-Core Version:    0.7.0.1
 */