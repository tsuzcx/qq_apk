package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sticker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"})
public final class a
{
  public static final String TAG = "MicroMsg.EmojiFilterProcess";
  public static final a.a rog;
  public int hDl;
  public int hDn;
  public int hDo;
  public com.tencent.mm.plugin.xlabeffect.b hiH;
  private String rnS;
  public int rod;
  public int roe;
  public boolean rof;
  
  static
  {
    AppMethodBeat.i(138);
    rog = new a.a((byte)0);
    TAG = "MicroMsg.EmojiFilterProcess";
    AppMethodBeat.o(138);
  }
  
  public a()
  {
    AppMethodBeat.i(137);
    this.rof = MultiProcessMMKV.getMMKV("xlab_effect_config").getBoolean("effect", true);
    AppMethodBeat.o(137);
  }
  
  public final void a(f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(256428);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(this.rnS).append(", ");
    if (paramf != null)
    {
      localObject1 = paramf.rnS;
      Log.i(str, (String)localObject1);
      str = this.rnS;
      if (paramf == null) {
        break label125;
      }
    }
    label125:
    for (Object localObject1 = paramf.rnS;; localObject1 = null)
    {
      if (!(p.j(str, localObject1) ^ true)) {
        break label130;
      }
      localObject1 = localObject2;
      if (paramf != null) {
        localObject1 = paramf.rnS;
      }
      this.rnS = ((String)localObject1);
      localObject1 = this.hiH;
      if (localObject1 == null) {
        break label130;
      }
      ((com.tencent.mm.plugin.xlabeffect.b)localObject1).a(paramf);
      AppMethodBeat.o(256428);
      return;
      localObject1 = null;
      break;
    }
    label130:
    AppMethodBeat.o(256428);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(136);
    Object localObject = TAG;
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    Log.i((String)localObject, "clear %s %d", new Object[] { this, Long.valueOf(localThread.getId()) });
    try
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.roe }, 0);
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.hiH = null;
      AppMethodBeat.o(136);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      e locale = e.roB;
      e.cIX();
      AppMethodBeat.o(136);
    }
  }
  
  public final void fG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135);
    this.hDl = paramInt1;
    this.rod = paramInt2;
    try
    {
      Object localObject = TAG;
      String str = "initial %s, %d, " + this.rof;
      Thread localThread = Thread.currentThread();
      p.g(localThread, "Thread.currentThread()");
      Log.i((String)localObject, str, new Object[] { this, Long.valueOf(localThread.getId()) });
      this.hiH = new com.tencent.mm.plugin.xlabeffect.b((byte)0);
      paramInt1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rXi, -1);
      paramInt2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rXj, -1);
      int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rXk, -1);
      int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rXl, -1);
      int k = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rXm, -1);
      Log.i(TAG, "Face beauty config: skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).l(paramInt1, i, k, paramInt2, j);
      }
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).ti(true);
      }
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).zG(false);
      }
      localObject = com.tencent.mm.plugin.emojicapture.ui.b.b.rvS;
      this.roe = com.tencent.mm.plugin.emojicapture.ui.b.b.a.cJU();
      Log.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(135);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "initial error", new Object[0]);
      e locale = e.roB;
      e.cIV();
      AppMethodBeat.o(135);
    }
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(256429);
    Log.i(TAG, "setRemoveBg: ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.xlabeffect.b localb = this.hiH;
    if (localb != null)
    {
      localb.zG(paramBoolean);
      AppMethodBeat.o(256429);
      return;
    }
    AppMethodBeat.o(256429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */