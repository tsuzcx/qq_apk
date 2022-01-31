package com.tencent.mm.plugin.appbrand.t;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.MalformedURLException;
import java.net.URL;

public final class n
{
  public static void a(i parami, String paramString, n.a parama)
  {
    AppMethodBeat.i(87428);
    if (bo.isNullOrNil(paramString))
    {
      if (parama != null) {
        parama.bU("isNullOrNil script");
      }
      AppMethodBeat.o(87428);
      return;
    }
    parami.evaluateJavascript(paramString + String.format("\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) }), new n.1(parama));
    AppMethodBeat.o(87428);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(i parami, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, n.a parama)
  {
    AppMethodBeat.i(87429);
    ab.i("MicroMsg.JsValidationInjector", "hy: injecting file %s", new Object[] { paramString1 });
    if (bo.isNullOrNil(paramString4))
    {
      ab.e("MicroMsg.JsValidationInjector", "hy: empty script!");
      if (parama != null) {
        parama.bU("isNullOrNil script");
      }
      AppMethodBeat.o(87429);
      return;
    }
    paramString4 = paramString4 + String.format("\n;(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    String str = paramString4 + bo.nullAsNil(paramString5);
    paramString5 = null;
    paramString4 = paramString5;
    if (paramString1 != null) {
      paramString4 = paramString5;
    }
    try
    {
      if (paramString1.length() > 0) {
        paramString4 = new URL(paramString1);
      }
      if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3)))
      {
        parami.a(paramString4, str, new n.2(paramString1, parama));
        AppMethodBeat.o(87429);
        return;
      }
    }
    catch (MalformedURLException parami)
    {
      ab.e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
      parama.bU("MalformedURLException");
      AppMethodBeat.o(87429);
      return;
    }
    parami.a(paramString4, paramString2, paramString3, str, new n.3(paramString1, parama));
    AppMethodBeat.o(87429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.n
 * JD-Core Version:    0.7.0.1
 */