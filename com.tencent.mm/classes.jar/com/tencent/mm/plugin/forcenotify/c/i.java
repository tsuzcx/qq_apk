package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "", "()V", "historyIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "itemQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "add", "", "item", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "hasNext", "", "next", "setExpired", "forcePushId", "size", "", "Companion", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a Hos;
  private static final j<i> nqI;
  final ConcurrentLinkedQueue<a> Hot;
  public final HashSet<String> Hou;
  
  static
  {
    AppMethodBeat.i(274859);
    Hos = new a((byte)0);
    nqI = kotlin.k.cm((kotlin.g.a.a)i.b.Hov);
    AppMethodBeat.o(274859);
  }
  
  private i()
  {
    AppMethodBeat.i(274843);
    this.Hot = new ConcurrentLinkedQueue();
    this.Hou = new HashSet();
    AppMethodBeat.o(274843);
  }
  
  public final void aDR(String paramString)
  {
    AppMethodBeat.i(274867);
    s.u(paramString, "forcePushId");
    this.Hou.remove(paramString);
    AppMethodBeat.o(274867);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(274864);
    s.u(parama, "item");
    if (this.Hou.contains(parama.id))
    {
      Log.i("ForceNotifyItemMgr", s.X("add info failed, historyIdSet contains ", parama.id));
      AppMethodBeat.o(274864);
      return;
    }
    this.Hot.offer(parama);
    this.Hou.add(parama.id);
    AppMethodBeat.o(274864);
  }
  
  public final a fwM()
  {
    AppMethodBeat.i(274874);
    a locala = (a)this.Hot.poll();
    AppMethodBeat.o(274874);
    return locala;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(274872);
    if (!this.Hot.isEmpty())
    {
      AppMethodBeat.o(274872);
      return true;
    }
    AppMethodBeat.o(274872);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "getInstance", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "instance$delegate", "Lkotlin/Lazy;", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static i fwN()
    {
      AppMethodBeat.i(274877);
      i locali = (i)i.blL().getValue();
      AppMethodBeat.o(274877);
      return locali;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements b<k, ah>
  {
    public c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.i
 * JD-Core Version:    0.7.0.1
 */