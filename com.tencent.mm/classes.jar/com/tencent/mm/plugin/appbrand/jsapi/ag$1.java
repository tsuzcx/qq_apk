package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class ag$1
  implements MMActivity.a
{
  ag$1(ag paramag, r paramr, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130410);
    if (paramInt1 != (this.hxB.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(130410);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      HashMap localHashMap = new HashMap();
      paramIntent = bo.bf(paramIntent.getStringExtra("choose_invoice_title_info"), "");
      ab.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : ".concat(String.valueOf(paramIntent)));
      localHashMap.put("invoiceTitleInfo", paramIntent);
      this.bAW.h(this.bAX, this.hxB.j("ok", localHashMap));
      AppMethodBeat.o(130410);
      return;
    }
    if (paramInt2 == 0)
    {
      this.bAW.h(this.bAX, this.hxB.j("cancel", null));
      AppMethodBeat.o(130410);
      return;
    }
    this.bAW.h(this.bAX, this.hxB.j("fail", null));
    AppMethodBeat.o(130410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.1
 * JD-Core Version:    0.7.0.1
 */