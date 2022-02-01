package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.dzo;
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
  public final void ax(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.ax(paramMap);
    com.tencent.mm.plugin.hp.model.c.UA(2);
    String str1 = com.tencent.mm.loader.i.a.bmm();
    String str2 = com.tencent.mm.loader.i.a.bmn();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      dzo localdzo = new dzo();
      localdzo.key = ((String)localObject);
      localdzo.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localdzo);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (dzo)localIterator.next();
      paramMap.append(((dzo)localObject).key).append(":").append(((dzo)localObject).value).append("\n");
    }
    Log.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new d(str1, str2, localLinkedList);
    h.aZW().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean fQe()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.fQe();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void fQf()
  {
    AppMethodBeat.i(117496);
    super.fQf();
    long l = b.aZP();
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yPx, 0);
    Object localObject = com.tinkerboots.sdk.a.kkr().rg("uin", String.valueOf(0xFFFFFFFF & l));
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).rg("network", String.valueOf(i)).rg("flavor-version", String.valueOf(j));
      localObject = ((com.tencent.mm.plugin.boots.a.c)h.ax(com.tencent.mm.plugin.boots.a.c.class)).dbd();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.kkr().rg(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */