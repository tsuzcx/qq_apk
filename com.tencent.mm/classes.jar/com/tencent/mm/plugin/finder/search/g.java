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
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "onDestroy", "onTextChange", "query", "onTextSearch", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class g
  implements i
{
  View ofC;
  private ListView rBm;
  private a rBn;
  
  public g(MMActivity paramMMActivity, b<? super String, y> paramb)
  {
    AppMethodBeat.i(166864);
    View localView = paramMMActivity.findViewById(2131300754);
    k.g(localView, "activity.findViewById(R.id.history_lv)");
    this.rBm = ((ListView)localView);
    localView = LayoutInflater.from((Context)paramMMActivity).inflate(2131494102, (ViewGroup)this.rBm, false);
    k.g(localView, "LayoutInflater.from(acti…footer, historyLV, false)");
    this.ofC = localView;
    cxN();
    this.rBm.addFooterView(this.ofC);
    this.rBn = new a();
    this.rBm.setAdapter((ListAdapter)this.rBn);
    this.ofC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(166844);
        this.rBo.ofC.setVisibility(8);
        paramAnonymousView = g.b.rBt;
        g.b.rBr.ncM.clear();
        g.b.cxQ();
        g.b.cxP();
        AppMethodBeat.o(166844);
      }
    });
    this.rBm.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(166845);
        paramAnonymousAdapterView = this.rBp;
        paramAnonymousView = g.b.rBt;
        paramAnonymousView = ((anq)g.b.cxO().ncM.get(paramAnonymousInt)).query;
        k.g(paramAnonymousView, "HistoryDataManager.searc…tory.List[position].query");
        paramAnonymousAdapterView.ay(paramAnonymousView);
        paramAnonymousAdapterView = g.b.rBt;
        paramAnonymousAdapterView = ((anq)g.b.cxO().ncM.get(paramAnonymousInt)).query;
        k.g(paramAnonymousAdapterView, "HistoryDataManager.searc…tory.List[position].query");
        g.b.adX(paramAnonymousAdapterView);
        AppMethodBeat.o(166845);
      }
    });
    this.rBm.setOnTouchListener((View.OnTouchListener)new g.3(paramMMActivity));
    paramMMActivity = b.rBt;
    b.a((i)this);
    AppMethodBeat.o(166864);
  }
  
  public final void adW(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!bs.isNullOrNil(paramString))
    {
      this.rBm.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.rBm.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void adX(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.rBt;
      b.adX(paramString);
      this.ofC.setVisibility(0);
      AppMethodBeat.o(166862);
      return;
    }
    AppMethodBeat.o(166862);
  }
  
  public final void cxN()
  {
    AppMethodBeat.i(166863);
    b localb = b.rBt;
    if (b.cxO().ncM.isEmpty())
    {
      this.ofC.setVisibility(8);
      AppMethodBeat.o(166863);
      return;
    }
    this.ofC.setVisibility(0);
    AppMethodBeat.o(166863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.rBt;
    b.b((i)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.rBn.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      g.b localb = g.b.rBt;
      int i = g.b.cxO().ncM.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = g.b.rBt;
      localObject = g.b.cxO().ncM.get(paramInt);
      k.g(localObject, "HistoryDataManager.searchHistory.List[position]");
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
          k.fOy();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494103, paramViewGroup, false);
        paramViewGroup = new g.c(this.rBo);
        localObject = paramView.findViewById(2131298778);
        k.g(localObject, "contentView.findViewById(R.id.content_tv)");
        localObject = (TextView)localObject;
        k.h(localObject, "<set-?>");
        paramViewGroup.fAy = ((TextView)localObject);
        localObject = paramView.findViewById(2131298373);
        k.g(localObject, "contentView.findViewById(R.id.close_iv)");
        localObject = (ImageView)localObject;
        k.h(localObject, "<set-?>");
        paramViewGroup.rBv = ((ImageView)localObject);
        k.g(paramView, "contentView");
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = g.b.rBt;
        localObject = ((anq)g.b.cxO().ncM.get(paramInt)).query;
        TextView localTextView = paramViewGroup.fAy;
        if (localTextView == null) {
          k.aVY("contentTV");
        }
        localTextView.setText((CharSequence)localObject);
        paramViewGroup = paramViewGroup.rBv;
        if (paramViewGroup == null) {
          k.aVY("closeIV");
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
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(g.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166847);
        paramView = g.b.rBt;
        int i = paramInt;
        g.b.rBr.ncM.remove(i);
        g.b.cxQ();
        g.b.cxP();
        this.rBq.rBo.cxN();
        AppMethodBeat.o(166847);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
  public static final class b
  {
    static anp rBr;
    private static HashMap<Integer, i> rBs;
    public static final b rBt;
    
    static
    {
      AppMethodBeat.i(166858);
      rBt = new b();
      rBr = new anp();
      rBs = new HashMap();
      Object localObject = new StringBuilder();
      p localp = p.rQw;
      localObject = com.tencent.mm.vfs.i.aU(p.cDu() + "search-history.info", 0, -1);
      try
      {
        rBr.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void a(i parami)
    {
      AppMethodBeat.i(166853);
      k.h(parami, "listener");
      ((Map)rBs).put(Integer.valueOf(parami.hashCode()), parami);
      AppMethodBeat.o(166853);
    }
    
    public static void adX(String paramString)
    {
      AppMethodBeat.i(166856);
      k.h(paramString, "query");
      anq localanq = new anq();
      localanq.timestamp = System.currentTimeMillis();
      localanq.query = paramString;
      int i = 0;
      LinkedList localLinkedList = rBr.ncM;
      k.g(localLinkedList, "searchHistory.List");
      int j = ((Collection)localLinkedList).size();
      for (;;)
      {
        if (i < j)
        {
          if (k.g(((anq)rBr.ncM.get(i)).query, paramString)) {
            rBr.ncM.remove(i);
          }
        }
        else
        {
          rBr.ncM.addFirst(localanq);
          if (rBr.ncM.size() > 20) {
            rBr.ncM.removeLast();
          }
          cxQ();
          cxP();
          AppMethodBeat.o(166856);
          return;
        }
        i += 1;
      }
    }
    
    public static void b(i parami)
    {
      AppMethodBeat.i(166854);
      k.h(parami, "listener");
      rBs.remove(Integer.valueOf(parami.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    public static anp cxO()
    {
      return rBr;
    }
    
    static void cxP()
    {
      AppMethodBeat.i(166855);
      h.JZN.aS((Runnable)a.rBu);
      AppMethodBeat.o(166855);
    }
    
    static void cxQ()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = rBs.values().iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a rBu;
      
      static
      {
        AppMethodBeat.i(166852);
        rBu = new a();
        AppMethodBeat.o(166852);
      }
      
      public final void run()
      {
        AppMethodBeat.i(166851);
        Object localObject1 = new StringBuilder();
        Object localObject2 = p.rQw;
        localObject1 = p.cDu() + "search-history.info";
        localObject2 = new e((String)localObject1);
        Object localObject3 = g.b.rBt;
        localObject3 = g.b.cxO().toByteArray();
        if (!com.tencent.mm.vfs.i.eA(((e)localObject2).fxU().toString())) {
          com.tencent.mm.vfs.i.aSh(((e)localObject2).fxU().toString());
        }
        com.tencent.mm.vfs.i.B((String)localObject1, (byte[])localObject3);
        AppMethodBeat.o(166851);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
  {
    public TextView fAy;
    public ImageView rBv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g
 * JD-Core Version:    0.7.0.1
 */