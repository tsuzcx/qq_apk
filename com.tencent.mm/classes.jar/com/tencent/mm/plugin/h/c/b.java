package com.tencent.mm.plugin.h.c;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

public final class b
  implements Runnable
{
  private int count = 0;
  public boolean isStop = false;
  
  private long a(String paramString, PLong paramPLong)
  {
    long l1 = 0L;
    if (this.count >= 10) {
      if (this.isStop) {
        l1 = -1L;
      }
    }
    long l2;
    do
    {
      return l1;
      this.count = 0;
      Object localObject = new File(paramString);
      if (((File)localObject).isDirectory())
      {
        String[] arrayOfString = ((File)localObject).list();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            localObject = arrayOfString[i];
            StringBuilder localStringBuilder = new StringBuilder().append(paramString);
            if (paramString.endsWith("/")) {}
            for (;;)
            {
              l2 = a((String)localObject, paramPLong);
              if (l2 != -1L) {
                break;
              }
              return -1L;
              localObject = "/" + (String)localObject;
            }
            l1 += l2;
            i += 1;
          }
          return l1;
        }
      }
      l2 = ((File)localObject).length();
      l1 = l2;
    } while (l2 <= 0L);
    paramPLong.value += 1L;
    return l2;
  }
  
  public final void run()
  {
    if (this.isStop) {}
    Object localObject1;
    PLong localPLong1;
    long l1;
    Object localObject2;
    long l2;
    long l3;
    PLong localPLong2;
    long l4;
    long l5;
    long l6;
    long l7;
    long l8;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = com.tencent.mm.plugin.n.c.FG();
                this.count = 0;
                localPLong1 = new PLong();
                l1 = a((String)localObject1, localPLong1);
              } while (this.isStop);
              localObject2 = com.tencent.mm.plugin.n.c.FH();
              this.count = 0;
              localObject1 = new PLong();
              l2 = a((String)localObject2, (PLong)localObject1);
            } while (this.isStop);
            au.Hx();
            str = com.tencent.mm.model.c.getAccVideoPath();
            this.count = 0;
            localObject2 = new PLong();
            l3 = a(str, (PLong)localObject2);
          } while (this.isStop);
          au.Hx();
          String str = com.tencent.mm.model.c.FI();
          this.count = 0;
          localPLong2 = new PLong();
          l4 = a(str, localPLong2);
        } while (this.isStop);
        l5 = com.tencent.mm.plugin.h.b.ayE().ayF().oI(43) + com.tencent.mm.plugin.h.b.ayE().ayF().oI(62) + com.tencent.mm.plugin.h.b.ayE().ayF().oI(44);
        l6 = com.tencent.mm.plugin.h.b.ayE().ayF().oJ(43) + com.tencent.mm.plugin.h.b.ayE().ayF().oJ(62) + com.tencent.mm.plugin.h.b.ayE().ayF().oJ(44);
      } while (this.isStop);
      l7 = com.tencent.mm.plugin.h.b.ayE().ayF().oI(3);
      l8 = com.tencent.mm.plugin.h.b.ayE().ayF().oJ(3);
    } while (this.isStop);
    long l9 = com.tencent.mm.plugin.h.b.ayE().ayF().oI(34);
    long l10 = com.tencent.mm.plugin.h.b.ayE().ayF().oJ(34);
    long l11 = com.tencent.mm.plugin.h.b.ayE().ayF().oI(49);
    long l12 = com.tencent.mm.plugin.h.b.ayE().ayF().oJ(49);
    h.nFQ.f(14556, new Object[] { Integer.valueOf(43), Long.valueOf(l5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l6) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf(3), Long.valueOf(l7), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l8) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf(34), Long.valueOf(l9), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l10) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf(49), Long.valueOf(l11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l12) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("image".hashCode()), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localPLong1.value) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("image2".hashCode()), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(((PLong)localObject1).value) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("video".hashCode()), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(((PLong)localObject2).value) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("voice".hashCode()), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localPLong2.value) });
    long l13 = ((Long)g.DP().Dz().get(ac.a.uxy, Long.valueOf(0L))).longValue();
    long l14 = ((Long)g.DP().Dz().get(ac.a.uxz, Long.valueOf(0L))).longValue();
    h.nFQ.f(14556, new Object[] { Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l14 - l13) });
    y.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", new Object[] { Long.valueOf(l5), Long.valueOf(l7), Long.valueOf(l9), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l8), Long.valueOf(l10), Long.valueOf(l12), Long.valueOf(((PLong)localObject2).value), Long.valueOf(((PLong)localObject1).value), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.h.c.b
 * JD-Core Version:    0.7.0.1
 */