package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.emojicapture.ui.b.b.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sticker.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final String TAG;
  public static final a.a ygz;
  public int mVb;
  public int mVd;
  public int mVe;
  public k muW;
  public int ygA;
  public int ygB;
  public boolean ygC;
  private String ygo;
  
  static
  {
    AppMethodBeat.i(138);
    ygz = new a.a((byte)0);
    TAG = "MicroMsg.EmojiFilterProcess";
    AppMethodBeat.o(138);
  }
  
  public a()
  {
    AppMethodBeat.i(137);
    this.ygC = MultiProcessMMKV.getMMKV("xlab_effect_config").getBoolean("effect", true);
    AppMethodBeat.o(137);
  }
  
  public final void a(f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(269334);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("changeSticker: ").append(this.ygo).append(", ");
    if (paramf == null)
    {
      localObject1 = null;
      Log.i(str, localObject1);
      str = this.ygo;
      if (paramf != null) {
        break label115;
      }
      localObject1 = null;
      label67:
      if (!s.p(str, localObject1)) {
        if (paramf != null) {
          break label123;
        }
      }
    }
    label115:
    label123:
    for (Object localObject1 = localObject2;; localObject1 = paramf.ygo)
    {
      this.ygo = ((String)localObject1);
      localObject1 = this.muW;
      if (localObject1 != null) {
        ((k)localObject1).a(paramf);
      }
      AppMethodBeat.o(269334);
      return;
      localObject1 = paramf.ygo;
      break;
      localObject1 = paramf.ygo;
      break label67;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(136);
    Log.i(TAG, "clear %s %d", new Object[] { this, Long.valueOf(Thread.currentThread().getId()) });
    try
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.ygB }, 0);
      k localk = this.muW;
      if (localk != null) {
        localk.destroy();
      }
      this.muW = null;
      AppMethodBeat.o(136);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      e locale = e.ygT;
      e.dDW();
      AppMethodBeat.o(136);
    }
  }
  
  public final void gW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135);
    this.mVb = paramInt1;
    this.ygA = paramInt2;
    try
    {
      Log.i(TAG, s.X("initial %s, %d, ", Boolean.valueOf(this.ygC)), new Object[] { this, Long.valueOf(Thread.currentThread().getId()) });
      this.muW = new k(0, 0, 0, false, false, 47);
      Object localObject = this.muW;
      s.checkNotNull(localObject);
      ((k)localObject).XLr.jFp = 5;
      paramInt1 = ((c)h.ax(c.class)).a(c.a.yTg, -1);
      paramInt2 = ((c)h.ax(c.class)).a(c.a.yTh, -1);
      int i = ((c)h.ax(c.class)).a(c.a.yTi, -1);
      int j = ((c)h.ax(c.class)).a(c.a.yTj, -1);
      int k = ((c)h.ax(c.class)).a(c.a.yTk, -1);
      Log.i(TAG, "Face beauty config: skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).q(paramInt1, i, k, paramInt2, j);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).Be(true);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).Jo(false);
      }
      localObject = b.ynr;
      this.ygB = b.a.dEV();
      Log.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(135);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "initial error", new Object[0]);
      e locale = e.ygT;
      e.dDU();
      AppMethodBeat.o(135);
    }
  }
  
  public final void op(boolean paramBoolean)
  {
    AppMethodBeat.i(269336);
    Log.i(TAG, s.X("setRemoveBg: ", Boolean.valueOf(paramBoolean)));
    k localk = this.muW;
    if (localk != null) {
      localk.Jo(paramBoolean);
    }
    AppMethodBeat.o(269336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */