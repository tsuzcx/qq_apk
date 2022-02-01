package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsruntime.t;

public class g<SERVICE extends c>
  extends a<SERVICE>
{
  protected g(SERVICE paramSERVICE, t paramt)
  {
    super(paramSERVICE, paramt);
  }
  
  protected final String BM()
  {
    return "WASubContext.js";
  }
  
  protected String c(SERVICE paramSERVICE)
  {
    AppMethodBeat.i(146851);
    boolean bool;
    if (paramSERVICE.getRuntime() == null)
    {
      bool = false;
      if (!bool) {
        break label62;
      }
    }
    label62:
    for (paramSERVICE = com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/native/WASubContext.js");; paramSERVICE = paramSERVICE.aSt().HL("WASubContext.js"))
    {
      if (!TextUtils.isEmpty(paramSERVICE)) {
        break label77;
      }
      paramSERVICE = new ao("WASubContext.js");
      AppMethodBeat.o(146851);
      throw paramSERVICE;
      bool = paramSERVICE.getRuntime().DJ().jDv;
      break;
    }
    label77:
    AppMethodBeat.o(146851);
    return paramSERVICE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.g
 * JD-Core Version:    0.7.0.1
 */