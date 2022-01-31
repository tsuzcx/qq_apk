package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {}
  
  public final void run()
  {
    AppMethodBeat.i(542);
    if ((this.mnA == 90) || (this.mnA == 270))
    {
      ab.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
      a.a(this.mnI, this.mnB);
      a.b(this.mnI, this.mnC);
    }
    synchronized (a.a(this.mnI))
    {
      a.c(this.mnI, this.mnA);
      a.a(this.mnI, this.mnD);
      a.d(this.mnI, this.mnE);
      a.b(this.mnI);
      a.c(this.mnI);
      a.d(this.mnI);
      al.d(new a.1.1(this));
      AppMethodBeat.o(542);
      return;
      a.a(this.mnI, this.mnC);
      a.b(this.mnI, this.mnB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.1
 * JD-Core Version:    0.7.0.1
 */