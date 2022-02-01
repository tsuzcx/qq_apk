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
    AppMethodBeat.i(4664);
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
      AppMethodBeat.o(4664);
      return;
    }
    this.zzud = paramString2;
    AppMethodBeat.o(4664);
  }
  
  public static boolean isBuildPiiEnabled()
  {
    return false;
  }
  
  private final String zza(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4687);
    paramString = String.format(paramString, paramVarArgs);
    if (this.zzud == null)
    {
      AppMethodBeat.o(4687);
      return paramString;
    }
    paramString = this.zzud.concat(paramString);
    AppMethodBeat.o(4687);
    return paramString;
  }
  
  private final String zzl(String paramString)
  {
    AppMethodBeat.i(4686);
    if (this.zzud == null)
    {
      AppMethodBeat.o(4686);
      return paramString;
    }
    paramString = this.zzud.concat(paramString);
    AppMethodBeat.o(4686);
    return paramString;
  }
  
  public final boolean canLog(int paramInt)
  {
    AppMethodBeat.i(4666);
    boolean bool = Log.isLoggable(this.zzuc, paramInt);
    AppMethodBeat.o(4666);
    return bool;
  }
  
  public final boolean canLogPii()
  {
    return false;
  }
  
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4667);
    if (canLog(3)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4667);
  }
  
  public final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4668);
    if (canLog(3)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4668);
  }
  
  public final void dfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(4669);
    if (canLog(3)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(4669);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4679);
    if (canLog(6)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4679);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4680);
    if (canLog(6)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4680);
  }
  
  public final void efmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(4681);
    if (canLog(6)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(4681);
  }
  
  public final String getTag()
  {
    return this.zzuc;
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4673);
    if (canLog(4)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4673);
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4674);
    if (canLog(4)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4674);
  }
  
  public final void ifmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(4675);
    if (canLog(4)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(4675);
  }
  
  public final void pii(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4683);
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      String str = String.valueOf(" PII_LOG");
      if (str.length() == 0) {
        break label50;
      }
      paramString1.concat(str);
    }
    for (;;)
    {
      zzl(paramString2);
      AppMethodBeat.o(4683);
      return;
      label50:
      new String(paramString1);
    }
  }
  
  public final void pii(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4684);
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      paramThrowable = String.valueOf(" PII_LOG");
      if (paramThrowable.length() == 0) {
        break label50;
      }
      paramString1.concat(paramThrowable);
    }
    for (;;)
    {
      zzl(paramString2);
      AppMethodBeat.o(4684);
      return;
      label50:
      new String(paramString1);
    }
  }
  
  public final void piifmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(4685);
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      String str = String.valueOf(" PII_LOG");
      if (str.length() == 0) {
        break label54;
      }
      paramString1.concat(str);
    }
    for (;;)
    {
      zza(paramString2, paramVarArgs);
      AppMethodBeat.o(4685);
      return;
      label54:
      new String(paramString1);
    }
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4670);
    if (canLog(2)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4670);
  }
  
  public final void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4671);
    if (canLog(2)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4671);
  }
  
  public final void vfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(4672);
    if (canLog(2)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(4672);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4676);
    if (canLog(5)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4676);
  }
  
  public final void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4677);
    if (canLog(5)) {
      zzl(paramString2);
    }
    AppMethodBeat.o(4677);
  }
  
  public final void wfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(4678);
    if (canLog(5)) {
      zza(paramString2, paramVarArgs);
    }
    AppMethodBeat.o(4678);
  }
  
  public final GmsLogger withMessagePrefix(String paramString)
  {
    AppMethodBeat.i(4665);
    paramString = new GmsLogger(this.zzuc, paramString);
    AppMethodBeat.o(4665);
    return paramString;
  }
  
  public final void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(4682);
    if (canLog(7))
    {
      zzl(paramString2);
      Log.wtf(paramString1, zzl(paramString2), paramThrowable);
    }
    AppMethodBeat.o(4682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsLogger
 * JD-Core Version:    0.7.0.1
 */