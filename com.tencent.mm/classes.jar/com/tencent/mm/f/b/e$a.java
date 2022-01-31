package com.tencent.mm.f.b;

import java.util.TimerTask;

final class e$a
  extends TimerTask
{
  private int bDn = this.bDq.bDa * 2;
  private int bDo = this.bDq.bDa;
  byte[] bDp = new byte[this.bDn];
  
  e$a(e parame) {}
  
  public final void run()
  {
    int j;
    if (!this.bDq.mIsPause)
    {
      j = (int)(0.8D * this.bDq.ut());
      i = j;
      if (j < this.bDq.bDa * 8) {
        i = this.bDq.bDa * 8;
      }
      if (this.bDq.uu() <= i) {
        break label130;
      }
    }
    label130:
    for (int i = 8;; i = 1)
    {
      j = 0;
      while (j < i)
      {
        int k = this.bDq.u(this.bDp, this.bDo);
        if ((this.bDq.bDg != null) && (k == 0)) {
          this.bDq.bDg.r(this.bDp, this.bDo);
        }
        j += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.e.a
 * JD-Core Version:    0.7.0.1
 */