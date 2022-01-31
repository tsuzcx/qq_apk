package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends com.tinkerboots.sdk.a.a.a
{
  public final void M(Map<String, String> paramMap)
  {
    AppMethodBeat.i(90659);
    super.M(paramMap);
    com.tencent.mm.plugin.hp.b.b.xu(2);
    String str2 = "tinker_id_" + com.tencent.mm.loader.j.a.Uj();
    if (com.tencent.mm.loader.j.a.eQt == null) {}
    LinkedList localLinkedList;
    Object localObject;
    for (String str1 = "";; str1 = "tinker_id_" + com.tencent.mm.loader.j.a.eQt)
    {
      localLinkedList = new LinkedList();
      localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        bjt localbjt = new bjt();
        localbjt.key = ((String)localObject);
        localbjt.value = ((String)paramMap.get(localObject));
        localLinkedList.add(localbjt);
      }
    }
    paramMap = new StringBuilder();
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (bjt)localIterator.next();
      paramMap.append(((bjt)localObject).key).append(":").append(((bjt)localObject).value).append("\n");
    }
    ab.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str2, str1, paramMap.toString() });
    paramMap = new com.tencent.mm.plugin.hp.c.b(str2, str1, localLinkedList);
    com.tencent.mm.kernel.g.Rc().a(paramMap, 0);
    AppMethodBeat.o(90659);
  }
  
  public final boolean bIp()
  {
    AppMethodBeat.i(90658);
    boolean bool = super.bIp();
    AppMethodBeat.o(90658);
    return bool;
  }
  
  public final void bIq()
  {
    AppMethodBeat.i(90660);
    super.bIq();
    long l = com.tencent.mm.kernel.a.QW();
    Object localObject = com.tinkerboots.sdk.a.eaJ().ji("uin", String.valueOf(l & 0xFFFFFFFF));
    if (at.isWifi(ah.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ji("network", String.valueOf(i));
      localObject = ((c)com.tencent.mm.kernel.g.E(c.class)).aWg();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.eaJ().ji(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(90660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */