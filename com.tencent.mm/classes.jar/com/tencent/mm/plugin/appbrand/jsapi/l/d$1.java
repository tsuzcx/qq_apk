package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.p;
import java.util.Map;

final class d$1
  implements b.a
{
  d$1(d paramd, p paramp, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.gbW.C(this.dIS, this.gzo.h("ok", null));
      return;
    case 2: 
      this.gbW.C(this.dIS, this.gzo.h("fail:" + paramString, null));
      return;
    }
    this.gbW.C(this.dIS, this.gzo.h("cancel", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.d.1
 * JD-Core Version:    0.7.0.1
 */