package com.tencent.luggage.sdk.b.a.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.n.t;

public class i<SERVICE extends d>
  extends b<SERVICE>
{
  protected i(SERVICE paramSERVICE, t paramt)
  {
    super(paramSERVICE, paramt);
  }
  
  protected final String apK()
  {
    return "WASubContext.js";
  }
  
  protected String c(SERVICE paramSERVICE)
  {
    AppMethodBeat.i(146851);
    paramSERVICE = paramSERVICE.cbl().UW("WASubContext.js");
    if (TextUtils.isEmpty(paramSERVICE))
    {
      paramSERVICE = new as("WASubContext.js");
      AppMethodBeat.o(146851);
      throw paramSERVICE;
    }
    AppMethodBeat.o(146851);
    return paramSERVICE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.i
 * JD-Core Version:    0.7.0.1
 */