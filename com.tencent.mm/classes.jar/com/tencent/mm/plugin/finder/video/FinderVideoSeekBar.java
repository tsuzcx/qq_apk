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
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "progressAnimation", "Landroid/animation/ValueAnimator;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "cancelProgressAnim", "", "dismissProgressBar", "dismissProgressBarThumb", "getCurrentProgress", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "showBigProgressBar", "isShowThumb", "showProgressBarThumb", "showSmallProgressBar", "updateProgress", "percent", "offsetSec", "allSec", "isWithAnim", "Companion", "SeekBarCallback", "plugin-finder_release"})
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, FinderViewPager.a
{
  public static final b LcP;
  private static final int tRL;
  boolean LcA;
  private c LcI;
  private final Rect LcJ;
  private final f LcK;
  private final boolean LcL;
  private boolean LcM;
  private final d LcN;
  ValueAnimator LcO;
  private final f rFB;
  
  static
  {
    AppMethodBeat.i(199818);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderVideoSeekBar.class), "videoSeekBar", "getVideoSeekBar()Landroid/widget/SeekBar;")), (d.l.k)w.a(new u(w.bk(FinderVideoSeekBar.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")) };
    LcP = new b((byte)0);
    tRL = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 4);
    AppMethodBeat.o(199818);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199837);
    this.LcJ = new Rect();
    this.LcK = g.E((d.g.a.a)new h(this));
    paramContext = b.qJA;
    this.LcL = b.fUx();
    this.rFB = g.E((d.g.a.a)new g(this));
    this.LcN = new d(this);
    setId(2131307822);
    if (this.LcL) {
      setOnTouchListener((View.OnTouchListener)this.LcN);
    }
    LayoutInflater.from(getContext()).inflate(2131496268, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    d.g.b.k.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(199837);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199838);
    this.LcJ = new Rect();
    this.LcK = g.E((d.g.a.a)new h(this));
    paramContext = b.qJA;
    this.LcL = b.fUx();
    this.rFB = g.E((d.g.a.a)new g(this));
    this.LcN = new d(this);
    setId(2131307822);
    if (this.LcL) {
      setOnTouchListener((View.OnTouchListener)this.LcN);
    }
    LayoutInflater.from(getContext()).inflate(2131496268, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    d.g.b.k.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(199838);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199839);
    this.LcJ = new Rect();
    this.LcK = g.E((d.g.a.a)new h(this));
    paramContext = b.qJA;
    this.LcL = b.fUx();
    this.rFB = g.E((d.g.a.a)new g(this));
    this.LcN = new d(this);
    setId(2131307822);
    if (this.LcL) {
      setOnTouchListener((View.OnTouchListener)this.LcN);
    }
    LayoutInflater.from(getContext()).inflate(2131496268, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    d.g.b.k.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(199839);
  }
  
  private final void fWv()
  {
    AppMethodBeat.i(199825);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(255);
        AppMethodBeat.o(199825);
        return;
      }
    }
    AppMethodBeat.o(199825);
  }
  
  private final void fWw()
  {
    AppMethodBeat.i(199826);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(0);
        AppMethodBeat.o(199826);
        return;
      }
    }
    AppMethodBeat.o(199826);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(199820);
    GestureDetector localGestureDetector = (GestureDetector)this.rFB.getValue();
    AppMethodBeat.o(199820);
    return localGestureDetector;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(199834);
    d.g.b.k.h(paramViewGroup, "parent");
    AppMethodBeat.o(199834);
    return true;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(199835);
    if ((this.LcM) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(199835);
      return true;
    }
    AppMethodBeat.o(199835);
    return false;
  }
  
  public final void fWx()
  {
    AppMethodBeat.i(199829);
    SeekBar localSeekBar1 = getVideoSeekBar();
    if (localSeekBar1 != null)
    {
      SeekBar localSeekBar2 = getVideoSeekBar();
      d.g.b.k.g(localSeekBar2, "videoSeekBar");
      localSeekBar2.setTag(null);
      if (localSeekBar1.getVisibility() == 4)
      {
        AppMethodBeat.o(199829);
        return;
      }
      localSeekBar1.setVisibility(4);
      AppMethodBeat.o(199829);
      return;
    }
    AppMethodBeat.o(199829);
  }
  
  public final void fWy()
  {
    AppMethodBeat.i(199830);
    ValueAnimator localValueAnimator = this.LcO;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(199830);
      return;
    }
    AppMethodBeat.o(199830);
  }
  
  public final boolean fWz()
  {
    AppMethodBeat.i(199833);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(199833);
      return true;
    }
    AppMethodBeat.o(199833);
    return false;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(199832);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(199832);
      return i;
    }
    AppMethodBeat.o(199832);
    return 0;
  }
  
  final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(199819);
    SeekBar localSeekBar = (SeekBar)this.LcK.getValue();
    AppMethodBeat.o(199819);
    return localSeekBar;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
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
    AppMethodBeat.i(199827);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (this.LcJ.isEmpty())
    {
      localObject1 = this.LcJ;
      localObject2 = getVideoSeekBar();
      d.g.b.k.g(localObject2, "videoSeekBar");
      localObject2 = ((SeekBar)localObject2).getProgressDrawable();
      d.g.b.k.g(localObject2, "videoSeekBar.progressDrawable");
      ((Rect)localObject1).set(((Drawable)localObject2).getBounds());
    }
    if (paramBoolean)
    {
      localObject1 = getVideoSeekBar();
      d.g.b.k.g(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(199827);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(199827);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(2131306865);
      paramInt2 = -tRL;
      if (localObject2 == null) {
        break label254;
      }
    }
    label254:
    for (paramInt1 = ((View)localObject2).getHeight();; paramInt1 = 0)
    {
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = (paramInt1 + paramInt2);
      localObject2 = getVideoSeekBar();
      d.g.b.k.g(localObject2, "videoSeekBar");
      ((SeekBar)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ad.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin);
      AppMethodBeat.o(199827);
      return;
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199823);
    d.g.b.k.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(199823);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(199836);
    boolean bool1;
    if (!this.LcA)
    {
      yN(true);
      paramMotionEvent = this.LcI;
      if (paramMotionEvent != null) {
        paramMotionEvent.yM(true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.LcA = bool1;
      paramMotionEvent = new StringBuilder("[onClick]...isShownSeekBar=").append(fWz()).append(" isSeekMode=").append(this.LcA).append(" thumb=");
      SeekBar localSeekBar = getVideoSeekBar();
      d.g.b.k.g(localSeekBar, "videoSeekBar");
      ad.i("Finder.VideoSeekBar", localSeekBar.getAlpha());
      AppMethodBeat.o(199836);
      return true;
      yN(false);
      paramMotionEvent = this.LcI;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.yM(false);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(199822);
    d.g.b.k.h(paramSeekBar, "seekBar");
    paramSeekBar.animate().cancel();
    this.LcM = true;
    Object localObject1 = getVideoSeekBar();
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
    fWv();
    localObject1 = getVideoSeekBar();
    d.g.b.k.g(localObject1, "videoSeekBar");
    if (!d.g.b.k.g(((SeekBar)localObject1).getTag(), Boolean.TRUE))
    {
      localObject1 = getVideoSeekBar();
      d.g.b.k.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setVisibility(0);
      localObject1 = getVideoSeekBar();
      d.g.b.k.g(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getProgressDrawable();
      localObject2 = this.LcJ;
      d.g.b.k.g(localObject1, "progressDrawable");
      ((Drawable)localObject1).setBounds(new Rect((Rect)localObject2));
      getVideoSeekBar().invalidate();
      localObject1 = getVideoSeekBar();
      d.g.b.k.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setTag(Boolean.TRUE);
    }
    localObject1 = this.LcI;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((c)localObject1).getCurrentPosSec() / ((c)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((c)localObject1).fWs();
      AppMethodBeat.o(199822);
      return;
    }
    AppMethodBeat.o(199822);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(199824);
    d.g.b.k.h(paramSeekBar, "seekBar");
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    ad.i("Finder.VideoSeekBar", "[onStopTrackingTouch] percent=".concat(String.valueOf(f)));
    for (Object localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(false);
    }
    yN(this.LcA);
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.LcI;
    if (paramSeekBar != null) {
      paramSeekBar.ca(f);
    }
    this.LcM = false;
    AppMethodBeat.o(199824);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(199831);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(paramInt);
      AppMethodBeat.o(199831);
      return;
    }
    AppMethodBeat.o(199831);
  }
  
  public final void setSeekBarCallback(c paramc)
  {
    AppMethodBeat.i(199821);
    d.g.b.k.h(paramc, "seekBarCallback");
    this.LcI = paramc;
    AppMethodBeat.o(199821);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.LcA = paramBoolean;
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(199828);
    if (paramBoolean) {
      fWv();
    }
    for (;;)
    {
      localObject = getVideoSeekBar();
      d.g.b.k.g(localObject, "videoSeekBar");
      if (!d.g.b.k.g(((SeekBar)localObject).getTag(), Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(199828);
      return;
      fWw();
    }
    Object localObject = getVideoSeekBar();
    d.g.b.k.g(localObject, "videoSeekBar");
    ((SeekBar)localObject).setVisibility(0);
    localObject = (d.g.a.a)new f(this);
    if (this.LcJ.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new e(this, (d.g.a.a)localObject));
      AppMethodBeat.o(199828);
      return;
    }
    ((d.g.a.a)localObject).invoke();
    AppMethodBeat.o(199828);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$updateProgress$1$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(SeekBar paramSeekBar) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(199811);
      d.g.b.k.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(199811);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      this.LcQ.setProgress(i);
      AppMethodBeat.o(199811);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_DURATION", "", "TAG", "", "_4dp", "get_4dp", "()I", "plugin-finder_release"})
  public static final class b {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosSec", "", "getVideoDurationSec", "onEnterSeekMode", "", "isEnter", "", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract void ca(float paramFloat);
    
    public abstract void fWs();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
    
    public abstract void yM(boolean paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements View.OnTouchListener
  {
    private int BcZ;
    private boolean LcR;
    private int LcS;
    private final int padding;
    private final Rect rect;
    private int uCK;
    private int uCL;
    
    d()
    {
      AppMethodBeat.i(199813);
      this.rect = new Rect();
      Context localContext = localContext.getContext();
      d.g.b.k.g(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(2131165296));
      AppMethodBeat.o(199813);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(199812);
      d.g.b.k.h(paramView, "v");
      d.g.b.k.h(paramMotionEvent, "event");
      FinderVideoSeekBar.d(this.LcT).onTouchEvent(paramMotionEvent);
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.LcT.LcA) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        this.BcZ = ((int)paramMotionEvent.getX());
        this.uCL = ((int)paramMotionEvent.getY());
        this.uCK = this.BcZ;
        this.LcS = 0;
        AppMethodBeat.o(199812);
        return true;
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.uCK != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.LcS != 100)
        {
          i = this.LcS;
          if (i >= 0) {
            break label254;
          }
        }
      }
      while (this.LcS == 100)
      {
        paramView = FinderVideoSeekBar.a(this.LcT);
        if (paramView != null)
        {
          if (!this.LcR) {
            this.LcT.onStartTrackingTouch(paramView);
          }
          this.LcR = true;
          paramView.setProgress(d.h.a.bU(((int)paramMotionEvent.getX() - this.BcZ) * 0.7F) + paramView.getProgress());
          this.BcZ = ((int)paramMotionEvent.getX());
          AppMethodBeat.o(199812);
          return true;
          label254:
          if (4 >= i)
          {
            i = Math.abs(this.uCK - (int)paramMotionEvent.getX());
            int j = Math.abs(this.uCL - (int)paramMotionEvent.getY());
            if ((i >= 8) && ((j <= 0) || (i / j >= 2))) {}
            for (i = 100;; i = this.LcS + 1)
            {
              this.LcS = i;
              if (this.LcS == 100) {
                break;
              }
              AppMethodBeat.o(199812);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.LcS = 0;
              this.uCK = 0;
              ViewParent localViewParent = this.LcT.getParent();
              paramView = localViewParent;
              if (!(localViewParent instanceof FinderMediaBanner)) {
                paramView = null;
              }
              paramView = (FinderMediaBanner)paramView;
              if (paramView != null) {
                paramView.setFrozenRecyclerView(false);
              }
              if (this.LcR)
              {
                paramView = FinderVideoSeekBar.a(this.LcT);
                if (paramView != null) {
                  this.LcT.onStopTrackingTouch(paramView);
                }
                this.LcR = false;
                AppMethodBeat.o(199812);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.uCK - (int)paramMotionEvent.getX());
                if ((Math.abs(this.uCL - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.LcT.performClick();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(199812);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showSmallProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class e
    implements View.OnLayoutChangeListener
  {
    e(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(199814);
      this.LcU.invoke();
      this.LcT.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(199814);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<GestureDetector>
  {
    g(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<SeekBar>
  {
    h(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */