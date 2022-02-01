package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyWorkaroundLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyWorkaroundLogic;", "weEffectManager", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "DUMMY", "IFactory", "luggage-xweb-ext_release"})
public abstract interface n
  extends g, k, m
{
  public static final a cHv = a.cHx;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "()V", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "luggage-xweb-ext_release"})
  public static final class a
    implements n
  {
    private static final m cHw;
    
    static
    {
      AppMethodBeat.i(226461);
      cHx = new a();
      m localm = m.cHf;
      p.j(localm, "IWeEffectManager.DUMMY");
      cHw = localm;
      AppMethodBeat.o(226461);
    }
    
    public final void TG()
    {
      AppMethodBeat.i(226452);
      cHw.TG();
      AppMethodBeat.o(226452);
    }
    
    public final void TH()
    {
      AppMethodBeat.i(226454);
      cHw.TH();
      AppMethodBeat.o(226454);
    }
    
    public final void a(m.a parama, float paramFloat)
    {
      AppMethodBeat.i(226444);
      cHw.a(parama, paramFloat);
      AppMethodBeat.o(226444);
    }
    
    public final void a(m.b paramb, String paramString)
    {
      AppMethodBeat.i(226453);
      cHw.a(paramb, paramString);
      AppMethodBeat.o(226453);
    }
    
    public final void a(m.c paramc, String paramString)
    {
      AppMethodBeat.i(226450);
      cHw.a(paramc, paramString);
      AppMethodBeat.o(226450);
    }
    
    public final boolean a(a parama)
    {
      AppMethodBeat.i(226440);
      p.k(parama, "info");
      AppMethodBeat.o(226440);
      return false;
    }
    
    public final boolean a(b paramb)
    {
      AppMethodBeat.i(226442);
      p.k(paramb, "info");
      AppMethodBeat.o(226442);
      return false;
    }
    
    public final boolean a(c paramc)
    {
      AppMethodBeat.i(226439);
      p.k(paramc, "info");
      AppMethodBeat.o(226439);
      return false;
    }
    
    public final boolean a(d paramd)
    {
      AppMethodBeat.i(226441);
      p.k(paramd, "info");
      AppMethodBeat.o(226441);
      return false;
    }
    
    public final boolean a(m.c paramc, List<StickerItemInfo> paramList)
    {
      AppMethodBeat.i(226434);
      p.k(paramc, "type");
      p.k(paramList, "stickerInfo");
      AppMethodBeat.o(226434);
      return false;
    }
    
    public final boolean a(o paramo)
    {
      AppMethodBeat.i(226437);
      p.k(paramo, "info");
      AppMethodBeat.o(226437);
      return false;
    }
    
    public final void b(String paramString, float paramFloat)
    {
      AppMethodBeat.i(226446);
      cHw.b(paramString, paramFloat);
      AppMethodBeat.o(226446);
    }
    
    public final void clearFilters()
    {
      AppMethodBeat.i(226448);
      cHw.clearFilters();
      AppMethodBeat.o(226448);
    }
    
    public final boolean isEnabled()
    {
      AppMethodBeat.i(226443);
      boolean bool = cHw.isEnabled();
      AppMethodBeat.o(226443);
      return bool;
    }
    
    public final void onDetectFacePoints(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(226458);
      cHw.onDetectFacePoints(paramArrayOfFloat);
      AppMethodBeat.o(226458);
    }
    
    public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(226456);
      paramInt1 = cHw.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(226456);
      return paramInt1;
    }
    
    public final void onTextureDestoryed()
    {
      AppMethodBeat.i(226460);
      cHw.onTextureDestoryed();
      AppMethodBeat.o(226460);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "DUMMY", "luggage-xweb-ext_release"})
  public static abstract interface b
  {
    public static final a cHy = a.cHz;
    
    public abstract n TI();
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "luggage-xweb-ext_release"})
    public static final class a
      implements n.b
    {
      static
      {
        AppMethodBeat.i(226289);
        cHz = new a();
        AppMethodBeat.o(226289);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n
 * JD-Core Version:    0.7.0.1
 */