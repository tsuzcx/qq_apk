package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends com.tinkerboots.sdk.a.a.a
{
  public final void an(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.an(paramMap);
    com.tencent.mm.plugin.hp.b.b.Gz(2);
    String str1 = com.tencent.mm.loader.j.a.arW();
    String str2 = com.tencent.mm.loader.j.a.arX();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      chn localchn = new chn();
      localchn.key = ((String)localObject);
      localchn.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localchn);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (chn)localIterator.next();
      paramMap.append(((chn)localObject).key).append(":").append(((chn)localObject).value).append("\n");
    }
    ae.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new d(str1, str2, localLinkedList);
    com.tencent.mm.kernel.g.ajj().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean dfu()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.dfu();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void dfv()
  {
    AppMethodBeat.i(117496);
    super.dfv();
    long l = com.tencent.mm.kernel.a.ajc();
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCn, 0);
    Object localObject = com.tinkerboots.sdk.a.gix().ns("uin", String.valueOf(0xFFFFFFFF & l));
    if (az.isWifi(ak.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ns("network", String.valueOf(i)).ns("flavor-version", String.valueOf(j));
      localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).bNR();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.gix().ns(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */