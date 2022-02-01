package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isLockShow", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "onSingleTapConfirmedListener", "Lkotlin/Function0;", "", "getOnSingleTapConfirmedListener", "()Lkotlin/jvm/functions/Function0;", "setOnSingleTapConfirmedListener", "(Lkotlin/jvm/functions/Function0;)V", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarId", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1;", "seekTimeView", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "getSeekTimeView", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "seekTimeView$delegate", "seekTimeViewId", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "verticalRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getVerticalRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setVerticalRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "videoSumTimeSec", "canScrollHorizontally", "direction", "canScrollVertically", "dismissProgressBar", "dismissProgressBarThumb", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "hideOtherView", "hidePauseIcon", "init", "initAttribute", "defStyle", "isSeekingMode", "isShownSeekBar", "lockShowProgressBar", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onProgressChanged", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "callback", "showOtherView", "showPauseIcon", "showProgressBar", "isShowThumb", "showProgressBarImpl", "isShow", "showProgressBarThumb", "showSeekTimeLayout", "unlockShowProgressBar", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "updateSeekTime", "Companion", "plugin-finder_release"})
public final class FinderFullVideoSeekBarLayout
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, q
{
  public static final a wcn;
  private final f vMb;
  private boolean wbE;
  private q.a wbF;
  boolean wbG;
  private final f wbH;
  private int wbJ;
  private int wcf;
  private int wcg;
  private final f wch;
  private int wci;
  private RecyclerView wcj;
  private kotlin.g.a.a<x> wck;
  private final d wcl;
  private boolean wcm;
  
  static
  {
    AppMethodBeat.i(254009);
    wcn = new a((byte)0);
    AppMethodBeat.o(254009);
  }
  
  public FinderFullVideoSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254007);
    this.vMb = g.ah((kotlin.g.a.a)new c(this));
    this.wch = g.ah((kotlin.g.a.a)new e(this));
    this.wci = 1;
    this.wck = ((kotlin.g.a.a)b.wco);
    this.wbH = g.ah((kotlin.g.a.a)new f(this));
    this.wcl = new d(this);
    b(paramAttributeSet, 0);
    AppMethodBeat.o(254007);
  }
  
  public FinderFullVideoSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254008);
    this.vMb = g.ah((kotlin.g.a.a)new c(this));
    this.wch = g.ah((kotlin.g.a.a)new e(this));
    this.wci = 1;
    this.wck = ((kotlin.g.a.a)b.wco);
    this.wbH = g.ah((kotlin.g.a.a)new f(this));
    this.wcl = new d(this);
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(254008);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(253982);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.a.FinderFullVideoSeekBarLayout, paramInt, 0);
    this.wcf = paramAttributeSet.getResourceId(0, 0);
    this.wcg = paramAttributeSet.getResourceId(1, 0);
    paramAttributeSet.recycle();
    AppMethodBeat.o(253982);
  }
  
  private final void dFb()
  {
    AppMethodBeat.i(253992);
    dFh();
    Object localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253992);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((View)localObject1).findViewById(2131303829);
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate();
      if (localObject2 != null) {
        ((ViewPropertyAnimator)localObject2).cancel();
      }
      ((View)localObject1).animate().alpha(1.0F).setDuration(280L).start();
    }
    localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253992);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((View)localObject1).findViewById(2131300827);
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject2 = (ViewGroup)localObject1;
    if (localObject2 != null)
    {
      int j = ((ViewGroup)localObject2).getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = ((ViewGroup)localObject2).getChildAt(i);
        localObject1 = getSeekBar();
        if (localObject1 != null) {}
        for (localObject1 = ((SeekBar)localObject1).getParent();; localObject1 = null)
        {
          if (!p.j(localView, localObject1))
          {
            localObject1 = localView.animate();
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).cancel();
            }
            localView.animate().alpha(1.0F).setDuration(280L).start();
          }
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(253992);
      return;
    }
    AppMethodBeat.o(253992);
  }
  
  private final void dFf()
  {
    AppMethodBeat.i(253985);
    Object localObject = getSeekBar();
    if (localObject != null)
    {
      float f = ((SeekBar)localObject).getProgress() * 1.0F / ((SeekBar)localObject).getMax();
      int i = this.wci;
      f = android.support.v4.b.a.j(f * i, i - 1.0F);
      localObject = getSeekTimeView();
      if (localObject != null) {
        ((FinderVideoSeekTimeView)localObject).setSumTime(this.wci);
      }
      localObject = getSeekTimeView();
      if (localObject != null)
      {
        ((FinderVideoSeekTimeView)localObject).setCurrentTime((int)f);
        AppMethodBeat.o(253985);
        return;
      }
      AppMethodBeat.o(253985);
      return;
    }
    AppMethodBeat.o(253985);
  }
  
  private final void dFg()
  {
    AppMethodBeat.i(253991);
    dFi();
    Object localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253991);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((View)localObject1).findViewById(2131303829);
    if (localObject1 != null) {
      ((View)localObject1).setAlpha(0.0F);
    }
    localObject1 = getParent();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253991);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((View)localObject1).findViewById(2131300827);
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject2 = (ViewGroup)localObject1;
    if (localObject2 != null)
    {
      int j = ((ViewGroup)localObject2).getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = ((ViewGroup)localObject2).getChildAt(i);
        localObject1 = getSeekBar();
        if (localObject1 != null) {}
        for (localObject1 = ((SeekBar)localObject1).getParent();; localObject1 = null)
        {
          if (!p.j(localView, localObject1))
          {
            localObject1 = localView.animate();
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).cancel();
            }
            localView.animate().alpha(0.0F).setDuration(280L).start();
          }
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(253991);
      return;
    }
    AppMethodBeat.o(253991);
  }
  
  private final void dFh()
  {
    AppMethodBeat.i(253993);
    Object localObject = getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253993);
      throw ((Throwable)localObject);
    }
    localObject = ((View)localObject).findViewById(2131300829);
    ViewPropertyAnimator localViewPropertyAnimator;
    if (localObject != null)
    {
      localViewPropertyAnimator = ((View)localObject).animate();
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      ((View)localObject).animate().alpha(1.0F).setDuration(280L).start();
    }
    localObject = getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253993);
      throw ((Throwable)localObject);
    }
    localObject = ((View)localObject).findViewById(2131301504);
    if (localObject != null)
    {
      localViewPropertyAnimator = ((View)localObject).animate();
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      ((View)localObject).animate().alpha(1.0F).setDuration(280L).start();
      AppMethodBeat.o(253993);
      return;
    }
    AppMethodBeat.o(253993);
  }
  
  private final void dFi()
  {
    AppMethodBeat.i(253994);
    Object localObject = getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253994);
      throw ((Throwable)localObject);
    }
    localObject = ((View)localObject).findViewById(2131300829);
    ViewPropertyAnimator localViewPropertyAnimator;
    if (localObject != null)
    {
      localViewPropertyAnimator = ((View)localObject).animate();
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      ((View)localObject).setAlpha(0.0F);
    }
    localObject = getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(253994);
      throw ((Throwable)localObject);
    }
    localObject = ((View)localObject).findViewById(2131301504);
    if (localObject != null)
    {
      localViewPropertyAnimator = ((View)localObject).animate();
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
      ((View)localObject).setAlpha(0.0F);
      AppMethodBeat.o(253994);
      return;
    }
    AppMethodBeat.o(253994);
  }
  
  private final FinderVideoSeekTimeView getSeekTimeView()
  {
    AppMethodBeat.i(253980);
    FinderVideoSeekTimeView localFinderVideoSeekTimeView = (FinderVideoSeekTimeView)this.wch.getValue();
    AppMethodBeat.o(253980);
    return localFinderVideoSeekTimeView;
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(253984);
    GestureDetector localGestureDetector = (GestureDetector)this.wbH.getValue();
    AppMethodBeat.o(253984);
    return localGestureDetector;
  }
  
  private final void oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(253989);
    Log.i("Finder.FullVideoSeekBarLayout", "[showSeekTimeLayout] isShowThumb=" + paramBoolean + " isLockShow=" + this.wcm);
    if (paramBoolean)
    {
      localFinderVideoSeekTimeView = getSeekTimeView();
      if (localFinderVideoSeekTimeView != null)
      {
        localFinderVideoSeekTimeView.setVisibility(0);
        AppMethodBeat.o(253989);
        return;
      }
      AppMethodBeat.o(253989);
      return;
    }
    FinderVideoSeekTimeView localFinderVideoSeekTimeView = getSeekTimeView();
    if (localFinderVideoSeekTimeView != null)
    {
      localFinderVideoSeekTimeView.setVisibility(8);
      AppMethodBeat.o(253989);
      return;
    }
    AppMethodBeat.o(253989);
  }
  
  private final void oK(boolean paramBoolean)
  {
    AppMethodBeat.i(253990);
    Log.i("Finder.FullVideoSeekBarLayout", "[showProgressBarImpl] isShowThumb=" + paramBoolean + " isLockShow=" + this.wcm);
    if (this.wcm)
    {
      if (paramBoolean)
      {
        dFi();
        AppMethodBeat.o(253990);
        return;
      }
      dFh();
      AppMethodBeat.o(253990);
      return;
    }
    Object localObject = getSeekBar();
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((SeekBar)localObject).setVisibility(0);
        dFg();
        localObject = this.wbF;
        if (localObject != null)
        {
          ((q.a)localObject).Q(true, false);
          AppMethodBeat.o(253990);
          return;
        }
        AppMethodBeat.o(253990);
        return;
      }
      ((SeekBar)localObject).setVisibility(8);
      dFb();
      localObject = this.wbF;
      if (localObject != null)
      {
        ((q.a)localObject).Q(false, false);
        AppMethodBeat.o(253990);
        return;
      }
      AppMethodBeat.o(253990);
      return;
    }
    AppMethodBeat.o(253990);
  }
  
  public final void awG(String paramString)
  {
    AppMethodBeat.i(254001);
    p.h(paramString, "reason");
    this.wbG = false;
    AppMethodBeat.o(254001);
  }
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(254000);
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setProgress(kotlin.h.a.cR(localSeekBar.getMax() * paramFloat));
      AppMethodBeat.o(254000);
      return;
    }
    AppMethodBeat.o(254000);
  }
  
  public final boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(254006);
    if ((this.wbE) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(254006);
      return true;
    }
    AppMethodBeat.o(254006);
    return false;
  }
  
  public final void dEX()
  {
    AppMethodBeat.i(253995);
    if (this.wcm)
    {
      AppMethodBeat.o(253995);
      return;
    }
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar != null)
    {
      localSeekBar.setTag(null);
      FinderVideoSeekTimeView localFinderVideoSeekTimeView = getSeekTimeView();
      if (localFinderVideoSeekTimeView != null) {
        localFinderVideoSeekTimeView.setVisibility(8);
      }
      if (localSeekBar.getVisibility() == 8)
      {
        AppMethodBeat.o(253995);
        return;
      }
      localSeekBar.setVisibility(8);
      AppMethodBeat.o(253995);
      return;
    }
    AppMethodBeat.o(253995);
  }
  
  public final boolean dEY()
  {
    AppMethodBeat.i(253998);
    SeekBar localSeekBar = getSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(253998);
      return true;
    }
    AppMethodBeat.o(253998);
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
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253983);
    p.h(paramMotionEvent, "event");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool) && (this.wcl.onTouch((View)this, paramMotionEvent)))
    {
      AppMethodBeat.o(253983);
      return true;
    }
    AppMethodBeat.o(253983);
    return bool;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(253996);
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar != null)
    {
      int i = localSeekBar.getProgress();
      AppMethodBeat.o(253996);
      return i;
    }
    AppMethodBeat.o(253996);
    return 0;
  }
  
  public final kotlin.g.a.a<x> getOnSingleTapConfirmedListener()
  {
    return this.wck;
  }
  
  public final SeekBar getSeekBar()
  {
    AppMethodBeat.i(253979);
    SeekBar localSeekBar = (SeekBar)this.vMb.getValue();
    AppMethodBeat.o(253979);
    return localSeekBar;
  }
  
  public final RecyclerView getVerticalRecyclerView()
  {
    return this.wcj;
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253999);
    if (getSeekBar() != null) {
      this.wci = paramInt2;
    }
    AppMethodBeat.o(253999);
  }
  
  public final void oI(boolean paramBoolean) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254005);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(254005);
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
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254003);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(254003);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254004);
    this.wck.invoke();
    AppMethodBeat.o(254004);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254002);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(254002);
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(253986);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.wbF;
    if ((localObject1 == null) || (((q.a)localObject1).dFI() != true))
    {
      Log.w("Finder.FullVideoSeekBarLayout", "[onStartTrackingTouch] is Disable Seek");
      AppMethodBeat.o(253986);
      return;
    }
    localObject1 = this.wcj;
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      if ((localObject1 != null) && ((localObject1 instanceof FinderLinearLayoutManager))) {
        ((FinderLinearLayoutManager)localObject1).wtl = false;
      }
    }
    paramSeekBar.animate().cancel();
    this.wbE = true;
    paramSeekBar.setVisibility(0);
    for (localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(true);
    }
    oK(true);
    oJ(true);
    localObject1 = this.wbF;
    if (localObject1 != null)
    {
      paramSeekBar.setProgress((int)(1.0F * ((q.a)localObject1).getCurrentPosSec() / ((q.a)localObject1).getVideoDurationSec() * paramSeekBar.getMax()));
      ((q.a)localObject1).dFH();
      AppMethodBeat.o(253986);
      return;
    }
    AppMethodBeat.o(253986);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(253987);
    p.h(paramSeekBar, "seekBar");
    Object localObject1 = this.wcj;
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      if ((localObject1 != null) && ((localObject1 instanceof FinderLinearLayoutManager))) {
        ((FinderLinearLayoutManager)localObject1).wtl = true;
      }
    }
    localObject1 = this.wbF;
    if (localObject1 != null)
    {
      if (((q.a)localObject1).dFI() != true) {
        AppMethodBeat.o(253987);
      }
    }
    else
    {
      AppMethodBeat.o(253987);
      return;
    }
    oK(false);
    oJ(false);
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    Log.i("Finder.FullVideoSeekBarLayout", "[onStopTrackingTouch] percent=".concat(String.valueOf(f)));
    for (localObject1 = getParent(); (localObject1 != null) && (!(localObject1 instanceof FinderMediaBanner)); localObject1 = ((ViewParent)localObject1).getParent()) {}
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof FinderMediaBanner)) {
      localObject2 = null;
    }
    localObject1 = (FinderMediaBanner)localObject2;
    if (localObject1 != null) {
      ((FinderMediaBanner)localObject1).setFrozenRecyclerView(false);
    }
    setProgress(paramSeekBar.getProgress());
    paramSeekBar = this.wbF;
    if (paramSeekBar != null) {
      paramSeekBar.bn(f);
    }
    this.wbE = false;
    AppMethodBeat.o(253987);
  }
  
  public final void setOnSingleTapConfirmedListener(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(253981);
    p.h(parama, "<set-?>");
    this.wck = parama;
    AppMethodBeat.o(253981);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(253988);
    this.wbJ = paramInt;
    SeekBar localSeekBar = getSeekBar();
    if (localSeekBar != null) {
      localSeekBar.setProgress(paramInt);
    }
    dFf();
    AppMethodBeat.o(253988);
  }
  
  public final void setSeekBarCallback(q.a parama)
  {
    AppMethodBeat.i(253997);
    p.h(parama, "callback");
    this.wbF = parama;
    AppMethodBeat.o(253997);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.wbG = paramBoolean;
  }
  
  public final void setVerticalRecyclerView(RecyclerView paramRecyclerView)
  {
    this.wcj = paramRecyclerView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final b wco;
    
    static
    {
      AppMethodBeat.i(253973);
      wco = new b();
      AppMethodBeat.o(253973);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<SeekBar>
  {
    c(FinderFullVideoSeekBarLayout paramFinderFullVideoSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements View.OnTouchListener
  {
    private int kuv;
    private int kuw;
    private final int padding;
    private final Rect rect;
    private boolean wcq;
    private int wcr;
    private int wcs;
    
    d()
    {
      AppMethodBeat.i(253976);
      this.rect = new Rect();
      Context localContext = localContext.getContext();
      p.g(localContext, "context");
      this.padding = ((int)localContext.getResources().getDimension(2131165306));
      AppMethodBeat.o(253976);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(253975);
      p.h(paramView, "v");
      p.h(paramMotionEvent, "event");
      Object localObject = FinderFullVideoSeekBarLayout.c(this.wcp);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.wcp.wbG) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        this.wcr = ((int)paramMotionEvent.getX());
        this.kuw = ((int)paramMotionEvent.getY());
        this.kuv = this.wcr;
        this.wcs = 0;
        AppMethodBeat.o(253975);
        return true;
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.kuv != 0) && (paramMotionEvent.getAction() == 2)) {
        if (this.wcs != 100)
        {
          i = this.wcs;
          if (i >= 0) {
            break label325;
          }
        }
      }
      while (this.wcs == 100)
      {
        paramView = this.wcp.getSeekBar();
        if (paramView != null)
        {
          if (!this.wcq) {
            this.wcp.onStartTrackingTouch(paramView);
          }
          this.wcq = true;
          paramView.setProgress(kotlin.h.a.cR(((int)paramMotionEvent.getX() - this.wcr) * 0.7F) + paramView.getProgress());
          FinderFullVideoSeekBarLayout.d(this.wcp);
          this.wcr = ((int)paramMotionEvent.getX());
          AppMethodBeat.o(253975);
          return true;
          label325:
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
              AppMethodBeat.o(253975);
              return true;
            }
            if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
            {
              this.wcs = 0;
              this.kuv = 0;
              localObject = this.wcp.getParent();
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
                paramView = this.wcp.getSeekBar();
                if (paramView != null) {
                  this.wcp.onStopTrackingTouch(paramView);
                }
                this.wcq = false;
                AppMethodBeat.o(253975);
                return true;
              }
              if (paramMotionEvent.getAction() == 1)
              {
                i = Math.abs(this.kuv - (int)paramMotionEvent.getX());
                if ((Math.abs(this.kuw - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
                  this.wcp.performClick();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(253975);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderVideoSeekTimeView>
  {
    e(FinderFullVideoSeekBarLayout paramFinderFullVideoSeekBarLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<GestureDetector>
  {
    f(FinderFullVideoSeekBarLayout paramFinderFullVideoSeekBarLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderFullVideoSeekBarLayout
 * JD-Core Version:    0.7.0.1
 */