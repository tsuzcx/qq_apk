package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"})
public final class a
{
  public static final String TAG = "MicroMsg.EmojiFilterProcess";
  public static final a uTN;
  public com.tencent.mm.plugin.xlabeffect.e jUF;
  public int kre;
  public int krg;
  public int krh;
  public int uTK;
  public int uTL;
  public boolean uTM;
  private String uTz;
  
  static
  {
    AppMethodBeat.i(138);
    uTN = new a((byte)0);
    TAG = "MicroMsg.EmojiFilterProcess";
    AppMethodBeat.o(138);
  }
  
  public a()
  {
    AppMethodBeat.i(137);
    this.uTM = MultiProcessMMKV.getMMKV("xlab_effect_config").getBoolean("effect", true);
    AppMethodBeat.o(137);
  }
  
  public final void a(f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(203369);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(this.uTz).append(", ");
    if (paramf != null)
    {
      localObject1 = paramf.uTz;
      Log.i(str, (String)localObject1);
      str = this.uTz;
      if (paramf == null) {
        break label125;
      }
    }
    label125:
    for (Object localObject1 = paramf.uTz;; localObject1 = null)
    {
      if (!(p.h(str, localObject1) ^ true)) {
        break label130;
      }
      localObject1 = localObject2;
      if (paramf != null) {
        localObject1 = paramf.uTz;
      }
      this.uTz = ((String)localObject1);
      localObject1 = this.jUF;
      if (localObject1 == null) {
        break label130;
      }
      ((com.tencent.mm.plugin.xlabeffect.e)localObject1).a(paramf);
      AppMethodBeat.o(203369);
      return;
      localObject1 = null;
      break;
    }
    label130:
    AppMethodBeat.o(203369);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(136);
    Object localObject = TAG;
    Thread localThread = Thread.currentThread();
    p.j(localThread, "Thread.currentThread()");
    Log.i((String)localObject, "clear %s %d", new Object[] { this, Long.valueOf(localThread.getId()) });
    try
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.uTL }, 0);
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).destroy();
      }
      this.jUF = null;
      AppMethodBeat.o(136);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      com.tencent.mm.plugin.emojicapture.model.e locale = com.tencent.mm.plugin.emojicapture.model.e.uUh;
      com.tencent.mm.plugin.emojicapture.model.e.cXG();
      AppMethodBeat.o(136);
    }
  }
  
  public final void gd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135);
    this.kre = paramInt1;
    this.uTK = paramInt2;
    try
    {
      Object localObject = TAG;
      String str = "initial %s, %d, " + this.uTM;
      Thread localThread = Thread.currentThread();
      p.j(localThread, "Thread.currentThread()");
      Log.i((String)localObject, str, new Object[] { this, Long.valueOf(localThread.getId()) });
      this.jUF = new com.tencent.mm.plugin.xlabeffect.e(0, 0, 0, false, false, 15);
      localObject = this.jUF;
      if (localObject == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.xlabeffect.e)localObject).QPZ.oZ(5);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vDZ, -1);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEa, -1);
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEb, -1);
      int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEc, -1);
      int k = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEd, -1);
      Log.i(TAG, "Face beauty config: skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).o(paramInt1, i, k, paramInt2, j);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).wE(true);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DH(false);
      }
      localObject = com.tencent.mm.plugin.emojicapture.ui.b.b.vbw;
      this.uTL = com.tencent.mm.plugin.emojicapture.ui.b.b.a.cYE();
      Log.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(135);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "initial error", new Object[0]);
      com.tencent.mm.plugin.emojicapture.model.e locale = com.tencent.mm.plugin.emojicapture.model.e.uUh;
      com.tencent.mm.plugin.emojicapture.model.e.cXE();
      AppMethodBeat.o(135);
    }
  }
  
  public final void mQ(boolean paramBoolean)
  {
    AppMethodBeat.i(203371);
    Log.i(TAG, "setRemoveBg: ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.xlabeffect.e locale = this.jUF;
    if (locale != null)
    {
      locale.DH(paramBoolean);
      AppMethodBeat.o(203371);
      return;
    }
    AppMethodBeat.o(203371);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */