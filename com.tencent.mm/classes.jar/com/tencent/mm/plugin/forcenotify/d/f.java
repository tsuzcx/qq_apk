package com.tencent.mm.plugin.forcenotify.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "", "()V", "historyIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "itemQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "add", "", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "item", "hasNext", "", "next", "setExpired", "forcePushId", "size", "", "Companion", "plugin-force-notify_release"})
public final class f
{
  public static final a BDU;
  private static final kotlin.f kPd;
  public final ConcurrentLinkedQueue<e> BDS;
  public final HashSet<String> BDT;
  
  static
  {
    AppMethodBeat.i(253847);
    BDU = new a((byte)0);
    kPd = g.ar((a)f.b.BDV);
    AppMethodBeat.o(253847);
  }
  
  private f()
  {
    AppMethodBeat.i(253846);
    this.BDS = new ConcurrentLinkedQueue();
    this.BDT = new HashSet();
    AppMethodBeat.o(253846);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(253841);
    p.k(parame, "item");
    if (this.BDT.contains(parame.BDR))
    {
      Log.i("ForceNotifyItemMgr", "add info failed, historyIdSet contains " + parame.BDR);
      AppMethodBeat.o(253841);
      return;
    }
    this.BDS.offer(parame);
    this.BDT.add(parame.BDR);
    AppMethodBeat.o(253841);
  }
  
  public final void aHv(String paramString)
  {
    AppMethodBeat.i(253842);
    p.k(paramString, "forcePushId");
    this.BDT.remove(paramString);
    AppMethodBeat.o(253842);
  }
  
  public final e eqk()
  {
    AppMethodBeat.i(253844);
    e locale = (e)this.BDS.poll();
    AppMethodBeat.o(253844);
    return locale;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(253843);
    if (!this.BDS.isEmpty())
    {
      AppMethodBeat.o(253843);
      return true;
    }
    AppMethodBeat.o(253843);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "getInstance", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "instance$delegate", "Lkotlin/Lazy;", "plugin-force-notify_release"})
  public static final class a
  {
    public static f eql()
    {
      AppMethodBeat.i(253500);
      Object localObject = f.aRW();
      a locala = f.BDU;
      localObject = (f)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(253500);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "invoke"})
  public static final class c
    extends q
    implements b<h, x>
  {
    public c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.f
 * JD-Core Version:    0.7.0.1
 */