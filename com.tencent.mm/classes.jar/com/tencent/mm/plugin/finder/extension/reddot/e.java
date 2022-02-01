package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.bbi;
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
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "checkDoSync", "", "source", "", "delayed", "", "checkExpired", "clearCheckDoSync", "getExpiredInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "innerCheckDoSync", "onAppBackground", "activity", "onAppForeground", "setup", "Companion", "plugin-finder_release"})
public final class e
  implements o
{
  public static final a tJs;
  private final MMHandler handler;
  final e tJr;
  final f toy;
  
  static
  {
    AppMethodBeat.i(243524);
    tJs = new a((byte)0);
    AppMethodBeat.o(243524);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(243523);
    this.toy = paramf;
    this.handler = new MMHandler("FinderRedDotExpired");
    this.tJr = new e(this);
    AppMethodBeat.o(243523);
  }
  
  private final void asU(final String paramString)
  {
    AppMethodBeat.i(243520);
    this.handler.post((Runnable)new c(this, paramString, 0L));
    AppMethodBeat.o(243520);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(243519);
    asU("onAppBackground");
    AppMethodBeat.o(243519);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(243511);
      Object localObject1 = e.day();
      k localk = this.tJt.toy.asX("FinderEntrance");
      Object localObject2 = new StringBuilder("[checkDoSync] hasEntranceRedDot=");
      if (localk != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.RedDotExpiredHandler", bool + " checkInfo=" + cj.a((apb)localObject1));
        if ((localk != null) && (((apb)localObject1).LBb == 1))
        {
          localObject2 = g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          int i = ((com.tencent.mm.kernel.e)localObject2).azQ().getInt(ar.a.OlV, 0);
          localObject2 = g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          long l2 = ((com.tencent.mm.kernel.e)localObject2).azQ().a(ar.a.OlU, 0L);
          long l1 = l2;
          if (l2 <= 0L)
          {
            l2 = localk.field_time;
            l1 = l2;
            if (l2 <= 0L) {
              l1 = cl.aWA();
            }
          }
          l1 = cl.aWA() - l1;
          Log.i("Finder.RedDotExpiredHandler", "[checkDoSync] diffTime=" + l1 + "ms checkCount=" + i + ", checkInfo=" + cj.a((apb)localObject1));
          if ((i < ((apb)localObject1).LBd) && (l1 >= ((apb)localObject1).LBc * 1000))
          {
            e.daz();
            localObject1 = g.aAh();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.OlV, Integer.valueOf(i + 1));
            localObject1 = g.aAh();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.OlU, Long.valueOf(cl.aWA()));
          }
        }
        AppMethodBeat.o(243511);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, String paramString, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(243513);
      Log.i("Finder.RedDotExpiredHandler", "[checkExpired] source=" + paramString + " delayed=" + this.tJv);
      final HashSet localHashSet = new HashSet();
      Iterator localIterator = ((Iterable)this.tJt.toy.daG()).iterator();
      label237:
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if ((localk.field_expiredTime > 0L) && (localk.field_expiredTime * 1000L + localk.field_time <= cl.aWA())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label237;
          }
          localHashSet.add(localk);
          Object localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          i = localk.field_ctrInfo.type;
          Object localObject2 = localk.field_tipsId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          String str = localk.field_revokeId;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          com.tencent.mm.plugin.finder.report.k.f(i, (String)localObject1, (String)localObject2, 2);
          Log.w("Finder.RedDotExpiredHandler", "[checkExpired] source=" + paramString + " ctrlInfo has expired! " + localk.field_ctrInfo.type);
          break;
        }
      }
      if (!((Collection)localHashSet).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.tJt.toy.a(-2147483648, (b)new q(localHashSet) {});
        }
        AppMethodBeat.o(243513);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d tJy;
    
    static
    {
      AppMethodBeat.i(243515);
      tJy = new d();
      AppMethodBeat.o(243515);
    }
    
    public final void run()
    {
      AppMethodBeat.i(243514);
      com.tencent.mm.kernel.e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.OlV, Integer.valueOf(0));
      locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.OlU, Long.valueOf(0L));
      AppMethodBeat.o(243514);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<kt>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.e
 * JD-Core Version:    0.7.0.1
 */