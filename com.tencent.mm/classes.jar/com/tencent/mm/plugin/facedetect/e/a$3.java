package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class a$3
  implements Runnable
{
  public a$3(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Runnable paramRunnable) {}
  
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
      ai.d(new a.3.1(this));
      return;
      a.a(this.jTm, this.jTg);
      a.b(this.jTm, this.jTf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.3
 * JD-Core Version:    0.7.0.1
 */