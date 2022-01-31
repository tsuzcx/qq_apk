package com.tencent.mm.plugin.appbrand.j.b;

import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;

public final class b
  implements f
{
  public final e a(c paramc)
  {
    if ((paramc instanceof e)) {
      return (e)paramc;
    }
    if ((paramc instanceof o)) {
      return ((o)paramc).E(q.class);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.b
 * JD-Core Version:    0.7.0.1
 */