package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "checkDoSync", "", "source", "", "delayed", "", "checkExpired", "clearCheckDoSync", "getExpiredInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "innerCheckDoSync", "onAppBackground", "activity", "onAppForeground", "setup", "Companion", "plugin-finder_release"})
public final class e
  implements o
{
  public static final a xsD;
  private final MMHandler handler;
  final f wVw;
  final e xsC;
  
  static
  {
    AppMethodBeat.i(291795);
    xsD = new a((byte)0);
    AppMethodBeat.o(291795);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(291794);
    this.wVw = paramf;
    this.handler = new MMHandler("FinderRedDotExpired");
    this.xsC = new e(this);
    AppMethodBeat.o(291794);
  }
  
  private final void aBc(final String paramString)
  {
    AppMethodBeat.i(291791);
    this.handler.post((Runnable)new c(this, paramString, 0L));
    AppMethodBeat.o(291791);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(291790);
    aBc("onAppBackground");
    AppMethodBeat.o(291790);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(284089);
      Object localObject1 = e.dqz();
      l locall = this.xsE.wVw.aBf("FinderEntrance");
      Object localObject2 = new StringBuilder("[checkDoSync] hasEntranceRedDot=");
      if (locall != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.RedDotExpiredHandler", bool + " checkInfo=" + cn.a((aqn)localObject1));
        if ((locall != null) && (((aqn)localObject1).SDK == 1))
        {
          localObject2 = h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          int i = ((com.tencent.mm.kernel.f)localObject2).aHp().getInt(ar.a.VAR, 0);
          localObject2 = h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          long l2 = ((com.tencent.mm.kernel.f)localObject2).aHp().a(ar.a.VAQ, 0L);
          long l1 = l2;
          if (l2 <= 0L)
          {
            l2 = locall.field_time;
            l1 = l2;
            if (l2 <= 0L) {
              l1 = cm.bfE();
            }
          }
          l1 = cm.bfE() - l1;
          Log.i("Finder.RedDotExpiredHandler", "[checkDoSync] diffTime=" + l1 + "ms checkCount=" + i + ", checkInfo=" + cn.a((aqn)localObject1));
          if ((i < ((aqn)localObject1).SDM) && (l1 >= ((aqn)localObject1).SDL * 1000))
          {
            e.dqA();
            localObject1 = h.aHG();
            p.j(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAR, Integer.valueOf(i + 1));
            localObject1 = h.aHG();
            p.j(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAQ, Long.valueOf(cm.bfE()));
          }
        }
        AppMethodBeat.o(284089);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(285236);
      Log.i("Finder.RedDotExpiredHandler", "[checkExpired] source=" + paramString + " delayed=" + this.xsG);
      final HashSet localHashSet = new HashSet();
      Iterator localIterator = ((Iterable)this.xsE.wVw.dqH()).iterator();
      label237:
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if ((locall.field_expiredTime > 0L) && (locall.field_expiredTime * 1000L + locall.field_time <= cm.bfE())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label237;
          }
          localHashSet.add(locall);
          Object localObject1 = n.zWF;
          i = locall.field_ctrInfo.type;
          Object localObject2 = locall.field_tipsId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          String str = locall.field_revokeId;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          n.f(i, (String)localObject1, (String)localObject2, 2);
          Log.w("Finder.RedDotExpiredHandler", "[checkExpired] source=" + paramString + " ctrlInfo has expired! " + locall.field_ctrInfo.type);
          break;
        }
      }
      if (!((Collection)localHashSet).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.xsE.wVw.b(-2147483648, (b)new q(localHashSet) {});
        }
        AppMethodBeat.o(285236);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d xsJ;
    
    static
    {
      AppMethodBeat.i(260311);
      xsJ = new d();
      AppMethodBeat.o(260311);
    }
    
    public final void run()
    {
      AppMethodBeat.i(260310);
      com.tencent.mm.kernel.f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VAR, Integer.valueOf(0));
      localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VAQ, Long.valueOf(0L));
      AppMethodBeat.o(260310);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<lk>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.e
 * JD-Core Version:    0.7.0.1
 */