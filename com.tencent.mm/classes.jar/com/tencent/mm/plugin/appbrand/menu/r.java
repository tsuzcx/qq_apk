package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "", "webViewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callback", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "(ILcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;)V", "getCallback$luggage_wechat_full_sdk_release", "()Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "getWebViewId$luggage_wechat_full_sdk_release", "()I", "parse", "", "parse$luggage_wechat_full_sdk_release", "Companion", "luggage-wechat-full-sdk_release"})
public final class r
{
  public static final a kSE;
  final c jZU;
  final int kSC;
  final r.a.a kSD;
  
  static
  {
    AppMethodBeat.i(169635);
    kSE = new a((byte)0);
    AppMethodBeat.o(169635);
  }
  
  public r(int paramInt, c paramc, r.a.a parama)
  {
    AppMethodBeat.i(169634);
    this.kSC = paramInt;
    this.jZU = paramc;
    this.kSD = parama;
    AppMethodBeat.o(169634);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion;", "", "()V", "Callback", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask$Companion$Callback;", "", "finish", "", "url", "", "timeOut", "luggage-wechat-full-sdk_release"})
    public static abstract interface a
    {
      public abstract void KQ(String paramString);
      
      public abstract void bic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.r
 * JD-Core Version:    0.7.0.1
 */