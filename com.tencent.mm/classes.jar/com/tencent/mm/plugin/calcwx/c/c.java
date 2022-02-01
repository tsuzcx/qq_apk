package com.tencent.mm.plugin.calcwx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.calcwx.a;
import com.tencent.mm.plugin.calcwx.b.b;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.u;

public final class c
  implements Runnable
{
  private int count = 0;
  public boolean isStop = false;
  
  private long a(String paramString, PLong paramPLong)
  {
    long l1 = 0L;
    AppMethodBeat.i(22753);
    if (this.count >= 10)
    {
      if (this.isStop)
      {
        AppMethodBeat.o(22753);
        return -1L;
      }
      this.count = 0;
    }
    Object localObject = new u(paramString);
    if (((u)localObject).isDirectory())
    {
      String[] arrayOfString = ((u)localObject).jKW();
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
            AppMethodBeat.o(22753);
            return -1L;
            localObject = "/".concat(String.valueOf(localObject));
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(22753);
        return l1;
      }
    }
    l1 = ((u)localObject).length();
    if (l1 > 0L) {
      paramPLong.value += 1L;
    }
    AppMethodBeat.o(22753);
    return l1;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22752);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    Object localObject1 = d.bzL();
    this.count = 0;
    PLong localPLong1 = new PLong();
    long l1 = a((String)localObject1, localPLong1);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    Object localObject2 = d.bzM();
    this.count = 0;
    localObject1 = new PLong();
    long l2 = a((String)localObject2, (PLong)localObject1);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    bh.bCz();
    String str = com.tencent.mm.model.c.getAccVideoPath();
    this.count = 0;
    localObject2 = new PLong();
    long l3 = a(str, (PLong)localObject2);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    bh.bCz();
    str = com.tencent.mm.model.c.bzN();
    this.count = 0;
    PLong localPLong2 = new PLong();
    long l4 = a(str, localPLong2);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    long l5 = a.diz().diA().Ib(43) + a.diz().diA().Ib(62) + a.diz().diA().Ib(44);
    long l6 = a.diz().diA().Ic(43) + a.diz().diA().Ic(62) + a.diz().diA().Ic(44);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    long l7 = a.diz().diA().Ib(3);
    long l8 = a.diz().diA().Ic(3);
    if (this.isStop)
    {
      AppMethodBeat.o(22752);
      return;
    }
    long l9 = a.diz().diA().Ib(34);
    long l10 = a.diz().diA().Ic(34);
    long l11 = a.diz().diA().Ib(49);
    long l12 = a.diz().diA().Ic(49);
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf(43), Long.valueOf(l5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l6) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf(3), Long.valueOf(l7), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l8) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf(34), Long.valueOf(l9), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l10) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf(49), Long.valueOf(l11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l12) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("image".hashCode()), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localPLong1.value) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("image2".hashCode()), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(((PLong)localObject1).value) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("video".hashCode()), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(((PLong)localObject2).value) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("voice".hashCode()), Long.valueOf(l4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localPLong2.value) });
    long l13 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTr, Long.valueOf(0L))).longValue();
    long l14 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTs, Long.valueOf(0L))).longValue();
    com.tencent.mm.plugin.report.service.h.OAn.b(14556, new Object[] { Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l14 - l13) });
    Log.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", new Object[] { Long.valueOf(l5), Long.valueOf(l7), Long.valueOf(l9), Long.valueOf(l11), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l8), Long.valueOf(l10), Long.valueOf(l12), Long.valueOf(((PLong)localObject2).value), Long.valueOf(((PLong)localObject1).value), Long.valueOf(localPLong2.value), Long.valueOf(localPLong1.value) });
    AppMethodBeat.o(22752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.c.c
 * JD-Core Version:    0.7.0.1
 */