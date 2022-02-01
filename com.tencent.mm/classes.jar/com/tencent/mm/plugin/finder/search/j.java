package com.tencent.mm.plugin.finder.search;

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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "isFullEnjoy", "", "(Lcom/tencent/mm/ui/MMActivity;ZLkotlin/jvm/functions/Function1;)V", "forceNightMode", "onHistoryClearListener", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "(Lcom/tencent/mm/ui/MMActivity;ZZLkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "dismissHistoryLV", "isShowing", "onDestroy", "onTextChange", "query", "onTextSearch", "showHistoryLV", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements n
{
  boolean ANb;
  ListView ESD;
  private a FxU;
  private m FxV;
  boolean FxW;
  private View uiF;
  
  public j(MMActivity paramMMActivity, kotlin.g.a.b<? super String, ah> paramb)
  {
    this(paramMMActivity, false, false, paramb, null);
    AppMethodBeat.i(166864);
    AppMethodBeat.o(166864);
  }
  
  public j(MMActivity paramMMActivity, boolean paramBoolean, kotlin.g.a.b<? super String, ah> paramb)
  {
    this(paramMMActivity, paramBoolean, false, paramb, null);
    AppMethodBeat.i(342519);
    AppMethodBeat.o(342519);
  }
  
  public j(MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super String, ah> paramb, m paramm)
  {
    AppMethodBeat.i(342525);
    Object localObject = paramMMActivity.findViewById(e.e.history_lv);
    s.s(localObject, "activity.findViewById(R.id.history_lv)");
    this.ESD = ((ListView)localObject);
    this.FxW = paramBoolean1;
    this.ANb = paramBoolean2;
    localObject = LayoutInflater.from((Context)paramMMActivity);
    int i;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i = e.f.finder_full_search_history_footer_night_mode;
      }
    }
    for (;;)
    {
      localObject = ((LayoutInflater)localObject).inflate(i, (ViewGroup)this.ESD, false);
      s.s(localObject, "from(activity).inflate(\n…     }, historyLV, false)");
      this.uiF = ((View)localObject);
      eGT();
      this.ESD.addFooterView(this.uiF);
      this.FxU = new a();
      this.ESD.setAdapter((ListAdapter)this.FxU);
      this.uiF.setOnClickListener(new j..ExternalSyntheticLambda0(this, paramm));
      this.ESD.setOnItemClickListener(new j..ExternalSyntheticLambda2(paramb));
      this.ESD.setOnTouchListener(new j..ExternalSyntheticLambda1(paramMMActivity));
      paramMMActivity = b.FxY;
      b.a((n)this);
      AppMethodBeat.o(342525);
      return;
      i = e.f.finder_full_search_history_footer;
      continue;
      if (paramBoolean2) {
        i = e.f.finder_search_history_footer_night_mode;
      } else {
        i = e.f.finder_search_history_footer;
      }
    }
  }
  
  private static final void a(j paramj, m paramm, View paramView)
  {
    AppMethodBeat.i(342537);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramj.uiF.setVisibility(8);
    paramj = b.FxY;
    b.ESI.vgO.clear();
    b.eGV();
    b.eDv();
    a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342537);
  }
  
  private static final void a(kotlin.g.a.b paramb, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(342544);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramb, "$onHistoryClickListener");
    paramAdapterView = b.FxY;
    paramView = ((buw)b.eGU().vgO.get(paramInt)).query;
    paramAdapterView = paramView;
    if (paramView == null) {
      paramAdapterView = "";
    }
    paramb.invoke(paramAdapterView);
    paramb = b.FxY;
    paramAdapterView = ((buw)b.eGU().vgO.get(paramInt)).query;
    paramb = paramAdapterView;
    if (paramAdapterView == null) {
      paramb = "";
    }
    b.azd(paramb);
    a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(342544);
  }
  
  private static final boolean a(MMActivity paramMMActivity, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342552);
    s.u(paramMMActivity, "$activity");
    paramMMActivity.hideVKB();
    AppMethodBeat.o(342552);
    return false;
  }
  
  public final void aAg(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!Util.isNullOrNil(paramString))
    {
      this.ESD.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.ESD.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void azd(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.FxY;
      b.azd(paramString);
      this.uiF.setVisibility(0);
    }
    AppMethodBeat.o(166862);
  }
  
  public final void eGT()
  {
    AppMethodBeat.i(166863);
    b localb = b.FxY;
    if (b.eGU().vgO.isEmpty())
    {
      this.uiF.setVisibility(8);
      if (this.FxV != null) {
        AppMethodBeat.o(166863);
      }
    }
    else
    {
      this.uiF.setVisibility(0);
    }
    AppMethodBeat.o(166863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.FxY;
    b.b((n)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.FxU.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    public a()
    {
      AppMethodBeat.i(342498);
      AppMethodBeat.o(342498);
    }
    
    private static final void a(int paramInt, j paramj, View paramView)
    {
      AppMethodBeat.i(342504);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sc(paramInt);
      localb.cH(paramj);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramj, "this$0");
      paramView = j.b.FxY;
      j.b.ESI.vgO.remove(paramInt);
      j.b.eGV();
      j.b.eDv();
      paramj.eGT();
      a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342504);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      j.b localb = j.b.FxY;
      int i = j.b.eGU().vgO.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = j.b.FxY;
      localObject = j.b.eGU().vgO.get(paramInt);
      s.s(localObject, "HistoryDataManager.searchHistory.List[position]");
      AppMethodBeat.o(166849);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2 = null;
      AppMethodBeat.i(166848);
      int i;
      Object localObject1;
      label158:
      String str;
      if (paramView == null)
      {
        s.checkNotNull(paramViewGroup);
        paramView = LayoutInflater.from(paramViewGroup.getContext());
        if (this.FxX.FxW) {
          if (this.FxX.ANb)
          {
            i = e.f.finder_full_search_history_item_night_mode;
            paramView = paramView.inflate(i, paramViewGroup, false);
            paramViewGroup = new j.c(this.FxX);
            localObject1 = paramView.findViewById(e.e.content_tv);
            s.s(localObject1, "contentView.findViewById(R.id.content_tv)");
            localObject1 = (TextView)localObject1;
            s.u(localObject1, "<set-?>");
            paramViewGroup.lNZ = ((TextView)localObject1);
            localObject1 = paramView.findViewById(e.e.close_iv);
            s.s(localObject1, "contentView.findViewById(R.id.close_iv)");
            localObject1 = (ImageView)localObject1;
            s.u(localObject1, "<set-?>");
            paramViewGroup.ESK = ((ImageView)localObject1);
            paramViewGroup.ESL = paramView.findViewById(e.e.finder_search_history_item);
            paramView.setTag(paramViewGroup);
            localObject1 = j.b.FxY;
            str = ((buw)j.b.eGU().vgO.get(paramInt)).query;
            localObject1 = paramViewGroup.lNZ;
            if (localObject1 == null) {
              break label328;
            }
            label192:
            ((TextView)localObject1).setText((CharSequence)str);
            localObject1 = paramViewGroup.ESK;
            if (localObject1 == null) {
              break label340;
            }
          }
        }
      }
      for (;;)
      {
        ((ImageView)localObject1).setOnClickListener(new j.a..ExternalSyntheticLambda0(paramInt, this.FxX));
        paramViewGroup = paramViewGroup.ESL;
        if (paramViewGroup != null) {
          paramViewGroup.setTag(e.e.finder_accessibility_content_desc_tag, str);
        }
        s.checkNotNull(paramView);
        AppMethodBeat.o(166848);
        return paramView;
        i = e.f.finder_full_search_history_item;
        break;
        if (this.FxX.ANb)
        {
          i = e.f.finder_search_history_item_night_mode;
          break;
        }
        i = e.f.finder_search_history_item;
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchHistoryLogic.HistoryItemHolder");
          AppMethodBeat.o(166848);
          throw paramView;
        }
        paramViewGroup = (j.c)paramViewGroup;
        break label158;
        label328:
        s.bIx("contentTV");
        localObject1 = null;
        break label192;
        label340:
        s.bIx("closeIV");
        localObject1 = localObject2;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    static buv ESI;
    private static HashMap<Integer, n> ESJ;
    public static final b FxY;
    
    static
    {
      AppMethodBeat.i(166858);
      FxY = new b();
      ESI = new buv();
      ESJ = new HashMap();
      Object localObject = bm.GlZ;
      localObject = y.bi(s.X(bm.fir(), "search-history.info"), 0, -1);
      try
      {
        ESI.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void a(n paramn)
    {
      AppMethodBeat.i(166853);
      s.u(paramn, "listener");
      ((Map)ESJ).put(Integer.valueOf(paramn.hashCode()), paramn);
      AppMethodBeat.o(166853);
    }
    
    public static void azd(String paramString)
    {
      AppMethodBeat.i(166856);
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
          AppMethodBeat.o(166856);
          return;
        }
      }
    }
    
    public static void b(n paramn)
    {
      AppMethodBeat.i(166854);
      s.u(paramn, "listener");
      ESJ.remove(Integer.valueOf(paramn.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    static void eDv()
    {
      AppMethodBeat.i(166855);
      h.ahAA.bm(j.b..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(166855);
    }
    
    public static buv eGU()
    {
      return ESI;
    }
    
    static void eGV()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = ESJ.values().iterator();
      while (localIterator.hasNext()) {
        ((n)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    private static final void eGW()
    {
      AppMethodBeat.i(342584);
      Object localObject = bm.GlZ;
      localObject = s.X(bm.fir(), "search-history.info");
      u localu = new u((String)localObject);
      byte[] arrayOfByte = ESI.toByteArray();
      if (!y.ZC(String.valueOf(localu.jKP()))) {
        y.bDX(String.valueOf(localu.jKP()));
      }
      y.f((String)localObject, arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(342584);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "historyItemContainer", "Landroid/view/View;", "getHistoryItemContainer", "()Landroid/view/View;", "setHistoryItemContainer", "(Landroid/view/View;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
  {
    public ImageView ESK;
    View ESL;
    public TextView lNZ;
    
    public c()
    {
      AppMethodBeat.i(342493);
      AppMethodBeat.o(342493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.j
 * JD-Core Version:    0.7.0.1
 */