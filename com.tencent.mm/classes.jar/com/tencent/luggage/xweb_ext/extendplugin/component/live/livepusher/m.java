package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyWorkaroundLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyWorkaroundLogic;", "weEffectManager", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "DUMMY", "IFactory", "luggage-xweb-ext_release"})
public abstract interface m
  extends g, k, l
{
  public static final a cGP = a.cGR;
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "()V", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "luggage-xweb-ext_release"})
  public static final class a
    implements m
  {
    private static final l cGQ;
    
    static
    {
      AppMethodBeat.i(215952);
      cGR = new a();
      l locall = l.cGz;
      p.g(locall, "IWeEffectManager.DUMMY");
      cGQ = locall;
      AppMethodBeat.o(215952);
    }
    
    public final void Qf()
    {
      AppMethodBeat.i(215946);
      cGQ.Qf();
      AppMethodBeat.o(215946);
    }
    
    public final void Qg()
    {
      AppMethodBeat.i(215948);
      cGQ.Qg();
      AppMethodBeat.o(215948);
    }
    
    public final void a(l.a parama, float paramFloat)
    {
      AppMethodBeat.i(215942);
      cGQ.a(parama, paramFloat);
      AppMethodBeat.o(215942);
    }
    
    public final void a(l.b paramb, String paramString)
    {
      AppMethodBeat.i(215947);
      cGQ.a(paramb, paramString);
      AppMethodBeat.o(215947);
    }
    
    public final void a(l.c paramc, String paramString)
    {
      AppMethodBeat.i(215945);
      cGQ.a(paramc, paramString);
      AppMethodBeat.o(215945);
    }
    
    public final boolean a(a parama)
    {
      AppMethodBeat.i(215938);
      p.h(parama, "info");
      AppMethodBeat.o(215938);
      return false;
    }
    
    public final boolean a(b paramb)
    {
      AppMethodBeat.i(215940);
      p.h(paramb, "info");
      AppMethodBeat.o(215940);
      return false;
    }
    
    public final boolean a(c paramc)
    {
      AppMethodBeat.i(215937);
      p.h(paramc, "info");
      AppMethodBeat.o(215937);
      return false;
    }
    
    public final boolean a(d paramd)
    {
      AppMethodBeat.i(215939);
      p.h(paramd, "info");
      AppMethodBeat.o(215939);
      return false;
    }
    
    public final boolean a(l.c paramc, List<StickerItemInfo> paramList)
    {
      AppMethodBeat.i(215935);
      p.h(paramc, "type");
      p.h(paramList, "stickerInfo");
      AppMethodBeat.o(215935);
      return false;
    }
    
    public final boolean a(n paramn)
    {
      AppMethodBeat.i(215936);
      p.h(paramn, "info");
      AppMethodBeat.o(215936);
      return false;
    }
    
    public final void b(String paramString, float paramFloat)
    {
      AppMethodBeat.i(215943);
      cGQ.b(paramString, paramFloat);
      AppMethodBeat.o(215943);
    }
    
    public final void clearFilters()
    {
      AppMethodBeat.i(215944);
      cGQ.clearFilters();
      AppMethodBeat.o(215944);
    }
    
    public final boolean isEnabled()
    {
      AppMethodBeat.i(215941);
      boolean bool = cGQ.isEnabled();
      AppMethodBeat.o(215941);
      return bool;
    }
    
    public final void onDetectFacePoints(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(215950);
      cGQ.onDetectFacePoints(paramArrayOfFloat);
      AppMethodBeat.o(215950);
    }
    
    public final int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(215949);
      paramInt1 = cGQ.onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(215949);
      return paramInt1;
    }
    
    public final void onTextureDestoryed()
    {
      AppMethodBeat.i(215951);
      cGQ.onTextureDestoryed();
      AppMethodBeat.o(215951);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "DUMMY", "luggage-xweb-ext_release"})
  public static abstract interface b
  {
    public static final a cGS = a.cGT;
    
    public abstract m Qh();
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "luggage-xweb-ext_release"})
    public static final class a
      implements m.b
    {
      static
      {
        AppMethodBeat.i(215953);
        cGT = new a();
        AppMethodBeat.o(215953);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m
 * JD-Core Version:    0.7.0.1
 */