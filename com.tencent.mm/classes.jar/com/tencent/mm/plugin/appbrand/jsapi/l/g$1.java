package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class g$1
  implements MMActivity.a
{
  g$1(g paramg, o paramo, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.gzs.hashCode() & 0xFFFF)) {
      return;
    }
    this.gzs.gzr = false;
    if (paramIntent != null) {}
    for (paramInt1 = paramIntent.getIntExtra("key_err_code", 1);; paramInt1 = 1)
    {
      y.i("MicroMsg.JsApiRequestVirtualPayment", "resultCode:%d,result:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (paramInt2 == -1)
      {
        if (paramInt1 == 0)
        {
          y.i("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
          this.gcp.C(this.dIS, this.gzs.h("ok", null));
          return;
        }
        HashMap localHashMap = new HashMap();
        paramIntent = bk.pm(paramIntent.getStringExtra("key_err_msg"));
        localHashMap.put("errCode", Integer.valueOf(paramInt1));
        y.i("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramIntent });
        this.gcp.C(this.dIS, this.gzs.h("fail " + paramIntent, localHashMap));
        return;
      }
      paramIntent = new HashMap();
      paramIntent.put("cancelScene", Integer.valueOf(paramInt1));
      this.gcp.C(this.dIS, this.gzs.h("cancel", paramIntent));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.g.1
 * JD-Core Version:    0.7.0.1
 */