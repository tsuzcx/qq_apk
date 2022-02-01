package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.sdk.platformtools.aq;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/task/SaveSubscribeMsgUIStatus;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "toSaveList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;ZZZLcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "subscribeMsgList", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class g
  extends a
{
  public static final g.a hIy;
  private List<SubscribeMsgTmpItem> hHO;
  private e.b hIf;
  private d hIg;
  private boolean hIv;
  private boolean hIw;
  private boolean hIx;
  
  static
  {
    AppMethodBeat.i(149692);
    hIy = new g.a((byte)0);
    AppMethodBeat.o(149692);
  }
  
  private g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149690);
    this.hHO = ((List)new ArrayList());
    AppMethodBeat.o(149690);
  }
  
  private g(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, d paramd)
  {
    this(paramString);
    AppMethodBeat.i(149691);
    this.hIg = paramd;
    this.hIf = null;
    this.hHO.addAll((Collection)paramList);
    this.hIv = paramBoolean1;
    this.hIw = paramBoolean2;
    this.hIx = paramBoolean3;
    AppMethodBeat.o(149691);
  }
  
  public final void run()
  {
    AppMethodBeat.i(149689);
    d.g.a.a locala = (d.g.a.a)new c(this);
    if (aq.isMainThread())
    {
      locala.invoke();
      AppMethodBeat.o(149689);
      return;
    }
    aq.f((Runnable)new g.b(locala));
    AppMethodBeat.o(149689);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.g
 * JD-Core Version:    0.7.0.1
 */