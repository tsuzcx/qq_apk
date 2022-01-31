package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$2
  implements Runnable
{
  b$2(b paramb, List paramList, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(156614);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.gcR.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((LinkedList)localObject1).add(new bwc().aoF((String)localObject3));
      ab.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", new Object[] { localObject3 });
    }
    localObject2 = new bwc().aoF(this.gcS);
    Object localObject3 = new bwc().aoF(this.gcT);
    g.Rc().a(228, this.gcU);
    localObject1 = new a(((LinkedList)localObject1).size(), (LinkedList)localObject1, (bwc)localObject2, (bwc)localObject3);
    int i = this.fwD;
    if (((a)localObject1).gcQ != null) {
      ((a)localObject1).gcQ.Scene = i;
    }
    g.Rc().a((m)localObject1, 0);
    AppMethodBeat.o(156614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.b.2
 * JD-Core Version:    0.7.0.1
 */