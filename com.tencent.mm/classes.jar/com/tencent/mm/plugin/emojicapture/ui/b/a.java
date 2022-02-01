package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureCropTopRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "externalRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setInputTexture", "texture", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends j
{
  private final String TAG;
  private com.tencent.mm.media.j.b.a ynq;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(830);
    this.TAG = "MicroMsg.EmojiCaptureCropTopRenderProc";
    this.ynq = ((com.tencent.mm.media.j.b.a)new c(paramInt1, paramInt2, getOutputWidth(), getOutputHeight(), 2, 2));
    com.tencent.mm.media.j.b.a locala = this.ynq;
    if (locala != null) {
      locala.gq(true);
    }
    AppMethodBeat.o(830);
  }
  
  public final com.tencent.mm.media.j.b.a dEU()
  {
    return this.ynq;
  }
  
  public final void release()
  {
    AppMethodBeat.i(829);
    super.release();
    com.tencent.mm.media.j.b.a locala = this.ynq;
    if (locala != null) {
      locala.release();
    }
    AppMethodBeat.o(829);
  }
  
  public final void uc(int paramInt)
  {
    AppMethodBeat.i(828);
    com.tencent.mm.media.j.b.a locala = this.ynq;
    if (locala != null) {
      locala.uc(paramInt);
    }
    AppMethodBeat.o(828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.a
 * JD-Core Version:    0.7.0.1
 */