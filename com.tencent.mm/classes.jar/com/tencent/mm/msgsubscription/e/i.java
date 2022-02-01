package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeStatusTimestamp;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "templateList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "", "getType", "", "run", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  public static final i.a pkB;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private List<SubscribeMsgTmpItem> pis;
  private com.tencent.mm.msgsubscription.api.a pkl;
  
  static
  {
    AppMethodBeat.i(236442);
    pkB = new i.a((byte)0);
    AppMethodBeat.o(236442);
  }
  
  private i(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236404);
    this.pis = ((List)new ArrayList());
    AppMethodBeat.o(236404);
  }
  
  private i(String paramString, List<SubscribeMsgTmpItem> paramList, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramString);
    AppMethodBeat.i(236413);
    this.piQ = parama;
    this.pis.addAll((Collection)paramList);
    this.pkl = null;
    AppMethodBeat.o(236413);
  }
  
  private static final void ag(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236425);
    s.u(parama, "$job");
    parama.invoke();
    AppMethodBeat.o(236425);
  }
  
  public final void run()
  {
    AppMethodBeat.i(236451);
    kotlin.g.a.a locala = (kotlin.g.a.a)new b(this);
    if (MMHandlerThread.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(236451);
      return;
    }
    h.ahAA.bk(new i..ExternalSyntheticLambda0(locala));
    AppMethodBeat.o(236451);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.i
 * JD-Core Version:    0.7.0.1
 */