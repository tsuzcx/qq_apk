package com.tencent.mm.plugin.finder.feed;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "bulletSubtitleLayout", "Landroid/widget/FrameLayout;", "bulletSubtitleRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBulletSubtitleRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setBulletSubtitleRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exitAnimator", "isEnterAnimRunning", "", "isFunctionTurnOn", "isPause", "()Z", "setPause", "(Z)V", "isStartLoop", "setStartLoop", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "needToRefresh", "restartRunnable", "Ljava/lang/Runnable;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "checkAllAnimPause", "checkAllAnimResume", "getFunctionSwitch", "initView", "", "pause", "reset", "prepareForRestart", "resume", "showBulletSubtitleLayout", "isShow", "smoothScrollToLastPosition", "startLoop", "switchFunction", "isTurnOn", "needRefresh", "plugin-finder_release"})
public final class e
{
  boolean dLD;
  final View hVd;
  private final f tCY;
  public WxRecyclerAdapter<?> tFp;
  FrameLayout tMA;
  private FinderAutoScrollLayoutManager tMB;
  ValueAnimator tMC;
  ValueAnimator tMD;
  Runnable tME;
  public boolean tMF;
  private boolean tMG;
  private boolean tMH;
  boolean tMI;
  private final d tMJ;
  private final f tMy;
  public WxRecyclerView tMz;
  
  public e(View paramView, d paramd)
  {
    AppMethodBeat.i(243741);
    this.hVd = paramView;
    this.tMJ = paramd;
    this.tMy = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.tCY = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.tMG = true;
    AppMethodBeat.o(243741);
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(243731);
    Context localContext = (Context)this.tMy.getValue();
    AppMethodBeat.o(243731);
    return localContext;
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(243732);
    int i = ((Number)this.tCY.getValue()).intValue();
    AppMethodBeat.o(243732);
    return i;
  }
  
