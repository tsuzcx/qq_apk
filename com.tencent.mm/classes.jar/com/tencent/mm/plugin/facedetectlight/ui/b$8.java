package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class b$8
  implements Runnable
{
  b$8(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(768);
    b localb = this.mrQ;
    ah.getContext();
    b.a(localb, p.n(b.x(this.mrQ), b.y(this.mrQ)));
    al.d(new b.8.1(this));
    AppMethodBeat.o(768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.8
 * JD-Core Version:    0.7.0.1
 */