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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "bulletSubtitleLayout", "Landroid/widget/FrameLayout;", "bulletSubtitleRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBulletSubtitleRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setBulletSubtitleRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exitAnimator", "isEnterAnimRunning", "", "isFunctionTurnOn", "isPause", "()Z", "setPause", "(Z)V", "isStartLoop", "setStartLoop", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "needToRefresh", "restartRunnable", "Ljava/lang/Runnable;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "checkAllAnimPause", "checkAllAnimResume", "getFunctionSwitch", "initView", "", "pause", "reset", "prepareForRestart", "resume", "showBulletSubtitleLayout", "isShow", "smoothScrollToLastPosition", "startLoop", "switchFunction", "isTurnOn", "needRefresh", "plugin-finder_release"})
public final class d
{
  boolean dtm;
  final View gZw;
  public WxRecyclerAdapter<?> rPu;
  private final c rUA;
  private final f rUo;
  private final f rUp;
  public WxRecyclerView rUq;
  FrameLayout rUr;
  private FinderAutoScrollLayoutManager rUs;
  ValueAnimator rUt;
  ValueAnimator rUu;
  Runnable rUv;
  public boolean rUw;
  private boolean rUx;
  private boolean rUy;
  boolean rUz;
  
  public d(View paramView, c paramc)
  {
    AppMethodBeat.i(201737);
    this.gZw = paramView;
    this.rUA = paramc;
    this.rUo = d.g.O((d.g.a.a)new a(this));
    this.rUp = d.g.O((d.g.a.a)new g(this));
    this.rUx = true;
    AppMethodBeat.o(201737);
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(201728);
    int i = ((Number)this.rUp.getValue()).intValue();
    AppMethodBeat.o(201728);
    return i;
  }
  
  private final void lO(boolean paramBoolean)
  {
    AppMethodBeat.i(201736);
    if (paramBoolean)
    {
      localFrameLayout = this.rUr;
      if (localFrameLayout == null) {
        p.bcb("bulletSubtitleLayout");
      }
      localFrameLayout.animate().cancel();
      localFrameLayout = this.rUr;
      if (localFrameLayout == null) {
        p.bcb("bulletSubtitleLayout");
      }
      localFrameLayout.setAlpha(0.0F);
      localFrameLayout = this.rUr;
      if (localFrameLayout == null) {
        p.bcb("bulletSubtitleLayout");
      }
      localFrameLayout.animate().alpha(1.0F).setDuration(300L).withStartAction((Runnable)new h(this)).start();
      AppMethodBeat.o(201736);
      return;
    }
    FrameLayout localFrameLayout = this.rUr;
    if (localFrameLayout == null) {
      p.bcb("bulletSubtitleLayout");
    }
    localFrameLayout.animate().cancel();
    localFrameLayout = this.rUr;
    if (localFrameLayout == null) {
      p.bcb("bulletSubtitleLayout");
    }
    localFrameLayout.setAlpha(1.0F);
    localFrameLayout = this.rUr;
    if (localFrameLayout == null) {
      p.bcb("bulletSubtitleLayout");
    }
    localFrameLayout.setVisibility(8);
    AppMethodBeat.o(201736);
  }
  
