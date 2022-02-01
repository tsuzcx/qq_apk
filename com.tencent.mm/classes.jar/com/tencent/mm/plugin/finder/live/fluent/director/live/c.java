package com.tencent.mm.plugin.finder.live.fluent.director.live;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.fluent.animate.b.a;
import com.tencent.mm.plugin.finder.live.fluent.f;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.fluent.i;
import com.tencent.mm.plugin.finder.live.fluent.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.w.a.a.a.b;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchOutLiveDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/director/base/BaseSwitchOutDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentRenderView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "maskView", "Lcom/tencent/mm/plugin/finder/live/fluent/FluentSwitchTextureView;", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "Lkotlin/Lazy;", "addMaskView", "", "addTransition", "builder", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/FluentTransitionConfig$Builder;", "addWindowTransition", "attachTransitionContainerView", "calculateSourceRect", "Landroid/graphics/Rect;", "calculateTargetRect", "detachMaskView", "videoView", "Landroid/view/TextureView;", "detachTransitionContainerView", "getTag", "", "getTransitionDuration", "", "getTransitionParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveParams;", "notifyFirstFrameChange", "renderView", "onFirstFrameRenderCallback", "Lkotlin/Function0;", "stopSwitchOut", "switchInLiveRoom", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.fluent.director.base.c
{
  private com.tencent.mm.plugin.finder.live.fluent.j CDj;
  private LiveVideoView CDk;
  private final kotlin.j rfk;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(352198);
    this.rfk = k.cm((kotlin.g.a.a)new c.e(paramContext));
    AppMethodBeat.o(352198);
  }
  
  private static final void a(c paramc, float paramFloat, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352264);
    s.u(paramc, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(352264);
      throw paramc;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = paramc.CDj;
    if (paramValueAnimator != null)
    {
      paramValueAnimator.setScaleX(1.0F - f * (1.0F - paramFloat));
      Log.i(paramc.TAG, "addTransition maskView scaleX = " + paramValueAnimator.getScaleX() + " scaleY = " + paramValueAnimator.getScaleY());
    }
    AppMethodBeat.o(352264);
  }
  
  private static final void a(c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352226);
    s.u(paramc, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(352226);
      throw paramc;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    int i = paramc.ejH().top;
    int j = (int)((paramc.ejH().top - paramc.ejI().top) * f);
    int k = paramc.ejH().left;
    int m = (int)((paramc.ejH().left - paramc.ejI().left) * f);
    int n = paramc.ejH().width() - (int)((paramc.ejH().width() - paramc.ejI().width()) * f);
    int i1 = paramc.ejH().height() - (int)(f * (paramc.ejH().height() - paramc.ejI().height()));
    paramValueAnimator = paramc.ejO();
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getLayoutParams())
    {
      paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(352226);
      throw paramc;
    }
    paramValueAnimator = (ViewGroup.MarginLayoutParams)paramValueAnimator;
    paramValueAnimator.topMargin = (i - j);
    paramValueAnimator.leftMargin = (k - m);
    paramValueAnimator.width = n;
    paramValueAnimator.height = i1;
    Object localObject = paramc.CDj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.fluent.j)localObject).hD(n, i1);
    }
    localObject = paramc.ejO();
    if (localObject != null) {
      ((RoundedCornerFrameLayout)localObject).requestLayout();
    }
    Log.i(paramc.TAG, "topMargin = " + paramValueAnimator.topMargin + " leftMargin = " + paramValueAnimator.leftMargin + " width = " + n + " height = " + i1);
    AppMethodBeat.o(352226);
  }
  
  private static final void a(c paramc, LiveVideoView paramLiveVideoView, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(352295);
    s.u(paramc, "this$0");
    s.u(paramLiveVideoView, "$renderView");
    s.u(parama, "$onFirstFrameRenderCallback");
    Log.i(paramc.TAG, "switchInLiveRoom switch view success. #2");
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
    if (com.tencent.mm.plugin.finder.live.fluent.a.ejm())
    {
      localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      com.tencent.mm.plugin.finder.live.fluent.util.a.fQ((View)paramLiveVideoView);
    }
    parama.invoke();
    if (((f)paramc.ejN()).CCq) {
      paramc.ejD();
    }
    for (;;)
    {
      Log.i(paramc.TAG, "switchInLiveRoom switch view success. #3");
      AppMethodBeat.o(352295);
      return;
      d.a(60L, (kotlin.g.a.a)new b(paramc));
    }
  }
  
  private static final void b(c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352239);
    s.u(paramc, "this$0");
    paramc = paramc.CCY;
    if (paramc != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(352239);
        throw paramc;
      }
      paramc.setBackgroundColor(((Integer)paramValueAnimator).intValue());
    }
    AppMethodBeat.o(352239);
  }
  
  private static final void c(c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352255);
    s.u(paramc, "this$0");
    paramc = paramc.CCY;
    if (paramc != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(352255);
        throw paramc;
      }
      paramc.setBackgroundColor(((Integer)paramValueAnimator).intValue());
    }
    AppMethodBeat.o(352255);
  }
  
  private static final void d(c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(352273);
    s.u(paramc, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(352273);
      throw paramc;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    int i = paramc.ejH().width();
    int j = (int)((paramc.ejH().width() - paramc.ejI().width()) * f);
    int k = paramc.ejH().height();
    int m = (int)(f * (paramc.ejH().height() - paramc.ejI().height()));
    paramc = paramc.CDj;
    if (paramc != null) {
      paramc.hD(i - j, k - m);
    }
    AppMethodBeat.o(352273);
  }
  
  private final WindowManager getWindowManager()
  {
    AppMethodBeat.i(352207);
    WindowManager localWindowManager = (WindowManager)this.rfk.getValue();
    AppMethodBeat.o(352207);
    return localWindowManager;
  }
  
  public final void a(LiveVideoView paramLiveVideoView, kotlin.g.a.a<ah> parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(352467);
    s.u(paramLiveVideoView, "renderView");
    s.u(parama, "onFirstFrameRenderCallback");
    String str = this.TAG;
    Object localObject1 = ejz();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((AnimatorSet)localObject1).isRunning()))
    {
      Log.i(str, s.X("switchInLiveRoom isRunning:", localObject1));
      localObject1 = i.CCI;
      i.ejv().aDn("switchInLiveRoom before");
      if ((!aFA()) || (paramLiveVideoView != this.CDk)) {
        break;
      }
      parama.invoke();
      Log.i(this.TAG, "switchInLiveRoom skipped by float view is detached.");
      AppMethodBeat.o(352467);
      return;
    }
    localObject1 = ((f)ejN()).CCB;
    int i;
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 == null) {
        parama.invoke();
      }
      this.CDk = paramLiveVideoView;
      parama = ejz();
      if ((parama == null) || (parama.isRunning() != true)) {
        break label256;
      }
      i = 1;
      label179:
      if (i == 0) {
        break label261;
      }
      parama = ejz();
      if (parama != null) {
        parama.addListener((Animator.AnimatorListener)new c.d(this, paramLiveVideoView));
      }
    }
    for (;;)
    {
      paramLiveVideoView = i.CCI;
      i.ejv().gG("switchInLiveRoom after");
      AppMethodBeat.o(352467);
      return;
      ((b)localObject1).setPlayListener((ITXLivePlayListener)new c.c(this, paramLiveVideoView, parama));
      localObject1 = ah.aiuX;
      break;
      label256:
      i = 0;
      break label179;
      label261:
      parama = ((f)ejN()).CCB;
      if (parama != null) {
        parama.setPlayerView((TXCloudVideoView)paramLiveVideoView);
      }
    }
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(352453);
    s.u(parama, "builder");
    if (((f)ejN()).CCq)
    {
      i = getContext().getResources().getColor(a.b.translucent);
      j = getContext().getResources().getColor(a.b.black);
      localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda3(this));
      localah = ah.aiuX;
      s.s(localObject, "ofFloat(0.0f, 1.0f).appl…}\n            }\n        }");
      parama = parama.c((ValueAnimator)localObject);
      localObject = ValueAnimator.ofObject((TypeEvaluator)new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda2(this));
      localah = ah.aiuX;
      s.s(localObject, "ofObject(ArgbEvaluator()…          }\n            }");
      parama.c((ValueAnimator)localObject);
      AppMethodBeat.o(352453);
      return;
    }
    super.a(parama);
    int i = getContext().getResources().getColor(a.b.translucent);
    int j = getContext().getResources().getColor(a.b.black);
    Object localObject = this.CDj;
    if (localObject == null) {}
    for (float f = 1.0F;; f = ((com.tencent.mm.plugin.finder.live.fluent.j)localObject).getScaleX())
    {
      localObject = this.CDj;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.fluent.j)localObject).getScaleY();
      }
      localObject = ValueAnimator.ofObject((TypeEvaluator)new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda0(this));
      localah = ah.aiuX;
      s.s(localObject, "ofObject(ArgbEvaluator()…          }\n            }");
      parama = parama.c((ValueAnimator)localObject);
      localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      if (!com.tencent.mm.plugin.finder.live.fluent.util.a.f((h)ejN())) {
        break;
      }
      localObject = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda4(this, f));
      localah = ah.aiuX;
      s.s(localObject, "ofFloat(1.0f, 0.0f).appl…          }\n            }");
      parama.c((ValueAnimator)localObject);
      AppMethodBeat.o(352453);
      return;
    }
    localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda1(this));
    ah localah = ah.aiuX;
    s.s(localObject, "ofFloat(0.0f, 1.0f).appl…          }\n            }");
    parama.c((ValueAnimator)localObject);
    AppMethodBeat.o(352453);
  }
  
  public final long ejA()
  {
    AppMethodBeat.i(352399);
    if (ejN().CCA == h.a.CCD)
    {
      com.tencent.mm.plugin.finder.live.fluent.util.a locala = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      if (!com.tencent.mm.plugin.finder.live.fluent.util.a.f(ejN()))
      {
        AppMethodBeat.o(352399);
        return 0L;
      }
    }
    long l = super.ejA();
    AppMethodBeat.o(352399);
    return l;
  }
  
  public final void ejC()
  {
    AppMethodBeat.i(352407);
    if (((f)ejN()).CCq)
    {
      WindowManager localWindowManager = getWindowManager();
      View localView = (View)this.CCY;
      com.tencent.mm.plugin.finder.live.fluent.util.a locala = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      localWindowManager.addView(localView, (ViewGroup.LayoutParams)com.tencent.mm.plugin.finder.live.fluent.util.a.ejY());
      this.CCX = false;
      AppMethodBeat.o(352407);
      return;
    }
    super.ejC();
    AppMethodBeat.o(352407);
  }
  
  public final void ejD()
  {
    AppMethodBeat.i(352426);
    Log.i(this.TAG, "detachFloatView view: " + this.CCY + " isFloatWindowEnter: " + ((f)ejN()).CCq);
    super.ejD();
    if (!((f)ejN()).CCq)
    {
      localObject1 = this.CDj;
      s.checkNotNull(localObject1);
      Object localObject2 = (TextureView)localObject1;
      Log.i(this.TAG, "detachMaskView videoView:" + localObject2 + " surfaceTexture:" + ((TextureView)localObject2).getSurfaceTexture());
      ((TextureView)localObject2).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new j.b("detachMaskView", true));
      localObject1 = ((TextureView)localObject2).getParent();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView((View)localObject2);
        }
        if (localObject1 != null) {
          break label247;
        }
      }
      for (localObject1 = null;; localObject1 = ah.aiuX)
      {
        if (localObject1 == null) {
          Log.w(this.TAG, "liveView is null.");
        }
        localObject1 = getTargetView();
        s.checkNotNull(localObject1);
        localObject1 = ((View)localObject1).getRootView();
        localObject2 = ((View)localObject1).findViewWithTag(this.TAG);
        if (localObject2 != null) {
          ((View)localObject2).setOnTouchListener(null);
        }
        if (localObject1 != null) {
          break label262;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(352426);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
        label247:
        ((ViewGroup)localObject1).addView((View)localObject2);
      }
      label262:
      ((ViewGroup)localObject1).removeView((View)localObject2);
      AppMethodBeat.o(352426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    com.tencent.mm.plugin.finder.live.fluent.util.a.ba((kotlin.g.a.a)new c.a(this));
    AppMethodBeat.o(352426);
  }
  
  public final Rect ejE()
  {
    AppMethodBeat.i(352416);
    if (ejN().CCA == h.a.CCD)
    {
      localObject = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      if (!com.tencent.mm.plugin.finder.live.fluent.util.a.f(ejN()))
      {
        localObject = ejF();
        AppMethodBeat.o(352416);
        return localObject;
      }
    }
    Object localObject = super.ejE();
    AppMethodBeat.o(352416);
    return localObject;
  }
  
  public final Rect ejF()
  {
    AppMethodBeat.i(352436);
    Object localObject1 = new int[2];
    Object localObject2 = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
    localObject2 = getTargetView();
    s.checkNotNull(localObject2);
    com.tencent.mm.plugin.finder.live.fluent.util.a.a((View)localObject2, (int[])localObject1);
    int i;
    int j;
    if (((f)ejN()).CCA == h.a.CCD) {
      if (((f)ejN()).hKI >= 1.0F)
      {
        i = (int)(ejw() * 1.0F / ((f)ejN()).hKI);
        j = (ejx() - i) / 2;
        j = localObject1[1] + j;
        ((f)ejN()).w(new Rect(0, j, ejw(), i + j));
      }
    }
    for (;;)
    {
      localObject1 = ((f)ejN()).CCC;
      AppMethodBeat.o(352436);
      return localObject1;
      ((f)ejN()).w(new Rect(0, 0, ejw(), ejx()));
      continue;
      localObject2 = getTargetView();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(352436);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup)localObject2;
      f localf = (f)ejN();
      i = localObject1[0];
      j = localObject1[1];
      int k = localObject1[0];
      int m = ((ViewGroup)localObject2).getWidth();
      int n = localObject1[1];
      localf.w(new Rect(i, j, k + m, ((ViewGroup)localObject2).getHeight() + n));
    }
  }
  
  public final void ejP()
  {
    AppMethodBeat.i(352391);
    TextureView localTextureView = ((f)ejN()).CCs;
    localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new j.b("liveView surfaceTexture"));
    Log.i(this.TAG, s.X("attachMaskView surfaceTexture:", localTextureView.getSurfaceTexture()));
    Object localObject1 = (f)ejN();
    Object localObject2 = localTextureView.getSurfaceTexture();
    s.checkNotNull(localObject2);
    ((f)localObject1).surfaceTexture = ((SurfaceTexture)localObject2);
    localObject1 = new com.tencent.mm.plugin.finder.live.fluent.j(getContext());
    localObject2 = localTextureView.getSurfaceTexture();
    s.checkNotNull(localObject2);
    ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).setSurfaceTexture((SurfaceTexture)localObject2);
    if (!((f)ejN()).CCq)
    {
      localObject2 = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      if ((com.tencent.mm.plugin.finder.live.fluent.util.a.f((h)ejN())) || (ejN().CCA == h.a.CCD)) {
        ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).setScaleX(((f)ejN()).hKI * ejH().height() / ejH().width());
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "createTexture scaleX： " + ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).getScaleX() + " scaleY: " + ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).getScaleY() + " videoRate: " + ((f)ejN()).hKI + " with: " + ejH().width() + " height: " + ejH().height());
      localObject2 = ah.aiuX;
      this.CDj = ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1);
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      localObject2 = ejO();
      if (localObject2 != null) {
        ((RoundedCornerFrameLayout)localObject2).addView((View)this.CDj, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.finder.live.fluent.util.a.CDq;
      com.tencent.mm.plugin.finder.live.fluent.util.a.fQ((View)localTextureView);
      AppMethodBeat.o(352391);
      return;
      int i = ((f)ejN()).videoWidth;
      int j = ((f)ejN()).videoHeight;
      ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).videoWidth = i;
      ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).videoHeight = j;
      ((com.tencent.mm.plugin.finder.live.fluent.j)localObject1).hD(ejH().width(), ejH().height());
    }
  }
  
  public final void ejn()
  {
    AppMethodBeat.i(352475);
    AnimatorSet localAnimatorSet = ejz();
    if (localAnimatorSet != null) {
      localAnimatorSet.pause();
    }
    ejD();
    AppMethodBeat.o(352475);
  }
  
  public final String getTag()
  {
    return "SwitchOutLiveDirector";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.live.c
 * JD-Core Version:    0.7.0.1
 */