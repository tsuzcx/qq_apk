package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "stickerApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "getStickerApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "plugin-appbrand-integration_release"})
public final class j
  implements i
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j rIF;
  
  public j(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m paramm)
  {
    AppMethodBeat.i(283991);
    if ((paramm instanceof p)) {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
    }
    for (paramm = ((p)paramm).rJk.TF();; paramm = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j)new r(paramm))
    {
      this.rIF = paramm;
      AppMethodBeat.o(283991);
      return;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j TF()
  {
    return this.rIF;
  }
  
  public final void a(m.c paramc, String paramString)
  {
    AppMethodBeat.i(283985);
    kotlin.g.b.p.k(paramc, "type");
    kotlin.g.b.p.k(paramString, "path");
    this.rIF.a(paramc, paramString);
    AppMethodBeat.o(283985);
  }
  
  public final boolean a(m.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(283988);
    kotlin.g.b.p.k(paramc, "type");
    kotlin.g.b.p.k(paramList, "stickerInfo");
    paramc = k.rIH.b(paramc, paramList);
    if (paramc != null)
    {
      this.rIF.a(paramc.rIK, paramc.path);
      AppMethodBeat.o(283988);
      return true;
    }
    AppMethodBeat.o(283988);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.j
 * JD-Core Version:    0.7.0.1
 */