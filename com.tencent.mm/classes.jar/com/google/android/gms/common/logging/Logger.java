package com.google.android.gms.common.logging;

import android.annotation.SuppressLint;
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
    AppMethodBeat.i(89880);
    this.zzud = paramString2;
    this.mTag = paramString1;
    this.zzvd = new GmsLogger(paramString1);
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(this.mTag, i))) {
      i += 1;
    }
    this.zzve = i;
    AppMethodBeat.o(89880);
  }
  
  public Logger(String paramString, String... paramVarArgs) {}
  
  public void d(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(89886);
    if (isLoggable(3)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(89886);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89885);
    if (isLoggable(3)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(89885);
  }
  
  public void e(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(89892);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(89892);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89891);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(89891);
  }
  
  public String elidePii(Object paramObject)
  {
    AppMethodBeat.i(89882);
    boolean bool = this.zzvd.canLogPii();
    if (paramObject == null)
    {
      AppMethodBeat.o(89882);
      return "<NULL>";
    }
    paramObject = paramObject.toString().trim();
    if (paramObject.isEmpty())
    {
      AppMethodBeat.o(89882);
      return "<EMPTY>";
    }
    if (bool)
    {
      AppMethodBeat.o(89882);
      return paramObject;
    }
    paramObject = String.format("<ELLIDED:%s>", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    AppMethodBeat.o(89882);
    return paramObject;
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89896);
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    paramString = this.zzud.concat(str);
    AppMethodBeat.o(89896);
    return paramString;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public void i(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(89888);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(89888);
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89887);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(89887);
  }
  
  public boolean isLoggable(int paramInt)
  {
    return this.zzve <= paramInt;
  }
  
  public boolean isPiiLoggable()
  {
    AppMethodBeat.i(89881);
    boolean bool = this.zzvd.canLogPii();
    AppMethodBeat.o(89881);
    return bool;
  }
  
  public void v(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(89884);
    if (isLoggable(2)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(89884);
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89883);
    if (isLoggable(2)) {
      format(paramString, paramVarArgs);
    }
    AppMethodBeat.o(89883);
  }
  
  public void w(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(89890);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(89890);
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89889);
    format(paramString, paramVarArgs);
    AppMethodBeat.o(89889);
  }
  
  public void w(Throwable paramThrowable) {}
  
  public void wtf(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    AppMethodBeat.i(89894);
    Log.wtf(this.mTag, format(paramString, paramVarArgs), paramThrowable);
    AppMethodBeat.o(89894);
  }
  
  @SuppressLint({"WtfWithoutException"})
  public void wtf(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89893);
    Log.wtf(this.mTag, format(paramString, paramVarArgs));
    AppMethodBeat.o(89893);
  }
  
  public void wtf(Throwable paramThrowable)
  {
    AppMethodBeat.i(89895);
    Log.wtf(this.mTag, paramThrowable);
    AppMethodBeat.o(89895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.logging.Logger
 * JD-Core Version:    0.7.0.1
 */