package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class ab$1
  implements MMActivity.a
{
  ab$1(ab paramab, o paramo, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.gfQ.hashCode() & 0xFFFF)) {
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      HashMap localHashMap = new HashMap();
      paramIntent = bk.aM(paramIntent.getStringExtra("choose_invoice_title_info"), "");
      y.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : " + paramIntent);
      localHashMap.put("invoiceTitleInfo", paramIntent);
      this.gcp.C(this.dIS, this.gfQ.h("ok", localHashMap));
      return;
    }
    if (paramInt2 == 0)
    {
      this.gcp.C(this.dIS, this.gfQ.h("cancel", null));
      return;
    }
    this.gcp.C(this.dIS, this.gfQ.h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.1
 * JD-Core Version:    0.7.0.1
 */