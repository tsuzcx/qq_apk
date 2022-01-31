package com.tencent.luggage.g;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static final String SYS_INFO;
  private static d.a bFw;
  private static d.a bFx;
  private static int level;
  
  static
  {
    AppMethodBeat.i(90895);
    level = 6;
    Object localObject = new d.1();
    bFw = (d.a)localObject;
    bFx = (d.a)localObject;
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
      AppMethodBeat.o(90895);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        printErrStackTrace("Luggage.Log", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static void a(d.a parama)
  {
    bFx = parama;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90892);
    if ((bFx != null) && (bFx.getLogLevel() <= 1))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      bFx.logI(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
    AppMethodBeat.o(90892);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90893);
    if ((bFx != null) && (bFx.getLogLevel() <= 2))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      bFx.logI(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
    AppMethodBeat.o(90893);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90885);
    d(paramString1, paramString2, null);
    AppMethodBeat.o(90885);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90890);
    if ((bFx != null) && (bFx.getLogLevel() <= 1)) {
      if (paramVarArgs != null) {
        break label77;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      bFx.logD(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(90890);
      return;
      label77:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90882);
    e(paramString1, paramString2, null);
    AppMethodBeat.o(90882);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90887);
    if ((bFx != null) && (bFx.getLogLevel() <= 4)) {
      if (paramVarArgs != null) {
        break label77;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      bFx.logE(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(90887);
      return;
      label77:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static int getLogLevel()
  {
    AppMethodBeat.i(141786);
    if (bFx != null)
    {
      int i = bFx.getLogLevel();
      AppMethodBeat.o(141786);
      return i;
    }
    AppMethodBeat.o(141786);
    return 6;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90884);
    i(paramString1, paramString2, null);
    AppMethodBeat.o(90884);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90889);
    if ((bFx != null) && (bFx.getLogLevel() <= 2)) {
      if (paramVarArgs != null) {
        break label77;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      bFx.logI(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(90889);
      return;
      label77:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90894);
    if ((bFx != null) && (bFx.getLogLevel() <= 4))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      bFx.logE(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
    }
    AppMethodBeat.o(90894);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90886);
    v(paramString1, paramString2, null);
    AppMethodBeat.o(90886);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90891);
    if ((bFx != null) && (bFx.getLogLevel() <= 0)) {
      if (paramVarArgs != null) {
        break label76;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      bFx.logV(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(90891);
      return;
      label76:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90883);
    w(paramString1, paramString2, null);
    AppMethodBeat.o(90883);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(90888);
    if ((bFx != null) && (bFx.getLogLevel() <= 3)) {
      if (paramVarArgs != null) {
        break label77;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      bFx.logW(paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
      AppMethodBeat.o(90888);
      return;
      label77:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.g.d
 * JD-Core Version:    0.7.0.1
 */