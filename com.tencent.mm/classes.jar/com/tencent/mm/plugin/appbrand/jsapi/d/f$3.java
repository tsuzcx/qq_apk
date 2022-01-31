package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class f$3
  implements com.tencent.mm.plugin.appbrand.widget.input.c.c
{
  f$3(f paramf, AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler, String paramString, q paramq) {}
  
  public final void aQ(String paramString, int paramInt)
  {
    int i = this.grm.getInputId();
    if (this.grm.getWidget() == null)
    {
      y.e("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", new Object[] { this.val$appId });
      return;
    }
    f.a locala = new f.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", com.tencent.mm.plugin.appbrand.v.c.wH(paramString));
    localHashMap.put("data", f.lr(i));
    localHashMap.put("cursor", Integer.valueOf(paramInt));
    localHashMap.put("inputId", Integer.valueOf(i));
    localHashMap.put("keyCode", Integer.valueOf(this.grm.getWidget().getLastKeyPressed()));
    locala.a(this.gkf.getRuntime().Zy(), this.gkf.hashCode()).o(localHashMap).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.f.3
 * JD-Core Version:    0.7.0.1
 */