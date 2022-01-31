package com.tencent.mm.ai;

import android.net.Uri;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;

final class k$3
  implements Runnable
{
  k$3(k paramk, bi parambi, String paramString, int paramInt) {}
  
  public final void run()
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = ((a)g.r(a.class)).d(this.dUy.field_msgId, this.dUy.field_content);
    if ((localObject1 == null) || (bk.dk(((l)localObject1).dTx)))
    {
      k.a(this.egy, null, this.egz);
      return;
    }
    localObject1 = ((l)localObject1).dTx.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      m localm = (m)((Iterator)localObject1).next();
      String str = localm.url;
      if (!bk.bl(str))
      {
        Object localObject2 = Uri.parse(str);
        try
        {
          str = ((Uri)localObject2).getQueryParameter("mid");
          localObject2 = ((Uri)localObject2).getQueryParameter("idx");
          qj localqj = new qj();
          localqj.sxj = bk.getLong(str, 0L);
          localqj.nSM = bk.getInt((String)localObject2, 0);
          localqj.bOL = localm.dTM;
          localqj.path = localm.dTJ;
          localLinkedList.add(localqj);
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          y.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
        }
      }
    }
    k.a(this.egy, localLinkedList, this.egz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.k.3
 * JD-Core Version:    0.7.0.1
 */