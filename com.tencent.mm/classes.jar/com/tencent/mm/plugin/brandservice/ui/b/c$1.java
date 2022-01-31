package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.mm.ai.z;
import com.tencent.mm.cf.h;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(q paramq) {}
  
  public final void run()
  {
    if ((c.aiY().containsKey(Long.valueOf(this.hSM.field_msgId))) && (!c.oG(((Integer)c.aiY().get(Long.valueOf(this.hSM.field_msgId))).intValue()))) {
      return;
    }
    List localList = z.ME().W(5, this.hSM.field_orderFlag);
    Object localObject = z.ME();
    long l = this.hSM.field_orderFlag;
    localObject = r.m(((r)localObject).dXo.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(l) }, null, null, "orderFlag DESC limit 5"));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(localList);
    localLinkedList.add(this.hSM);
    localLinkedList.addAll((Collection)localObject);
    c.aL(localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c.1
 * JD-Core Version:    0.7.0.1
 */