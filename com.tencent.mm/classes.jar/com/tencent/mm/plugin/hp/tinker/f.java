package com.tencent.mm.plugin.hp.tinker;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.c.bxr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends com.tinkerboots.sdk.a.a.a
{
  public final void C(Map<String, String> paramMap)
  {
    super.C(paramMap);
    b.sv(2);
    String str2 = "tinker_id_" + com.tencent.mm.loader.a.a.EP();
    if (com.tencent.mm.loader.a.a.dON == null) {}
    LinkedList localLinkedList;
    Object localObject;
    for (String str1 = "";; str1 = "tinker_id_" + com.tencent.mm.loader.a.a.dON)
    {
      localLinkedList = new LinkedList();
      localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        bxr localbxr = new bxr();
        localbxr.key = ((String)localObject);
        localbxr.value = ((String)paramMap.get(localObject));
        localLinkedList.add(localbxr);
      }
    }
    paramMap = new StringBuilder();
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (bxr)localIterator.next();
      paramMap.append(((bxr)localObject).key).append(":").append(((bxr)localObject).value).append("\n");
    }
    y.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[] { str2, str1, paramMap.toString() });
    paramMap = new com.tencent.mm.plugin.hp.c.a(str2, str1, localLinkedList);
    au.Dk().a(paramMap, 0);
  }
  
  public final boolean bbk()
  {
    return super.bbk();
  }
  
  public final void bbl()
  {
    super.bbl();
    long l = com.tencent.mm.kernel.a.De();
    Object localObject = com.tinkerboots.sdk.a.cTY().gV("uin", String.valueOf(l & 0xFFFFFFFF));
    if (aq.isWifi(ae.getContext())) {}
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).gV("network", String.valueOf(i));
      localObject = ((c)g.r(c.class)).awD();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.boots.a.a locala = (com.tencent.mm.plugin.boots.a.a)((Iterator)localObject).next();
        com.tinkerboots.sdk.a.cTY().gV(Integer.toHexString(locala.field_key), String.valueOf(locala.field_dau));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.f
 * JD-Core Version:    0.7.0.1
 */