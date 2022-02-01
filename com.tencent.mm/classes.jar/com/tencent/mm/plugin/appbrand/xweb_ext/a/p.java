package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "stickerApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "makeupApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;)V", "getMakeupApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "getStickerApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "plugin-appbrand-integration_release"})
public final class p
  implements m
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l cGQ;
  final i oHu;
  final e oHv;
  
  private p(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l paraml, i parami, e parame)
  {
    AppMethodBeat.i(229769);
    this.cGQ = paraml;
    this.oHu = parami;
    this.oHv = parame;
    AppMethodBeat.o(229769);
  }
  
  public final void Qf()
  {
    AppMethodBeat.i(229763);
    this.cGQ.Qf();
    AppMethodBeat.o(229763);
  }
  
  public final void Qg()
  {
    AppMethodBeat.i(229765);
    this.cGQ.Qg();
    AppMethodBeat.o(229765);
  }
  
  public final void a(l.a parama, float paramFloat)
  {
    AppMethodBeat.i(229759);
    this.cGQ.a(parama, paramFloat);
    AppMethodBeat.o(229759);
  }
  
  public final void a(l.b paramb, String paramString)
  {
    AppMethodBeat.i(229764);
    this.cGQ.a(paramb, paramString);
    AppMethodBeat.o(229764);
  }
  
  public final void a(l.c paramc, String paramString)
  {
    AppMethodBeat.i(229762);
    this.cGQ.a(paramc, paramString);
    AppMethodBeat.o(229762);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(229755);
    kotlin.g.b.p.h(parama, "info");
    boolean bool = this.oHv.a(parama);
    AppMethodBeat.o(229755);
    return bool;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(229757);
    kotlin.g.b.p.h(paramb, "info");
    boolean bool = this.oHv.a(paramb);
    AppMethodBeat.o(229757);
    return bool;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(229754);
    kotlin.g.b.p.h(paramc, "info");
    boolean bool = this.oHv.a(paramc);
    AppMethodBeat.o(229754);
    return bool;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(229756);
    kotlin.g.b.p.h(paramd, "info");
    boolean bool = this.oHv.a(paramd);
    AppMethodBeat.o(229756);
    return bool;
  }
  
  public final boolean a(l.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(229752);
    kotlin.g.b.p.h(paramc, "type");
    kotlin.g.b.p.h(paramList, "stickerInfo");
    boolean bool = this.oHu.a(paramc, paramList);
    AppMethodBeat.o(229752);
    return bool;
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(229753);
    kotlin.g.b.p.h(paramn, "info");
    boolean bool = this.oHv.a(paramn);
    AppMethodBeat.o(229753);
    return bool;
  }
  
  public final void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(229760);
    this.cGQ.b(paramString, paramFloat);
    AppMethodBeat.o(229760);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(229761);
    this.cGQ.clearFilters();
    AppMethodBeat.o(229761);
  }
  
  public final boolean isEnabled()
  {
    AppMethodBeat.i(229758);
    boolean bool = this.cGQ.isEnabled();
    AppMethodBeat.o(229758);
    return bool;
  }
  
  public final void onDetectFacePoints(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(229767);
    this.cGQ.onDetectFacePoints(paramArrayOfFloat);
    AppMethodBeat.o(229767);
  }
  
  public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229766);
    paramInt1 = this.cGQ.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(229766);
    return paramInt1;
  }
  
  public final void onTextureDestoryed()
  {
    AppMethodBeat.i(229768);
    this.cGQ.onTextureDestoryed();
    AppMethodBeat.o(229768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.p
 * JD-Core Version:    0.7.0.1
 */