package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initial", "previewTexture", "beautyParam", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "updateTextureSize", "Companion", "plugin-core_release"})
public final class a
{
  static final String TAG = "MicroMsg.LiveFilterProcessTex";
  public static final a qPv;
  XLabEffect fVU;
  int guC;
  int guI;
  int guJ;
  d zwE;
  
  static
  {
    AppMethodBeat.i(205733);
    qPv = new a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(205733);
  }
  
  public final void a(int paramInt1, d paramd, int paramInt2)
  {
    AppMethodBeat.i(205731);
    k.h(paramd, "outputTexture");
    for (;;)
    {
      try
      {
        Object localObject = TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt2) });
        if (this.fVU != null)
        {
          ad.w(TAG, "initial xLabEffect: again");
          localObject = this.fVU;
          if (localObject == null) {
            k.fvU();
          }
          ((XLabEffect)localObject).destroy();
        }
        this.fVU = new XLabEffect(0, 0, 1, false, 8);
        localObject = this.fVU;
        if (localObject == null) {
          k.fvU();
        }
        ((XLabEffect)localObject).tP(false);
        boolean bool1;
        if ((paramInt2 & 0x1) != 0)
        {
          bool1 = true;
          break label326;
          ad.i(TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1)
          {
            localObject = this.fVU;
            if (localObject == null) {
              k.fvU();
            }
            ((XLabEffect)localObject).etX();
          }
          if (bool2)
          {
            localObject = this.fVU;
            if (localObject == null) {
              k.fvU();
            }
            ((XLabEffect)localObject).etY();
          }
          if (bool3)
          {
            localObject = this.fVU;
            if (localObject == null) {
              k.fvU();
            }
            ((XLabEffect)localObject).tO(true);
          }
          this.guC = paramInt1;
          this.zwE = paramd;
          ad.d(TAG, "initial end %s", new Object[] { this });
          AppMethodBeat.o(205731);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
        AppMethodBeat.o(205731);
        return;
      }
      boolean bool2 = false;
      break label335;
      boolean bool3 = false;
      continue;
      label326:
      if ((paramInt2 & 0x2) != 0)
      {
        bool2 = true;
        label335:
        if ((paramInt2 & 0x4) != 0) {
          bool3 = true;
        }
      }
    }
  }
  
  public final void cta()
  {
    AppMethodBeat.i(205732);
    long l = bt.GC();
    try
    {
      Object localObject = this.fVU;
      if (localObject == null) {
        k.fvU();
      }
      XLabEffect.a((XLabEffect)localObject, this.guC);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
      localObject = this.zwE;
      if (localObject == null) {
        k.fvU();
      }
      ((d)localObject).a(this.guI, this.guJ, 6408, null, 9729, 10497);
      GLES20.glViewport(0, 0, this.guI, this.guJ);
      localObject = this.fVU;
      if (localObject == null) {
        k.fvU();
      }
      int i = this.guC;
      d locald = this.zwE;
      if (locald == null) {
        k.fvU();
      }
      XLabEffect.a((XLabEffect)localObject, i, locald.gro, 0L, false, 40);
      GLES20.glFinish();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)localException, "filterProcess error", new Object[0]);
      }
    }
    ad.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(205732);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */