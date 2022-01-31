package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class h$1
  implements b.a
{
  h$1(h paramh, p paramp, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    switch (paramInt)
    {
    default: 
      this.gbW.C(this.dIS, this.gzt.h("cancel", null));
      return;
    case 1: 
      this.gbW.C(this.dIS, this.gzt.h("ok", null));
      return;
    }
    if (bk.bl(paramString))
    {
      this.gbW.C(this.dIS, this.gzt.h("fail", null));
      return;
    }
    this.gbW.C(this.dIS, this.gzt.h(String.format("fail %s", new Object[] { paramString }), null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.h.1
 * JD-Core Version:    0.7.0.1
 */