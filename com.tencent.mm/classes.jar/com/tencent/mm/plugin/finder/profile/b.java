package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawer", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer;)V", "header", "Landroid/view/View;", "getHeader", "()Landroid/view/View;", "setHeader", "(Landroid/view/View;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "onBuildDrawerBody", "", "onBuildDrawerHeader", "headerLayout", "Landroid/widget/FrameLayout;", "onBuildLoading", "loadingLayout", "onDrawerCreated", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "", "isBegin", "onDrawerTranslation", "percent", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements RecyclerViewDrawerSquares.c
{
  public RefreshLoadMoreLayout ATx;
  public FinderProfilePoiDrawer Faf;
  public View Fag;
  public Context context;
  public RecyclerView mkw;
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(348198);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    RecyclerViewDrawer.b((RecyclerViewDrawer)paramb.eIt());
    a.a(new Object(), "com/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawerBuilder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348198);
  }
  
  public static void c(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(348185);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "loadingLayout");
    AppMethodBeat.o(348185);
  }
  
  private FinderProfilePoiDrawer eIt()
  {
    AppMethodBeat.i(348177);
    FinderProfilePoiDrawer localFinderProfilePoiDrawer = this.Faf;
    if (localFinderProfilePoiDrawer != null)
    {
      AppMethodBeat.o(348177);
      return localFinderProfilePoiDrawer;
    }
    s.bIx("drawer");
    AppMethodBeat.o(348177);
    return null;
  }
  
  public final void ak(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void b(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(348226);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "headerLayout");
    paramContext = af.mU(paramContext).inflate(e.f.finder_profile_poi_list_header, (ViewGroup)paramFrameLayout);
    s.s(paramContext, "getInflater(context).inf…ist_header, headerLayout)");
    s.u(paramContext, "<set-?>");
    this.Fag = paramContext;
    paramContext = eIu().findViewById(e.e.close_area_layout);
    if (paramContext != null) {
      paramContext.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    }
    if (paramContext != null) {
      eIt().mA(paramContext);
    }
    paramContext = (LinearLayout)eIu().findViewById(e.e.drawer_top_search_layout);
    paramFrameLayout = eIt();
    s.s(paramContext, "topSearchLayout");
    paramFrameLayout.mA((View)paramContext);
    paramContext = (FTSSearchView)eIu().findViewById(e.e.drawer_header_search);
    paramFrameLayout = eIt();
    s.s(paramContext, "searchView");
    paramFrameLayout.mA((View)paramContext);
    AppMethodBeat.o(348226);
  }
  
  public final void cm(float paramFloat) {}
  
  public final View eIu()
  {
    AppMethodBeat.i(348213);
    View localView = this.Fag;
    if (localView != null)
    {
      AppMethodBeat.o(348213);
      return localView;
    }
    s.bIx("header");
    AppMethodBeat.o(348213);
    return null;
  }
  
  public final void eIv() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.b
 * JD-Core Version:    0.7.0.1
 */