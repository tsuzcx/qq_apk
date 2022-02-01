package com.tencent.mm.msgsubscription.e;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/UpdateSubscribeStatusTimestamp;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "templateList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class i
  extends a
{
  public static final i.a jBu;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private List<SubscribeMsgTmpItem> jyV;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223413);
    jBu = new i.a((byte)0);
    AppMethodBeat.o(223413);
  }
  
  private i(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223411);
    this.jyV = ((List)new ArrayList());
    AppMethodBeat.o(223411);
  }
  
  private i(String paramString, List<SubscribeMsgTmpItem> paramList, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramString);
    AppMethodBeat.i(223412);
    this.jzv = parama;
    this.jyV.addAll((Collection)paramList);
    this.jAX = null;
    AppMethodBeat.o(223412);
  }
  
  public final void run()
  {
    AppMethodBeat.i(223410);
    kotlin.g.a.a locala = (kotlin.g.a.a)new c(this);
    if (MMHandlerThread.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(223410);
      return;
    }
    h.RTc.aV((Runnable)new i.b(locala));
    AppMethodBeat.o(223410);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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