package com.tencent.mm.plugin.finder.video;

import android.animation.ValueAnimator;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "progressAnimation", "Landroid/animation/ValueAnimator;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "cancelProgressAnim", "", "dismissProgressBar", "dismissProgressBarThumb", "getCurrentProgress", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "showBigProgressBar", "isShowThumb", "showProgressBarThumb", "showSmallProgressBar", "updateProgress", "percent", "offsetSec", "allSec", "isWithAnim", "Companion", "SeekBarCallback", "plugin-finder_release"})
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, FinderViewPager.a
{
  private static final int tbf;
  public static final FinderVideoSeekBar.b tbg;
  boolean taN;
  private c taX;
  private final Rect taY;
  private final f taZ;
  private final boolean tba;
  private boolean tbb;
  private final f tbc;
  private final d tbd;
  ValueAnimator tbe;
  
  static
  {
    AppMethodBeat.i(205481);
    tbg = new FinderVideoSeekBar.b((byte)0);
    tbf = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 4);
    AppMethodBeat.o(205481);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205478);
    this.taY = new Rect();
    this.taZ = g.O((d.g.a.a)new h(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tba = com.tencent.mm.plugin.finder.storage.b.cIt();
    this.tbc = g.O((d.g.a.a)new g(this));
    this.tbd = new d(this);
    setId(2131307914);
    if (this.tba) {
      setOnTouchListener((View.OnTouchListener)this.tbd);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(205478);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205479);
    this.taY = new Rect();
    this.taZ = g.O((d.g.a.a)new h(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tba = com.tencent.mm.plugin.finder.storage.b.cIt();
    this.tbc = g.O((d.g.a.a)new g(this));
    this.tbd = new d(this);
    setId(2131307914);
    if (this.tba) {
      setOnTouchListener((View.OnTouchListener)this.tbd);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(205479);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205480);
    this.taY = new Rect();
    this.taZ = g.O((d.g.a.a)new h(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tba = com.tencent.mm.plugin.finder.storage.b.cIt();
    this.tbc = g.O((d.g.a.a)new g(this));
    this.tbd = new d(this);
    setId(2131307914);
    if (this.tba) {
      setOnTouchListener((View.OnTouchListener)this.tbd);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(205480);
  }
  
  private final void cPo()
  {
    AppMethodBeat.i(205463);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(255);
        AppMethodBeat.o(205463);
        return;
      }
    }
    AppMethodBeat.o(205463);
  }
  
  private final void cPp()
  {
    AppMethodBeat.i(205464);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(0);
        AppMethodBeat.o(205464);
        return;
      }
    }
    AppMethodBeat.o(205464);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(205458);
    GestureDetector localGestureDetector = (GestureDetector)this.tbc.getValue();
    AppMethodBeat.o(205458);
    return localGestureDetector;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(205474);
    p.h(paramViewGroup, "parent");
    AppMethodBeat.o(205474);
    return true;
  }
  
  public final void cPq()
  {
    AppMethodBeat.i(205467);
    SeekBar localSeekBar1 = getVideoSeekBar();
    if (localSeekBar1 != null)
    {
      SeekBar localSeekBar2 = getVideoSeekBar();
      p.g(localSeekBar2, "videoSeekBar");
      localSeekBar2.setTag(null);
      if (localSeekBar1.getVisibility() == 4)
      {
        AppMethodBeat.o(205467);
        return;
      }
      localSeekBar1.setVisibility(4);
      AppMethodBeat.o(205467);
      return;
    }
    AppMethodBeat.o(205467);
  }
  
  public final void cPr()
  {
    AppMethodBeat.i(205468);
    ValueAnimator localValueAnimator = this.tbe;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(205468);
      return;
    }
    AppMethodBeat.o(205468);
  }
  
  public final boolean cPs()
  {
    AppMethodBeat.i(205471);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(205471);
      return true;
    }
    AppMethodBeat.o(205471);
    return false;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(205475);
    if ((this.tbb) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(205475);
      return true;
    }
    AppMethodBeat.o(205475);
    return false;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(205470);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(205470);
      return i;
    }
    AppMethodBeat.o(205470);
    return 0;
  }
  
  final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(205457);
    SeekBar localSeekBar = (SeekBar)this.taZ.getValue();
    AppMethodBeat.o(205457);
    return localSeekBar;
  }
  
  public final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(205466);
    if (paramBoolean) {
      cPo();
    }
    for (;;)
    {
      localObject = getVideoSeekBar();
      p.g(localObject, "videoSeekBar");
      if (!p.i(((SeekBar)localObject).getTag(), Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(205466);
      return;
      cPp();
    }
    Object localObject = getVideoSeekBar();
    p.g(localObject, "videoSeekBar");
    ((SeekBar)localObject).setVisibility(0);
    localObject = (d.g.a.a)new f(this);
    if (this.taY.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new e(this, (d.g.a.a)localObject));
      AppMethodBeat.o(205466);
      return;
    }
    ((d.g.a.a)localObject).invoke();
    AppMethodBeat.o(205466);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205476);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(205476);
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
    AppMethodBeat.i(205465);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (this.taY.isEmpty())
    {
      localObject1 = this.taY;
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
        AppMethodBeat.o(205465);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(205465);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(2131306865);
      p.g(localObject2, "warnView");
      if (((View)localObject2).getVisibility() != 0) {
        break label275;
      }
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-tbf + ((View)localObject2).getHeight());
      localSeekBar = getVideoSeekBar();
      p.g(localSeekBar, "videoSeekBar");
      localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      ae.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin + ", warnView visibility=" + ((View)localObject2).getVisibility());
      AppMethodBeat.o(205465);
      return;
      label275:
      if (((FrameLayout.LayoutParams)localObject1).bottomMargin != -tbf)
      {
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-tbf);
        localSeekBar = getVideoSeekBar();
        p.g(localSeekBar, "videoSeekBar");
        localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205473);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(205473);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205461);
    p.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(205461);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(205477);
    paramMotionEvent = this.taX;
    if ((paramMotionEvent == null) || (paramMotionEvent.cPj() != true))
    {
      ae.w("Finder.VideoSeekBar", "[onSingleTapConfirmed] is Disable Seek");
      AppMethodBeat.o(205477);
      return false;
    }
    boolean bool1;
    if (!this.taN)
    {
      mp(true);
      paramMotionEvent = this.taX;
      if (paramMotionEvent != null) {
        paramMotionEvent.mo(true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.taN = bool1;
      paramMotionEvent = new StringBuilder("[onClick]...isShownSeekBar=").append(cPs()).append(" isSeekMode=").append(this.taN).append(" thumb=");
      SeekBar localSeekBar = getVideoSeekBar();
      p.g(localSeekBar, "videoSeekBar");
      ae.i("Finder.VideoSeekBar", localSeekBar.getAlpha());
      AppMethodBeat.o(205477);
      return true;
      mp(false);
      paramMotionEvent = this.taX;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.mo(false);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205472);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(205472);
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(205460);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.taX;
    if ((localObject1 == null) || (((c)localObject1).cPj() != true))
    {
      ae.w("Finder.VideoSeekBar", "[onStartTrackingTouch] is Disable Seek");
      AppMethodBeat.o(205460);
      return;
    }
    paramSeekBar.animate().cancel();
    this.tbb = true;
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
    cPo();
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
      localObject2 = this.taY;
      p.g(localObject1, "progressDrawable");
      ((Drawable)localObject1).setBounds(new Rect((Rect)localObject2));
      getVideoSeekBar().invalidate();
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setTag(Boolean.TRUE);
    }
    localObject1 = this.taX;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((c)localObject1).getCurrentPosSec() / ((c)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((c)localObject1).cPi();
      AppMethodBeat.o(205460);
      return;
    }
    AppMethodBeat.o(205460);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(205462);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.taX;
    if ((localObject1 == null) || (((c)localObject1).cPj() != true))
    {
      ae.w("Finder.VideoSeekBar", "[onStopTrackingTouch] is Disable Seek");
      AppMethodBeat.o(205462);
      return;
    }
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    ae.i("Finder.VideoSeekBar", "[onStopTrackingTouch] percent=".concat(String.valueOf(f)));
    for (localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(false);
    }
    mp(this.taN);
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.taX;
    if (paramSeekBar != null) {
      paramSeekBar.bd(f);
    }
    this.tbb = false;
    AppMethodBeat.o(205462);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(205469);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(paramInt);
      AppMethodBeat.o(205469);
      return;
    }
    AppMethodBeat.o(205469);
  }
  
  public final void setSeekBarCallback(c paramc)
  {
    AppMethodBeat.i(205459);
    p.h(paramc, "seekBarCallback");
    this.taX = paramc;
    AppMethodBeat.o(205459);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.taN = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosSec", "", "getVideoDurationSec", "isEnableSeek", "", "onEnterSeekMode", "", "isEnter", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean R(MotionEvent paramMotionEvent);
    
    public abstract void bd(float paramFloat);
    
    public abstract void cPi();
    
    public abstract boolean cPj();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
    
    public abstract void mo(boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements View.OnTouchListener
  {
    private int jwh;
    private int jwi;
    private final int padding;
    private final Rect rect;
    private boolean tbi;
    private int tbj;
    private int tbk;
    
    d()
    {
      AppMethodBeat.i(205452);
      this.rect = new Rect();
      Context localContext = localContext.getContext();
      p.g(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(2131165296));
      AppMethodBeat.o(205452);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205451);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramView, "v");
      p.h(paramMotionEvent, "event");
      localObject = FinderVideoSeekBar.d(this.tbl);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.tbl.taN) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        if (FinderVideoSeekBar.e(this.tbl) != null)
        {
          paramView = FinderVideoSeekBar.e(this.tbl);
          if (paramView == null) {
            break label292;
          }
        }
        label292:
        for (paramView = Boolean.valueOf(paramView.R(paramMotionEvent));; paramView = null)
        {
          if (paramView == null) {
            p.gkB();
          }
          if (paramView.booleanValue()) {
            break;
          }
          this.tbj = ((int)paramMotionEvent.getX());
          this.jwi = ((int)paramMotionEvent.getY());
          this.jwh = this.tbj;
          this.tbk = 0;
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(205451);
          return true;
        }
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.jwh != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.tbk != 100)
        {
          i = this.tbk;
          if (i >= 0) {
            break label434;
          }
        }
      }
      while (this.tbk == 100)
      {
        paramView = FinderVideoSeekBar.a(this.tbl);
        if (paramView != null)
        {
          if (!this.tbi) {
            this.tbl.onStartTrackingTouch(paramView);
          }
          this.tbi = true;
          paramView.setProgress(d.h.a.cm(((int)paramMotionEvent.getX() - this.tbj) * 0.7F) + paramView.getProgress());
          this.tbj = ((int)paramMotionEvent.getX());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(205451);
          return true;
          label434:
          if (4 >= i)
          {
            i = Math.abs(this.jwh - (int)paramMotionEvent.getX());
            int j = Math.abs(this.jwi - (int)paramMotionEvent.getY());
            if ((i >= 8) && ((j <= 0) || (i / j >= 2))) {}
            for (i = 100;; i = this.tbk + 1)
            {
              this.tbk = i;
              if (this.tbk == 100) {
                break;
              }
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(205451);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.tbk = 0;
              this.jwh = 0;
              localObject = this.tbl.getParent();
              paramView = (View)localObject;
              if (!(localObject instanceof FinderMediaBanner)) {
                paramView = null;
              }
              paramView = (FinderMediaBanner)paramView;
              if (paramView != null) {
                paramView.setFrozenRecyclerView(false);
              }
              if (this.tbi)
              {
                paramView = FinderVideoSeekBar.a(this.tbl);
                if (paramView != null) {
                  this.tbl.onStopTrackingTouch(paramView);
                }
                this.tbi = false;
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205451);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.jwh - (int)paramMotionEvent.getX());
                if ((Math.abs(this.jwi - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.tbl.performClick();
                }
              }
            }
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(205451);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showSmallProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class e
    implements View.OnLayoutChangeListener
  {
    e(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(205453);
      this.tbm.invoke();
      this.tbl.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(205453);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<GestureDetector>
  {
    g(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */