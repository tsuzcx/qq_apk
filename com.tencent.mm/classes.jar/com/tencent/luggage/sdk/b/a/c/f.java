package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.sdk.platformtools.bo;

public class f<SERVICE extends c>
  extends a<SERVICE>
{
  protected f(SERVICE paramSERVICE, q paramq)
  {
    super(paramSERVICE, paramq);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(140780);
    d.i("Luggage.Standalone.MPJSContextInterface", "reportBootstrapScriptEvaluateResult name[%s], source.length[%d], succeed[%b], cost[%d]", new Object[] { paramString1, Integer.valueOf(bo.nullAsNil(paramString2).length()), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong2 - paramLong1) });
    AppMethodBeat.o(140780);
  }
  
  protected String b(SERVICE paramSERVICE)
  {
    AppMethodBeat.i(140779);
    paramSERVICE = paramSERVICE.asY().yl("WASubContext.js");
    if (TextUtils.isEmpty(paramSERVICE))
    {
      paramSERVICE = new a.a("WASubContext.js");
      AppMethodBeat.o(140779);
      throw paramSERVICE;
    }
    AppMethodBeat.o(140779);
    return paramSERVICE;
  }
  
  protected final String vm()
  {
    return "WASubContext.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.f
 * JD-Core Version:    0.7.0.1
 */