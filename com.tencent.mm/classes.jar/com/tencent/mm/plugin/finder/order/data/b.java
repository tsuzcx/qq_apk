package com.tencent.mm.plugin.finder.order.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/OrderFeedLoader;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "tabType", "", "lastBuffer", "", "pageSize", "callback", "Lkotlin/Function5;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerGetOrderListResp;", "", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;ILkotlin/jvm/functions/Function5;)V", "TAG", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lkotlin/jvm/functions/Function5;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/order/data/OrderFeed;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Ljava/lang/String;", "setLastBuffer", "(Ljava/lang/String;)V", "getPageSize", "()I", "requestingCgi", "Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerGetOrderList;", "getRequestingCgi", "()Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerGetOrderList;", "setRequestingCgi", "(Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerGetOrderList;)V", "getTabType", "doCgi", "loadMore", "refresh", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final kotlin.g.a.s<Integer, Integer, alq, Integer, Integer, ah> Azf;
  String ESi;
  com.tencent.mm.plugin.finder.order.cgi.b ESu;
  final String TAG;
  private final MMActivity activity;
  private final int hJx;
  public final ArrayList<a> pUj;
  private final int pageSize;
  
  public b(MMActivity paramMMActivity, int paramInt, String paramString, kotlin.g.a.s<? super Integer, ? super Integer, ? super alq, ? super Integer, ? super Integer, ah> params)
  {
    AppMethodBeat.i(332332);
    this.activity = paramMMActivity;
    this.hJx = paramInt;
    this.ESi = paramString;
    this.pageSize = 10;
    this.Azf = params;
    this.TAG = "Finder.OrderFeedLoader";
    this.pUj = new ArrayList();
    AppMethodBeat.o(332332);
  }
  
  private static final ah a(b paramb, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(332345);
    kotlin.g.b.s.u(paramb, "this$0");
    d.uiThread((kotlin.g.a.a)new b.a(paramb, parama));
    paramb = ah.aiuX;
    AppMethodBeat.o(332345);
    return paramb;
  }
  
  public final void azc(String paramString)
  {
    AppMethodBeat.i(332380);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.ESi = paramString;
    AppMethodBeat.o(332380);
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(332391);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(332391);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.data.b
 * JD-Core Version:    0.7.0.1
 */