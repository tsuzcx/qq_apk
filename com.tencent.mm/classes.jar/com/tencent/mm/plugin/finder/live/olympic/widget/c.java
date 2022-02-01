package com.tencent.mm.plugin.finder.live.olympic.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent;
import com.tencent.mm.plugin.finder.live.olympic.q;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fragmentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRunnerFramgent;", "viewPageAdapter", "Lcom/tencent/mm/plugin/finder/live/olympic/RunnerFragmentAdapter;", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "viewRoot$delegate", "Lkotlin/Lazy;", "visibleChangeCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "getVisibleChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setVisibleChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "hide", "withAnimation", "removeFragment", "show", "activity", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "rootView", "Landroid/view/ViewGroup;", "isLandscape", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.widget.p
{
  private final j CSC;
  private kotlin.g.a.b<? super Boolean, ah> CSE;
  private q CSR;
  private LinkedList<FinderLiveOlympicsRunnerFramgent> CSS;
  private final String TAG;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(360745);
    this.TAG = "FinderLiveOlympicsRunnerTabWidget";
    this.CSC = kotlin.k.cm((kotlin.g.a.a)new d(paramContext, this));
    this.CSS = new LinkedList();
    AppMethodBeat.o(360745);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(360762);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360762);
      return;
    }
    a(paramc);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(360762);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(360770);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360770);
      return;
    }
    a(paramc);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(360770);
  }
  
  private static final void c(LiveBottomSheetPanel paramLiveBottomSheetPanel)
  {
    AppMethodBeat.i(360776);
    paramLiveBottomSheetPanel.show();
    AppMethodBeat.o(360776);
  }
  
  private static final void d(LiveBottomSheetPanel paramLiveBottomSheetPanel)
  {
    AppMethodBeat.i(360783);
    paramLiveBottomSheetPanel.hide();
    AppMethodBeat.o(360783);
  }
  
  private final View getViewRoot()
  {
    AppMethodBeat.i(360748);
    Object localObject = this.CSC.getValue();
    s.s(localObject, "<get-viewRoot>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(360748);
    return localObject;
  }
  
  public final void a(fgz paramfgz, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(360855);
    s.u(paramfgz, "activity");
    s.u(paramViewGroup, "rootView");
    boolean bool;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if (paramViewGroup.indexOfChild((View)this) != -1)
    {
      bool = true;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("show isLandscape:").append(paramBoolean).append(",haveAttachToRootView:").append(bool).append(",activity:");
      localObject3 = bj.GlQ;
      Log.i((String)localObject1, bj.b(paramfgz));
      if (!bool) {
        paramViewGroup.addView((View)this);
      }
      localObject1 = getViewRoot().findViewById(p.e.BYS);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new c..ExternalSyntheticLambda0(this));
      }
      localObject1 = getViewRoot().findViewById(p.e.BYR);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new c..ExternalSyntheticLambda1(this));
      }
      localObject1 = (CharSequence)paramfgz.abHo;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label441;
      }
      i = 1;
      label190:
      if (i == 0) {
        break label447;
      }
      ((TextView)getViewRoot().findViewById(p.e.BYU)).setText((CharSequence)paramViewGroup.getContext().getResources().getString(p.h.CpF));
      label227:
      this.CSS.clear();
      paramViewGroup = new LinkedList();
      localObject1 = paramfgz.abHp;
      if (localObject1 == null) {
        break label517;
      }
      localObject1 = (bv)kotlin.a.p.oL((List)localObject1);
      if (localObject1 == null) {
        break label517;
      }
      localObject1 = ((bv)localObject1).YDC;
      if (localObject1 == null) {
        break label517;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
    }
    for (;;)
    {
      label298:
      if (!((Iterator)localObject1).hasNext()) {
        break label517;
      }
      localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (bw)localObject2;
      localObject3 = (CharSequence)((bw)localObject2).YDE;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label479;
        }
        localObject3 = bj.GlQ;
        s.s(localObject2, "activityStageBoardInfo");
        localObject3 = bj.a(paramfgz, (bw)localObject2);
        this.CSS.add(new FinderLiveOlympicsRunnerFramgent((fgz)localObject3));
        localObject2 = ((bw)localObject2).YDE;
        s.checkNotNull(localObject2);
        paramViewGroup.add(localObject2);
        i = j;
        break label298;
        bool = false;
        break;
        label441:
        i = 0;
        break label190;
        label447:
        ((TextView)getViewRoot().findViewById(p.e.BYU)).setText((CharSequence)paramfgz.abHo);
        break label227;
      }
      label479:
      Log.e(getTAG(), "stage:" + i + " invalid!");
      i = j;
    }
    label517:
    if ((paramViewGroup.size() <= 0) || (this.CSS.size() != paramViewGroup.size()))
    {
      paramfgz = this.CSE;
      if (paramfgz != null) {
        paramfgz.invoke(Boolean.FALSE);
      }
      gc(false);
      Log.e(this.TAG, "titleList.size:" + paramViewGroup.size() + ",fragmentList.size:" + this.CSS.size() + '!');
      AppMethodBeat.o(360855);
      return;
    }
    paramfgz = (FinderViewPager)getViewRoot().findViewById(p.e.BYV);
    if (paramfgz != null)
    {
      localObject1 = paramfgz.getContext();
      if (localObject1 == null)
      {
        paramfgz = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        AppMethodBeat.o(360855);
        throw paramfgz;
      }
      localObject1 = ((FragmentActivity)localObject1).getSupportFragmentManager();
      s.s(localObject1, "context as FragmentActiv…y).supportFragmentManager");
      this.CSR = new q((FragmentManager)localObject1, (List)this.CSS, (List)paramViewGroup);
      paramfgz.setAdapter((androidx.viewpager.widget.a)this.CSR);
      paramfgz.setEnableViewPagerScroll(true);
      paramfgz.setOffscreenPageLimit(kotlin.k.k.qv(paramViewGroup.size() - 1, 5));
    }
    paramfgz = (TabLayout)getViewRoot().findViewById(p.e.BYT);
    if (paramfgz != null)
    {
      paramfgz.setupWithViewPager((ViewPager)getViewRoot().findViewById(p.e.BYV));
      paramfgz.a((TabLayout.b)new a(this));
      paramfgz.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b(paramfgz, this));
    }
    paramfgz = (LiveBottomSheetPanel)getViewRoot().findViewById(p.e.Cay);
    if (paramBoolean)
    {
      paramfgz.getLayoutParams().width = bf.bf(paramfgz.getContext()).y;
      paramfgz.setTranslationX(bf.bf(paramfgz.getContext()).y);
    }
    for (;;)
    {
      paramfgz.setOnVisibilityListener((kotlin.g.a.b)new c(this));
      paramfgz.post(new c..ExternalSyntheticLambda3(paramfgz));
      Log.i(this.TAG, "offscreenPageLimit:" + kotlin.k.k.qv(paramViewGroup.size() - 1, 5) + ' ');
      AppMethodBeat.o(360855);
      return;
      paramfgz.setTranslationY(bf.bf(paramfgz.getContext()).y);
      ((RoundCornerRelativeLayout)getViewRoot().findViewById(p.e.Cax)).A(getViewRoot().getContext().getResources().getDimension(p.c.Edge_1_5_A), getViewRoot().getContext().getResources().getDimension(p.c.Edge_1_5_A), 0.0F, 0.0F);
    }
  }
  
  public final void eoC()
  {
    AppMethodBeat.i(360866);
    for (;;)
    {
      Object localObject2;
      Context localContext;
      try
      {
        Object localObject1 = ((Iterable)this.CSS).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (FinderLiveOlympicsRunnerFramgent)((Iterator)localObject1).next();
        localContext = getContext();
        if (localContext == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(360866);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        localObject2 = aw.Gjk;
        aw.a(localException, s.X(this.TAG, "-removeFragment"));
        AppMethodBeat.o(360866);
        return;
      }
      ((FragmentActivity)localContext).getSupportFragmentManager().beginTransaction().a((Fragment)localObject2).FW();
    }
    this.CSS.clear();
    AppMethodBeat.o(360866);
  }
  
  public final void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(360861);
    Log.i(this.TAG, s.X("hide withAnimation:", Boolean.valueOf(paramBoolean)));
    Object localObject;
    if (paramBoolean)
    {
      localObject = (LiveBottomSheetPanel)getViewRoot().findViewById(p.e.Cay);
      if (localObject != null)
      {
        ((LiveBottomSheetPanel)localObject).post(new c..ExternalSyntheticLambda2((LiveBottomSheetPanel)localObject));
        AppMethodBeat.o(360861);
      }
    }
    else
    {
      localObject = this.CSE;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
      }
      eoC();
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg((View)this);
    }
    AppMethodBeat.o(360861);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getVisibleChangeCallback()
  {
    return this.CSE;
  }
  
  public final void setVisibleChangeCallback(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.CSE = paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget$show$5$1", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "tab", "onTabSelected", "onTabUnselected", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements TabLayout.b<TabLayout.e>
  {
    a(c paramc) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(360684);
      String str = this.CST.getTAG();
      Object localObject;
      int i;
      if (parame == null)
      {
        localObject = null;
        Log.i(str, s.X("onTabSelected:", localObject));
        localObject = c.b(this.CST);
        if ((parame != null) && (localObject != null))
        {
          i = ((q)localObject).getCount();
          int j = parame.position;
          if (j < 0) {
            break label127;
          }
          if (j >= i) {
            break label122;
          }
          i = 1;
          label73:
          if (i != 0)
          {
            parame = ((q)localObject).getItem(parame.position);
            if (!(parame instanceof FinderLiveOlympicsRunnerFramgent)) {
              break label132;
            }
          }
        }
      }
      label132:
      for (parame = (FinderLiveOlympicsRunnerFramgent)parame;; parame = null)
      {
        if (parame != null) {
          parame.onUserVisibleFocused();
        }
        AppMethodBeat.o(360684);
        return;
        localObject = parame.bba;
        break;
        label122:
        i = 0;
        break label73;
        label127:
        i = 0;
        break label73;
      }
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(360694);
      String str = this.CST.getTAG();
      Object localObject;
      int i;
      if (parame == null)
      {
        localObject = null;
        Log.i(str, s.X("onTabUnselected:", localObject));
        localObject = c.b(this.CST);
        if ((parame != null) && (localObject != null))
        {
          i = ((q)localObject).getCount();
          int j = parame.position;
          if (j < 0) {
            break label127;
          }
          if (j >= i) {
            break label122;
          }
          i = 1;
          label73:
          if (i != 0)
          {
            parame = ((q)localObject).getItem(parame.position);
            if (!(parame instanceof FinderLiveOlympicsRunnerFramgent)) {
              break label132;
            }
          }
        }
      }
      label132:
      for (parame = (FinderLiveOlympicsRunnerFramgent)parame;; parame = null)
      {
        if (parame != null) {
          parame.onUserVisibleUnFocused();
        }
        AppMethodBeat.o(360694);
        return;
        localObject = parame.bba;
        break;
        label122:
        i = 0;
        break label73;
        label127:
        i = 0;
        break label73;
      }
    }
    
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(360699);
      String str = this.CST.getTAG();
      if (parame == null) {}
      for (parame = null;; parame = parame.bba)
      {
        Log.i(str, s.X("onTabReselected:", parame));
        AppMethodBeat.o(360699);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveOlympicsRunnerTabWidget$show$5$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ViewTreeObserver.OnPreDrawListener
  {
    b(TabLayout paramTabLayout, c paramc) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(360688);
      this.CSU.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject;
      label62:
      int i;
      if (this.CSU.getTabCount() > 0)
      {
        localObject = this.CSU.js(0);
        if (localObject != null) {
          break label140;
        }
        localObject = null;
        if (!(localObject instanceof ViewGroup)) {
          break label150;
        }
        localObject = (ViewGroup)localObject;
        if (localObject != null) {
          break label156;
        }
        i = 0;
        label69:
        if (i <= 0) {
          break label181;
        }
      }
      int k;
      label87:
      label105:
      label233:
      for (int j = 0;; j = k)
      {
        k = j + 1;
        View localView;
        if (localObject == null)
        {
          localView = null;
          if (!(localView instanceof TextView)) {
            break label176;
          }
          i = ((ViewGroup)localObject).getChildAt(j).getMeasuredHeight();
          if (i <= 0) {
            break label186;
          }
          this.CSU.getLayoutParams().height = (i + MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A));
        }
        for (;;)
        {
          AppMethodBeat.o(360688);
          return true;
          localObject = ((TabLayout.e)localObject).dyM;
          break;
          localObject = null;
          break label62;
          i = ((ViewGroup)localObject).getChildCount();
          break label69;
          localView = ((ViewGroup)localObject).getChildAt(j);
          break label87;
          if (k < i) {
            break label233;
          }
          i = 0;
          break label105;
          Log.i(jdField_this.getTAG(), "tabHeight:" + i + ",tabLayout height:" + this.CSU.getLayoutParams().height);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(Context paramContext, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.widget.c
 * JD-Core Version:    0.7.0.1
 */