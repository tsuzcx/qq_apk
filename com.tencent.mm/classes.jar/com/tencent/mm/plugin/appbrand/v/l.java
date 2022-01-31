package com.tencent.mm.plugin.appbrand.v;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class l
{
  public static String a(o paramo, l.a parama)
  {
    String str = "";
    if (parama == l.a.hlv) {
      str = paramo.aay();
    }
    while (parama != l.a.hlw) {
      return str;
    }
    return paramo.aaz();
  }
  
  public static void a(i parami, f paramf, String paramString1, String paramString2, l.a parama, k.a parama1)
  {
    a(parami, paramf, paramString1, "", "", paramString2, parama, parama1);
  }
  
  public static void a(i parami, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, l.a parama, k.a parama1)
  {
    if ((parami == null) || (parami.Zy() == null))
    {
      y.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      return;
    }
    String str = p.a(parami, paramString1, a(parami.Zy(), parama));
    if (!bk.bl(str)) {
      k.a(paramf, str, null);
    }
    a(parami.Zy(), paramf, paramString1, paramString2, paramString3, paramString4, parama, parama1);
  }
  
  public static void a(o paramo, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, l.a parama, k.a parama1)
  {
    if (paramo == null)
    {
      y.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      return;
    }
    parama = a(paramo, parama);
    paramo = paramo.qK(paramString1);
    k.a(paramf, parama + paramString1, paramString2, paramString3, paramString4, paramo, parama1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.l
 * JD-Core Version:    0.7.0.1
 */