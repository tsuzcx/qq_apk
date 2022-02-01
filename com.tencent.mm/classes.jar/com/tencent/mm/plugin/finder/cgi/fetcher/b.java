package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher;", "", "()V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "fetch", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "listen_event_type", "", "tabType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enhanceFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "recentStatsList", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "unreadFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "(IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderObject;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Task", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a ADX;
  public final com.tencent.mm.loader.f.h ADY;
  
  static
  {
    AppMethodBeat.i(336812);
    ADX = new a((byte)0);
    AppMethodBeat.o(336812);
  }
  
  public b()
  {
    AppMethodBeat.i(336806);
    com.tencent.mm.loader.f.h localh = new com.tencent.mm.loader.f.h("Finder.EnhanceStreamFetcher");
    localh.start();
    ah localah = ah.aiuX;
    this.ADY = localh;
    AppMethodBeat.o(336806);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher$Task;", "Lcom/tencent/mm/loader/loader/SingleTask;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "task", "Lkotlin/Function1;", "", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;)V", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "cancel", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends g
  {
    private final kotlinx.coroutines.a.h<com.tencent.mm.am.b.a<awp>> ADZ;
    
    public b(kotlinx.coroutines.a.h<com.tencent.mm.am.b.a<awp>> paramh, kotlin.g.a.b<? super g, ah> paramb)
    {
      super();
      AppMethodBeat.i(336795);
      this.ADZ = paramh;
      AppMethodBeat.o(336795);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(336800);
      super.cancel();
      ((x)this.ADZ).a(null);
      Log.w("Finder.EnhanceStreamFetcher", "Task cancel");
      AppMethodBeat.o(336800);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.b<g, ah>
  {
    public c(int paramInt1, bui parambui, FinderObject paramFinderObject, List<? extends fhp> paramList, List<? extends byg> paramList1, int paramInt2, kotlinx.coroutines.a.h<com.tencent.mm.am.b.a<awp>> paramh)
    {
      super();
    }
    
    private static final ah a(g paramg, kotlinx.coroutines.a.h paramh, final com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(336801);
      s.u(paramg, "$task");
      s.u(paramh, "$channel");
      paramg.a(i.nrG);
      kotlinx.coroutines.k.x((m)new a(paramh, parama, null));
      paramg = ah.aiuX;
      AppMethodBeat.o(336801);
      return paramg;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(kotlinx.coroutines.a.h<com.tencent.mm.am.b.a<awp>> paramh, com.tencent.mm.am.b.a<awp> parama, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(336826);
        paramObject = (d)new a(this.aaM, parama, paramd);
        AppMethodBeat.o(336826);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(336820);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(336820);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.aaM;
          com.tencent.mm.am.b.a locala1 = parama;
          s.s(locala1, "it");
          d locald = (d)this;
          this.label = 1;
          if (paramObject.b(locala1, locald) == locala)
          {
            AppMethodBeat.o(336820);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(336820);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b
 * JD-Core Version:    0.7.0.1
 */