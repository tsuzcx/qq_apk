package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {}
  
  public final void run()
  {
    if ((this.jTe == 90) || (this.jTe == 270))
    {
      y.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
      a.a(this.jTm, this.jTf);
      a.b(this.jTm, this.jTg);
    }
    synchronized (a.a(this.jTm))
    {
      a.c(this.jTm, this.jTe);
      a.a(this.jTm, this.jTh);
      a.d(this.jTm, this.jTi);
      a.b(this.jTm);
      a.c(this.jTm);
      a.d(this.jTm);
      ai.d(new a.1.1(this));
      return;
      a.a(this.jTm, this.jTg);
      a.b(this.jTm, this.jTf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.1
 * JD-Core Version:    0.7.0.1
 */