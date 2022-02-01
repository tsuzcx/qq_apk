package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends com.tinkerboots.sdk.a.a.a
{
  public final void ac(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.ac(paramMap);
    b.EN(2);
    String str1 = com.tencent.mm.loader.j.a.aoU();
    String str2 = com.tencent.mm.loader.j.a.aoV();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      ccc localccc = new ccc();
      localccc.key = ((String)localObject);
      localccc.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localccc);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (ccc)localIterator.next();
      paramMap.append(((ccc)localObject).key).append(":").append(((ccc)localObject).value).append("\n");
    }
    ac.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new d(str1, str2, localLinkedList);
    com.tencent.mm.kernel.g.agi().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean cTs()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.cTs();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void cTt()
  {
    AppMethodBeat.i(117496);
    super.cTt();
    long l = com.tencent.mm.kernel.a.agb();
    Object localObject = com.tinkerboots.sdk.a.fMx().mO("uin", String.valueOf(l & 0xFFFFFFFF));
    if (ax.isWifi(ai.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).mO("network", String.valueOf(i));
      localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).bIG();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.fMx().mO(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */