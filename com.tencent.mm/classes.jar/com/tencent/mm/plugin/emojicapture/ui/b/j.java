package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.f.c;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j
  extends com.tencent.mm.media.i.b.a
  implements k, l
{
  final int gtF;
  final int gtG;
  private com.tencent.mm.media.f.d oSo;
  private com.tencent.mm.plugin.emojicapture.d.a oSp;
  private boolean oSq;
  private com.tencent.mm.media.i.b.a oSr;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    this.gtF = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    this.gtG = com.tencent.mm.plugin.emojicapture.model.d.bXy();
    this.oSq = true;
    localObject = b.oRy;
    this.oSo = c.dF(true);
    this.oSr = ((com.tencent.mm.media.i.b.a)new i(this.gtF, this.gtG, paramInt3, paramInt4));
  }
  
  private final void bYT()
  {
    int j = 0;
    Object localObject = bYM();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.i.b.a)localObject).guU;
      if (localObject != null) {
        i = ((com.tencent.mm.media.f.d)localObject).gro;
      }
    }
    for (;;)
    {
      if ((this.oSp == null) && (this.oSq))
      {
        this.oSp = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.oSp;
        if (localObject != null)
        {
          com.tencent.mm.media.f.d locald = this.oSo;
          if (locald != null) {
            j = locald.gro;
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fi(i, j);
        }
      }
      return;
      i = -1;
      continue;
      i = 0;
    }
  }
  
  public final void a(com.tencent.mm.sticker.e parame)
  {
    Object localObject2 = null;
    bYT();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.oSp;
    String str;
    if (locala != null)
    {
      str = com.tencent.mm.plugin.emojicapture.d.a.TAG;
      StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(locala.oJp).append(", ");
      if (parame == null) {
        break label129;
      }
      localObject1 = parame.oJp;
      ad.i(str, (String)localObject1);
      str = locala.oJp;
      if (parame == null) {
        break label134;
      }
    }
    label129:
    label134:
    for (Object localObject1 = parame.oJp;; localObject1 = null)
    {
      if ((d.g.b.k.g(str, localObject1) ^ true))
      {
        localObject1 = localObject2;
        if (parame != null) {
          localObject1 = parame.oJp;
        }
        locala.oJp = ((String)localObject1);
        localObject1 = locala.fVU;
        if (localObject1 != null) {
          ((XLabEffect)localObject1).a(parame);
        }
      }
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void akv()
  {
    int j = 0;
    Object localObject1 = bYM();
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).cS(this.guI, this.guJ);
    }
    localObject1 = bYM();
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).mz(this.guD);
    }
    localObject1 = bYM();
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).guE = this.guE;
    }
    localObject1 = bYM();
    int i;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.i.b.a)localObject1).akk();
      localObject1 = ((com.tencent.mm.media.i.b.a)localObject1).guU;
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.media.f.d)localObject1).gro;
        bYT();
        localObject1 = this.oSp;
        if (localObject1 != null)
        {
          int k = this.gtF;
          int m = this.gtG;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guI = k;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guJ = m;
          localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).fVU;
          if (localObject2 != null) {
            ((XLabEffect)localObject2).setSize(k, m);
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guC = i;
          l = bt.GC();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.emojicapture.d.a)localObject1).oJD)
        {
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).oJC);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guC, 0);
          localObject2 = b.oRy;
          b.a.X(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).oJB, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guI, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guJ);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).oJB);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guI, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guJ, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.oSo;
          i = j;
          if (localObject1 != null) {
            i = ((com.tencent.mm.media.f.d)localObject1).gro;
          }
          localObject1 = this.oSr;
          if (localObject1 != null) {
            ((com.tencent.mm.media.i.b.a)localObject1).mA(i);
          }
          localObject1 = this.oSr;
          if (localObject1 != null) {
            ((com.tencent.mm.media.i.b.a)localObject1).akk();
          }
          return;
          i = -1;
          break;
          i = 0;
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).fVU;
        if (localObject2 != null) {
          XLabEffect.a((XLabEffect)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guC);
        }
        localObject2 = b.oRy;
        b.a.X(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).oJB, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guI, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guJ);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).fVU;
        if (localObject2 != null) {
          XLabEffect.a((XLabEffect)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).guC, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).oJB, 0L, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
        com.tencent.mm.plugin.emojicapture.model.e locale = com.tencent.mm.plugin.emojicapture.model.e.oKa;
        com.tencent.mm.plugin.emojicapture.model.e.bXO();
        continue;
      }
      ad.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bt.aS(l)) });
    }
  }
  
  public abstract com.tencent.mm.media.i.b.a bYM();
  
  public final void bYR()
  {
    this.oSq = true;
  }
  
  public final void bYS()
  {
    this.oSq = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.oSp;
    if (locala != null) {
      locala.clear();
    }
    this.oSp = null;
  }
  
  public final com.tencent.mm.media.f.d fRl()
  {
    com.tencent.mm.media.i.b.a locala = bYM();
    if (locala != null) {
      return locala.guU;
    }
    return null;
  }
  
  public final void jW(boolean paramBoolean)
  {
    bYT();
    Object localObject = this.oSp;
    if (localObject != null)
    {
      ad.i(com.tencent.mm.plugin.emojicapture.d.a.TAG, "setRemoveBg: ".concat(String.valueOf(paramBoolean)));
      localObject = ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).tP(paramBoolean);
      }
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.oSo;
    if (localObject != null) {
      ((com.tencent.mm.media.f.d)localObject).close();
    }
    localObject = this.oSr;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).release();
    }
    localObject = this.oSp;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.oSp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */