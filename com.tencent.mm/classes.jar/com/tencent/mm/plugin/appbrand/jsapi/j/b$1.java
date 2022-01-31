package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements c.a
{
  b$1(b paramb) {}
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
  {
    if ((paramb == com.tencent.mm.plugin.appbrand.b.b.fFJ) && (b.a(this.gyP).equals(paramString)))
    {
      y.i(b.access$100(), "hy: appbrand change to background");
      j.iFl.a(new a() {}, j.a.iGq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b.1
 * JD-Core Version:    0.7.0.1
 */