package com.tencent.mm.plugin.emojicapture.ui.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.b.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureCropTopRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "emojiFilterRender", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiFilterRenderer;", "firstRender", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getEmojiProcessOutputTexture", "release", "releaseFilterProcess", "renderImpl", "plugin-emojicapture_release"})
public final class a
  extends c
{
  private final String TAG;
  public final h lAF;
  private boolean lAG;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(3143);
    this.TAG = "MicroMsg.EmojiCaptureCropTopRenderProc";
    this.lAF = new h();
    this.lAG = true;
    this.lAF.bpl();
    AppMethodBeat.o(3143);
  }
  
  public final void Vj()
  {
    AppMethodBeat.i(3141);
    if (this.lAG) {
      ab.i(this.TAG, "first frame start render");
    }
    this.lAF.bpl();
    this.lAF.updateSize(this.eYl, this.eYm);
    this.lAF.a(this.eYa, this.eYf, this.eYj, this.eYk, this.eYe);
    if (this.lAG)
    {
      ab.i(this.TAG, "first frame render");
      this.lAG = false;
    }
    AppMethodBeat.o(3141);
  }
  
  public final void release()
  {
    AppMethodBeat.i(3142);
    super.release();
    this.lAF.destroy();
    AppMethodBeat.o(3142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.a
 * JD-Core Version:    0.7.0.1
 */