package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initial", "previewTexture", "beautyParam", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"})
public final class a
{
  static final String TAG = "MicroMsg.LiveFilterProcessTex";
  public static final a.a gKL;
  int gKH;
  d gKI;
  int gKJ;
  int gKK;
  b gtl;
  
  static
  {
    AppMethodBeat.i(216927);
    gKL = new a.a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(216927);
  }
  
  public final void a(int paramInt1, d paramd, int paramInt2)
  {
    boolean bool3 = true;
    AppMethodBeat.i(216925);
    p.h(paramd, "outputTexture");
    for (;;)
    {
      try
      {
        Object localObject = TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt2) });
        if (this.gtl != null)
        {
          ad.w(TAG, "initial xLabEffect: again");
          localObject = this.gtl;
          if (localObject == null) {
            p.gfZ();
          }
          ((b)localObject).destroy();
        }
        this.gtl = new b(0, 0, 1, 8);
        localObject = this.gtl;
        if (localObject == null) {
          p.gfZ();
        }
        ((b)localObject).vB(false);
        boolean bool1;
        if ((paramInt2 & 0x1) != 0)
        {
          bool1 = true;
          break label328;
          ad.i(TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1)
          {
            localObject = this.gtl;
            if (localObject == null) {
              p.gfZ();
            }
            ((b)localObject).eYk();
          }
          if (bool2)
          {
            localObject = this.gtl;
            if (localObject == null) {
              p.gfZ();
            }
            ((b)localObject).eYl();
          }
          if (bool3)
          {
            localObject = this.gtl;
            if (localObject == null) {
              p.gfZ();
            }
            ((b)localObject).vA(true);
          }
          this.gKH = paramInt1;
          this.gKI = paramd;
          ad.d(TAG, "initial end %s", new Object[] { this });
          AppMethodBeat.o(216925);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
        AppMethodBeat.o(216925);
        return;
      }
      boolean bool2 = false;
      break label337;
      bool3 = false;
      continue;
      label328:
      if ((paramInt2 & 0x2) != 0)
      {
        bool2 = true;
        label337:
        if ((paramInt2 & 0x4) == 0) {}
      }
    }
  }
  
  public final void aml()
  {
    AppMethodBeat.i(216926);
    long l = bt.HI();
    try
    {
      Object localObject = this.gtl;
      if (localObject == null) {
        p.gfZ();
      }
      b.a((b)localObject, this.gKH);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
      localObject = this.gKI;
      if (localObject == null) {
        p.gfZ();
      }
      ((d)localObject).a(this.gKJ, this.gKK, 6408, null, 9729, 10497);
      GLES20.glViewport(0, 0, this.gKJ, this.gKK);
      localObject = this.gtl;
      if (localObject == null) {
        p.gfZ();
      }
      int i = this.gKH;
      d locald = this.gKI;
      if (locald == null) {
        p.gfZ();
      }
      b.a((b)localObject, i, locald.hko, false, 40);
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
    ad.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(216926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */