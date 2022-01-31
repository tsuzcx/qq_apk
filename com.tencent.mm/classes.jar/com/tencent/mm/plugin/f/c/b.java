package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(18644);
    if (this.count >= 10)
    {
      if (this.isStop)
      {
        AppMethodBeat.o(18644);
        return -1L;
      }
      this.count = 0;
    }
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
          long l2;
          for (;;)
          {
            l2 = a((String)localObject, paramPLong);
            if (l2 != -1L) {
              break;
            }
            AppMethodBeat.o(18644);
            return -1L;
            localObject = "/".concat(String.valueOf(localObject));
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(18644);
        return l1;
      }
    }
    l1 = ((File)localObject).length();
    if (l1 > 0L) {
      paramPLong.value += 1L;
    }
    AppMethodBeat.o(18644);
    return l1;
  }
  
  public final void run()
  {
    AppMethodBeat.i(18643);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.i.c.YK();
    this.count = 0;
    PLong localPLong1 = new PLong();
    long l1 = a((String)localObject1, localPLong1);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.i.c.YL();
    this.count = 0;
    localObject1 = new PLong();
    long l2 = a((String)localObject2, (PLong)localObject1);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    aw.aaz();
    String str = com.tencent.mm.model.c.getAccVideoPath();
    this.count = 0;
    localObject2 = new PLong();
    long l3 = a(str, (PLong)localObject2);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    aw.aaz();
    str = com.tencent.mm.model.c.YM();
    this.count = 0;
    PLong localPLong2 = new PLong();
    long l4 = a(str, localPLong2);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    long l5 = com.tencent.mm.plugin.f.b.bak().bal().sS(43) + com.tencent.mm.plugin.f.b.bak().bal().sS(62) + com.tencent.mm.plugin.f.b.bak().bal().sS(44);
    long l6 = com.tencent.mm.plugin.f.b.bak().bal().sT(43) + com.tencent.mm.plugin.f.b.bak().bal().sT(62) + com.tencent.mm.plugin.f.b.bak().bal().sT(44);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    long l7 = com.tencent.mm.plugin.f.b.bak().bal().sS(3);
    long l8 = com.tencent.mm.plugin.f.b.bak().bal().sT(3);
    if (this.isStop)
    {
      AppMethodBeat.o(18643);
      return;
    }
    long l9 = com.tencent.mm.plugin.f.b.bak().bal().sS(34);
    long l10 = com.tencent.mm.plugin.f.b.bak().bal().sT(34);
    long l11 = com.tencent.mm.plugin.f.b.bak().bal().sS(49);
    long l12 = com.tencent.mm.plugin.f.b.bak().bal().sT(49);
    h.qsU.e(14556, new Object[] { Integer.valueOf(43), Long.valueOf(l5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l6) });
    h.qsU.e(14556, new Object[] { Integer.valueOf(3), Long.valueOf(l7), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l8) });
    h.qsU.e(14556, new Object[] { Integer.valueOf(34), Long.valueOf(l9), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l10) });
    h.qsU.e(14556, new Object[] { Integer.valueOf(49), Long.valueOf(l11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l12) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("image".hashCode()), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localPLong1.value) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("image2".hashCode()), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(((PLong)localObject1).value) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("video".hashCode()), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(((PLong)localObject2).value) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("voice".hashCode()), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localPLong2.value) });
    long l13 = ((Long)g.RL().Ru().get(ac.a.yHH, Long.valueOf(0L))).longValue();
    long l14 = ((Long)g.RL().Ru().get(ac.a.yHI, Long.valueOf(0L))).longValue();
    h.qsU.e(14556, new Object[] { Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l14 - l13) });
    ab.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", new Object[] { Long.valueOf(l5), Long.valueOf(l7), Long.valueOf(l9), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l8), Long.valueOf(l10), Long.valueOf(l12), Long.valueOf(((PLong)localObject2).value), Long.valueOf(((PLong)localObject1).value), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value) });
    AppMethodBeat.o(18643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.b
 * JD-Core Version:    0.7.0.1
 */