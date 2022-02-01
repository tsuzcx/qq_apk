package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initial", "previewTexture", "beautyParam", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"})
public final class a
{
  static final String TAG = "MicroMsg.LiveFilterProcessTex";
  public static final a.a grb;
  XLabEffect fZP;
  int gqX;
  d gqY;
  int gqZ;
  int gra;
  
  static
  {
    AppMethodBeat.i(209269);
    grb = new a.a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(209269);
  }
  
  public final void a(int paramInt1, d paramd, int paramInt2)
  {
    AppMethodBeat.i(209267);
    k.h(paramd, "outputTexture");
    for (;;)
    {
      try
      {
        Object localObject = TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ac.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt2) });
        if (this.fZP != null)
        {
          ac.w(TAG, "initial xLabEffect: again");
          localObject = this.fZP;
          if (localObject == null) {
            k.fOy();
          }
          ((XLabEffect)localObject).destroy();
        }
        this.fZP = new XLabEffect(0, 0, 1, false, 8);
        localObject = this.fZP;
        if (localObject == null) {
          k.fOy();
        }
        ((XLabEffect)localObject).uQ(false);
        boolean bool1;
        if ((paramInt2 & 0x1) != 0)
        {
          bool1 = true;
          break label326;
          ac.i(TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1)
          {
            localObject = this.fZP;
            if (localObject == null) {
              k.fOy();
            }
            ((XLabEffect)localObject).eJq();
          }
          if (bool2)
          {
            localObject = this.fZP;
            if (localObject == null) {
              k.fOy();
            }
            ((XLabEffect)localObject).eJr();
          }
          if (bool3)
          {
            localObject = this.fZP;
            if (localObject == null) {
              k.fOy();
            }
            ((XLabEffect)localObject).uP(true);
          }
          this.gqX = paramInt1;
          this.gqY = paramd;
          ac.d(TAG, "initial end %s", new Object[] { this });
          AppMethodBeat.o(209267);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd)
      {
        ac.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
        AppMethodBeat.o(209267);
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
  
  public final void ajz()
  {
    AppMethodBeat.i(209268);
    long l = bs.Gn();
    try
    {
      Object localObject = this.fZP;
      if (localObject == null) {
        k.fOy();
      }
      XLabEffect.a((XLabEffect)localObject, this.gqX);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
      localObject = this.gqY;
      if (localObject == null) {
        k.fOy();
      }
      ((d)localObject).a(this.gqZ, this.gra, 6408, null, 9729, 10497);
      GLES20.glViewport(0, 0, this.gqZ, this.gra);
      localObject = this.fZP;
      if (localObject == null) {
        k.fOy();
      }
      int i = this.gqX;
      d locald = this.gqY;
      if (locald == null) {
        k.fOy();
      }
      XLabEffect.a((XLabEffect)localObject, i, locald.gRW, 0L, false, 40);
      GLES20.glFinish();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace(TAG, (Throwable)localException, "filterProcess error", new Object[0]);
      }
    }
    ac.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(209268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */