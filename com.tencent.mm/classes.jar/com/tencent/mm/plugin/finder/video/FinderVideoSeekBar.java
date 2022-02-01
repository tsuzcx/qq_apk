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
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "progressAnimation", "Landroid/animation/ValueAnimator;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "cancelProgressAnim", "", "dismissProgressBar", "dismissProgressBarThumb", "getCurrentProgress", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "showBigProgressBar", "isShowThumb", "showProgressBarThumb", "showSmallProgressBar", "updateProgress", "percent", "offsetSec", "allSec", "isWithAnim", "Companion", "SeekBarCallback", "plugin-finder_release"})
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, FinderViewPager.a
{
  private static final int rTi;
  public static final FinderVideoSeekBar.b rTj;
  boolean rSQ;
  private c rTa;
  private final Rect rTb;
  private final f rTc;
  private final boolean rTd;
  private boolean rTe;
  private final f rTf;
  private final d rTg;
  ValueAnimator rTh;
  
  static
  {
    AppMethodBeat.i(203883);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderVideoSeekBar.class), "videoSeekBar", "getVideoSeekBar()Landroid/widget/SeekBar;")), (d.l.k)w.a(new u(w.bn(FinderVideoSeekBar.class), "touchDetector", "getTouchDetector()Landroid/view/GestureDetector;")) };
    rTj = new FinderVideoSeekBar.b((byte)0);
    rTi = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 4);
    AppMethodBeat.o(203883);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(203902);
    this.rTb = new Rect();
    this.rTc = g.K((d.g.a.a)new h(this));
    paramContext = b.rCU;
    this.rTd = b.czU();
    this.rTf = g.K((d.g.a.a)new g(this));
    this.rTg = new d(this);
    setId(2131307914);
    if (this.rTd) {
      setOnTouchListener((View.OnTouchListener)this.rTg);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    d.g.b.k.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(203902);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203903);
    this.rTb = new Rect();
    this.rTc = g.K((d.g.a.a)new h(this));
    paramContext = b.rCU;
    this.rTd = b.czU();
    this.rTf = g.K((d.g.a.a)new g(this));
    this.rTg = new d(this);
    setId(2131307914);
    if (this.rTd) {
      setOnTouchListener((View.OnTouchListener)this.rTg);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    d.g.b.k.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(203903);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203904);
    this.rTb = new Rect();
    this.rTc = g.K((d.g.a.a)new h(this));
    paramContext = b.rCU;
    this.rTd = b.czU();
    this.rTf = g.K((d.g.a.a)new g(this));
    this.rTg = new d(this);
    setId(2131307914);
    if (this.rTd) {
      setOnTouchListener((View.OnTouchListener)this.rTg);
    }
    LayoutInflater.from(getContext()).inflate(2131496269, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    d.g.b.k.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(203904);
  }
  
  private final void cEl()
  {
    AppMethodBeat.i(203890);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(255);
        AppMethodBeat.o(203890);
        return;
      }
    }
    AppMethodBeat.o(203890);
  }
  
  private final void cEm()
  {
    AppMethodBeat.i(203891);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(0);
        AppMethodBeat.o(203891);
        return;
      }
    }
    AppMethodBeat.o(203891);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(203885);
    GestureDetector localGestureDetector = (GestureDetector)this.rTf.getValue();
    AppMethodBeat.o(203885);
    return localGestureDetector;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203899);
    d.g.b.k.h(paramViewGroup, "parent");
    AppMethodBeat.o(203899);
    return true;
  }
  
  public final void cEn()
  {
    AppMethodBeat.i(203894);
    SeekBar localSeekBar1 = getVideoSeekBar();
    if (localSeekBar1 != null)
    {
      SeekBar localSeekBar2 = getVideoSeekBar();
      d.g.b.k.g(localSeekBar2, "videoSeekBar");
      localSeekBar2.setTag(null);
      if (localSeekBar1.getVisibility() == 4)
      {
        AppMethodBeat.o(203894);
        return;
      }
      localSeekBar1.setVisibility(4);
      AppMethodBeat.o(203894);
      return;
    }
    AppMethodBeat.o(203894);
  }
  
  public final void cEo()
  {
    AppMethodBeat.i(203895);
    ValueAnimator localValueAnimator = this.rTh;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      AppMethodBeat.o(203895);
      return;
    }
    AppMethodBeat.o(203895);
  }
  
  public final boolean cEp()
  {
    AppMethodBeat.i(203898);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(203898);
      return true;
    }
    AppMethodBeat.o(203898);
    return false;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(203900);
    if ((this.rTe) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(203900);
      return true;
    }
    AppMethodBeat.o(203900);
    return false;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(203897);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(203897);
      return i;
    }
    AppMethodBeat.o(203897);
    return 0;
  }
  
  final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(203884);
    SeekBar localSeekBar = (SeekBar)this.rTc.getValue();
    AppMethodBeat.o(203884);
    return localSeekBar;
  }
  
  public final void lS(boolean paramBoolean)
  {
    AppMethodBeat.i(203893);
    if (paramBoolean) {
      cEl();
    }
    for (;;)
    {
      localObject = getVideoSeekBar();
      d.g.b.k.g(localObject, "videoSeekBar");
      if (!d.g.b.k.g(((SeekBar)localObject).getTag(), Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(203893);
      return;
      cEm();
    }
    Object localObject = getVideoSeekBar();
    d.g.b.k.g(localObject, "videoSeekBar");
    ((SeekBar)localObject).setVisibility(0);
    localObject = (d.g.a.a)new f(this);
    if (this.rTb.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new e(this, (d.g.a.a)localObject));
      AppMethodBeat.o(203893);
      return;
    }
    ((d.g.a.a)localObject).invoke();
    AppMethodBeat.o(203893);
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
    AppMethodBeat.i(203892);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (this.rTb.isEmpty())
    {
      localObject1 = this.rTb;
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
        AppMethodBeat.o(203892);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(203892);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(2131306865);
      paramInt2 = -rTi;
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
      ac.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin);
      AppMethodBeat.o(203892);
      return;
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203888);
    d.g.b.k.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(203888);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(203901);
    boolean bool1;
    if (!this.rSQ)
    {
      lS(true);
      paramMotionEvent = this.rTa;
      if (paramMotionEvent != null) {
        paramMotionEvent.lR(true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.rSQ = bool1;
      paramMotionEvent = new StringBuilder("[onClick]...isShownSeekBar=").append(cEp()).append(" isSeekMode=").append(this.rSQ).append(" thumb=");
      SeekBar localSeekBar = getVideoSeekBar();
      d.g.b.k.g(localSeekBar, "videoSeekBar");
      ac.i("Finder.VideoSeekBar", localSeekBar.getAlpha());
      AppMethodBeat.o(203901);
      return true;
      lS(false);
      paramMotionEvent = this.rTa;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.lR(false);
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
    AppMethodBeat.i(203887);
    d.g.b.k.h(paramSeekBar, "seekBar");
    paramSeekBar.animate().cancel();
    this.rTe = true;
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
    cEl();
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
      localObject2 = this.rTb;
      d.g.b.k.g(localObject1, "progressDrawable");
      ((Drawable)localObject1).setBounds(new Rect((Rect)localObject2));
      getVideoSeekBar().invalidate();
      localObject1 = getVideoSeekBar();
      d.g.b.k.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setTag(Boolean.TRUE);
    }
    localObject1 = this.rTa;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((c)localObject1).getCurrentPosSec() / ((c)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((c)localObject1).cEe();
      AppMethodBeat.o(203887);
      return;
    }
    AppMethodBeat.o(203887);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(203889);
    d.g.b.k.h(paramSeekBar, "seekBar");
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    ac.i("Finder.VideoSeekBar", "[onStopTrackingTouch] percent=".concat(String.valueOf(f)));
    for (Object localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(false);
    }
    lS(this.rSQ);
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.rTa;
    if (paramSeekBar != null) {
      paramSeekBar.ba(f);
    }
    this.rTe = false;
    AppMethodBeat.o(203889);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(203896);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(paramInt);
      AppMethodBeat.o(203896);
      return;
    }
    AppMethodBeat.o(203896);
  }
  
  public final void setSeekBarCallback(c paramc)
  {
    AppMethodBeat.i(203886);
    d.g.b.k.h(paramc, "seekBarCallback");
    this.rTa = paramc;
    AppMethodBeat.o(203886);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.rSQ = paramBoolean;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "", "getCurrentPosSec", "", "getVideoDurationSec", "onEnterSeekMode", "", "isEnter", "", "onStartSeek", "onStopSeek", "percent", "", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract void ba(float paramFloat);
    
    public abstract void cEe();
    
    public abstract int getCurrentPosSec();
    
    public abstract int getVideoDurationSec();
    
    public abstract void lR(boolean paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements View.OnTouchListener
  {
    private final int padding;
    private boolean rTl;
    private int rTm;
    private int rTn;
    private int rTo;
    private int rTp;
    private final Rect rect;
    
    d()
    {
      AppMethodBeat.i(203878);
      this.rect = new Rect();
      Context localContext = localContext.getContext();
      d.g.b.k.g(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(2131165296));
      AppMethodBeat.o(203878);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(203877);
      d.g.b.k.h(paramView, "v");
      d.g.b.k.h(paramMotionEvent, "event");
      FinderVideoSeekBar.d(this.rTq).onTouchEvent(paramMotionEvent);
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.rTq.rSQ) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        this.rTm = ((int)paramMotionEvent.getX());
        this.rTo = ((int)paramMotionEvent.getY());
        this.rTn = this.rTm;
        this.rTp = 0;
        AppMethodBeat.o(203877);
        return true;
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.rTn != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.rTp != 100)
        {
          i = this.rTp;
          if (i >= 0) {
            break label254;
          }
        }
      }
      while (this.rTp == 100)
      {
        paramView = FinderVideoSeekBar.a(this.rTq);
        if (paramView != null)
        {
          if (!this.rTl) {
            this.rTq.onStartTrackingTouch(paramView);
          }
          this.rTl = true;
          paramView.setProgress(d.h.a.cj(((int)paramMotionEvent.getX() - this.rTm) * 0.7F) + paramView.getProgress());
          this.rTm = ((int)paramMotionEvent.getX());
          AppMethodBeat.o(203877);
          return true;
          label254:
          if (4 >= i)
          {
            i = Math.abs(this.rTn - (int)paramMotionEvent.getX());
            int j = Math.abs(this.rTo - (int)paramMotionEvent.getY());
            if ((i >= 8) && ((j <= 0) || (i / j >= 2))) {}
            for (i = 100;; i = this.rTp + 1)
            {
              this.rTp = i;
              if (this.rTp == 100) {
                break;
              }
              AppMethodBeat.o(203877);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.rTp = 0;
              this.rTn = 0;
              ViewParent localViewParent = this.rTq.getParent();
              paramView = localViewParent;
              if (!(localViewParent instanceof FinderMediaBanner)) {
                paramView = null;
              }
              paramView = (FinderMediaBanner)paramView;
              if (paramView != null) {
                paramView.setFrozenRecyclerView(false);
              }
              if (this.rTl)
              {
                paramView = FinderVideoSeekBar.a(this.rTq);
                if (paramView != null) {
                  this.rTq.onStopTrackingTouch(paramView);
                }
                this.rTl = false;
                AppMethodBeat.o(203877);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.rTn - (int)paramMotionEvent.getX());
                if ((Math.abs(this.rTo - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.rTq.performClick();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(203877);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showSmallProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class e
    implements View.OnLayoutChangeListener
  {
    e(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(203879);
      this.rTr.invoke();
      this.rTq.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(203879);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<GestureDetector>
  {
    g(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */