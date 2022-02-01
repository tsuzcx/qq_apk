package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRecorderRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "updateDrawViewSize", "width", "height", "updateTextureSize", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.media.j.a
{
  public g()
  {
    super(i, j, k, d.dDF(), 1, 1);
    AppMethodBeat.i(861);
    AppMethodBeat.o(861);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(858);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new e(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    AppMethodBeat.o(858);
    return locala;
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(860);
    d.a locala = d.ygM;
    paramInt1 = d.dDF();
    locala = d.ygM;
    super.ek(paramInt1, d.dDF());
    AppMethodBeat.o(860);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(859);
    d.a locala = d.ygM;
    paramInt1 = d.dDF();
    locala = d.ygM;
    super.el(paramInt1, d.dDF());
    AppMethodBeat.o(859);
  }
  
  public final void fQ(boolean paramBoolean) {}
  
  public final void th(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b.g
 * JD-Core Version:    0.7.0.1
 */