package com.tencent.mm.plugin.finder.feed;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "bulletSubtitleLayout", "Landroid/widget/FrameLayout;", "bulletSubtitleRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBulletSubtitleRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setBulletSubtitleRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exitAnimator", "isEnterAnimRunning", "", "isFunctionTurnOn", "isPause", "()Z", "setPause", "(Z)V", "isStartLoop", "setStartLoop", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "needToRefresh", "restartRunnable", "Ljava/lang/Runnable;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "checkAllAnimPause", "checkAllAnimResume", "getFunctionSwitch", "initView", "", "pause", "reset", "prepareForRestart", "resume", "showBulletSubtitleLayout", "isShow", "smoothScrollToLastPosition", "startLoop", "switchFunction", "isTurnOn", "needRefresh", "plugin-finder_release"})
public final class d
{
  boolean dus;
  final View hcj;
  public WxRecyclerAdapter<?> rXV;
  private final f scS;
  private final f scT;
  public WxRecyclerView scU;
  FrameLayout scV;
  private FinderAutoScrollLayoutManager scW;
  ValueAnimator scX;
  ValueAnimator scY;
  Runnable scZ;
  public boolean sda;
  private boolean sdb;
  private boolean sdc;
  boolean sdd;
  private final c sde;
  
  public d(View paramView, c paramc)
  {
    AppMethodBeat.i(202196);
    this.hcj = paramView;
    this.sde = paramc;
    this.scS = d.g.O((d.g.a.a)new a(this));
    this.scT = d.g.O((d.g.a.a)new g(this));
    this.sdb = true;
    AppMethodBeat.o(202196);
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(202187);
    int i = ((Number)this.scT.getValue()).intValue();
    AppMethodBeat.o(202187);
    return i;
  }
  
  private final void lO(boolean paramBoolean)
  {
    AppMethodBeat.i(202195);
    if (paramBoolean)
    {
      localFrameLayout = this.scV;
      if (localFrameLayout == null) {
        p.bdF("bulletSubtitleLayout");
      }
      localFrameLayout.animate().cancel();
      localFrameLayout = this.scV;
      if (localFrameLayout == null) {
        p.bdF("bulletSubtitleLayout");
      }
      localFrameLayout.setAlpha(0.0F);
      localFrameLayout = this.scV;
      if (localFrameLayout == null) {
        p.bdF("bulletSubtitleLayout");
      }
      localFrameLayout.animate().alpha(1.0F).setDuration(300L).withStartAction((Runnable)new h(this)).start();
      AppMethodBeat.o(202195);
      return;
    }
    FrameLayout localFrameLayout = this.scV;
    if (localFrameLayout == null) {
      p.bdF("bulletSubtitleLayout");
    }
    localFrameLayout.animate().cancel();
    localFrameLayout = this.scV;
    if (localFrameLayout == null) {
      p.bdF("bulletSubtitleLayout");
    }
    localFrameLayout.setAlpha(1.0F);
    localFrameLayout = this.scV;
    if (localFrameLayout == null) {
      p.bdF("bulletSubtitleLayout");
    }
    localFrameLayout.setVisibility(8);
    AppMethodBeat.o(202195);
  }
  
