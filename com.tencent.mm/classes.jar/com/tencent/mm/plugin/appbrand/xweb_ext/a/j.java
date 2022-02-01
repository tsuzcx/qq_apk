package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;)V", "stickerApplyLogic", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "getStickerApplyLogic", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyLogic;", "applySticker", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k uTW;
  
  public j(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo)
  {
    AppMethodBeat.i(317069);
    if ((paramo instanceof o)) {
      Log.w("MicroMsg.AppBrand.StickerApplyAdapter", "weEffectManager is IWeEffectWorkaroundManager");
    }
    for (paramo = ((o)paramo).uUA.auk();; paramo = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k)new t(paramo))
    {
      this.uTW = paramo;
      AppMethodBeat.o(317069);
      return;
    }
  }
  
  public final void a(o.c paramc, String paramString)
  {
    AppMethodBeat.i(317079);
    s.u(paramc, "type");
    s.u(paramString, "path");
    this.uTW.a(paramc, paramString);
    AppMethodBeat.o(317079);
  }
  
  public final boolean a(o.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(317090);
    s.u(paramc, "type");
    s.u(paramList, "stickerInfo");
    paramc = k.uTX.b(paramc, paramList);
    if (paramc == null)
    {
      AppMethodBeat.o(317090);
      return false;
    }
    this.uTW.a(paramc.uUa, paramc.path);
    AppMethodBeat.o(317090);
    return true;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k auk()
  {
    return this.uTW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.j
 * JD-Core Version:    0.7.0.1
 */