  public final void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201731);
    this.rUx = paramBoolean1;
    label42:
    Object localObject;
    com.tencent.mm.plugin.finder.report.a locala;
    label77:
    long l;
    int j;
    if (this.rUx)
    {
      lO(true);
      if ((!this.rUx) || (!paramBoolean2)) {
        break label146;
      }
      this.rUy = true;
      cAX();
      if (!paramBoolean2) {
        break label209;
      }
      localObject = this.rUA.rUg;
      if (localObject == null) {
        break label209;
      }
      if (!paramBoolean1) {
        break label154;
      }
      locala = com.tencent.mm.plugin.finder.report.a.smX;
      com.tencent.mm.plugin.finder.report.a.wo(((FinderItem)localObject).getId());
      locala = com.tencent.mm.plugin.finder.report.a.smX;
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
      localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = getContext();
      if (localObject != null) {
        break label175;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201731);
      throw ((Throwable)localObject);
      lO(false);
      break;
      reset(false);
      break label42;
      locala = com.tencent.mm.plugin.finder.report.a.smX;
      com.tencent.mm.plugin.finder.report.a.wn(((FinderItem)localObject).getId());
      break label77;
    }
    label175:
    com.tencent.mm.plugin.finder.report.a.a(l, j, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject).get(FinderReporterUIC.class)).cOu());
    AppMethodBeat.o(201731);
    return;
    label209:
    AppMethodBeat.o(201731);
  }
  
  public final WxRecyclerView cAW()
  {
    AppMethodBeat.i(201729);
    WxRecyclerView localWxRecyclerView = this.rUq;
    if (localWxRecyclerView == null) {
      p.bcb("bulletSubtitleRv");
    }
    AppMethodBeat.o(201729);
    return localWxRecyclerView;
  }
  
  public final void cAX()
  {
    int i = 1;
    AppMethodBeat.i(201733);
    Object localObject1 = this.rUA.rUg;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.a.smX;
      com.tencent.mm.plugin.finder.report.a.start(((FinderItem)localObject1).getId());
    }
    if (!this.rUw)
    {
      localObject1 = this.rUq;
      if (localObject1 == null) {
        p.bcb("bulletSubtitleRv");
      }
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 == null) {
        p.gfZ();
      }
      p.g(localObject1, "bulletSubtitleRv.adapter!!");
      if (((RecyclerView.a)localObject1).getItemCount() > 0) {}
    }
    else
    {
      AppMethodBeat.o(201733);
      return;
    }
    localObject1 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject1, "MMKernel.storage()");
    long l;
    if (!((e)localObject1).ajl().getBoolean(al.a.IIP, true))
    {
      this.rUx = false;
      localObject1 = this.rUA.rUg;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.a.smX;
        l = ((FinderItem)localObject1).getId();
        if (this.rUx) {}
        for (;;)
        {
          com.tencent.mm.plugin.finder.report.a.H(l, i);
          AppMethodBeat.o(201733);
          return;
          i = 0;
        }
      }
      AppMethodBeat.o(201733);
      return;
    }
    this.rUx = true;
    localObject1 = this.rPu;
    if (localObject1 == null) {
      p.bcb("adapter");
    }
    ((WxRecyclerAdapter)localObject1).notifyDataSetChanged();
    Object localObject2 = this.rUA.rUg;
    if (localObject2 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.a.smX;
      com.tencent.mm.plugin.finder.report.a.wm(((FinderItem)localObject2).getId());
      localObject1 = com.tencent.mm.plugin.finder.report.a.smX;
      l = ((FinderItem)localObject2).getId();
      localObject1 = this.rPu;
      if (localObject1 == null) {
        p.bcb("adapter");
      }
      if (localObject1 == null) {
        break label416;
      }
      localObject1 = Integer.valueOf(((WxRecyclerAdapter)localObject1).getItemCount());
      com.tencent.mm.plugin.finder.report.a.G(l, ((Integer)localObject1).intValue());
      localObject1 = com.tencent.mm.plugin.finder.report.a.smX;
      l = ((FinderItem)localObject2).getId();
      if (!this.rUx) {
        break label422;
      }
    }
    label416:
    label422:
    for (i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.a.H(l, i);
      localObject1 = this.rUq;
      if (localObject1 == null) {
        p.bcb("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setTranslationX(getScreenWidth());
      localObject1 = this.rUq;
      if (localObject1 == null) {
        p.bcb("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(0);
      lO(true);
      localObject1 = this.rUt;
      if (localObject1 == null) {
        p.bcb("enterAnimator");
      }
      ((ValueAnimator)localObject1).start();
      this.rUz = true;
      this.rUw = true;
      this.dtm = false;
      AppMethodBeat.o(201733);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void cAY()
  {
    AppMethodBeat.i(201735);
    if ((this.dtm) || (!this.rUw) || (this.rUz))
    {
      AppMethodBeat.o(201735);
      return;
    }
    Object localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    if (!((WxRecyclerView)localObject1).canScrollHorizontally(1))
    {
      localObject1 = this.rUu;
      if (localObject1 == null) {
        p.bcb("exitAnimator");
      }
      ((ValueAnimator)localObject1).start();
      AppMethodBeat.o(201735);
      return;
    }
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    Object localObject2 = this.rUq;
    if (localObject2 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject2 = ((WxRecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.gfZ();
    }
    p.g(localObject2, "bulletSubtitleRv.adapter!!");
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(((RecyclerView.a)localObject2).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(201735);
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(201727);
    Context localContext = (Context)this.rUo.getValue();
    AppMethodBeat.o(201727);
    return localContext;
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(201732);
    e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    this.rUx = locale.ajl().getBoolean(al.a.IIP, true);
    boolean bool = this.rUx;
    AppMethodBeat.o(201732);
    return bool;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201730);
    Object localObject1 = this.gZw.findViewById(2131308190);
    p.g(localObject1, "parent.findViewById<WxRe…(R.id.rv_bullet_subtitle)");
    this.rUq = ((WxRecyclerView)localObject1);
    localObject1 = this.gZw.findViewById(2131300066);
    p.g(localObject1, "parent.findViewById<Fram…d.bullet_subtitle_layout)");
    this.rUr = ((FrameLayout)localObject1);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).setOnTouchListener((View.OnTouchListener)d.b.rUC);
    localObject1 = this.rUA;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    this.rPu = ((c)localObject1).eM((Context)localObject2);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject2 = this.rPu;
    if (localObject2 == null) {
      p.bcb("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = new FinderAutoScrollLayoutManager((Context)localObject2);
    ((FinderAutoScrollLayoutManager)localObject2).setOrientation(0);
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)localObject2);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager");
      AppMethodBeat.o(201730);
      throw ((Throwable)localObject1);
    }
    this.rUs = ((FinderAutoScrollLayoutManager)localObject1);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject2 = com.tencent.mm.ui.component.a.KiD;
    localObject2 = getContext();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201730);
      throw ((Throwable)localObject1);
    }
    ((WxRecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.s((MMActivity)localObject2).get(FinderRecyclerViewPool.class)).sZH);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject1 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { getScreenWidth(), 0.0F });
    p.g(localObject1, "ObjectAnimator.ofFloat(b…creenWidth.toFloat(), 0f)");
    this.rUt = ((ValueAnimator)localObject1);
    localObject1 = new LinearInterpolator();
    localObject2 = this.rUt;
    if (localObject2 == null) {
      p.bcb("enterAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    this.rUv = ((Runnable)new c(this));
    localObject2 = this.rUt;
    if (localObject2 == null) {
      p.bcb("enterAnimator");
    }
    ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new d(this));
    localObject2 = this.rUt;
    if (localObject2 == null) {
      p.bcb("enterAnimator");
    }
    ((ValueAnimator)localObject2).setDuration(4000L);
    localObject2 = this.rUq;
    if (localObject2 == null) {
      p.bcb("bulletSubtitleRv");
    }
    localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { 0.0F, -getScreenWidth() });
    p.g(localObject2, "ObjectAnimator.ofFloat(b…, -screenWidth.toFloat())");
    this.rUu = ((ValueAnimator)localObject2);
    localObject2 = this.rUu;
    if (localObject2 == null) {
      p.bcb("exitAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    localObject1 = this.rUu;
    if (localObject1 == null) {
      p.bcb("exitAnimator");
    }
    ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new e(this));
    localObject1 = this.rUu;
    if (localObject1 == null) {
      p.bcb("exitAnimator");
    }
    ((ValueAnimator)localObject1).setDuration(4000L);
    localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).a((RecyclerView.m)new f(this));
    localObject1 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject1, "MMKernel.storage()");
    this.rUx = ((e)localObject1).ajl().getBoolean(al.a.IIP, true);
    AppMethodBeat.o(201730);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(201734);
    this.rUw = false;
    this.dtm = false;
    this.rUA.cAV();
    Object localObject1 = this.rUq;
    if (localObject1 == null) {
      p.bcb("bulletSubtitleRv");
    }
    Object localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    if (!paramBoolean)
    {
      lO(false);
      localObject1 = this.rUq;
      if (localObject1 == null) {
        p.bcb("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(8);
      localObject1 = this.rUq;
      if (localObject1 == null) {
        p.bcb("bulletSubtitleRv");
      }
      localObject2 = this.rUv;
      if (localObject2 == null) {
        p.bcb("restartRunnable");
      }
      ((WxRecyclerView)localObject1).removeCallbacks((Runnable)localObject2);
    }
    this.rUz = false;
    localObject1 = this.rUt;
    if (localObject1 == null) {
      p.bcb("enterAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    localObject1 = this.rUu;
    if (localObject1 == null) {
      p.bcb("exitAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    AppMethodBeat.o(201734);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<Context>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(201720);
      Object localObject;
      int i;
      if (this.rUB.cAW().getVisibility() == 0)
      {
        this.rUB.cAX();
        if (this.rUB.dtm)
        {
          localObject = this.rUB;
          ((d)localObject).dtm = true;
          if (((d)localObject).rUw)
          {
            i = 0;
            ValueAnimator localValueAnimator = ((d)localObject).rUt;
            if (localValueAnimator == null) {
              p.bcb("enterAnimator");
            }
            if (localValueAnimator.isRunning())
            {
              localValueAnimator = ((d)localObject).rUt;
              if (localValueAnimator == null) {
                p.bcb("enterAnimator");
              }
              localValueAnimator.pause();
              i = 1;
            }
            localValueAnimator = ((d)localObject).rUu;
            if (localValueAnimator == null) {
              p.bcb("exitAnimator");
            }
            if (!localValueAnimator.isRunning()) {
              break label178;
            }
            localValueAnimator = ((d)localObject).rUu;
            if (localValueAnimator == null) {
              p.bcb("exitAnimator");
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
          localObject = ((d)localObject).rUq;
          if (localObject == null) {
            p.bcb("bulletSubtitleRv");
          }
          ((WxRecyclerView)localObject).kJ();
        }
        AppMethodBeat.o(201720);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(201721);
      this.rUB.rUz = false;
      if (this.rUB.cAW().getVisibility() != 0)
      {
        AppMethodBeat.o(201721);
        return;
      }
      this.rUB.cAY();
      AppMethodBeat.o(201721);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(201722);
      this.rUB.reset(true);
      paramAnimator = this.rUB.cAW();
      Runnable localRunnable = this.rUB.rUv;
      if (localRunnable == null) {
        p.bcb("restartRunnable");
      }
      paramAnimator.postDelayed(localRunnable, 5000L);
      AppMethodBeat.o(201722);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201724);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(201724);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201723);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      if (paramInt == 0)
      {
        if ((paramRecyclerView.getVisibility() == 8) || (!this.rUB.rUw) || (this.rUB.dtm))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(201723);
          return;
        }
        this.rUB.cAY();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201723);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Integer>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(201726);
      FrameLayout localFrameLayout = this.rUB.rUr;
      if (localFrameLayout == null) {
        p.bcb("bulletSubtitleLayout");
      }
      localFrameLayout.setVisibility(0);
      AppMethodBeat.o(201726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d
 * JD-Core Version:    0.7.0.1
 */