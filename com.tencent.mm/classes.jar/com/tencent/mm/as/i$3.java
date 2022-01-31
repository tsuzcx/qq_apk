package com.tencent.mm.as;

import com.tencent.mm.ah.m;
import java.util.Set;

final class i$3
  implements Runnable
{
  i$3(i parami, m paramm) {}
  
  public final void run()
  {
    if (this.bEe.getType() != 110) {}
    while (!(this.bEe instanceof l)) {
      return;
    }
    i.c(this.eoG);
    int i = (int)((l)this.bEe).eoN;
    i.Ov().remove(Integer.valueOf(i));
    if (i.d(this.eoG) > 0)
    {
      i.e(this.eoG);
      return;
    }
    i.f(this.eoG);
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.i.3
 * JD-Core Version:    0.7.0.1
 */