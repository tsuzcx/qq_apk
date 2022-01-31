package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.widget.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiAuthorize$AuthorizeTask$2$1
  implements c.a
{
  JsApiAuthorize$AuthorizeTask$2$1(JsApiAuthorize.AuthorizeTask.2 param2) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.JsApiAuthorize", "press back button!");
      this.gjS.gjR.gjH.b(this.gjS.gjR.gjI, this.gjS.gjR.gfg, "fail auth cancel");
      this.gjS.gjR.gjJ.aib();
    }
    do
    {
      return;
      this.gjS.gjR.gjL = "authorizeConfirm";
      this.gjS.gjR.gjK = paramBundle;
      this.gjS.gjR.gjN = paramInt;
      AppBrandMainProcessService.a(this.gjS.gjR);
    } while (paramInt != 2);
    this.gjS.gjR.gjH.b(this.gjS.gjR.gjI, this.gjS.gjR.gfg, "fail auth deny");
    this.gjS.gjR.gjJ.aib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.2.1
 * JD-Core Version:    0.7.0.1
 */