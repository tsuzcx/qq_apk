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
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "dismissProgressBar", "", "dismissProgressBarThumb", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "getMaxProgress", "isSeekingMode", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "callback", "showBigProgressBar", "isShowThumb", "showProgressBar", "showProgressBarThumb", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoSeekBar
  extends FrameLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, s, FinderViewPager.a
{
  public static final FinderVideoSeekBar.a GqW;
  private static final int Grd;
  private boolean Gng;
  private s.a Gnm;
  boolean Gnn;
  private final Rect GqX;
  private final j GqY;
  private final boolean GqZ;
  private final j Gra;
  private final b Grb;
  private int Grc;
  
  static
  {
    AppMethodBeat.i(335498);
    GqW = new FinderVideoSeekBar.a((byte)0);
    Grd = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(335498);
  }
  
  public FinderVideoSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(335407);
    this.GqX = new Rect();
    this.GqY = k.cm((kotlin.g.a.a)new f(this));
    paramContext = d.FAy;
    this.GqZ = d.eRG();
    this.Gra = k.cm((kotlin.g.a.a)new e(this));
    this.Grb = new b(this);
    setId(e.e.preview_seek_bar_layout);
    if (this.GqZ) {
      setOnTouchListener((View.OnTouchListener)this.Grb);
    }
    LayoutInflater.from(getContext()).inflate(e.f.finder_video_seek_bar_layout, (ViewGroup)this);
    getVideoSeekBar().setVisibility(4);
    AppMethodBeat.o(335407);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335415);
    this.GqX = new Rect();
    this.GqY = k.cm((kotlin.g.a.a)new f(this));
    paramContext = d.FAy;
    this.GqZ = d.eRG();
    this.Gra = k.cm((kotlin.g.a.a)new e(this));
    this.Grb = new b(this);
    setId(e.e.preview_seek_bar_layout);
    if (this.GqZ) {
      setOnTouchListener((View.OnTouchListener)this.Grb);
    }
    LayoutInflater.from(getContext()).inflate(e.f.finder_video_seek_bar_layout, (ViewGroup)this);
    getVideoSeekBar().setVisibility(4);
    AppMethodBeat.o(335415);
  }
  
  public FinderVideoSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335423);
    this.GqX = new Rect();
    this.GqY = k.cm((kotlin.g.a.a)new f(this));
    paramContext = d.FAy;
    this.GqZ = d.eRG();
    this.Gra = k.cm((kotlin.g.a.a)new e(this));
    this.Grb = new b(this);
    setId(e.e.preview_seek_bar_layout);
    if (this.GqZ) {
      setOnTouchListener((View.OnTouchListener)this.Grb);
    }
    LayoutInflater.from(getContext()).inflate(e.f.finder_video_seek_bar_layout, (ViewGroup)this);
    getVideoSeekBar().setVisibility(4);
    AppMethodBeat.o(335423);
  }
  
  private final void fjB()
  {
    AppMethodBeat.i(335445);
    Object localObject = getVideoSeekBar();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((SeekBar)localObject).getThumb())
    {
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(255);
      }
      AppMethodBeat.o(335445);
      return;
    }
  }
  
  private final void fjC()
  {
    AppMethodBeat.i(335452);
    Object localObject = getVideoSeekBar();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((SeekBar)localObject).getThumb())
    {
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(0);
      }
      AppMethodBeat.o(335452);
      return;
    }
  }
  
  private final GestureDetector getTouchDetector()
  {
    AppMethodBeat.i(335436);
    GestureDetector localGestureDetector = (GestureDetector)this.Gra.getValue();
    AppMethodBeat.o(335436);
    return localGestureDetector;
  }
  
  private final SeekBar getVideoSeekBar()
  {
    AppMethodBeat.i(335431);
    SeekBar localSeekBar = (SeekBar)this.GqY.getValue();
    AppMethodBeat.o(335431);
    return localSeekBar;
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(335723);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    AppMethodBeat.o(335723);
    return true;
  }
  
  public final void aCk(String paramString)
  {
    AppMethodBeat.i(335605);
    kotlin.g.b.s.u(paramString, "reason");
    this.Gnn = false;
    AppMethodBeat.o(335605);
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(335730);
    if ((this.Gng) || (super.canScrollVertically(paramInt)))
    {
      AppMethodBeat.o(335730);
      return true;
    }
    AppMethodBeat.o(335730);
    return false;
  }
  
  public final void co(float paramFloat)
  {
    AppMethodBeat.i(335626);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null) {
      localSeekBar.setProgress(kotlin.h.a.eH(localSeekBar.getMax() * paramFloat));
    }
    AppMethodBeat.o(335626);
  }
  
  public final void fiE()
  {
    AppMethodBeat.i(335589);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null)
    {
      getVideoSeekBar().setTag(null);
      if (localSeekBar.getVisibility() == 4)
      {
        AppMethodBeat.o(335589);
        return;
      }
      localSeekBar.setVisibility(4);
    }
    AppMethodBeat.o(335589);
  }
  
  public final boolean fiF()
  {
    AppMethodBeat.i(335669);
    SeekBar localSeekBar = getVideoSeekBar();
    if ((localSeekBar != null) && (localSeekBar.getVisibility() == 0))
    {
      AppMethodBeat.o(335669);
      return true;
    }
    AppMethodBeat.o(335669);
    return false;
  }
  
  public final boolean fiG()
  {
    return this.Gnn;
  }
  
  public final void fiH()
  {
    this.Gnn = true;
  }
  
  public final int getCurrentProgress()
  {
    AppMethodBeat.i(335645);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar == null)
    {
      AppMethodBeat.o(335645);
      return 0;
    }
    int i = localSeekBar.getProgress();
    AppMethodBeat.o(335645);
    return i;
  }
  
  public final int getMaxProgress()
  {
    AppMethodBeat.i(335654);
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar == null)
    {
      AppMethodBeat.o(335654);
      return 1;
    }
    int i = localSeekBar.getProgress();
    AppMethodBeat.o(335654);
    return i;
  }
  
  public final void iw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335618);
    if ((getVideoSeekBar() != null) && (Log.getLogLevel() <= 1)) {
      Log.d("Finder.VideoSeekBar", "[updateProgressSec] offsetSec=" + paramInt1 + " allSec=" + paramInt2);
    }
    AppMethodBeat.o(335618);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335736);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(335736);
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
    AppMethodBeat.i(335570);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.GqX.isEmpty()) {
      this.GqX.set(getVideoSeekBar().getProgressDrawable().getBounds());
    }
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = getVideoSeekBar().getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(335570);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = getParent();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(335570);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((ViewGroup)localObject2).findViewById(e.e.warn_container);
      if (((View)localObject2).getVisibility() != 0) {
        break label232;
      }
      paramInt2 = -Grd;
      if (localObject2 != null) {
        break label223;
      }
      paramInt1 = 0;
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = (paramInt1 + paramInt2);
      getVideoSeekBar().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      Log.i("Finder.VideoSeekBar", "bottomMargin=" + ((FrameLayout.LayoutParams)localObject1).bottomMargin + ", warnView visibility=" + ((View)localObject2).getVisibility());
      AppMethodBeat.o(335570);
      return;
      label223:
      paramInt1 = ((View)localObject2).getHeight();
      break;
      label232:
      if (((FrameLayout.LayoutParams)localObject1).bottomMargin != -Grd)
      {
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = (-Grd);
        getVideoSeekBar().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335713);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(335713);
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(335543);
    kotlin.g.b.s.u(paramSeekBar, "seekBar");
    AppMethodBeat.o(335543);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(335752);
    paramMotionEvent = this.Gnm;
    if ((paramMotionEvent != null) && (paramMotionEvent.fjA() == true)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.w("Finder.VideoSeekBar", "[onSingleTapConfirmed] is Disable Seek");
      AppMethodBeat.o(335752);
      return false;
    }
    boolean bool1;
    if (!this.Gnn)
    {
      ux(true);
      paramMotionEvent = this.Gnm;
      if (paramMotionEvent != null) {
        paramMotionEvent.uG(true);
      }
      bool1 = true;
    }
    for (;;)
    {
      this.Gnn = bool1;
      Log.i("Finder.VideoSeekBar", "[onClick]...isShownSeekBar=" + fiF() + " isSeekMode=" + this.Gnn + " thumb=" + getVideoSeekBar().getAlpha());
      AppMethodBeat.o(335752);
      return true;
      ux(false);
      paramMotionEvent = this.Gnm;
      bool1 = bool2;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.uG(false);
        bool1 = bool2;
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335685);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(335685);
    return false;
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(335535);
    kotlin.g.b.s.u(paramSeekBar, "seekBar");
    Object localObject = this.Gnm;
    if ((localObject != null) && (((s.a)localObject).fjA() == true)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.w("Finder.VideoSeekBar", "[onStartTrackingTouch] is Disable Seek");
      AppMethodBeat.o(335535);
      return;
    }
    paramSeekBar.animate().cancel();
    this.Gng = true;
    localObject = getVideoSeekBar();
    if (localObject != null) {
      ((SeekBar)localObject).setVisibility(0);
    }
    for (localObject = getParent(); (localObject != null) && (!(localObject instanceof FinderMediaBanner)); localObject = ((ViewParent)localObject).getParent()) {}
    if ((localObject instanceof FinderMediaBanner)) {}
    for (localObject = (FinderMediaBanner)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((FinderMediaBanner)localObject).setFrozenRecyclerView(true);
      }
      fjB();
      if (!kotlin.g.b.s.p(getVideoSeekBar().getTag(), Boolean.TRUE))
      {
        getVideoSeekBar().setVisibility(0);
        getVideoSeekBar().getProgressDrawable().setBounds(new Rect(this.GqX));
        getVideoSeekBar().invalidate();
        getVideoSeekBar().setTag(Boolean.TRUE);
      }
      localObject = this.Gnm;
      if (localObject != null)
      {
        paramSeekBar.setProgress((int)(1.0F * ((s.a)localObject).getCurrentPosSec() / ((s.a)localObject).getVideoDurationSec() * paramSeekBar.getMax()));
        ((s.a)localObject).fjz();
      }
      AppMethodBeat.o(335535);
      return;
    }
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = 1;
    AppMethodBeat.i(335556);
    kotlin.g.b.s.u(paramSeekBar, "seekBar");
    Object localObject = this.Gnm;
    if ((localObject != null) && (((s.a)localObject).fjA() == true)) {}
    while (i == 0)
    {
      Log.w("Finder.VideoSeekBar", "[onStopTrackingTouch] is Disable Seek");
      AppMethodBeat.o(335556);
      return;
      i = 0;
    }
    float f = 1.0F * paramSeekBar.getProgress() / paramSeekBar.getMax();
    Log.i("Finder.VideoSeekBar", kotlin.g.b.s.X("[onStopTrackingTouch] percent=", Float.valueOf(f)));
    for (localObject = getParent(); (localObject != null) && (!(localObject instanceof FinderMediaBanner)); localObject = ((ViewParent)localObject).getParent()) {}
    if ((localObject instanceof FinderMediaBanner)) {}
    for (localObject = (FinderMediaBanner)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((FinderMediaBanner)localObject).setFrozenRecyclerView(false);
      }
      ux(this.Gnn);
      setProgress(paramSeekBar.getProgress());
      paramSeekBar = this.Gnm;
      if (paramSeekBar != null) {
        paramSeekBar.cq(f);
      }
      this.Gng = false;
      AppMethodBeat.o(335556);
      return;
    }
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(335638);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.VideoSeekBar", kotlin.g.b.s.X("[setProgress] target=", Integer.valueOf(paramInt)));
    }
    this.Grc = paramInt;
    SeekBar localSeekBar = getVideoSeekBar();
    if (localSeekBar != null) {
      localSeekBar.setProgress(paramInt);
    }
    AppMethodBeat.o(335638);
  }
  
  public final void setSeekBarCallback(s.a parama)
  {
    AppMethodBeat.i(335660);
    kotlin.g.b.s.u(parama, "callback");
    this.Gnm = parama;
    AppMethodBeat.o(335660);
  }
  
  public final void setSeekMode(boolean paramBoolean)
  {
    this.Gnn = paramBoolean;
  }
  
  public final void ux(boolean paramBoolean)
  {
    AppMethodBeat.i(335582);
    if (paramBoolean) {
      fjB();
    }
    while (kotlin.g.b.s.p(getVideoSeekBar().getTag(), Boolean.FALSE))
    {
      AppMethodBeat.o(335582);
      return;
      fjC();
    }
    getVideoSeekBar().setVisibility(0);
    kotlin.g.a.a locala = (kotlin.g.a.a)new d(this);
    if (this.GqX.isEmpty())
    {
      addOnLayoutChangeListener((View.OnLayoutChangeListener)new FinderVideoSeekBar.c(locala, this));
      AppMethodBeat.o(335582);
      return;
    }
    locala.invoke();
    AppMethodBeat.o(335582);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnTouchListener
  {
    private boolean Gre;
    private int Grf;
    private int Grg;
    private final int padding;
    private int qjs;
    private int qjt;
    private final Rect rect;
    
    b(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      AppMethodBeat.i(334697);
      this.rect = new Rect();
      this.padding = ((int)this.Grh.getContext().getResources().getDimension(e.c.Edge_5A));
      AppMethodBeat.o(334697);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(334710);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(paramMotionEvent, "event");
      Object localObject = FinderVideoSeekBar.d(this.Grh);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramView.getFocusedRect(this.rect);
      paramView = this.rect;
      paramView.left += this.padding;
      if ((paramMotionEvent.getAction() == 0) && ((this.Grh.Gnn) || (this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
      {
        if (FinderVideoSeekBar.e(this.Grh) != null)
        {
          paramView = FinderVideoSeekBar.e(this.Grh);
          if (paramView != null) {
            break label229;
          }
        }
        label229:
        for (paramView = null;; paramView = Boolean.valueOf(paramView.ad(paramMotionEvent)))
        {
          kotlin.g.b.s.checkNotNull(paramView);
          if (paramView.booleanValue()) {
            break;
          }
          this.Grf = ((int)paramMotionEvent.getX());
          this.qjt = ((int)paramMotionEvent.getY());
          this.qjs = this.Grf;
          this.Grg = 0;
          AppMethodBeat.o(334710);
          return true;
        }
      }
      int i;
      if ((paramMotionEvent.getPointerCount() <= 1) && (this.qjs != 0) && (paramMotionEvent.getAction() == 2))
      {
        if (this.Grg != 100)
        {
          i = this.Grg;
          if (i >= 0) {
            if (i <= 4)
            {
              i = 1;
              if (i == 0) {
                break label387;
              }
              i = Math.abs(this.qjs - (int)paramMotionEvent.getX());
              int j = Math.abs(this.qjt - (int)paramMotionEvent.getY());
              if ((i < 8) || ((j > 0) && (i / j < 2))) {
                break label377;
              }
            }
          }
          label377:
          for (i = 100;; i = this.Grg + 1)
          {
            this.Grg = i;
            if (this.Grg == 100) {
              break label387;
            }
            AppMethodBeat.o(334710);
            return true;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        label387:
        if (this.Grg == 100)
        {
          paramView = FinderVideoSeekBar.a(this.Grh);
          if (paramView != null)
          {
            localObject = this.Grh;
            if (!this.Gre) {
              ((FinderVideoSeekBar)localObject).onStartTrackingTouch(paramView);
            }
            this.Gre = true;
            paramView.setProgress(kotlin.h.a.eH(((int)paramMotionEvent.getX() - this.Grf) * 0.7F) + paramView.getProgress());
            this.Grf = ((int)paramMotionEvent.getX());
            AppMethodBeat.o(334710);
            return true;
          }
        }
      }
      else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.Grg = 0;
        this.qjs = 0;
        paramView = this.Grh.getParent();
        if ((paramView instanceof FinderMediaBanner)) {}
        for (paramView = (FinderMediaBanner)paramView;; paramView = null)
        {
          if (paramView != null) {
            paramView.setFrozenRecyclerView(false);
          }
          if (!this.Gre) {
            break;
          }
          paramView = FinderVideoSeekBar.a(this.Grh);
          if (paramView != null) {
            this.Grh.onStopTrackingTouch(paramView);
          }
          this.Gre = false;
          AppMethodBeat.o(334710);
          return true;
        }
        if (paramMotionEvent.getAction() == 1)
        {
          i = Math.abs(this.qjs - (int)paramMotionEvent.getX());
          if ((Math.abs(this.qjt - (int)paramMotionEvent.getY()) <= 5) && (i <= 5)) {
            this.Grh.performClick();
          }
        }
      }
      AppMethodBeat.o(334710);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<GestureDetector>
  {
    e(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<SeekBar>
  {
    f(FinderVideoSeekBar paramFinderVideoSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar
 * JD-Core Version:    0.7.0.1
 */