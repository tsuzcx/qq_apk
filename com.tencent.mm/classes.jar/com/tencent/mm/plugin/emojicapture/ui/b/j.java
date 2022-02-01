package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.g.c;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.f;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "removeBg", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker", "", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j
  extends com.tencent.mm.media.j.b.a
  implements k, l
{
  private com.tencent.mm.media.g.d gLJ;
  final int outputHeight;
  final int outputWidth;
  private boolean pQj;
  private f pSk;
  private com.tencent.mm.plugin.emojicapture.d.a pZf;
  private boolean pZg;
  private com.tencent.mm.media.j.b.a pZh;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    this.outputWidth = com.tencent.mm.plugin.emojicapture.model.d.cjo();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    this.outputHeight = com.tencent.mm.plugin.emojicapture.model.d.cjo();
    this.pZg = true;
    localObject = b.pYp;
    this.gLJ = c.ec(true);
    this.pZh = ((com.tencent.mm.media.j.b.a)new i(this.outputWidth, this.outputHeight, paramInt3, paramInt4));
  }
  
  private final void ckG()
  {
    int j = 0;
    Object localObject = ckB();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).hnu;
      if (localObject != null) {
        i = ((com.tencent.mm.media.g.d)localObject).hko;
      }
    }
    for (;;)
    {
      if ((this.pZf == null) && (this.pZg))
      {
        this.pZf = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.pZf;
        if (localObject != null)
        {
          com.tencent.mm.media.g.d locald = this.gLJ;
          if (locald != null) {
            j = locald.hko;
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fp(i, j);
        }
        localObject = this.pZf;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).kL(this.pQj);
        }
        localObject = this.pZf;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).a(this.pSk);
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
    this.pSk = paramf;
    ckG();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.pZf;
    if (locala != null) {
      locala.a(paramf);
    }
  }
  
  public final void amf()
  {
    this.pZg = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.pZf;
    if (locala != null) {
      locala.clear();
    }
    this.pZf = null;
  }
  
  public final void amg()
  {
    this.pZg = true;
  }
  
  public final void aue()
  {
    int j = 0;
    Object localObject1 = ckB();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).cU(this.gKJ, this.gKK);
    }
    localObject1 = ckB();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).nd(this.hnk);
    }
    localObject1 = ckB();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).hnl = this.hnl;
    }
    localObject1 = ckB();
    int i;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.j.b.a)localObject1).ams();
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).hnu;
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.media.g.d)localObject1).hko;
        ckG();
        localObject1 = this.pZf;
        if (localObject1 != null)
        {
          int k = this.outputWidth;
          int m = this.outputHeight;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKJ = k;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKK = m;
          localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gtl;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(k, m);
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKH = i;
          l = bt.HI();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pQB)
        {
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pQA);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKH, 0);
          localObject2 = b.pYp;
          b.a.aa(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pQz, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKJ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKK);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pQz);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKJ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKK, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.gLJ;
          i = j;
          if (localObject1 != null) {
            i = ((com.tencent.mm.media.g.d)localObject1).hko;
          }
          localObject1 = this.pZh;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).nN(i);
          }
          localObject1 = this.pZh;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).ams();
          }
          return;
          i = -1;
          break;
          i = 0;
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gtl;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKH);
        }
        localObject2 = b.pYp;
        b.a.aa(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pQz, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKJ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKK);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gtl;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gKH, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pQz, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
        e locale = e.pQY;
        e.cjE();
        continue;
      }
      ad.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bt.aO(l)) });
    }
  }
  
  public abstract com.tencent.mm.media.j.b.a ckB();
  
  public final com.tencent.mm.media.g.d ckF()
  {
    com.tencent.mm.media.j.b.a locala = ckB();
    if (locala != null) {
      return locala.hnu;
    }
    return null;
  }
  
  public final void kL(boolean paramBoolean)
  {
    this.pQj = paramBoolean;
    ckG();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.pZf;
    if (locala != null) {
      locala.kL(paramBoolean);
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.gLJ;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    localObject = this.pZh;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    localObject = this.pZf;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.pZf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */