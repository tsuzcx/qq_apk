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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import d.g.a.b;
import d.l;
import d.v;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "onDestroy", "onTextChange", "query", "onTextSearch", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class h
  implements j
{
  View nCB;
  private ListView qIl;
  private a qIm;
  
  public h(MMActivity paramMMActivity, b<? super String, y> paramb)
  {
    AppMethodBeat.i(166864);
    View localView = paramMMActivity.findViewById(2131300754);
    d.g.b.k.g(localView, "activity.findViewById(R.id.history_lv)");
    this.qIl = ((ListView)localView);
    localView = LayoutInflater.from((Context)paramMMActivity).inflate(2131494102, (ViewGroup)this.qIl, false);
    d.g.b.k.g(localView, "LayoutInflater.from(acti…footer, historyLV, false)");
    this.nCB = localView;
    coq();
    this.qIl.addFooterView(this.nCB);
    this.qIm = new a();
    this.qIl.setAdapter((ListAdapter)this.qIm);
    this.nCB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(166844);
        this.qIn.nCB.setVisibility(8);
        paramAnonymousView = h.b.qIs;
        h.b.qIq.mAL.clear();
        h.b.cot();
        h.b.cos();
        AppMethodBeat.o(166844);
      }
    });
    this.qIl.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(166845);
        paramAnonymousAdapterView = this.qIo;
        paramAnonymousView = h.b.qIs;
        paramAnonymousView = ((akx)h.b.cor().mAL.get(paramAnonymousInt)).query;
        d.g.b.k.g(paramAnonymousView, "HistoryDataManager.searc…tory.List[position].query");
        paramAnonymousAdapterView.aA(paramAnonymousView);
        paramAnonymousAdapterView = h.b.qIs;
        paramAnonymousAdapterView = ((akx)h.b.cor().mAL.get(paramAnonymousInt)).query;
        d.g.b.k.g(paramAnonymousAdapterView, "HistoryDataManager.searc…tory.List[position].query");
        h.b.Zp(paramAnonymousAdapterView);
        AppMethodBeat.o(166845);
      }
    });
    this.qIl.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(166846);
        this.qCc.hideVKB();
        AppMethodBeat.o(166846);
        return false;
      }
    });
    paramMMActivity = b.qIs;
    b.a((j)this);
    AppMethodBeat.o(166864);
  }
  
  public final void Zo(String paramString)
  {
    AppMethodBeat.i(166860);
    if (!bt.isNullOrNil(paramString))
    {
      this.qIl.setVisibility(8);
      AppMethodBeat.o(166860);
      return;
    }
    this.qIl.setVisibility(0);
    AppMethodBeat.o(166860);
  }
  
  public final void Zp(String paramString)
  {
    AppMethodBeat.i(166862);
    if (paramString != null)
    {
      b localb = b.qIs;
      b.Zp(paramString);
      this.nCB.setVisibility(0);
      AppMethodBeat.o(166862);
      return;
    }
    AppMethodBeat.o(166862);
  }
  
  public final void coq()
  {
    AppMethodBeat.i(166863);
    b localb = b.qIs;
    if (b.cor().mAL.isEmpty())
    {
      this.nCB.setVisibility(8);
      AppMethodBeat.o(166863);
      return;
    }
    this.nCB.setVisibility(0);
    AppMethodBeat.o(166863);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166859);
    b localb = b.qIs;
    b.b((j)this);
    AppMethodBeat.o(166859);
  }
  
  public final void update()
  {
    AppMethodBeat.i(166861);
    this.qIm.notifyDataSetChanged();
    AppMethodBeat.o(166861);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(166850);
      h.b localb = h.b.qIs;
      int i = h.b.cor().mAL.size();
      AppMethodBeat.o(166850);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(166849);
      Object localObject = h.b.qIs;
      localObject = h.b.cor().mAL.get(paramInt);
      d.g.b.k.g(localObject, "HistoryDataManager.searchHistory.List[position]");
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
          d.g.b.k.fvU();
        }
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494103, paramViewGroup, false);
        paramViewGroup = new h.c(this.qIn);
        localObject = paramView.findViewById(2131298778);
        d.g.b.k.g(localObject, "contentView.findViewById(R.id.content_tv)");
        localObject = (TextView)localObject;
        d.g.b.k.h(localObject, "<set-?>");
        paramViewGroup.fwR = ((TextView)localObject);
        localObject = paramView.findViewById(2131298373);
        d.g.b.k.g(localObject, "contentView.findViewById(R.id.close_iv)");
        localObject = (ImageView)localObject;
        d.g.b.k.h(localObject, "<set-?>");
        paramViewGroup.qIu = ((ImageView)localObject);
        d.g.b.k.g(paramView, "contentView");
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = h.b.qIs;
        localObject = ((akx)h.b.cor().mAL.get(paramInt)).query;
        TextView localTextView = paramViewGroup.fwR;
        if (localTextView == null) {
          d.g.b.k.aPZ("contentTV");
        }
        localTextView.setText((CharSequence)localObject);
        paramViewGroup = paramViewGroup.qIu;
        if (paramViewGroup == null) {
          d.g.b.k.aPZ("closeIV");
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
        paramViewGroup = (h.c)paramViewGroup;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(h.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166847);
        paramView = h.b.qIs;
        int i = paramInt;
        h.b.qIq.mAL.remove(i);
        h.b.cot();
        h.b.cos();
        this.qIp.qIn.coq();
        AppMethodBeat.o(166847);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", "listener", "notifyUpdate", "onTextSearch", "query", "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
  public static final class b
  {
    static akw qIq;
    private static HashMap<Integer, j> qIr;
    public static final b qIs;
    
    static
    {
      AppMethodBeat.i(166858);
      qIs = new b();
      qIq = new akw();
      qIr = new HashMap();
      Object localObject = new StringBuilder();
      com.tencent.mm.plugin.finder.utils.k localk = com.tencent.mm.plugin.finder.utils.k.qTp;
      localObject = com.tencent.mm.vfs.i.aR(com.tencent.mm.plugin.finder.utils.k.fWh() + "search-history.info", 0, -1);
      try
      {
        qIq.parseFrom((byte[])localObject);
        AppMethodBeat.o(166858);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("Finder.FinderSearchHistoryLogic", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(166858);
      }
    }
    
    public static void Zp(String paramString)
    {
      AppMethodBeat.i(166856);
      d.g.b.k.h(paramString, "query");
      akx localakx = new akx();
      localakx.timestamp = System.currentTimeMillis();
      localakx.query = paramString;
      int i = 0;
      LinkedList localLinkedList = qIq.mAL;
      d.g.b.k.g(localLinkedList, "searchHistory.List");
      int j = ((Collection)localLinkedList).size();
      for (;;)
      {
        if (i < j)
        {
          if (d.g.b.k.g(((akx)qIq.mAL.get(i)).query, paramString)) {
            qIq.mAL.remove(i);
          }
        }
        else
        {
          qIq.mAL.addFirst(localakx);
          if (qIq.mAL.size() > 20) {
            qIq.mAL.removeLast();
          }
          cot();
          cos();
          AppMethodBeat.o(166856);
          return;
        }
        i += 1;
      }
    }
    
    public static void a(j paramj)
    {
      AppMethodBeat.i(166853);
      d.g.b.k.h(paramj, "listener");
      ((Map)qIr).put(Integer.valueOf(paramj.hashCode()), paramj);
      AppMethodBeat.o(166853);
    }
    
    public static void b(j paramj)
    {
      AppMethodBeat.i(166854);
      d.g.b.k.h(paramj, "listener");
      qIr.remove(Integer.valueOf(paramj.hashCode()));
      AppMethodBeat.o(166854);
    }
    
    public static akw cor()
    {
      return qIq;
    }
    
    static void cos()
    {
      AppMethodBeat.i(166855);
      com.tencent.e.h.Iye.aP((Runnable)a.qIt);
      AppMethodBeat.o(166855);
    }
    
    static void cot()
    {
      AppMethodBeat.i(166857);
      Iterator localIterator = qIr.values().iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).update();
      }
      AppMethodBeat.o(166857);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a qIt;
      
      static
      {
        AppMethodBeat.i(166852);
        qIt = new a();
        AppMethodBeat.o(166852);
      }
      
      public final void run()
      {
        AppMethodBeat.i(166851);
        Object localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
        localObject1 = com.tencent.mm.plugin.finder.utils.k.fWh() + "search-history.info";
        localObject2 = new e((String)localObject1);
        Object localObject3 = h.b.qIs;
        localObject3 = h.b.cor().toByteArray();
        if (!com.tencent.mm.vfs.i.eK(((e)localObject2).fhT().toString())) {
          com.tencent.mm.vfs.i.aMF(((e)localObject2).fhT().toString());
        }
        com.tencent.mm.vfs.i.B((String)localObject1, (byte[])localObject3);
        AppMethodBeat.o(166851);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
  {
    public TextView fwR;
    public ImageView qIu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.h
 * JD-Core Version:    0.7.0.1
 */