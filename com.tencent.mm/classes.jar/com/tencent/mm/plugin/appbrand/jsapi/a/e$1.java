package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements MMActivity.a
{
  e$1(e parame, q paramq, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    HashMap localHashMap;
    if (paramInt1 == 1)
    {
      localHashMap = new HashMap();
      if (paramInt2 != -1) {
        break label151;
      }
      y.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
      paramIntent = paramIntent.getStringExtra("intent_auth_token");
      if (bk.bl(paramIntent)) {
        break label128;
      }
      localHashMap.put("errCode", Integer.valueOf(0));
      localHashMap.put("auth_token", paramIntent);
      this.gkf.C(this.dIS, this.gkM.h("ok", localHashMap));
      y.d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", new Object[] { paramIntent });
    }
    label128:
    label151:
    do
    {
      return;
      this.gkf.C(this.dIS, this.gkM.h("fail", localHashMap));
      return;
      if (paramInt2 == 0)
      {
        y.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
        this.gkf.C(this.dIS, this.gkM.h("cancel", null));
        return;
      }
    } while (paramInt2 != 1);
    y.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("intent_err_code", -1);
      paramIntent = paramIntent.getStringExtra("intent_err_msg");
      localHashMap.put("errCode", Integer.valueOf(paramInt1));
      this.gkf.C(this.dIS, this.gkM.h("fail:" + bk.pm(paramIntent), localHashMap));
      y.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), paramIntent });
      return;
    }
    this.gkf.C(this.dIS, this.gkM.h("fail", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.e.1
 * JD-Core Version:    0.7.0.1
 */