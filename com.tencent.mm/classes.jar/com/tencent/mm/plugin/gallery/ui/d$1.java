package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;

final class d$1
  implements k.a
{
  d$1(d paramd, d.b paramb)
  {
    AppMethodBeat.i(179461);
    AppMethodBeat.o(179461);
  }
  
  public final void eM(int paramInt1, int paramInt2) {}
  
  public final int fE(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(242280);
    this.Ccb.Ccl.stop();
    d.a(this.Ccc, this.Ccb);
    AppMethodBeat.o(242280);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242274);
    d.a(this.Ccc, this.Ccb);
    AppMethodBeat.o(242274);
  }
  
  public final void qX()
  {
    AppMethodBeat.i(242277);
    this.Ccb.Ccl.start();
    d.b(this.Ccc, this.Ccb);
    AppMethodBeat.o(242277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.1
 * JD-Core Version:    0.7.0.1
 */