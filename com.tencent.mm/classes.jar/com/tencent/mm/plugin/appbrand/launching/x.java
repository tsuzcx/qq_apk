package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.Locale;
import java.util.concurrent.Callable;

public abstract interface x
  extends Callable<WxaPkgWrappingInfo>
{
  public abstract void onDownloadProgress(int paramInt);
  
  public static final class a
    extends Error
  {
    final String kJe;
    
    a(String paramString1, String paramString2)
    {
      super();
      this.kJe = paramString2;
    }
    
    static final class a
    {
      String errorMessage;
      String kJe;
      
      final x.a bgA()
      {
        AppMethodBeat.i(47167);
        x.a locala = new x.a(this.errorMessage, this.kJe);
        AppMethodBeat.o(47167);
        return locala;
      }
      
      final a n(String paramString, Object... paramVarArgs)
      {
        AppMethodBeat.i(47165);
        this.kJe = String.format(Locale.US, paramString, paramVarArgs);
        AppMethodBeat.o(47165);
        return this;
      }
      
      final a o(String paramString, Object... paramVarArgs)
      {
        AppMethodBeat.i(47166);
        this.errorMessage = String.format(Locale.US, paramString, paramVarArgs);
        AppMethodBeat.o(47166);
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void gv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x
 * JD-Core Version:    0.7.0.1
 */