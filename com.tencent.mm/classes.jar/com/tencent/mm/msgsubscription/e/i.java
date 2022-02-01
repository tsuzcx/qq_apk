package com.tencent.mm.msgsubscription.e;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeStatusTimestamp;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "templateList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class i
  extends a
{
  public static final i.a mrd;
  private List<SubscribeMsgTmpItem> moB;
  private com.tencent.mm.msgsubscription.d.a mpb;
  private com.tencent.mm.msgsubscription.api.a mqF;
  
  static
  {
    AppMethodBeat.i(192934);
    mrd = new i.a((byte)0);
    AppMethodBeat.o(192934);
  }
  
  private i(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(192923);
    this.moB = ((List)new ArrayList());
    AppMethodBeat.o(192923);
  }
  
  private i(String paramString, List<SubscribeMsgTmpItem> paramList, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramString);
    AppMethodBeat.i(192927);
    this.mpb = parama;
    this.moB.addAll((Collection)paramList);
    this.mqF = null;
    AppMethodBeat.o(192927);
  }
  
  public final void run()
  {
    AppMethodBeat.i(192920);
    kotlin.g.a.a locala = (kotlin.g.a.a)new c(this);
    if (MMHandlerThread.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(192920);
      return;
    }
    h.ZvG.bc((Runnable)new i.b(locala));
    AppMethodBeat.o(192920);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.i
 * JD-Core Version:    0.7.0.1
 */