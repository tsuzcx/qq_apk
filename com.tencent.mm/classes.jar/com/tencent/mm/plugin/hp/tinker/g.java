package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends com.tinkerboots.sdk.a.a.a
{
  public final void ah(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.ah(paramMap);
    com.tencent.mm.plugin.hp.b.b.FZ(2);
    String str1 = com.tencent.mm.loader.j.a.arH();
    String str2 = com.tencent.mm.loader.j.a.arI();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      cgt localcgt = new cgt();
      localcgt.key = ((String)localObject);
      localcgt.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localcgt);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (cgt)localIterator.next();
      paramMap.append(((cgt)localObject).key).append(":").append(((cgt)localObject).value).append("\n");
    }
    ad.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new d(str1, str2, localLinkedList);
    com.tencent.mm.kernel.g.aiU().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean dcC()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.dcC();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void dcD()
  {
    AppMethodBeat.i(117496);
    super.dcD();
    long l = com.tencent.mm.kernel.a.aiN();
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvo, 0);
    Object localObject = com.tinkerboots.sdk.a.gdU().nm("uin", String.valueOf(0xFFFFFFFF & l));
    if (ay.isWifi(aj.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).nm("network", String.valueOf(i)).nm("flavor-version", String.valueOf(j));
      localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).bMT();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.gdU().nm(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */