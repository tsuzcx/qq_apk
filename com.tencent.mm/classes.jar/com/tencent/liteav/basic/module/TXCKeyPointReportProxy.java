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
    paramContext = paramContext.getAbsolutePath() + "/txrtmp/ssoreport.txt";
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
  
  public static void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(14433);
    nativeTagKeyPoint(paramString, paramInt);
    AppMethodBeat.o(14433);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14434);
    nativeSetQuality(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(14434);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(14429);
    nativeSetDeviceInfo(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(14429);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14432);
    nativeTagKeyPointEnd(paramInt1, paramInt2);
    AppMethodBeat.o(14432);
  }
  
  private static native void nativeInit(String paramString);
  
  private static native void nativeSendCacheReport();
  
  private static native void nativeSetCpu(int paramInt1, int paramInt2);
  
  private static native void nativeSetDeviceInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  private static native void nativeSetQuality(String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeTagKeyPoint(String paramString, int paramInt);
  
  private static native void nativeTagKeyPointEnd(int paramInt1, int paramInt2);
  
  private static native void nativeTagKeyPointStart(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCKeyPointReportProxy
 * JD-Core Version:    0.7.0.1
 */