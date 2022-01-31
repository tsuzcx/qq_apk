package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class af$1
  implements MMActivity.a
{
  af$1(af paramaf, r paramr, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130408);
    ab.d("MicroMsg.JsApiChooseInvoice", "request choose invoice, resultCode = ".concat(String.valueOf(paramInt2)));
    HashMap localHashMap = new HashMap();
    if (paramInt2 == -1)
    {
      if (paramIntent != null) {
        localHashMap.put("invoiceInfo", bo.bf(paramIntent.getStringExtra("choose_invoice_info"), ""));
      }
      this.htA.h(this.bAX, this.hxA.j("ok", localHashMap));
      ab.i("MicroMsg.JsApiChooseInvoice", "callback ok values = ".concat(String.valueOf(localHashMap)));
      AppMethodBeat.o(130408);
      return;
    }
    if (paramInt2 == 0)
    {
      this.htA.h(this.bAX, this.hxA.j("cancel", null));
      ab.i("MicroMsg.JsApiChooseInvoice", "callback cancel");
      AppMethodBeat.o(130408);
      return;
    }
    this.htA.h(this.bAX, this.hxA.j("fail", null));
    ab.i("MicroMsg.JsApiChooseInvoice", "callback fail");
    AppMethodBeat.o(130408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.1
 * JD-Core Version:    0.7.0.1
 */