package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.Locale;
import java.util.concurrent.Callable;

public abstract interface n
  extends Callable<WxaPkgWrappingInfo>
{
  public abstract void onDownloadProgress(int paramInt);
  
  static final class a$a
  {
    String errorMessage;
    String ili;
    
    final n.a aGT()
    {
      AppMethodBeat.i(131816);
      n.a locala = new n.a(this.errorMessage, this.ili);
      AppMethodBeat.o(131816);
      return locala;
    }
    
    final a k(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(131814);
      this.ili = String.format(Locale.US, paramString, paramVarArgs);
      AppMethodBeat.o(131814);
      return this;
    }
    
    final a l(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(131815);
      this.errorMessage = String.format(Locale.US, paramString, paramVarArgs);
      AppMethodBeat.o(131815);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.n
 * JD-Core Version:    0.7.0.1
 */