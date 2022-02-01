package com.tencent.mm.audio.mix.h;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private static final String SYS_INFO;
  private static b.a fqN;
  private static b.a fqO;
  private static int level;
  
  static
  {
    AppMethodBeat.i(136967);
    level = 6;
    Object localObject = new b.1();
    fqN = (b.a)localObject;
    fqO = (b.a)localObject;
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
      AppMethodBeat.o(136967);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("mix.Log", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136963);
    Log.d(paramString1, paramString2, null);
    AppMethodBeat.o(136963);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136961);
    Log.e(paramString1, paramString2, null);
    AppMethodBeat.o(136961);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(136964);
    Log.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(136964);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136962);
    Log.i(paramString1, paramString2, null);
    AppMethodBeat.o(136962);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(136965);
    Log.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(136965);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(136966);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(136966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.b
 * JD-Core Version:    0.7.0.1
 */