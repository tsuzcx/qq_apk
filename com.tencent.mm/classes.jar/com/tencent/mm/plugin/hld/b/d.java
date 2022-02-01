package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/HldOplogBatchResult;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogBatchResult;", "()V", "TAG", "", "onOpLogResult", "", "rets", "Ljava/util/LinkedList;", "", "oplogErrMsgs", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "operations", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "plugin-hld_release"})
public final class d
  implements h.a
{
  public static final d Dvn;
  
  static
  {
    AppMethodBeat.i(211937);
    Dvn = new d();
    AppMethodBeat.o(211937);
  }
  
  public final void a(LinkedList<Integer> paramLinkedList, LinkedList<dgv> paramLinkedList1, ArrayList<k.b> paramArrayList)
  {
    AppMethodBeat.i(211935);
    Object localObject = new StringBuilder("onOpLogResult ");
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    paramLinkedList = ((StringBuilder)localObject).append(com.tencent.mm.plugin.hld.f.l.fE((List)paramLinkedList)).append(' ');
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    paramLinkedList = paramLinkedList.append(com.tencent.mm.plugin.hld.f.l.b((List)paramLinkedList1, (b)a.Dvo)).append(' ');
    paramLinkedList1 = com.tencent.mm.plugin.hld.f.l.DHK;
    Log.i("WxIme.HldOplogBatchResult", com.tencent.mm.plugin.hld.f.l.b((List)paramArrayList, (b)b.Dvp));
    AppMethodBeat.o(211935);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "invoke"})
  static final class a
    extends q
    implements b<dgv, String>
  {
    public static final a Dvo;
    
    static
    {
      AppMethodBeat.i(215782);
      Dvo = new a();
      AppMethodBeat.o(215782);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "invoke"})
  static final class b
    extends q
    implements b<k.b, String>
  {
    public static final b Dvp;
    
    static
    {
      AppMethodBeat.i(215338);
      Dvp = new b();
      AppMethodBeat.o(215338);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.d
 * JD-Core Version:    0.7.0.1
 */