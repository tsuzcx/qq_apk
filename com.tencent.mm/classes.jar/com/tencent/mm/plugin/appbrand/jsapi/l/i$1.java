package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.p;
import java.util.HashMap;
import java.util.Map;

final class i$1
  implements b.b
{
  i$1(i parami, p paramp, int paramInt) {}
  
  public final void f(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("token", paramString);
      this.gbW.C(this.dIS, this.gzu.h("ok", localHashMap));
      return;
    }
    this.gbW.C(this.dIS, this.gzu.h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.i.1
 * JD-Core Version:    0.7.0.1
 */