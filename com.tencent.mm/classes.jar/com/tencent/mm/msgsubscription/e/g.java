package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/task/UpdateLocalSubscribeStatus;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "toSaveList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;ZZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class g
  extends a
{
  public static final g.a mqU;
  private List<SubscribeMsgTmpItem> moB;
  private boolean moH;
  private com.tencent.mm.msgsubscription.d.a mpb;
  private com.tencent.mm.msgsubscription.api.a mqF;
  private boolean mqS;
  private boolean mqT;
  
  static
  {
    AppMethodBeat.i(215601);
    mqU = new g.a((byte)0);
    AppMethodBeat.o(215601);
  }
  
  private g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(215596);
    this.moB = ((List)new ArrayList());
    AppMethodBeat.o(215596);
  }
  
  private g(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramString);
    AppMethodBeat.i(215597);
    this.mpb = parama;
    this.mqF = null;
    this.moB.addAll((Collection)paramList);
    this.moH = paramBoolean1;
    this.mqS = paramBoolean2;
    this.mqT = paramBoolean3;
    AppMethodBeat.o(215597);
  }
  
  public final void run()
  {
    AppMethodBeat.i(215594);
    kotlin.g.a.a locala = (kotlin.g.a.a)new c(this);
    if (MMHandlerThread.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(215594);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new g.b(locala));
    AppMethodBeat.o(215594);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.g
 * JD-Core Version:    0.7.0.1
 */