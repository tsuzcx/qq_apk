package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.protocal.protobuf.dhf;
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
  public final void ah(Map<String, String> paramMap)
  {
    AppMethodBeat.i(117495);
    super.ah(paramMap);
    com.tencent.mm.plugin.hp.b.b.Rw(2);
    String str1 = com.tencent.mm.loader.j.a.aSy();
    String str2 = com.tencent.mm.loader.j.a.aSz();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      dhf localdhf = new dhf();
      localdhf.key = ((String)localObject);
      localdhf.value = ((String)paramMap.get(localObject));
      localLinkedList.add(localdhf);
    }
    paramMap = new StringBuilder();
    localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (dhf)localIterator.next();
      paramMap.append(((dhf)localObject).key).append(":").append(((dhf)localObject).value).append("\n");
    }
    Log.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str1, str2, paramMap.toString() });
    paramMap = new d(str1, str2, localLinkedList);
    h.aGY().a(paramMap, 0);
    AppMethodBeat.o(117495);
  }
  
  public final boolean eIl()
  {
    AppMethodBeat.i(117494);
    boolean bool = super.eIl();
    AppMethodBeat.o(117494);
    return bool;
  }
  
  public final void eIm()
  {
    AppMethodBeat.i(117496);
    super.eIm();
    long l = com.tencent.mm.kernel.b.aGP();
    int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBw, 0);
    Object localObject = com.tinkerboots.sdk.a.izW().ph("uin", String.valueOf(0xFFFFFFFF & l));
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ph("network", String.valueOf(i)).ph("flavor-version", String.valueOf(j));
      localObject = ((c)h.ae(c.class)).cym();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.izW().ph(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
    AppMethodBeat.o(117496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.g
 * JD-Core Version:    0.7.0.1
 */