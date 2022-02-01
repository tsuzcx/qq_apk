package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRGBRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setFrame", "frame", "", "plugin-emojicapture_release"})
public final class f
  extends j
{
  private a pvr;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(857);
    this.pvr = ((a)new com.tencent.mm.media.i.b.f(paramInt1, paramInt2, this.grA, this.grB, 2, 2));
    a locala = this.pvr;
    if (locala != null)
    {
      locala.gVv = true;
      AppMethodBeat.o(857);
      return;
    }
    AppMethodBeat.o(857);
  }
  
  public final void T(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(855);
    k.h(paramArrayOfByte, "frame");
    a locala = this.pvr;
    if (locala != null)
    {
      locala.T(paramArrayOfByte);
      AppMethodBeat.o(855);
      return;
    }
    AppMethodBeat.o(855);
  }
  
  public final a cfX()
  {
    return this.pvr;
  }
  
  public final void release()
  {
    AppMethodBeat.i(856);
    super.release();
    a locala = this.pvr;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(856);
      return;
    }
    AppMethodBeat.o(856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.f
 * JD-Core Version:    0.7.0.1
 */