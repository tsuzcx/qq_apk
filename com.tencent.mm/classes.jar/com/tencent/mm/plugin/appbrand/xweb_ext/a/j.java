package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "stickerApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "getStickerApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "plugin-appbrand-integration_release"})
public final class j
  implements i
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j oGP;
  
  public j(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l paraml)
  {
    AppMethodBeat.i(229738);
    if ((paraml instanceof p)) {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
    }
    for (paraml = ((p)paraml).oHu.Qe();; paraml = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j)new q(paraml))
    {
      this.oGP = paraml;
      AppMethodBeat.o(229738);
      return;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j Qe()
  {
    return this.oGP;
  }
  
  public final void a(l.c paramc, String paramString)
  {
    AppMethodBeat.i(229736);
    kotlin.g.b.p.h(paramc, "type");
    kotlin.g.b.p.h(paramString, "path");
    this.oGP.a(paramc, paramString);
    AppMethodBeat.o(229736);
  }
  
  public final boolean a(l.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(229737);
    kotlin.g.b.p.h(paramc, "type");
    kotlin.g.b.p.h(paramList, "stickerInfo");
    paramc = k.oGR.b(paramc, paramList);
    if (paramc != null)
    {
      this.oGP.a(paramc.oGU, paramc.path);
      AppMethodBeat.o(229737);
      return true;
    }
    AppMethodBeat.o(229737);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.j
 * JD-Core Version:    0.7.0.1
 */