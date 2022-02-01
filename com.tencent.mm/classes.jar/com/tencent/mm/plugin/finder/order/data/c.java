package com.tencent.mm.plugin.finder.order.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/OrderSearchFeedLoader;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "lastOffset", "", "pageSize", "callback", "Lkotlin/Function5;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerSearchOrderListResp;", "", "(Lcom/tencent/mm/ui/MMActivity;IILkotlin/jvm/functions/Function5;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lkotlin/jvm/functions/Function5;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/order/data/OrderFeed;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "getLastOffset", "()I", "setLastOffset", "(I)V", "getPageSize", "query", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "requestingCgi", "Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerSearchOrderList;", "getRequestingCgi", "()Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerSearchOrderList;", "setRequestingCgi", "(Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerSearchOrderList;)V", "doCgi", "loadMore", "refresh", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final kotlin.g.a.s<Integer, Integer, alt, Integer, Integer, ah> Azf;
  int ESj;
  com.tencent.mm.plugin.finder.order.cgi.c ESw;
  final String TAG;
  private final MMActivity activity;
  public final ArrayList<a> pUj;
  private final int pageSize;
  String query;
  
  public c(MMActivity paramMMActivity, kotlin.g.a.s<? super Integer, ? super Integer, ? super alt, ? super Integer, ? super Integer, ah> params)
  {
    AppMethodBeat.i(332331);
    this.activity = paramMMActivity;
    this.ESj = 0;
    this.pageSize = 10;
    this.Azf = params;
    this.TAG = "Finder.OrderSearchFeedLoader";
    this.pUj = new ArrayList();
    this.query = "";
    AppMethodBeat.o(332331);
  }
  
  private static final ah a(c paramc, b.a parama)
  {
    AppMethodBeat.i(332338);
    kotlin.g.b.s.u(paramc, "this$0");
    d.uiThread((kotlin.g.a.a)new c.a(paramc, parama));
    paramc = ah.aiuX;
    AppMethodBeat.o(332338);
    return paramc;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.data.c
 * JD-Core Version:    0.7.0.1
 */