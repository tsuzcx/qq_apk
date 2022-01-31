package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.widget.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiLogin$LoginTask$2$1
  implements c.a
{
  JsApiLogin$LoginTask$2$1(JsApiLogin.LoginTask.2 param2) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.JsApiLogin", "press back button!");
      this.gjV.gjU.gjH.b(this.gjV.gjU.gjI, this.gjV.gjU.gfg, "fail auth cancel");
      this.gjV.gjU.gjJ.aib();
    }
    do
    {
      return;
      this.gjV.gjU.gjL = "loginConfirm";
      this.gjV.gjU.gjK = paramBundle;
      this.gjV.gjU.gjN = paramInt;
      AppBrandMainProcessService.a(this.gjV.gjU);
    } while (paramInt != 2);
    this.gjV.gjU.gjH.b(this.gjV.gjU.gjI, this.gjV.gjU.gfg, "fail auth deny");
    this.gjV.gjU.gjJ.aib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.2.1
 * JD-Core Version:    0.7.0.1
 */