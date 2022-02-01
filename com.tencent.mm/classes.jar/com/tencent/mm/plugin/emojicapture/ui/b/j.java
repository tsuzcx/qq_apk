package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.g.c;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "removeBg", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker", "", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class j
  extends com.tencent.mm.media.j.b.a
  implements k, l
{
  private com.tencent.mm.media.g.d mWs;
  private final int outputHeight;
  private final int outputWidth;
  private boolean ygj;
  private f yhU;
  private com.tencent.mm.plugin.emojicapture.d.a yog;
  private boolean yoh;
  private com.tencent.mm.media.j.b.a yoi;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    this.outputWidth = com.tencent.mm.plugin.emojicapture.model.d.dDF();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    this.outputHeight = com.tencent.mm.plugin.emojicapture.model.d.dDF();
    this.yoh = true;
    localObject = b.ynr;
    this.mWs = c.gm(true);
    this.yoi = ((com.tencent.mm.media.j.b.a)new i(this.outputWidth, this.outputHeight, paramInt3, paramInt4));
  }
  
  private final void dEZ()
  {
    int j = 0;
    Object localObject = dEU();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).nDF;
      if (localObject == null) {
        i = -1;
      }
    }
    for (;;)
    {
      com.tencent.mm.media.g.d locald;
      if ((this.yog == null) && (this.yoh))
      {
        this.yog = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.yog;
        if (localObject != null)
        {
          locald = this.mWs;
          if (locald != null) {
            break label116;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.emojicapture.d.a)localObject).gW(i, j);
        localObject = this.yog;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).op(this.ygj);
        }
        localObject = this.yog;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).a(this.yhU);
        }
        return;
        i = ((com.tencent.mm.media.g.d)localObject).nAF;
        break;
        label116:
        j = locald.nAF;
      }
      i = 0;
    }
  }
  
  public final void a(f paramf)
  {
    this.yhU = paramf;
    dEZ();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.yog;
    if (locala != null) {
      locala.a(paramf);
    }
  }
  
  public final void bfH()
  {
    this.yoh = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.yog;
    if (locala != null) {
      locala.clear();
    }
    this.yog = null;
  }
  
  public final void bfI()
  {
    this.yoh = true;
  }
  
  public final void bqg()
  {
    int j = 0;
    Object localObject1 = dEU();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).el(bpT(), bpU());
    }
    localObject1 = dEU();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).th(this.nDr);
    }
    localObject1 = dEU();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).gr(bqb());
    }
    localObject1 = dEU();
    int i;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.j.b.a)localObject1).bgE();
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).nDF;
      if (localObject1 == null) {
        i = -1;
      }
    }
    for (;;)
    {
      dEZ();
      localObject1 = this.yog;
      Object localObject2;
      long l;
      if (localObject1 != null)
      {
        int k = this.outputWidth;
        int m = this.outputHeight;
        ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVd = k;
        ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVe = m;
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).muW;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.xlabeffect.k)localObject2).setSize(k, m);
        }
        ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVb = i;
        l = Util.currentTicks();
      }
      for (;;)
      {
        try
        {
          if (((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ygC) {
            continue;
          }
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ygB);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVb, 0);
          localObject2 = b.ynr;
          b.a.at(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ygA, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVd, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVe);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ygA);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVd, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVe, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.mWs;
          if (localObject1 != null) {
            continue;
          }
          i = j;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
          e locale = e.ygT;
          e.dDV();
          continue;
          i = locale.nAF;
          continue;
        }
        localObject1 = this.yoi;
        if (localObject1 != null) {
          ((com.tencent.mm.media.j.b.a)localObject1).uc(i);
        }
        localObject1 = this.yoi;
        if (localObject1 != null) {
          ((com.tencent.mm.media.j.b.a)localObject1).bgE();
        }
        return;
        i = ((com.tencent.mm.media.g.d)localObject1).nAF;
        break;
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).muW;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.k.a((com.tencent.mm.plugin.xlabeffect.k)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVb);
        }
        localObject2 = b.ynr;
        b.a.at(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ygA, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVd, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVe);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).muW;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.k.a((com.tencent.mm.plugin.xlabeffect.k)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).mVb, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).ygA, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        Log.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      i = 0;
    }
  }
  
  public abstract com.tencent.mm.media.j.b.a dEU();
  
  public final com.tencent.mm.media.g.d dEY()
  {
    com.tencent.mm.media.j.b.a locala = dEU();
    if (locala == null) {
      return null;
    }
    return locala.nDF;
  }
  
  protected final int getOutputHeight()
  {
    return this.outputHeight;
  }
  
  protected final int getOutputWidth()
  {
    return this.outputWidth;
  }
  
  public final void op(boolean paramBoolean)
  {
    this.ygj = paramBoolean;
    dEZ();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.yog;
    if (locala != null) {
      locala.op(paramBoolean);
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.mWs;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    localObject = this.yoi;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    localObject = this.yog;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.yog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */