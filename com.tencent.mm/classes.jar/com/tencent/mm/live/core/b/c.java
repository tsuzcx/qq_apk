package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qg;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "scene", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initScene", "initial", "previewTexture", "beautyParam", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterParam", "Lcom/tencent/mm/live/core/render/FilterConfig;", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "setLiveScene", "updateBeautyConfig", "beautyConfig", "updateFilterConfig", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"})
public final class c
{
  static final String TAG = "MicroMsg.LiveFilterProcessTex";
  public static final a kri;
  public e jUF;
  int kre;
  d krf;
  int krg;
  int krh;
  public int scene = -1;
  
  static
  {
    AppMethodBeat.i(200545);
    kri = new a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(200545);
  }
  
  public final void a(int paramInt, d paramd, a parama, b paramb)
  {
    AppMethodBeat.i(200524);
    p.k(paramd, "outputTexture");
    p.k(parama, "beautyParam");
    p.k(paramb, "filterParam");
    try
    {
      Object localObject = TAG;
      Thread localThread = Thread.currentThread();
      p.j(localThread, "Thread.currentThread()");
      Log.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(localThread.getId()), parama });
      if (this.jUF != null)
      {
        Log.w(TAG, "initial xLabEffect: again");
        localObject = this.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((e)localObject).destroy();
      }
      this.jUF = new e(0, 0, 1);
      localObject = this.jUF;
      if (localObject == null) {
        p.iCn();
      }
      ((e)localObject).DH(false);
      a(parama);
      Log.i(TAG, "#initial Beauty ".concat(String.valueOf(parama)));
      boolean bool = paramb.aMK();
      Log.i(TAG, "#initial Filter " + paramb.krc + ", " + paramb.krd);
      if (bool)
      {
        parama = this.jUF;
        if (parama == null) {
          p.iCn();
        }
        parama.n(paramb.krc, paramb.krd / 100.0F);
      }
      this.kre = paramInt;
      this.krf = paramd;
      if (this.scene != -1) {
        tl(this.scene);
      }
      Log.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(200524);
      return;
    }
    catch (Exception paramd)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
      AppMethodBeat.o(200524);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(200540);
    p.k(parama, "beautyConfig");
    boolean bool1 = parama.aMG();
    boolean bool2 = parama.aMH();
    boolean bool3 = parama.aMI();
    boolean bool4 = parama.aMJ();
    Log.i(TAG, "#updateBeautyConfig beautyConfig=" + parama.toString());
    e locale = this.jUF;
    if (locale != null)
    {
      XEffectConfig localXEffectConfig = new XEffectConfig();
      localXEffectConfig.QPt = parama.aMs();
      localXEffectConfig.QPu = parama.aMt();
      localXEffectConfig.QPv = parama.aMu();
      localXEffectConfig.QPw = parama.aMv();
      localXEffectConfig.QPx = parama.aMw();
      localXEffectConfig.yCP = parama.aMx();
      localXEffectConfig.QPy = parama.aMy();
      localXEffectConfig.QPz = parama.aMz();
      localXEffectConfig.QPA = parama.aMA();
      localXEffectConfig.QPB = parama.aMB();
      localXEffectConfig.QPC = parama.aMC();
      localXEffectConfig.QPD = parama.aMD();
      localXEffectConfig.QPE = parama.aME();
      localXEffectConfig.QPF = parama.aMF();
      locale.a(localXEffectConfig);
    }
    if (bool1)
    {
      locale = this.jUF;
      if (locale == null) {
        p.iCn();
      }
      locale.DE(true);
    }
    if (bool2)
    {
      locale = this.jUF;
      if (locale == null) {
        p.iCn();
      }
      locale.DF(true);
    }
    if (bool3)
    {
      locale = this.jUF;
      if (locale == null) {
        p.iCn();
      }
      e.a(locale, true);
    }
    if (bool4)
    {
      locale = this.jUF;
      if (locale == null) {
        p.iCn();
      }
      locale.apl(parama.aMx());
      parama = this.jUF;
      if (parama == null) {
        p.iCn();
      }
      parama.DG(true);
    }
    AppMethodBeat.o(200540);
  }
  
  public final void aML()
  {
    AppMethodBeat.i(200544);
    long l = Util.currentTicks();
    try
    {
      Object localObject = this.jUF;
      if (localObject == null) {
        p.iCn();
      }
      e.a((e)localObject, this.kre);
      localObject = this.krf;
      if (localObject == null) {
        p.iCn();
      }
      ((d)localObject).a(this.krg, this.krh, 6408, null, 9729, 10497);
      localObject = this.jUF;
      if (localObject == null) {
        p.iCn();
      }
      int i = this.kre;
      d locald = this.krf;
      if (locald == null) {
        p.iCn();
      }
      e.a((e)localObject, i, locald.kVj, false, 40);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "filterProcess error", new Object[0]);
      }
    }
    Log.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(200544);
  }
  
  public final void tl(int paramInt)
  {
    AppMethodBeat.i(200527);
    Object localObject = e.g.kkm;
    if (paramInt == e.g.aKs())
    {
      localObject = this.jUF;
      if (localObject != null)
      {
        localObject = ((e)localObject).QPZ;
        if (localObject != null)
        {
          ((qg)localObject).oZ(3);
          AppMethodBeat.o(200527);
          return;
        }
      }
      AppMethodBeat.o(200527);
      return;
    }
    localObject = e.g.kkm;
    if (paramInt == e.g.aKt())
    {
      localObject = this.jUF;
      if (localObject != null)
      {
        localObject = ((e)localObject).QPZ;
        if (localObject != null)
        {
          ((qg)localObject).oZ(0);
          AppMethodBeat.o(200527);
          return;
        }
      }
      AppMethodBeat.o(200527);
      return;
    }
    localObject = this.jUF;
    if (localObject != null)
    {
      localObject = ((e)localObject).QPZ;
      if (localObject != null)
      {
        ((qg)localObject).oZ(-1);
        AppMethodBeat.o(200527);
        return;
      }
    }
    AppMethodBeat.o(200527);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.c
 * JD-Core Version:    0.7.0.1
 */