package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.msgsubscription.storage.g;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/task/LoadLocalSubscribeMsgListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class f
  extends a
{
  public static final f.a hIu;
  private e.b hIf;
  private d hIg;
  
  static
  {
    AppMethodBeat.i(149686);
    hIu = new f.a((byte)0);
    AppMethodBeat.o(149686);
  }
  
  private f(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149684);
    AppMethodBeat.o(149684);
  }
  
  public f(String paramString, d paramd, e.b paramb)
  {
    this(paramString);
    AppMethodBeat.i(149685);
    this.hIg = paramd;
    this.hIf = paramb;
    AppMethodBeat.o(149685);
  }
  
  public final void run()
  {
    AppMethodBeat.i(149683);
    Object localObject1 = this.hIg;
    if (localObject1 != null) {}
    ArrayList localArrayList;
    Object localObject3;
    for (localObject1 = ((d)localObject1).xy(this.dta);; localObject1 = null)
    {
      localArrayList = new ArrayList();
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).hHO;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubscribeMsgTmpItem)((Iterator)localObject2).next();
        if (((SubscribeMsgTmpItem)localObject3).hGu == 3) {
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = this.hIf;
    if (localObject2 != null)
    {
      localObject3 = this.dta;
      if (localObject1 == null) {
        break label167;
      }
    }
    label167:
    for (boolean bool = ((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).hHP;; bool = false)
    {
      ((e.b)localObject2).a((String)localObject3, new SubscribeMsgRequestResult(localArrayList, bool));
      localObject1 = g.hHX;
      g.a((a)this);
      AppMethodBeat.o(149683);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.f
 * JD-Core Version:    0.7.0.1
 */