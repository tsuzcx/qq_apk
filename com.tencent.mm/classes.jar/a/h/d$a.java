package a.h;

import a.d.a.c;
import a.d.b.a.a;
import a.g;
import java.util.Iterator;

public final class d$a
  implements a, Iterator<a.e.d>
{
  private int hpc;
  private int xoM = -1;
  private int xoN;
  private int xoO;
  private a.e.d xoP;
  
  d$a()
  {
    int j = localObject.hrK;
    int k = localObject.xoK.length();
    if (k < 0) {
      throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + k + " is less than minimum 0."));
    }
    int i;
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      this.xoN = i;
      this.xoO = this.xoN;
      return;
      i = j;
      if (j > k) {
        i = k;
      }
    }
  }
  
  private final void cUn()
  {
    if (this.xoO < 0)
    {
      this.xoM = 0;
      this.xoP = null;
      return;
    }
    if (this.xoQ.limit > 0)
    {
      this.hpc += 1;
      if (this.hpc >= this.xoQ.limit) {}
    }
    else
    {
      if (this.xoO <= this.xoQ.xoK.length()) {
        break label107;
      }
    }
    this.xoP = new a.e.d(this.xoN, e.Y(this.xoQ.xoK));
    label107:
    g localg;
    for (this.xoO = -1;; this.xoO = -1)
    {
      this.xoM = 1;
      return;
      localg = (g)this.xoQ.xoL.l(this.xoQ.xoK, Integer.valueOf(this.xoO));
      if (localg != null) {
        break;
      }
      this.xoP = new a.e.d(this.xoN, e.Y(this.xoQ.xoK));
    }
    int j = ((Number)localg.first).intValue();
    int i = ((Number)localg.second).intValue();
    this.xoP = new a.e.d(this.xoN, j - 1);
    this.xoN = (j + i);
    j = this.xoN;
    if (i == 0) {}
    for (i = 1;; i = 0)
    {
      this.xoO = (i + j);
      break;
    }
  }
  
  public final boolean hasNext()
  {
    if (this.xoM == -1) {
      cUn();
    }
    return this.xoM == 1;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.h.d.a
 * JD-Core Version:    0.7.0.1
 */