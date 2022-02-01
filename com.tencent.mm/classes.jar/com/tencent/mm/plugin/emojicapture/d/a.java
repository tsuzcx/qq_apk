package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sticker.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"})
public final class a
{
  public static final String TAG = "MicroMsg.EmojiFilterProcess";
  public static final a.a pXh;
  public int gNq;
  public int gNs;
  public int gNt;
  public com.tencent.mm.plugin.xlabeffect.b gvS;
  private String pWT;
  public int pXe;
  public int pXf;
  public boolean pXg;
  
  static
  {
    AppMethodBeat.i(138);
    pXh = new a.a((byte)0);
    TAG = "MicroMsg.EmojiFilterProcess";
    AppMethodBeat.o(138);
  }
  
  public a()
  {
    AppMethodBeat.i(137);
    this.pXg = ay.aRW("xlab_effect_config").getBoolean("effect", true);
    AppMethodBeat.o(137);
  }
  
  public final void a(f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(221759);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(this.pWT).append(", ");
    if (paramf != null)
    {
      localObject1 = paramf.pWT;
      ae.i(str, (String)localObject1);
      str = this.pWT;
      if (paramf == null) {
        break label125;
      }
    }
    label125:
    for (Object localObject1 = paramf.pWT;; localObject1 = null)
    {
      if (!(p.i(str, localObject1) ^ true)) {
        break label130;
      }
      localObject1 = localObject2;
      if (paramf != null) {
        localObject1 = paramf.pWT;
      }
      this.pWT = ((String)localObject1);
      localObject1 = this.gvS;
      if (localObject1 == null) {
        break label130;
      }
      ((com.tencent.mm.plugin.xlabeffect.b)localObject1).a(paramf);
      AppMethodBeat.o(221759);
      return;
      localObject1 = null;
      break;
    }
    label130:
    AppMethodBeat.o(221759);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(136);
    Object localObject = TAG;
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    ae.i((String)localObject, "clear %s %d", new Object[] { this, Long.valueOf(localThread.getId()) });
    try
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.pXf }, 0);
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.gvS = null;
      AppMethodBeat.o(136);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      e locale = e.pXD;
      e.ckV();
      AppMethodBeat.o(136);
    }
  }
  
  public final void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135);
    this.gNq = paramInt1;
    this.pXe = paramInt2;
    try
    {
      Object localObject = TAG;
      String str = "initial %s, %d, " + this.pXg;
      Thread localThread = Thread.currentThread();
      p.g(localThread, "Thread.currentThread()");
      ae.i((String)localObject, str, new Object[] { this, Long.valueOf(localThread.getId()) });
      this.gvS = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEe, -1);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEf, -1);
      int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEg, -1);
      int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEh, -1);
      int k = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEi, -1);
      ae.i(TAG, "Face beauty config: skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).k(paramInt1, i, k, paramInt2, j);
      }
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).pX(true);
      }
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vJ(false);
      }
      localObject = com.tencent.mm.plugin.emojicapture.ui.b.b.qeU;
      this.pXf = com.tencent.mm.plugin.emojicapture.ui.b.b.a.clS();
      ae.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(135);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, (Throwable)localException, "initial error", new Object[0]);
      e locale = e.pXD;
      e.ckT();
      AppMethodBeat.o(135);
    }
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(221760);
    ae.i(TAG, "setRemoveBg: ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.xlabeffect.b localb = this.gvS;
    if (localb != null)
    {
      localb.vJ(paramBoolean);
      AppMethodBeat.o(221760);
      return;
    }
    AppMethodBeat.o(221760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */