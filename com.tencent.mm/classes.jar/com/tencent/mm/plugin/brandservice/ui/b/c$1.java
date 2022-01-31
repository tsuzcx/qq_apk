package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.cg.h;
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
    AppMethodBeat.i(14450);
    if ((c.access$000().containsKey(Long.valueOf(this.jMz.field_msgId))) && (!c.sN(((Integer)c.access$000().get(Long.valueOf(this.jMz.field_msgId))).intValue())))
    {
      AppMethodBeat.o(14450);
      return;
    }
    List localList = z.afo().al(5, this.jMz.field_orderFlag);
    Object localObject = z.afo();
    long l = this.jMz.field_orderFlag;
    localObject = r.n(((r)localObject).fnw.query("BizTimeLineInfo", null, "orderFlag>?", new String[] { String.valueOf(l) }, null, null, "orderFlag DESC limit 5"));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(localList);
    localLinkedList.add(this.jMz);
    localLinkedList.addAll((Collection)localObject);
    c.aZ(localLinkedList);
    AppMethodBeat.o(14450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c.1
 * JD-Core Version:    0.7.0.1
 */