package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/LiveFilterProcessTex;", "", "()V", "inputTexture", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "clear", "", "filterProcess", "initial", "previewTexture", "beautyParam", "setInputTexture", "texture", "setInputTexture$plugin_core_release", "updateOutputTexture", "updateTextureSize", "Companion", "plugin-core_release"})
public final class a
{
  static final String TAG = "MicroMsg.LiveFilterProcessTex";
  public static final a.a gNu;
  int gNq;
  d gNr;
  int gNs;
  int gNt;
  b gvS;
  
  static
  {
    AppMethodBeat.i(196939);
    gNu = new a.a((byte)0);
    TAG = "MicroMsg.LiveFilterProcessTex";
    AppMethodBeat.o(196939);
  }
  
  public final void a(int paramInt1, d paramd, int paramInt2)
  {
    boolean bool3 = true;
    AppMethodBeat.i(196937);
    p.h(paramd, "outputTexture");
    for (;;)
    {
      try
      {
        Object localObject = TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ae.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt2) });
        if (this.gvS != null)
        {
          ae.w(TAG, "initial xLabEffect: again");
          localObject = this.gvS;
          if (localObject == null) {
            p.gkB();
          }
          ((b)localObject).destroy();
        }
        this.gvS = new b(0, 0, 1, 8);
        localObject = this.gvS;
        if (localObject == null) {
          p.gkB();
        }
        ((b)localObject).vJ(false);
        boolean bool1;
        if ((paramInt2 & 0x1) != 0)
        {
          bool1 = true;
          break label328;
          ae.i(TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1)
          {
            localObject = this.gvS;
            if (localObject == null) {
              p.gkB();
            }
            ((b)localObject).fbW();
          }
          if (bool2)
          {
            localObject = this.gvS;
            if (localObject == null) {
              p.gkB();
            }
            ((b)localObject).fbX();
          }
          if (bool3)
          {
            localObject = this.gvS;
            if (localObject == null) {
              p.gkB();
            }
            b.a((b)localObject, true);
          }
          this.gNq = paramInt1;
          this.gNr = paramd;
          ae.d(TAG, "initial end %s", new Object[] { this });
          AppMethodBeat.o(196937);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd)
      {
        ae.printErrStackTrace(TAG, (Throwable)paramd, "initial error", new Object[0]);
        AppMethodBeat.o(196937);
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
  
  public final void amA()
  {
    AppMethodBeat.i(196938);
    long l = bu.HQ();
    try
    {
      Object localObject = this.gvS;
      if (localObject == null) {
        p.gkB();
      }
      b.a((b)localObject, this.gNq);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
      localObject = this.gNr;
      if (localObject == null) {
        p.gkB();
      }
      ((d)localObject).a(this.gNs, this.gNt, 6408, null, 9729, 10497);
      GLES20.glViewport(0, 0, this.gNs, this.gNt);
      localObject = this.gvS;
      if (localObject == null) {
        p.gkB();
      }
      int i = this.gNq;
      d locald = this.gNr;
      if (locald == null) {
        p.gkB();
      }
      b.a((b)localObject, i, locald.hnc, false, 40);
      GLES20.glFinish();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glBindTexture(3553, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(TAG, (Throwable)localException, "filterProcess error", new Object[0]);
      }
    }
    ae.d(TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(196938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.a
 * JD-Core Version:    0.7.0.1
 */