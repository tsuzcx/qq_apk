package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.widget.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class JsApiLogin$LoginTask$2$1
  implements c.a
{
  JsApiLogin$LoginTask$2$1(JsApiLogin.LoginTask.2 param2) {}
  
  public final void b(int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(130857);
    ab.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.d("MicroMsg.JsApiLogin", "press back button!");
      this.hDQ.hDP.hDu.b(this.hDQ.hDP.hDv, this.hDQ.hDP.hry, "fail auth cancel");
      this.hDQ.hDP.hDw.aBV();
    }
    do
    {
      AppMethodBeat.o(130857);
      return;
      this.hDQ.hDP.hDy = "loginConfirm";
      this.hDQ.hDP.hDx = paramArrayList;
      this.hDQ.hDP.hDA = paramInt;
      AppBrandMainProcessService.a(this.hDQ.hDP);
    } while (paramInt != 2);
    this.hDQ.hDP.hDu.b(this.hDQ.hDP.hDv, this.hDQ.hDP.hry, "fail auth deny");
    this.hDQ.hDP.hDw.aBV();
    AppMethodBeat.o(130857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.2.1
 * JD-Core Version:    0.7.0.1
 */