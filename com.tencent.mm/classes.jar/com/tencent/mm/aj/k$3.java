package com.tencent.mm.aj;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;

final class k$3
  implements Runnable
{
  k$3(k paramk, caf paramcaf, String paramString, bi parambi, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(11403);
    k.a(this.fwB, this.fwC);
    if ((this.fkH == null) || (!this.fkH.dvV()))
    {
      k.a(this.fwC, 10, null, this.fwD, this.fwB);
      AppMethodBeat.o(11403);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = ((a)g.E(a.class)).b(this.fkH.field_msgId, this.fkH.field_content);
    if ((localObject1 == null) || (bo.es(((p)localObject1).fjy)))
    {
      k.a(this.fwC, 10, null, this.fwD, this.fwB);
      AppMethodBeat.o(11403);
      return;
    }
    localObject1 = ((p)localObject1).fjy.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      q localq = (q)((Iterator)localObject1).next();
      String str = localq.url;
      if (!bo.isNullOrNil(str))
      {
        Object localObject2 = Uri.parse(str);
        try
        {
          str = ((Uri)localObject2).getQueryParameter("mid");
          localObject2 = ((Uri)localObject2).getQueryParameter("idx");
          to localto = new to();
          localto.kfs = bo.getLong(str, 0L);
          localto.kft = bo.getInt((String)localObject2, 0);
          localto.cwc = localq.fjS;
          localto.path = localq.fjP;
          localLinkedList.add(localto);
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          ab.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
        }
      }
    }
    k.a(this.fwC, 10, localLinkedList, this.fwD, this.fwB);
    AppMethodBeat.o(11403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aj.k.3
 * JD-Core Version:    0.7.0.1
 */