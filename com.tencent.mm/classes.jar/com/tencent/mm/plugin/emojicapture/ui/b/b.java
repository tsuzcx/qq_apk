package com.tencent.mm.plugin.emojicapture.ui.b;

import a.l;
import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLSurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "renderOutputType", "", "(I)V", "TAG", "", "useCpuCrop", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getEmojiProcessOutputTexture", "release", "shouldDestroySurfaceTexture", "releaseFilterProcess", "resetRenderer", "plugin-emojicapture_release"})
public final class b
  extends com.tencent.mm.media.h.a
{
  private final String TAG = "MicroMsg.EmojiCaptureGLSurfaceTextureRenderer";
  private boolean eZM;
  
  private b()
  {
    super(0, 0, 0, 0, 1, 1);
  }
  
  public final com.tencent.mm.media.h.b.a Ve()
  {
    AppMethodBeat.i(3144);
    ab.i(this.TAG, "doInitRenderProc, useCpuCrop:" + this.eZM);
    try
    {
      PTModule.getInstance().init(EGL14.eglGetCurrentContext());
      if (this.eZM)
      {
        com.tencent.mm.media.h.b.a locala1 = (com.tencent.mm.media.h.b.a)new f(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
        AppMethodBeat.o(3144);
        return locala1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)localException, "PTModule.getInstance().init error", new Object[0]);
      }
      com.tencent.mm.media.h.b.a locala2 = (com.tencent.mm.media.h.b.a)new a(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
      AppMethodBeat.o(3144);
      return locala2;
    }
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(155544);
    super.release(paramBoolean);
    GamePlaySDK.getInstance().clear();
    PTModule.getInstance().destroy();
    AppMethodBeat.o(155544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.b
 * JD-Core Version:    0.7.0.1
 */