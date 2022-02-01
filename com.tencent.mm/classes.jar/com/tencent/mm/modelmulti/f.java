package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.fla;
import java.util.Queue;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelmulti/MMKVHandlerProcessor;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/modelmulti/ISyncProcessor;", "syncData", "Lcom/tencent/mm/protocal/protobuf/SyncServiceData;", "(Lcom/tencent/mm/protocal/protobuf/SyncServiceData;)V", "getSyncData", "()Lcom/tencent/mm/protocal/protobuf/SyncServiceData;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getType", "hashCode", "run", "", "list", "Ljava/util/Queue;", "toString", "", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends p
  implements e
{
  private final fla oLw;
  
  public f(fla paramfla)
  {
    AppMethodBeat.i(243108);
    this.oLw = paramfla;
    AppMethodBeat.o(243108);
  }
  
  public final boolean d(Queue<e> paramQueue)
  {
    return false;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    return -1;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final int hashCode()
  {
    return this.oLw.abLB;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243112);
    String str = "MMKVHandlerProcessor[" + this.oLw.abLB + ']';
    AppMethodBeat.o(243112);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.f
 * JD-Core Version:    0.7.0.1
 */