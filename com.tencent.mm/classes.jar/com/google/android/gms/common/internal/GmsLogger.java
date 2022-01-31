package com.google.android.gms.common.internal;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GmsLogger
{
  public static final int MAX_PII_TAG_LENGTH = 15;
  public static final int MAX_TAG_LENGTH = 23;
  private static final String zzub = null;
  private final String zzuc;
  private final String zzud;
  
  public GmsLogger(String paramString)
  {
    this(paramString, null);
  }
  
  public GmsLogger(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89642);
    Preconditions.checkNotNull(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      this.zzuc = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        break;
      }
      this.zzud = null;
      AppMethodBeat.o(89642);
      return;
    }
    this.zzud = paramString2;
    AppMethodBeat.o(89642);
  }
  
  public static boolean isBuildPiiEnabled()
  {
    return false;
  }
  
  private final String zza(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89665);
    paramString = String.format(paramString, paramVarArgs);
    if (this.zzud == null)
    {
      AppMethodBeat.o(89665);
      return paramString;
    }
    paramString = this.zzud.concat(paramString);
    AppMethodBeat.o(89665);
    return paramString;
  }
  
  private final String zzl(String paramString)
  {
    AppMethodBeat.i(89664);
    if (this.zzud == null)
    {
      AppMethodBeat.o(89664);
      return paramString;
    }
    paramString = this.zzud.concat(paramString);
    AppMethodBeat.o(89664);
    return paramString;
  }
  
  public final boolean canLog(int paramInt)
  {
    AppMethodBeat.i(89644);
    boolean bool = Log.isLoggable(this.zzuc, paramInt);
    AppMethodBeat.o(89644);
    return bool;
  }
  
  public final boolean canLogPii()
  {
    return false;
  }
  
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89645);
    if (canLog(3)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89645);
  }
  
  public final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89646);
    if (canLog(3)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89646);
  }
  
  public final void dfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(89647);
    if (canLog(3)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(89647);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89657);
    if (canLog(6)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89657);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89658);
    if (canLog(6)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89658);
  }
  
  public final void efmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(89659);
    if (canLog(6)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(89659);
  }
  
  public final String getTag()
  {
    return this.zzuc;
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89651);
    if (canLog(4)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89651);
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89652);
    if (canLog(4)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89652);
  }
  
  public final void ifmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(89653);
    if (canLog(4)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(89653);
  }
  
  public final void pii(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89661);
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      String str = String.valueOf(" PII_LOG");
      if (str.length() == 0) {
        break label48;
      }
      paramString1.concat(str);
    }
    for (;;)
    {
      zzl(paramString2);
      AppMethodBeat.o(89661);
      return;
      label48:
      new String(paramString1);
    }
  }
  
  public final void pii(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89662);
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      paramThrowable = String.valueOf(" PII_LOG");
      if (paramThrowable.length() == 0) {
        break label48;
      }
      paramString1.concat(paramThrowable);
    }
    for (;;)
    {
      zzl(paramString2);
      AppMethodBeat.o(89662);
      return;
      label48:
      new String(paramString1);
    }
  }
  
  public final void piifmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(89663);
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      String str = String.valueOf(" PII_LOG");
      if (str.length() == 0) {
        break label52;
      }
      paramString1.concat(str);
    }
    for (;;)
    {
      zza(paramString2, paramVarArgs);
      AppMethodBeat.o(89663);
      return;
      label52:
      new String(paramString1);
    }
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89648);
    if (canLog(2)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89648);
  }
  
  public final void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89649);
    if (canLog(2)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89649);
  }
  
  public final void vfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(89650);
    if (canLog(2)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(89650);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89654);
    if (canLog(5)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89654);
  }
  
  public final void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89655);
    if (canLog(5)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(89655);
  }
  
  public final void wfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(89656);
    if (canLog(5)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(89656);
  }
  
  public final GmsLogger withMessagePrefix(String paramString)
  {
    AppMethodBeat.i(89643);
    paramString = new GmsLogger(this.zzuc, paramString);
    AppMethodBeat.o(89643);
    return paramString;
  }
  
  public final void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(89660);
    if (canLog(7))
    {
      zzl(paramString2);
      Log.wtf(paramString1, zzl(paramString2), paramThrowable);
    }
    AppMethodBeat.o(89660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsLogger
 * JD-Core Version:    0.7.0.1
 */