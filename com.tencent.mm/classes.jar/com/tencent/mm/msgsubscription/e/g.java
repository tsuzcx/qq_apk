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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/UpdateLocalSubscribeStatus;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "toSaveList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;ZZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class g
  extends a
{
  public static final g.a jBl;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private boolean jBj;
  private boolean jBk;
  private List<SubscribeMsgTmpItem> jyV;
  private boolean jzb;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223398);
    jBl = new g.a((byte)0);
    AppMethodBeat.o(223398);
  }
  
  private g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223396);
    this.jyV = ((List)new ArrayList());
    AppMethodBeat.o(223396);
  }
  
  private g(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.msgsubscription.d.a parama)
  {
    this(paramString);
    AppMethodBeat.i(223397);
    this.jzv = parama;
    this.jAX = null;
    this.jyV.addAll((Collection)paramList);
    this.jzb = paramBoolean1;
    this.jBj = paramBoolean2;
    this.jBk = paramBoolean3;
    AppMethodBeat.o(223397);
  }
  
  public final void run()
  {
    AppMethodBeat.i(223395);
    kotlin.g.a.a locala = (kotlin.g.a.a)new c(this);
    if (MMHandlerThread.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(223395);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new g.b(locala));
    AppMethodBeat.o(223395);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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