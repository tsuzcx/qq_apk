package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.tz;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.plugin.xlabeffect.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "scene", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initScene", "initial", "previewTexture", "beautyParam", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterParam", "Lcom/tencent/mm/live/core/render/FilterConfig;", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "setLiveScene", "setSceneLevel", "level", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect$SceneLevel;", "updateBeautyConfig", "beautyConfig", "updateFilterConfig", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  static final String TAG;
  public static final c.a mVa;
  int mVb;
  d mVc;
  int mVd;
  int mVe;
  public k muW;
  public int scene = -1;
  
  static
  {
    AppMethodBeat.i(247726);
    mVa = new c.a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(247726);
  }
  
  private void a(k.d paramd)
  {
    AppMethodBeat.i(247718);
    s.u(paramd, "level");
    k localk = this.muW;
    if (localk != null)
    {
      s.u(paramd, "level");
      localk.XLk = paramd;
    }
    AppMethodBeat.o(247718);
  }
  
  public final void a(int paramInt, d paramd, a parama, b paramb)
  {
    AppMethodBeat.i(247740);
    s.u(paramd, "outputTexture");
    s.u(parama, "beautyParam");
    s.u(paramb, "filterParam");
    try
    {
      Log.i(TAG, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), parama });
      if (this.muW != null)
      {
        Log.w(TAG, "initial xLabEffect: again");
        localk = this.muW;
        s.checkNotNull(localk);
        localk.destroy();
      }
      this.muW = new k(0, 0, 1);
      k localk = this.muW;
      s.checkNotNull(localk);
      localk.Jo(false);
      a(parama);
      Log.i(TAG, s.X("#initial Beauty ", parama));
      boolean bool = paramb.bgu();
      Log.i(TAG, "#initial Filter " + paramb.mUY + ", " + paramb.mUZ);
      if (bool)
      {
        parama = this.muW;
        s.checkNotNull(parama);
        parama.o(paramb.mUY, paramb.mUZ / 100.0F);
      }
      this.mVb = paramInt;
      this.mVc = paramd;
      if (this.scene != -1) {
        tg(this.scene);
      }
      Log.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(247740);
      return;
    }
    catch (Exception paramd)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
      AppMethodBeat.o(247740);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(247764);
    s.u(parama, "beautyConfig");
    Log.i(TAG, s.X("#updateBeautyConfig beautyConfig=", parama));
    boolean bool1 = parama.bgq();
    boolean bool2 = parama.bgr();
    boolean bool3 = parama.bgs();
    boolean bool4 = parama.bgt();
    if (parama.mUW) {}
    for (Object localObject = k.d.XLP;; localObject = k.d.XLO)
    {
      a((k.d)localObject);
      localObject = this.muW;
      if (localObject != null)
      {
        XEffectConfig localXEffectConfig = new XEffectConfig();
        localXEffectConfig.XKs = parama.bfU();
        localXEffectConfig.XKt = parama.bfV();
        localXEffectConfig.XKu = parama.bfW();
        localXEffectConfig.XKv = parama.bfX();
        localXEffectConfig.XKw = parama.bfY();
        localXEffectConfig.DpI = parama.bfZ();
        localXEffectConfig.XKx = parama.bga();
        localXEffectConfig.XKy = parama.bgb();
        localXEffectConfig.XKz = parama.bgc();
        localXEffectConfig.XKA = parama.bgd();
        localXEffectConfig.XKB = parama.bge();
        localXEffectConfig.XKC = parama.bgf();
        localXEffectConfig.XKD = parama.bgg();
        localXEffectConfig.XKE = parama.bgh();
        localXEffectConfig.XKJ = parama.bgi();
        localXEffectConfig.avm(parama.bgj());
        localXEffectConfig.XKM = parama.bgk();
        localXEffectConfig.avl(parama.bgl());
        localXEffectConfig.XKK = parama.bgm();
        localXEffectConfig.XKL = parama.bgn();
        localXEffectConfig.XKN = parama.bgo();
        localXEffectConfig.XKO = parama.bgp();
        ah localah = ah.aiuX;
        ((k)localObject).a(localXEffectConfig);
      }
      if (bool1)
      {
        localObject = this.muW;
        s.checkNotNull(localObject);
        ((k)localObject).Jl(true);
      }
      if (bool2)
      {
        localObject = this.muW;
        s.checkNotNull(localObject);
        ((k)localObject).Jm(true);
      }
      if (bool3)
      {
        localObject = this.muW;
        s.checkNotNull(localObject);
        k.a((k)localObject, true);
      }
      if (bool4)
      {
        localObject = this.muW;
        s.checkNotNull(localObject);
        ((k)localObject).avn(parama.bfZ());
        parama = this.muW;
        s.checkNotNull(parama);
        parama.Jn(true);
      }
      AppMethodBeat.o(247764);
      return;
    }
  }
  
  public final void bgv()
  {
    AppMethodBeat.i(247774);
    long l = Util.currentTicks();
    try
    {
      Object localObject = this.muW;
      s.checkNotNull(localObject);
      k.a((k)localObject, this.mVb);
      localObject = this.mVc;
      s.checkNotNull(localObject);
      ((d)localObject).a(this.mVd, this.mVe, 6408, null, 9729, 10497);
      localObject = this.muW;
      s.checkNotNull(localObject);
      int i = this.mVb;
      d locald = this.mVc;
      s.checkNotNull(locald);
      k.a((k)localObject, i, locald.nAF, false, 40);
      Log.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(247774);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "filterProcess error", new Object[0]);
      }
    }
  }
  
  public final void tg(int paramInt)
  {
    AppMethodBeat.i(247752);
    Object localObject = e.h.mKY;
    if (paramInt == e.h.bdi())
    {
      localObject = this.muW;
      if (localObject != null)
      {
        localObject = ((k)localObject).XLr;
        if (localObject != null)
        {
          ((tz)localObject).jFp = 3;
          AppMethodBeat.o(247752);
        }
      }
    }
    else
    {
      localObject = e.h.mKY;
      if (paramInt == e.h.bdj())
      {
        localObject = this.muW;
        if (localObject != null)
        {
          localObject = ((k)localObject).XLr;
          if (localObject != null)
          {
            ((tz)localObject).jFp = 0;
            AppMethodBeat.o(247752);
          }
        }
      }
      else
      {
        localObject = this.muW;
        if (localObject != null)
        {
          localObject = ((k)localObject).XLr;
          if (localObject != null) {
            ((tz)localObject).jFp = -1;
          }
        }
      }
    }
    AppMethodBeat.o(247752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.c
 * JD-Core Version:    0.7.0.1
 */