package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "removeBg", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker", "", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j
  extends com.tencent.mm.media.j.b.a
  implements k, l
{
  private com.tencent.mm.media.g.d ksA;
  private final int outputHeight;
  private final int outputWidth;
  private boolean uTu;
  private f uVs;
  private com.tencent.mm.plugin.emojicapture.d.a vcn;
  private boolean vco;
  private com.tencent.mm.media.j.b.a vcp;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    this.outputWidth = com.tencent.mm.plugin.emojicapture.model.d.cXp();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    this.outputHeight = com.tencent.mm.plugin.emojicapture.model.d.cXp();
    this.vco = true;
    localObject = b.vbw;
    this.ksA = c.fC(true);
    this.vcp = ((com.tencent.mm.media.j.b.a)new i(this.outputWidth, this.outputHeight, paramInt3, paramInt4));
  }
  
  private final void cYI()
  {
    int j = 0;
    Object localObject = cYD();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).kYx;
      if (localObject != null) {
        i = ((com.tencent.mm.media.g.d)localObject).kVj;
      }
    }
    for (;;)
    {
      if ((this.vcn == null) && (this.vco))
      {
        this.vcn = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.vcn;
        if (localObject != null)
        {
          com.tencent.mm.media.g.d locald = this.ksA;
          if (locald != null) {
            j = locald.kVj;
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).gd(i, j);
        }
        localObject = this.vcn;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).mQ(this.uTu);
        }
        localObject = this.vcn;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).a(this.uVs);
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
    this.uVs = paramf;
    cYI();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.vcn;
    if (locala != null) {
      locala.a(paramf);
    }
  }
  
  public final void aMi()
  {
    this.vco = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.vcn;
    if (locala != null) {
      locala.clear();
    }
    this.vcn = null;
  }
  
  public final void aMj()
  {
    this.vco = true;
  }
  
  public final void aVw()
  {
    int j = 0;
    Object localObject1 = cYD();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).dv(aVx(), aVy());
    }
    localObject1 = cYD();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).tm(aVr());
    }
    localObject1 = cYD();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).kYh = this.kYh;
    }
    localObject1 = cYD();
    int i;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.j.b.a)localObject1).aMU();
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).kYx;
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.media.g.d)localObject1).kVj;
        cYI();
        localObject1 = this.vcn;
        if (localObject1 != null)
        {
          int k = this.outputWidth;
          int m = this.outputHeight;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krg = k;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krh = m;
          localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).jUF;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.xlabeffect.e)localObject2).setSize(k, m);
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).kre = i;
          l = Util.currentTicks();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.emojicapture.d.a)localObject1).uTM)
        {
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).uTL);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).kre, 0);
          localObject2 = b.vbw;
          b.a.ac(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).uTK, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krg, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krh);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).uTK);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krg, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krh, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.ksA;
          i = j;
          if (localObject1 != null) {
            i = ((com.tencent.mm.media.g.d)localObject1).kVj;
          }
          localObject1 = this.vcp;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).ua(i);
          }
          localObject1 = this.vcp;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).aMU();
          }
          return;
          i = -1;
          break;
          i = 0;
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).jUF;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.e.a((com.tencent.mm.plugin.xlabeffect.e)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).kre);
        }
        localObject2 = b.vbw;
        b.a.ac(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).uTK, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krg, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).krh);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).jUF;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.e.a((com.tencent.mm.plugin.xlabeffect.e)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).kre, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).uTK, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
        com.tencent.mm.plugin.emojicapture.model.e locale = com.tencent.mm.plugin.emojicapture.model.e.uUh;
        com.tencent.mm.plugin.emojicapture.model.e.cXF();
        continue;
      }
      Log.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
  }
  
  public abstract com.tencent.mm.media.j.b.a cYD();
  
  public final com.tencent.mm.media.g.d cYH()
  {
    com.tencent.mm.media.j.b.a locala = cYD();
    if (locala != null) {
      return locala.kYx;
    }
    return null;
  }
  
  protected final int getOutputHeight()
  {
    return this.outputHeight;
  }
  
  protected final int getOutputWidth()
  {
    return this.outputWidth;
  }
  
  public final void mQ(boolean paramBoolean)
  {
    this.uTu = paramBoolean;
    cYI();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.vcn;
    if (locala != null) {
      locala.mQ(paramBoolean);
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.ksA;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    localObject = this.vcp;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    localObject = this.vcn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.vcn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */