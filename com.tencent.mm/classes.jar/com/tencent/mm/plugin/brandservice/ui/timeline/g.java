package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  int igF;
  int igG;
  int igH;
  HashMap<String, g.a> igI = new HashMap();
  
  public g(int paramInt)
  {
    this.igH = paramInt;
  }
  
  static int a(q paramq, String paramString)
  {
    if ((paramq.field_appMsgStatInfoProto == null) || (bk.bl(paramString)) || (bk.dk(paramq.field_appMsgStatInfoProto.sxo))) {
      return 0;
    }
    paramq = paramq.field_appMsgStatInfoProto.sxo.iterator();
    while (paramq.hasNext())
    {
      ds localds = (ds)paramq.next();
      if (bk.isEqual(localds.url, paramString)) {
        return localds.sxn;
      }
    }
    return 0;
  }
  
  static void a(g.a parama, String paramString)
  {
    if (((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramString).Bl())
    {
      parama.sDz = 1;
      parama.sDD = 1;
      return;
    }
    parama.sDz = 0;
    parama.sDD = 0;
  }
  
  public final void a(q paramq, boolean paramBoolean)
  {
    paramq = (g.a)this.igI.get(Long.valueOf(paramq.field_msgId));
    if (paramq == null) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramq.sDy = i;
      return;
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    h.nFQ.f(15721, new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.igH) });
  }
  
  public final void b(q paramq, int paramInt)
  {
    int i = paramq.field_status;
    int j = paramq.field_isRead;
    com.tencent.mm.kernel.g.DS().O(new g.1(this, paramq, paramInt, i, j));
  }
  
  public final void c(q paramq, int paramInt)
  {
    l2 = 0L;
    l1 = l2;
    if (paramq.ctz()) {}
    try
    {
      Object localObject = ((a)com.tencent.mm.kernel.g.r(a.class)).d(paramq.field_msgId, paramq.field_content);
      if ((localObject == null) || (bk.dk(((l)localObject).dTx))) {
        break label160;
      }
      localObject = (m)((l)localObject).dTx.get(0);
      if (bk.bl(((m)localObject).url)) {
        break label160;
      }
      l1 = bk.getLong(Uri.parse(((m)localObject).url).getQueryParameter("mid"), 0L);
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        y.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
        l1 = l2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
        l1 = l2;
        continue;
        l1 = 0L;
      }
    }
    a(paramq.field_talker, l1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */