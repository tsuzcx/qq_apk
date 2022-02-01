package com.tencent.mm.plugin.finder.video;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "dismissProgressBar", "", "dismissProgressBarThumb", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "getMaxProgress", "isSeekingMode", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "callback", "showBigProgressBar", "isShowThumb", "showProgressBar", "showProgressBarThumb", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "Companion", "plugin-finder_release"})
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, r, FinderViewPager.a
{
  private static final int AOJ;
  public static final a AOK;
  private boolean AKp;
  private r.a AKu;
  boolean AKv;
  private final Rect AOD;
  private final f AOE;
  private final boolean AOF;
  private final f AOG;
  private final b AOH;
  private int AOI;
  
  static
  {
    AppMethodBeat.i(280804);
    AOK = new a((byte)0);
    AOJ = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(280804);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(280800);
    this.AOD = new Rect();
    this.AOE = g.ar((kotlin.g.a.a)new f(this));
    paramContext = d.AjH;
    this.AOF = d.dTr();
    this.AOG = g.ar((kotlin.g.a.a)new e(this));
    this.AOH = new b(this);
    setId(b.f.preview_seek_bar_layout);
    if (this.AOF) {
      setOnTouchListener((View.OnTouchListener)this.AOH);
    }
    LayoutInflater.from(getContext()).inflate(b.g.finder_video_seek_bar_layout, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.j(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(280800);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280802);
    this.AOD = new Rect();
    this.AOE = g.ar((kotlin.g.a.a)new f(this));
    paramContext = d.AjH;
    this.AOF = d.dTr();
    this.AOG = g.ar((kotlin.g.a.a)new e(this));
    this.AOH = new b(this);
    setId(b.f.preview_seek_bar_layout);
    if (this.AOF) {
      setOnTouchListener((View.OnTouchListener)this.AOH);
    }
    LayoutInflater.from(getContext()).inflate(b.g.finder_video_seek_bar_layout, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.j(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(280802);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280803);
    this.AOD = new Rect();
    this.AOE = g.ar((kotlin.g.a.a)new f(this));
    paramContext = d.AjH;
    this.AOF = d.dTr();
    this.AOG = g.ar((kotlin.g.a.a)new e(this));
    this.AOH = new b(this);
    setId(b.f.preview_seek_bar_layout);
    if (this.AOF) {
      setOnTouchListener((View.OnTouchListener)this.AOH);
    }
    LayoutInflater.from(getContext()).inflate(b.g.finder_video_seek_bar_layout, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.j(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(280803);
  }
  
  private final void ehx()
  {
    AppMethodBeat.i(280768);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(255);
        AppMethodBeat.o(280768);
        return;
      }
    }
    AppMethodBeat.o(280768);
  }
  
  private final void ehy()
  {
    AppMethodBeat.i(280769);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(0);
        AppMethodBeat.o(280769);
        return;
      }
    }
    AppMethodBeat.o(280769);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(280759);
    GestureDetector localGestureDetector = (GestureDetector)this.AOG.getValue();
    AppMethodBeat.o(280759);
    return localGestureDetector;
  }
  
  private final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(280757);
    SeekBar localSeekBar = (SeekBar)this.AOE.getValue();
    AppMethodBeat.o(280757);
    return localSeekBar;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(280793);
    p.k(paramViewGroup, "parent");
    AppMethodBeat.o(280793);
    return true;
  }
  
  public final void aGh(String paramString)
  {
    AppMethodBeat.i(280777);
    p.k(paramString, "reason");
    this.AKv = false;
    AppMethodBeat.o(280777);
  }
  
  public final void bk(float paramFloat)
  {
    AppMethodBeat.i(280780);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(kotlin.h.a.dm(localSeekBar.getMax() * paramFloat));
      AppMethodBeat.o(280780);
      return;
    }
    AppMethodBeat.o(280780);
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(280795);
    if ((this.AKp) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(280795);
      return true;
    }
    AppMethodBeat.o(280795);
    return false;
  }
  
  public final void egH()
  {
    AppMethodBeat.i(280774);
    SeekBar localSeekBar1 = getVideoSeekBar();
    if (localSeekBar1 != null)
    {
      SeekBar localSeekBar2 = getVideoSeekBar();
      p.j(localSeekBar2, "videoSeekBar");
      localSeekBar2.setTag(null);
      if (localSeekBar1.getVisibility() == 4)
      {
        AppMethodBeat.o(280774);
        return;
      }
      localSeekBar1.setVisibility(4);
      AppMethodBeat.o(280774);
      return;
    }
    AppMethodBeat.o(280774);
  }
  
  public final boolean egI()
  {
    AppMethodBeat.i(280788);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(280788);
      return true;
    }
    AppMethodBeat.o(280788);
    return false;
  }
  
  public final boolean egJ()
  {
    return this.AKv;
  }
  
  public final void egK()
  {
    this.AKv = true;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(280783);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(280783);
      return i;
    }
    AppMethodBeat.o(280783);
    return 0;
  }
  
  public final int getMaxProgress()
  {
    AppMethodBeat.i(280785);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(280785);
      return i;
    }
    AppMethodBeat.o(280785);
    return 1;
  }
  
  public final void he(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(280779);
    if ((getVideoSeekBar() != null) && (Log.getLogLevel() <= 1)) {
      Log.d("Finder.VideoSeekBar", "[updateProgressSec] offsetSec=" + paramInt1 + " allSec=" + paramInt2);
    }
    AppMethodBeat.o(280779);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280796);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(280796);
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
    AppMethodBeat.i(280770);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (this.AOD.isEmpty())
    {
      localObject1 = this.AOD;
      localObject2 = getVideoSeekBar();
      p.j(localObject2, "videoSeekBar");
      localObject2 = ((SeekBar)localObject2).getProgressDrawable();
      p.j(localObject2, "videoSeekBar.progressDrawable");
      ((Rect)localObject1).set(((Drawable)localObject2).getBounds());
    }
    SeekBar localSeekBar;
    if (paramBoolean)
    {
      localObject1 = getVideoSeekBar();
      p.j(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(280770);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(280770);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(b.f.warn_container);
      p.j(localObject2, "warnView");
      if (((View)localObject2).getVisibility() != 0) {
        break label278;
      }
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-AOJ + ((View)localObject2).getHeight());
      localSeekBar = getVideoSeekBar();
      p.j(localSeekBar, "videoSeekBar");
      localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      Log.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin + ", warnView visibility=" + ((View)localObject2).getVisibility());
      AppMethodBeat.o(280770);
      return;
      label278:
      if (((FrameLayout.LayoutParams)localObject1).bottomMargin != -AOJ)
      {
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-AOJ);
        localSeekBar = getVideoSeekBar();
        p.j(localSeekBar, "videoSeekBar");
        localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280792);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(280792);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(280764);
    p.k(paramSeekBar, "seekBar");
    AppMethodBeat.o(280764);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(280799);
    paramMotionEvent = this.AKu;
    if ((paramMotionEvent == null) || (paramMotionEvent.ehw() != true))
    {
      Log.w("Finder.VideoSeekBar", "[onSingleTapConfirmed] is Disable Seek");
      AppMethodBeat.o(280799);
      return false;
    }
    boolean bool1;
    if (!this.AKv)
    {
      qW(true);
      paramMotionEvent = this.AKu;
      if (paramMotionEvent != null) {
        paramMotionEvent.rf(true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.AKv = bool1;
      paramMotionEvent = new StringBuilder("[onClick]...isShownSeekBar=").append(egI()).append(" isSeekMode=").append(this.AKv).append(" thumb=");
      SeekBar localSeekBar = getVideoSeekBar();
      p.j(localSeekBar, "videoSeekBar");
      Log.i("Finder.VideoSeekBar", localSeekBar.getAlpha());
      AppMethodBeat.o(280799);
      return true;
      qW(false);
      paramMotionEvent = this.AKu;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.rf(false);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280790);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(280790);
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(280762);
    p.k(paramSeekBar, "seekBar");
    Object localObject1 = this.AKu;
    if ((localObject1 == null) || (((r.a)localObject1).ehw() != true))
    {
      Log.w("Finder.VideoSeekBar", "[onStartTrackingTouch] is Disable Seek");
      AppMethodBeat.o(280762);
      return;
    }
    paramSeekBar.animate().cancel();
    this.AKp = true;
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
    ehx();
    localObject1 = getVideoSeekBar();
    p.j(localObject1, "videoSeekBar");
    if (!p.h(((SeekBar)localObject1).getTag(), Boolean.TRUE))
    {
      localObject1 = getVideoSeekBar();
      p.j(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setVisibility(0);
      localObject1 = getVideoSeekBar();
      p.j(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getProgressDrawable();
      localObject2 = this.AOD;
      p.j(localObject1, "progressDrawable");
      ((Drawable)localObject1).setBounds(new Rect((Rect)localObject2));
      getVideoSeekBar().invalidate();
      localObject1 = getVideoSeekBar();
      p.j(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setTag(Boolean.TRUE);
    }
    localObject1 = this.AKu;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((r.a)localObject1).getCurrentPosSec() / ((r.a)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((r.a)localObject1).ehv();
      AppMethodBeat.o(280762);
      return;
    }
    AppMethodBeat.o(280762);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(280766);
    p.k(paramSeekBar, "seekBar");
    Object localObject1 = this.AKu;
    if ((localObject1 == null) || (((r.a)localObject1).ehw() != true))
    {
      Log.w("Finder.VideoSeekBar", "[onStopTrackingTouch] is Disable Seek");
      AppMethodBeat.o(280766);
      return;
    }
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    Log.i("Finder.VideoSeekBar", "[onStopTrackingTouch] percent=".concat(String.valueOf(f)));
    for (localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(false);
    }
    qW(this.AKv);
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.AKu;
    if (paramSeekBar != null) {
      paramSeekBar.bl(f);
    }
    this.AKp = false;
    AppMethodBeat.o(280766);
  }
  
  public final void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(280772);
    if (paramBoolean) {
      ehx();
    }
    for (;;)
    {
      localObject = getVideoSeekBar();
      p.j(localObject, "videoSeekBar");
      if (!p.h(((SeekBar)localObject).getTag(), Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(280772);
      return;
      ehy();
    }
    Object localObject = getVideoSeekBar();
    p.j(localObject, "videoSeekBar");
    ((SeekBar)localObject).setVisibility(0);
    localObject = (kotlin.g.a.a)new d(this);
    if (this.AOD.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this, (kotlin.g.a.a)localObject));
      AppMethodBeat.o(280772);
      return;
    }
    ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(280772);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(280782);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.VideoSeekBar", "[setProgress] target=".concat(String.valueOf(paramInt)));
    }
    this.AOI = paramInt;
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(paramInt);
      AppMethodBeat.o(280782);
      return;
    }
    AppMethodBeat.o(280782);
  }
  
  public final void setSeekBarCallback(r.a parama)
  {
    AppMethodBeat.i(280787);
    p.k(parama, "callback");
    this.AKu = parama;
    AppMethodBeat.o(280787);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.AKv = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_DURATION", "", "TAG", "", "_4dp", "get_4dp", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class b
    implements View.OnTouchListener
  {
    private boolean AOL;
    private int AOM;
    private int AON;
    private final Rect byG;
    private int nmj;
    private int nmk;
    private final int padding;
    
    b()
    {
      AppMethodBeat.i(290378);
      this.byG = new Rect();
      Context localContext = localContext.getContext();
      p.j(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(b.d.Edge_5A));
      AppMethodBeat.o(290378);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(290377);
      p.k(paramView, "v");
      p.k(paramMotionEvent, "event");
      Object localObject = FinderVideoSeekBar.d(this.AOO);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramView.getFocusedRect(this.byG);
      paramView = this.byG;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.AOO.AKv) || (this.byG.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        if (FinderVideoSeekBar.e(this.AOO) != null)
        {
          paramView = FinderVideoSeekBar.e(this.AOO);
          if (paramView == null) {
            break label241;
          }
        }
        label241:
        for (paramView = Boolean.valueOf(paramView.ac(paramMotionEvent));; paramView = null)
        {
          if (paramView == null) {
            p.iCn();
          }
          if (paramView.booleanValue()) {
            break;
          }
          this.AOM = ((int)paramMotionEvent.getX());
          this.nmk = ((int)paramMotionEvent.getY());
          this.nmj = this.AOM;
          this.AON = 0;
          AppMethodBeat.o(290377);
          return true;
        }
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.nmj != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.AON != 100)
        {
          i = this.AON;
          if (i >= 0) {
            break label370;
          }
        }
      }
      while (this.AON == 100)
      {
        paramView = FinderVideoSeekBar.a(this.AOO);
        if (paramView != null)
        {
          if (!this.AOL) {
            this.AOO.onStartTrackingTouch(paramView);
          }
          this.AOL = true;
          paramView.setProgress(kotlin.h.a.dm(((int)paramMotionEvent.getX() - this.AOM) * 0.7F) + paramView.getProgress());
          this.AOM = ((int)paramMotionEvent.getX());
          AppMethodBeat.o(290377);
          return true;
          label370:
          if (4 >= i)
          {
            i = Math.abs(this.nmj - (int)paramMotionEvent.getX());
            int j = Math.abs(this.nmk - (int)paramMotionEvent.getY());
            if ((i >= 8) && ((j <= 0) || (i / j >= 2))) {}
            for (i = 100;; i = this.AON + 1)
            {
              this.AON = i;
              if (this.AON == 100) {
                break;
              }
              AppMethodBeat.o(290377);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.AON = 0;
              this.nmj = 0;
              localObject = this.AOO.getParent();
              paramView = (View)localObject;
              if (!(localObject instanceof FinderMediaBanner)) {
                paramView = null;
              }
              paramView = (FinderMediaBanner)paramView;
              if (paramView != null) {
                paramView.setFrozenRecyclerView(false);
              }
              if (this.AOL)
              {
                paramView = FinderVideoSeekBar.a(this.AOO);
                if (paramView != null) {
                  this.AOO.onStopTrackingTouch(paramView);
                }
                this.AOL = false;
                AppMethodBeat.o(290377);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.nmj - (int)paramMotionEvent.getX());
                if ((Math.abs(this.nmk - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.AOO.performClick();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(290377);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    c(kotlin.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(225968);
      this.AOP.invoke();
      this.AOO.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(225968);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<GestureDetector>
  {
    e(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<SeekBar>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */