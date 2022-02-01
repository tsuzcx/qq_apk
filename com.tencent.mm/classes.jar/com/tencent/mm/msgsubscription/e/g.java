package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/UpdateLocalSubscribeStatus;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "toSaveList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;ZZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "getType", "", "run", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public static final g.a pkt;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private List<SubscribeMsgTmpItem> pis;
  private boolean piy;
  private com.tencent.mm.msgsubscription.api.a pkl;
  private boolean pku;
  private boolean pkv;
  
  static
  {
    AppMethodBeat.i(236450);
    pkt = new g.a((byte)0);
    AppMethodBeat.o(236450);
  }
  
  private g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236398);
    this.pis = ((List)new ArrayList());
    AppMethodBeat.o(236398);
  }
  
  private g(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramString);
    AppMethodBeat.i(236406);
    this.piQ = parama;
    this.pkl = null;
    this.pis.addAll((Collection)paramList);
    this.piy = paramBoolean1;
    this.pku = paramBoolean2;
    this.pkv = paramBoolean3;
    AppMethodBeat.o(236406);
  }
  
  private static final void ag(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236421);
    s.u(parama, "$job");
    parama.invoke();
    AppMethodBeat.o(236421);
  }
  
  public final void run()
  {
    AppMethodBeat.i(236466);
    kotlin.g.a.a locala = (kotlin.g.a.a)new b(this);
    if (MMHandlerThread.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(236466);
      return;
    }
    MMHandlerThread.postToMainThread(new g..ExternalSyntheticLambda0(locala));
    AppMethodBeat.o(236466);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.g
 * JD-Core Version:    0.7.0.1
 */