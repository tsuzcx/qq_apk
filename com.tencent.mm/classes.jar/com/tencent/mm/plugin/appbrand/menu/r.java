package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "", "webViewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callback", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "(ILcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;)V", "getCallback$luggage_wechat_full_sdk_release", "()Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "getWebViewId$luggage_wechat_full_sdk_release", "()I", "parse", "", "parse$luggage_wechat_full_sdk_release", "Companion", "luggage-wechat-full-sdk_release"})
public final class r
{
  public static final a lue;
  final c kAH;
  final int luc;
  final r.a.a lud;
  
  static
  {
    AppMethodBeat.i(169635);
    lue = new a((byte)0);
    AppMethodBeat.o(169635);
  }
  
  public r(int paramInt, c paramc, r.a.a parama)
  {
    AppMethodBeat.i(169634);
    this.luc = paramInt;
    this.kAH = paramc;
    this.lud = parama;
    AppMethodBeat.o(169634);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion;", "", "()V", "Callback", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "", "finish", "", "url", "", "timeOut", "luggage-wechat-full-sdk_release"})
    public static abstract interface a
    {
      public abstract void OX(String paramString);
      
      public abstract void boW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.r
 * JD-Core Version:    0.7.0.1
 */