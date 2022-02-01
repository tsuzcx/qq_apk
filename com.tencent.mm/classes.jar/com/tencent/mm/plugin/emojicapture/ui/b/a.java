package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureCropTopRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "externalRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class a
  extends j
{
  private final String TAG;
  private com.tencent.mm.media.j.b.a pYo;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(830);
    this.TAG = "MicroMsg.EmojiCaptureCropTopRenderProc";
    this.pYo = ((com.tencent.mm.media.j.b.a)new c(paramInt1, paramInt2, this.outputWidth, this.outputHeight, 2, 2));
    com.tencent.mm.media.j.b.a locala = this.pYo;
    if (locala != null)
    {
      locala.hny = true;
      AppMethodBeat.o(830);
      return;
    }
    AppMethodBeat.o(830);
  }
  
  public final com.tencent.mm.media.j.b.a ckB()
  {
    return this.pYo;
  }
  
  public final void nN(int paramInt)
  {
    AppMethodBeat.i(828);
    com.tencent.mm.media.j.b.a locala = this.pYo;
    if (locala != null)
    {
      locala.nN(paramInt);
      AppMethodBeat.o(828);
      return;
    }
    AppMethodBeat.o(828);
  }
  
  public final void release()
  {
    AppMethodBeat.i(829);
    super.release();
    com.tencent.mm.media.j.b.a locala = this.pYo;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(829);
      return;
    }
    AppMethodBeat.o(829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.a
 * JD-Core Version:    0.7.0.1
 */