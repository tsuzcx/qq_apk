package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.o;

final class e$1$1
  implements ap.a
{
  boolean fSN = false;
  
  e$1$1(e.1 param1, e.b paramb, e.c paramc, String paramString1, String paramString2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78715);
    boolean bool = o.eD(ah.getContext());
    long l1 = bo.aoy();
    long l2 = l1 - e.a(this.fSS.fSM);
    if (l2 <= e.g(this.fSS.fSM))
    {
      if (bool)
      {
        this.fSN = false;
        AppMethodBeat.o(78715);
        return true;
      }
      if (!this.fSN)
      {
        this.fSN = true;
        AppMethodBeat.o(78715);
        return true;
      }
    }
    ab.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.fSN), Boolean.valueOf(bool), Long.valueOf(l2) });
    e.a(this.fSS.fSM, 0L);
    String str = this.fSO.akA();
    Object localObject = this.fSP.akA();
    try
    {
      StringBuilder localStringBuilder;
      if ((bo.isNullOrNil(str)) || (bo.isNullOrNil((String)localObject)))
      {
        ab.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
        localObject = h.qsU;
        localStringBuilder = new StringBuilder().append(this.fSQ).append(this.fSR);
        if (!bo.isNullOrNil(str)) {}
        for (str = ",-10011,ERROR:StopFailed.";; str = ",-10012,ERROR:StopFailed.")
        {
          ((h)localObject).kvStat(13381, str);
          AppMethodBeat.o(78715);
          return false;
        }
      }
      localObject = str + (String)localObject;
      int j = (int)Math.ceil(((String)localObject).length() / 5400.0D);
      int i = 0;
      if (i < j)
      {
        localStringBuilder = new StringBuilder().append(this.fSQ).append(this.fSR).append("_").append(l1).append("_").append(j).append("_");
        if (l2 > e.g(this.fSS.fSM)) {}
        for (str = "1";; str = "2")
        {
          str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
          ab.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
          h.qsU.kvStat(13381, str);
          i += 1;
          break;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(78715);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.1.1
 * JD-Core Version:    0.7.0.1
 */