  private final void mV(boolean paramBoolean)
  {
    AppMethodBeat.i(243740);
    if (paramBoolean)
    {
      localFrameLayout = this.tMA;
      if (localFrameLayout == null) {
        p.btv("bulletSubtitleLayout");
      }
      localFrameLayout.animate().cancel();
      localFrameLayout = this.tMA;
      if (localFrameLayout == null) {
        p.btv("bulletSubtitleLayout");
      }
      localFrameLayout.setAlpha(0.0F);
      localFrameLayout = this.tMA;
      if (localFrameLayout == null) {
        p.btv("bulletSubtitleLayout");
      }
      localFrameLayout.animate().alpha(1.0F).setDuration(300L).withStartAction((Runnable)new h(this)).start();
      AppMethodBeat.o(243740);
      return;
    }
    FrameLayout localFrameLayout = this.tMA;
    if (localFrameLayout == null) {
      p.btv("bulletSubtitleLayout");
    }
    localFrameLayout.animate().cancel();
    localFrameLayout = this.tMA;
    if (localFrameLayout == null) {
      p.btv("bulletSubtitleLayout");
    }
    localFrameLayout.setAlpha(1.0F);
    localFrameLayout = this.tMA;
    if (localFrameLayout == null) {
      p.btv("bulletSubtitleLayout");
    }
    localFrameLayout.setVisibility(8);
    AppMethodBeat.o(243740);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(243735);
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
      localObject = com.tencent.mm.kernel.g.af(ad.class);
      p.g(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)localObject).dxX())
      {
        bool = true;
        this.tMG = bool;
        if (!this.tMG) {
          break label179;
        }
        mV(true);
        if ((!this.tMG) || (!paramBoolean2)) {
          break label187;
        }
        this.tMH = true;
        startLoop();
        if (!paramBoolean2) {
          break label253;
        }
        localObject = this.tMJ.feed;
        if (localObject == null) {
          break label253;
        }
        if (!paramBoolean1) {
          break label195;
        }
        localc = com.tencent.mm.plugin.finder.report.c.vdc;
        com.tencent.mm.plugin.finder.report.c.EX(((FeedData)localObject).getId());
        localc = com.tencent.mm.plugin.finder.report.c.vdc;
        l = ((FeedData)localObject).getId();
        j = ((FeedData)localObject).getMediaType();
        if (!paramBoolean1) {
          break label211;
        }
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = getContext();
      if (localObject != null) {
        break label216;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243735);
      throw ((Throwable)localObject);
      bool = false;
      break;
      label179:
      mV(false);
      break label59;
      label187:
      reset(false);
      break label79;
      label195:
      localc = com.tencent.mm.plugin.finder.report.c.vdc;
      com.tencent.mm.plugin.finder.report.c.EW(((FeedData)localObject).getId());
      break label114;
      label211:
      i = 2;
    }
    label216:
    com.tencent.mm.plugin.finder.report.c.a(l, j, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject).get(FinderReporterUIC.class)).dIx());
    AppMethodBeat.o(243735);
    return;
    label253:
    AppMethodBeat.o(243735);
  }
  
  public final WxRecyclerView dcy()
  {
    AppMethodBeat.i(243733);
    WxRecyclerView localWxRecyclerView = this.tMz;
    if (localWxRecyclerView == null) {
      p.btv("bulletSubtitleRv");
    }
    AppMethodBeat.o(243733);
    return localWxRecyclerView;
  }
  
  public final void dcz()
  {
    AppMethodBeat.i(243739);
    if ((this.dLD) || (!this.tMF) || (this.tMI))
    {
      AppMethodBeat.o(243739);
      return;
    }
    Object localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    if (!((WxRecyclerView)localObject1).canScrollHorizontally(1))
    {
      localObject1 = this.tMD;
      if (localObject1 == null) {
        p.btv("exitAnimator");
      }
      ((ValueAnimator)localObject1).start();
      AppMethodBeat.o(243739);
      return;
    }
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    Object localObject2 = this.tMz;
    if (localObject2 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject2 = ((WxRecyclerView)localObject2).getAdapter();
    if (localObject2 == null) {
      p.hyc();
    }
    p.g(localObject2, "bulletSubtitleRv.adapter!!");
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(((RecyclerView.a)localObject2).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(243739);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(243736);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    this.tMG = locale.azQ().getBoolean(ar.a.OmJ, true);
    boolean bool = this.tMG;
    AppMethodBeat.o(243736);
    return bool;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(243734);
    Object localObject1 = this.hVd.findViewById(2131307197);
    p.g(localObject1, "parent.findViewById<WxRe…(R.id.rv_bullet_subtitle)");
    this.tMz = ((WxRecyclerView)localObject1);
    localObject1 = this.hVd.findViewById(2131297861);
    p.g(localObject1, "parent.findViewById<Fram…d.bullet_subtitle_layout)");
    this.tMA = ((FrameLayout)localObject1);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).setOnTouchListener((View.OnTouchListener)b.tML);
    localObject1 = this.tMJ;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    this.tFp = ((d)localObject1).fm((Context)localObject2);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject2 = this.tFp;
    if (localObject2 == null) {
      p.btv("adapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = new FinderAutoScrollLayoutManager((Context)localObject2);
    ((FinderAutoScrollLayoutManager)localObject2).setOrientation(0);
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager");
      AppMethodBeat.o(243734);
      throw ((Throwable)localObject1);
    }
    this.tMB = ((FinderAutoScrollLayoutManager)localObject1);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject2 = getContext();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243734);
      throw ((Throwable)localObject1);
    }
    ((WxRecyclerView)localObject1).setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject2).get(FinderRecyclerViewPool.class)).wuz);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject1 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { getScreenWidth(), 0.0F });
    p.g(localObject1, "ObjectAnimator.ofFloat(b…creenWidth.toFloat(), 0f)");
    this.tMC = ((ValueAnimator)localObject1);
    localObject1 = new LinearInterpolator();
    localObject2 = this.tMC;
    if (localObject2 == null) {
      p.btv("enterAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    this.tME = ((Runnable)new c(this));
    localObject2 = this.tMC;
    if (localObject2 == null) {
      p.btv("enterAnimator");
    }
    ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new d(this));
    localObject2 = this.tMC;
    if (localObject2 == null) {
      p.btv("enterAnimator");
    }
    ((ValueAnimator)localObject2).setDuration(4000L);
    localObject2 = this.tMz;
    if (localObject2 == null) {
      p.btv("bulletSubtitleRv");
    }
    localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { 0.0F, -getScreenWidth() });
    p.g(localObject2, "ObjectAnimator.ofFloat(b…, -screenWidth.toFloat())");
    this.tMD = ((ValueAnimator)localObject2);
    localObject2 = this.tMD;
    if (localObject2 == null) {
      p.btv("exitAnimator");
    }
    ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
    localObject1 = this.tMD;
    if (localObject1 == null) {
      p.btv("exitAnimator");
    }
    ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new e(this));
    localObject1 = this.tMD;
    if (localObject1 == null) {
      p.btv("exitAnimator");
    }
    ((ValueAnimator)localObject1).setDuration(4000L);
    localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    ((WxRecyclerView)localObject1).a((RecyclerView.l)new f(this));
    localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    this.tMG = ((com.tencent.mm.kernel.e)localObject1).azQ().getBoolean(ar.a.OmJ, true);
    AppMethodBeat.o(243734);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(243738);
    this.tMF = false;
    this.dLD = false;
    this.tMJ.dcx();
    Object localObject1 = this.tMz;
    if (localObject1 == null) {
      p.btv("bulletSubtitleRv");
    }
    Object localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    if (!paramBoolean)
    {
      mV(false);
      localObject1 = this.tMz;
      if (localObject1 == null) {
        p.btv("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(8);
      localObject1 = this.tMz;
      if (localObject1 == null) {
        p.btv("bulletSubtitleRv");
      }
      localObject2 = this.tME;
      if (localObject2 == null) {
        p.btv("restartRunnable");
      }
      ((WxRecyclerView)localObject1).removeCallbacks((Runnable)localObject2);
    }
    this.tMI = false;
    localObject1 = this.tMC;
    if (localObject1 == null) {
      p.btv("enterAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    localObject1 = this.tMD;
    if (localObject1 == null) {
      p.btv("exitAnimator");
    }
    ((ValueAnimator)localObject1).cancel();
    AppMethodBeat.o(243738);
  }
  
  public final void startLoop()
  {
    AppMethodBeat.i(243737);
    Object localObject1 = com.tencent.mm.kernel.g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)localObject1).dxX())
    {
      AppMethodBeat.o(243737);
      return;
    }
    localObject1 = this.tMJ.feed;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.c.vdc;
      com.tencent.mm.plugin.finder.report.c.start(((FeedData)localObject1).getId());
    }
    if (!this.tMF)
    {
      localObject1 = this.tMz;
      if (localObject1 == null) {
        p.btv("bulletSubtitleRv");
      }
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 == null) {
        p.hyc();
      }
      p.g(localObject1, "bulletSubtitleRv.adapter!!");
      if (((RecyclerView.a)localObject1).getItemCount() > 0) {}
    }
    else
    {
      AppMethodBeat.o(243737);
      return;
    }
    localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    long l;
    if (!((com.tencent.mm.kernel.e)localObject1).azQ().getBoolean(ar.a.OmJ, true))
    {
      this.tMG = false;
      localObject1 = this.tMJ.feed;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.c.vdc;
        l = ((FeedData)localObject1).getId();
        if (this.tMG) {}
        for (i = 1;; i = 0)
        {
          com.tencent.mm.plugin.finder.report.c.F(l, i);
          AppMethodBeat.o(243737);
          return;
        }
      }
      AppMethodBeat.o(243737);
      return;
    }
    this.tMG = true;
    localObject1 = this.tFp;
    if (localObject1 == null) {
      p.btv("adapter");
    }
    ((WxRecyclerAdapter)localObject1).notifyDataSetChanged();
    Object localObject2 = this.tMJ.feed;
    if (localObject2 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.vdc;
      com.tencent.mm.plugin.finder.report.c.EV(((FeedData)localObject2).getId());
      localObject1 = com.tencent.mm.plugin.finder.report.c.vdc;
      l = ((FeedData)localObject2).getId();
      localObject1 = this.tFp;
      if (localObject1 == null) {
        p.btv("adapter");
      }
      if (localObject1 == null) {
        break label450;
      }
      localObject1 = Integer.valueOf(((WxRecyclerAdapter)localObject1).getItemCount());
      com.tencent.mm.plugin.finder.report.c.E(l, ((Integer)localObject1).intValue());
      localObject1 = com.tencent.mm.plugin.finder.report.c.vdc;
      l = ((FeedData)localObject2).getId();
      if (!this.tMG) {
        break label456;
      }
    }
    label450:
    label456:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.c.F(l, i);
      localObject1 = this.tMz;
      if (localObject1 == null) {
        p.btv("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setTranslationX(getScreenWidth());
      localObject1 = this.tMz;
      if (localObject1 == null) {
        p.btv("bulletSubtitleRv");
      }
      ((WxRecyclerView)localObject1).setVisibility(0);
      mV(true);
      localObject1 = this.tMC;
      if (localObject1 == null) {
        p.btv("enterAnimator");
      }
      ((ValueAnimator)localObject1).start();
      this.tMI = true;
      this.tMF = true;
      this.dLD = false;
      AppMethodBeat.o(243737);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Context>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    public static final b tML;
    
    static
    {
      AppMethodBeat.i(243723);
      tML = new b();
      AppMethodBeat.o(243723);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(243724);
      Object localObject;
      int i;
      if (this.tMK.dcy().getVisibility() == 0)
      {
        this.tMK.startLoop();
        if (this.tMK.dLD)
        {
          localObject = this.tMK;
          ((e)localObject).dLD = true;
          if (((e)localObject).tMF)
          {
            i = 0;
            ValueAnimator localValueAnimator = ((e)localObject).tMC;
            if (localValueAnimator == null) {
              p.btv("enterAnimator");
            }
            if (localValueAnimator.isRunning())
            {
              localValueAnimator = ((e)localObject).tMC;
              if (localValueAnimator == null) {
                p.btv("enterAnimator");
              }
              localValueAnimator.pause();
              i = 1;
            }
            localValueAnimator = ((e)localObject).tMD;
            if (localValueAnimator == null) {
              p.btv("exitAnimator");
            }
            if (!localValueAnimator.isRunning()) {
              break label178;
            }
            localValueAnimator = ((e)localObject).tMD;
            if (localValueAnimator == null) {
              p.btv("exitAnimator");
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
          localObject = ((e)localObject).tMz;
          if (localObject == null) {
            p.btv("bulletSubtitleRv");
          }
          ((WxRecyclerView)localObject).kQ();
        }
        AppMethodBeat.o(243724);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(243725);
      this.tMK.tMI = false;
      if (this.tMK.dcy().getVisibility() != 0)
      {
        AppMethodBeat.o(243725);
        return;
      }
      this.tMK.dcz();
      AppMethodBeat.o(243725);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(243726);
      this.tMK.reset(true);
      paramAnimator = this.tMK.dcy();
      Runnable localRunnable = this.tMK.tME;
      if (localRunnable == null) {
        p.btv("restartRunnable");
      }
      paramAnimator.postDelayed(localRunnable, 5000L);
      AppMethodBeat.o(243726);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243727);
      p.h(paramRecyclerView, "recyclerView");
      if (paramInt == 0)
      {
        if ((paramRecyclerView.getVisibility() == 8) || (!this.tMK.tMF) || (this.tMK.dLD))
        {
          AppMethodBeat.o(243727);
          return;
        }
        this.tMK.dcz();
      }
      AppMethodBeat.o(243727);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243728);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(243728);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<Integer>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(243730);
      FrameLayout localFrameLayout = this.tMK.tMA;
      if (localFrameLayout == null) {
        p.btv("bulletSubtitleLayout");
      }
      localFrameLayout.setVisibility(0);
      AppMethodBeat.o(243730);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e
 * JD-Core Version:    0.7.0.1
 */