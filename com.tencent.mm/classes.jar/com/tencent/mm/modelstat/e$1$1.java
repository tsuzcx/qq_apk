package com.tencent.mm.modelstat;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.y;

final class e$1$1
  implements am.a
{
  boolean eCW = false;
  
  e$1$1(e.1 param1, e.b paramb, e.c paramc, String paramString1, String paramString2) {}
  
  public final boolean tC()
  {
    boolean bool = l.dR(ae.getContext());
    long l1 = bk.UY();
    long l2 = l1 - e.a(this.eDb.eCV);
    if (l2 <= e.g(this.eDb.eCV))
    {
      if (bool)
      {
        this.eCW = false;
        return true;
      }
      if (!this.eCW)
      {
        this.eCW = true;
        return true;
      }
    }
    y.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.eCW), Boolean.valueOf(bool), Long.valueOf(l2) });
    e.a(this.eDb.eCV, 0L);
    String str1 = this.eCX.Rr();
    Object localObject = this.eCY.Rr();
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder;
        if ((bk.bl(str1)) || (bk.bl((String)localObject)))
        {
          y.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str1, localObject });
          localObject = h.nFQ;
          localStringBuilder = new StringBuilder().append(this.eCZ).append(this.eDa);
          if (!bk.bl(str1))
          {
            str1 = ",-10011,ERROR:StopFailed.";
            ((h)localObject).aC(13381, str1);
            return false;
          }
        }
        else
        {
          localObject = str1 + (String)localObject;
          int j = (int)Math.ceil(((String)localObject).length() / 5400.0D);
          int i = 0;
          if (i < j)
          {
            localStringBuilder = new StringBuilder().append(this.eCZ).append(this.eDa).append("_").append(l1).append("_").append(j).append("_");
            if (l2 > e.g(this.eDb.eCV))
            {
              str1 = "1";
              str1 = str1 + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
              y.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str1.length()), str1 });
              h.nFQ.aC(13381, str1);
              i += 1;
              continue;
            }
            str1 = "2";
            continue;
          }
          return false;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
      }
      String str2 = ",-10012,ERROR:StopFailed.";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.1.1
 * JD-Core Version:    0.7.0.1
 */