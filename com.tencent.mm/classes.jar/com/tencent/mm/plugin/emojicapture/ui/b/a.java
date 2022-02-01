package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.c;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureCropTopRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "externalRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class a
  extends j
{
  private final String TAG;
  private com.tencent.mm.media.i.b.a puJ;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(830);
    this.TAG = "MicroMsg.EmojiCaptureCropTopRenderProc";
    this.puJ = ((com.tencent.mm.media.i.b.a)new c(paramInt1, paramInt2, this.grA, this.grB, 2, 2));
    com.tencent.mm.media.i.b.a locala = this.puJ;
    if (locala != null)
    {
      locala.gVv = true;
      AppMethodBeat.o(830);
      return;
    }
    AppMethodBeat.o(830);
  }
  
  public final com.tencent.mm.media.i.b.a cfX()
  {
    return this.puJ;
  }
  
  public final void no(int paramInt)
  {
    AppMethodBeat.i(828);
    com.tencent.mm.media.i.b.a locala = this.puJ;
    if (locala != null)
    {
      locala.no(paramInt);
      AppMethodBeat.o(828);
      return;
    }
    AppMethodBeat.o(828);
  }
  
  public final void release()
  {
    AppMethodBeat.i(829);
    super.release();
    com.tencent.mm.media.i.b.a locala = this.puJ;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(829);
      return;
    }
    AppMethodBeat.o(829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.a
 * JD-Core Version:    0.7.0.1
 */