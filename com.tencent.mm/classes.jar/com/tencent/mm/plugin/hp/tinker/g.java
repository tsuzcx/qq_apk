package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.protobuf.bxh;
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
  public final void ab(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.ab(paramMap);
    b.EW(2);
    String str1 = com.tencent.mm.loader.j.a.ahU();
    String str2 = com.tencent.mm.loader.j.a.ahV();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      bxh localbxh = new bxh();
      localbxh.key = ((String)localObject);
      localbxh.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localbxh);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (bxh)localIterator.next();
      paramMap.append(((bxh)localObject).key).append(":").append(((bxh)localObject).value).append("\n");
    }
    ad.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new com.tencent.mm.plugin.hp.net.c(str1, str2, localLinkedList);
    com.tencent.mm.kernel.g.aeS().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean cGi()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.cGi();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void cGj()
  {
    AppMethodBeat.i(117496);
    super.cGj();
    long l = com.tencent.mm.kernel.a.aeL();
    Object localObject = com.tinkerboots.sdk.a.ftM().mn("uin", String.valueOf(l & 0xFFFFFFFF));
    if (ay.isWifi(aj.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).mn("network", String.valueOf(i));
      localObject = ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).bBI();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.ftM().mn(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */