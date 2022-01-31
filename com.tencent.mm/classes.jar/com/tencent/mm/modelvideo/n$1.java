package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class n$1
  implements Runnable
{
  n$1(n paramn, String paramString, com.tencent.mm.i.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(50752);
    n.a locala = (n.a)n.a(this.fWJ).remove(this.val$key);
    if (locala == null)
    {
      AppMethodBeat.o(50752);
      return;
    }
    int k = e.cM(locala.fWU);
    a locala2 = com.tencent.mm.plugin.sight.base.d.Zo(locala.fWU);
    a locala1;
    int i;
    if (!bo.isNullOrNil(locala.fWT))
    {
      locala1 = com.tencent.mm.plugin.sight.base.d.Zo(locala.fWT);
      i = e.cM(locala.fWT);
    }
    while ((locala1 == null) || (locala2 == null))
    {
      ab.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.fWU });
      AppMethodBeat.o(50752);
      return;
      i = k;
      locala1 = locala2;
    }
    int m = at.gW(ah.getContext());
    long l1;
    if (this.fWI.field_startTime != 0L)
    {
      l1 = this.fWI.field_startTime;
      if (this.fWI.field_endTime == 0L) {
        break label254;
      }
    }
    label254:
    for (long l2 = this.fWI.field_endTime;; l2 = bo.aoy())
    {
      localObject1 = null;
      if (this.fWI.field_usedSvrIps == null) {
        break label269;
      }
      localObject1 = new StringBuffer();
      localObject2 = this.fWI.field_usedSvrIps;
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
    label269:
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(locala.toUser).append(",").append(locala.dns).append(",");
    ((StringBuffer)localObject2).append(m).append(",").append(this.fWI.field_fileId).append(",");
    ((StringBuffer)localObject2).append(this.fWI.field_mp4identifymd5).append(",").append(c.aeA(locala.fWV)).append(",");
    ((StringBuffer)localObject2).append(l1).append(",").append(l2).append(",");
    ((StringBuffer)localObject2).append(i).append(",").append(locala1.eVA).append(",");
    ((StringBuffer)localObject2).append(locala1.videoBitrate / 1000).append(",").append(locala1.fzT / 1000).append(",");
    ((StringBuffer)localObject2).append(locala1.eRw).append(",").append(locala1.width).append(",");
    ((StringBuffer)localObject2).append(locala1.height).append(",").append(locala.fWW).append(",");
    ((StringBuffer)localObject2).append(k).append(",").append(locala2.eVA).append(",");
    ((StringBuffer)localObject2).append(locala2.videoBitrate / 1000).append(",").append(locala2.fzT / 1000).append(",");
    ((StringBuffer)localObject2).append(locala2.eRw).append(",").append(locala2.width).append(",");
    ((StringBuffer)localObject2).append(locala2.height).append(",").append(locala.fWX).append(",");
    ((StringBuffer)localObject2).append((String)localObject1).append(",").append(locala1.qSh).append(",").append(this.fWI.field_fileUrl);
    ab.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject2).toString() });
    new bl(((StringBuffer)localObject2).toString()).ake();
    n.cH(locala2.videoBitrate, locala.fWX);
    if ((locala2.qSi == 1) || (locala2.qSj == 1))
    {
      ab.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala.fWU });
      n.a(locala2, locala.fWX);
    }
    AppMethodBeat.o(50752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n.1
 * JD-Core Version:    0.7.0.1
 */