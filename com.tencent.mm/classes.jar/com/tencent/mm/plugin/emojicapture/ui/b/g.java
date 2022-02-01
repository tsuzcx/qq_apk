package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRecorderRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "updateDrawViewSize", "width", "height", "updateTextureSize", "plugin-emojicapture_release"})
public final class g
  extends com.tencent.mm.media.j.a
{
  public g()
  {
    super(i, j, k, d.cXp(), 1, 1);
    AppMethodBeat.i(861);
    AppMethodBeat.o(861);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(858);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new e(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
    AppMethodBeat.o(858);
    return locala;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(860);
    d.a locala = d.uUg;
    paramInt1 = d.cXp();
    locala = d.uUg;
    super.du(paramInt1, d.cXp());
    AppMethodBeat.o(860);
  }
  
  public final void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(859);
    d.a locala = d.uUg;
    paramInt1 = d.cXp();
    locala = d.uUg;
    super.dv(paramInt1, d.cXp());
    AppMethodBeat.o(859);
  }
  
  public final void fj(boolean paramBoolean) {}
  
  public final void tm(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.g
 * JD-Core Version:    0.7.0.1
 */