package com.tencent.mm.plugin.finder.nearby.guide;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePreviewView;
import com.tencent.mm.plugin.finder.video.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper;", "", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;)V", "animationDuration", "", "animationSet", "Landroid/animation/AnimatorSet;", "animationStartMs", "autoPlayRunnable", "Ljava/lang/Runnable;", "getContext", "()Landroid/content/Context;", "currentAnimatedValue", "", "floatViewAlpha", "Landroid/animation/ValueAnimator;", "floatViewContainer", "Landroid/widget/RelativeLayout;", "hasStop", "", "isDarkMode", "maskView", "Landroid/view/TextureView;", "maskViewContainer", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "scaleRatio", "", "settledDuration", "targetView", "Landroid/view/View;", "targetViewPos", "", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoViewSurfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "attachFloatView", "", "attachMaskView", "videoView", "createAnimationSet", "createReverseAnimationSet", "detachFloatView", "detachMaskView", "getFloatViewBackgroundColor", "getLocationOnScreen", "pos", "reOrderView", "desiredFrontView", "reverse", "reverseDelayMs", "delayMs", "setTargetView", "start", "stop", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EHN;
  private AnimatorSet CCT;
  private RoundedCornerFrameLayout CCZ;
  private int[] EHO;
  private TextureView EHP;
  private RelativeLayout EHQ;
  private ValueAnimator EHR;
  private int EHS;
  private float EHT;
  private long EHU;
  private long EHV;
  private long EHW;
  private TextureView.SurfaceTextureListener EHX;
  private Runnable EHY;
  private boolean EHZ;
  private final Context context;
  private boolean ehd;
  private MMHandler mRi;
  private final RecyclerView mkw;
  private View nmf;
  
  static
  {
    AppMethodBeat.i(340017);
    EHN = new a((byte)0);
    AppMethodBeat.o(340017);
  }
  
  public a(Context paramContext, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(339930);
    this.context = paramContext;
    this.mkw = paramRecyclerView;
    this.EHO = new int[2];
    this.EHS = this.context.getResources().getColor(f.a.translucent);
    this.EHT = 1.15F;
    this.EHU = 300L;
    this.EHV = 1000L;
    this.mRi = new MMHandler(Looper.getMainLooper());
    paramContext = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    this.ehd = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
    AppMethodBeat.o(339930);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(339967);
    s.u(parama, "this$0");
    Object localObject1 = parama.CCT;
    if (localObject1 != null) {
      ((AnimatorSet)localObject1).pause();
    }
    float f3 = (float)(System.currentTimeMillis() - parama.EHW);
    localObject1 = parama.EHR;
    float f2;
    label62:
    int i;
    label71:
    label85:
    float f1;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label408;
      }
      f2 = (float)parama.EHU;
      if (f3 != 0.0F) {
        break label417;
      }
      i = 1;
      if (i == 0)
      {
        if (f2 != 0.0F) {
          break label423;
        }
        i = 1;
        if (i == 0) {
          break label429;
        }
      }
      f1 = 1.0F;
    }
    for (;;)
    {
      float f4 = (parama.EHT - 1.0F) * f1 + 1.0F;
      Log.i("FinderLiveCardPreViewAnimationHelper", "createReverseAnimationSet reverseRatio:" + f1 + " reverseScaleRatio:" + f4 + " [" + f3 + '/' + f2 + ']');
      localObject1 = parama.CCZ;
      s.checkNotNull(localObject1);
      localObject1 = ObjectAnimator.ofFloat(localObject1, "scaleX", new float[] { f4, 1.0F });
      Object localObject2 = parama.CCZ;
      s.checkNotNull(localObject2);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "scaleY", new float[] { f4, 1.0F });
      i = parama.EHS;
      int j = parama.context.getResources().getColor(f.a.translucent);
      ValueAnimator localValueAnimator = ValueAnimator.ofObject((TypeEvaluator)new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda1(parama));
      }
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration((f2 * f4));
      localAnimatorSet.playTogether(new Animator[] { (Animator)localValueAnimator, (Animator)localObject1, (Animator)localObject2 });
      localAnimatorSet.addListener((Animator.AnimatorListener)new d(parama));
      parama.CCT = localAnimatorSet;
      parama = parama.CCT;
      if (parama != null) {
        parama.start();
      }
      AppMethodBeat.o(339967);
      return;
      localObject1 = Float.valueOf((float)((ValueAnimator)localObject1).getDuration());
      break;
      label408:
      f2 = ((Float)localObject1).floatValue();
      break label62;
      label417:
      i = 0;
      break label71;
      label423:
      i = 0;
      break label85;
      label429:
      if (1.0F * f3 / f2 > 1.0F) {
        f1 = 1.0F;
      } else {
        f1 = 1.0F * f3 / f2;
      }
    }
  }
  
  private static final void a(a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(339979);
    s.u(parama, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(339979);
      throw parama;
    }
    parama.EHS = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = parama.EHQ;
    if (paramValueAnimator != null) {
      paramValueAnimator.setBackgroundColor(parama.EHS);
    }
    AppMethodBeat.o(339979);
  }
  
  private static final void a(NearbyLivePreviewView paramNearbyLivePreviewView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(339984);
    if (paramNearbyLivePreviewView != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramNearbyLivePreviewView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(339984);
        throw paramNearbyLivePreviewView;
      }
      paramNearbyLivePreviewView.setVolume(((Integer)paramValueAnimator).intValue());
    }
    AppMethodBeat.o(339984);
  }
  
  private static final boolean a(a parama, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339975);
    s.u(parama, "this$0");
    Log.i("FinderLiveCardPreViewAnimationHelper", "attachFloatView onTouch");
    parama.stop();
    parama = parama.EHQ;
    if (parama != null) {
      parama.setOnTouchListener(null);
    }
    AppMethodBeat.o(339975);
    return false;
  }
  
  private static final void b(a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(339991);
    s.u(parama, "this$0");
    parama = parama.EHQ;
    if (parama != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(339991);
        throw parama;
      }
      parama.setBackgroundColor(((Integer)paramValueAnimator).intValue());
    }
    AppMethodBeat.o(339991);
  }
  
  private final int ejQ()
  {
    if (this.ehd) {
      return f.a.UN_BW_0_Alpha_0_3;
    }
    return f.a.BW_100_Alpha_0_3;
  }
  
  private final void stop()
  {
    AppMethodBeat.i(339945);
    if (this.EHZ)
    {
      Log.i("FinderLiveCardPreViewAnimationHelper", s.X("stop return for hasStop:", Boolean.valueOf(this.EHZ)));
      AppMethodBeat.o(339945);
      return;
    }
    Log.i("FinderLiveCardPreViewAnimationHelper", s.X("stop hasStop:", Boolean.valueOf(this.EHZ)));
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    Object localObject1 = this.CCT;
    if (localObject1 != null) {
      ((AnimatorSet)localObject1).pause();
    }
    localObject1 = this.nmf;
    s.checkNotNull(localObject1);
    View localView1 = ((View)localObject1).getRootView();
    View localView2 = localView1.findViewWithTag("FinderLiveCardPreViewAnimationHelper");
    if (localView2 != null) {
      localView2.setOnTouchListener(null);
    }
    Log.i("FinderLiveCardPreViewAnimationHelper", s.X("detachFloatView view:", localView2));
    localObject1 = this.EHP;
    s.checkNotNull(localObject1);
    Log.i("FinderLiveCardPreViewAnimationHelper", "detachMaskView videoView:" + localObject1 + " surfaceTexture:" + ((TextureView)localObject1).getSurfaceTexture());
    Object localObject2 = this.nmf;
    s.checkNotNull(localObject2);
    ((TextureView)localObject1).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new e());
    localObject2 = (NearbyLivePreviewView)((View)localObject2).findViewWithTag("nearby-live-preview-view-tag");
    if (localObject2 == null) {}
    for (localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.w("FinderLiveCardPreViewAnimationHelper", "liveView is null.");
      }
      localObject1 = this.EHP;
      s.checkNotNull(localObject1);
      localObject1 = ((TextureView)localObject1).getParent();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(339945);
      throw ((Throwable)localObject1);
      localObject3 = ((NearbyLivePreviewView)localObject2).getParent();
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(339945);
        throw ((Throwable)localObject1);
      }
      localObject3 = (ViewGroup)localObject3;
      ((ViewGroup)localObject3).removeView((View)localObject2);
      if ((((TextureView)localObject1).getSurfaceTexture() != null) && (!s.p(((NearbyLivePreviewView)localObject2).getRenderView().getVideoView().getSurfaceTexture(), ((TextureView)localObject1).getSurfaceTexture())))
      {
        TextureView localTextureView = ((NearbyLivePreviewView)localObject2).getRenderView().getVideoView();
        localObject1 = ((TextureView)localObject1).getSurfaceTexture();
        s.checkNotNull(localObject1);
        localTextureView.setSurfaceTexture((SurfaceTexture)localObject1);
      }
      ((ViewGroup)localObject3).addView((View)localObject2);
      ((NearbyLivePreviewView)localObject2).getRenderView().getVideoView().setSurfaceTextureListener(this.EHX);
    }
    localObject2 = (ViewGroup)localObject1;
    Object localObject3 = this.EHP;
    s.checkNotNull(localObject3);
    ((ViewGroup)localObject2).removeView((View)localObject3);
    localObject1 = (ViewGroup)localObject1;
    localObject2 = this.EHP;
    s.checkNotNull(localObject2);
    ((ViewGroup)localObject1).addView((View)localObject2);
    if (localView1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(339945);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup)localView1).removeView(localView2);
    this.EHZ = true;
    AppMethodBeat.o(339945);
  }
  
  public final void setTargetView(View paramView)
  {
    AppMethodBeat.i(340068);
    s.u(paramView, "targetView");
    this.nmf = paramView;
    Object localObject1 = this.EHO;
    Object localObject2 = new int[2];
    paramView.getLocationOnScreen((int[])localObject2);
    Object localObject3 = new int[2];
    this.mkw.getLocationOnScreen((int[])localObject3);
    if (localObject2[1] < localObject3[1])
    {
      Log.w("FinderLiveCardPreViewAnimationHelper", "getLocationOnScreen use recyclerView Y:" + localObject3[1] + " targetViewPos[" + localObject2[0] + 'x' + localObject2[1] + "] recyclerViewPos[" + localObject3[0] + 'x' + localObject3[1] + ']');
      localObject1[1] = localObject3[1];
    }
    for (;;)
    {
      localObject1[0] = localObject2[0];
      Log.i("FinderLiveCardPreViewAnimationHelper", "setTargetView pos[" + this.EHO[0] + ", " + this.EHO[1] + "] scale[" + this.EHT + ", " + this.EHT + "] targetView:" + paramView);
      paramView = this.nmf;
      s.checkNotNull(paramView);
      this.EHQ = new RelativeLayout(paramView.getContext());
      localObject1 = this.EHQ;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setTag("FinderLiveCardPreViewAnimationHelper");
      }
      localObject1 = this.EHQ;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setBackground(paramView.getContext().getResources().getDrawable(ejQ()));
      }
      localObject1 = this.EHQ;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnTouchListener(new a..ExternalSyntheticLambda3(this));
      }
      s.checkNotNull(paramView);
      this.EHP = new TextureView(paramView.getContext());
      localObject1 = this.EHP;
      if (localObject1 != null) {
        ((TextureView)localObject1).setOpaque(false);
      }
      paramView = (NearbyLivePreviewView)paramView.findViewWithTag("nearby-live-preview-view-tag");
      localObject1 = paramView.getRenderView().getVideoView();
      this.EHX = ((TextureView)localObject1).getSurfaceTextureListener();
      Log.i("FinderLiveCardPreViewAnimationHelper", "attachFloatView floatViewContainer:" + this.EHQ + " surfaceTexture:" + paramView.getRenderView().getVideoView().getSurfaceTexture() + " videoViewSurfaceTextureListener:" + this.EHX);
      if (paramView.getRenderView().getVideoView().getSurfaceTexture() != null) {
        break;
      }
      Log.w("FinderLiveCardPreViewAnimationHelper", "attachFloatView error for null.");
      AppMethodBeat.o(340068);
      return;
      localObject1[1] = localObject2[1];
    }
    paramView.getRenderView().getVideoView().setSurfaceTextureListener((TextureView.SurfaceTextureListener)new a.b());
    localObject2 = paramView.getRenderView().getVideoView();
    s.s(localObject2, "liveView.renderView.videoView");
    localObject3 = this.EHP;
    s.checkNotNull(localObject3);
    Object localObject4 = ((TextureView)localObject2).getSurfaceTexture();
    s.checkNotNull(localObject4);
    ((TextureView)localObject3).setSurfaceTexture((SurfaceTexture)localObject4);
    localObject3 = this.nmf;
    s.checkNotNull(localObject3);
    this.CCZ = new RoundedCornerFrameLayout(((View)localObject3).getContext());
    localObject3 = this.CCZ;
    if (localObject3 != null) {
      ((RoundedCornerFrameLayout)localObject3).setRadius(this.context.getResources().getDimension(f.b.Edge_A));
    }
    localObject3 = this.nmf;
    s.checkNotNull(localObject3);
    int i = ((View)localObject3).getWidth();
    localObject3 = this.nmf;
    s.checkNotNull(localObject3);
    localObject3 = new RelativeLayout.LayoutParams(i, ((View)localObject3).getHeight());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.EHO[0];
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.EHO[1];
    localObject4 = this.EHQ;
    if (localObject4 != null) {
      ((RelativeLayout)localObject4).addView((View)this.CCZ, (ViewGroup.LayoutParams)localObject3);
    }
    localObject3 = this.nmf;
    s.checkNotNull(localObject3);
    localObject3 = (NearbyLivePreviewView)((View)localObject3).findViewWithTag("nearby-live-preview-view-tag");
    localObject4 = this.nmf;
    s.checkNotNull(localObject4);
    int j = ((View)localObject4).getHeight();
    float f;
    if (localObject3 != null) {
      if (((NearbyLivePreviewView)localObject3).getVideoRatioWH() == 0.0F)
      {
        i = 1;
        if (i != 0) {
          break label973;
        }
        f = j;
      }
    }
    for (i = (int)(((NearbyLivePreviewView)localObject3).getVideoRatioWH() * f);; i = ((View)localObject3).getWidth())
    {
      localObject3 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject3).width = i;
      ((FrameLayout.LayoutParams)localObject3).height = j;
      ((FrameLayout.LayoutParams)localObject3).gravity = 17;
      Log.i("FinderLiveCardPreViewAnimationHelper", "attachMaskView maskView[" + i + 'x' + j + "] videoView:[" + ((TextureView)localObject2).getWidth() + 'x' + ((TextureView)localObject2).getHeight() + "] surfaceTexture:" + ((TextureView)localObject2).getSurfaceTexture());
      localObject2 = this.CCZ;
      if (localObject2 != null) {
        ((RoundedCornerFrameLayout)localObject2).addView((View)this.EHP, (ViewGroup.LayoutParams)localObject3);
      }
      localObject2 = this.nmf;
      s.checkNotNull(localObject2);
      localObject2 = ((View)localObject2).getRootView();
      localObject3 = new FrameLayout.LayoutParams(-1, -1);
      if (localObject2 != null) {
        break label993;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(340068);
      throw paramView;
      i = 0;
      break;
      label973:
      localObject3 = this.nmf;
      s.checkNotNull(localObject3);
    }
    label993:
    ((ViewGroup)localObject2).addView((View)this.EHQ, (ViewGroup.LayoutParams)localObject3);
    paramView.getRenderView().removeVideoView();
    paramView.getRenderView().addVideoView((TextureView)localObject1);
    Log.i("FinderLiveCardPreViewAnimationHelper", "start");
    this.EHZ = false;
    if (this.CCZ == null)
    {
      Log.w("FinderLiveCardPreViewAnimationHelper", "createAnimationSet return for null.");
      paramView = null;
    }
    for (;;)
    {
      this.CCT = paramView;
      paramView = this.CCT;
      if (paramView != null) {
        paramView.start();
      }
      this.EHW = System.currentTimeMillis();
      AppMethodBeat.o(340068);
      return;
      paramView = this.CCZ;
      s.checkNotNull(paramView);
      localObject1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, this.EHT });
      paramView = this.CCZ;
      s.checkNotNull(paramView);
      localObject2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, this.EHT });
      i = this.context.getResources().getColor(f.a.translucent);
      j = this.context.getResources().getColor(ejQ());
      this.EHR = ValueAnimator.ofObject((TypeEvaluator)new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      paramView = this.EHR;
      if (paramView != null) {
        paramView.addUpdateListener(new a..ExternalSyntheticLambda0(this));
      }
      paramView = this.nmf;
      s.checkNotNull(paramView);
      paramView = (NearbyLivePreviewView)paramView.findViewWithTag("nearby-live-preview-view-tag");
      localObject3 = ValueAnimator.ofObject((TypeEvaluator)new IntEvaluator(), new Object[] { Integer.valueOf(0), Integer.valueOf(100) });
      if (localObject3 != null) {
        ((ValueAnimator)localObject3).addUpdateListener(new a..ExternalSyntheticLambda2(paramView));
      }
      paramView = new AnimatorSet();
      paramView.setDuration(this.EHU);
      paramView.playTogether(new Animator[] { (Animator)this.EHR, (Animator)localObject1, (Animator)localObject2, (Animator)localObject3 });
      paramView.addListener((Animator.AnimatorListener)new c(this));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper$createAnimationSet$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(339938);
      a.a(this.EIa, a.c(this.EIa));
      AppMethodBeat.o(339938);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(339929);
      paramAnimator = a.b(this.EIa);
      if (paramAnimator != null) {
        paramAnimator.setTag(e.e.nearby_live_card_click_timing, "loading");
      }
      AppMethodBeat.o(339929);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper$createReverseAnimationSet$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(339936);
      paramAnimator = a.b(this.EIa);
      if (paramAnimator != null) {
        paramAnimator.setTag(e.e.nearby_live_card_click_timing, "loaded");
      }
      a.d(this.EIa);
      AppMethodBeat.o(339936);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/guide/FinderLiveCardPreViewAnimationHelper$detachMaskView$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(339927);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FinderLiveCardPreViewAnimationHelper", s.X("detachMaskView#onSurfaceTextureAvailable surface:", paramSurfaceTexture));
      AppMethodBeat.o(339927);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(339940);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FinderLiveCardPreViewAnimationHelper", s.X("detachMaskView#onSurfaceTextureDestroyed surface:", paramSurfaceTexture));
      AppMethodBeat.o(339940);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(339933);
      s.u(paramSurfaceTexture, "surface");
      Log.i("FinderLiveCardPreViewAnimationHelper", "detachMaskView#onSurfaceTextureSizeChanged");
      AppMethodBeat.o(339933);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(339946);
      s.u(paramSurfaceTexture, "surface");
      AppMethodBeat.o(339946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.guide.a
 * JD-Core Version:    0.7.0.1
 */