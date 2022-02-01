package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRecorderRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "updateDrawViewSize", "width", "height", "updateTextureSize", "plugin-emojicapture_release"})
public final class g
  extends com.tencent.mm.media.j.a
{
  public g()
  {
    super(i, j, k, d.cIG(), 1, 1);
    AppMethodBeat.i(861);
    AppMethodBeat.o(861);
  }
  
  public final com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(858);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new e(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
    AppMethodBeat.o(858);
    return locala;
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(860);
    d.a locala = d.roA;
    paramInt1 = d.cIG();
    locala = d.roA;
    super.cY(paramInt1, d.cIG());
    AppMethodBeat.o(860);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(859);
    d.a locala = d.roA;
    paramInt1 = d.cIG();
    locala = d.roA;
    super.cZ(paramInt1, d.cIG());
    AppMethodBeat.o(859);
  }
  
  public final void eD(boolean paramBoolean) {}
  
  public final void qx(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.g
 * JD-Core Version:    0.7.0.1
 */