package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.g.c;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "removeBg", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "changeSticker", "", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j
  extends com.tencent.mm.media.j.b.a
  implements k, l
{
  private com.tencent.mm.media.g.d hEv;
  final int outputHeight;
  final int outputWidth;
  private boolean rnN;
  private f rpM;
  private com.tencent.mm.plugin.emojicapture.d.a rwH;
  private boolean rwI;
  private com.tencent.mm.media.j.b.a rwJ;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
    this.outputWidth = com.tencent.mm.plugin.emojicapture.model.d.cIG();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.roA;
    this.outputHeight = com.tencent.mm.plugin.emojicapture.model.d.cIG();
    this.rwI = true;
    localObject = b.rvS;
    this.hEv = c.eV(true);
    this.rwJ = ((com.tencent.mm.media.j.b.a)new i(this.outputWidth, this.outputHeight, paramInt3, paramInt4));
  }
  
  private final void cJY()
  {
    int j = 0;
    Object localObject = cJT();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.j.b.a)localObject).ijD;
      if (localObject != null) {
        i = ((com.tencent.mm.media.g.d)localObject).igv;
      }
    }
    for (;;)
    {
      if ((this.rwH == null) && (this.rwI))
      {
        this.rwH = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.rwH;
        if (localObject != null)
        {
          com.tencent.mm.media.g.d locald = this.hEv;
          if (locald != null) {
            j = locald.igv;
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fG(i, j);
        }
        localObject = this.rwH;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).lF(this.rnN);
        }
        localObject = this.rwH;
        if (localObject != null) {
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).a(this.rpM);
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
    this.rpM = paramf;
    cJY();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.rwH;
    if (locala != null) {
      locala.a(paramf);
    }
  }
  
  public final void aEa()
  {
    this.rwI = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.rwH;
    if (locala != null) {
      locala.clear();
    }
    this.rwH = null;
  }
  
  public final void aEb()
  {
    this.rwI = true;
  }
  
  public final void aMV()
  {
    int j = 0;
    Object localObject1 = cJT();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).cZ(this.hDn, this.hDo);
    }
    localObject1 = cJT();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).qx(this.ijt);
    }
    localObject1 = cJT();
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).iju = this.iju;
    }
    localObject1 = cJT();
    int i;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.j.b.a)localObject1).aED();
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).ijD;
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.media.g.d)localObject1).igv;
        cJY();
        localObject1 = this.rwH;
        if (localObject1 != null)
        {
          int k = this.outputWidth;
          int m = this.outputHeight;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDn = k;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDo = m;
          localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hiH;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(k, m);
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDl = i;
          l = Util.currentTicks();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.emojicapture.d.a)localObject1).rof)
        {
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).roe);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDl, 0);
          localObject2 = b.rvS;
          b.a.ab(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).rod, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDn, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDo);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).rod);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDn, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDo, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.hEv;
          i = j;
          if (localObject1 != null) {
            i = ((com.tencent.mm.media.g.d)localObject1).igv;
          }
          localObject1 = this.rwJ;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).rl(i);
          }
          localObject1 = this.rwJ;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).aED();
          }
          return;
          i = -1;
          break;
          i = 0;
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hiH;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDl);
        }
        localObject2 = b.rvS;
        b.a.ab(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).rod, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDn, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDo);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hiH;
        if (localObject2 != null) {
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).hDl, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).rod, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
        e locale = e.roB;
        e.cIW();
        continue;
      }
      Log.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
  }
  
  public abstract com.tencent.mm.media.j.b.a cJT();
  
  public final com.tencent.mm.media.g.d cJX()
  {
    com.tencent.mm.media.j.b.a locala = cJT();
    if (locala != null) {
      return locala.ijD;
    }
    return null;
  }
  
  public final void lF(boolean paramBoolean)
  {
    this.rnN = paramBoolean;
    cJY();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.rwH;
    if (locala != null) {
      locala.lF(paramBoolean);
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.hEv;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    localObject = this.rwJ;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    localObject = this.rwH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.rwH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */