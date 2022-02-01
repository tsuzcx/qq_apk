package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initial", "previewTexture", "beautyParam", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterParam", "Lcom/tencent/mm/live/core/render/FilterConfig;", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "updateBeautyConfig", "beautyConfig", "updateFilterConfig", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"})
public final class c
{
  static final String TAG = "MicroMsg.LiveFilterProcessTex";
  public static final a hDp;
  int hDl;
  d hDm;
  int hDn;
  int hDo;
  com.tencent.mm.plugin.xlabeffect.b hiH;
  
  static
  {
    AppMethodBeat.i(196618);
    hDp = new a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(196618);
  }
  
  public final void a(int paramInt, d paramd, a parama, b paramb)
  {
    AppMethodBeat.i(196616);
    p.h(paramd, "outputTexture");
    p.h(parama, "beautyParam");
    p.h(paramb, "filterParam");
    try
    {
      Object localObject = TAG;
      Thread localThread = Thread.currentThread();
      p.g(localThread, "Thread.currentThread()");
      Log.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(localThread.getId()), parama });
      if (this.hiH != null)
      {
        Log.w(TAG, "initial xLabEffect: again");
        localObject = this.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.hiH = new com.tencent.mm.plugin.xlabeffect.b(0, 0);
      localObject = this.hiH;
      if (localObject == null) {
        p.hyc();
      }
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).zG(false);
      boolean bool1 = parama.aEr();
      boolean bool2 = parama.aEs();
      boolean bool3 = paramb.aEv();
      boolean bool4 = parama.aEt();
      boolean bool5 = parama.aEu();
      Log.i(TAG, "initial, needSkin:" + bool1 + ", needShape:" + bool2 + ", needBright:" + bool4 + ", needFilter:" + bool3 + ", needRosy:" + bool5 + " [" + parama.aEl() + ", " + parama.aEm() + ", " + parama.aEn() + ", " + parama.aEo() + ", " + parama.aEp() + ", " + parama.aEq() + ", " + paramb.hDj + ", " + paramb.hDk + ']');
      localObject = this.hiH;
      if (localObject == null) {
        p.hyc();
      }
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).l(parama.aEl(), parama.aEm(), parama.aEn(), parama.aEo(), parama.aEp());
      if (bool1)
      {
        localObject = this.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).gli();
      }
      if (bool2)
      {
        localObject = this.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).glk();
      }
      if (bool4)
      {
        localObject = this.hiH;
        if (localObject == null) {
          p.hyc();
        }
        com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject);
      }
      if (bool3)
      {
        localObject = this.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).m(paramb.hDj, paramb.hDk / 100.0F);
      }
      if (bool5)
      {
        paramb = this.hiH;
        if (paramb == null) {
          p.hyc();
        }
        paramb.ahu(parama.aEq());
        parama = this.hiH;
        if (parama == null) {
          p.hyc();
        }
        parama.glm();
      }
      this.hDl = paramInt;
      this.hDm = paramd;
      Log.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(196616);
      return;
    }
    catch (Exception paramd)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
      AppMethodBeat.o(196616);
    }
  }
  
  public final void aEw()
  {
    AppMethodBeat.i(196617);
    long l = Util.currentTicks();
    try
    {
      Object localObject = this.hiH;
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, this.hDl);
      localObject = this.hDm;
      if (localObject == null) {
        p.hyc();
      }
      ((d)localObject).a(this.hDn, this.hDo, 6408, null, 9729, 10497);
      localObject = this.hiH;
      if (localObject == null) {
        p.hyc();
      }
      int i = this.hDl;
      d locald = this.hDm;
      if (locald == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject, i, locald.igv, false, 40);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)localException, "filterProcess error", new Object[0]);
      }
    }
    Log.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(196617);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.c
 * JD-Core Version:    0.7.0.1
 */