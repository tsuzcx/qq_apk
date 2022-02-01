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
    final String lMi;
    
    a(String paramString1, String paramString2)
    {
      super();
      this.lMi = paramString2;
    }
    
    static final class a
    {
      String errorMessage;
      String lMi;
      
      final x.a brQ()
      {
        AppMethodBeat.i(47167);
        x.a locala = new x.a(this.errorMessage, this.lMi);
        AppMethodBeat.o(47167);
        return locala;
      }
      
      final a p(String paramString, Object... paramVarArgs)
      {
        AppMethodBeat.i(47165);
        this.lMi = String.format(Locale.US, paramString, paramVarArgs);
        AppMethodBeat.o(47165);
        return this;
      }
      
      final a q(String paramString, Object... paramVarArgs)
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
    public abstract void gZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x
 * JD-Core Version:    0.7.0.1
 */