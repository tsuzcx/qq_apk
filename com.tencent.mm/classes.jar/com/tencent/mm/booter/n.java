package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.bf.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.z;

public final class n
{
  private static long dZF = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(15862);
    aw.aaz();
    if (ah.gz(ah.c((Long)c.Ru().get(81944, null))) * 1000L > dZF) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.akj();
        d.akk();
        if (!((d)localObject).fpN)
        {
          g.RM();
          if (g.RL().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).fpN = true;
            g.Rc().a(159, (f)localObject);
            localObject = new k(9);
            g.Rc().a((m)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(15862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.n
 * JD-Core Version:    0.7.0.1
 */