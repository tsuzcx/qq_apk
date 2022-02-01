package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "onDestroy", "onTextChange", "query", "onTextSearch", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class g
  implements i
{
  View oIV;
  private ListView stD;
  private a stE;
  
  public g(MMActivity paramMMActivity, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(166864);
    View localView = paramMMActivity.findViewById(2131300754);
    p.g(localView, "activity.findViewById(R.id.history_lv)");
    this.stD = ((ListView)localView);
    localView = LayoutInflater.from((Context)paramMMActivity).inflate(2131494102, (ViewGroup)this.stD, false);
    p.g(localView, "LayoutInflater.from(acti…footer, historyLV, false)");
    this.oIV = localView;
    cEK();
    this.stD.addFooterView(this.oIV);
    this.stE = new a();
    this.stD.setAdapter((ListAdapter)this.stE);
    this.oIV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(166844);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.stF.oIV.setVisibility(8);
        paramAnonymousView = g.b.stK;
        g.b.stI.nDj.clear();
        g.b.cEN();
        g.b.cEM();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166844);
      }
    });
    this.stD.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(166845);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = this.stG;
        paramAnonymousView = g.b.stK;
        paramAnonymousView = ((arc)g.b.cEL().nDj.get(paramAnonymousInt)).query;
        p.g(paramAnonymousView, "HistoryDataManager.searc…tory.List[position].query");
        paramAnonymousAdapterView.invoke(paramAnonymousView);
        paramAnonymousAdapterView = g.b.stK;
        paramAnonymousAdapterView = ((arc)g.b.cEL().nDj.get(paramAnonymousInt)).query;
        p.g(paramAnonymousAdapterView, "HistoryDataManager.searc…tory.List[position].query");
        g.b.ahW(paramAnonymousAdapterView);
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(166845);
      }
    });
    this.stD.setOnTouchListener((View.OnTouchListener)new g.3(paramMMActivity));
    paramMMActivity = b.stK;
    b.a((i)this);
    AppMethodBeat.o(166864);
  }
  
  public final void ahV(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!bt.isNullOrNil(paramString))
    {
      this.stD.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.stD.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void ahW(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.stK;
      b.ahW(paramString);
      this.oIV.setVisibility(0);
      AppMethodBeat.o(166862);
      return;
    }
    AppMethodBeat.o(166862);
  }
  
  public final void cEK()
  {
    AppMethodBeat.i(166863);
    b localb = b.stK;
    if (b.cEL().nDj.isEmpty())
    {
      this.oIV.setVisibility(8);
      AppMethodBeat.o(166863);
      return;
    }
    this.oIV.setVisibility(0);
    AppMethodBeat.o(166863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.stK;
    b.b((i)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.stE.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      g.b localb = g.b.stK;
      int i = g.b.cEL().nDj.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = g.b.stK;
      localObject = g.b.cEL().nDj.get(paramInt);
      p.g(localObject, "HistoryDataManager.searchHistory.List[position]");
      AppMethodBeat.o(166849);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(166848);
      Object localObject;
      if (paramView == null)
      {
        if (paramViewGroup == null) {
          p.gfZ();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494103, paramViewGroup, false);
        paramViewGroup = new g.c(this.stF);
        localObject = paramView.findViewById(2131298778);
        p.g(localObject, "contentView.findViewById(R.id.content_tv)");
        localObject = (TextView)localObject;
        p.h(localObject, "<set-?>");
        paramViewGroup.fTO = ((TextView)localObject);
        localObject = paramView.findViewById(2131298373);
        p.g(localObject, "contentView.findViewById(R.id.close_iv)");
        localObject = (ImageView)localObject;
        p.h(localObject, "<set-?>");
        paramViewGroup.stM = ((ImageView)localObject);
        p.g(paramView, "contentView");
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = g.b.stK;
        localObject = ((arc)g.b.cEL().nDj.get(paramInt)).query;
        TextView localTextView = paramViewGroup.fTO;
        if (localTextView == null) {
          p.bcb("contentTV");
        }
        localTextView.setText((CharSequence)localObject);
        paramViewGroup = paramViewGroup.stM;
        if (paramViewGroup == null) {
          p.bcb("closeIV");
        }
        paramViewGroup.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(166848);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchHistoryLogic.HistoryItemHolder");
          AppMethodBeat.o(166848);
          throw paramView;
        }
        paramViewGroup = (g.c)paramViewGroup;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(g.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166847);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = g.b.stK;
        int i = paramInt;
        g.b.stI.nDj.remove(i);
        g.b.cEN();
        g.b.cEM();
        this.stH.stF.cEK();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166847);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
  public static final class b
  {
    static arb stI;
    private static HashMap<Integer, i> stJ;
    public static final b stK;
    
    static
    {
      AppMethodBeat.i(166858);
      stK = new b();
      stI = new arb();
      stJ = new HashMap();
      Object localObject = new StringBuilder();
      r localr = r.sNc;
      localObject = com.tencent.mm.vfs.i.aY(r.cLO() + "search-history.info", 0, -1);
      try
      {
        stI.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void a(i parami)
    {
      AppMethodBeat.i(166853);
      p.h(parami, "listener");
      ((Map)stJ).put(Integer.valueOf(parami.hashCode()), parami);
      AppMethodBeat.o(166853);
    }
    
    public static void ahW(String paramString)
    {
      AppMethodBeat.i(166856);
      p.h(paramString, "query");
      arc localarc = new arc();
      localarc.timestamp = System.currentTimeMillis();
      localarc.query = paramString;
      int i = 0;
      LinkedList localLinkedList = stI.nDj;
      p.g(localLinkedList, "searchHistory.List");
      int j = ((Collection)localLinkedList).size();
      for (;;)
      {
        if (i < j)
        {
          if (p.i(((arc)stI.nDj.get(i)).query, paramString)) {
            stI.nDj.remove(i);
          }
        }
        else
        {
          stI.nDj.addFirst(localarc);
          if (stI.nDj.size() > 20) {
            stI.nDj.removeLast();
          }
          cEN();
          cEM();
          AppMethodBeat.o(166856);
          return;
        }
        i += 1;
      }
    }
    
    public static void b(i parami)
    {
      AppMethodBeat.i(166854);
      p.h(parami, "listener");
      stJ.remove(Integer.valueOf(parami.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    public static arb cEL()
    {
      return stI;
    }
    
    static void cEM()
    {
      AppMethodBeat.i(166855);
      h.LTJ.aR((Runnable)a.stL);
      AppMethodBeat.o(166855);
    }
    
    static void cEN()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = stJ.values().iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a stL;
      
      static
      {
        AppMethodBeat.i(166852);
        stL = new a();
        AppMethodBeat.o(166852);
      }
      
      public final void run()
      {
        AppMethodBeat.i(166851);
        Object localObject1 = new StringBuilder();
        Object localObject2 = r.sNc;
        localObject1 = r.cLO() + "search-history.info";
        localObject2 = new e((String)localObject1);
        Object localObject3 = g.b.stK;
        localObject3 = g.b.cEL().toByteArray();
        if (!com.tencent.mm.vfs.i.fv(((e)localObject2).fOJ().toString())) {
          com.tencent.mm.vfs.i.aYg(((e)localObject2).fOJ().toString());
        }
        com.tencent.mm.vfs.i.C((String)localObject1, (byte[])localObject3);
        AppMethodBeat.o(166851);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
  {
    public TextView fTO;
    public ImageView stM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g
 * JD-Core Version:    0.7.0.1
 */