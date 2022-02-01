package com.tencent.mm.plugin.finder.feed;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "bulletSubtitleLayout", "Landroid/widget/FrameLayout;", "bulletSubtitleRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBulletSubtitleRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setBulletSubtitleRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exitAnimator", "isEnterAnimRunning", "", "isFunctionTurnOn", "isPause", "()Z", "setPause", "(Z)V", "isStartLoop", "setStartLoop", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "needToRefresh", "restartRunnable", "Ljava/lang/Runnable;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "checkAllAnimPause", "checkAllAnimResume", "getFunctionSwitch", "initView", "", "pause", "reset", "prepareForRestart", "resume", "showBulletSubtitleLayout", "isShow", "smoothScrollToLastPosition", "startLoop", "switchFunction", "isTurnOn", "needRefresh", "plugin-finder_release"})
public final class e
{
  boolean fEs;
  final View kJC;
  private final kotlin.f xlu;
  public WxRecyclerAdapter<?> xnR;
  private final d xwA;
  private final kotlin.f xwp;
  public WxRecyclerView xwq;
  FrameLayout xwr;
  private FinderAutoScrollLayoutManager xws;
  ValueAnimator xwt;
  ValueAnimator xwu;
  Runnable xwv;
  public boolean xww;
  private boolean xwx;
  private boolean xwy;
  boolean xwz;
  
  public e(View paramView, d paramd)
  {
    AppMethodBeat.i(280256);
    this.kJC = paramView;
    this.xwA = paramd;
    this.xwp = kotlin.g.ar((kotlin.g.a.a)new a(this));
    this.xlu = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.xwx = true;
    AppMethodBeat.o(280256);
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(280244);
    Context localContext = (Context)this.xwp.getValue();
    AppMethodBeat.o(280244);
    return localContext;
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(280245);
    int i = ((Number)this.xlu.getValue()).intValue();
    AppMethodBeat.o(280245);
    return i;
  }
  
  private final void op(boolean paramBoolean)
  {
    AppMethodBeat.i(280255);
    if (paramBoolean)
    {
      localFrameLayout = this.xwr;
      if (localFrameLayout == null) {
        p.bGy("bulletSubtitleLayout");
      }
      localFrameLayout.animate().cancel();
      localFrameLayout = this.xwr;
      if (localFrameLayout == null) {
        p.bGy("bulletSubtitleLayout");
      }
      localFrameLayout.setAlpha(0.0F);
      localFrameLayout = this.xwr;
      if (localFrameLayout == null) {
        p.bGy("bulletSubtitleLayout");
      }
      localFrameLayout.animate().alpha(1.0F).setDuration(300L).withStartAction((Runnable)new h(this)).start();
      AppMethodBeat.o(280255);
      return;
    }
    FrameLayout localFrameLayout = this.xwr;
    if (localFrameLayout == null) {
      p.bGy("bulletSubtitleLayout");
    }
    localFrameLayout.animate().cancel();
    localFrameLayout = this.xwr;
    if (localFrameLayout == null) {
      p.bGy("bulletSubtitleLayout");
    }
    localFrameLayout.setAlpha(1.0F);
    localFrameLayout = this.xwr;
    if (localFrameLayout == null) {
      p.bGy("bulletSubtitleLayout");
    }
    localFrameLayout.setVisibility(8);
    AppMethodBeat.o(280255);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(280250);
    Object localObject;
    boolean bool;
    label59:
    label79:
    com.tencent.mm.plugin.finder.report.c localc;
    label114:
    long l;
    int j;
    if (paramBoolean1)
    {
      localObject = h.ae(ae.class);
      p.j(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)localObject).dYT())
      {
        bool = true;
        this.xwx = bool;
        if (!this.xwx) {
          break label179;
        }
        op(true);
        if ((!this.xwx) || (!paramBoolean2)) {
          break label187;
        }
        this.xwy = true;
        startLoop();
        if (!paramBoolean2) {
          break label253;
        }
        localObject = this.xwA.feed;
        if (localObject == null) {
          break label253;
        }
        if (!paramBoolean1) {
          break label195;
        }
        localc = com.tencent.mm.plugin.finder.report.c.zTT;
        com.tencent.mm.plugin.finder.report.c.Mh(((FeedData)localObject).getId());
        localc = com.tencent.mm.plugin.finder.report.c.zTT;
        l = ((FeedData)localObject).getId();
        j = ((FeedData)localObject).getMediaType();
        if (!paramBoolean1) {
          break label211;
        }
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = getContext();
      if (localObject != null) {
        break label216;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(280250);
      throw ((Throwable)localObject);
      bool = false;
      break;
      label179:
      op(false);
      break label59;
      label187:
      reset(false);
      break label79;
      label195:
      localc = com.tencent.mm.plugin.finder.report.c.zTT;
      com.tencent.mm.plugin.finder.report.c.Mg(((FeedData)localObject).getId());
      break label114;
      label211:
      i = 2;
    }
    label216:
    com.tencent.mm.plugin.finder.report.c.a(l, j, i, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject).i(aj.class)).ekY());
    AppMethodBeat.o(280250);
    return;
    label253:
    AppMethodBeat.o(280250);
  }
  
  public final WxRecyclerView dsO()
  {
    AppMethodBeat.i(280246);
    WxRecyclerView localWxRecyclerView = this.xwq;
    if (localWxRecyclerView == null) {
      p.bGy("bulletSubtitleRv");
    }
    AppMethodBeat.o(280246);
    return localWxRecyclerView;
  }
  
  public final void dsP()
  {
    AppMethodBeat.i(280254);
    if ((this.fEs) || (!this.xww) || (this.xwz))
    {
      AppMethodBeat.o(280254);
      return;
    }
    Object localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    if (!((WxRecyclerView)localObject1).canScrollHorizontally(1))
    {
      localObject1 = this.xwu;
      if (localObject1 == null) {
        p.bGy("exitAnimator");
      }
      ((ValueAnimator)localObject1).start();
      AppMethodBeat.o(280254);
      return;
    }
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    Object localObject2 = this.xwq;
    if (localObject2 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject2 = ((WxRecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.iCn();
    }
    p.j(localObject2, "bulletSubtitleRv.adapter!!");
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(((RecyclerView.a)localObject2).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(280254);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(280251);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    this.xwx = localf.aHp().getBoolean(ar.a.VBI, true);
    boolean bool = this.xwx;
    AppMethodBeat.o(280251);
    return bool;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(280248);
    Object localObject1 = this.kJC.findViewById(b.f.rv_bullet_subtitle);
    p.j(localObject1, "parent.findViewById<WxRe…(R.id.rv_bullet_subtitle)");
    this.xwq = ((WxRecyclerView)localObject1);
    localObject1 = this.kJC.findViewById(b.f.bullet_subtitle_layout);
    p.j(localObject1, "parent.findViewById<Fram…d.bullet_subtitle_layout)");
    this.xwr = ((FrameLayout)localObject1);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).setOnTouchListener((View.OnTouchListener)e.b.xwC);
    localObject1 = this.xwA;
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    this.xnR = ((d)localObject1).fs((Context)localObject2);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject2 = this.xnR;
    if (localObject2 == null) {
      p.bGy("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject2 = getContext();
    p.j(localObject2, "context");
    localObject2 = new FinderAutoScrollLayoutManager((Context)localObject2);
    ((FinderAutoScrollLayoutManager)localObject2).setOrientation(0);
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager");
      AppMethodBeat.o(280248);
      throw ((Throwable)localObject1);
    }
    this.xws = ((FinderAutoScrollLayoutManager)localObject1);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject2 = com.tencent.mm.ui.component.g.Xox;
    localObject2 = getContext();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(280248);
      throw ((Throwable)localObject1);
    }
    ((WxRecyclerView)localObject1).setRecycledViewPool(((com.tencent.mm.plugin.finder.viewmodel.c)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject2).i(com.tencent.mm.plugin.finder.viewmodel.c.class)).BgY);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject1 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { getScreenWidth(), 0.0F });
    p.j(localObject1, "ObjectAnimator.ofFloat(b…creenWidth.toFloat(), 0f)");
    this.xwt = ((ValueAnimator)localObject1);
    localObject1 = new LinearInterpolator();
    localObject2 = this.xwt;
    if (localObject2 == null) {
      p.bGy("enterAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    this.xwv = ((Runnable)new c(this));
    localObject2 = this.xwt;
    if (localObject2 == null) {
      p.bGy("enterAnimator");
    }
    ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new d(this));
    localObject2 = this.xwt;
    if (localObject2 == null) {
      p.bGy("enterAnimator");
    }
    ((ValueAnimator)localObject2).setDuration(4000L);
    localObject2 = this.xwq;
    if (localObject2 == null) {
      p.bGy("bulletSubtitleRv");
    }
    localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { 0.0F, -getScreenWidth() });
    p.j(localObject2, "ObjectAnimator.ofFloat(b…, -screenWidth.toFloat())");
    this.xwu = ((ValueAnimator)localObject2);
    localObject2 = this.xwu;
    if (localObject2 == null) {
      p.bGy("exitAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    localObject1 = this.xwu;
    if (localObject1 == null) {
      p.bGy("exitAnimator");
    }
    ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new e(this));
    localObject1 = this.xwu;
    if (localObject1 == null) {
      p.bGy("exitAnimator");
    }
    ((ValueAnimator)localObject1).setDuration(4000L);
    localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).a((RecyclerView.l)new f(this));
    localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    this.xwx = ((com.tencent.mm.kernel.f)localObject1).aHp().getBoolean(ar.a.VBI, true);
    AppMethodBeat.o(280248);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(280253);
    this.xww = false;
    this.fEs = false;
    this.xwA.dsN();
    Object localObject1 = this.xwq;
    if (localObject1 == null) {
      p.bGy("bulletSubtitleRv");
    }
    Object localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    if (!paramBoolean)
    {
      op(false);
      localObject1 = this.xwq;
      if (localObject1 == null) {
        p.bGy("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(8);
      localObject1 = this.xwq;
      if (localObject1 == null) {
        p.bGy("bulletSubtitleRv");
      }
      localObject2 = this.xwv;
      if (localObject2 == null) {
        p.bGy("restartRunnable");
      }
      ((WxRecyclerView)localObject1).removeCallbacks((Runnable)localObject2);
    }
    this.xwz = false;
    localObject1 = this.xwt;
    if (localObject1 == null) {
      p.bGy("enterAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    localObject1 = this.xwu;
    if (localObject1 == null) {
      p.bGy("exitAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    AppMethodBeat.o(280253);
  }
  
  public final void startLoop()
  {
    AppMethodBeat.i(280252);
    Object localObject1 = h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)localObject1).dYT())
    {
      AppMethodBeat.o(280252);
      return;
    }
    localObject1 = this.xwA.feed;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.c.zTT;
      com.tencent.mm.plugin.finder.report.c.start(((FeedData)localObject1).getId());
    }
    if (!this.xww)
    {
      localObject1 = this.xwq;
      if (localObject1 == null) {
        p.bGy("bulletSubtitleRv");
      }
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 == null) {
        p.iCn();
      }
      p.j(localObject1, "bulletSubtitleRv.adapter!!");
      if (((RecyclerView.a)localObject1).getItemCount() > 0) {}
    }
    else
    {
      AppMethodBeat.o(280252);
      return;
    }
    localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    long l;
    if (!((com.tencent.mm.kernel.f)localObject1).aHp().getBoolean(ar.a.VBI, true))
    {
      this.xwx = false;
      localObject1 = this.xwA.feed;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.c.zTT;
        l = ((FeedData)localObject1).getId();
        if (this.xwx) {}
        for (i = 1;; i = 0)
        {
          com.tencent.mm.plugin.finder.report.c.M(l, i);
          AppMethodBeat.o(280252);
          return;
        }
      }
      AppMethodBeat.o(280252);
      return;
    }
    this.xwx = true;
    localObject1 = this.xnR;
    if (localObject1 == null) {
      p.bGy("adapter");
    }
    ((WxRecyclerAdapter)localObject1).notifyDataSetChanged();
    Object localObject2 = this.xwA.feed;
    if (localObject2 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.zTT;
      com.tencent.mm.plugin.finder.report.c.Mf(((FeedData)localObject2).getId());
      localObject1 = com.tencent.mm.plugin.finder.report.c.zTT;
      l = ((FeedData)localObject2).getId();
      localObject1 = this.xnR;
      if (localObject1 == null) {
        p.bGy("adapter");
      }
      if (localObject1 == null) {
        break label450;
      }
      localObject1 = Integer.valueOf(((WxRecyclerAdapter)localObject1).getItemCount());
      com.tencent.mm.plugin.finder.report.c.L(l, ((Integer)localObject1).intValue());
      localObject1 = com.tencent.mm.plugin.finder.report.c.zTT;
      l = ((FeedData)localObject2).getId();
      if (!this.xwx) {
        break label456;
      }
    }
    label450:
    label456:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.c.M(l, i);
      localObject1 = this.xwq;
      if (localObject1 == null) {
        p.bGy("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setTranslationX(getScreenWidth());
      localObject1 = this.xwq;
      if (localObject1 == null) {
        p.bGy("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(0);
      op(true);
      localObject1 = this.xwt;
      if (localObject1 == null) {
        p.bGy("enterAnimator");
      }
      ((ValueAnimator)localObject1).start();
      this.xwz = true;
      this.xww = true;
      this.fEs = false;
      AppMethodBeat.o(280252);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Context>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(268012);
      Object localObject;
      int i;
      if (this.xwB.dsO().getVisibility() == 0)
      {
        this.xwB.startLoop();
        if (this.xwB.fEs)
        {
          localObject = this.xwB;
          ((e)localObject).fEs = true;
          if (((e)localObject).xww)
          {
            i = 0;
            ValueAnimator localValueAnimator = ((e)localObject).xwt;
            if (localValueAnimator == null) {
              p.bGy("enterAnimator");
            }
            if (localValueAnimator.isRunning())
            {
              localValueAnimator = ((e)localObject).xwt;
              if (localValueAnimator == null) {
                p.bGy("enterAnimator");
              }
              localValueAnimator.pause();
              i = 1;
            }
            localValueAnimator = ((e)localObject).xwu;
            if (localValueAnimator == null) {
              p.bGy("exitAnimator");
            }
            if (!localValueAnimator.isRunning()) {
              break label178;
            }
            localValueAnimator = ((e)localObject).xwu;
            if (localValueAnimator == null) {
              p.bGy("exitAnimator");
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
          localObject = ((e)localObject).xwq;
          if (localObject == null) {
            p.bGy("bulletSubtitleRv");
          }
          ((WxRecyclerView)localObject).ld();
        }
        AppMethodBeat.o(268012);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(277054);
      this.xwB.xwz = false;
      if (this.xwB.dsO().getVisibility() != 0)
      {
        AppMethodBeat.o(277054);
        return;
      }
      this.xwB.dsP();
      AppMethodBeat.o(277054);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(286103);
      this.xwB.reset(true);
      paramAnimator = this.xwB.dsO();
      Runnable localRunnable = this.xwB.xwv;
      if (localRunnable == null) {
        p.bGy("restartRunnable");
      }
      paramAnimator.postDelayed(localRunnable, 5000L);
      AppMethodBeat.o(286103);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(289815);
      p.k(paramRecyclerView, "recyclerView");
      if (paramInt == 0)
      {
        if ((paramRecyclerView.getVisibility() == 8) || (!this.xwB.xww) || (this.xwB.fEs))
        {
          AppMethodBeat.o(289815);
          return;
        }
        this.xwB.dsP();
      }
      AppMethodBeat.o(289815);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289816);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(289816);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<Integer>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(266258);
      FrameLayout localFrameLayout = this.xwB.xwr;
      if (localFrameLayout == null) {
        p.bGy("bulletSubtitleLayout");
      }
      localFrameLayout.setVisibility(0);
      AppMethodBeat.o(266258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e
 * JD-Core Version:    0.7.0.1
 */