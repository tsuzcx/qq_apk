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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "isFullEnjoy", "", "(Lcom/tencent/mm/ui/MMActivity;ZLkotlin/jvm/functions/Function1;)V", "onHistoryClearListener", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "(Lcom/tencent/mm/ui/MMActivity;ZLkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "dismissHistoryLV", "isShowing", "onDestroy", "onTextChange", "query", "onTextSearch", "showHistoryLV", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class h
  implements k
{
  View qdl;
  private ListView vvb;
  private a vvc;
  private j vvd;
  boolean vve;
  
  public h(MMActivity paramMMActivity, kotlin.g.a.b<? super String, x> paramb)
  {
    this(paramMMActivity, false, paramb, null);
    AppMethodBeat.i(166864);
    AppMethodBeat.o(166864);
  }
  
  public h(MMActivity paramMMActivity, boolean paramBoolean, kotlin.g.a.b<? super String, x> paramb)
  {
    this(paramMMActivity, paramBoolean, paramb, null);
    AppMethodBeat.i(251368);
    AppMethodBeat.o(251368);
  }
  
  public h(MMActivity paramMMActivity, boolean paramBoolean, kotlin.g.a.b<? super String, x> paramb, final j paramj)
  {
    AppMethodBeat.i(251369);
    Object localObject = paramMMActivity.findViewById(2131302342);
    p.g(localObject, "activity.findViewById(R.id.history_lv)");
    this.vvb = ((ListView)localObject);
    this.vve = paramBoolean;
    localObject = LayoutInflater.from((Context)paramMMActivity);
    if (paramBoolean) {}
    for (int i = 2131494335;; i = 2131494609)
    {
      localObject = ((LayoutInflater)localObject).inflate(i, (ViewGroup)this.vvb, false);
      p.g(localObject, "LayoutInflater.from(acti…footer, historyLV, false)");
      this.qdl = ((View)localObject);
      dpV();
      this.vvb.addFooterView(this.qdl);
      this.vvc = new a();
      this.vvb.setAdapter((ListAdapter)this.vvc);
      this.qdl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(166844);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.vvf.qdl.setVisibility(8);
          paramAnonymousView = h.b.vvl;
          h.b.vvj.oTA.clear();
          h.b.dpY();
          h.b.dpX();
          paramAnonymousView = paramj;
          if (paramAnonymousView != null) {
            paramAnonymousView.cwc();
          }
          a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(166844);
        }
      });
      this.vvb.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(166845);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = this.vvh;
          paramAnonymousAdapterView = h.b.vvl;
          paramAnonymousView = ((bbx)h.b.dpW().oTA.get(paramAnonymousInt)).query;
          paramAnonymousAdapterView = paramAnonymousView;
          if (paramAnonymousView == null) {
            paramAnonymousAdapterView = "";
          }
          ((kotlin.g.a.b)localObject).invoke(paramAnonymousAdapterView);
          paramAnonymousAdapterView = h.b.vvl;
          paramAnonymousView = ((bbx)h.b.dpW().oTA.get(paramAnonymousInt)).query;
          paramAnonymousAdapterView = paramAnonymousView;
          if (paramAnonymousView == null) {
            paramAnonymousAdapterView = "";
          }
          h.b.auX(paramAnonymousAdapterView);
          a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(166845);
        }
      });
      this.vvb.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(166846);
          this.nbB.hideVKB();
          AppMethodBeat.o(166846);
          return false;
        }
      });
      paramMMActivity = b.vvl;
      b.a((k)this);
      AppMethodBeat.o(251369);
      return;
    }
  }
  
  public final void auW(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!Util.isNullOrNil(paramString))
    {
      this.vvb.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.vvb.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void auX(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.vvl;
      b.auX(paramString);
      this.qdl.setVisibility(0);
      AppMethodBeat.o(166862);
      return;
    }
    AppMethodBeat.o(166862);
  }
  
  public final void dpT()
  {
    AppMethodBeat.i(251365);
    this.vvb.setVisibility(0);
    AppMethodBeat.o(251365);
  }
  
  public final void dpU()
  {
    AppMethodBeat.i(251366);
    this.vvb.setVisibility(8);
    AppMethodBeat.o(251366);
  }
  
  public final void dpV()
  {
    AppMethodBeat.i(166863);
    Object localObject = b.vvl;
    if (b.dpW().oTA.isEmpty())
    {
      this.qdl.setVisibility(8);
      localObject = this.vvd;
      if (localObject != null)
      {
        ((j)localObject).cwc();
        AppMethodBeat.o(166863);
        return;
      }
      AppMethodBeat.o(166863);
      return;
    }
    this.qdl.setVisibility(0);
    AppMethodBeat.o(166863);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(251367);
    if (this.vvb.getVisibility() == 0)
    {
      AppMethodBeat.o(251367);
      return true;
    }
    AppMethodBeat.o(251367);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.vvl;
    b.b((k)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.vvc.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      h.b localb = h.b.vvl;
      int i = h.b.dpW().oTA.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = h.b.vvl;
      localObject = h.b.dpW().oTA.get(paramInt);
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
      int i;
      Object localObject;
      if (paramView == null)
      {
        if (paramViewGroup == null) {
          p.hyc();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext());
        if (this.vvf.vve)
        {
          i = 2131494336;
          paramView = paramView.inflate(i, paramViewGroup, false);
          paramViewGroup = new h.c(this.vvf);
          localObject = paramView.findViewById(2131299223);
          p.g(localObject, "contentView.findViewById(R.id.content_tv)");
          localObject = (TextView)localObject;
          p.h(localObject, "<set-?>");
          paramViewGroup.gBb = ((TextView)localObject);
          localObject = paramView.findViewById(2131298782);
          p.g(localObject, "contentView.findViewById(R.id.close_iv)");
          localObject = (ImageView)localObject;
          p.h(localObject, "<set-?>");
          paramViewGroup.vvn = ((ImageView)localObject);
          p.g(paramView, "contentView");
          paramView.setTag(paramViewGroup);
        }
      }
      for (;;)
      {
        localObject = h.b.vvl;
        localObject = ((bbx)h.b.dpW().oTA.get(paramInt)).query;
        TextView localTextView = paramViewGroup.gBb;
        if (localTextView == null) {
          p.btv("contentTV");
        }
        localTextView.setText((CharSequence)localObject);
        paramViewGroup = paramViewGroup.vvn;
        if (paramViewGroup == null) {
          p.btv("closeIV");
        }
        paramViewGroup.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(166848);
        return paramView;
        i = 2131494610;
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchHistoryLogic.HistoryItemHolder");
          AppMethodBeat.o(166848);
          throw paramView;
        }
        paramViewGroup = (h.c)paramViewGroup;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(h.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166847);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = h.b.vvl;
        int i = paramInt;
        h.b.vvj.oTA.remove(i);
        h.b.dpY();
        h.b.dpX();
        this.vvi.vvf.dpV();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166847);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
  public static final class b
  {
    static bbw vvj;
    private static HashMap<Integer, k> vvk;
    public static final b vvl;
    
    static
    {
      AppMethodBeat.i(166858);
      vvl = new b();
      vvj = new bbw();
      vvk = new HashMap();
      Object localObject = new StringBuilder();
      al localal = al.waC;
      localObject = s.aW(al.dEF() + "search-history.info", 0, -1);
      try
      {
        vvj.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void a(k paramk)
    {
      AppMethodBeat.i(166853);
      p.h(paramk, "listener");
      ((Map)vvk).put(Integer.valueOf(paramk.hashCode()), paramk);
      AppMethodBeat.o(166853);
    }
    
    public static void auX(String paramString)
    {
      AppMethodBeat.i(166856);
      p.h(paramString, "query");
      bbx localbbx = new bbx();
      localbbx.timestamp = System.currentTimeMillis();
      localbbx.query = paramString;
      int i = 0;
      LinkedList localLinkedList = vvj.oTA;
      p.g(localLinkedList, "searchHistory.List");
      int j = ((Collection)localLinkedList).size();
      for (;;)
      {
        if (i < j)
        {
          if (p.j(((bbx)vvj.oTA.get(i)).query, paramString)) {
            vvj.oTA.remove(i);
          }
        }
        else
        {
          vvj.oTA.addFirst(localbbx);
          if (vvj.oTA.size() > 20) {
            vvj.oTA.removeLast();
          }
          dpY();
          dpX();
          AppMethodBeat.o(166856);
          return;
        }
        i += 1;
      }
    }
    
    public static void b(k paramk)
    {
      AppMethodBeat.i(166854);
      p.h(paramk, "listener");
      vvk.remove(Integer.valueOf(paramk.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    public static bbw dpW()
    {
      return vvj;
    }
    
    static void dpX()
    {
      AppMethodBeat.i(166855);
      com.tencent.f.h.RTc.aX((Runnable)a.vvm);
      AppMethodBeat.o(166855);
    }
    
    static void dpY()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = vvk.values().iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a vvm;
      
      static
      {
        AppMethodBeat.i(166852);
        vvm = new a();
        AppMethodBeat.o(166852);
      }
      
      public final void run()
      {
        AppMethodBeat.i(166851);
        Object localObject1 = new StringBuilder();
        Object localObject2 = al.waC;
        localObject1 = al.dEF() + "search-history.info";
        localObject2 = new o((String)localObject1);
        Object localObject3 = h.b.vvl;
        localObject3 = h.b.dpW().toByteArray();
        if (!s.YS(String.valueOf(((o)localObject2).heq()))) {
          s.boN(String.valueOf(((o)localObject2).heq()));
        }
        s.C((String)localObject1, (byte[])localObject3);
        AppMethodBeat.o(166851);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
  {
    public TextView gBb;
    public ImageView vvn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.h
 * JD-Core Version:    0.7.0.1
 */