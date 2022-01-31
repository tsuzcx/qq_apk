package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.b;
import java.util.HashMap;

final class c$1
  implements AppBrandInputInvokeHandler.b
{
  c$1(c paramc, AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final void bW(int paramInt1, int paramInt2)
  {
    int i = this.grm.getInputId();
    q localq = c.ls(i);
    if ((localq == null) || (!localq.ahC)) {
      return;
    }
    c.a locala = new c.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(h.mx(paramInt2)));
    localHashMap.put("lineCount", Integer.valueOf(paramInt1));
    localHashMap.put("inputId", Integer.valueOf(i));
    locala.d(localq).o(localHashMap).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.c.1
 * JD-Core Version:    0.7.0.1
 */