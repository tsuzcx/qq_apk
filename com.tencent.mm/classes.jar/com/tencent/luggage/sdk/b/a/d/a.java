package com.tencent.luggage.sdk.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.a.a.a;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.b.a;
import com.tencent.mm.appbrand.commonjni.a.c.b;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public final AppBrandCommonBindingJni esf;
  public final BufferURLManager esg;
  
  static
  {
    AppMethodBeat.i(220320);
    b.a(new b.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(220308);
        long l = Util.currentTicks();
        k.load(paramAnonymousString);
        Log.i("MicroMsg.AppBrandCommonBinding", "hy: test loading %s using %d ms", new Object[] { paramAnonymousString, Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(220308);
      }
    });
    c.c.a(new c.b()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(220314);
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(220314);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(220309);
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(220309);
      }
      
      public final void printStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(220316);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(220316);
      }
    });
    b.loadLibrary("wxa-runtime-binding");
    AppMethodBeat.o(220320);
  }
  
  public a(a.a parama)
  {
    AppMethodBeat.i(220317);
    this.esf = new AppBrandCommonBindingJni(parama);
    this.esg = new BufferURLManager();
    AppMethodBeat.o(220317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */