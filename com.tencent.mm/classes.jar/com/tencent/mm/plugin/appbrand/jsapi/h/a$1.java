package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.d;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements a.b
{
  a$1(a parama, f paramf) {}
  
  public final void a(a.d paramd)
  {
    y.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s", new Object[] { paramd.toString() });
    switch (a.3.gxl[paramd.ordinal()])
    {
    default: 
      return;
    case 1: 
      a.a.a(this.gfy, this.gxk.gep, "success", this.gxk.gxj);
      return;
    case 2: 
      a.a.a(this.gfy, this.gxk.gep, "fail", this.gxk.gxj);
      return;
    }
    y.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
    a.a.a(this.gfy, this.gxk.gep, "fail", this.gxk.gxj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.a.1
 * JD-Core Version:    0.7.0.1
 */