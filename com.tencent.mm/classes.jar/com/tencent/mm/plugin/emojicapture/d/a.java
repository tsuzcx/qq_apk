package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"})
public final class a
{
  public static final String TAG = "MicroMsg.EmojiFilterProcess";
  public static final a.a pQC;
  public int gKH;
  public int gKJ;
  public int gKK;
  public com.tencent.mm.plugin.xlabeffect.b gtl;
  public int pQA;
  public boolean pQB;
  private String pQo;
  public int pQz;
  
  static
  {
    AppMethodBeat.i(138);
    pQC = new a.a((byte)0);
    TAG = "MicroMsg.EmojiFilterProcess";
    AppMethodBeat.o(138);
  }
  
  public a()
  {
    AppMethodBeat.i(137);
    this.pQB = ax.aQz("xlab_effect_config").getBoolean("effect", true);
    AppMethodBeat.o(137);
  }
  
  public final void a(f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(221666);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(this.pQo).append(", ");
    if (paramf != null)
    {
      localObject1 = paramf.pQo;
      ad.i(str, (String)localObject1);
      str = this.pQo;
      if (paramf == null) {
        break label125;
      }
    }
    label125:
    for (Object localObject1 = paramf.pQo;; localObject1 = null)
    {
      if (!(p.i(str, localObject1) ^ true)) {
        break label130;
      }
      localObject1 = localObject2;
      if (paramf != null) {
        localObject1 = paramf.pQo;
      }
      this.pQo = ((String)localObject1);
      localObject1 = this.gtl;
      if (localObject1 == null) {
        break label130;
      }
      ((com.tencent.mm.plugin.xlabeffect.b)localObject1).a(paramf);
      AppMethodBeat.o(221666);
      return;
      localObject1 = null;
      break;
    }
    label130:
    AppMethodBeat.o(221666);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(136);
    Object localObject = TAG;
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    ad.i((String)localObject, "clear %s %d", new Object[] { this, Long.valueOf(localThread.getId()) });
    try
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.pQA }, 0);
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.gtl = null;
      AppMethodBeat.o(136);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      e locale = e.pQY;
      e.cjF();
      AppMethodBeat.o(136);
    }
  }
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135);
    this.gKH = paramInt1;
    this.pQz = paramInt2;
    try
    {
      Object localObject = TAG;
      String str = "initial %s, %d, " + this.pQB;
      Thread localThread = Thread.currentThread();
      p.g(localThread, "Thread.currentThread()");
      ad.i((String)localObject, str, new Object[] { this, Long.valueOf(localThread.getId()) });
      this.gtl = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).pP(true);
      }
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vB(false);
      }
      localObject = com.tencent.mm.plugin.emojicapture.ui.b.b.pYp;
      this.pQA = b.a.ckC();
      ad.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(135);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "initial error", new Object[0]);
      e locale = e.pQY;
      e.cjD();
      AppMethodBeat.o(135);
    }
  }
  
  public final void kL(boolean paramBoolean)
  {
    AppMethodBeat.i(221667);
    ad.i(TAG, "setRemoveBg: ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.xlabeffect.b localb = this.gtl;
    if (localb != null)
    {
      localb.vB(paramBoolean);
      AppMethodBeat.o(221667);
      return;
    }
    AppMethodBeat.o(221667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */