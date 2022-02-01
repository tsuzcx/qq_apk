package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends com.tinkerboots.sdk.a.a.a
{
  public final void ao(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.ao(paramMap);
    com.tencent.mm.plugin.hp.b.b.Mg(2);
    String str1 = com.tencent.mm.loader.j.a.aKw();
    String str2 = com.tencent.mm.loader.j.a.aKx();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      cxu localcxu = new cxu();
      localcxu.key = ((String)localObject);
      localcxu.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localcxu);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (cxu)localIterator.next();
      paramMap.append(((cxu)localObject).key).append(":").append(((cxu)localObject).value).append("\n");
    }
    Log.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new d(str1, str2, localLinkedList);
    com.tencent.mm.kernel.g.azz().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean dZo()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.dZo();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void dZp()
  {
    AppMethodBeat.i(117496);
    super.dZp();
    long l = com.tencent.mm.kernel.a.azs();
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVb, 0);
    Object localObject = com.tinkerboots.sdk.a.hvX().ol("uin", String.valueOf(0xFFFFFFFF & l));
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ol("network", String.valueOf(i)).ol("flavor-version", String.valueOf(j));
      localObject = ((c)com.tencent.mm.kernel.g.af(c.class)).ckR();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.hvX().ol(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */