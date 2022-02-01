package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FOOTER_COUNT", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "foldedController", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1;", "footerData", "com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$footerData$1;", "itemLayoutType", "presenter", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "initView", "", "setup", "Companion", "FoldedController", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFoldedScrollLayout
  extends FrameLayout
{
  public static final FinderFoldedScrollLayout.a Gzl;
  private static long Gzr;
  private static long Gzs;
  private static long Gzt;
  private static long Gzu;
  public WxRecyclerAdapter<a> ALE;
  public WxRecyclerView AZd;
  private final int Gzm;
  private final FinderFoldedScrollLayout.e Gzn;
  private int Gzo;
  private y Gzp;
  private final d Gzq;
  private ArrayList<a> pUj;
  
  static
  {
    AppMethodBeat.i(344015);
    Gzl = new FinderFoldedScrollLayout.a((byte)0);
    AppMethodBeat.o(344015);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(343941);
    this.Gzm = 1;
    this.pUj = new ArrayList();
    this.Gzn = new FinderFoldedScrollLayout.e();
    this.Gzq = new d(this);
    initView();
    AppMethodBeat.o(343941);
  }
  
  public FinderFoldedScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(343950);
    this.Gzm = 1;
    this.pUj = new ArrayList();
    this.Gzn = new FinderFoldedScrollLayout.e();
    this.Gzq = new d(this);
    initView();
    AppMethodBeat.o(343950);
  }
  
  private g dUK()
  {
    AppMethodBeat.i(343969);
    g localg = (g)new FinderFoldedScrollLayout.c(this);
    AppMethodBeat.o(343969);
    return localg;
  }
  
  private final void initView()
  {
    AppMethodBeat.i(343961);
    Object localObject = getContext();
    s.s(localObject, "context");
    setRecyclerView(new WxRecyclerView((Context)localObject));
    getRecyclerView().setBackgroundResource(e.d.folded_recycler_view_bg);
    addView((View)getRecyclerView(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject = getRecyclerView();
    Context localContext = getContext();
    s.s(localContext, "context");
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager(localContext, (byte)0));
    setAdapter(new WxRecyclerAdapter(dUK(), this.pUj, true));
    getRecyclerView().setAdapter((RecyclerView.a)getAdapter());
    getRecyclerView().a(getItemDecoration());
    localObject = as.GSQ;
    localObject = getContext();
    s.s(localObject, "context");
    localObject = as.a.hu((Context)localObject);
    if (localObject != null) {
      ((as)localObject).a(getAdapter());
    }
    AppMethodBeat.o(343961);
  }
  
  public final WxRecyclerAdapter<a> getAdapter()
  {
    AppMethodBeat.i(344020);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null)
    {
      AppMethodBeat.o(344020);
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    AppMethodBeat.o(344020);
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(344059);
    RecyclerView.h localh = (RecyclerView.h)new f(this);
    AppMethodBeat.o(344059);
    return localh;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(344034);
    WxRecyclerView localWxRecyclerView = this.AZd;
    if (localWxRecyclerView != null)
    {
      AppMethodBeat.o(344034);
      return localWxRecyclerView;
    }
    s.bIx("recyclerView");
    AppMethodBeat.o(344034);
    return null;
  }
  
  public final void setAdapter(WxRecyclerAdapter<a> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(344026);
    s.u(paramWxRecyclerAdapter, "<set-?>");
    this.ALE = paramWxRecyclerAdapter;
    AppMethodBeat.o(344026);
  }
  
  public final void setRecyclerView(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(344038);
    s.u(paramWxRecyclerView, "<set-?>");
    this.AZd = paramWxRecyclerView;
    AppMethodBeat.o(344038);
  }
  
  public final void setup(y paramy)
  {
    Object localObject2 = null;
    AppMethodBeat.i(344052);
    s.u(paramy, "presenter");
    this.Gzp = paramy;
    this.Gzo = paramy.dXD();
    this.pUj.clear();
    List localList = paramy.aiJ();
    StringBuilder localStringBuilder = new StringBuilder("steup foldedlayout ");
    Object localObject1 = paramy.flz();
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      localObject1 = paramy.flz();
      if (localObject1 != null) {
        break label227;
      }
      localObject1 = null;
      label96:
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      localObject1 = (BaseFinderFeed)p.ae(localList, 0);
      if (localObject1 != null) {
        break label235;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Log.i("Finder.FinderFoldedScrollLayout", localObject1);
      this.pUj.addAll((Collection)localList);
      if (paramy.aWl()) {
        this.pUj.add(this.Gzn);
      }
      paramy = getRecyclerView().getLayoutManager();
      if (paramy != null) {
        break label257;
      }
      paramy = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(344052);
      throw paramy;
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderItem)localObject1).getDebugDescription();
      break;
      label227:
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      break label96;
      label235:
      FinderItem localFinderItem = ((BaseFinderFeed)localObject1).feedObject;
      localObject1 = localObject2;
      if (localFinderItem != null) {
        localObject1 = localFinderItem.getDebugDescription();
      }
    }
    label257:
    ((FinderLinearLayoutManager)paramy).bo(0, 0);
    paramy = getRecyclerView().getAdapter();
    if (paramy != null) {
      paramy.bZE.notifyChanged();
    }
    AppMethodBeat.o(344052);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements FinderFoldedScrollLayout.b
  {
    d(FinderFoldedScrollLayout paramFinderFoldedScrollLayout) {}
    
    public final ConstraintLayout.LayoutParams dXB()
    {
      AppMethodBeat.i(344456);
      Object localObject = FinderFoldedScrollLayout.b(this.Gzv);
      if (localObject == null)
      {
        AppMethodBeat.o(344456);
        return null;
      }
      localObject = ((y)localObject).dXB();
      AppMethodBeat.o(344456);
      return localObject;
    }
    
    public final boolean dXC()
    {
      AppMethodBeat.i(344462);
      y localy = FinderFoldedScrollLayout.b(this.Gzv);
      if (localy == null)
      {
        AppMethodBeat.o(344462);
        return false;
      }
      boolean bool = localy.dXC();
      AppMethodBeat.o(344462);
      return bool;
    }
    
    public final int dXD()
    {
      AppMethodBeat.i(344466);
      y localy = FinderFoldedScrollLayout.b(this.Gzv);
      if (localy == null)
      {
        AppMethodBeat.o(344466);
        return 1;
      }
      int i = localy.dXD();
      AppMethodBeat.o(344466);
      return i;
    }
    
    public final void p(j paramj)
    {
      AppMethodBeat.i(344448);
      s.u(paramj, "holder");
      paramj.KI();
      if (FinderFoldedScrollLayout.b(this.Gzv) != null) {
        s.s(this.Gzv.getContext(), "context");
      }
      AppMethodBeat.o(344448);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.h
  {
    f(FinderFoldedScrollLayout paramFinderFoldedScrollLayout) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(344470);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int j = (int)paramView.getContext().getResources().getDimension(e.c.Edge_1_5_A);
      int k = (int)paramView.getContext().getResources().getDimension(e.c.finder_0_25_A);
      paramRecyclerView = FinderFoldedScrollLayout.b(this.Gzv);
      if (paramRecyclerView == null) {}
      for (int i = 0;; i = paramRecyclerView.flA())
      {
        i = Math.max(k, i);
        k = RecyclerView.bA(paramView);
        if (k != 0) {
          break;
        }
        paramRect.left = j;
        paramRect.right = i;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(344470);
        return;
      }
      if (k == FinderFoldedScrollLayout.c(this.Gzv).size() - 1)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(344470);
        return;
      }
      paramRect.left = i;
      paramRect.right = i;
      paramRect.bottom = 0;
      paramRect.top = 0;
      AppMethodBeat.o(344470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout
 * JD-Core Version:    0.7.0.1
 */