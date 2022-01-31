package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.g;
import java.util.HashMap;

final class i$1
  implements c.a
{
  i$1(i parami) {}
  
  public final void a(String paramString, b paramb)
  {
    i locali = this.fyM;
    HashMap localHashMap = new HashMap();
    switch (com.tencent.mm.plugin.appbrand.page.g.1.fGc[paramb.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramString = "background";
    }
    for (;;)
    {
      localHashMap.put("status", paramString);
      new g().o(localHashMap).d(locali.Zy()).dispatch();
      return;
      paramString = "active";
      continue;
      paramString = "suspend";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.1
 * JD-Core Version:    0.7.0.1
 */