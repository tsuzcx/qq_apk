package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.d.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/GetLocalSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class c
  extends a
{
  public static final c.a jBb;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223380);
    jBb = new c.a((byte)0);
    AppMethodBeat.o(223380);
  }
  
  private c(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223378);
    AppMethodBeat.o(223378);
  }
  
  public c(String paramString, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString);
    AppMethodBeat.i(223379);
    this.jzv = parama;
    this.jAX = parama1;
    AppMethodBeat.o(223379);
  }
  
  public final void run()
  {
    AppMethodBeat.i(223377);
    Object localObject1 = this.jzv;
    if (localObject1 != null) {}
    ArrayList localArrayList;
    Object localObject3;
    for (localObject1 = ((com.tencent.mm.msgsubscription.d.a)localObject1).RA(this.dVu);; localObject1 = null)
    {
      localArrayList = new ArrayList();
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).jyV;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubscribeMsgTmpItem)((Iterator)localObject2).next();
        if (((SubscribeMsgTmpItem)localObject3).jyz == 3) {
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = this.jAX;
    if (localObject2 != null)
    {
      localObject3 = this.dVu;
      if (localObject1 == null) {
        break label167;
      }
    }
    label167:
    for (boolean bool = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).jyW;; bool = false)
    {
      ((com.tencent.mm.msgsubscription.api.a)localObject2).a((String)localObject3, new SubscribeMsgRequestResult(localArrayList, bool));
      localObject1 = d.jAR;
      d.a((a)this);
      AppMethodBeat.o(223377);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.c
 * JD-Core Version:    0.7.0.1
 */