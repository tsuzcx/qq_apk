package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private boolean canScroll = true;
  private Rect flM = new Rect();
  private boolean isActive = false;
  Paint mPaint = new Paint();
  protected Rect mRect = new Rect();
  private RecyclerView mRecyclerView;
  GestureDetector pCU;
  protected Rect rqA = new Rect();
  protected Rect rqB = new Rect();
  private Vibrator rqC = (Vibrator)getContext().getSystemService("vibrator");
  private boolean rqD = true;
  private FrameLayout rqE;
  private a rqF;
  private a rqG;
  private boolean rqH = false;
  boolean rqI = false;
  private g rqJ = null;
  private boolean rqK = false;
  private Runnable rqL;
  private Animator.AnimatorListener rqM = new Animator.AnimatorListener()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      AppMethodBeat.i(49647);
      DragFeatureView.d(DragFeatureView.this);
      DragFeatureView.this.requestLayout();
      if ((DragFeatureView.g(DragFeatureView.this)) && ((DragFeatureView.h(DragFeatureView.this) instanceof DragRecyclerView)))
      {
        ((DragRecyclerView)DragFeatureView.h(DragFeatureView.this)).setLongPress(false);
        DragFeatureView.i(DragFeatureView.this);
        DragFeatureView.j(DragFeatureView.this);
      }
      AppMethodBeat.o(49647);
    }
    
    public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
    
    public final void onAnimationStart(Animator paramAnonymousAnimator) {}
  };
  protected int rqt = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_desktop_close_area_height) + com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_desktop_close_area_extra);
  private Runnable rqu;
  private c rqv;
  protected RecyclerView.v rqw;
  private int rqx = -1;
  private Vibrator rqy;
  private View rqz;
  
  public DragFeatureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DragFeatureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private boolean R(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private boolean aX(float paramFloat)
  {
    return (this.rqF.getVisibility() == 0) && (paramFloat < getRubbishRect().centerX());
  }
  
  private void cnF()
  {
    Log.i("MicroMsg.DragFeatureView", "resetRubbishView");
    this.isActive = false;
    this.rqF.setActive(false);
    this.rqG.setActive(false);
  }
  
  private View cnG()
  {
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(getContext());
    float f = com.tencent.mm.ci.a.aZ(getContext(), au.d.Edge_A);
    localRoundedCornerFrameLayout.v(f, f, 0.0F, 0.0F);
    localRoundedCornerFrameLayout.setId(au.f.rubbish_view);
    localRoundedCornerFrameLayout.setTranslationY(this.rqt);
    Object localObject = new FrameLayout.LayoutParams(-1, this.rqt);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    localRoundedCornerFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(getContext());
    ((LinearLayout)localObject).setOrientation(0);
    ((LinearLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localRoundedCornerFrameLayout.addView((View)localObject);
    this.rqF = new a(getContext());
    this.rqF.b(au.h.appbrand_icon_star_off, au.h.appbrand_icon_star_on, au.i.app_brand_desktop_menu_add_to_my_app_brand, au.i.app_brand_desktop_menu_add_to_my_app_brand_release, au.c.app_brand_desktop_star_normal_bg_color, au.c.app_brand_desktop_star_release_bg_color);
    ((LinearLayout)localObject).addView(this.rqF);
    this.rqG = new a(getContext());
    this.rqG.b(au.h.icons_filled_delete, au.h.icons_filled_delete_on, au.i.app_brand_desktop_delete_normal_text, au.i.app_brand_desktop_release_delete_text, au.c.app_brand_desktop_delete_normal_bg_color, au.c.app_brand_desktop_delete_release_bg_color);
    ((LinearLayout)localObject).addView(this.rqG);
    this.rqE = localRoundedCornerFrameLayout;
    return localRoundedCornerFrameLayout;
  }
  
  private void init(Context paramContext)
  {
    setVisibility(8);
    this.pCU = new GestureDetector(paramContext, this);
    this.rqy = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(cnG());
  }
  
  private void kf(final boolean paramBoolean)
  {
    if (this.rqL == null)
    {
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49645);
          Log.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", new Object[] { Boolean.valueOf(paramBoolean) });
          RecyclerView localRecyclerView = DragFeatureView.this.getRecyclerView();
          if (paramBoolean)
          {
            i = -10;
            Log.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", new Object[] { Boolean.valueOf(localRecyclerView.canScrollVertically(i)) });
            localRecyclerView = DragFeatureView.this.getRecyclerView();
            if (!paramBoolean) {
              break label111;
            }
          }
          label111:
          for (int i = -20;; i = 20)
          {
            localRecyclerView.scrollBy(0, i);
            DragFeatureView.this.post(this);
            AppMethodBeat.o(49645);
            return;
            i = 10;
            break;
          }
        }
      };
      this.rqL = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private void kg(boolean paramBoolean)
  {
    Log.i("MicroMsg.DragFeatureView", "resetStatus %b", new Object[] { Boolean.valueOf(paramBoolean) });
    removeCallbacks(this.rqu);
    removeCallbacks(this.rqL);
    setRubbishViewVisible(8);
    int i = this.rqx;
    this.rqx = -1;
    this.isActive = false;
    this.rqv.a(getRecyclerView(), this.rqw, i, paramBoolean, true, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49646);
        DragFeatureView.this.setVisibility(8);
        DragFeatureView.e(DragFeatureView.this);
        DragFeatureView.f(DragFeatureView.this);
        AppMethodBeat.o(49646);
      }
    });
  }
  
  private void setItemDragCallback(c paramc)
  {
    this.rqv = paramc;
  }
  
  protected boolean N(MotionEvent paramMotionEvent)
  {
    if (getTopScrollRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
    {
      kf(true);
      return true;
    }
    if (getBottomScrollRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
    {
      kf(false);
      return true;
    }
    if (getRubbishRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
    {
      removeCallbacks(this.rqu);
      removeCallbacks(this.rqL);
      this.rqL = null;
      return true;
    }
    return false;
  }
  
  public final void cnE()
  {
    if (this.rqI)
    {
      Log.i("MicroMsg.DragFeatureView", "resetIfNeeded trigger");
      kg(false);
    }
  }
  
  protected abstract c cnn();
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    if (getVisibility() == 8) {
      return;
    }
    Log.i("MicroMsg.DragFeatureView", "onBindViewHolder %d %d", new Object[] { Integer.valueOf(this.rqx), Integer.valueOf(paramInt) });
    if (this.rqx == paramInt)
    {
      paramv.amk.setVisibility(4);
      return;
    }
    paramv.amk.setVisibility(0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.rqA != null) {
      paramCanvas.drawRect(this.rqA, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.rqB != null) {
      paramCanvas.drawRect(this.rqB, this.mPaint);
    }
  }
  
  protected RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.rqA.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.v localv = getRecyclerView().aQ(getRecyclerView().getChildAt(i));
      localv.amk.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localv;
      }
      i += 1;
    }
    if (this.rqB.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public Rect getBottomScrollRect()
  {
    return this.rqA;
  }
  
  public c getItemDragCallback()
  {
    return this.rqv;
  }
  
  public g getRecyclerScrollComputer()
  {
    return this.rqJ;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public Rect getRubbishRect()
  {
    return this.flM;
  }
  
  public Rect getTopScrollRect()
  {
    return this.rqB;
  }
  
  public final void in(boolean paramBoolean)
  {
    Log.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.canScroll = paramBoolean;
  }
  
  public final void kh(boolean paramBoolean)
  {
    int i = 0;
    Log.i("MicroMsg.DragFeatureView", "enableStar %b", new Object[] { Boolean.valueOf(paramBoolean) });
    a locala = this.rqF;
    if (paramBoolean) {}
    for (;;)
    {
      locala.setVisibility(i);
      this.rqF.getParent().requestLayout();
      return;
      i = 8;
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGlobalVisibleRect(this.rqA);
    this.rqA.set(this.rqA.left, this.rqA.bottom - this.rqt * 2, this.rqA.right, this.rqA.bottom - this.rqt);
    getRecyclerView().getGlobalVisibleRect(this.rqB);
    this.rqB.set(this.rqB.left, 0, this.rqB.right, this.rqB.top + this.rqt);
    findViewById(au.f.rubbish_view).getGlobalVisibleRect(this.flM);
  }
  
  @SuppressLint({"MissingPermission"})
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if (this.rqI)
    {
      Log.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
      this.rqI = false;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
    Log.i("MicroMsg.DragFeatureView", "onLongPress");
    this.rqI = true;
    localObject1 = e(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
    setItemDragCallback(cnn());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.rqv;
      getRecyclerView();
      if (((c)localObject2).Q((RecyclerView.v)localObject1))
      {
        this.rqz = this.rqv.e(getRecyclerView(), (RecyclerView.v)localObject1);
        if (this.rqz != null)
        {
          setVisibility(8);
          this.rqx = ((RecyclerView.v)localObject1).md();
          this.rqw = ((RecyclerView.v)localObject1);
          this.rqy.vibrate(30L);
          setRubbishViewVisible(0);
          setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramMotionEvent.setAction(0);
      localObject1 = this.pCU;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramMotionEvent.setAction(3);
      localObject1 = this.pCU;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramMotionEvent.aFh(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
      setRubbishViewVisible(8);
      setVisibility(8);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if (getVisibility() == 8) {
      return false;
    }
    float f1 = paramMotionEvent2.getRawX();
    float f2 = paramMotionEvent2.getRawY();
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    int i;
    if (!this.mRect.contains((int)f1, (int)f2)) {
      if (f1 < this.mRect.left) {
        i = 3;
      }
    }
    for (;;)
    {
      paramMotionEvent1 = e(paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY(), false);
      if (this.canScroll) {
        break;
      }
      paramMotionEvent1 = this.rqv;
      getRecyclerView();
      paramMotionEvent1.b(this.rqz, paramFloat1, paramFloat2, paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY());
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.rqA.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.rqB.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (R(f1, f2))
      {
        i = 6;
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= getRecyclerView().getChildCount()) {
            break label280;
          }
          getRecyclerView().aQ(getRecyclerView().getChildAt(i)).amk.getGlobalVisibleRect(this.mRect);
          if (this.mRect.contains((int)f1, (int)f2))
          {
            i = 5;
            break;
          }
          i += 1;
        }
        label280:
        i = 7;
      }
    }
    if (paramMotionEvent1 == null) {
      bool = true;
    }
    f1 = paramMotionEvent2.getRawX();
    f2 = paramMotionEvent2.getRawY();
    int j;
    if (paramMotionEvent1 != null)
    {
      j = paramMotionEvent1.amo;
      Log.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label533;
      }
      N(paramMotionEvent2);
      label393:
      c localc = this.rqv;
      getRecyclerView();
      localc.b(this.rqz, paramFloat1, paramFloat2, paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY());
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.rqL);
        this.rqL = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.rqu);
        getRecyclerView();
        if ((paramMotionEvent1 == null) || (paramMotionEvent1.amo != 5)) {
          break label561;
        }
        paramMotionEvent1 = new b(paramMotionEvent1);
        this.rqu = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
    }
    for (;;)
    {
      return true;
      j = -1;
      break;
      label533:
      if ((i != 3) && (i != 4))
      {
        getRecyclerView();
        break label393;
      }
      getRecyclerView();
      break label393;
      label561:
      paramMotionEvent1 = new b(paramMotionEvent1);
      this.rqu = paramMotionEvent1;
      postDelayed(paramMotionEvent1, 150L);
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.rqD) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramView = this.pCU;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      return true;
      boolean bool;
      if (R(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        bool = aX(paramMotionEvent.getRawX());
        Log.i("MicroMsg.DragFeatureView", "handleDoAction %b", new Object[] { Boolean.valueOf(bool) });
        int i = this.rqx;
        this.isActive = false;
        if (bool)
        {
          paramView = this.rqv;
          getRecyclerView();
          paramView.T(this.rqw);
          kg(true);
        }
        else
        {
          this.rqv.a(getRecyclerView(), this.rqw, i, true, false, null);
          this.rqx = -1;
          this.rqv.f(getRecyclerView(), this.rqw);
          if (this.rqz != null) {
            this.rqz.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
            {
              public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(49644);
                DragFeatureView.this.removeView(DragFeatureView.c(DragFeatureView.this));
                DragFeatureView.d(DragFeatureView.this);
                DragFeatureView.this.setRubbishViewVisible(8);
                AppMethodBeat.o(49644);
              }
              
              public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
              
              public final void onAnimationStart(Animator paramAnonymousAnimator) {}
            }).setDuration(300L).start();
          }
          removeCallbacks(this.rqu);
          removeCallbacks(this.rqL);
        }
      }
      else
      {
        kg(false);
        continue;
        if (R(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          bool = aX(paramMotionEvent.getRawX());
          Log.i("MicroMsg.DragFeatureView", "handleActive %b", new Object[] { Boolean.valueOf(bool) });
          if (!this.isActive)
          {
            if (this.rqC != null) {
              this.rqC.vibrate(10L);
            }
            this.rqH = bool;
            label401:
            this.isActive = true;
            this.rqF.setActive(bool);
            paramView = this.rqG;
            if (bool) {
              break label472;
            }
          }
          label472:
          for (bool = true;; bool = false)
          {
            paramView.setActive(bool);
            break;
            if (bool == this.rqH) {
              break label401;
            }
            if (this.rqC != null) {
              this.rqC.vibrate(10L);
            }
            this.rqH = bool;
            break label401;
          }
        }
        cnF();
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(g paramg)
  {
    this.rqJ = paramg;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(au.f.rubbish_view);
    if (localView == null) {
      return;
    }
    Log.i("MicroMsg.DragFeatureView", "setRubbishViewVisible %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      localView.requestLayout();
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.rqM).start();
      return;
    }
    this.rqK = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.rqM).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.rqD = paramBoolean;
  }
  
  static final class a
    extends LinearLayout
  {
    private TextView bFR;
    private int iconRes;
    private WeImageView jQn;
    private int rqP;
    private int rqQ;
    private int rqR;
    private int rqS;
    private int rqT;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(283819);
      setOrientation(0);
      setOrientation(1);
      setGravity(17);
      paramContext = new LinearLayout.LayoutParams(0, -1);
      paramContext.weight = 1.0F;
      setLayoutParams(paramContext);
      AppMethodBeat.o(283819);
    }
    
    private float cnH()
    {
      AppMethodBeat.i(283823);
      float f = b.ez(getContext());
      AppMethodBeat.o(283823);
      return 12.0F * f;
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @androidx.annotation.a int paramInt5, @androidx.annotation.a int paramInt6)
    {
      AppMethodBeat.i(283820);
      this.iconRes = paramInt1;
      this.rqP = paramInt2;
      this.rqQ = paramInt3;
      this.rqR = paramInt4;
      this.rqS = paramInt5;
      this.rqT = paramInt6;
      setBackgroundResource(paramInt5);
      Object localObject = new WeImageView(getContext());
      ((WeImageView)localObject).setImageResource(paramInt1);
      ((WeImageView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = com.tencent.mm.ci.a.aY(getContext(), au.d.Edge_3A);
      localLayoutParams.height = com.tencent.mm.ci.a.aY(getContext(), au.d.Edge_3A);
      ((WeImageView)localObject).setIconColor(-1);
      ((WeImageView)localObject).setLayoutParams(localLayoutParams);
      this.jQn = ((WeImageView)localObject);
      addView((View)localObject);
      localObject = new TextView(getContext());
      ((TextView)localObject).setText(au.i.app_brand_desktop_delete_normal_text);
      ((TextView)localObject).setTextSize(1, cnH());
      ((TextView)localObject).setTextColor(getContext().getResources().getColor(au.c.white_text_color));
      ((TextView)localObject).setPadding(0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 4), 0, 0);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.bFR = ((TextView)localObject);
      addView((View)localObject);
      AppMethodBeat.o(283820);
    }
    
    public final void setActive(boolean paramBoolean)
    {
      AppMethodBeat.i(283821);
      Object localObject = this.jQn;
      if (paramBoolean)
      {
        i = this.rqP;
        ((WeImageView)localObject).setImageResource(i);
        if (!paramBoolean) {
          break label71;
        }
        i = this.rqT;
        label33:
        setBackgroundResource(i);
        localObject = this.bFR;
        if (!paramBoolean) {
          break label79;
        }
      }
      label71:
      label79:
      for (int i = this.rqR;; i = this.rqQ)
      {
        ((TextView)localObject).setText(i);
        AppMethodBeat.o(283821);
        return;
        i = this.iconRes;
        break;
        i = this.rqS;
        break label33;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    final RecyclerView.v agC;
    
    b(RecyclerView.v paramv)
    {
      this.agC = paramv;
    }
    
    public final void run()
    {
      AppMethodBeat.i(49648);
      if (this.agC == null)
      {
        AppMethodBeat.o(49648);
        return;
      }
      int i = DragFeatureView.a(DragFeatureView.this);
      int j = this.agC.md();
      if ((j < 0) && (i < 0))
      {
        AppMethodBeat.o(49648);
        return;
      }
      if (DragFeatureView.this.rqw != this.agC) {}
      for (boolean bool = true;; bool = false)
      {
        c localc = DragFeatureView.b(DragFeatureView.this);
        DragFeatureView.this.getRecyclerView();
        Log.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localc.S(this.agC)), Integer.valueOf(i), Integer.valueOf(j) });
        if (DragFeatureView.this.rqw != this.agC)
        {
          localc = DragFeatureView.b(DragFeatureView.this);
          DragFeatureView.this.getRecyclerView();
          if ((localc.S(this.agC)) && (DragFeatureView.b(DragFeatureView.this).a(DragFeatureView.this.getRecyclerView(), DragFeatureView.this.rqw, this.agC, i, j))) {
            DragFeatureView.a(DragFeatureView.this, j);
          }
        }
        AppMethodBeat.o(49648);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */