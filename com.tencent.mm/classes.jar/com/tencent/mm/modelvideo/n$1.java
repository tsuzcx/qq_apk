package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

final class n$1
  implements Runnable
{
  n$1(n paramn, String paramString, com.tencent.mm.j.d paramd) {}
  
  public final void run()
  {
    n.a locala = (n.a)n.a(this.eGT).remove(this.doz);
    if (locala == null) {
      return;
    }
    int k = e.bJ(locala.eHe);
    a locala2 = com.tencent.mm.plugin.sight.base.d.MH(locala.eHe);
    a locala1;
    if (!bk.bl(locala.eHd)) {
      locala1 = com.tencent.mm.plugin.sight.base.d.MH(locala.eHd);
    }
    for (int i = e.bJ(locala.eHd); (locala1 == null) || (locala2 == null); i = k)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.eHe });
      return;
      locala1 = locala2;
    }
    int m = aq.fJ(ae.getContext());
    long l1;
    if (this.eGS.field_startTime != 0L)
    {
      l1 = this.eGS.field_startTime;
      if (this.eGS.field_endTime == 0L) {
        break label239;
      }
    }
    label239:
    for (long l2 = this.eGS.field_endTime;; l2 = bk.UY())
    {
      localObject1 = null;
      if (this.eGS.field_usedSvrIps == null) {
        break label254;
      }
      localObject1 = new StringBuffer();
      localObject2 = this.eGS.field_usedSvrIps;
      int n = localObject2.length;
      int j = 0;
      while (j < n)
      {
        ((StringBuffer)localObject1).append(localObject2[j]).append("|");
        j += 1;
      }
      l1 = locala.startTime;
      break;
    }
    Object localObject1 = ((StringBuffer)localObject1).toString();
    label254:
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(locala.toUser).append(",").append(locala.czr).append(",");
    ((StringBuffer)localObject2).append(m).append(",").append(this.eGS.field_fileId).append(",");
    ((StringBuffer)localObject2).append(this.eGS.field_mp4identifymd5).append(",").append(c.PU(locala.eHf)).append(",");
    ((StringBuffer)localObject2).append(l1).append(",").append(l2).append(",");
    ((StringBuffer)localObject2).append(i).append(",").append(locala1.jlu).append(",");
    ((StringBuffer)localObject2).append(locala1.videoBitrate / 1000).append(",").append(locala1.ejM / 1000).append(",");
    ((StringBuffer)localObject2).append(locala1.eIM).append(",").append(locala1.width).append(",");
    ((StringBuffer)localObject2).append(locala1.height).append(",").append(locala.eHg).append(",");
    ((StringBuffer)localObject2).append(k).append(",").append(locala2.jlu).append(",");
    ((StringBuffer)localObject2).append(locala2.videoBitrate / 1000).append(",").append(locala2.ejM / 1000).append(",");
    ((StringBuffer)localObject2).append(locala2.eIM).append(",").append(locala2.width).append(",");
    ((StringBuffer)localObject2).append(locala2.height).append(",").append(locala.eHh).append(",");
    ((StringBuffer)localObject2).append((String)localObject1).append(",").append(locala1.odX).append(",").append(this.eGS.field_fileUrl);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject2).toString() });
    new com.tencent.mm.h.b.a.y(((StringBuffer)localObject2).toString()).QX();
    n.bx(locala2.videoBitrate, locala.eHh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n.1
 * JD-Core Version:    0.7.0.1
 */