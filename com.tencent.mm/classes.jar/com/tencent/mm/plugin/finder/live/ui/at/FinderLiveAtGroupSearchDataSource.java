package com.tencent.mm.plugin.finder.live.ui.at;

import androidx.lifecycle.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.mvvmlist.a.b;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "", "Landroidx/lifecycle/LifecycleObserver;", "chatroom", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "resultListener", "Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource$FTSResultListener;", "destroy", "", "getSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "dataRequest", "Lcom/tencent/mm/plugin/mvvmlist/SearchDataRequest;", "stopSearch", "Companion", "FTSResultListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveAtGroupSearchDataSource
  extends b<com.tencent.mm.plugin.finder.ui.at.g, String>
  implements androidx.lifecycle.p
{
  public static final a akfz;
  private com.tencent.mm.plugin.fts.a.a.c DHR;
  private b akfA;
  private final String hCy;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(371294);
    akfz = new a((byte)0);
    AppMethodBeat.o(371294);
  }
  
  public FinderLiveAtGroupSearchDataSource(String paramString)
  {
    AppMethodBeat.i(371290);
    this.hCy = paramString;
    this.rdm = kotlin.k.cm((a)c.akfC);
    AppMethodBeat.o(371290);
  }
  
  public final kotlinx.coroutines.b.g<d<com.tencent.mm.plugin.finder.ui.at.g>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.h<com.tencent.mm.plugin.finder.ui.at.g, String> paramh)
  {
    AppMethodBeat.i(371298);
    s.u(paramLifecycleScope, "scope");
    s.u(paramh, "dataRequest");
    paramLifecycleScope = new q();
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.Htv = this.hCy;
    locall.query = ((String)paramh.Mnu);
    locall.qRb = 12;
    locall.handler = ((MMHandler)this.rdm.getValue());
    this.akfA = new b((com.tencent.mm.plugin.mvvmlist.a.c)paramh, paramLifecycleScope);
    locall.HtC = ((com.tencent.mm.plugin.fts.a.l)this.akfA);
    locall.HtA.add(com.tencent.mm.model.z.bAM());
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    this.DHR = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
    paramLifecycleScope = kotlinx.coroutines.b.k.a((f)paramLifecycleScope);
    AppMethodBeat.o(371298);
    return paramLifecycleScope;
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_DESTROY)
  public final void destroy()
  {
    AppMethodBeat.i(371296);
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    this.DHR = null;
    this.akfA = null;
    AppMethodBeat.o(371296);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(371299);
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    AppMethodBeat.o(371299);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource$FTSResultListener;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "(Lcom/tencent/mm/plugin/finder/live/ui/at/FinderLiveAtGroupSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getRequest", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "onFTSSearchEnd", "", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.plugin.fts.a.l
  {
    private final com.tencent.mm.plugin.mvvmlist.a.c<com.tencent.mm.plugin.finder.ui.at.g> DHT;
    private final q<d<com.tencent.mm.plugin.finder.ui.at.g>> ovy;
    
    public b(q<d<com.tencent.mm.plugin.finder.ui.at.g>> paramq)
    {
      AppMethodBeat.i(371289);
      this.DHT = paramq;
      this.ovy = localObject;
      AppMethodBeat.o(371289);
    }
    
    public final void b(m paramm)
    {
      AppMethodBeat.i(371292);
      if (paramm != null)
      {
        Object localObject1 = FinderLiveAtGroupSearchDataSource.this;
        d locald;
        if (s.p(paramm.HtE, FinderLiveAtGroupSearchDataSource.a((FinderLiveAtGroupSearchDataSource)localObject1)))
        {
          localObject1 = paramm;
          if (localObject1 == null) {
            break label261;
          }
          if (paramm.resultCode != 0) {
            break label249;
          }
          locald = new d(this.DHT);
          localObject1 = paramm.HtF;
          s.s(localObject1, "result.resultList");
          localObject1 = (o)kotlin.a.p.ae((List)localObject1, 0);
          if (localObject1 != null) {
            break label222;
          }
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label233;
          }
          localObject1 = ((o)localObject1).HtP;
          if (localObject1 == null) {
            break label233;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            localObject2 = (i)localObject2;
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((i)localObject2).username);
            localObject2 = locald.pUj;
            s.s(localObject3, "contact");
            localObject3 = new com.tencent.mm.plugin.finder.ui.at.g(i, (au)localObject3, 2);
            ((com.tencent.mm.plugin.finder.ui.at.g)localObject3).FWt = paramm.FWt;
            ah localah = ah.aiuX;
            ((ArrayList)localObject2).add(localObject3);
            i += 1;
          }
          localObject1 = null;
          break;
          label222:
          ((o)localObject1).FWt = paramm.FWt;
        }
        label233:
        this.ovy.offer(locald);
        AppMethodBeat.o(371292);
        return;
        label249:
        ((f)this.ovy).kDk();
      }
      label261:
      AppMethodBeat.o(371292);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<MMHandler>
  {
    public static final c akfC;
    
    static
    {
      AppMethodBeat.i(371291);
      akfC = new c();
      AppMethodBeat.o(371291);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.at.FinderLiveAtGroupSearchDataSource
 * JD-Core Version:    0.7.0.1
 */