package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.bin;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "isFullEnjoy", "", "(Lcom/tencent/mm/ui/MMActivity;ZLkotlin/jvm/functions/Function1;)V", "forceNightMode", "onHistoryClearListener", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "(Lcom/tencent/mm/ui/MMActivity;ZZLkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "dismissHistoryLV", "isShowing", "onDestroy", "onTextChange", "query", "onTextSearch", "showHistoryLV", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class i
  implements m
{
  ListView AbZ;
  private a Aca;
  private l Acb;
  boolean Acc;
  View tzi;
  boolean zEV;
  
  public i(MMActivity paramMMActivity, kotlin.g.a.b<? super String, x> paramb)
  {
    this(paramMMActivity, false, false, paramb, null);
    AppMethodBeat.i(166864);
    AppMethodBeat.o(166864);
  }
  
  public i(MMActivity paramMMActivity, boolean paramBoolean, kotlin.g.a.b<? super String, x> paramb)
  {
    this(paramMMActivity, paramBoolean, false, paramb, null);
    AppMethodBeat.i(265043);
    AppMethodBeat.o(265043);
  }
  
  public i(MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super String, x> paramb, final l paraml)
  {
    AppMethodBeat.i(265045);
    Object localObject = paramMMActivity.findViewById(b.f.history_lv);
    p.j(localObject, "activity.findViewById(R.id.history_lv)");
    this.AbZ = ((ListView)localObject);
    this.Acc = paramBoolean1;
    this.zEV = paramBoolean2;
    localObject = LayoutInflater.from((Context)paramMMActivity);
    int i;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i = b.g.finder_full_search_history_footer_night_mode;
      }
    }
    for (;;)
    {
      localObject = ((LayoutInflater)localObject).inflate(i, (ViewGroup)this.AbZ, false);
      p.j(localObject, "LayoutInflater.from(acti…     }, historyLV, false)");
      this.tzi = ((View)localObject);
      dRc();
      this.AbZ.addFooterView(this.tzi);
      this.Aca = new a();
      this.AbZ.setAdapter((ListAdapter)this.Aca);
      this.tzi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(166844);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.Acd.tzi.setVisibility(8);
          paramAnonymousView = i.b.Acj;
          i.b.Ach.rVy.clear();
          i.b.dRf();
          i.b.dRe();
          a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(166844);
        }
      });
      this.AbZ.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(166845);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = this.Acf;
          paramAnonymousAdapterView = i.b.Acj;
          paramAnonymousView = ((bin)i.b.dRd().rVy.get(paramAnonymousInt)).query;
          paramAnonymousAdapterView = paramAnonymousView;
          if (paramAnonymousView == null) {
            paramAnonymousAdapterView = "";
          }
          ((kotlin.g.a.b)localObject).invoke(paramAnonymousAdapterView);
          paramAnonymousAdapterView = i.b.Acj;
          paramAnonymousView = ((bin)i.b.dRd().rVy.get(paramAnonymousInt)).query;
          paramAnonymousAdapterView = paramAnonymousView;
          if (paramAnonymousView == null) {
            paramAnonymousAdapterView = "";
          }
          i.b.aEn(paramAnonymousAdapterView);
          a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(166845);
        }
      });
      this.AbZ.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(166846);
          this.mpU.hideVKB();
          AppMethodBeat.o(166846);
          return false;
        }
      });
      paramMMActivity = b.Acj;
      b.a((m)this);
      AppMethodBeat.o(265045);
      return;
      i = b.g.finder_full_search_history_footer;
      continue;
      if (paramBoolean2) {
        i = b.g.finder_search_history_footer_night_mode;
      } else {
        i = b.g.finder_search_history_footer;
      }
    }
  }
  
  public final void aEm(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!Util.isNullOrNil(paramString))
    {
      this.AbZ.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.AbZ.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void aEn(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.Acj;
      b.aEn(paramString);
      this.tzi.setVisibility(0);
      AppMethodBeat.o(166862);
      return;
    }
    AppMethodBeat.o(166862);
  }
  
  public final void dRc()
  {
    AppMethodBeat.i(166863);
    b localb = b.Acj;
    if (b.dRd().rVy.isEmpty())
    {
      this.tzi.setVisibility(8);
      if (this.Acb == null) {
        AppMethodBeat.o(166863);
      }
    }
    else
    {
      this.tzi.setVisibility(0);
    }
    AppMethodBeat.o(166863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.Acj;
    b.b((m)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.Aca.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      i.b localb = i.b.Acj;
      int i = i.b.dRd().rVy.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = i.b.Acj;
      localObject = i.b.dRd().rVy.get(paramInt);
      p.j(localObject, "HistoryDataManager.searchHistory.List[position]");
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
      int i;
      Object localObject;
      if (paramView == null)
      {
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext());
        if (this.Acd.Acc) {
          if (this.Acd.zEV)
          {
            i = b.g.finder_full_search_history_item_night_mode;
            paramView = paramView.inflate(i, paramViewGroup, false);
            paramViewGroup = new i.c(this.Acd);
            localObject = paramView.findViewById(b.f.content_tv);
            p.j(localObject, "contentView.findViewById(R.id.content_tv)");
            localObject = (TextView)localObject;
            p.k(localObject, "<set-?>");
            paramViewGroup.jlh = ((TextView)localObject);
            localObject = paramView.findViewById(b.f.close_iv);
            p.j(localObject, "contentView.findViewById(R.id.close_iv)");
            localObject = (ImageView)localObject;
            p.k(localObject, "<set-?>");
            paramViewGroup.Acl = ((ImageView)localObject);
            p.j(paramView, "contentView");
            paramView.setTag(paramViewGroup);
          }
        }
      }
      for (;;)
      {
        localObject = i.b.Acj;
        localObject = ((bin)i.b.dRd().rVy.get(paramInt)).query;
        TextView localTextView = paramViewGroup.jlh;
        if (localTextView == null) {
          p.bGy("contentTV");
        }
        localTextView.setText((CharSequence)localObject);
        paramViewGroup = paramViewGroup.Acl;
        if (paramViewGroup == null) {
          p.bGy("closeIV");
        }
        paramViewGroup.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(166848);
        return paramView;
        i = b.g.finder_full_search_history_item;
        break;
        if (this.Acd.zEV)
        {
          i = b.g.finder_search_history_item_night_mode;
          break;
        }
        i = b.g.finder_search_history_item;
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchHistoryLogic.HistoryItemHolder");
          AppMethodBeat.o(166848);
          throw paramView;
        }
        paramViewGroup = (i.c)paramViewGroup;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(i.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166847);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        a.c("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = i.b.Acj;
        int i = paramInt;
        i.b.Ach.rVy.remove(i);
        i.b.dRf();
        i.b.dRe();
        this.Acg.Acd.dRc();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166847);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
  public static final class b
  {
    static bim Ach;
    private static HashMap<Integer, m> Aci;
    public static final b Acj;
    
    static
    {
      AppMethodBeat.i(166858);
      Acj = new b();
      Ach = new bim();
      Aci = new HashMap();
      Object localObject = new StringBuilder();
      av localav = av.AJz;
      localObject = u.aY(av.egs() + "search-history.info", 0, -1);
      try
      {
        Ach.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void a(m paramm)
    {
      AppMethodBeat.i(166853);
      p.k(paramm, "listener");
      ((Map)Aci).put(Integer.valueOf(paramm.hashCode()), paramm);
      AppMethodBeat.o(166853);
    }
    
    public static void aEn(String paramString)
    {
      AppMethodBeat.i(166856);
      p.k(paramString, "query");
      bin localbin = new bin();
      localbin.timestamp = System.currentTimeMillis();
      localbin.query = paramString;
      int i = 0;
      LinkedList localLinkedList = Ach.rVy;
      p.j(localLinkedList, "searchHistory.List");
      int j = ((Collection)localLinkedList).size();
      for (;;)
      {
        if (i < j)
        {
          if (p.h(((bin)Ach.rVy.get(i)).query, paramString)) {
            Ach.rVy.remove(i);
          }
        }
        else
        {
          Ach.rVy.addFirst(localbin);
          if (Ach.rVy.size() > 20) {
            Ach.rVy.removeLast();
          }
          dRf();
          dRe();
          AppMethodBeat.o(166856);
          return;
        }
        i += 1;
      }
    }
    
    public static void b(m paramm)
    {
      AppMethodBeat.i(166854);
      p.k(paramm, "listener");
      Aci.remove(Integer.valueOf(paramm.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    public static bim dRd()
    {
      return Ach;
    }
    
    static void dRe()
    {
      AppMethodBeat.i(166855);
      h.ZvG.be((Runnable)a.Ack);
      AppMethodBeat.o(166855);
    }
    
    static void dRf()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = Aci.values().iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a Ack;
      
      static
      {
        AppMethodBeat.i(166852);
        Ack = new a();
        AppMethodBeat.o(166852);
      }
      
      public final void run()
      {
        AppMethodBeat.i(166851);
        Object localObject1 = new StringBuilder();
        Object localObject2 = av.AJz;
        localObject1 = av.egs() + "search-history.info";
        localObject2 = new q((String)localObject1);
        Object localObject3 = i.b.Acj;
        localObject3 = i.b.dRd().toByteArray();
        if (!u.agG(String.valueOf(((q)localObject2).ifB()))) {
          u.bBD(String.valueOf(((q)localObject2).ifB()));
        }
        u.H((String)localObject1, (byte[])localObject3);
        AppMethodBeat.o(166851);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
  {
    public ImageView Acl;
    public TextView jlh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.i
 * JD-Core Version:    0.7.0.1
 */