package com.tencent.liteav.network;

import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(67543);
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
          break label914;
        }
        if (!TXCStreamUploader.access$1000(this.c)) {
          break label909;
        }
        i = 3;
        if (!TXCStreamUploader.access$1100(this.c))
        {
          if (TXCStreamUploader.access$1200(this.c) == null) {
            break label901;
          }
          j = i;
          if (TXCStreamUploader.access$1200(this.c).size() == 0) {
            break label901;
          }
          this.c.setStatusValue(7020, Long.valueOf(j));
          TXCStreamUploader.access$402(this.c, TXCStreamUploader.access$1400(this.c, TXCStreamUploader.access$700(this.c), this.b, this.a, TXCStreamUploader.access$600(this.c).e, TXCStreamUploader.access$600(this.c).d, TXCStreamUploader.access$600(this.c).a, TXCStreamUploader.access$600(this.c).c, TXCStreamUploader.access$600(this.c).h, 16, j, TXCStreamUploader.access$600(this.c).n, TXCStreamUploader.access$600(this.c).o));
          if (TXCStreamUploader.access$400(this.c) == 0L) {
            break label509;
          }
          TXCStreamUploader.access$1500(this.c, TXCStreamUploader.access$400(this.c), TXCStreamUploader.access$600(this.c).j, TXCStreamUploader.access$600(this.c).h, TXCStreamUploader.access$600(this.c).i);
          i = 0;
          Iterator localIterator = TXCStreamUploader.access$1600(this.c).iterator();
          if (localIterator.hasNext())
          {
            TXSNALPacket localTXSNALPacket = (TXSNALPacket)localIterator.next();
            if ((i != 0) || (localTXSNALPacket.nalType != 0)) {
              break label898;
            }
            i = 1;
            if (i == 0) {
              break label906;
            }
            TXCStreamUploader.access$1700(this.c, TXCStreamUploader.access$400(this.c), localTXSNALPacket.nalData, localTXSNALPacket.nalType, localTXSNALPacket.frameIndex, localTXSNALPacket.pts, localTXSNALPacket.dts);
            break label906;
          }
        }
        else
        {
          j = i;
          if (!TXCStreamUploader.access$1300(this.c)) {
            continue;
          }
          TXCStreamUploader.access$600(this.c).n = false;
          j = i;
        }
      }
      TXCStreamUploader.access$1600(this.c).removeAllElements();
      label509:
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
      synchronized (TXCStreamUploader.access$900(this.c))
      {
        TXCStreamUploader.access$2900(this.c, TXCStreamUploader.access$400(this.c));
        TXCStreamUploader.access$402(this.c, 0L);
        AppMethodBeat.o(67543);
        return;
        localObject3 = finally;
        AppMethodBeat.o(67543);
        throw localObject3;
        localObject4 = finally;
        AppMethodBeat.o(67543);
        throw localObject4;
        localObject5 = finally;
        AppMethodBeat.o(67543);
        throw localObject5;
        localObject6 = finally;
        AppMethodBeat.o(67543);
        throw localObject6;
      }
      label898:
      continue;
      label901:
      int j = 1;
      continue;
      label906:
      continue;
      label909:
      int i = 2;
      continue;
      label914:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader.2
 * JD-Core Version:    0.7.0.1
 */