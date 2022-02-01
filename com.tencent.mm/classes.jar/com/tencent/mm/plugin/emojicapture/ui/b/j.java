package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.tencent.mm.media.f.c;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sticker.f;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCaptureRender;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/IEmojiCapturePreviewRender;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "emojiFilterProcessTex", "Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "enableEffect", "", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputHeight", "getOutputHeight", "()I", "outputProc", "outputWidth", "getOutputWidth", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkInitEffect", "getInputRenderProc", "getRecordTexture", "pauseRender", "release", "renderImpl", "resumeRender", "setRemoveBg", "remove", "plugin-emojicapture_release"})
public abstract class j
  extends com.tencent.mm.media.i.b.a
  implements k, l
{
  final int grA;
  final int grB;
  private com.tencent.mm.media.f.d gsb;
  private com.tencent.mm.plugin.emojicapture.d.a pvA;
  private boolean pvB;
  private com.tencent.mm.media.i.b.a pvC;
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    this.grA = com.tencent.mm.plugin.emojicapture.model.d.ceL();
    localObject = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    this.grB = com.tencent.mm.plugin.emojicapture.model.d.ceL();
    this.pvB = true;
    localObject = b.puK;
    this.gsb = c.ea(true);
    this.pvC = ((com.tencent.mm.media.i.b.a)new i(this.grA, this.grB, paramInt3, paramInt4));
  }
  
  private final void cgc()
  {
    int j = 0;
    Object localObject = cfX();
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.i.b.a)localObject).gVr;
      if (localObject != null) {
        i = ((com.tencent.mm.media.f.d)localObject).gRW;
      }
    }
    for (;;)
    {
      if ((this.pvA == null) && (this.pvB))
      {
        this.pvA = new com.tencent.mm.plugin.emojicapture.d.a();
        localObject = this.pvA;
        if (localObject != null)
        {
          com.tencent.mm.media.f.d locald = this.gsb;
          if (locald != null) {
            j = locald.gRW;
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fl(i, j);
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
    Object localObject2 = null;
    cgc();
    com.tencent.mm.plugin.emojicapture.d.a locala = this.pvA;
    String str;
    if (locala != null)
    {
      str = com.tencent.mm.plugin.emojicapture.d.a.TAG;
      StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(locala.pmO).append(", ");
      if (paramf == null) {
        break label129;
      }
      localObject1 = paramf.pmO;
      ac.i(str, (String)localObject1);
      str = locala.pmO;
      if (paramf == null) {
        break label134;
      }
    }
    label129:
    label134:
    for (Object localObject1 = paramf.pmO;; localObject1 = null)
    {
      if ((d.g.b.k.g(str, localObject1) ^ true))
      {
        localObject1 = localObject2;
        if (paramf != null) {
          localObject1 = paramf.pmO;
        }
        locala.pmO = ((String)localObject1);
        localObject1 = locala.fZP;
        if (localObject1 != null) {
          ((XLabEffect)localObject1).a(paramf);
        }
      }
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void ajt()
  {
    this.pvB = false;
    com.tencent.mm.plugin.emojicapture.d.a locala = this.pvA;
    if (locala != null) {
      locala.clear();
    }
    this.pvA = null;
  }
  
  public final void aju()
  {
    this.pvB = true;
  }
  
  public final void arr()
  {
    int j = 0;
    Object localObject1 = cfX();
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).cS(this.gqZ, this.gra);
    }
    localObject1 = cfX();
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).mE(this.gVh);
    }
    localObject1 = cfX();
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).gVi = this.gVi;
    }
    localObject1 = cfX();
    int i;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      ((com.tencent.mm.media.i.b.a)localObject1).ajG();
      localObject1 = ((com.tencent.mm.media.i.b.a)localObject1).gVr;
      if (localObject1 != null)
      {
        i = ((com.tencent.mm.media.f.d)localObject1).gRW;
        cgc();
        localObject1 = this.pvA;
        if (localObject1 != null)
        {
          int k = this.grA;
          int m = this.grB;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqZ = k;
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gra = m;
          localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).fZP;
          if (localObject2 != null) {
            ((XLabEffect)localObject2).setSize(k, m);
          }
          ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqX = i;
          l = bs.Gn();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pnb)
        {
          GLES20.glBindFramebuffer(36160, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pna);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqX, 0);
          localObject2 = b.puK;
          b.a.Y(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pmZ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqZ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gra);
          GLES20.glBindTexture(3553, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pmZ);
          GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqZ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gra, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          localObject1 = this.gsb;
          i = j;
          if (localObject1 != null) {
            i = ((com.tencent.mm.media.f.d)localObject1).gRW;
          }
          localObject1 = this.pvC;
          if (localObject1 != null) {
            ((com.tencent.mm.media.i.b.a)localObject1).no(i);
          }
          localObject1 = this.pvC;
          if (localObject1 != null) {
            ((com.tencent.mm.media.i.b.a)localObject1).ajG();
          }
          return;
          i = -1;
          break;
          i = 0;
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).fZP;
        if (localObject2 != null) {
          XLabEffect.a((XLabEffect)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqX);
        }
        localObject2 = b.puK;
        b.a.Y(((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pmZ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqZ, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gra);
        localObject2 = ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).fZP;
        if (localObject2 != null) {
          XLabEffect.a((XLabEffect)localObject2, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).gqX, ((com.tencent.mm.plugin.emojicapture.d.a)localObject1).pmZ, 0L, false, 60);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(com.tencent.mm.plugin.emojicapture.d.a.TAG, (Throwable)localException, "filterProcess error", new Object[0]);
        e locale = e.pny;
        e.cfb();
        continue;
      }
      ac.d(com.tencent.mm.plugin.emojicapture.d.a.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bs.aO(l)) });
    }
  }
  
  public abstract com.tencent.mm.media.i.b.a cfX();
  
  public final com.tencent.mm.media.f.d cgb()
  {
    com.tencent.mm.media.i.b.a locala = cfX();
    if (locala != null) {
      return locala.gVr;
    }
    return null;
  }
  
  public final void kA(boolean paramBoolean)
  {
    cgc();
    Object localObject = this.pvA;
    if (localObject != null)
    {
      ac.i(com.tencent.mm.plugin.emojicapture.d.a.TAG, "setRemoveBg: ".concat(String.valueOf(paramBoolean)));
      localObject = ((com.tencent.mm.plugin.emojicapture.d.a)localObject).fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).uQ(paramBoolean);
      }
    }
  }
  
  public void release()
  {
    super.release();
    Object localObject = this.gsb;
    if (localObject != null) {
      ((com.tencent.mm.media.f.d)localObject).close();
    }
    localObject = this.pvC;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).release();
    }
    localObject = this.pvA;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.d.a)localObject).clear();
    }
    this.pvA = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.j
 * JD-Core Version:    0.7.0.1
 */