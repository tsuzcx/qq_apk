package com.tencent.mm.plugin.finder.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "progressAnimation", "Landroid/animation/ValueAnimator;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "cancelProgressAnim", "", "dismissProgressBar", "dismissProgressBarThumb", "getCurrentProgress", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "showBigProgressBar", "isShowThumb", "showProgressBarThumb", "showSmallProgressBar", "updateProgress", "percent", "offsetSec", "allSec", "isWithAnim", "Companion", "SeekBarCallback", "plugin-finder_release"})
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, FinderViewPager.a
{
  private static final int sPS;
  public static final b sPT;
  boolean sPA;
  private c sPK;
  private final Rect sPL;
  private final f sPM;
  private final boolean sPN;
  private boolean sPO;
  private final f sPP;
  private final d sPQ;
  ValueAnimator sPR;
  
  static
  {
    AppMethodBeat.i(204856);
    sPT = new b((byte)0);
    sPS = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 4);
    AppMethodBeat.o(204856);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204853);
    this.sPL = new Rect();
    this.sPM = g.O((d.g.a.a)new h(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sPN = com.tencent.mm.plugin.finder.storage.b.cGw();
    this.sPP = g.O((d.g.a.a)new g(this));
    this.sPQ = new d(this);
    setId(2131307914);
    if (this.sPN) {
      setOnTouchListener((View.OnTouchListener)this.sPQ);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(204853);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204854);
    this.sPL = new Rect();
    this.sPM = g.O((d.g.a.a)new h(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sPN = com.tencent.mm.plugin.finder.storage.b.cGw();
    this.sPP = g.O((d.g.a.a)new g(this));
    this.sPQ = new d(this);
    setId(2131307914);
    if (this.sPN) {
      setOnTouchListener((View.OnTouchListener)this.sPQ);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(204854);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204855);
    this.sPL = new Rect();
    this.sPM = g.O((d.g.a.a)new h(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sPN = com.tencent.mm.plugin.finder.storage.b.cGw();
    this.sPP = g.O((d.g.a.a)new g(this));
    this.sPQ = new d(this);
    setId(2131307914);
    if (this.sPN) {
      setOnTouchListener((View.OnTouchListener)this.sPQ);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(204855);
  }
  
  private final void cMF()
  {
    AppMethodBeat.i(204838);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(255);
        AppMethodBeat.o(204838);
        return;
      }
    }
    AppMethodBeat.o(204838);
  }
  
  private final void cMG()
  {
    AppMethodBeat.i(204839);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(0);
        AppMethodBeat.o(204839);
        return;
      }
    }
    AppMethodBeat.o(204839);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(204833);
    GestureDetector localGestureDetector = (GestureDetector)this.sPP.getValue();
    AppMethodBeat.o(204833);
    return localGestureDetector;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204849);
    p.h(paramViewGroup, "parent");
    AppMethodBeat.o(204849);
    return true;
  }
  
  public final void cMH()
  {
    AppMethodBeat.i(204842);
    SeekBar localSeekBar1 = getVideoSeekBar();
    if (localSeekBar1 != null)
    {
      SeekBar localSeekBar2 = getVideoSeekBar();
      p.g(localSeekBar2, "videoSeekBar");
      localSeekBar2.setTag(null);
      if (localSeekBar1.getVisibility() == 4)
      {
        AppMethodBeat.o(204842);
        return;
      }
      localSeekBar1.setVisibility(4);
      AppMethodBeat.o(204842);
      return;
    }
    AppMethodBeat.o(204842);
  }
  
  public final void cMI()
  {
    AppMethodBeat.i(204843);
    ValueAnimator localValueAnimator = this.sPR;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(204843);
      return;
    }
    AppMethodBeat.o(204843);
  }
  
  public final boolean cMJ()
  {
    AppMethodBeat.i(204846);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(204846);
      return true;
    }
    AppMethodBeat.o(204846);
    return false;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(204850);
    if ((this.sPO) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(204850);
      return true;
    }
    AppMethodBeat.o(204850);
    return false;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(204845);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(204845);
      return i;
    }
    AppMethodBeat.o(204845);
    return 0;
  }
  
  final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(204832);
    SeekBar localSeekBar = (SeekBar)this.sPM.getValue();
    AppMethodBeat.o(204832);
    return localSeekBar;
  }
  
  public final void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(204841);
    if (paramBoolean) {
      cMF();
    }
    for (;;)
    {
      localObject = getVideoSeekBar();
      p.g(localObject, "videoSeekBar");
      if (!p.i(((SeekBar)localObject).getTag(), Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(204841);
      return;
      cMG();
    }
    Object localObject = getVideoSeekBar();
    p.g(localObject, "videoSeekBar");
    ((SeekBar)localObject).setVisibility(0);
    localObject = (d.g.a.a)new f(this);
    if (this.sPL.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new e(this, (d.g.a.a)localObject));
      AppMethodBeat.o(204841);
      return;
    }
    ((d.g.a.a)localObject).invoke();
    AppMethodBeat.o(204841);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204851);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(204851);
    return false;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204840);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (this.sPL.isEmpty())
    {
      localObject1 = this.sPL;
      localObject2 = getVideoSeekBar();
      p.g(localObject2, "videoSeekBar");
      localObject2 = ((SeekBar)localObject2).getProgressDrawable();
      p.g(localObject2, "videoSeekBar.progressDrawable");
      ((Rect)localObject1).set(((Drawable)localObject2).getBounds());
    }
    SeekBar localSeekBar;
    if (paramBoolean)
    {
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(204840);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(204840);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(2131306865);
      p.g(localObject2, "warnView");
      if (((View)localObject2).getVisibility() != 0) {
        break label278;
      }
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-sPS + ((View)localObject2).getHeight());
      localSeekBar = getVideoSeekBar();
      p.g(localSeekBar, "videoSeekBar");
      localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      ad.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin + ", warnView visibility=" + ((View)localObject2).getVisibility());
      AppMethodBeat.o(204840);
      return;
      label278:
      if (((FrameLayout.LayoutParams)localObject1).bottomMargin != -sPS)
      {
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-sPS);
        localSeekBar = getVideoSeekBar();
        p.g(localSeekBar, "videoSeekBar");
        localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204848);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(204848);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204836);
    p.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(204836);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(204852);
    paramMotionEvent = this.sPK;
    if ((paramMotionEvent == null) || (paramMotionEvent.cMA() != true))
    {
      ad.w("Finder.VideoSeekBar", "[onSingleTapConfirmed] is Disable Seek");
      AppMethodBeat.o(204852);
      return false;
    }
    boolean bool1;
    if (!this.sPA)
    {
      mk(true);
      paramMotionEvent = this.sPK;
      if (paramMotionEvent != null) {
        paramMotionEvent.mj(true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.sPA = bool1;
      paramMotionEvent = new StringBuilder("[onClick]...isShownSeekBar=").append(cMJ()).append(" isSeekMode=").append(this.sPA).append(" thumb=");
      SeekBar localSeekBar = getVideoSeekBar();
      p.g(localSeekBar, "videoSeekBar");
      ad.i("Finder.VideoSeekBar", localSeekBar.getAlpha());
      AppMethodBeat.o(204852);
      return true;
      mk(false);
      paramMotionEvent = this.sPK;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.mj(false);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204847);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(204847);
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(204835);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.sPK;
    if ((localObject1 == null) || (((c)localObject1).cMA() != true))
    {
      ad.w("Finder.VideoSeekBar", "[onStartTrackingTouch] is Disable Seek");
      AppMethodBeat.o(204835);
      return;
    }
    paramSeekBar.animate().cancel();
    this.sPO = true;
    localObject1 = getVideoSeekBar();
    if (localObject1 != null) {
      ((SeekBar)localObject1).setVisibility(0);
    }
    for (localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(true);
    }
    cMF();
    localObject1 = getVideoSeekBar();
    p.g(localObject1, "videoSeekBar");
    if (!p.i(((SeekBar)localObject1).getTag(), Boolean.TRUE))
    {
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setVisibility(0);
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getProgressDrawable();
      localObject2 = this.sPL;
      p.g(localObject1, "progressDrawable");
      ((Drawable)localObject1).setBounds(new Rect((Rect)localObject2));
      getVideoSeekBar().invalidate();
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setTag(Boolean.TRUE);
    }
    localObject1 = this.sPK;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((c)localObject1).getCurrentPosSec() / ((c)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((c)localObject1).cMz();
      AppMethodBeat.o(204835);
      return;
    }
    AppMethodBeat.o(204835);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(204837);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.sPK;
    if ((localObject1 == null) || (((c)localObject1).cMA() != true))
    {
      ad.w("Finder.VideoSeekBar", "[onStopTrackingTouch] is Disable Seek");
      AppMethodBeat.o(204837);
      return;
    }
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    ad.i("Finder.VideoSeekBar", "[onStopTrackingTouch] percent=".concat(String.valueOf(f)));
    for (localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(false);
    }
    mk(this.sPA);
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.sPK;
    if (paramSeekBar != null) {
      paramSeekBar.bd(f);
    }
    this.sPO = false;
    AppMethodBeat.o(204837);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(204844);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(paramInt);
      AppMethodBeat.o(204844);
      return;
    }
    AppMethodBeat.o(204844);
  }
  
  public final void setSeekBarCallback(c paramc)
  {
    AppMethodBeat.i(204834);
    p.h(paramc, "seekBarCallback");
    this.sPK = paramc;
    AppMethodBeat.o(204834);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.sPA = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$updateProgress$1$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(SeekBar paramSeekBar) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(204825);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(204825);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      this.sPU.setProgress(i);
      AppMethodBeat.o(204825);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_DURATION", "", "TAG", "", "_4dp", "get_4dp", "()I", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosSec", "", "getVideoDurationSec", "isEnableSeek", "", "onEnterSeekMode", "", "isEnter", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean T(MotionEvent paramMotionEvent);
    
    public abstract void bd(float paramFloat);
    
    public abstract boolean cMA();
    
    public abstract void cMz();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
    
    public abstract void mj(boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements View.OnTouchListener
  {
    private final int padding;
    private final Rect rect;
    private boolean sPV;
    private int sPW;
    private int sPX;
    private int sPY;
    private int sPZ;
    
    d()
    {
      AppMethodBeat.i(204827);
      this.rect = new Rect();
      Context localContext = localContext.getContext();
      p.g(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(2131165296));
      AppMethodBeat.o(204827);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204826);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramView, "v");
      p.h(paramMotionEvent, "event");
      localObject = FinderVideoSeekBar.d(this.sQa);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.sQa.sPA) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        if (FinderVideoSeekBar.e(this.sQa) != null)
        {
          paramView = FinderVideoSeekBar.e(this.sQa);
          if (paramView == null) {
            break label292;
          }
        }
        label292:
        for (paramView = Boolean.valueOf(paramView.T(paramMotionEvent));; paramView = null)
        {
          if (paramView == null) {
            p.gfZ();
          }
          if (paramView.booleanValue()) {
            break;
          }
          this.sPW = ((int)paramMotionEvent.getX());
          this.sPY = ((int)paramMotionEvent.getY());
          this.sPX = this.sPW;
          this.sPZ = 0;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(204826);
          return true;
        }
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.sPX != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.sPZ != 100)
        {
          i = this.sPZ;
          if (i >= 0) {
            break label434;
          }
        }
      }
      while (this.sPZ == 100)
      {
        paramView = FinderVideoSeekBar.a(this.sQa);
        if (paramView != null)
        {
          if (!this.sPV) {
            this.sQa.onStartTrackingTouch(paramView);
          }
          this.sPV = true;
          paramView.setProgress(d.h.a.co(((int)paramMotionEvent.getX() - this.sPW) * 0.7F) + paramView.getProgress());
          this.sPW = ((int)paramMotionEvent.getX());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(204826);
          return true;
          label434:
          if (4 >= i)
          {
            i = Math.abs(this.sPX - (int)paramMotionEvent.getX());
            int j = Math.abs(this.sPY - (int)paramMotionEvent.getY());
            if ((i >= 8) && ((j <= 0) || (i / j >= 2))) {}
            for (i = 100;; i = this.sPZ + 1)
            {
              this.sPZ = i;
              if (this.sPZ == 100) {
                break;
              }
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(204826);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.sPZ = 0;
              this.sPX = 0;
              localObject = this.sQa.getParent();
              paramView = (View)localObject;
              if (!(localObject instanceof FinderMediaBanner)) {
                paramView = null;
              }
              paramView = (FinderMediaBanner)paramView;
              if (paramView != null) {
                paramView.setFrozenRecyclerView(false);
              }
              if (this.sPV)
              {
                paramView = FinderVideoSeekBar.a(this.sQa);
                if (paramView != null) {
                  this.sQa.onStopTrackingTouch(paramView);
                }
                this.sPV = false;
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(204826);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.sPX - (int)paramMotionEvent.getX());
                if ((Math.abs(this.sPY - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.sQa.performClick();
                }
              }
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(204826);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showSmallProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class e
    implements View.OnLayoutChangeListener
  {
    e(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(204828);
      this.sQb.invoke();
      this.sQa.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(204828);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<GestureDetector>
  {
    g(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<SeekBar>
  {
    h(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */