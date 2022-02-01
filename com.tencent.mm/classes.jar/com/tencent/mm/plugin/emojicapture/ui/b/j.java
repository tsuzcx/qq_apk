package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.g.c;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sticker.f;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "removeBg", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker", "", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j
  extends com.tencent.mm.media.j.b.a
  implements k, l
{
  private com.tencent.mm.media.g.d gOs;
  final int outputHeight;
  final int outputWidth;
  private boolean pWO;
  private f pYP;
  private com.tencent.mm.plugin.emojicapture.d.a qfK;
  private boolean qfL;
  private com.tencent.mm.media.j.b.a qfM;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    this.outputWidth = com.tencent.mm.plugin.emojicapture.model.d.ckE();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    this.outputHeight = com.tencent.mm.plugin.emojicapture.model.d.ckE();
    this.qfL = true;
    localObject = b.qeU;
    this.gOs = c.ee(true);
    this.qfM = ((com.tencent.mm.media.j.b.a)new i(this.outputWidth, this.outputHeight, paramInt3, paramInt4));
  }
  
  private final void clW()
  {
    int j = 0;
    Object localObject = clR();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).hqi;
      if (localObject != null) {
        i = ((com.tencent.mm.media.g.d)localObject).hnc;
      }
    }
    for (;;)
    {
      if ((this.qfK == null) && (this.qfL))
      {
        this.qfK = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.qfK;
        if (localObject != null)
        {
          com.tencent.mm.media.g.d locald = this.gOs;
          if (locald != null) {
            j = locald.hnc;
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fq(i, j);
        }
        localObject = this.qfK;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).kD(this.pWO);
        }
        localObject = this.qfK;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).a(this.pYP);
        }
      }
      return;
      i = -1;
      continue;
      i = 0;
    }
  }
  
  public final void a(f paramf)
  {
    this.pYP = paramf;
    clW();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.qfK;
    if (locala != null) {
      locala.a(paramf);
    }
  }
  
  public final void amu()
  {
    this.qfL = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.qfK;
    if (locala != null) {
      locala.clear();
    }
    this.qfK = null;
  }
  
  public final void amv()
  {
    this.qfL = true;
  }
  
  public final void aut()
  {
    int j = 0;
    Object localObject1 = clR();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).cU(this.gNs, this.gNt);
    }
    localObject1 = clR();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).ng(this.hpY);
    }
    localObject1 = clR();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).hpZ = this.hpZ;
    }
    localObject1 = clR();
    int i;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.j.b.a)localObject1).amH();
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).hqi;
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.media.g.d)localObject1).hnc;
        clW();
        localObject1 = this.qfK;
        if (localObject1 != null)
        {
          int k = this.outputWidth;
          int m = this.outputHeight;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNs = k;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNt = m;
          localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gvS;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(k, m);
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNq = i;
          l = bu.HQ();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pXg)
        {
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pXf);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNq, 0);
          localObject2 = b.qeU;
          b.a.aa(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pXe, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNs, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNt);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pXe);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNs, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNt, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.gOs;
          i = j;
          if (localObject1 != null) {
            i = ((com.tencent.mm.media.g.d)localObject1).hnc;
          }
          localObject1 = this.qfM;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).nQ(i);
          }
          localObject1 = this.qfM;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).amH();
          }
          return;
          i = -1;
          break;
          i = 0;
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gvS;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNq);
        }
        localObject2 = b.qeU;
        b.a.aa(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pXe, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNs, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNt);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gvS;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gNq, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pXe, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
        e locale = e.pXD;
        e.ckU();
        continue;
      }
      ae.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bu.aO(l)) });
    }
  }
  
  public abstract com.tencent.mm.media.j.b.a clR();
  
  public final com.tencent.mm.media.g.d clV()
  {
    com.tencent.mm.media.j.b.a locala = clR();
    if (locala != null) {
      return locala.hqi;
    }
    return null;
  }
  
  public final void kD(boolean paramBoolean)
  {
    this.pWO = paramBoolean;
    clW();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.qfK;
    if (locala != null) {
      locala.kD(paramBoolean);
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.gOs;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    localObject = this.qfM;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    localObject = this.qfK;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.qfK = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */