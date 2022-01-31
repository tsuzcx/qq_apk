package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.i.l;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.MalformedURLException;
import java.net.URL;

public final class o
{
  private static String a(r paramr, o.a parama)
  {
    AppMethodBeat.i(133589);
    String str = "";
    if (parama == o.a.iXP) {
      str = paramr.wH();
    }
    for (;;)
    {
      AppMethodBeat.o(133589);
      return str;
      if (parama == o.a.iXQ) {
        str = paramr.wG();
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.i parami, com.tencent.mm.plugin.appbrand.i.i parami1, String paramString1, String paramString2, o.a parama, n.a parama1)
  {
    AppMethodBeat.i(140986);
    a(parami, parami1, paramString1, "", "", paramString2, parama, parama1);
    AppMethodBeat.o(140986);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.i parami, com.tencent.mm.plugin.appbrand.i.i parami1, String paramString1, String paramString2, String paramString3, String paramString4, o.a parama, n.a parama1)
  {
    AppMethodBeat.i(133588);
    if ((parami == null) || (parami.ws() == null))
    {
      ab.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(133588);
      return;
    }
    String str = ag.a(parami, paramString1, a(parami.ws(), parama));
    if (!bo.isNullOrNil(str)) {
      n.a(parami1, str, null);
    }
    a(parami.ws(), parami1, paramString1, paramString2, paramString3, paramString4, parama, parama1);
    AppMethodBeat.o(133588);
  }
  
  public static void a(r paramr, com.tencent.mm.plugin.appbrand.i.i parami, String paramString1, String paramString2, o.a parama, n.a parama1)
  {
    AppMethodBeat.i(133590);
    if (bo.isNullOrNil(paramString2))
    {
      parama1.bU("isNullOrNil script");
      AppMethodBeat.o(133590);
      return;
    }
    parami = (l)parami.v(l.class);
    if (parami == null)
    {
      AppMethodBeat.o(133590);
      return;
    }
    paramString2 = paramString2 + String.format(";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    try
    {
      paramr = new URL(a(paramr, parama) + paramString1);
      parami.a(paramString2, paramr.toString(), new o.1(parama1));
      AppMethodBeat.o(133590);
      return;
    }
    catch (MalformedURLException paramr)
    {
      AppMethodBeat.o(133590);
    }
  }
  
  public static void a(r paramr, com.tencent.mm.plugin.appbrand.i.i parami, String paramString1, String paramString2, String paramString3, String paramString4, o.a parama, n.a parama1)
  {
    AppMethodBeat.i(133586);
    if (paramr == null)
    {
      ab.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(133586);
      return;
    }
    parama = a(paramr, parama);
    paramr = paramr.ce(paramString1);
    n.a(parami, parama + paramString1, paramString2, paramString3, paramString4, paramr, parama1);
    AppMethodBeat.o(133586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.o
 * JD-Core Version:    0.7.0.1
 */