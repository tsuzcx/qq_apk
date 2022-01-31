package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.widget.b.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class JsApiOperateWXData$OperateWXDataTask$2$1
  implements c.a
{
  JsApiOperateWXData$OperateWXDataTask$2$1(JsApiOperateWXData.OperateWXDataTask.2 param2) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.JsApiOperateWXData", "press back button!");
      this.gkb.gka.gjH.b(this.gkb.gka.gjI, this.gkb.gka.gfg, "fail auth cancel");
      this.gkb.gka.gjJ.aib();
      return;
    }
    this.gkb.gka.gjL = "operateWXDataConfirm";
    paramBundle = (ArrayList)paramBundle.getSerializable("key_scope");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {}
    for (this.gkb.gka.gjZ = ((String)paramBundle.get(0));; this.gkb.gka.gjZ = "")
    {
      this.gkb.gka.gjN = paramInt;
      AppBrandMainProcessService.a(this.gkb.gka);
      if (paramInt != 2) {
        break;
      }
      this.gkb.gka.gjH.b(this.gkb.gka.gjI, this.gkb.gka.gfg, "fail auth deny");
      this.gkb.gka.gjJ.aib();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.2.1
 * JD-Core Version:    0.7.0.1
 */