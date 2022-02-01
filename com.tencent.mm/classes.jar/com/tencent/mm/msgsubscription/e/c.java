package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.d.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/GetLocalSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final c.a pkn;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private com.tencent.mm.msgsubscription.api.a pkl;
  
  static
  {
    AppMethodBeat.i(236399);
    pkn = new c.a((byte)0);
    AppMethodBeat.o(236399);
  }
  
  private c(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236388);
    AppMethodBeat.o(236388);
  }
  
  public c(String paramString, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString);
    AppMethodBeat.i(236393);
    this.piQ = parama;
    this.pkl = parama1;
    AppMethodBeat.o(236393);
  }
  
  public final void run()
  {
    AppMethodBeat.i(236410);
    Object localObject1 = this.piQ;
    if (localObject1 == null) {}
    ArrayList localArrayList;
    Object localObject3;
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.msgsubscription.d.a)localObject1).Re(this.hUQ))
    {
      localArrayList = new ArrayList();
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).pis;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubscribeMsgTmpItem)((Iterator)localObject2).next();
        if (((SubscribeMsgTmpItem)localObject3).phR == 3) {
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = this.pkl;
    if (localObject2 != null)
    {
      localObject3 = this.hUQ;
      if (localObject1 != null) {
        break label164;
      }
    }
    label164:
    for (boolean bool = false;; bool = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).pit)
    {
      ((com.tencent.mm.msgsubscription.api.a)localObject2).a((String)localObject3, new SubscribeMsgRequestResult(localArrayList, bool));
      localObject1 = d.pkg;
      d.a((a)this);
      AppMethodBeat.o(236410);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.c
 * JD-Core Version:    0.7.0.1
 */