package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/task/SaveSubscribeMsgUIStatus;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "toSaveList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;ZZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class g
  extends a
{
  public static final a iFl;
  private List<SubscribeMsgTmpItem> iED;
  private e.b iEU;
  private d iEV;
  private boolean iFi;
  private boolean iFj;
  private boolean iFk;
  
  static
  {
    AppMethodBeat.i(149692);
    iFl = new a((byte)0);
    AppMethodBeat.o(149692);
  }
  
  private g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149690);
    this.iED = ((List)new ArrayList());
    AppMethodBeat.o(149690);
  }
  
  private g(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, d paramd)
  {
    this(paramString);
    AppMethodBeat.i(149691);
    this.iEV = paramd;
    this.iEU = null;
    this.iED.addAll((Collection)paramList);
    this.iFi = paramBoolean1;
    this.iFj = paramBoolean2;
    this.iFk = paramBoolean3;
    AppMethodBeat.o(149691);
  }
  
  public final void run()
  {
    AppMethodBeat.i(149689);
    d.g.a.a locala = (d.g.a.a)new c(this);
    if (ar.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(149689);
      return;
    }
    ar.f((Runnable)new b(locala));
    AppMethodBeat.o(149689);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/task/SaveSubscribeMsgUIStatus$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(149687);
      this.iFm.invoke();
      AppMethodBeat.o(149687);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.g
 * JD-Core Version:    0.7.0.1
 */