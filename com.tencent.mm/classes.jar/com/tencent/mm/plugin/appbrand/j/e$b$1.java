package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class e$b$1
  implements Runnable
{
  e$b$1(e.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(132279);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = e.b.a(this.irK).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e.a)((Iterator)localObject1).next();
      if (((e.a)localObject2).aIb())
      {
        localObject3 = new cch();
        ((cch)localObject3).xMI = ((e.a)localObject2).bCZ;
        ((cch)localObject3).cwc = ((e.a)localObject2).appId;
        localLinkedList.add(localObject3);
      }
    }
    localObject1 = this.irK;
    if (localLinkedList.size() <= 0)
    {
      ab.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
      ((e.b)localObject1).aId();
      AppMethodBeat.o(132279);
      return;
    }
    ab.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    Object localObject2 = new b.a();
    ((b.a)localObject2).funcId = 2954;
    ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
    Object localObject3 = new aqv();
    ((aqv)localObject3).xgb = localLinkedList;
    ((b.a)localObject2).fsX = ((a)localObject3);
    ((b.a)localObject2).fsY = new aqw();
    w.a(((b.a)localObject2).ado(), new e.b.2((e.b)localObject1));
    AppMethodBeat.o(132279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.e.b.1
 * JD-Core Version:    0.7.0.1
 */