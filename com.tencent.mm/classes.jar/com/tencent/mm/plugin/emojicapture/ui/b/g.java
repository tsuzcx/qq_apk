package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRecorderRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "updateDrawViewSize", "width", "height", "updateTextureSize", "plugin-emojicapture_release"})
public final class g
  extends com.tencent.mm.media.i.a
{
  public g()
  {
    super(i, j, k, d.ceL(), 1, 1);
    AppMethodBeat.i(861);
    AppMethodBeat.o(861);
  }
  
  public final com.tencent.mm.media.i.b.a ajF()
  {
    AppMethodBeat.i(858);
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new e(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
    AppMethodBeat.o(858);
    return locala;
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(860);
    d.a locala = d.pnw;
    paramInt1 = d.ceL();
    locala = d.pnw;
    super.cR(paramInt1, d.ceL());
    AppMethodBeat.o(860);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(859);
    d.a locala = d.pnw;
    paramInt1 = d.ceL();
    locala = d.pnw;
    super.cS(paramInt1, d.ceL());
    AppMethodBeat.o(859);
  }
  
  public final void ee(boolean paramBoolean) {}
  
  public final void mE(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.g
 * JD-Core Version:    0.7.0.1
 */