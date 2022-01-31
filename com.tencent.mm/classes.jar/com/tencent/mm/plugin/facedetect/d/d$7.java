package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.sdk.platformtools.y;

final class d$7
  implements Runnable
{
  d$7(d paramd) {}
  
  public final void run()
  {
    synchronized (this.jPM.jPG)
    {
      if (!this.jPM.jPA)
      {
        y.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
        this.jPM.jPA = true;
        d.b(this.jPM);
        return;
      }
      y.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.7
 * JD-Core Version:    0.7.0.1
 */