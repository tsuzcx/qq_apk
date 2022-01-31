package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.p;
import java.util.Map;

final class f$1
  implements b.a
{
  f$1(f paramf, p paramp, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    switch (paramInt)
    {
    default: 
      this.gbW.C(this.dIS, this.gzq.h("fail:" + paramString, null));
      return;
    }
    this.gbW.C(this.dIS, this.gzq.h("ok", paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.f.1
 * JD-Core Version:    0.7.0.1
 */