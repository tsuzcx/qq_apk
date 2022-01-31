package com.tencent.magicbrush.d;

import a.f.b.j;
import a.l;
import android.os.SystemClock;
import com.github.henryye.nativeiv.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Locale;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/utils/Util;", "", "()V", "TAG", "", "currentTicks", "", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "isNullOrNil", "", "str", "loadLibrary", "", "libName", "loader", "Ljava/lang/ClassLoader;", "nullAsNil", "qualityClose", "c", "Ljava/io/Closeable;", "quietlyClose", "closeable", "ticksToNow", "tick", "lib-magicbrush-nano_release"})
public final class e
{
  public static final e bLO;
  
  static
  {
    AppMethodBeat.i(151518);
    bLO = new e();
    AppMethodBeat.o(151518);
  }
  
  public static final long av(long paramLong)
  {
    AppMethodBeat.i(151514);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(151514);
    return l - paramLong;
  }
  
  public static final void b(Closeable paramCloseable)
  {
    AppMethodBeat.i(151517);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(151517);
      return;
    }
    catch (Exception paramCloseable)
    {
      AppMethodBeat.o(151517);
    }
    AppMethodBeat.o(151517);
    return;
  }
  
  public static final void cv(String paramString)
  {
    AppMethodBeat.i(151516);
    j.q(paramString, "libName");
    new StringBuilder("System.loadLibrary").append(paramString).append(' ').append(null);
    c.mv();
    System.loadLibrary(paramString);
    AppMethodBeat.o(151516);
  }
  
  public static final String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(151515);
    j.q(paramString, "format");
    j.q(paramVarArgs, "args");
    Locale localLocale = Locale.ENGLISH;
    j.p(localLocale, "Locale.ENGLISH");
    paramString = String.format(localLocale, paramString, Arrays.copyOf(new Object[] { paramVarArgs }, 1));
    j.p(paramString, "java.lang.String.format(locale, this, *args)");
    AppMethodBeat.o(151515);
    return paramString;
  }
  
  public static final boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(151512);
    if ((paramString == null) || (j.e("", paramString)))
    {
      AppMethodBeat.o(151512);
      return true;
    }
    AppMethodBeat.o(151512);
    return false;
  }
  
  public static final long yB()
  {
    AppMethodBeat.i(151513);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(151513);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.d.e
 * JD-Core Version:    0.7.0.1
 */