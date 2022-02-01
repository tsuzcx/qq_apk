package com.tencent.mm.plugin.emojicapture.d;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.emojicapture.ui.b.b.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/filter/EmojiFilterProcess;", "", "()V", "effectEnable", "", "getEffectEnable", "()Z", "setEffectEnable", "(Z)V", "faceTrackFbo", "", "inputTexture", "lensId", "", "outputTexture", "textureHeight", "textureWidth", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "clear", "filterProcess", "initial", "previewRgbTexture", "setInputTexture", "texture", "setRemoveBg", "remove", "updateTextureSize", "Companion", "plugin-emojicapture_release"})
public final class a
{
  public static final String TAG = "MicroMsg.EmojiFilterProcess";
  public static final a.a oJE;
  public XLabEffect fVU;
  public int guC;
  public int guI;
  public int guJ;
  public int oJB;
  public int oJC;
  public boolean oJD;
  public String oJp;
  
  static
  {
    AppMethodBeat.i(138);
    oJE = new a.a((byte)0);
    TAG = "MicroMsg.EmojiFilterProcess";
    AppMethodBeat.o(138);
  }
  
  public a()
  {
    AppMethodBeat.i(137);
    this.oJD = ax.aFC("xlab_effect_config").getBoolean("effect", true);
    AppMethodBeat.o(137);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(136);
    Object localObject = TAG;
    Thread localThread = Thread.currentThread();
    k.g(localThread, "Thread.currentThread()");
    ad.i((String)localObject, "clear %s %d", new Object[] { this, Long.valueOf(localThread.getId()) });
    try
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.oJC }, 0);
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).destroy();
      }
      this.fVU = null;
      AppMethodBeat.o(136);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      e locale = e.oKa;
      e.bXP();
      AppMethodBeat.o(136);
    }
  }
  
  public final void fi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135);
    this.guC = paramInt1;
    this.oJB = paramInt2;
    try
    {
      Object localObject = TAG;
      String str = "initial %s, %d, " + this.oJD;
      Thread localThread = Thread.currentThread();
      k.g(localThread, "Thread.currentThread()");
      ad.i((String)localObject, str, new Object[] { this, Long.valueOf(localThread.getId()) });
      this.fVU = new XLabEffect(0, 0, 0, false, 15);
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).tN(true);
      }
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).tP(false);
      }
      localObject = b.oRy;
      this.oJC = b.a.bYN();
      ad.d(TAG, "initial end %s", new Object[] { this });
      AppMethodBeat.o(135);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "initial error", new Object[0]);
      e locale = e.oKa;
      e.bXN();
      AppMethodBeat.o(135);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.a
 * JD-Core Version:    0.7.0.1
 */