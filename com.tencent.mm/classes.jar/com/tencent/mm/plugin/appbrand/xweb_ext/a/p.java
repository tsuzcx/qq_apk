package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "stickerApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "makeupApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;)V", "getMakeupApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "getStickerApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "plugin-appbrand-integration_release"})
public final class p
  implements n
{
  private final m cHw;
  final i rJk;
  final e rJl;
  
  private p(m paramm, i parami, e parame)
  {
    AppMethodBeat.i(273977);
    this.cHw = paramm;
    this.rJk = parami;
    this.rJl = parame;
    AppMethodBeat.o(273977);
  }
  
  public final void TG()
  {
    AppMethodBeat.i(273970);
    this.cHw.TG();
    AppMethodBeat.o(273970);
  }
  
  public final void TH()
  {
    AppMethodBeat.i(273973);
    this.cHw.TH();
    AppMethodBeat.o(273973);
  }
  
  public final void a(m.a parama, float paramFloat)
  {
    AppMethodBeat.i(273966);
    this.cHw.a(parama, paramFloat);
    AppMethodBeat.o(273966);
  }
  
  public final void a(m.b paramb, String paramString)
  {
    AppMethodBeat.i(273972);
    this.cHw.a(paramb, paramString);
    AppMethodBeat.o(273972);
  }
  
  public final void a(m.c paramc, String paramString)
  {
    AppMethodBeat.i(273969);
    this.cHw.a(paramc, paramString);
    AppMethodBeat.o(273969);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(273962);
    kotlin.g.b.p.k(parama, "info");
    boolean bool = this.rJl.a(parama);
    AppMethodBeat.o(273962);
    return bool;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(273964);
    kotlin.g.b.p.k(paramb, "info");
    boolean bool = this.rJl.a(paramb);
    AppMethodBeat.o(273964);
    return bool;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(273961);
    kotlin.g.b.p.k(paramc, "info");
    boolean bool = this.rJl.a(paramc);
    AppMethodBeat.o(273961);
    return bool;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(273963);
    kotlin.g.b.p.k(paramd, "info");
    boolean bool = this.rJl.a(paramd);
    AppMethodBeat.o(273963);
    return bool;
  }
  
  public final boolean a(m.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(273959);
    kotlin.g.b.p.k(paramc, "type");
    kotlin.g.b.p.k(paramList, "stickerInfo");
    boolean bool = this.rJk.a(paramc, paramList);
    AppMethodBeat.o(273959);
    return bool;
  }
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(273960);
    kotlin.g.b.p.k(paramo, "info");
    boolean bool = this.rJl.a(paramo);
    AppMethodBeat.o(273960);
    return bool;
  }
  
  public final void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(273967);
    this.cHw.b(paramString, paramFloat);
    AppMethodBeat.o(273967);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(273968);
    this.cHw.clearFilters();
    AppMethodBeat.o(273968);
  }
  
  public final boolean isEnabled()
  {
    AppMethodBeat.i(273965);
    boolean bool = this.cHw.isEnabled();
    AppMethodBeat.o(273965);
    return bool;
  }
  
  public final void onDetectFacePoints(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(273975);
    this.cHw.onDetectFacePoints(paramArrayOfFloat);
    AppMethodBeat.o(273975);
  }
  
  public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(273974);
    paramInt1 = this.cHw.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(273974);
    return paramInt1;
  }
  
  public final void onTextureDestoryed()
  {
    AppMethodBeat.i(273976);
    this.cHw.onTextureDestoryed();
    AppMethodBeat.o(273976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.p
 * JD-Core Version:    0.7.0.1
 */