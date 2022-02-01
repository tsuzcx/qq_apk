package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "stickerApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "makeupApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;)V", "getMakeupApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "getStickerApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadowV2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStickV1", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV1;", "applyLipStickV2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements p
{
  private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o eAU;
  final j uUA;
  final f uUB;
  
  private o(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo, j paramj, f paramf)
  {
    AppMethodBeat.i(317086);
    this.eAU = paramo;
    this.uUA = paramj;
    this.uUB = paramf;
    AppMethodBeat.o(317086);
  }
  
  public final void a(o.a parama, float paramFloat)
  {
    AppMethodBeat.i(317145);
    this.eAU.a(parama, paramFloat);
    AppMethodBeat.o(317145);
  }
  
  public final void a(o.b paramb, String paramString)
  {
    AppMethodBeat.i(317159);
    this.eAU.a(paramb, paramString);
    AppMethodBeat.o(317159);
  }
  
  public final void a(o.c paramc, String paramString)
  {
    AppMethodBeat.i(317151);
    this.eAU.a(paramc, paramString);
    AppMethodBeat.o(317151);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(317124);
    s.u(paramb, "info");
    boolean bool = this.uUB.a(paramb);
    AppMethodBeat.o(317124);
    return bool;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(317132);
    s.u(paramc, "info");
    boolean bool = this.uUB.a(paramc);
    AppMethodBeat.o(317132);
    return bool;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(317117);
    s.u(paramd, "info");
    boolean bool = this.uUB.a(paramd);
    AppMethodBeat.o(317117);
    return bool;
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(317130);
    s.u(parame, "info");
    boolean bool = this.uUB.a(parame);
    AppMethodBeat.o(317130);
    return bool;
  }
  
  public final boolean a(o.c paramc, List<StickerItemInfo> paramList)
  {
    AppMethodBeat.i(317105);
    s.u(paramc, "type");
    s.u(paramList, "stickerInfo");
    boolean bool = this.uUA.a(paramc, paramList);
    AppMethodBeat.o(317105);
    return bool;
  }
  
  public final boolean a(q paramq)
  {
    AppMethodBeat.i(317111);
    s.u(paramq, "info");
    boolean bool = this.uUB.a(paramq);
    AppMethodBeat.o(317111);
    return bool;
  }
  
  public final void aul()
  {
    AppMethodBeat.i(317155);
    this.eAU.aul();
    AppMethodBeat.o(317155);
  }
  
  public final void aum()
  {
    AppMethodBeat.i(317162);
    this.eAU.aum();
    AppMethodBeat.o(317162);
  }
  
  public final void c(String paramString, float paramFloat)
  {
    AppMethodBeat.i(317148);
    this.eAU.c(paramString, paramFloat);
    AppMethodBeat.o(317148);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(317149);
    this.eAU.clearFilters();
    AppMethodBeat.o(317149);
  }
  
  public final boolean isEnabled()
  {
    AppMethodBeat.i(317138);
    boolean bool = this.eAU.isEnabled();
    AppMethodBeat.o(317138);
    return bool;
  }
  
  public final void onDetectFacePoints(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(317167);
    this.eAU.onDetectFacePoints(paramArrayOfFloat);
    AppMethodBeat.o(317167);
  }
  
  public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(317163);
    paramInt1 = this.eAU.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(317163);
    return paramInt1;
  }
  
  public final void onTextureDestoryed()
  {
    AppMethodBeat.i(317169);
    this.eAU.onTextureDestoryed();
    AppMethodBeat.o(317169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.o
 * JD-Core Version:    0.7.0.1
 */