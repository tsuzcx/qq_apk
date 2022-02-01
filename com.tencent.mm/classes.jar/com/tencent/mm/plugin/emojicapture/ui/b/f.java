package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRGBRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setFrame", "frame", "", "plugin-emojicapture_release"})
public final class f
  extends j
{
  private a vce;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(857);
    this.vce = ((a)new com.tencent.mm.media.j.b.f(paramInt1, paramInt2, getOutputWidth(), getOutputHeight(), 2, 2));
    a locala = this.vce;
    if (locala != null)
    {
      locala.kYB = true;
      AppMethodBeat.o(857);
      return;
    }
    AppMethodBeat.o(857);
  }
  
  public final void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(855);
    p.k(paramArrayOfByte, "frame");
    a locala = this.vce;
    if (locala != null)
    {
      locala.ap(paramArrayOfByte);
      AppMethodBeat.o(855);
      return;
    }
    AppMethodBeat.o(855);
  }
  
  public final a cYD()
  {
    return this.vce;
  }
  
  public final void release()
  {
    AppMethodBeat.i(856);
    super.release();
    a locala = this.vce;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(856);
      return;
    }
    AppMethodBeat.o(856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.f
 * JD-Core Version:    0.7.0.1
 */