package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.m.t;

public class i<SERVICE extends d>
  extends b<SERVICE>
{
  protected i(SERVICE paramSERVICE, t paramt)
  {
    super(paramSERVICE, paramt);
  }
  
  protected final String MK()
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
    for (paramSERVICE = com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/native/WASubContext.js");; paramSERVICE = paramSERVICE.bqZ().UM("WASubContext.js"))
    {
      if (!TextUtils.isEmpty(paramSERVICE)) {
        break label77;
      }
      paramSERVICE = new aq("WASubContext.js");
      AppMethodBeat.o(146851);
      throw paramSERVICE;
      bool = paramSERVICE.getRuntime().OU().ldK;
      break;
    }
    label77:
    AppMethodBeat.o(146851);
    return paramSERVICE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.i
 * JD-Core Version:    0.7.0.1
 */