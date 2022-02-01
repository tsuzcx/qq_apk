package com.tencent.mm.plugin.hld.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "rets", "Ljava/util/LinkedList;", "", "kotlin.jvm.PlatformType", "oplogErrMsgs", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "operations", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onOpLogResult", "com/tencent/mm/plugin/hld/cgi/IPCOplogImeSetting$invoke$1$2"})
final class e$b
  implements h.a
{
  e$b(e parame, boolean paramBoolean, long paramLong, f paramf) {}
  
  public final void a(LinkedList<Integer> paramLinkedList, LinkedList<dgv> paramLinkedList1, ArrayList<k.b> paramArrayList)
  {
    AppMethodBeat.i(217621);
    p.j(paramLinkedList, "rets");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    if (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (Integer)paramLinkedList.next();
      if (paramLinkedList1 != null) {}
    }
    label44:
    for (boolean bool = false;; bool = true)
    {
      paramLinkedList = new Bundle();
      paramLinkedList.putBoolean("success", bool);
      this.Dvv.aH(paramLinkedList);
      Log.i("WxIme.IPCOplogImeSetting", "success:".concat(String.valueOf(bool)));
      AppMethodBeat.o(217621);
      return;
      if (paramLinkedList1.intValue() == 0) {
        break;
      }
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.e.b
 * JD-Core Version:    0.7.0.1
 */