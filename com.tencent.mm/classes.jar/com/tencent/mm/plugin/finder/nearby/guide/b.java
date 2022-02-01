package com.tencent.mm.plugin.finder.nearby.guide;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.lang.reflect.Method;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper;", "", "()V", "GUIDE_SHOW_CNT_MAX", "", "GUIDE_SHOW_WAITING_MS", "autoPlayRunnable", "Ljava/lang/Runnable;", "gestureDetector", "Landroid/view/GestureDetector;", "gestureDetectorListener", "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1;", "isStartAnim", "", "nextPageFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabFragment;", "rootView", "Landroid/view/View;", "targetView", "targetViewPos", "", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "attachFloatView", "", "cancel", "detachFloatView", "dismissNextPageFragmentGuide", "getCancelAnimSmoothScrollDistance", "getStartAnimSmoothScrollDistance", "isInLeftArea", "e", "Landroid/view/MotionEvent;", "isInRightArea", "isInTopArea", "jumpToNextPageFragment", "setTargetView", "showNextPageFragmentGuide", "smoothScrollTo", "x", "y", "velocity", "start", "startDelay", "delayMs", "", "startInternal", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a EIb;
  public int[] EHO;
  private Runnable EHY;
  private final int EIc;
  private final int EId;
  private NearbyLiveSquareTabFragment EIe;
  private boolean EIf;
  private b EIg;
  private MMHandler mRi;
  public View nmf;
  private GestureDetector nwZ;
  public View rootView;
  
  static
  {
    AppMethodBeat.i(339995);
    EIb = new a((byte)0);
    AppMethodBeat.o(339995);
  }
  
  public b()
  {
    AppMethodBeat.i(339926);
    d locald = d.FAy;
    this.EIc = ((Number)d.eWX().bmg()).intValue();
    locald = d.FAy;
    this.EId = ((Number)d.eWY().bmg()).intValue();
    this.EHO = new int[2];
    this.EIg = new b(this);
    this.nwZ = new GestureDetector((GestureDetector.OnGestureListener)this.EIg);
    this.mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(339926);
  }
  
  private final void QA(int paramInt)
  {
    AppMethodBeat.i(339937);
    View localView;
    try
    {
      Object localObject = ViewPager.class.getDeclaredMethod("smoothScrollTo", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE });
      ((Method)localObject).setAccessible(true);
      localView = this.nmf;
      if (localView == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        AppMethodBeat.o(339937);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.w("FinderLivePageScrollGuideHelper", s.X("smoothScrollTo ", localException.getMessage()));
      AppMethodBeat.o(339937);
      return;
    }
    localException.invoke((ViewPager)localView, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(339937);
  }
  
  private static final void a(b paramb)
  {
    int i = 0;
    AppMethodBeat.i(339962);
    s.u(paramb, "this$0");
    int j = h.baE().ban().getInt(at.a.adeq, 0);
    boolean bool = h.baE().ban().getBoolean(at.a.adep, true);
    Log.i("FinderLivePageScrollGuideHelper", "onAnimationStart scrollGuideCnt:" + j + " isNeverScroll:" + bool);
    if (!bool)
    {
      Log.i("FinderLivePageScrollGuideHelper", s.X("onAnimationStart return for isNeverScroll:", Boolean.valueOf(bool)));
      AppMethodBeat.o(339962);
      return;
    }
    if (j > paramb.EIc)
    {
      Log.i("FinderLivePageScrollGuideHelper", s.X("onAnimationStart return for scrollGuideCnt:", Integer.valueOf(j)));
      AppMethodBeat.o(339962);
      return;
    }
    Object localObject = paramb.rootView;
    s.checkNotNull(localObject);
    localObject = new View(((View)localObject).getContext());
    Log.i("FinderLivePageScrollGuideHelper", s.X("attachFloatView floatView:", localObject));
    ((View)localObject).setTag("FinderLivePageScrollGuideHelper");
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    ((View)localObject).setOnTouchListener(new b..ExternalSyntheticLambda0(paramb));
    View localView = paramb.rootView;
    if (localView == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
      AppMethodBeat.o(339962);
      throw paramb;
    }
    ((CoordinatorLayout)localView).addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = paramb.EIe;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (paramb.EIe != null) {
        break label341;
      }
    }
    label341:
    int k;
    for (;;)
    {
      paramb.QA(i);
      h.baE().ban().set(at.a.adeq, Integer.valueOf(j + 1));
      paramb.EIf = true;
      AppMethodBeat.o(339962);
      return;
      localObject = ((NearbyLiveSquareTabFragment)localObject).getView();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((View)localObject).findViewById(f.d.EGx);
      break;
      localObject = k.aeZF;
      localObject = paramb.EIe;
      s.checkNotNull(localObject);
      localObject = ((NearbyLiveSquareTabFragment)localObject).getParentFragment();
      s.checkNotNull(localObject);
      s.s(localObject, "nextPageFragment!!.parentFragment!!");
      int m = ((com.tencent.mm.plugin.finder.nearby.live.square.b)k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).ELJ.size();
      localObject = k.aeZF;
      localObject = paramb.EIe;
      s.checkNotNull(localObject);
      localObject = ((NearbyLiveSquareTabFragment)localObject).getParentFragment();
      s.checkNotNull(localObject);
      s.s(localObject, "nextPageFragment!!.parentFragment!!");
      k = ((com.tencent.mm.plugin.finder.nearby.live.square.b)k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).getCurrentTabIndex();
      if (m != k + 1) {
        break label497;
      }
      Log.w("FinderLivePageScrollGuideHelper", "getSmoothScrollDistance return 0 for size:" + m + " index:" + k);
    }
    label497:
    localObject = paramb.nmf;
    if (localObject == null) {}
    for (i = 0;; i = ((View)localObject).getWidth())
    {
      localObject = paramb.nmf;
      s.checkNotNull(localObject);
      i = i * k + (int)((View)localObject).getContext().getResources().getDimension(f.b.Edge_8A);
      Log.i("FinderLivePageScrollGuideHelper", s.X("getSmoothScrollDistance distance:", Integer.valueOf(i)));
      break;
    }
  }
  
  private static final boolean a(b paramb, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339942);
    s.u(paramb, "this$0");
    paramb = paramb.nwZ;
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramb, paramView.aYi(), "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper", "attachFloatView$lambda-0", "(Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramb, paramb.onTouchEvent((MotionEvent)paramView.sb(0)), "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper", "attachFloatView$lambda-0", "(Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(339942);
    return bool;
  }
  
  public final void a(NearbyLiveSquareTabFragment paramNearbyLiveSquareTabFragment)
  {
    AppMethodBeat.i(340015);
    Log.i("FinderLivePageScrollGuideHelper", "start delayMs:" + this.EId + " maxCnt:" + this.EIc);
    View localView = this.nmf;
    if (localView != null) {
      localView.getLocationOnScreen(this.EHO);
    }
    this.EIe = paramNearbyLiveSquareTabFragment;
    int i = h.baE().ban().getInt(at.a.adeq, 0);
    boolean bool = h.baE().ban().getBoolean(at.a.adep, true);
    Log.i("FinderLivePageScrollGuideHelper", "start scrollGuideCnt:" + i + " isNeverScroll:" + bool + " pos[" + this.EHO[0] + ", " + this.EHO[1] + ']');
    if (paramNearbyLiveSquareTabFragment == null)
    {
      Log.i("FinderLivePageScrollGuideHelper", s.X("start return for nextPageFragment:", paramNearbyLiveSquareTabFragment));
      AppMethodBeat.o(340015);
      return;
    }
    if (!bool)
    {
      Log.i("FinderLivePageScrollGuideHelper", s.X("start return for isNeverScroll:", Boolean.valueOf(bool)));
      AppMethodBeat.o(340015);
      return;
    }
    if (i > this.EIc)
    {
      Log.i("FinderLivePageScrollGuideHelper", s.X("start return for scrollGuideCnt:", Integer.valueOf(i)));
      AppMethodBeat.o(340015);
      return;
    }
    long l = this.EId;
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    this.EHY = new b..ExternalSyntheticLambda1(this);
    this.mRi.postDelayed(this.EHY, l);
    AppMethodBeat.o(340015);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(340023);
    Log.i("FinderLivePageScrollGuideHelper", "cancel");
    if (this.EHY != null)
    {
      this.mRi.removeCallbacks(this.EHY);
      this.EHY = null;
    }
    if (!this.EIf)
    {
      Log.i("FinderLivePageScrollGuideHelper", s.X("cancel for isStartAnim:", Boolean.valueOf(this.EIf)));
      AppMethodBeat.o(340023);
      return;
    }
    int i;
    if (this.EIe == null)
    {
      i = 0;
      QA(i);
      localObject = this.EIe;
      if (localObject != null) {
        break label346;
      }
      localObject = null;
      label94:
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.rootView;
      if (localObject != null) {
        break label371;
      }
    }
    View localView;
    label346:
    label371:
    for (Object localObject = null;; localObject = ((View)localObject).findViewWithTag("FinderLivePageScrollGuideHelper"))
    {
      if (localObject != null) {
        ((View)localObject).setOnTouchListener(null);
      }
      Log.i("FinderLivePageScrollGuideHelper", s.X("detachFloatView view:", localObject));
      localView = this.rootView;
      if (localView != null) {
        break label381;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
      AppMethodBeat.o(340023);
      throw ((Throwable)localObject);
      localObject = k.aeZF;
      localObject = this.EIe;
      s.checkNotNull(localObject);
      localObject = ((NearbyLiveSquareTabFragment)localObject).getParentFragment();
      s.checkNotNull(localObject);
      s.s(localObject, "nextPageFragment!!.parentFragment!!");
      i = ((com.tencent.mm.plugin.finder.nearby.live.square.b)k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).ELJ.size();
      localObject = k.aeZF;
      localObject = this.EIe;
      s.checkNotNull(localObject);
      localObject = ((NearbyLiveSquareTabFragment)localObject).getParentFragment();
      s.checkNotNull(localObject);
      s.s(localObject, "nextPageFragment!!.parentFragment!!");
      int j = ((com.tencent.mm.plugin.finder.nearby.live.square.b)k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).getCurrentTabIndex();
      if (i == j + 1)
      {
        Log.w("FinderLivePageScrollGuideHelper", "getSmoothScrollDistance return 0 for size:" + i + " index:" + j);
        i = 0;
        break;
      }
      localObject = this.nmf;
      if (localObject == null) {}
      for (i = 0;; i = ((View)localObject).getWidth())
      {
        i *= j;
        Log.i("FinderLivePageScrollGuideHelper", s.X("getSmoothScrollDistance distance:", Integer.valueOf(i)));
        break;
      }
      localObject = ((NearbyLiveSquareTabFragment)localObject).getView();
      if (localObject == null)
      {
        localObject = null;
        break label94;
      }
      localObject = ((View)localObject).findViewById(f.d.EGx);
      break label94;
    }
    label381:
    ((CoordinatorLayout)localView).removeView((View)localObject);
    this.EIf = false;
    AppMethodBeat.o(340023);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements GestureDetector.OnGestureListener
  {
    b(b paramb) {}
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(339939);
      Log.i("FinderLivePageScrollGuideHelper", "onDown");
      if (b.a(this.EIh, paramMotionEvent))
      {
        AppMethodBeat.o(339939);
        return false;
      }
      if (b.b(this.EIh, paramMotionEvent))
      {
        AppMethodBeat.o(339939);
        return true;
      }
      if (b.c(this.EIh, paramMotionEvent))
      {
        AppMethodBeat.o(339939);
        return true;
      }
      AppMethodBeat.o(339939);
      return true;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(339949);
      StringBuilder localStringBuilder = new StringBuilder("onFling e1:");
      Object localObject1;
      if (paramMotionEvent1 == null)
      {
        localObject1 = null;
        localObject1 = localStringBuilder.append(localObject1).append(" e2:");
        if (paramMotionEvent2 != null) {
          break label110;
        }
      }
      label110:
      for (paramMotionEvent2 = localObject2;; paramMotionEvent2 = Float.valueOf(paramMotionEvent2.getX()))
      {
        Log.i("FinderLivePageScrollGuideHelper", paramMotionEvent2 + " velocityX:" + paramFloat1 + " velocityY:" + paramFloat2);
        if (!b.a(this.EIh, paramMotionEvent1)) {
          break label121;
        }
        AppMethodBeat.o(339949);
        return false;
        localObject1 = Float.valueOf(paramMotionEvent1.getX());
        break;
      }
      label121:
      if (b.b(this.EIh, paramMotionEvent1))
      {
        AppMethodBeat.o(339949);
        return true;
      }
      if (b.c(this.EIh, paramMotionEvent1))
      {
        AppMethodBeat.o(339949);
        return true;
      }
      AppMethodBeat.o(339949);
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(339964);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      Log.i("FinderLivePageScrollGuideHelper", "onLongPress");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(339964);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(339956);
      StringBuilder localStringBuilder = new StringBuilder("onScroll e1:");
      Object localObject1;
      if (paramMotionEvent1 == null)
      {
        localObject1 = null;
        localObject1 = localStringBuilder.append(localObject1).append(" e2:");
        if (paramMotionEvent2 != null) {
          break label110;
        }
      }
      label110:
      for (paramMotionEvent2 = localObject2;; paramMotionEvent2 = Float.valueOf(paramMotionEvent2.getX()))
      {
        Log.i("FinderLivePageScrollGuideHelper", paramMotionEvent2 + " distanceX:" + paramFloat1 + " distanceY:" + paramFloat2);
        if (!b.a(this.EIh, paramMotionEvent1)) {
          break label121;
        }
        AppMethodBeat.o(339956);
        return false;
        localObject1 = Float.valueOf(paramMotionEvent1.getX());
        break;
      }
      label121:
      if (b.b(this.EIh, paramMotionEvent1))
      {
        if (paramFloat1 > 10.0F)
        {
          this.EIh.cancel();
          b.b(this.EIh);
        }
        for (;;)
        {
          AppMethodBeat.o(339956);
          return true;
          this.EIh.cancel();
        }
      }
      if (b.c(this.EIh, paramMotionEvent1))
      {
        if (paramFloat1 > 10.0F)
        {
          this.EIh.cancel();
          b.b(this.EIh);
        }
        for (;;)
        {
          AppMethodBeat.o(339956);
          return true;
          this.EIh.cancel();
        }
      }
      AppMethodBeat.o(339956);
      return true;
    }
    
    public final void onShowPress(MotionEvent paramMotionEvent) {}
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(339931);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      Log.i("FinderLivePageScrollGuideHelper", "onSingleTapUp");
      if (b.a(this.EIh, paramMotionEvent))
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(339931);
        return false;
      }
      if (b.b(this.EIh, paramMotionEvent))
      {
        this.EIh.cancel();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(339931);
        return true;
      }
      if (b.c(this.EIh, paramMotionEvent))
      {
        this.EIh.cancel();
        b.b(this.EIh);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(339931);
        return true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/nearby/guide/FinderLivePageScrollGuideHelper$gestureDetectorListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(339931);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.guide.b
 * JD-Core Version:    0.7.0.1
 */