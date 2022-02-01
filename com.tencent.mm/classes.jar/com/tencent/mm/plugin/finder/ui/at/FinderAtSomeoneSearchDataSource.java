package com.tencent.mm.plugin.finder.ui.at;

import androidx.lifecycle.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.mvvmlist.a.b;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "", "Landroidx/lifecycle/LifecycleObserver;", "()V", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "resultListener", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource$FTSResultListener;", "destroy", "", "getSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "dataRequest", "Lcom/tencent/mm/plugin/mvvmlist/SearchDataRequest;", "stopSearch", "Companion", "FTSResultListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAtSomeoneSearchDataSource
  extends b<g, String>
  implements androidx.lifecycle.p
{
  public static final FinderAtSomeoneSearchDataSource.a FWz;
  private com.tencent.mm.plugin.fts.a.a.c DHR;
  private b FWA;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(347894);
    FWz = new FinderAtSomeoneSearchDataSource.a((byte)0);
    AppMethodBeat.o(347894);
  }
  
  public FinderAtSomeoneSearchDataSource()
  {
    AppMethodBeat.i(347884);
    this.rdm = kotlin.k.cm((a)FinderAtSomeoneSearchDataSource.c.FWC);
    AppMethodBeat.o(347884);
  }
  
  public final kotlinx.coroutines.b.g<d<g>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.h<g, String> paramh)
  {
    AppMethodBeat.i(347914);
    s.u(paramLifecycleScope, "scope");
    s.u(paramh, "dataRequest");
    paramLifecycleScope = new q();
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.query = ((String)paramh.Mnu);
    locall.qRb = 64;
    locall.Htx = new int[] { 131072, 131081 };
    locall.handler = ((MMHandler)this.rdm.getValue());
    this.FWA = new b((com.tencent.mm.plugin.mvvmlist.a.c)paramh, paramLifecycleScope);
    locall.HtC = ((com.tencent.mm.plugin.fts.a.l)this.FWA);
    locall.HtA.add(com.tencent.mm.model.z.bAM());
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    this.DHR = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
    paramLifecycleScope = kotlinx.coroutines.b.k.a((f)paramLifecycleScope);
    AppMethodBeat.o(347914);
    return paramLifecycleScope;
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_DESTROY)
  public final void destroy()
  {
    AppMethodBeat.i(347904);
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    this.DHR = null;
    this.FWA = null;
    AppMethodBeat.o(347904);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(347925);
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    AppMethodBeat.o(347925);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource$FTSResultListener;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "(Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getRequest", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "onFTSSearchEnd", "", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.plugin.fts.a.l
  {
    private final com.tencent.mm.plugin.mvvmlist.a.c<g> DHT;
    private final q<d<g>> ovy;
    
    public b(q<d<g>> paramq)
    {
      AppMethodBeat.i(347889);
      this.DHT = paramq;
      this.ovy = localObject;
      AppMethodBeat.o(347889);
    }
    
    public final void b(m paramm)
    {
      AppMethodBeat.i(347922);
      if (paramm != null)
      {
        Object localObject1 = FinderAtSomeoneSearchDataSource.this;
        if (s.p(paramm.HtE, FinderAtSomeoneSearchDataSource.a((FinderAtSomeoneSearchDataSource)localObject1))) {
          localObject1 = paramm;
        }
        while (localObject1 != null)
        {
          if (paramm.resultCode == 0)
          {
            d locald = new d(this.DHT);
            localObject1 = new ArrayList();
            Object localObject2 = paramm.HtF;
            s.s(localObject2, "result.resultList");
            localObject2 = ((Iterable)localObject2).iterator();
            Object localObject3;
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (o)((Iterator)localObject2).next();
                if (kotlin.a.p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(15) }).contains(Integer.valueOf(((o)localObject3).subtype)))
                {
                  ((ArrayList)localObject1).add(localObject3);
                  continue;
                  localObject1 = null;
                  break;
                }
              }
            }
            int i;
            if (!((Collection)localObject1).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label261;
              }
              label180:
              if (localObject1 != null) {
                break label266;
              }
            }
            for (localObject1 = null;; localObject1 = ah.aiuX)
            {
              if (localObject1 == null)
              {
                localObject1 = locald.pUj;
                localObject2 = new g(0, new au(), 4);
                ((g)localObject2).rpp = null;
                ((g)localObject2).FWt = paramm.FWt;
                paramm = ah.aiuX;
                ((ArrayList)localObject1).add(localObject2);
              }
              this.ovy.offer(locald);
              AppMethodBeat.o(347922);
              return;
              i = 0;
              break;
              label261:
              localObject1 = null;
              break label180;
              label266:
              localObject1 = ((Iterable)localObject1).iterator();
              i = 0;
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = ((Iterator)localObject1).next();
                if (i < 0) {
                  kotlin.a.p.kkW();
                }
                localObject3 = (o)localObject2;
                Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((o)localObject3).Hsz);
                localObject2 = locald.pUj;
                s.s(localObject4, "contact");
                localObject4 = new g(i, (au)localObject4, 2);
                ((g)localObject4).rpp = ((o)localObject3);
                ((g)localObject4).FWt = paramm.FWt;
                localObject3 = ah.aiuX;
                ((ArrayList)localObject2).add(localObject4);
                i += 1;
              }
            }
          }
          ((f)this.ovy).kDk();
        }
      }
      AppMethodBeat.o(347922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.FinderAtSomeoneSearchDataSource
 * JD-Core Version:    0.7.0.1
 */