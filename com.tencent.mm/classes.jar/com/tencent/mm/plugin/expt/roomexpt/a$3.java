package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.mm.h.b.a.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    int i = 0;
    com.tencent.mm.plugin.expt.a.a locala = (com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class);
    a.a locala1 = a.a.jHZ;
    boolean bool;
    if (a.a(this.jII) != null)
    {
      bool = a.a(this.jII).cjq;
      if (locala.a(locala1, bool)) {
        break label57;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label57:
      int j = Math.min(a.b(this.jII).length, 5);
      while (i < j)
      {
        if (this.jIJ.equals(a.b(this.jII)[i]))
        {
          a.ay(this.jIJ, this.iFZ);
          a.a(this.jII).cjn = 6L;
          a.a(this.jII).cjp = "";
          a.c(this.jII);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.3
 * JD-Core Version:    0.7.0.1
 */