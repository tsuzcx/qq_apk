package com.tencent.mm.plugin.finder.order.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/order/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "onHistoryClearListener", "Lcom/tencent/mm/plugin/finder/order/search/OnHistoryClearListener;", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/finder/order/search/OnHistoryClearListener;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "dismissHistoryLV", "isShowing", "", "onDestroy", "onTextChange", "query", "onTextSearch", "showHistoryLV", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public ListView ESD;
  private a ESE;
  private b ESF;
  public View uiF;
  
  public a(MMActivity paramMMActivity, kotlin.g.a.b<? super String, ah> paramb, b paramb1)
  {
    AppMethodBeat.i(332263);
    View localView = paramMMActivity.findViewById(p.e.history_lv);
    s.s(localView, "activity.findViewById(R.id.history_lv)");
    this.ESD = ((ListView)localView);
    localView = LayoutInflater.from((Context)paramMMActivity).inflate(p.f.Cgo, (ViewGroup)this.ESD, false);
    s.s(localView, "from(activity).inflate(R…footer, historyLV, false)");
    this.uiF = localView;
    eGT();
    this.ESD.addFooterView(this.uiF);
    this.ESE = new a();
    this.ESD.setAdapter((ListAdapter)this.ESE);
    this.uiF.setOnClickListener(new a..ExternalSyntheticLambda0(this, paramb1));
    this.ESD.setOnItemClickListener(new a..ExternalSyntheticLambda2(paramb));
    this.ESD.setOnTouchListener(new a..ExternalSyntheticLambda1(paramMMActivity));
    paramMMActivity = b.ESH;
    b.a((c)this);
    AppMethodBeat.o(332263);
  }
  
  private static final void a(a parama, b paramb, View paramView)
  {
    AppMethodBeat.i(332273);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.uiF.setVisibility(8);
    parama = b.ESH;
    b.ESI.vgO.clear();
    b.eGV();
    b.eDv();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332273);
  }
  
  private static final void a(kotlin.g.a.b paramb, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(332281);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramb, "$onHistoryClickListener");
    paramAdapterView = b.ESH;
    paramView = ((buw)b.eGU().vgO.get(paramInt)).query;
    paramAdapterView = paramView;
    if (paramView == null) {
      paramAdapterView = "";
    }
    paramb.invoke(paramAdapterView);
    paramb = b.ESH;
    paramAdapterView = ((buw)b.eGU().vgO.get(paramInt)).query;
    paramb = paramAdapterView;
    if (paramAdapterView == null) {
      paramb = "";
    }
    b.azd(paramb);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(332281);
  }
  
  private static final boolean a(MMActivity paramMMActivity, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(332290);
    s.u(paramMMActivity, "$activity");
    paramMMActivity.hideVKB();
    AppMethodBeat.o(332290);
    return false;
  }
  
  public final void eGT()
  {
    AppMethodBeat.i(332330);
    b localb = b.ESH;
    if (b.eGU().vgO.isEmpty())
    {
      this.uiF.setVisibility(8);
      if (this.ESF != null) {
        AppMethodBeat.o(332330);
      }
    }
    else
    {
      this.uiF.setVisibility(0);
    }
    AppMethodBeat.o(332330);
  }
  
  public final void update()
  {
    AppMethodBeat.i(332323);
    this.ESE.notifyDataSetChanged();
    AppMethodBeat.o(332323);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    public a()
    {
      AppMethodBeat.i(332266);
      AppMethodBeat.o(332266);
    }
    
    private static final void a(int paramInt, a parama, View paramView)
    {
      AppMethodBeat.i(332276);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sc(paramInt);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic$HistoryAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      paramView = a.b.ESH;
      a.b.ESI.vgO.remove(paramInt);
      a.b.eGV();
      a.b.eDv();
      parama.eGT();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic$HistoryAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332276);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(332322);
      a.b localb = a.b.ESH;
      int i = a.b.eGU().vgO.size();
      AppMethodBeat.o(332322);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(332306);
      Object localObject = a.b.ESH;
      localObject = a.b.eGU().vgO.get(paramInt);
      s.s(localObject, "HistoryDataManager.searchHistory.List[position]");
      AppMethodBeat.o(332306);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2 = null;
      AppMethodBeat.i(332299);
      Object localObject1;
      String str;
      if (paramView == null)
      {
        s.checkNotNull(paramViewGroup);
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(p.f.Cgp, paramViewGroup, false);
        paramViewGroup = new a.c(this.ESG);
        localObject1 = paramView.findViewById(p.e.content_tv);
        s.s(localObject1, "contentView.findViewById(R.id.content_tv)");
        localObject1 = (TextView)localObject1;
        s.u(localObject1, "<set-?>");
        paramViewGroup.lNZ = ((TextView)localObject1);
        localObject1 = paramView.findViewById(p.e.close_iv);
        s.s(localObject1, "contentView.findViewById(R.id.close_iv)");
        localObject1 = (ImageView)localObject1;
        s.u(localObject1, "<set-?>");
        paramViewGroup.ESK = ((ImageView)localObject1);
        paramViewGroup.ESL = paramView.findViewById(p.e.finder_search_history_item);
        paramView.setTag(paramViewGroup);
        localObject1 = a.b.ESH;
        str = ((buw)a.b.eGU().vgO.get(paramInt)).query;
        localObject1 = paramViewGroup.lNZ;
        if (localObject1 == null) {
          break label268;
        }
        label166:
        ((TextView)localObject1).setText((CharSequence)str);
        localObject1 = paramViewGroup.ESK;
        if (localObject1 == null) {
          break label280;
        }
      }
      for (;;)
      {
        ((ImageView)localObject1).setOnClickListener(new a.a..ExternalSyntheticLambda0(paramInt, this.ESG));
        paramViewGroup = paramViewGroup.ESL;
        if (paramViewGroup != null) {
          paramViewGroup.setTag(p.e.BEO, str);
        }
        s.checkNotNull(paramView);
        AppMethodBeat.o(332299);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.order.search.FinderOrderSearchHistoryLogic.HistoryItemHolder");
          AppMethodBeat.o(332299);
          throw paramView;
        }
        paramViewGroup = (a.c)paramViewGroup;
        break;
        label268:
        s.bIx("contentTV");
        localObject1 = null;
        break label166;
        label280:
        s.bIx("closeIV");
        localObject1 = localObject2;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/order/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b ESH;
    static buv ESI;
    private static HashMap<Integer, c> ESJ;
    
    static
    {
      AppMethodBeat.i(332341);
      ESH = new b();
      ESI = new buv();
      ESJ = new HashMap();
      Object localObject = bm.GlZ;
      localObject = y.bi(s.X(bm.fir(), "order-search-history.info"), 0, -1);
      try
      {
        ESI.parseFrom((byte[])localObject);
        AppMethodBeat.o(332341);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(332341);
      }
    }
    
    public static void a(c paramc)
    {
      AppMethodBeat.i(332287);
      s.u(paramc, "listener");
      ((Map)ESJ).put(Integer.valueOf(paramc.hashCode()), paramc);
      AppMethodBeat.o(332287);
    }
    
    public static void azd(String paramString)
    {
      AppMethodBeat.i(332316);
      s.u(paramString, "query");
      buw localbuw = new buw();
      localbuw.timestamp = System.currentTimeMillis();
      localbuw.query = paramString;
      int k = ESI.vgO.size() - 1;
      if (k >= 0) {}
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (s.p(((buw)ESI.vgO.get(i)).query, paramString)) {
          ESI.vgO.remove(i);
        }
        while (j > k)
        {
          ESI.vgO.addFirst(localbuw);
          if (ESI.vgO.size() > 20) {
            ESI.vgO.removeLast();
          }
          eGV();
          eDv();
          AppMethodBeat.o(332316);
          return;
        }
      }
    }
    
    public static void b(c paramc)
    {
      AppMethodBeat.i(332295);
      s.u(paramc, "listener");
      ESJ.remove(Integer.valueOf(paramc.hashCode()));
      AppMethodBeat.o(332295);
    }
    
    static void eDv()
    {
      AppMethodBeat.i(332304);
      h.ahAA.bm(a.b..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(332304);
    }
    
    public static buv eGU()
    {
      return ESI;
    }
    
    static void eGV()
    {
      AppMethodBeat.i(332324);
      Iterator localIterator = ESJ.values().iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).update();
      }
      AppMethodBeat.o(332324);
    }
    
    private static final void eGW()
    {
      AppMethodBeat.i(332333);
      Object localObject = bm.GlZ;
      localObject = s.X(bm.fir(), "order-search-history.info");
      u localu = new u((String)localObject);
      byte[] arrayOfByte = ESI.toByteArray();
      if (!y.ZC(String.valueOf(localu.jKP()))) {
        y.bDX(String.valueOf(localu.jKP()));
      }
      y.f((String)localObject, arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(332333);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/order/search/FinderOrderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "historyItemContainer", "Landroid/view/View;", "getHistoryItemContainer", "()Landroid/view/View;", "setHistoryItemContainer", "(Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
  {
    public ImageView ESK;
    View ESL;
    public TextView lNZ;
    
    public c()
    {
      AppMethodBeat.i(332284);
      AppMethodBeat.o(332284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.search.a
 * JD-Core Version:    0.7.0.1
 */