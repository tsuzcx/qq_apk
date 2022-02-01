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
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "dismissProgressBar", "", "dismissProgressBarThumb", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "isSeekingMode", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "callback", "showBigProgressBar", "isShowThumb", "showProgressBar", "showProgressBarThumb", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "Companion", "plugin-finder_release"})
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, q, FinderViewPager.a
{
  private static final int wfQ;
  public static final a wfR;
  private boolean wbE;
  private q.a wbF;
  boolean wbG;
  private final f wbH;
  private int wbJ;
  private final Rect wfM;
  private final f wfN;
  private final boolean wfO;
  private final b wfP;
  
  static
  {
    AppMethodBeat.i(254368);
    wfR = new a((byte)0);
    wfQ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(254368);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254365);
    this.wfM = new Rect();
    this.wfN = g.ah((kotlin.g.a.a)new f(this));
    paramContext = c.vCb;
    this.wfO = c.dsc();
    this.wbH = g.ah((kotlin.g.a.a)new e(this));
    this.wfP = new b(this);
    setId(2131306117);
    if (this.wfO) {
      setOnTouchListener((View.OnTouchListener)this.wfP);
    }
    LayoutInflater.from(getContext()).inflate(2131494674, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(254365);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254366);
    this.wfM = new Rect();
    this.wfN = g.ah((kotlin.g.a.a)new f(this));
    paramContext = c.vCb;
    this.wfO = c.dsc();
    this.wbH = g.ah((kotlin.g.a.a)new e(this));
    this.wfP = new b(this);
    setId(2131306117);
    if (this.wfO) {
      setOnTouchListener((View.OnTouchListener)this.wfP);
    }
    LayoutInflater.from(getContext()).inflate(2131494674, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(254366);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254367);
    this.wfM = new Rect();
    this.wfN = g.ah((kotlin.g.a.a)new f(this));
    paramContext = c.vCb;
    this.wfO = c.dsc();
    this.wbH = g.ah((kotlin.g.a.a)new e(this));
    this.wfP = new b(this);
    setId(2131306117);
    if (this.wfO) {
      setOnTouchListener((View.OnTouchListener)this.wfP);
    }
    LayoutInflater.from(getContext()).inflate(2131494674, (ViewGroup)this);
    paramContext = getVideoSeekBar();
    p.g(paramContext, "videoSeekBar");
    paramContext.setVisibility(4);
    AppMethodBeat.o(254367);
  }
  
  private final void dFP()
  {
    AppMethodBeat.i(254347);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(255);
        AppMethodBeat.o(254347);
        return;
      }
    }
    AppMethodBeat.o(254347);
  }
  
  private final void dFQ()
  {
    AppMethodBeat.i(254348);
    Object localObject = getVideoSeekBar();
    if (localObject != null)
    {
      localObject = ((SeekBar)localObject).getThumb();
      if (localObject != null)
      {
        ((Drawable)localObject).setAlpha(0);
        AppMethodBeat.o(254348);
        return;
      }
    }
    AppMethodBeat.o(254348);
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(254343);
    GestureDetector localGestureDetector = (GestureDetector)this.wbH.getValue();
    AppMethodBeat.o(254343);
    return localGestureDetector;
  }
  
  private final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(254342);
    SeekBar localSeekBar = (SeekBar)this.wfN.getValue();
    AppMethodBeat.o(254342);
    return localSeekBar;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254361);
    p.h(paramViewGroup, "parent");
    AppMethodBeat.o(254361);
    return true;
  }
  
  public final void awG(String paramString)
  {
    AppMethodBeat.i(254352);
    p.h(paramString, "reason");
    this.wbG = false;
    AppMethodBeat.o(254352);
  }
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(254354);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(kotlin.h.a.cR(localSeekBar.getMax() * paramFloat));
      AppMethodBeat.o(254354);
      return;
    }
    AppMethodBeat.o(254354);
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(254362);
    if ((this.wbE) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(254362);
      return true;
    }
    AppMethodBeat.o(254362);
    return false;
  }
  
  public final void dEX()
  {
    AppMethodBeat.i(254351);
    SeekBar localSeekBar1 = getVideoSeekBar();
    if (localSeekBar1 != null)
    {
      SeekBar localSeekBar2 = getVideoSeekBar();
      p.g(localSeekBar2, "videoSeekBar");
      localSeekBar2.setTag(null);
      if (localSeekBar1.getVisibility() == 4)
      {
        AppMethodBeat.o(254351);
        return;
      }
      localSeekBar1.setVisibility(4);
      AppMethodBeat.o(254351);
      return;
    }
    AppMethodBeat.o(254351);
  }
  
  public final boolean dEY()
  {
    AppMethodBeat.i(254358);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(254358);
      return true;
    }
    AppMethodBeat.o(254358);
    return false;
  }
  
  public final boolean dEZ()
  {
    return this.wbG;
  }
  
  public final void dFa()
  {
    this.wbG = true;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(254356);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(254356);
      return i;
    }
    AppMethodBeat.o(254356);
    return 0;
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254353);
    if ((getVideoSeekBar() != null) && (Log.getLogLevel() <= 1)) {
      Log.d("Finder.VideoSeekBar", "[updateProgressSec] offsetSec=" + paramInt1 + " allSec=" + paramInt2);
    }
    AppMethodBeat.o(254353);
  }
  
  public final void oI(boolean paramBoolean)
  {
    AppMethodBeat.i(254350);
    if (paramBoolean) {
      dFP();
    }
    for (;;)
    {
      localObject = getVideoSeekBar();
      p.g(localObject, "videoSeekBar");
      if (!p.j(((SeekBar)localObject).getTag(), Boolean.FALSE)) {
        break;
      }
      AppMethodBeat.o(254350);
      return;
      dFQ();
    }
    Object localObject = getVideoSeekBar();
    p.g(localObject, "videoSeekBar");
    ((SeekBar)localObject).setVisibility(0);
    localObject = (kotlin.g.a.a)new d(this);
    if (this.wfM.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this, (kotlin.g.a.a)localObject));
      AppMethodBeat.o(254350);
      return;
    }
    ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(254350);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254363);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(254363);
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
    AppMethodBeat.i(254349);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1;
    Object localObject2;
    if (this.wfM.isEmpty())
    {
      localObject1 = this.wfM;
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
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(254349);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(254349);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(2131310327);
      p.g(localObject2, "warnView");
      if (((View)localObject2).getVisibility() != 0) {
        break label278;
      }
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-wfQ + ((View)localObject2).getHeight());
      localSeekBar = getVideoSeekBar();
      p.g(localSeekBar, "videoSeekBar");
      localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      Log.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin + ", warnView visibility=" + ((View)localObject2).getVisibility());
      AppMethodBeat.o(254349);
      return;
      label278:
      if (((FrameLayout.LayoutParams)localObject1).bottomMargin != -wfQ)
      {
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-wfQ);
        localSeekBar = getVideoSeekBar();
        p.g(localSeekBar, "videoSeekBar");
        localSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254360);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(254360);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254345);
    p.h(paramSeekBar, "seekBar");
    AppMethodBeat.o(254345);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(254364);
    paramMotionEvent = this.wbF;
    if ((paramMotionEvent == null) || (paramMotionEvent.dFI() != true))
    {
      Log.w("Finder.VideoSeekBar", "[onSingleTapConfirmed] is Disable Seek");
      AppMethodBeat.o(254364);
      return false;
    }
    boolean bool1;
    if (!this.wbG)
    {
      oI(true);
      paramMotionEvent = this.wbF;
      if (paramMotionEvent != null) {
        paramMotionEvent.Q(true, true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.wbG = bool1;
      paramMotionEvent = new StringBuilder("[onClick]...isShownSeekBar=").append(dEY()).append(" isSeekMode=").append(this.wbG).append(" thumb=");
      SeekBar localSeekBar = getVideoSeekBar();
      p.g(localSeekBar, "videoSeekBar");
      Log.i("Finder.VideoSeekBar", localSeekBar.getAlpha());
      AppMethodBeat.o(254364);
      return true;
      oI(false);
      paramMotionEvent = this.wbF;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.Q(false, true);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254359);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(254359);
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(254344);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.wbF;
    if ((localObject1 == null) || (((q.a)localObject1).dFI() != true))
    {
      Log.w("Finder.VideoSeekBar", "[onStartTrackingTouch] is Disable Seek");
      AppMethodBeat.o(254344);
      return;
    }
    paramSeekBar.animate().cancel();
    this.wbE = true;
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
    dFP();
    localObject1 = getVideoSeekBar();
    p.g(localObject1, "videoSeekBar");
    if (!p.j(((SeekBar)localObject1).getTag(), Boolean.TRUE))
    {
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setVisibility(0);
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      localObject1 = ((SeekBar)localObject1).getProgressDrawable();
      localObject2 = this.wfM;
      p.g(localObject1, "progressDrawable");
      ((Drawable)localObject1).setBounds(new Rect((Rect)localObject2));
      getVideoSeekBar().invalidate();
      localObject1 = getVideoSeekBar();
      p.g(localObject1, "videoSeekBar");
      ((SeekBar)localObject1).setTag(Boolean.TRUE);
    }
    localObject1 = this.wbF;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((q.a)localObject1).getCurrentPosSec() / ((q.a)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((q.a)localObject1).dFH();
      AppMethodBeat.o(254344);
      return;
    }
    AppMethodBeat.o(254344);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(254346);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.wbF;
    if ((localObject1 == null) || (((q.a)localObject1).dFI() != true))
    {
      Log.w("Finder.VideoSeekBar", "[onStopTrackingTouch] is Disable Seek");
      AppMethodBeat.o(254346);
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
    oI(this.wbG);
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.wbF;
    if (paramSeekBar != null) {
      paramSeekBar.bn(f);
    }
    this.wbE = false;
    AppMethodBeat.o(254346);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(254355);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.VideoSeekBar", "[setProgress] target=".concat(String.valueOf(paramInt)));
    }
    this.wbJ = paramInt;
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(paramInt);
      AppMethodBeat.o(254355);
      return;
    }
    AppMethodBeat.o(254355);
  }
  
  public final void setSeekBarCallback(q.a parama)
  {
    AppMethodBeat.i(254357);
    p.h(parama, "callback");
    this.wbF = parama;
    AppMethodBeat.o(254357);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.wbG = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_DURATION", "", "TAG", "", "_4dp", "get_4dp", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class b
    implements View.OnTouchListener
  {
    private int kuv;
    private int kuw;
    private final int padding;
    private final Rect rect;
    private boolean wcq;
    private int wcr;
    private int wcs;
    
    b()
    {
      AppMethodBeat.i(254337);
      this.rect = new Rect();
      Context localContext = localContext.getContext();
      p.g(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(2131165306));
      AppMethodBeat.o(254337);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(254336);
      p.h(paramView, "v");
      p.h(paramMotionEvent, "event");
      Object localObject = FinderVideoSeekBar.d(this.wfS);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.wfS.wbG) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        if (FinderVideoSeekBar.e(this.wfS) != null)
        {
          paramView = FinderVideoSeekBar.e(this.wfS);
          if (paramView == null) {
            break label241;
          }
        }
        label241:
        for (paramView = Boolean.valueOf(paramView.W(paramMotionEvent));; paramView = null)
        {
          if (paramView == null) {
            p.hyc();
          }
          if (paramView.booleanValue()) {
            break;
          }
          this.wcr = ((int)paramMotionEvent.getX());
          this.kuw = ((int)paramMotionEvent.getY());
          this.kuv = this.wcr;
          this.wcs = 0;
          AppMethodBeat.o(254336);
          return true;
        }
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.kuv != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.wcs != 100)
        {
          i = this.wcs;
          if (i >= 0) {
            break label370;
          }
        }
      }
      while (this.wcs == 100)
      {
        paramView = FinderVideoSeekBar.a(this.wfS);
        if (paramView != null)
        {
          if (!this.wcq) {
            this.wfS.onStartTrackingTouch(paramView);
          }
          this.wcq = true;
          paramView.setProgress(kotlin.h.a.cR(((int)paramMotionEvent.getX() - this.wcr) * 0.7F) + paramView.getProgress());
          this.wcr = ((int)paramMotionEvent.getX());
          AppMethodBeat.o(254336);
          return true;
          label370:
          if (4 >= i)
          {
            i = Math.abs(this.kuv - (int)paramMotionEvent.getX());
            int j = Math.abs(this.kuw - (int)paramMotionEvent.getY());
            if ((i >= 8) && ((j <= 0) || (i / j >= 2))) {}
            for (i = 100;; i = this.wcs + 1)
            {
              this.wcs = i;
              if (this.wcs == 100) {
                break;
              }
              AppMethodBeat.o(254336);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.wcs = 0;
              this.kuv = 0;
              localObject = this.wfS.getParent();
              paramView = (View)localObject;
              if (!(localObject instanceof FinderMediaBanner)) {
                paramView = null;
              }
              paramView = (FinderMediaBanner)paramView;
              if (paramView != null) {
                paramView.setFrozenRecyclerView(false);
              }
              if (this.wcq)
              {
                paramView = FinderVideoSeekBar.a(this.wfS);
                if (paramView != null) {
                  this.wfS.onStopTrackingTouch(paramView);
                }
                this.wcq = false;
                AppMethodBeat.o(254336);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.kuv - (int)paramMotionEvent.getX());
                if ((Math.abs(this.kuw - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.wfS.performClick();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(254336);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    c(kotlin.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(254338);
      this.wfT.invoke();
      this.wfS.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(254338);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<GestureDetector>
  {
    e(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<SeekBar>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */