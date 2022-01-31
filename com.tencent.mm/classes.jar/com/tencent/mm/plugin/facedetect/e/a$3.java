package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class a$3
  implements Runnable
{
  public a$3(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(547);
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
      al.d(new a.3.1(this));
      AppMethodBeat.o(547);
      return;
      a.a(this.mnI, this.mnC);
      a.b(this.mnI, this.mnB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.3
 * JD-Core Version:    0.7.0.1
 */