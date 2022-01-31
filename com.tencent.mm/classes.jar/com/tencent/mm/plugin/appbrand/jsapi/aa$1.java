package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class aa$1
  implements MMActivity.a
{
  aa$1(aa paramaa, o paramo, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.JsApiChooseInvoice", "request choose invoice, resultCode = " + paramInt2);
    HashMap localHashMap = new HashMap();
    if (paramInt2 == -1)
    {
      if (paramIntent != null) {
        localHashMap.put("choose_invoice_info", bk.aM(paramIntent.getStringExtra("choose_invoice_info"), ""));
      }
      this.gfO.C(this.dIS, this.gfP.h("ok", localHashMap));
      y.i("MicroMsg.JsApiChooseInvoice", "callback ok values = " + localHashMap);
      return;
    }
    if (paramInt2 == 0)
    {
      this.gfO.C(this.dIS, this.gfP.h("cancel", null));
      y.i("MicroMsg.JsApiChooseInvoice", "callback cancel");
      return;
    }
    this.gfO.C(this.dIS, this.gfP.h("fail", null));
    y.i("MicroMsg.JsApiChooseInvoice", "callback fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.1
 * JD-Core Version:    0.7.0.1
 */