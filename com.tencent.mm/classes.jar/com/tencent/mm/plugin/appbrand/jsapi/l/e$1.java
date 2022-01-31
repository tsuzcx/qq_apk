package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import java.util.Map;

final class e$1
  implements b.a
{
  e$1(e parame, f paramf, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.gfy.C(this.dIS, this.gzp.h("ok", null));
      return;
    case 2: 
      this.gfy.C(this.dIS, this.gzp.h("fail:" + paramString, null));
      return;
    }
    this.gfy.C(this.dIS, this.gzp.h("cancel", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.e.1
 * JD-Core Version:    0.7.0.1
 */