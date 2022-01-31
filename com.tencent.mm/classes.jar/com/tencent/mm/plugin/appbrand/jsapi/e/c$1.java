package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements MMActivity.a
{
  c$1(c paramc, o paramo) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label310;
      }
      if (paramIntent == null)
      {
        this.gcp.C(this.grB.bhx, this.grB.h("fail", null));
        y.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
      }
    }
    else
    {
      return;
    }
    paramIntent = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
    HashMap localHashMap = new HashMap();
    if (paramIntent != null)
    {
      y.i("MicroMsg.JsApiChooseLocation", "addr: " + paramIntent.toString());
      StringBuilder localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(paramIntent.ekZ))
      {
        localStringBuilder.append(paramIntent.ekZ);
        localHashMap.put("address", localStringBuilder.toString());
        if (TextUtils.isEmpty(paramIntent.eli)) {
          break label247;
        }
        localHashMap.put("name", paramIntent.eli);
      }
      for (;;)
      {
        localHashMap.put("latitude", Float.valueOf(paramIntent.elk));
        localHashMap.put("longitude", Float.valueOf(paramIntent.ell));
        this.gcp.C(this.grB.bhx, this.grB.h("ok", localHashMap));
        return;
        localStringBuilder.append(paramIntent.NY());
        break;
        label247:
        localHashMap.put("name", localStringBuilder.toString());
      }
    }
    this.gcp.C(this.grB.bhx, this.grB.h("fail", null));
    y.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
    return;
    label310:
    if (paramInt2 == 0)
    {
      this.gcp.C(this.grB.bhx, this.grB.h("cancel", null));
      y.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
      return;
    }
    this.gcp.C(this.grB.bhx, this.grB.h("fail", null));
    y.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.c.1
 * JD-Core Version:    0.7.0.1
 */