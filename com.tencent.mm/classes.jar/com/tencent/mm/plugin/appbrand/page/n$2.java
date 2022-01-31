package com.tencent.mm.plugin.appbrand.page;

import java.util.LinkedList;

final class n$2
  implements Runnable
{
  n$2(n paramn, boolean[] paramArrayOfBoolean, al paramal, k paramk) {}
  
  public final void run()
  {
    if (this.gTb[0] != 0) {}
    do
    {
      return;
      this.gTb[0] = true;
    } while (this.gTa.getPageCount() == 0);
    if (n.a(this.gTa).isEmpty()) {}
    for (k localk = null;; localk = (k)n.a(this.gTa).getFirst())
    {
      if ((this.gTc == al.gVR) || (this.gTc == al.gVP) || (this.gTc == al.gVQ)) {
        n.a(this.gTa, localk);
      }
      boolean bool1 = n.b(this.gTc);
      boolean bool2 = n.c(this.gTc);
      n.a(this.gTa, localk, bool1, bool2);
      n.a(this.gTa, this.gTd, bool1);
      this.gTa.a(localk, this.gTd, this.gTc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n.2
 * JD-Core Version:    0.7.0.1
 */