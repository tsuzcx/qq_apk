package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "", "webViewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callback", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "(ILcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;)V", "getCallback$luggage_wechat_full_sdk_release", "()Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "getWebViewId$luggage_wechat_full_sdk_release", "()I", "parse", "", "parse$luggage_wechat_full_sdk_release", "Companion", "luggage-wechat-full-sdk_release"})
public final class t
{
  public static final a lXQ;
  final int lXO;
  final t.a.a lXP;
  final c lay;
  
  static
  {
    AppMethodBeat.i(169635);
    lXQ = new a((byte)0);
    AppMethodBeat.o(169635);
  }
  
  public t(int paramInt, c paramc, t.a.a parama)
  {
    AppMethodBeat.i(169634);
    this.lXO = paramInt;
    this.lay = paramc;
    this.lXP = parama;
    AppMethodBeat.o(169634);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion;", "", "()V", "Callback", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "", "finish", "", "url", "", "timeOut", "luggage-wechat-full-sdk_release"})
    public static abstract interface a
    {
      public abstract void Tj(String paramString);
      
      public abstract void btG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.t
 * JD-Core Version:    0.7.0.1
 */