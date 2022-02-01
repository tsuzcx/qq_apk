package com.tencent.liteav.basic.module;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TXCKeyPointReportProxy
{
  public static void a()
  {
    AppMethodBeat.i(14427);
    nativeSendCacheReport();
    AppMethodBeat.o(14427);
  }
  
  public static void a(int paramInt)
  {
    AppMethodBeat.i(14431);
    nativeTagKeyPointStart(paramInt);
    AppMethodBeat.o(14431);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14430);
    nativeSetCpu(paramInt1, paramInt2);
    AppMethodBeat.o(14430);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(238889);
    nativeSetLocalQuality(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(238889);
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(182421);
    if (paramContext == null)
    {
      AppMethodBeat.o(182421);
      return;
    }
    paramContext = paramContext.getApplicationContext().getExternalFilesDir(null);
    if (paramContext == null)
    {
      AppMethodBeat.o(182421);
      return;
    }
    paramContext = paramContext.getAbsolutePath() + "/liteav/ssoreport.txt";
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      try
      {
        if (!localFile.mkdirs())
        {
          TXCLog.e("TXCKeyPointReportProxy", "can not create sso file path");
          AppMethodBeat.o(182421);
          return;
        }
      }
      catch (Exception localException)
      {
        TXCLog.e("TXCKeyPointReportProxy", "create sso file exception:" + localException.toString());
      }
    }
    nativeInit(paramContext);
    AppMethodBeat.o(182421);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(238878);
    nativeSetDeviceInfo(parama.a, parama.b, parama.c, parama.d, parama.e, parama.f, parama.g, parama.h);
    AppMethodBeat.o(238878);
  }
  
  public static void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(14433);
    nativeTagKeyPointVideo(paramString, paramInt);
    AppMethodBeat.o(14433);
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(238887);
    nativesetRemoteQuality(paramString, paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(238887);
  }
  
  public static void b(int paramInt)
  {
    AppMethodBeat.i(238894);
    nativeSetErrorCode(paramInt);
    AppMethodBeat.o(238894);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14432);
    nativeTagKeyPointEnd(paramInt1, paramInt2);
    AppMethodBeat.o(14432);
  }
  
  public static void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(238885);
    nativeTagKeyPointAudio(paramString, paramInt);
    AppMethodBeat.o(238885);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238891);
    nativeSetBasicInfo(paramInt1, paramInt2);
    AppMethodBeat.o(238891);
  }
  
  private static native void nativeInit(String paramString);
  
  private static native void nativeSendCacheReport();
  
  private static native void nativeSetBasicInfo(int paramInt1, int paramInt2);
  
  private static native void nativeSetCpu(int paramInt1, int paramInt2);
  
  private static native void nativeSetDeviceInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native void nativeSetErrorCode(int paramInt);
  
  private static native void nativeSetLocalQuality(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeTagKeyPointAudio(String paramString, int paramInt);
  
  private static native void nativeTagKeyPointEnd(int paramInt1, int paramInt2);
  
  private static native void nativeTagKeyPointStart(int paramInt);
  
  private static native void nativeTagKeyPointVideo(String paramString, int paramInt);
  
  private static native void nativesetRemoteQuality(String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public static class a
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCKeyPointReportProxy
 * JD-Core Version:    0.7.0.1
 */