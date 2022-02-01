package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyWorkaroundLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyWorkaroundLogic;", "weEffectManager", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "DUMMY", "IFactory", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface p
  extends h, l, o
{
  public static final a eAS = a.eAT;
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "()V", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadowV2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStickV1", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV1;", "applyLipStickV2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements p
  {
    private static final o eAU;
    
    static
    {
      AppMethodBeat.i(220791);
      eAT = new a();
      o localo = o.eAC;
      s.s(localo, "DUMMY");
      eAU = localo;
      AppMethodBeat.o(220791);
    }
    
    public final void a(o.a parama, float paramFloat)
    {
      AppMethodBeat.i(220851);
      eAU.a(parama, paramFloat);
      AppMethodBeat.o(220851);
    }
    
    public final void a(o.b paramb, String paramString)
    {
      AppMethodBeat.i(220890);
      eAU.a(paramb, paramString);
      AppMethodBeat.o(220890);
    }
    
    public final void a(o.c paramc, String paramString)
    {
      AppMethodBeat.i(220876);
      eAU.a(paramc, paramString);
      AppMethodBeat.o(220876);
    }
    
    public final boolean a(b paramb)
    {
      AppMethodBeat.i(220821);
      s.u(paramb, "info");
      AppMethodBeat.o(220821);
      return false;
    }
    
    public final boolean a(c paramc)
    {
      AppMethodBeat.i(220839);
      s.u(paramc, "info");
      AppMethodBeat.o(220839);
      return false;
    }
    
    public final boolean a(d paramd)
    {
      AppMethodBeat.i(220812);
      s.u(paramd, "info");
      AppMethodBeat.o(220812);
      return false;
    }
    
    public final boolean a(e parame)
    {
      AppMethodBeat.i(220828);
      s.u(parame, "info");
      AppMethodBeat.o(220828);
      return false;
    }
    
    public final boolean a(o.c paramc, List<StickerItemInfo> paramList)
    {
      AppMethodBeat.i(220796);
      s.u(paramc, "type");
      s.u(paramList, "stickerInfo");
      AppMethodBeat.o(220796);
      return false;
    }
    
    public final boolean a(q paramq)
    {
      AppMethodBeat.i(220804);
      s.u(paramq, "info");
      AppMethodBeat.o(220804);
      return false;
    }
    
    public final void aul()
    {
      AppMethodBeat.i(220883);
      eAU.aul();
      AppMethodBeat.o(220883);
    }
    
    public final void aum()
    {
      AppMethodBeat.i(220899);
      eAU.aum();
      AppMethodBeat.o(220899);
    }
    
    public final void c(String paramString, float paramFloat)
    {
      AppMethodBeat.i(220857);
      eAU.c(paramString, paramFloat);
      AppMethodBeat.o(220857);
    }
    
    public final void clearFilters()
    {
      AppMethodBeat.i(220866);
      eAU.clearFilters();
      AppMethodBeat.o(220866);
    }
    
    public final boolean isEnabled()
    {
      AppMethodBeat.i(220847);
      boolean bool = eAU.isEnabled();
      AppMethodBeat.o(220847);
      return bool;
    }
    
    public final void onDetectFacePoints(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(220921);
      eAU.onDetectFacePoints(paramArrayOfFloat);
      AppMethodBeat.o(220921);
    }
    
    public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220908);
      paramInt1 = eAU.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(220908);
      return paramInt1;
    }
    
    public final void onTextureDestoryed()
    {
      AppMethodBeat.i(220926);
      eAU.onTextureDestoryed();
      AppMethodBeat.o(220926);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "DUMMY", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public static final a eAV = a.eAW;
    
    public abstract p aun();
    
    @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements p.b
    {
      static
      {
        AppMethodBeat.i(220784);
        eAW = new a();
        AppMethodBeat.o(220784);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p
 * JD-Core Version:    0.7.0.1
 */