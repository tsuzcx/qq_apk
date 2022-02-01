package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;

final class d$1
  implements i.a
{
  d$1(d paramd, d.b paramb)
  {
    AppMethodBeat.i(179461);
    AppMethodBeat.o(179461);
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(289540);
    this.HOd.HOn.start();
    d.b(this.HOe, this.HOd);
    AppMethodBeat.o(289540);
  }
  
  public final void fG(int paramInt1, int paramInt2) {}
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(289542);
    this.HOd.HOn.stop();
    d.a(this.HOe, this.HOd);
    AppMethodBeat.o(289542);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289538);
    d.a(this.HOe, this.HOd);
    AppMethodBeat.o(289538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.1
 * JD-Core Version:    0.7.0.1
 */