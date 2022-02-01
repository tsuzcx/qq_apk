package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class Logger
{
  private final String mTag;
  private final String zzud;
  private final GmsLogger zzvd;
  private final int zzve;
  
  private Logger(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4902);
    this.zzud = paramString2;
    this.mTag = paramString1;
    this.zzvd = new GmsLogger(paramString1);
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(this.mTag, i))) {
      i += 1;
    }
    this.zzve = i;
    AppMethodBeat.o(4902);
  }
  
  public Logger(String paramString, String... paramVarArgs) {}
  
  public void d(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(4908);
    if (isLoggable(3)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(4908);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4907);
    if (isLoggable(3)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(4907);
  }
  
  public void e(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(4914);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(4914);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4913);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(4913);
  }
  
  public String elidePii(Object paramObject)
  {
    AppMethodBeat.i(4904);
    boolean bool = this.zzvd.canLogPii();
    if (paramObject == null)
    {
      AppMethodBeat.o(4904);
      return "<NULL>";
    }
    paramObject = paramObject.toString().trim();
    if (paramObject.isEmpty())
    {
      AppMethodBeat.o(4904);
      return "<EMPTY>";
    }
    if (bool)
    {
      AppMethodBeat.o(4904);
      return paramObject;
    }
    paramObject = String.format("<ELLIDED:%s>", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    AppMethodBeat.o(4904);
    return paramObject;
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4918);
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    paramString = this.zzud.concat(str);
    AppMethodBeat.o(4918);
    return paramString;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public void i(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(4910);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(4910);
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4909);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(4909);
  }
  
  public boolean isLoggable(int paramInt)
  {
    return this.zzve <= paramInt;
  }
  
  public boolean isPiiLoggable()
  {
    AppMethodBeat.i(4903);
    boolean bool = this.zzvd.canLogPii();
    AppMethodBeat.o(4903);
    return bool;
  }
  
  public void v(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(4906);
    if (isLoggable(2)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(4906);
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4905);
    if (isLoggable(2)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(4905);
  }
  
  public void w(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(4912);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(4912);
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4911);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(4911);
  }
  
  public void w(Throwable paramThrowable) {}
  
  public void wtf(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(4916);
    Log.wtf(this.mTag, format(paramString, paramVarArgs), paramThrowable);
    AppMethodBeat.o(4916);
  }
  
  public void wtf(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4915);
    Log.wtf(this.mTag, format(paramString, paramVarArgs));
    AppMethodBeat.o(4915);
  }
  
  public void wtf(Throwable paramThrowable)
  {
    AppMethodBeat.i(4917);
    Log.wtf(this.mTag, paramThrowable);
    AppMethodBeat.o(4917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.logging.Logger
 * JD-Core Version:    0.7.0.1
 */