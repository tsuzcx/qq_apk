package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/HldOplogBatchResult;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogBatchResult;", "()V", "TAG", "", "onOpLogResult", "", "rets", "Ljava/util/LinkedList;", "", "oplogErrMsgs", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "operations", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements h.a
{
  public static final d JoH;
  
  static
  {
    AppMethodBeat.i(312062);
    JoH = new d();
    AppMethodBeat.o(312062);
  }
  
  public final void onOpLogResult(LinkedList<Integer> paramLinkedList, LinkedList<dzc> paramLinkedList1, ArrayList<k.b> paramArrayList)
  {
    AppMethodBeat.i(312073);
    Object localObject = new StringBuilder("onOpLogResult ");
    l locall = l.JyV;
    paramLinkedList = ((StringBuilder)localObject).append(l.iB((List)paramLinkedList)).append(' ');
    localObject = l.JyV;
    paramLinkedList = paramLinkedList.append(l.b((List)paramLinkedList1, (b)a.JoI)).append(' ');
    paramLinkedList1 = l.JyV;
    Log.i("WxIme.HldOplogBatchResult", l.b((List)paramArrayList, (b)d.b.JoJ));
    AppMethodBeat.o(312073);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<dzc, String>
  {
    public static final a JoI;
    
    static
    {
      AppMethodBeat.i(312018);
      JoI = new a();
      AppMethodBeat.o(312018);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.d
 * JD-Core Version:    0.7.0.1
 */