package com.tencent.mm.audio.mix.h;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  private static final String SYS_INFO;
  private static b.a cia;
  private static b.a cib;
  private static int level;
  
  static
  {
    AppMethodBeat.i(137218);
    level = 6;
    Object localObject = new b.a()
    {
      private Handler handler;
    };
    cia = (b.a)localObject;
    cib = (b.a)localObject;
    localObject = new StringBuilder();
    try
    {
      ((StringBuilder)localObject).append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
      ((StringBuilder)localObject).append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
      ((StringBuilder)localObject).append("] BOARD:[" + Build.BOARD);
      ((StringBuilder)localObject).append("] DEVICE:[" + Build.DEVICE);
      ((StringBuilder)localObject).append("] DISPLAY:[" + Build.DISPLAY);
      ((StringBuilder)localObject).append("] FINGERPRINT:[" + Build.FINGERPRINT);
      ((StringBuilder)localObject).append("] HOST:[" + Build.HOST);
      ((StringBuilder)localObject).append("] MANUFACTURER:[" + Build.MANUFACTURER);
      ((StringBuilder)localObject).append("] MODEL:[" + Build.MODEL);
      ((StringBuilder)localObject).append("] PRODUCT:[" + Build.PRODUCT);
      ((StringBuilder)localObject).append("] TAGS:[" + Build.TAGS);
      ((StringBuilder)localObject).append("] TYPE:[" + Build.TYPE);
      ((StringBuilder)localObject).append("] USER:[" + Build.USER + "]");
      SYS_INFO = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137218);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("mix.Log", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137214);
    ab.d(paramString1, paramString2, null);
    AppMethodBeat.o(137214);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137212);
    ab.e(paramString1, paramString2, null);
    AppMethodBeat.o(137212);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(137215);
    ab.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(137215);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137213);
    ab.i(paramString1, paramString2, null);
    AppMethodBeat.o(137213);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(137216);
    ab.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(137216);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(137217);
    ab.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(137217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.b
 * JD-Core Version:    0.7.0.1
 */