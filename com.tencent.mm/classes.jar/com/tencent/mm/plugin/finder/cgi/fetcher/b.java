package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.t;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher;", "", "()V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "fetch", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enhanceFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "recentStatsList", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "unreadFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderObject;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Task", "plugin-finder_release"})
public final class b
{
  public static final a xeN;
  public final i xeM;
  
  static
  {
    AppMethodBeat.i(279788);
    xeN = new a((byte)0);
    AppMethodBeat.o(279788);
  }
  
  public b()
  {
    AppMethodBeat.i(279787);
    i locali = new i("Finder.EnhanceStreamFetcher");
    locali.start();
    this.xeM = locali;
    AppMethodBeat.o(279787);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher$Task;", "Lcom/tencent/mm/loader/loader/SingleTask;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "task", "Lkotlin/Function1;", "", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;)V", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "cancel", "plugin-finder_release"})
  public static final class b
    extends h
  {
    private final g<c.a<asd>> xeO;
    
    public b(g<c.a<asd>> paramg, kotlin.g.a.b<? super h, x> paramb)
    {
      super();
      AppMethodBeat.i(276640);
      this.xeO = paramg;
      AppMethodBeat.o(276640);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(276638);
      super.cancel();
      this.xeO.a(null);
      Log.w("Finder.EnhanceStreamFetcher", "Task cancel");
      AppMethodBeat.o(276638);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<h, x>
  {
    public c(int paramInt, bid parambid, FinderObject paramFinderObject, List paramList1, List paramList2, aa.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.b
 * JD-Core Version:    0.7.0.1
 */