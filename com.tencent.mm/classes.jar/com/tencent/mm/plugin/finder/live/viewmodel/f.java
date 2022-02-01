package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.live.view.adapter.b.a;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "container", "Landroid/widget/LinearLayout;", "netSceneSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch;", "recentPlayAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter;", "recentPlayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "Lkotlin/collections/ArrayList;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "space2A", "", "space2_5_A", "space4_5_A", "", "hide", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "Companion", "plugin-finder_release"})
public final class f
  extends UIComponent
  implements i
{
  public static final a zbU;
  private RecyclerView jLl;
  LinearLayout wSF;
  private final int zbO;
  private final int zbP;
  private final float zbQ;
  private bf zbR;
  private final ArrayList<bnu> zbS;
  private final com.tencent.mm.plugin.finder.live.view.adapter.b zbT;
  
  static
  {
    AppMethodBeat.i(269155);
    zbU = new a((byte)0);
    AppMethodBeat.o(269155);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(269154);
    this.zbO = ((int)getContext().getResources().getDimension(b.d.Edge_2A));
    this.zbP = ((int)getContext().getResources().getDimension(b.d.Edge_2_5_A));
    this.zbQ = getContext().getResources().getDimension(b.d.Edge_4_5_A);
    this.zbS = new ArrayList();
    this.zbT = new com.tencent.mm.plugin.finder.live.view.adapter.b();
    AppMethodBeat.o(269154);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(269151);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(b.f.ll_recent_play);
    p.j(paramBundle, "activity.findViewById(R.id.ll_recent_play)");
    this.wSF = ((LinearLayout)paramBundle);
    paramBundle = getActivity().findViewById(b.f.recent_play_rl_view);
    p.j(paramBundle, "activity.findViewById(R.id.recent_play_rl_view)");
    this.jLl = ((RecyclerView)paramBundle);
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.zbT);
    this.zbT.yVM = ((kotlin.g.a.b)new b(this));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    paramBundle.b((RecyclerView.h)new c(this));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    com.tencent.mm.view.f.a(paramBundle, (e.a)new d());
    this.zbR = new bf("", "", (byte)0);
    h.aGY().b((com.tencent.mm.an.q)this.zbR);
    h.aGY().a(4140, (i)this);
    AppMethodBeat.o(269151);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(269152);
    h.aGY().b(4140, (i)this);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof bf)) {
        break label120;
      }
    }
    label120:
    for (paramString = null;; paramString = paramq)
    {
      paramString = (bf)paramString;
      if (paramString != null)
      {
        paramString = paramString.xcM;
        if (paramString != null) {
          this.zbS.addAll((Collection)paramString.SNN);
        }
      }
      Log.i("Finder.FinderGameLiveRecentPlayUIC", "recentPlayList.size:" + this.zbS.size());
      d.uiThread((a)new e(this));
      AppMethodBeat.o(269152);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(269153);
    if (this.zbT.getItemCount() > 0)
    {
      LinearLayout localLinearLayout = this.wSF;
      if (localLinearLayout == null) {
        p.bGy("container");
      }
      localLinearLayout.setVisibility(0);
    }
    AppMethodBeat.o(269153);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC$Companion;", "", "()V", "MAX_COUNT", "", "SPAN_COUNT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.view.convert.b, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC$initView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(285665);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      if (RecyclerView.bh(paramView) < 4) {}
      for (paramRect.top = f.a(this.zbV);; paramRect.top = f.b(this.zbV))
      {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          break;
        }
        paramRect = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(285665);
        throw paramRect;
      }
      paramView = (GridLayoutManager.LayoutParams)paramView;
      paramRect.left = ((int)(f.c(this.zbV) * paramView.kv() / 4.0F));
      float f = f.c(this.zbV);
      paramRect.right = ((int)((3.0F - paramView.kv()) * f / 4.0F));
      AppMethodBeat.o(285665);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC$initView$3", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class d
    extends e.a
  {
    private final HashSet<String> xlV;
    
    d()
    {
      AppMethodBeat.i(275283);
      this.xlV = new HashSet();
      AppMethodBeat.o(275283);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(275281);
      p.k(paramView, "parent");
      p.k(paramList, "exposedHolders");
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        paramList = (RecyclerView.v)localIterator.next();
        paramView = paramList;
        if (!(paramList instanceof b.a)) {
          paramView = null;
        }
        paramView = (b.a)paramView;
        if (paramView != null)
        {
          paramView = paramView.yVO;
          if (paramView != null)
          {
            paramList = paramView.zaE.SYP;
            if ((paramList != null) && (paramList.SYi == 1))
            {
              paramView = paramView.zaE.SYP;
              if (paramView != null)
              {
                paramView = paramView.appid;
                if ((paramView != null) && (!this.xlV.contains(paramView)))
                {
                  this.xlV.add(paramView);
                  paramList = o.ADA;
                  o.bd(4, paramView);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(275281);
    }
    
    public final boolean dpC()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements a<x>
  {
    e(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.f
 * JD-Core Version:    0.7.0.1
 */