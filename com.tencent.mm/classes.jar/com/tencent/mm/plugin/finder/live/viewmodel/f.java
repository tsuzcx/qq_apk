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
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.cc;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.view.adapter.b.a;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "container", "Landroid/widget/LinearLayout;", "netSceneSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch;", "recentPlayAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter;", "recentPlayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "Lkotlin/collections/ArrayList;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "space2A", "", "space2_5_A", "space4_5_A", "", "hide", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final f.a DXT;
  LinearLayout Api;
  private final int DXU;
  private final int DXV;
  private final float DXW;
  private cc DXX;
  private final ArrayList<cby> DXY;
  private final com.tencent.mm.plugin.finder.live.view.adapter.b DXZ;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(356202);
    DXT = new f.a((byte)0);
    AppMethodBeat.o(356202);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356163);
    this.DXU = ((int)getContext().getResources().getDimension(p.c.Edge_2A));
    this.DXV = ((int)getContext().getResources().getDimension(p.c.Edge_2_5_A));
    this.DXW = getContext().getResources().getDimension(p.c.Edge_4_5_A);
    this.DXY = new ArrayList();
    this.DXZ = new com.tencent.mm.plugin.finder.live.view.adapter.b();
    AppMethodBeat.o(356163);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(356217);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(p.e.BXj);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.ll_recent_play)");
    this.Api = ((LinearLayout)paramBundle);
    paramBundle = getActivity().findViewById(p.e.Cag);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.recent_play_rl_view)");
    this.mkw = ((RecyclerView)paramBundle);
    paramBundle = this.mkw;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      getContext();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label257;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label114:
      paramBundle.setAdapter((RecyclerView.a)this.DXZ);
      this.DXZ.DPH = ((kotlin.g.a.b)new b(this));
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label260;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label159:
      paramBundle.a((RecyclerView.h)new c(this));
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label263;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = localObject;
    }
    label257:
    label260:
    label263:
    for (;;)
    {
      com.tencent.mm.view.f.a(paramBundle, (e.a)new d());
      this.DXX = new cc("", "", (byte)0);
      com.tencent.mm.kernel.h.aZW().a((p)this.DXX, 0);
      com.tencent.mm.kernel.h.aZW().a(4140, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(356217);
      return;
      break;
      break label114;
      break label159;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(356227);
    com.tencent.mm.kernel.h.aZW().b(4140, (com.tencent.mm.am.h)this);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (!(paramp instanceof cc)) {
        break label112;
      }
    }
    label112:
    for (paramString = (cc)paramp;; paramString = null)
    {
      if (paramString != null)
      {
        paramString = paramString.ACd;
        if (paramString != null) {
          this.DXY.addAll((Collection)paramString.ZVd);
        }
      }
      Log.i("Finder.FinderGameLiveRecentPlayUIC", kotlin.g.b.s.X("recentPlayList.size:", Integer.valueOf(this.DXY.size())));
      d.uiThread((a)new e(this));
      AppMethodBeat.o(356227);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(356234);
    if (this.DXZ.getItemCount() > 0)
    {
      LinearLayout localLinearLayout2 = this.Api;
      LinearLayout localLinearLayout1 = localLinearLayout2;
      if (localLinearLayout2 == null)
      {
        kotlin.g.b.s.bIx("container");
        localLinearLayout1 = null;
      }
      localLinearLayout1.setVisibility(0);
    }
    AppMethodBeat.o(356234);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.view.convert.b, ah>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC$initView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    c(f paramf) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(356132);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      if (RecyclerView.bA(paramView) < 4) {}
      for (paramRect.top = f.a(this.DYa);; paramRect.top = f.b(this.DYa))
      {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          break;
        }
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(356132);
        throw paramRect;
      }
      paramView = (GridLayoutManager.LayoutParams)paramView;
      paramRect.left = ((int)(f.c(this.DYa) * paramView.bWs / 4.0F));
      float f = f.c(this.DYa);
      paramRect.right = ((int)((3.0F - paramView.bWs) * f / 4.0F));
      AppMethodBeat.o(356132);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveRecentPlayUIC$initView$3", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e.a
  {
    private final HashSet<String> AKl;
    
    d()
    {
      AppMethodBeat.i(356128);
      this.AKl = new HashSet();
      AppMethodBeat.o(356128);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(356138);
      kotlin.g.b.s.u(paramView, "parent");
      kotlin.g.b.s.u(paramList, "exposedHolders");
      paramList = ((Iterable)paramList).iterator();
      label154:
      label156:
      label159:
      label161:
      label167:
      while (paramList.hasNext())
      {
        paramView = (RecyclerView.v)paramList.next();
        label58:
        Object localObject;
        int i;
        if ((paramView instanceof b.a))
        {
          paramView = (b.a)paramView;
          if (paramView == null) {
            break label154;
          }
          paramView = paramView.DPJ;
          if (paramView == null) {
            continue;
          }
          localObject = paramView.DUE.aall;
          if ((localObject == null) || (((cbx)localObject).aakj != 1)) {
            break label156;
          }
          i = 1;
          label96:
          if (i == 0) {
            break label159;
          }
          paramView = paramView.DUE.aall;
          if (paramView != null) {
            break label161;
          }
        }
        for (paramView = null;; paramView = paramView.appid)
        {
          if ((paramView == null) || (this.AKl.contains(paramView))) {
            break label167;
          }
          this.AKl.add(paramView);
          localObject = com.tencent.mm.plugin.finder.utils.s.GgL;
          com.tencent.mm.plugin.finder.utils.s.bG(4, paramView);
          break;
          paramView = null;
          break label58;
          break;
          i = 0;
          break label96;
          break;
        }
      }
      AppMethodBeat.o(356138);
    }
    
    public final boolean dXG()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.f
 * JD-Core Version:    0.7.0.1
 */