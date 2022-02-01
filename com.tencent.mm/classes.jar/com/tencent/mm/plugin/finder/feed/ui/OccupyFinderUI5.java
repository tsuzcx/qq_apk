package com.tencent.mm.plugin.finder.feed.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.preload.f;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.MMFinderFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.plugin.finder.viewmodel.component.ao;
import com.tencent.mm.plugin.finder.viewmodel.component.aq;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ay;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.c;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "()V", "enterTime", "", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFriendTabFragment;", "isAutoRefreshFriendTab", "", "isDispatchOnUserVisibleFocused", "isFromShareToTimeline", "isRunningAnim", "page_exit_mode", "", "resumeTime", "enableActivityAnimation", "finish", "", "fixActionBarStatus", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isHideStatusBar", "isSupportNavigationSwipeBack", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "onStop", "onSwipeBack", "onWindowFocusChanged", "hasFocus", "overlayStatusBar", "revealActivity", "rootLayout", "Landroid/view/View;", "x", "y", "isExit", "call", "Lkotlin/Function0;", "runEnterAnim", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class OccupyFinderUI5
  extends MMFinderFeedDetailUI
{
  public static final a Bth;
  private static boolean Btp;
  private static long Btq;
  private static WeakReference<Activity> Btr;
  private long Bti;
  private FinderFriendTabFragment Btj;
  private boolean Btk;
  private boolean Btl;
  private int Btm;
  private boolean Btn;
  private boolean Bto;
  private long enterTime;
  
  static
  {
    AppMethodBeat.i(365661);
    Bth = new a((byte)0);
    Btq = System.nanoTime();
    AppMethodBeat.o(365661);
  }
  
  private static final Map a(OccupyFinderUI5 paramOccupyFinderUI5, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(365612);
    kotlin.g.b.s.u(paramOccupyFinderUI5, "this$0");
    paramString = paramOccupyFinderUI5.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!org.apache.commons.c.i.hm(paramString)) {
        break label208;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label208:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      kotlin.r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      kotlin.r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramOccupyFinderUI5 = paramOccupyFinderUI5.getIntent();
      if (paramOccupyFinderUI5 == null) {}
      for (paramOccupyFinderUI5 = localObject2;; paramOccupyFinderUI5 = paramOccupyFinderUI5.getStringExtra("key_enter_source_info"))
      {
        paramOccupyFinderUI5 = ak.e(new kotlin.r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramOccupyFinderUI5)) });
        AppMethodBeat.o(365612);
        return paramOccupyFinderUI5;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(365580);
    kotlin.g.b.s.u(paramView, "rootLayout");
    kotlin.g.b.s.u(parama, "call");
    if (this.Bto)
    {
      AppMethodBeat.o(365580);
      return;
    }
    float f2 = kotlin.k.k.qu(paramView.getWidth(), paramView.getHeight());
    float f1;
    label131:
    Animator localAnimator;
    long l;
    if (paramBoolean)
    {
      f1 = 1.0F;
      f1 *= f2;
      paramView.animate().cancel();
      Log.i("Finder.FriendTabAffinityUI", "[revealActivity] x=" + paramInt1 + " y=" + paramInt2 + " isExit=" + paramBoolean + " finalRadius=" + f1);
      if (!paramBoolean) {
        break label239;
      }
      f2 = f1;
      if (paramBoolean) {
        f1 = 0.0F;
      }
      localAnimator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, f2, f1);
      kotlin.g.b.s.s(localAnimator, "createCircularReveal(roo…xit) 0f else finalRadius)");
      if (!paramBoolean) {
        break label245;
      }
      l = 420L;
      label169:
      localAnimator.setDuration(l);
      if (!paramBoolean) {
        break label253;
      }
    }
    label239:
    label245:
    label253:
    for (TimeInterpolator localTimeInterpolator = (TimeInterpolator)new DecelerateInterpolator();; localTimeInterpolator = (TimeInterpolator)new AccelerateInterpolator())
    {
      localAnimator.setInterpolator(localTimeInterpolator);
      localAnimator.addListener((Animator.AnimatorListener)new c(paramView, this, parama));
      localAnimator.start();
      AppMethodBeat.o(365580);
      return;
      f1 = 1.1F;
      break;
      f2 = 0.0F;
      break label131;
      l = 480L;
      break label169;
    }
  }
  
  private static final void a(OccupyFinderUI5 paramOccupyFinderUI5, View paramView)
  {
    AppMethodBeat.i(365591);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOccupyFinderUI5);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramOccupyFinderUI5, "this$0");
    paramOccupyFinderUI5.Btm = 1;
    paramOccupyFinderUI5.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365591);
  }
  
  private static final void b(OccupyFinderUI5 paramOccupyFinderUI5, View paramView)
  {
    AppMethodBeat.i(365599);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOccupyFinderUI5);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramOccupyFinderUI5, "this$0");
    paramOccupyFinderUI5 = paramOccupyFinderUI5.Btj;
    if (paramOccupyFinderUI5 != null) {
      paramOccupyFinderUI5.eEr();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365599);
  }
  
  private static final void c(OccupyFinderUI5 paramOccupyFinderUI5, View paramView)
  {
    AppMethodBeat.i(365605);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOccupyFinderUI5);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramOccupyFinderUI5, "this$0");
    paramOccupyFinderUI5 = paramOccupyFinderUI5.Btj;
    if (paramOccupyFinderUI5 != null) {
      paramOccupyFinderUI5.eEr();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365605);
  }
  
  private static final void egf()
  {
    AppMethodBeat.i(365621);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).a(1, d.c.GKF);
    AppMethodBeat.o(365621);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 1;
  }
  
  public boolean enableActivityAnimation()
  {
    AppMethodBeat.i(365804);
    if (!getIntent().hasExtra("EXTRA_CIRCULAR_REVEAL_X"))
    {
      AppMethodBeat.o(365804);
      return true;
    }
    AppMethodBeat.o(365804);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(365795);
    Log.i("Finder.FriendTabAffinityUI", "[finish] page_exit_mode=" + this.Btm + " isAutoRefreshFriendTab=" + this.Btl);
    Object localObject1 = this.Btj;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((ao)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(ao.class)).iv("page_exit_mode", String.valueOf(this.Btm));
      if ((Btp) && (this.Btl))
      {
        Log.i("Finder.FriendTabAffinityUI", "mark TAB_TYPE_MACHINE in cache time");
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(4);
        ((d.a)localObject1).GKz = System.nanoTime();
        ((d.a)localObject1).a(d.d.GKO);
      }
    }
    Btp = false;
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(as.class)).fou();
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    String str1 = ((bui)localObject1).sessionId;
    String str2 = getClass().getSimpleName();
    long l1 = System.currentTimeMillis();
    long l2 = this.enterTime;
    long l3 = this.enterTime;
    long l4 = System.currentTimeMillis();
    String str3 = ((bui)localObject1).zIB;
    String str4 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
    int i = c.b.zHb.value;
    localObject2 = ((bui)localObject1).zIO;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = getIntent().getStringExtra("key_extra_info");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, str3, str4, i, (String)localObject2, (String)localObject1, 1280));
    if (Btr != null)
    {
      localObject1 = Btr;
      if (localObject1 != null)
      {
        localObject1 = (Activity)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = (bn)com.tencent.mm.ui.component.k.nq((Context)localObject1).cq(bn.class);
          localObject3 = as.GSQ;
          ((bn)localObject2).aCO(as.a.Vs(4));
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          localObject1 = ((as)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(as.class)).fou();
          localObject2 = z.FrZ;
          switch (this.Btm)
          {
          default: 
            i = 10;
          }
        }
      }
    }
    for (;;)
    {
      z.a(1, 4, (bui)localObject1, i);
      i = e.a.anim_not_change;
      overridePendingTransition(i, i);
      if ((!getIntent().hasExtra("EXTRA_CIRCULAR_REVEAL_X")) || (!getIntent().hasExtra("EXTRA_CIRCULAR_REVEAL_Y"))) {
        break;
      }
      i = getIntent().getIntExtra("EXTRA_CIRCULAR_REVEAL_X", 0);
      int j = getIntent().getIntExtra("EXTRA_CIRCULAR_REVEAL_Y", 0);
      localObject1 = findViewById(e.e.root_container);
      kotlin.g.b.s.s(localObject1, "rootLayout");
      a((View)localObject1, i, j, true, (kotlin.g.a.a)new b((View)localObject1, this));
      AppMethodBeat.o(365795);
      return;
      i = 9;
      continue;
      i = 10;
      continue;
      i = 12;
    }
    super.finish();
    AppMethodBeat.o(365795);
  }
  
  public int getLayoutId()
  {
    return e.f.finder_friend_tab_ui;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365705);
    Set localSet = kotlin.a.ar.setOf(new Class[] { com.tencent.mm.plugin.finder.viewmodel.component.i.class, com.tencent.mm.plugin.finder.viewmodel.component.r.class, al.class, f.class, as.class, aq.class, com.tencent.mm.plugin.finder.viewmodel.component.ah.class, az.class, com.tencent.mm.plugin.finder.viewmodel.component.ar.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, ay.class, com.tencent.mm.plugin.finder.accessibility.s.class, l.a(ai.cz(ap.class)), ae.class });
    AppMethodBeat.o(365705);
    return localSet;
  }
  
  public boolean isHideStatusBar()
  {
    return true;
  }
  
  public boolean isSupportNavigationSwipeBack()
  {
    return true;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(365814);
    Object localObject1 = ((Iterable)getUiComponents()).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((UIComponent)((Iterator)localObject1).next()).onBackPressed())
      {
        AppMethodBeat.o(365814);
        return;
      }
    }
    localObject1 = getSupportFragmentManager().getFragments();
    kotlin.g.b.s.s(localObject1, "supportFragmentManager.fragments");
    Object localObject2;
    do
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (!((Iterator)localObject2).hasNext())
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Fragment)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof UIComponentFragment));
        localObject2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
      }
    } while (!((UIComponent)((Iterator)localObject2).next()).onBackPressed());
    AppMethodBeat.o(365814);
    return;
    this.Btm = 3;
    finish();
    AppMethodBeat.o(365814);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365729);
    super.onCreate(paramBundle);
    Object localObject1 = getWindow().getDecorView();
    kotlin.g.b.s.s(localObject1, "this.window.decorView");
    ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
    getWindow().setStatusBarColor(0);
    c.h((Activity)this, false);
    localObject1 = getSupportActionBar();
    if (localObject1 != null)
    {
      ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
      ((ActionBar)localObject1).hide();
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    localObject1 = getWindow();
    kotlin.g.b.s.s(localObject1, "window");
    com.tencent.mm.plugin.finder.utils.av.d((Window)localObject1);
    setNavigationbarColor(getResources().getColor(e.b.black));
    final int i = bf.getStatusBarHeight((Context)this);
    localObject1 = findViewById(e.e.root_container);
    if (localObject1 != null) {
      ((View)localObject1).setPadding(0, i, 0, 0);
    }
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    if (!kotlin.g.b.s.p(getIntent().getStringExtra("ENTER_SOURCE"), "bubble"))
    {
      overridePendingTransition(e.a.slide_right_in, e.a.slide_left_out);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("TLRecommendTab");
    }
    for (;;)
    {
      this.enterTime = System.currentTimeMillis();
      float f = getResources().getDimension(e.c.Edge_2A);
      ((RoundedCornerFrameLayout)findViewById(e.e.corner_layout)).A(f, f, 0.0F, 0.0F);
      paramBundle = (TextView)findViewById(e.e.tabTitle);
      i = com.tencent.mm.view.d.e((Context)getContext(), 18.0F);
      kotlin.g.b.s.s(paramBundle, "it");
      com.tencent.mm.plugin.finder.utils.i.setTextBold(paramBundle);
      Object localObject2 = getContext().getResources().getString(e.h.finder_friend_tab_bubble_title_2, new Object[] { "@" });
      kotlin.g.b.s.s(localObject2, "context.resources.getStr…_tab_bubble_title_2, \"@\")");
      localObject1 = new SpannableString((CharSequence)localObject2);
      final int j = n.a((CharSequence)localObject2, "@", 0, false, 6);
      int k = getContext().getResources().getColor(e.b.White);
      localObject2 = bb.m((Context)getContext(), e.g.icons_filled_little_like, k);
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      kotlin.ah localah = kotlin.ah.aiuX;
      ((SpannableString)localObject1).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1), j, j + 1, 33);
      localObject2 = kotlin.ah.aiuX;
      paramBundle.setText((CharSequence)localObject1);
      this.Btj = new FinderFriendTabFragment();
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      this.Btl = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).Rp(1);
      if (getIntent().getBooleanExtra("IsFirstEnterTab", false))
      {
        paramBundle = this.Btj;
        if (paramBundle != null)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("IsFirstEnterTab", true);
          localObject2 = kotlin.ah.aiuX;
          paramBundle.EHy = ((Bundle)localObject1);
        }
      }
      paramBundle = getSupportFragmentManager().beginTransaction();
      kotlin.g.b.s.s(paramBundle, "supportFragmentManager.beginTransaction()");
      i = e.e.fragment_container;
      localObject1 = this.Btj;
      kotlin.g.b.s.checkNotNull(localObject1);
      paramBundle.b(i, (Fragment)localObject1);
      paramBundle.FW();
      findViewById(e.e.close_layout).setOnClickListener(new OccupyFinderUI5..ExternalSyntheticLambda1(this));
      findViewById(e.e.title_layout).setOnClickListener(new OccupyFinderUI5..ExternalSyntheticLambda0(this));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(as.class)).fou();
      localObject1 = z.FrZ;
      z.a(4, 1, paramBundle, 11);
      findViewById(e.e.title_layout).setOnClickListener(new OccupyFinderUI5..ExternalSyntheticLambda2(this));
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgB);
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
      ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new OccupyFinderUI5..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(365729);
      return;
      localObject1 = findViewById(e.e.root_container);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.root_container)");
      if ((paramBundle == null) && (getIntent().hasExtra("EXTRA_CIRCULAR_REVEAL_X")) && (getIntent().hasExtra("EXTRA_CIRCULAR_REVEAL_Y")))
      {
        ((View)localObject1).setVisibility(4);
        i = getIntent().getIntExtra("EXTRA_CIRCULAR_REVEAL_X", 0);
        j = getIntent().getIntExtra("EXTRA_CIRCULAR_REVEAL_Y", 0);
        paramBundle = ((View)localObject1).getViewTreeObserver();
        if (paramBundle.isAlive()) {
          paramBundle.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this, (View)localObject1, i, j));
        }
      }
      else
      {
        ((View)localObject1).setVisibility(0);
      }
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(365778);
    super.onCreateBeforeSetContentView();
    setTheme(e.i.MMTheme_Holo_FinderDarkTransparent);
    AppMethodBeat.o(365778);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(365798);
    super.onDestroy();
    if (!this.Btk) {
      com.tencent.threadpool.h.ahAA.bk(OccupyFinderUI5..ExternalSyntheticLambda4.INSTANCE);
    }
    AppMethodBeat.o(365798);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(365741);
    if (this.Btj != null)
    {
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(as.class)).fou();
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      String str2 = ((bui)localObject1).sessionId;
      String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.ara("FinderFriendTabFragment");
      long l1 = System.currentTimeMillis();
      long l2 = this.Bti;
      long l3 = this.Bti;
      long l4 = System.currentTimeMillis();
      String str4 = ((bui)localObject1).zIB;
      String str5 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      int i = c.b.zHb.value;
      localObject2 = ((bui)localObject1).zIO;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str1 = getIntent().getStringExtra("key_extra_info");
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str2, str3, l1 - l2, l3, l4, str4, str5, i, (String)localObject2, (String)localObject1, 1280));
    }
    super.onPause();
    AppMethodBeat.o(365741);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(365735);
    super.onResume();
    this.Bti = System.currentTimeMillis();
    AppMethodBeat.o(365735);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(365760);
    super.onStop();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = (com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    FinderFriendTabFragment localFinderFriendTabFragment = this.Btj;
    if (localFinderFriendTabFragment == null) {}
    for (int i = 0;; i = localFinderFriendTabFragment.hJx)
    {
      ((com.tencent.mm.plugin.finder.viewmodel.d)localObject).UT(i);
      AppMethodBeat.o(365760);
      return;
    }
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(365748);
    this.Btm = 2;
    super.onSwipeBack();
    AppMethodBeat.o(365748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(365754);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.Btn))
    {
      FinderFriendTabFragment localFinderFriendTabFragment = this.Btj;
      if (localFinderFriendTabFragment != null) {
        localFinderFriendTabFragment.onUserVisibleFocused();
      }
      this.Btn = true;
    }
    AppMethodBeat.o(365754);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5$Companion;", "", "()V", "ENTER_SOURCE", "", "EXTRA_BUBBLE_EXT", "EXTRA_CIRCULAR_REVEAL_X", "EXTRA_CIRCULAR_REVEAL_Y", "TAG", "finderHomeUIRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getFinderHomeUIRef", "()Ljava/lang/ref/WeakReference;", "setFinderHomeUIRef", "(Ljava/lang/ref/WeakReference;)V", "foldedFeedItemId", "", "getFoldedFeedItemId", "()J", "setFoldedFeedItemId", "(J)V", "isEnterHomeToJumpFriendTab", "", "()Z", "setEnterHomeToJumpFriendTab", "(Z)V", "presentActivity", "", "activity", "view", "Landroid/view/View;", "source", "i", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(View paramView, OccupyFinderUI5 paramOccupyFinderUI5)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5$revealActivity$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(View paramView, OccupyFinderUI5 paramOccupyFinderUI5, kotlin.g.a.a<kotlin.ah> parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(364530);
      parama.invoke();
      OccupyFinderUI5.a(jdField_this, false);
      AppMethodBeat.o(364530);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(364521);
      this.Bts.setVisibility(0);
      OccupyFinderUI5.a(jdField_this, true);
      com.tencent.mm.ui.base.b.a((Activity)jdField_this.getContext(), null);
      AppMethodBeat.o(364521);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI5$runEnterAnim$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(OccupyFinderUI5 paramOccupyFinderUI5, View paramView, int paramInt1, int paramInt2) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(364513);
      OccupyFinderUI5.a(this.Btt, this.Bts, i, j, (kotlin.g.a.a)a.Btw);
      this.Bts.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(364513);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      public static final a Btw;
      
      static
      {
        AppMethodBeat.i(365655);
        Btw = new a();
        AppMethodBeat.o(365655);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5
 * JD-Core Version:    0.7.0.1
 */