  public final void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(202190);
    this.sdb = paramBoolean1;
    label42:
    Object localObject;
    com.tencent.mm.plugin.finder.report.a locala;
    label77:
    long l;
    int j;
    if (this.sdb)
    {
      lO(true);
      if ((!this.sdb) || (!paramBoolean2)) {
        break label146;
      }
      this.sdc = true;
      cCJ();
      if (!paramBoolean2) {
        break label209;
      }
      localObject = this.sde.scK;
      if (localObject == null) {
        break label209;
      }
      if (!paramBoolean1) {
        break label154;
      }
      locala = com.tencent.mm.plugin.finder.report.a.swO;
      com.tencent.mm.plugin.finder.report.a.wE(((FinderItem)localObject).getId());
      locala = com.tencent.mm.plugin.finder.report.a.swO;
      l = ((FinderItem)localObject).getId();
      j = ((FinderItem)localObject).getMediaType();
      if (!paramBoolean1) {
        break label170;
      }
    }
    label146:
    label154:
    label170:
    for (int i = 1;; i = 2)
    {
      localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = getContext();
      if (localObject != null) {
        break label175;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(202190);
      throw ((Throwable)localObject);
      lO(false);
      break;
      reset(false);
      break label42;
      locala = com.tencent.mm.plugin.finder.report.a.swO;
      com.tencent.mm.plugin.finder.report.a.wD(((FinderItem)localObject).getId());
      break label77;
    }
    label175:
    com.tencent.mm.plugin.finder.report.a.a(l, j, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject).get(FinderReporterUIC.class)).cQZ());
    AppMethodBeat.o(202190);
    return;
    label209:
    AppMethodBeat.o(202190);
  }
  
  public final WxRecyclerView cCI()
  {
    AppMethodBeat.i(202188);
    WxRecyclerView localWxRecyclerView = this.scU;
    if (localWxRecyclerView == null) {
      p.bdF("bulletSubtitleRv");
    }
    AppMethodBeat.o(202188);
    return localWxRecyclerView;
  }
  
  public final void cCJ()
  {
    int i = 1;
    AppMethodBeat.i(202192);
    Object localObject1 = this.sde.scK;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.a.swO;
      com.tencent.mm.plugin.finder.report.a.start(((FinderItem)localObject1).getId());
    }
    if (!this.sda)
    {
      localObject1 = this.scU;
      if (localObject1 == null) {
        p.bdF("bulletSubtitleRv");
      }
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 == null) {
        p.gkB();
      }
      p.g(localObject1, "bulletSubtitleRv.adapter!!");
      if (((RecyclerView.a)localObject1).getItemCount() > 0) {}
    }
    else
    {
      AppMethodBeat.o(202192);
      return;
    }
    localObject1 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    long l;
    if (!((e)localObject1).ajA().getBoolean(am.a.Jdu, true))
    {
      this.sdb = false;
      localObject1 = this.sde.scK;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.a.swO;
        l = ((FinderItem)localObject1).getId();
        if (this.sdb) {}
        for (;;)
        {
          com.tencent.mm.plugin.finder.report.a.H(l, i);
          AppMethodBeat.o(202192);
          return;
          i = 0;
        }
      }
      AppMethodBeat.o(202192);
      return;
    }
    this.sdb = true;
    localObject1 = this.rXV;
    if (localObject1 == null) {
      p.bdF("adapter");
    }
    ((WxRecyclerAdapter)localObject1).notifyDataSetChanged();
    Object localObject2 = this.sde.scK;
    if (localObject2 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.a.swO;
      com.tencent.mm.plugin.finder.report.a.wC(((FinderItem)localObject2).getId());
      localObject1 = com.tencent.mm.plugin.finder.report.a.swO;
      l = ((FinderItem)localObject2).getId();
      localObject1 = this.rXV;
      if (localObject1 == null) {
        p.bdF("adapter");
      }
      if (localObject1 == null) {
        break label416;
      }
      localObject1 = Integer.valueOf(((WxRecyclerAdapter)localObject1).getItemCount());
      com.tencent.mm.plugin.finder.report.a.G(l, ((Integer)localObject1).intValue());
      localObject1 = com.tencent.mm.plugin.finder.report.a.swO;
      l = ((FinderItem)localObject2).getId();
      if (!this.sdb) {
        break label422;
      }
    }
    label416:
    label422:
    for (i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.a.H(l, i);
      localObject1 = this.scU;
      if (localObject1 == null) {
        p.bdF("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setTranslationX(getScreenWidth());
      localObject1 = this.scU;
      if (localObject1 == null) {
        p.bdF("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(0);
      lO(true);
      localObject1 = this.scX;
      if (localObject1 == null) {
        p.bdF("enterAnimator");
      }
      ((ValueAnimator)localObject1).start();
      this.sdd = true;
      this.sda = true;
      this.dus = false;
      AppMethodBeat.o(202192);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void cCK()
  {
    AppMethodBeat.i(202194);
    if ((this.dus) || (!this.sda) || (this.sdd))
    {
      AppMethodBeat.o(202194);
      return;
    }
    Object localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    if (!((WxRecyclerView)localObject1).canScrollHorizontally(1))
    {
      localObject1 = this.scY;
      if (localObject1 == null) {
        p.bdF("exitAnimator");
      }
      ((ValueAnimator)localObject1).start();
      AppMethodBeat.o(202194);
      return;
    }
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    Object localObject2 = this.scU;
    if (localObject2 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject2 = ((WxRecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.gkB();
    }
    p.g(localObject2, "bulletSubtitleRv.adapter!!");
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(((RecyclerView.a)localObject2).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(202194);
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(202186);
    Context localContext = (Context)this.scS.getValue();
    AppMethodBeat.o(202186);
    return localContext;
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(202191);
    e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    this.sdb = locale.ajA().getBoolean(am.a.Jdu, true);
    boolean bool = this.sdb;
    AppMethodBeat.o(202191);
    return bool;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202189);
    Object localObject1 = this.hcj.findViewById(2131308190);
    p.g(localObject1, "parent.findViewById<WxRe…(R.id.rv_bullet_subtitle)");
    this.scU = ((WxRecyclerView)localObject1);
    localObject1 = this.hcj.findViewById(2131300066);
    p.g(localObject1, "parent.findViewById<Fram…d.bullet_subtitle_layout)");
    this.scV = ((FrameLayout)localObject1);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).setOnTouchListener((View.OnTouchListener)d.b.sdg);
    localObject1 = this.sde;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    this.rXV = ((c)localObject1).eQ((Context)localObject2);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject2 = this.rXV;
    if (localObject2 == null) {
      p.bdF("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = new FinderAutoScrollLayoutManager((Context)localObject2);
    ((FinderAutoScrollLayoutManager)localObject2).setOrientation(0);
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)localObject2);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager");
      AppMethodBeat.o(202189);
      throw ((Throwable)localObject1);
    }
    this.scW = ((FinderAutoScrollLayoutManager)localObject1);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject2 = com.tencent.mm.ui.component.a.KEX;
    localObject2 = getContext();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(202189);
      throw ((Throwable)localObject1);
    }
    ((WxRecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s((MMActivity)localObject2).get(FinderRecyclerViewPool.class)).tkV);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject1 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { getScreenWidth(), 0.0F });
    p.g(localObject1, "ObjectAnimator.ofFloat(b…creenWidth.toFloat(), 0f)");
    this.scX = ((ValueAnimator)localObject1);
    localObject1 = new LinearInterpolator();
    localObject2 = this.scX;
    if (localObject2 == null) {
      p.bdF("enterAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    this.scZ = ((Runnable)new c(this));
    localObject2 = this.scX;
    if (localObject2 == null) {
      p.bdF("enterAnimator");
    }
    ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new d(this));
    localObject2 = this.scX;
    if (localObject2 == null) {
      p.bdF("enterAnimator");
    }
    ((ValueAnimator)localObject2).setDuration(4000L);
    localObject2 = this.scU;
    if (localObject2 == null) {
      p.bdF("bulletSubtitleRv");
    }
    localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { 0.0F, -getScreenWidth() });
    p.g(localObject2, "ObjectAnimator.ofFloat(b…, -screenWidth.toFloat())");
    this.scY = ((ValueAnimator)localObject2);
    localObject2 = this.scY;
    if (localObject2 == null) {
      p.bdF("exitAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    localObject1 = this.scY;
    if (localObject1 == null) {
      p.bdF("exitAnimator");
    }
    ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new e(this));
    localObject1 = this.scY;
    if (localObject1 == null) {
      p.bdF("exitAnimator");
    }
    ((ValueAnimator)localObject1).setDuration(4000L);
    localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).a((RecyclerView.m)new f(this));
    localObject1 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    this.sdb = ((e)localObject1).ajA().getBoolean(am.a.Jdu, true);
    AppMethodBeat.o(202189);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(202193);
    this.sda = false;
    this.dus = false;
    this.sde.cCH();
    Object localObject1 = this.scU;
    if (localObject1 == null) {
      p.bdF("bulletSubtitleRv");
    }
    Object localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    if (!paramBoolean)
    {
      lO(false);
      localObject1 = this.scU;
      if (localObject1 == null) {
        p.bdF("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(8);
      localObject1 = this.scU;
      if (localObject1 == null) {
        p.bdF("bulletSubtitleRv");
      }
      localObject2 = this.scZ;
      if (localObject2 == null) {
        p.bdF("restartRunnable");
      }
      ((WxRecyclerView)localObject1).removeCallbacks((Runnable)localObject2);
    }
    this.sdd = false;
    localObject1 = this.scX;
    if (localObject1 == null) {
      p.bdF("enterAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    localObject1 = this.scY;
    if (localObject1 == null) {
      p.bdF("exitAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    AppMethodBeat.o(202193);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Context>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(202179);
      Object localObject;
      int i;
      if (this.sdf.cCI().getVisibility() == 0)
      {
        this.sdf.cCJ();
        if (this.sdf.dus)
        {
          localObject = this.sdf;
          ((d)localObject).dus = true;
          if (((d)localObject).sda)
          {
            i = 0;
            ValueAnimator localValueAnimator = ((d)localObject).scX;
            if (localValueAnimator == null) {
              p.bdF("enterAnimator");
            }
            if (localValueAnimator.isRunning())
            {
              localValueAnimator = ((d)localObject).scX;
              if (localValueAnimator == null) {
                p.bdF("enterAnimator");
              }
              localValueAnimator.pause();
              i = 1;
            }
            localValueAnimator = ((d)localObject).scY;
            if (localValueAnimator == null) {
              p.bdF("exitAnimator");
            }
            if (!localValueAnimator.isRunning()) {
              break label178;
            }
            localValueAnimator = ((d)localObject).scY;
            if (localValueAnimator == null) {
              p.bdF("exitAnimator");
            }
            localValueAnimator.pause();
            i = j;
          }
        }
      }
      label178:
      for (;;)
      {
        if (i == 0)
        {
          localObject = ((d)localObject).scU;
          if (localObject == null) {
            p.bdF("bulletSubtitleRv");
          }
          ((WxRecyclerView)localObject).kJ();
        }
        AppMethodBeat.o(202179);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(202180);
      this.sdf.sdd = false;
      if (this.sdf.cCI().getVisibility() != 0)
      {
        AppMethodBeat.o(202180);
        return;
      }
      this.sdf.cCK();
      AppMethodBeat.o(202180);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(202181);
      this.sdf.reset(true);
      paramAnimator = this.sdf.cCI();
      Runnable localRunnable = this.sdf.scZ;
      if (localRunnable == null) {
        p.bdF("restartRunnable");
      }
      paramAnimator.postDelayed(localRunnable, 5000L);
      AppMethodBeat.o(202181);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202183);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202183);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202182);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      if (paramInt == 0)
      {
        if ((paramRecyclerView.getVisibility() == 8) || (!this.sdf.sda) || (this.sdf.dus))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(202182);
          return;
        }
        this.sdf.cCK();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202182);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Integer>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(202185);
      FrameLayout localFrameLayout = this.sdf.scV;
      if (localFrameLayout == null) {
        p.bdF("bulletSubtitleLayout");
      }
      localFrameLayout.setVisibility(0);
      AppMethodBeat.o(202185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d
 * JD-Core Version:    0.7.0.1
 */