package com.tencent.mm.modelvideo;

import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class o$4
  implements Runnable
{
  o$4(o paramo) {}
  
  public final void run()
  {
    if (!g.DK()) {
      return;
    }
    Object localObject1 = o.Sr();
    long l = System.currentTimeMillis() / 1000L;
    Object localObject2 = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + l + " WHERE masssendid > 0  AND status = 200";
    y.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject2 });
    ((t)localObject1).dXo.gk("videoinfo2", (String)localObject2);
    o.Sv().dXw.gk("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
    localObject1 = o.Sv();
    if (1209600000L <= 0L)
    {
      y.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
      ((l)localObject1).dXw.gk("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
    }
    for (;;)
    {
      localObject1 = o.Sv().Sm().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (j)((Iterator)localObject1).next();
        y.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", new Object[] { ((j)localObject2).field_fileName });
        com.tencent.mm.a.e.deleteFile(k.nI(((j)localObject2).field_fileName));
        com.tencent.mm.a.e.deleteFile(k.nJ(((j)localObject2).field_fileName));
      }
      break;
      l = bk.UY() - 1209600000L;
      y.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", new Object[] { Long.valueOf(l) });
      localObject2 = "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + l;
      ((l)localObject1).dXw.gk("SightDraftInfo", (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.o.4
 * JD-Core Version:    0.7.0.1
 */