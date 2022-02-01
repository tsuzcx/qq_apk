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
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "onDestroy", "onTextChange", "query", "onTextSearch", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class g
  implements i
{
  View oPx;
  private ListView sDO;
  private a sDP;
  
  public g(MMActivity paramMMActivity, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(166864);
    View localView = paramMMActivity.findViewById(2131300754);
    p.g(localView, "activity.findViewById(R.id.history_lv)");
    this.sDO = ((ListView)localView);
    localView = LayoutInflater.from((Context)paramMMActivity).inflate(2131494102, (ViewGroup)this.sDO, false);
    p.g(localView, "LayoutInflater.from(acti…footer, historyLV, false)");
    this.oPx = localView;
    cGG();
    this.sDO.addFooterView(this.oPx);
    this.sDP = new a();
    this.sDO.setAdapter((ListAdapter)this.sDP);
    this.oPx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(166844);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.sDQ.oPx.setVisibility(8);
        paramAnonymousView = g.b.sDV;
        g.b.sDT.nIE.clear();
        g.b.cGJ();
        g.b.cGI();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166844);
      }
    });
    this.sDO.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(166845);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = this.sDR;
        paramAnonymousAdapterView = g.b.sDV;
        paramAnonymousView = ((arr)g.b.cGH().nIE.get(paramAnonymousInt)).query;
        paramAnonymousAdapterView = paramAnonymousView;
        if (paramAnonymousView == null) {
          paramAnonymousAdapterView = "";
        }
        ((d.g.a.b)localObject).invoke(paramAnonymousAdapterView);
        paramAnonymousAdapterView = g.b.sDV;
        paramAnonymousView = ((arr)g.b.cGH().nIE.get(paramAnonymousInt)).query;
        paramAnonymousAdapterView = paramAnonymousView;
        if (paramAnonymousView == null) {
          paramAnonymousAdapterView = "";
        }
        g.b.aiU(paramAnonymousAdapterView);
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(166845);
      }
    });
    this.sDO.setOnTouchListener((View.OnTouchListener)new g.3(paramMMActivity));
    paramMMActivity = b.sDV;
    b.a((i)this);
    AppMethodBeat.o(166864);
  }
  
  public final void aiT(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!bu.isNullOrNil(paramString))
    {
      this.sDO.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.sDO.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void aiU(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.sDV;
      b.aiU(paramString);
      this.oPx.setVisibility(0);
      AppMethodBeat.o(166862);
      return;
    }
    AppMethodBeat.o(166862);
  }
  
  public final void cGG()
  {
    AppMethodBeat.i(166863);
    b localb = b.sDV;
    if (b.cGH().nIE.isEmpty())
    {
      this.oPx.setVisibility(8);
      AppMethodBeat.o(166863);
      return;
    }
    this.oPx.setVisibility(0);
    AppMethodBeat.o(166863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.sDV;
    b.b((i)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.sDP.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      g.b localb = g.b.sDV;
      int i = g.b.cGH().nIE.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = g.b.sDV;
      localObject = g.b.cGH().nIE.get(paramInt);
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
          p.gkB();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494103, paramViewGroup, false);
        paramViewGroup = new g.c(this.sDQ);
        localObject = paramView.findViewById(2131298778);
        p.g(localObject, "contentView.findViewById(R.id.content_tv)");
        localObject = (TextView)localObject;
        p.h(localObject, "<set-?>");
        paramViewGroup.fVU = ((TextView)localObject);
        localObject = paramView.findViewById(2131298373);
        p.g(localObject, "contentView.findViewById(R.id.close_iv)");
        localObject = (ImageView)localObject;
        p.h(localObject, "<set-?>");
        paramViewGroup.sDX = ((ImageView)localObject);
        p.g(paramView, "contentView");
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = g.b.sDV;
        localObject = ((arr)g.b.cGH().nIE.get(paramInt)).query;
        TextView localTextView = paramViewGroup.fVU;
        if (localTextView == null) {
          p.bdF("contentTV");
        }
        localTextView.setText((CharSequence)localObject);
        paramViewGroup = paramViewGroup.sDX;
        if (paramViewGroup == null) {
          p.bdF("closeIV");
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(g.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166847);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = g.b.sDV;
        int i = paramInt;
        g.b.sDT.nIE.remove(i);
        g.b.cGJ();
        g.b.cGI();
        this.sDS.sDQ.cGG();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166847);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
  public static final class b
  {
    static arq sDT;
    private static HashMap<Integer, i> sDU;
    public static final b sDV;
    
    static
    {
      AppMethodBeat.i(166858);
      sDV = new b();
      sDT = new arq();
      sDU = new HashMap();
      Object localObject = new StringBuilder();
      r localr = r.sYn;
      localObject = o.bb(r.cOw() + "search-history.info", 0, -1);
      try
      {
        sDT.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void a(i parami)
    {
      AppMethodBeat.i(166853);
      p.h(parami, "listener");
      ((Map)sDU).put(Integer.valueOf(parami.hashCode()), parami);
      AppMethodBeat.o(166853);
    }
    
    public static void aiU(String paramString)
    {
      AppMethodBeat.i(166856);
      p.h(paramString, "query");
      arr localarr = new arr();
      localarr.timestamp = System.currentTimeMillis();
      localarr.query = paramString;
      int i = 0;
      LinkedList localLinkedList = sDT.nIE;
      p.g(localLinkedList, "searchHistory.List");
      int j = ((Collection)localLinkedList).size();
      for (;;)
      {
        if (i < j)
        {
          if (p.i(((arr)sDT.nIE.get(i)).query, paramString)) {
            sDT.nIE.remove(i);
          }
        }
        else
        {
          sDT.nIE.addFirst(localarr);
          if (sDT.nIE.size() > 20) {
            sDT.nIE.removeLast();
          }
          cGJ();
          cGI();
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
      sDU.remove(Integer.valueOf(parami.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    public static arq cGH()
    {
      return sDT;
    }
    
    static void cGI()
    {
      AppMethodBeat.i(166855);
      h.MqF.aO((Runnable)a.sDW);
      AppMethodBeat.o(166855);
    }
    
    static void cGJ()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = sDU.values().iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a sDW;
      
      static
      {
        AppMethodBeat.i(166852);
        sDW = new a();
        AppMethodBeat.o(166852);
      }
      
      public final void run()
      {
        AppMethodBeat.i(166851);
        Object localObject1 = new StringBuilder();
        Object localObject2 = r.sYn;
        localObject1 = r.cOw() + "search-history.info";
        localObject2 = new k((String)localObject1);
        Object localObject3 = g.b.sDV;
        localObject3 = g.b.cGH().toByteArray();
        if (!o.fB(((k)localObject2).fTg().toString())) {
          o.aZI(((k)localObject2).fTg().toString());
        }
        o.C((String)localObject1, (byte[])localObject3);
        AppMethodBeat.o(166851);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
  {
    public TextView fVU;
    public ImageView sDX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.g
 * JD-Core Version:    0.7.0.1
 */