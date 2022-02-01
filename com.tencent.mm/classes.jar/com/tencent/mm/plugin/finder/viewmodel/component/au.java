package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.c.b;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.findersdk.a.n;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activeFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getActiveFragment", "()Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "activeFragment$delegate", "Lkotlin/Lazy;", "config", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM$Config;", "getConfig", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM$Config;", "config$delegate", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "delayedHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showFeedId", "", "showState", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$ShowState;", "tabType", "", "getTabType", "()I", "tabType$delegate", "checkShowGuide", "", "feedId", "position", "mediaType", "percent", "", "videoDuration", "delayDismissGuide", "dismissGuide", "currentPosition", "incrementCount", "isShouldShowGuide", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showGuide", "Companion", "ShowState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends UIComponent
{
  public static final a GUb;
  private static final long GUh;
  private static int GUi;
  private final j Fqc;
  private final j GUc;
  private final j GUd;
  private long GUe;
  private final MMHandler GUf;
  private b GUg;
  private RecyclerView mkw;
  private final j vFm;
  
  static
  {
    AppMethodBeat.i(338289);
    GUb = new a((byte)0);
    GUh = 604800000L;
    AppMethodBeat.o(338289);
  }
  
  public au(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338071);
    this.vFm = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.GUc = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.GUd = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.GUf = new MMHandler(com.tencent.threadpool.j.a.jZz());
    this.GUg = b.GUm;
    AppMethodBeat.o(338071);
  }
  
  public au(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338060);
    this.vFm = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.GUc = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.GUd = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.GUf = new MMHandler(com.tencent.threadpool.j.a.jZz());
    this.GUg = b.GUm;
    AppMethodBeat.o(338060);
  }
  
  private final void a(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    AppMethodBeat.i(338124);
    long l;
    if (this.GUg != b.GUn)
    {
      Object localObject = this.mkw;
      if (localObject == null) {
        i = 0;
      }
      boolean bool1;
      while (i - 1 <= paramInt1)
      {
        Log.i("Finder.SlideMoreGuideUIC", "[isShouldShowGuide] itemCount[" + i + "] -1 <= position[" + paramInt1 + ']');
        bool1 = false;
        if (bool1) {
          break label432;
        }
        this.GUg = b.GUn;
        AppMethodBeat.o(338124);
        return;
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject == null) {
          i = 0;
        } else {
          i = ((RecyclerView.a)localObject).getItemCount();
        }
      }
      int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhr, 0);
      l = com.tencent.mm.kernel.h.baE().ban().a(at.a.adhs, 0L);
      int i = j;
      if (foQ().GKj == 3)
      {
        i = j;
        if (System.currentTimeMillis() - l >= GUh)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adhr, Integer.valueOf(0));
          i = 0;
          Log.i("Finder.SlideMoreGuideUIC", "[isShouldShowGuide] reset count.");
        }
      }
      if (foQ().GKj == 1) {
        if (i <= 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        boolean bool2 = bool1;
        if (GUi != 0)
        {
          bool2 = bool1;
          if (GUi != getTabType()) {
            bool2 = false;
          }
        }
        if (this.GUg == b.GUm) {
          Log.i("Finder.SlideMoreGuideUIC", "[isShouldShowGuide] result=" + bool2 + " position=" + paramInt1 + " tabType=" + getTabType() + " countStyle=" + foQ().GKj + " configCount=" + foQ().wDI + " count=" + i + " time=" + l + " otherTabTypeShowing=" + GUi);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        GUi = getTabType();
        bool1 = bool2;
        break;
        bool1 = false;
        continue;
        if (i < foQ().wDI) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
    }
    label432:
    if (this.GUg != b.GUm)
    {
      AppMethodBeat.o(338124);
      return;
    }
    switch (foQ().phI)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(338124);
      return;
      this.GUg = b.GUl;
      this.GUf.removeCallbacksAndMessages(null);
      this.GUf.postUIDelayed(new au..ExternalSyntheticLambda3(this, paramLong, paramInt1), 1000L);
      AppMethodBeat.o(338124);
      return;
      l = foQ().GKf;
      if (paramInt2 != 4)
      {
        this.GUg = b.GUl;
        this.GUf.removeCallbacksAndMessages(null);
        this.GUf.postUIDelayed(new au..ExternalSyntheticLambda4(this, paramLong, paramInt1), l * 1000L);
        AppMethodBeat.o(338124);
        return;
      }
      if (paramFloat >= Math.min(1.0F * foQ().GKf / Math.max(1, paramInt3), 1.0F))
      {
        this.GUg = b.GUl;
        this.GUf.removeCallbacksAndMessages(null);
        this.GUf.post(new au..ExternalSyntheticLambda5(this, paramLong, paramInt1));
        AppMethodBeat.o(338124);
        return;
        if (paramFloat >= foQ().GKg)
        {
          this.GUg = b.GUl;
          this.GUf.removeCallbacksAndMessages(null);
          this.GUf.post(new au..ExternalSyntheticLambda2(this, paramLong, paramInt1));
        }
      }
    }
  }
  
  private static final void a(au paramau, long paramLong)
  {
    AppMethodBeat.i(338237);
    s.u(paramau, "this$0");
    Log.i("Finder.SlideMoreGuideUIC", "[delayDismissGuide] delay " + paramau.foQ().GKi + "s dismiss");
    paramau.aj(paramLong, 2147483647);
    AppMethodBeat.o(338237);
  }
  
  private static final void a(au paramau, long paramLong, int paramInt)
  {
    AppMethodBeat.i(338194);
    s.u(paramau, "this$0");
    if (paramau.ai(paramLong, paramInt)) {
      paramau.ri(paramLong);
    }
    AppMethodBeat.o(338194);
  }
  
  private static final void a(au paramau, View paramView)
  {
    AppMethodBeat.i(338232);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramau);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramau, "this$0");
    paramau.aj(paramau.GUe, 2147483647);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338232);
  }
  
  private final boolean ai(final long paramLong, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(338148);
    Log.i("Finder.SlideMoreGuideUIC", "[showGuide] ... tabType=" + getTabType() + " showState=" + this.GUg + " feedId=" + com.tencent.mm.ae.d.hF(paramLong) + " position=" + paramInt);
    if (this.GUg != b.GUl)
    {
      AppMethodBeat.o(338148);
      return false;
    }
    this.GUg = b.GUk;
    this.GUe = paramLong;
    if (foQ().GKj != 1) {
      foR();
    }
    com.tencent.mm.view.f.a((View)getContainer(), (e.b)new h(this, paramLong));
    Object localObject2 = getActiveFragment();
    if (localObject2 == null)
    {
      localObject2 = null;
      if ((localObject2 instanceof FrameLayout)) {
        localObject1 = (FrameLayout)localObject2;
      }
      if ((localObject1 != null) && (((FrameLayout)localObject1).indexOfChild((View)getContainer()) < 0))
      {
        localObject2 = (View)getContainer();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams.gravity = 17;
        ah localah = ah.aiuX;
        ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
      }
      if (foQ().GKh != 3) {
        break label345;
      }
      getContainer().setClickable(true);
      getContainer().setOnClickListener(new au..ExternalSyntheticLambda0(this));
    }
    for (;;)
    {
      localObject1 = (PAGView)getContainer().findViewWithTag("pag");
      if (localObject1 != null) {
        ((PAGView)localObject1).play();
      }
      getContainer().setTag(Integer.valueOf(paramInt));
      getContainer().setAlpha(0.0F);
      getContainer().animate().alpha(1.0F).setDuration(300L).start();
      AppMethodBeat.o(338148);
      return true;
      localObject2 = ((UIComponentFragment)localObject2).rootView;
      break;
      label345:
      getContainer().setClickable(false);
    }
  }
  
  private final void aj(long paramLong, int paramInt)
  {
    AppMethodBeat.i(338171);
    Object localObject1 = getContainer().getTag();
    if ((localObject1 instanceof Integer))
    {
      localObject1 = (Integer)localObject1;
      if (localObject1 != null) {
        break label244;
      }
    }
    label244:
    for (int i = -1;; i = ((Integer)localObject1).intValue())
    {
      Log.i("Finder.SlideMoreGuideUIC", "[dismissGuide] tabType=" + getTabType() + " feedId=" + com.tencent.mm.ae.d.hF(paramLong) + " showState=" + this.GUg + " showPosition=" + i + " currentPosition=" + paramInt);
      if (((i < paramInt) || (paramInt == 2147483647)) && (this.GUg == b.GUk))
      {
        getContainer().setVisibility(8);
        if (foQ().GKj == 1)
        {
          foR();
          GUi = 0;
        }
        this.GUg = b.GUj;
        this.GUf.removeCallbacksAndMessages(null);
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = ((as)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(as.class)).Vl(getTabType());
        Object localObject2 = bb.FuK;
        localObject2 = n.Hcg;
        bb.a((bui)localObject1, "timeline_slide_guide", false, paramLong, n.frD());
      }
      AppMethodBeat.o(338171);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private static final void b(au paramau, long paramLong, int paramInt)
  {
    AppMethodBeat.i(338204);
    s.u(paramau, "this$0");
    if (paramau.ai(paramLong, paramInt)) {
      paramau.ri(paramLong);
    }
    AppMethodBeat.o(338204);
  }
  
  private static final void c(au paramau, long paramLong, int paramInt)
  {
    AppMethodBeat.i(338216);
    s.u(paramau, "this$0");
    if (paramau.ai(paramLong, paramInt)) {
      paramau.ri(paramLong);
    }
    AppMethodBeat.o(338216);
  }
  
  private static final void d(au paramau, long paramLong, int paramInt)
  {
    AppMethodBeat.i(338224);
    s.u(paramau, "this$0");
    if (paramau.ai(paramLong, paramInt)) {
      paramau.ri(paramLong);
    }
    AppMethodBeat.o(338224);
  }
  
  private final c.b foQ()
  {
    AppMethodBeat.i(338097);
    c.b localb = (c.b)this.GUd.getValue();
    AppMethodBeat.o(338097);
    return localb;
  }
  
  private static void foR()
  {
    AppMethodBeat.i(338182);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhr, 0);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhr, Integer.valueOf(i + 1));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adhs, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(338182);
  }
  
  private final FinderHomeTabFragment getActiveFragment()
  {
    AppMethodBeat.i(338092);
    FinderHomeTabFragment localFinderHomeTabFragment = (FinderHomeTabFragment)this.GUc.getValue();
    AppMethodBeat.o(338092);
    return localFinderHomeTabFragment;
  }
  
  private final LinearLayout getContainer()
  {
    AppMethodBeat.i(338079);
    LinearLayout localLinearLayout = (LinearLayout)this.vFm.getValue();
    AppMethodBeat.o(338079);
    return localLinearLayout;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(338083);
    int i = ((Number)this.Fqc.getValue()).intValue();
    AppMethodBeat.o(338083);
    return i;
  }
  
  private final void ri(long paramLong)
  {
    AppMethodBeat.i(338162);
    if ((foQ().GKh == 2) && (this.GUg == b.GUk)) {
      this.GUf.postUIDelayed(new au..ExternalSyntheticLambda1(this, paramLong), foQ().GKi * 1000L);
    }
    AppMethodBeat.o(338162);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(338344);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(getTabType());
    boolean bool1 = paramBundle.GKD;
    boolean bool2 = paramBundle.GKE;
    paramBundle = foQ();
    s.u(paramBundle, "<this>");
    Log.i("Finder.SlideMoreGuideUIC", s.X("config=", "[type=" + paramBundle.scene + ",guide_appear_time=" + paramBundle.phI + ",appear_time_second=" + paramBundle.GKf + ",appear_time_percent=" + paramBundle.GKg + ",guide_disappear_time=" + paramBundle.GKh + ",disappear_time_second=" + paramBundle.GKi + ",guide_appear_frequency=" + paramBundle.GKj + ",frequency_limit=" + paramBundle.wDI + ']'));
    if (foQ().scene == 0)
    {
      Log.w("Finder.SlideMoreGuideUIC", s.X("just return. configScene=", Integer.valueOf(foQ().scene)));
      AppMethodBeat.o(338344);
      return;
    }
    if ((bool1) && (!bool2) && (foQ().scene != 1))
    {
      Log.w("Finder.SlideMoreGuideUIC", s.X("just return. isInInnerAppPush configScene=", Integer.valueOf(foQ().scene)));
      AppMethodBeat.o(338344);
      return;
    }
    if ((bool1) && (bool2) && (foQ().scene != 2))
    {
      Log.w("Finder.SlideMoreGuideUIC", s.X("just return. isInInnerAppPush configScene=", Integer.valueOf(foQ().scene)));
      AppMethodBeat.o(338344);
      return;
    }
    if ((foQ().scene == 3) && (bool1))
    {
      Log.w("Finder.SlideMoreGuideUIC", s.X("just return. isInInnerAppPush configScene=", Integer.valueOf(foQ().scene)));
      AppMethodBeat.o(338344);
      return;
    }
    Log.i("Finder.SlideMoreGuideUIC", "scene=" + foQ().scene + " isAppPush=" + bool1);
    paramBundle = getActiveFragment();
    if (paramBundle != null)
    {
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = ((bd)com.tencent.mm.ui.component.k.y((Fragment)paramBundle).q(bd.class)).getRecyclerView();
      this.mkw = paramBundle;
      localObject = paramBundle.getLayoutManager();
      if (localObject == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(338344);
        throw paramBundle;
      }
      paramBundle.a((RecyclerView.l)new f(this, (LinearLayoutManager)localObject));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = ((as)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(as.class)).Vr(getTabType());
      if (paramBundle != null) {
        paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)new g(this));
      }
    }
    AppMethodBeat.o(338344);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338350);
    super.onDestroy();
    if (!(getActivity() instanceof OccupyFinderUI5))
    {
      GUi = 0;
      this.GUf.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(338350);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$Companion;", "", "()V", "ONE_WEEK", "", "getONE_WEEK", "()J", "TAG", "", "otherTabTypeShowing", "", "getOtherTabTypeShowing", "()I", "setOtherTabTypeShowing", "(I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$ShowState;", "", "(Ljava/lang/String;I)V", "SHOWN", "SHOWING", "READY", "DEFAULT", "DISABLE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(338523);
      GUj = new b("SHOWN", 0);
      GUk = new b("SHOWING", 1);
      GUl = new b("READY", 2);
      GUm = new b("DEFAULT", 3);
      GUn = new b("DISABLE", 4);
      GUo = new b[] { GUj, GUk, GUl, GUm, GUn };
      AppMethodBeat.o(338523);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<FinderHomeTabFragment>
  {
    c(au paramau)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGuideConfigVM$Config;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<c.b>
  {
    d(au paramau)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    e(au paramau)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$onCreateAfter$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.l
  {
    f(au paramau, LinearLayoutManager paramLinearLayoutManager) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(338493);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$onCreateAfter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$onCreateAfter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(338493);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(338487);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$onCreateAfter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if ((au.c(this.GUp) == au.b.GUk) && (this.FQO.Ju() == 0))
      {
        paramRecyclerView = paramRecyclerView.fU(0);
        if (paramRecyclerView != null)
        {
          localObject = this.GUp;
          float f = 1.0F * paramRecyclerView.caK.getBottom() / paramRecyclerView.caK.getHeight();
          au.d((au)localObject).setAlpha(f);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$onCreateAfter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(338487);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$onCreateAfter$1$2$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    g(au paramau) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      int i = 1;
      int j = 1;
      AppMethodBeat.i(338480);
      s.u(paramb, "ev");
      Object localObject;
      label91:
      long l;
      label154:
      label159:
      float f;
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6))
      {
        localObject = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOy;
        if ((localObject != null) && (((FeedData)localObject).getMediaType() == 9))
        {
          i = 1;
          if (i == 0)
          {
            localObject = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOy;
            if ((localObject == null) || (((FeedData)localObject).getMediaType() != 2)) {
              break label154;
            }
            i = j;
            if (i == 0) {
              break label296;
            }
          }
          l = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv;
          j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOw;
          localObject = this.GUp;
          paramb = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOy;
          if (paramb != null) {
            break label159;
          }
        }
        for (i = 0;; i = paramb.getMediaType())
        {
          au.a((au)localObject, l, j, i);
          AppMethodBeat.o(338480);
          return;
          i = 0;
          break;
          i = 0;
          break label91;
        }
      }
      else
      {
        if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).AOq > 0))
        {
          au.e(this.GUp, au.b(this.GUp), ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOw);
          AppMethodBeat.o(338480);
          return;
        }
        if ((paramb instanceof c.a))
        {
          f = 100.0F * ((c.a)paramb).offset / ((c.a)paramb).total;
          localObject = this.GUp;
          l = ((c.a)paramb).feedId;
          j = ((c.a)paramb).position;
          paramb = ((c.a)paramb).ANJ;
          if (paramb != null) {
            break label302;
          }
        }
      }
      for (;;)
      {
        au.a((au)localObject, l, j, f, i);
        label296:
        AppMethodBeat.o(338480);
        return;
        label302:
        i = paramb.videoDuration;
      }
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(338502);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6)))
      {
        AppMethodBeat.o(338502);
        return true;
      }
      if (((paramb instanceof c.a)) && ((((c.a)paramb).type == 1) || (((c.a)paramb).type == 3)))
      {
        AppMethodBeat.o(338502);
        return true;
      }
      AppMethodBeat.o(338502);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSlideMoreGuideUIC$showGuide$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends e.b
  {
    h(au paramau, long paramLong) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(338455);
      s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = com.tencent.mm.ui.component.k.aeZF;
        paramView = ((as)com.tencent.mm.ui.component.k.nq((Context)this.GUp.getContext()).q(as.class)).Vl(au.a(this.GUp));
        Object localObject = bb.FuK;
        paramLong1 = paramLong;
        localObject = n.Hcg;
        bb.a(paramView, "timeline_slide_guide", true, paramLong1, n.frD());
      }
      AppMethodBeat.o(338455);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Integer>
  {
    i(au paramau)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.au
 * JD-Core Version:    0.7.0.1
 */