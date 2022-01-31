package com.tencent.liteav.network;

import com.tencent.liteav.basic.f.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class TXCStreamUploader$2
  extends Thread
{
  TXCStreamUploader$2(TXCStreamUploader paramTXCStreamUploader, String paramString1, boolean paramBoolean, String paramString2)
  {
    super(paramString1);
  }
  
  public void run()
  {
    while (TXCStreamUploader.access$400(this.c) != 0L) {
      try
      {
        sleep(100L, 0);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    TXCStreamUploader.access$500(this.c).b();
    TXCStreamUploader.access$500(this.c).a(TXCStreamUploader.access$600(this.c).m);
    TXCStreamUploader.access$500(this.c).a(TXCStreamUploader.access$700(this.c));
    TXCStreamUploader.access$500(this.c).a(this.a, TXCStreamUploader.access$800(this.c, this.b));
    for (;;)
    {
      synchronized (TXCStreamUploader.access$900(this.c))
      {
        TXCStreamUploader.access$1002(this.c, this.a);
        if (!TXCStreamUploader.access$600(this.c).m) {
          break label883;
        }
        if (!TXCStreamUploader.access$1000(this.c)) {
          break label878;
        }
        i = 3;
        j = i;
        if (!TXCStreamUploader.access$1100(this.c))
        {
          if (TXCStreamUploader.access$1200(this.c) == null) {
            break label870;
          }
          j = i;
          if (TXCStreamUploader.access$1200(this.c).size() == 0) {
            break label870;
          }
        }
        this.c.setStatusValue(7020, Long.valueOf(j));
        TXCStreamUploader.access$402(this.c, TXCStreamUploader.access$1300(this.c, TXCStreamUploader.access$700(this.c), this.b, this.a, TXCStreamUploader.access$600(this.c).e, TXCStreamUploader.access$600(this.c).d, TXCStreamUploader.access$600(this.c).a, TXCStreamUploader.access$600(this.c).c, TXCStreamUploader.access$600(this.c).h, 16, j, TXCStreamUploader.access$600(this.c).n));
        if (TXCStreamUploader.access$400(this.c) != 0L)
        {
          TXCStreamUploader.access$1400(this.c, TXCStreamUploader.access$400(this.c), TXCStreamUploader.access$600(this.c).j, TXCStreamUploader.access$600(this.c).h, TXCStreamUploader.access$600(this.c).i);
          i = 0;
          Iterator localIterator = TXCStreamUploader.access$1500(this.c).iterator();
          if (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            if ((i != 0) || (localb.b != 0)) {
              break label867;
            }
            i = 1;
            if (i == 0) {
              break label875;
            }
            if (TXCStreamUploader.access$1600(this.c) == 0L) {
              TXCStreamUploader.access$1602(this.c, localb.h - 3600000L);
            }
            TXCStreamUploader.access$1700(this.c, TXCStreamUploader.access$400(this.c), localb.a, localb.b, localb.e, localb.g - TXCStreamUploader.access$1600(this.c), localb.h - TXCStreamUploader.access$1600(this.c));
            break label875;
          }
          TXCStreamUploader.access$1500(this.c).removeAllElements();
        }
        if (TXCStreamUploader.access$1100(this.c)) {}
        synchronized (TXCStreamUploader.access$1800(this.c))
        {
          TXCStreamUploader.access$1902(this.c, TXCStreamUploader.access$2100(this.c, TXCStreamUploader.access$2000(this.c).a, TXCStreamUploader.access$2000(this.c).b, TXCStreamUploader.access$2000(this.c).c, TXCStreamUploader.access$2000(this.c).d, TXCStreamUploader.access$2000(this.c).e, TXCStreamUploader.access$2000(this.c).f, TXCStreamUploader.access$2000(this.c).g, TXCStreamUploader.access$2000(this.c).h, TXCStreamUploader.access$2000(this.c).i, TXCStreamUploader.access$2000(this.c).j));
          synchronized (TXCStreamUploader.access$2200(this.c))
          {
            TXCStreamUploader.access$2302(this.c, TXCStreamUploader.access$2400(this.c, TXCStreamUploader.access$1900(this.c), TXCStreamUploader.access$400(this.c)));
            TXCStreamUploader.access$2500(this.c, TXCStreamUploader.access$400(this.c));
            if (TXCStreamUploader.access$1100(this.c)) {
              synchronized (TXCStreamUploader.access$2200(this.c))
              {
                TXCStreamUploader.access$2600(this.c, TXCStreamUploader.access$2300(this.c));
                TXCStreamUploader.access$2700(this.c, TXCStreamUploader.access$2300(this.c));
                TXCStreamUploader.access$2302(this.c, 0L);
                synchronized (TXCStreamUploader.access$1800(this.c))
                {
                  TXCStreamUploader.access$2800(this.c, TXCStreamUploader.access$1900(this.c));
                  TXCStreamUploader.access$1902(this.c, 0L);
                }
              }
            }
          }
        }
      }
      synchronized (TXCStreamUploader.access$900(this.c))
      {
        TXCStreamUploader.access$2900(this.c, TXCStreamUploader.access$400(this.c));
        TXCStreamUploader.access$402(this.c, 0L);
        return;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
        localObject4 = finally;
        throw localObject4;
        localObject5 = finally;
        throw localObject5;
        localObject6 = finally;
        throw localObject6;
      }
      label867:
      continue;
      label870:
      int j = 1;
      continue;
      label875:
      continue;
      label878:
      int i = 2;
      continue;
      label883:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader.2
 * JD-Core Version:    0.7.0.1
 */