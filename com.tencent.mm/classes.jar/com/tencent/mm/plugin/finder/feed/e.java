package com.tencent.mm.plugin.finder.feed;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "", "parent", "Landroid/view/View;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "bulletSubtitleLayout", "Landroid/widget/FrameLayout;", "bulletSubtitleRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getBulletSubtitleRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setBulletSubtitleRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "enterAnimator", "Landroid/animation/ValueAnimator;", "exitAnimator", "isEnterAnimRunning", "", "isFunctionTurnOn", "isPause", "()Z", "setPause", "(Z)V", "isStartLoop", "setStartLoop", "layoutManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "needToRefresh", "restartRunnable", "Ljava/lang/Runnable;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "checkAllAnimPause", "checkAllAnimResume", "getFunctionSwitch", "initView", "", "pause", "reset", "prepareForRestart", "resume", "showBulletSubtitleLayout", "isShow", "smoothScrollToLastPosition", "startLoop", "switchFunction", "isTurnOn", "needRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final j AJO;
  public WxRecyclerAdapter<?> ALE;
  private final d ATT;
  private final j ATU;
  public WxRecyclerView ATV;
  private FrameLayout ATW;
  private FinderAutoScrollLayoutManager ATX;
  private ValueAnimator ATY;
  private ValueAnimator ATZ;
  Runnable AUa;
  boolean AUb;
  private boolean AUc;
  private boolean AUd;
  boolean AUe;
  boolean hJi;
  final View nma;
  
  public e(View paramView, d paramd)
  {
    AppMethodBeat.i(362764);
    this.nma = paramView;
    this.ATT = paramd;
    this.ATU = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.AJO = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.AUc = true;
    AppMethodBeat.o(362764);
  }
  
  private static final void b(e parame)
  {
    int j = 1;
    Object localObject2 = null;
    AppMethodBeat.i(362810);
    s.u(parame, "this$0");
    ValueAnimator localValueAnimator;
    Object localObject1;
    if (parame.ebQ().getVisibility() == 0)
    {
      parame.startLoop();
      if (parame.hJi)
      {
        parame.hJi = true;
        if (parame.AUb)
        {
          localValueAnimator = parame.ATY;
          localObject1 = localValueAnimator;
          if (localValueAnimator == null)
          {
            s.bIx("enterAnimator");
            localObject1 = null;
          }
          if (!((ValueAnimator)localObject1).isRunning()) {
            break label178;
          }
          localValueAnimator = parame.ATY;
          localObject1 = localValueAnimator;
          if (localValueAnimator == null)
          {
            s.bIx("enterAnimator");
            localObject1 = null;
          }
          ((ValueAnimator)localObject1).pause();
        }
      }
    }
    label178:
    for (int i = 1;; i = 0)
    {
      localValueAnimator = parame.ATZ;
      localObject1 = localValueAnimator;
      if (localValueAnimator == null)
      {
        s.bIx("exitAnimator");
        localObject1 = null;
      }
      if (((ValueAnimator)localObject1).isRunning())
      {
        localObject1 = parame.ATZ;
        if (localObject1 == null)
        {
          s.bIx("exitAnimator");
          localObject1 = localObject2;
          ((ValueAnimator)localObject1).pause();
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0) {
          parame.ebQ().JO();
        }
        AppMethodBeat.o(362810);
        return;
        break;
      }
    }
  }
  
  private static final void c(e parame)
  {
    AppMethodBeat.i(362818);
    s.u(parame, "this$0");
    FrameLayout localFrameLayout = parame.ATW;
    parame = localFrameLayout;
    if (localFrameLayout == null)
    {
      s.bIx("bulletSubtitleLayout");
      parame = null;
    }
    parame.setVisibility(0);
    AppMethodBeat.o(362818);
  }
  
  private static final boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  private WxRecyclerAdapter<?> getAdapter()
  {
    AppMethodBeat.i(362777);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null)
    {
      AppMethodBeat.o(362777);
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    AppMethodBeat.o(362777);
    return null;
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(362771);
    Context localContext = (Context)this.ATU.getValue();
    AppMethodBeat.o(362771);
    return localContext;
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(362782);
    int i = ((Number)this.AJO.getValue()).intValue();
    AppMethodBeat.o(362782);
    return i;
  }
  
  private final void pR(boolean paramBoolean)
  {
    FrameLayout localFrameLayout3 = null;
    FrameLayout localFrameLayout2 = null;
    AppMethodBeat.i(362797);
    if (paramBoolean)
    {
      localFrameLayout3 = this.ATW;
      localFrameLayout1 = localFrameLayout3;
      if (localFrameLayout3 == null)
      {
        s.bIx("bulletSubtitleLayout");
        localFrameLayout1 = null;
      }
      localFrameLayout1.animate().cancel();
      localFrameLayout3 = this.ATW;
      localFrameLayout1 = localFrameLayout3;
      if (localFrameLayout3 == null)
      {
        s.bIx("bulletSubtitleLayout");
        localFrameLayout1 = null;
      }
      localFrameLayout1.setAlpha(0.0F);
      localFrameLayout1 = this.ATW;
      if (localFrameLayout1 == null)
      {
        s.bIx("bulletSubtitleLayout");
        localFrameLayout1 = localFrameLayout2;
      }
      for (;;)
      {
        localFrameLayout1.animate().alpha(1.0F).setDuration(300L).withStartAction(new e..ExternalSyntheticLambda2(this)).start();
        AppMethodBeat.o(362797);
        return;
      }
    }
    localFrameLayout2 = this.ATW;
    FrameLayout localFrameLayout1 = localFrameLayout2;
    if (localFrameLayout2 == null)
    {
      s.bIx("bulletSubtitleLayout");
      localFrameLayout1 = null;
    }
    localFrameLayout1.animate().cancel();
    localFrameLayout2 = this.ATW;
    localFrameLayout1 = localFrameLayout2;
    if (localFrameLayout2 == null)
    {
      s.bIx("bulletSubtitleLayout");
      localFrameLayout1 = null;
    }
    localFrameLayout1.setAlpha(1.0F);
    localFrameLayout1 = this.ATW;
    if (localFrameLayout1 == null)
    {
      s.bIx("bulletSubtitleLayout");
      localFrameLayout1 = localFrameLayout3;
    }
    for (;;)
    {
      localFrameLayout1.setVisibility(8);
      AppMethodBeat.o(362797);
      return;
    }
  }
  
  private final void reset(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(362791);
    this.AUb = false;
    this.hJi = false;
    this.ATT.releaseListener();
    Object localObject1 = ebQ();
    Object localObject3 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "reset", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    if (!paramBoolean)
    {
      pR(false);
      ebQ().setVisibility(8);
      WxRecyclerView localWxRecyclerView = ebQ();
      localObject3 = this.AUa;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("restartRunnable");
        localObject1 = null;
      }
      localWxRecyclerView.removeCallbacks((Runnable)localObject1);
    }
    this.AUe = false;
    localObject3 = this.ATY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("enterAnimator");
      localObject1 = null;
    }
    ((ValueAnimator)localObject1).cancel();
    localObject1 = this.ATZ;
    if (localObject1 == null)
    {
      s.bIx("exitAnimator");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ValueAnimator)localObject1).cancel();
      AppMethodBeat.o(362791);
      return;
    }
  }
  
  public final void V(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(362875);
    boolean bool;
    label50:
    label70:
    Object localObject;
    com.tencent.mm.plugin.finder.report.d locald;
    label105:
    long l;
    int j;
    if ((paramBoolean1) && (!((bw)h.ax(bw.class)).aBu()))
    {
      bool = true;
      this.AUc = bool;
      if (!this.AUc) {
        break label171;
      }
      pR(true);
      if ((!this.AUc) || (!paramBoolean2)) {
        break label179;
      }
      this.AUd = true;
      startLoop();
      if (!paramBoolean2) {
        break label239;
      }
      localObject = this.ATT.feed;
      if (localObject == null) {
        break label239;
      }
      if (!paramBoolean1) {
        break label187;
      }
      locald = com.tencent.mm.plugin.finder.report.d.FnC;
      com.tencent.mm.plugin.finder.report.d.py(((FeedData)localObject).getId());
      locald = com.tencent.mm.plugin.finder.report.d.FnC;
      l = ((FeedData)localObject).getId();
      j = ((FeedData)localObject).getMediaType();
      if (!paramBoolean1) {
        break label203;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = getContext();
      if (localObject != null) {
        break label208;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(362875);
      throw ((Throwable)localObject);
      bool = false;
      break;
      label171:
      pR(false);
      break label50;
      label179:
      reset(false);
      break label70;
      label187:
      locald = com.tencent.mm.plugin.finder.report.d.FnC;
      com.tencent.mm.plugin.finder.report.d.px(((FeedData)localObject).getId());
      break label105;
      label203:
      i = 2;
    }
    label208:
    com.tencent.mm.plugin.finder.report.d.a(l, j, i, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(as.class)).fou());
    label239:
    AppMethodBeat.o(362875);
  }
  
  public final WxRecyclerView ebQ()
  {
    AppMethodBeat.i(362847);
    WxRecyclerView localWxRecyclerView = this.ATV;
    if (localWxRecyclerView != null)
    {
      AppMethodBeat.o(362847);
      return localWxRecyclerView;
    }
    s.bIx("bulletSubtitleRv");
    AppMethodBeat.o(362847);
    return null;
  }
  
  public final void ebR()
  {
    AppMethodBeat.i(362908);
    if ((this.hJi) || (!this.AUb) || (this.AUe))
    {
      AppMethodBeat.o(362908);
      return;
    }
    if (!ebQ().canScrollHorizontally(1))
    {
      localObject2 = this.ATZ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("exitAnimator");
        localObject1 = null;
      }
      ((ValueAnimator)localObject1).start();
      AppMethodBeat.o(362908);
      return;
    }
    Object localObject1 = ebQ();
    Object localObject2 = ebQ().getAdapter();
    s.checkNotNull(localObject2);
    localObject2 = c.a(((RecyclerView.a)localObject2).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    ((WxRecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(362908);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(362882);
    this.AUc = h.baE().ban().getBoolean(at.a.adee, true);
    boolean bool = this.AUc;
    AppMethodBeat.o(362882);
    return bool;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(362865);
    Object localObject1 = this.nma.findViewById(com.tencent.mm.plugin.finder.e.e.rv_bullet_subtitle);
    s.s(localObject1, "parent.findViewById<WxRe…(R.id.rv_bullet_subtitle)");
    localObject1 = (WxRecyclerView)localObject1;
    s.u(localObject1, "<set-?>");
    this.ATV = ((WxRecyclerView)localObject1);
    localObject1 = this.nma.findViewById(com.tencent.mm.plugin.finder.e.e.bullet_subtitle_layout);
    s.s(localObject1, "parent.findViewById<Fram…d.bullet_subtitle_layout)");
    this.ATW = ((FrameLayout)localObject1);
    ebQ().setOnTouchListener(e..ExternalSyntheticLambda0.INSTANCE);
    localObject1 = this.ATT;
    Object localObject3 = getContext();
    s.s(localObject3, "context");
    s.u(localObject3, "context");
    localObject1 = ((d)localObject1).ALE;
    s.u(localObject1, "<set-?>");
    this.ALE = ((WxRecyclerAdapter)localObject1);
    ebQ().setAdapter((RecyclerView.a)getAdapter());
    localObject1 = ebQ();
    localObject3 = getContext();
    s.s(localObject3, "context");
    localObject3 = new FinderAutoScrollLayoutManager((Context)localObject3);
    ((FinderAutoScrollLayoutManager)localObject3).setOrientation(0);
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject3);
    localObject1 = ebQ().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderAutoScrollLayoutManager");
      AppMethodBeat.o(362865);
      throw ((Throwable)localObject1);
    }
    this.ATX = ((FinderAutoScrollLayoutManager)localObject1);
    localObject1 = ebQ();
    localObject3 = com.tencent.mm.ui.component.k.aeZF;
    localObject3 = getContext();
    if (localObject3 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(362865);
      throw ((Throwable)localObject1);
    }
    ((WxRecyclerView)localObject1).setRecycledViewPool(((com.tencent.mm.plugin.finder.viewmodel.e)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject3).q(com.tencent.mm.plugin.finder.viewmodel.e.class)).GKZ);
    localObject1 = ObjectAnimator.ofFloat(ebQ(), "translationX", new float[] { getScreenWidth(), 0.0F });
    s.s(localObject1, "ofFloat(bulletSubtitleRv…creenWidth.toFloat(), 0f)");
    this.ATY = ((ValueAnimator)localObject1);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    localObject1 = this.ATY;
    if (localObject1 == null)
    {
      s.bIx("enterAnimator");
      localObject1 = null;
      ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)localLinearInterpolator);
      this.AUa = new e..ExternalSyntheticLambda1(this);
      localObject1 = this.ATY;
      if (localObject1 != null) {
        break label588;
      }
      s.bIx("enterAnimator");
      localObject1 = null;
      label378:
      ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new b(this));
      localObject3 = this.ATY;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("enterAnimator");
        localObject1 = null;
      }
      ((ValueAnimator)localObject1).setDuration(4000L);
      localObject1 = ObjectAnimator.ofFloat(ebQ(), "translationX", new float[] { 0.0F, -getScreenWidth() });
      s.s(localObject1, "ofFloat(bulletSubtitleRv…, -screenWidth.toFloat())");
      this.ATZ = ((ValueAnimator)localObject1);
      localObject3 = this.ATZ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("exitAnimator");
        localObject1 = null;
      }
      ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)localLinearInterpolator);
      localObject1 = this.ATZ;
      if (localObject1 != null) {
        break label591;
      }
      s.bIx("exitAnimator");
      localObject1 = null;
      label504:
      ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new c(this));
      localObject1 = this.ATZ;
      if (localObject1 != null) {
        break label594;
      }
      s.bIx("exitAnimator");
      localObject1 = localObject2;
    }
    label588:
    label591:
    label594:
    for (;;)
    {
      ((ValueAnimator)localObject1).setDuration(4000L);
      ebQ().a((RecyclerView.l)new d(this));
      this.AUc = h.baE().ban().getBoolean(at.a.adee, true);
      AppMethodBeat.o(362865);
      return;
      break;
      break label378;
      break label504;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(370820);
    reset(false);
    AppMethodBeat.o(370820);
  }
  
  public final void startLoop()
  {
    AppMethodBeat.i(362893);
    if (((bw)h.ax(bw.class)).aBu())
    {
      AppMethodBeat.o(362893);
      return;
    }
    Object localObject1 = this.ATT.feed;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.d.FnC;
      com.tencent.mm.plugin.finder.report.d.start(((FeedData)localObject1).getId());
    }
    if (!this.AUb)
    {
      localObject1 = ebQ().getAdapter();
      s.checkNotNull(localObject1);
      if (((RecyclerView.a)localObject1).getItemCount() > 0) {}
    }
    else
    {
      AppMethodBeat.o(362893);
      return;
    }
    long l;
    if (!h.baE().ban().getBoolean(at.a.adee, true))
    {
      this.AUc = false;
      localObject1 = this.ATT.feed;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.d.FnC;
        l = ((FeedData)localObject1).getId();
        if (!this.AUc) {
          break label160;
        }
      }
      label160:
      for (i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.report.d.Z(l, i);
        AppMethodBeat.o(362893);
        return;
      }
    }
    this.AUc = true;
    getAdapter().bZE.notifyChanged();
    localObject1 = this.ATT.feed;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.d.FnC;
      com.tencent.mm.plugin.finder.report.d.pw(((FeedData)localObject1).getId());
      localObject2 = com.tencent.mm.plugin.finder.report.d.FnC;
      l = ((FeedData)localObject1).getId();
      localObject2 = getAdapter();
      if (localObject2 != null) {
        break label336;
      }
      i = 0;
      com.tencent.mm.plugin.finder.report.d.Y(l, i);
      localObject2 = com.tencent.mm.plugin.finder.report.d.FnC;
      l = ((FeedData)localObject1).getId();
      if (!this.AUc) {
        break label345;
      }
    }
    label336:
    label345:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.d.Z(l, i);
      ebQ().setTranslationX(getScreenWidth());
      ebQ().setVisibility(0);
      pR(true);
      localObject2 = this.ATY;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("enterAnimator");
        localObject1 = null;
      }
      ((ValueAnimator)localObject1).start();
      this.AUe = true;
      this.AUb = true;
      this.hJi = false;
      AppMethodBeat.o(362893);
      return;
      i = ((WxRecyclerAdapter)localObject2).getItemCount();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Context>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(e parame) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(362345);
      this.AUf.AUe = false;
      if (this.AUf.ebQ().getVisibility() != 0)
      {
        AppMethodBeat.o(362345);
        return;
      }
      this.AUf.ebR();
      AppMethodBeat.o(362345);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(e parame) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(362354);
      e.d(this.AUf);
      WxRecyclerView localWxRecyclerView = this.AUf.ebQ();
      Runnable localRunnable = this.AUf.AUa;
      paramAnimator = localRunnable;
      if (localRunnable == null)
      {
        s.bIx("restartRunnable");
        paramAnimator = null;
      }
      localWxRecyclerView.postDelayed(paramAnimator, 5000L);
      AppMethodBeat.o(362354);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(e parame) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(362360);
      s.u(paramRecyclerView, "recyclerView");
      if (paramInt == 0)
      {
        if ((paramRecyclerView.getVisibility() == 8) || (!this.AUf.AUb) || (this.AUf.hJi))
        {
          AppMethodBeat.o(362360);
          return;
        }
        this.AUf.ebR();
      }
      AppMethodBeat.o(362360);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362371);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback$initView$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(362371);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e
 * JD-Core Version:    0.7.0.1
 */