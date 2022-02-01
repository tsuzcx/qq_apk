package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private Vibrator cqQ;
  private Rect hpZ = new Rect();
  private boolean isActive = false;
  Paint mPaint = new Paint();
  GestureDetector mQj;
  protected Rect mRect = new Rect();
  private RecyclerView mRecyclerView;
  protected int uAD = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_desktop_close_area_height) + com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_desktop_close_area_extra);
  private Runnable uAE;
  private c uAF;
  protected RecyclerView.v uAG;
  private int uAH = -1;
  private View uAI;
  protected Rect uAJ = new Rect();
  protected Rect uAK = new Rect();
  private Vibrator uAL = (Vibrator)getContext().getSystemService("vibrator");
  private boolean uAM = true;
  private FrameLayout uAN;
  private a uAO;
  private a uAP;
  private boolean uAQ = false;
  boolean uAR = false;
  private boolean uAS = true;
  private g uAT = null;
  private boolean uAU = false;
  private Runnable uAV;
  private Animator.AnimatorListener uAW = new Animator.AnimatorListener()
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
  
  private boolean ax(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private boolean bZ(float paramFloat)
  {
    return (this.uAO.getVisibility() == 0) && (paramFloat < getRubbishRect().centerX());
  }
  
  private void cPI()
  {
    Log.i("MicroMsg.DragFeatureView", "resetRubbishView");
    this.isActive = false;
    this.uAO.setActive(false);
    this.uAP.setActive(false);
  }
  
  private View cPJ()
  {
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(getContext());
    float f = com.tencent.mm.cd.a.bs(getContext(), ba.d.Edge_A);
    localRoundedCornerFrameLayout.A(f, f, 0.0F, 0.0F);
    localRoundedCornerFrameLayout.setId(ba.f.rubbish_view);
    localRoundedCornerFrameLayout.setTranslationY(this.uAD);
    Object localObject = new FrameLayout.LayoutParams(-1, this.uAD);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    localRoundedCornerFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(getContext());
    ((LinearLayout)localObject).setOrientation(0);
    ((LinearLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localRoundedCornerFrameLayout.addView((View)localObject);
    this.uAO = new a(getContext());
    this.uAO.b(ba.h.appbrand_icon_star_off, ba.h.appbrand_icon_star_on, ba.i.app_brand_desktop_menu_add_to_my_app_brand, ba.i.app_brand_desktop_menu_add_to_my_app_brand_release, ba.c.app_brand_desktop_star_normal_bg_color, ba.c.app_brand_desktop_star_release_bg_color);
    ((LinearLayout)localObject).addView(this.uAO);
    this.uAP = new a(getContext());
    this.uAP.b(ba.h.icons_filled_delete, ba.h.icons_filled_delete_on, ba.i.app_brand_desktop_delete_normal_text, ba.i.app_brand_desktop_release_delete_text, ba.c.app_brand_desktop_delete_normal_bg_color, ba.c.app_brand_desktop_delete_release_bg_color);
    ((LinearLayout)localObject).addView(this.uAP);
    this.uAN = localRoundedCornerFrameLayout;
    return localRoundedCornerFrameLayout;
  }
  
  private void init(Context paramContext)
  {
    setVisibility(8);
    this.mQj = new GestureDetector(paramContext, this);
    this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(cPJ());
  }
  
  private void lp(final boolean paramBoolean)
  {
    if (this.uAV == null)
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
      this.uAV = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private void lq(boolean paramBoolean)
  {
    Log.i("MicroMsg.DragFeatureView", "resetStatus %b", new Object[] { Boolean.valueOf(paramBoolean) });
    removeCallbacks(this.uAE);
    removeCallbacks(this.uAV);
    setRubbishViewVisible(8);
    int i = this.uAH;
    this.uAH = -1;
    this.isActive = false;
    this.uAF.a(getRecyclerView(), this.uAG, i, paramBoolean, true, new Runnable()
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
    this.uAF = paramc;
  }
  
  protected boolean P(MotionEvent paramMotionEvent)
  {
    if (getTopScrollRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
    {
      lp(true);
      return true;
    }
    if (getBottomScrollRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
    {
      lp(false);
      return true;
    }
    if (getRubbishRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
    {
      removeCallbacks(this.uAE);
      removeCallbacks(this.uAV);
      this.uAV = null;
      return true;
    }
    return false;
  }
  
  public final void cPH()
  {
    if (this.uAR)
    {
      Log.i("MicroMsg.DragFeatureView", "resetIfNeeded trigger");
      lq(false);
    }
  }
  
  protected abstract c cPj();
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    if (getVisibility() == 8) {
      return;
    }
    Log.i("MicroMsg.DragFeatureView", "onBindViewHolder %d %d", new Object[] { Integer.valueOf(this.uAH), Integer.valueOf(paramInt) });
    if (this.uAH == paramInt)
    {
      paramv.caK.setVisibility(4);
      return;
    }
    paramv.caK.setVisibility(0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.uAJ != null) {
      paramCanvas.drawRect(this.uAJ, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.uAK != null) {
      paramCanvas.drawRect(this.uAK, this.mPaint);
    }
  }
  
  public Rect getBottomScrollRect()
  {
    return this.uAJ;
  }
  
  public c getItemDragCallback()
  {
    return this.uAF;
  }
  
  public g getRecyclerScrollComputer()
  {
    return this.uAT;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public Rect getRubbishRect()
  {
    return this.hpZ;
  }
  
  public Rect getTopScrollRect()
  {
    return this.uAK;
  }
  
  protected RecyclerView.v i(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.uAJ.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.v localv = getRecyclerView().bj(getRecyclerView().getChildAt(i));
      localv.caK.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localv;
      }
      i += 1;
    }
    if (this.uAK.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public final void jr(boolean paramBoolean)
  {
    Log.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uAS = paramBoolean;
  }
  
  public final void lr(boolean paramBoolean)
  {
    int i = 0;
    Log.i("MicroMsg.DragFeatureView", "enableStar %b", new Object[] { Boolean.valueOf(paramBoolean) });
    a locala = this.uAO;
    if (paramBoolean) {}
    for (;;)
    {
      locala.setVisibility(i);
      this.uAO.getParent().requestLayout();
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
    getGlobalVisibleRect(this.uAJ);
    this.uAJ.set(this.uAJ.left, this.uAJ.bottom - this.uAD * 2, this.uAJ.right, this.uAJ.bottom - this.uAD);
    getRecyclerView().getGlobalVisibleRect(this.uAK);
    this.uAK.set(this.uAK.left, 0, this.uAK.right, this.uAK.top + this.uAD);
    findViewById(ba.f.rubbish_view).getGlobalVisibleRect(this.hpZ);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if (this.uAR)
    {
      Log.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
      this.uAR = false;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
    Log.i("MicroMsg.DragFeatureView", "onLongPress");
    localObject1 = i(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
    if (localObject1 == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      return;
    }
    this.uAR = true;
    setItemDragCallback(cPj());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.uAF;
      getRecyclerView();
      if (((c)localObject2).N((RecyclerView.v)localObject1))
      {
        this.uAI = this.uAF.f(getRecyclerView(), (RecyclerView.v)localObject1);
        if (this.uAI != null)
        {
          setVisibility(8);
          this.uAH = ((RecyclerView.v)localObject1).KJ();
          this.uAG = ((RecyclerView.v)localObject1);
          announceForAccessibility(getContext().getString(ba.i.app_brand_desktop_accessibility_long_pressed));
          this.cqQ.vibrate(30L);
          setRubbishViewVisible(0);
          setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramMotionEvent.setAction(0);
      localObject1 = this.mQj;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      paramMotionEvent.setAction(3);
      localObject1 = this.mQj;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramMotionEvent.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onLongPress", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
      paramMotionEvent1 = i(paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY(), false);
      if (this.uAS) {
        break;
      }
      paramMotionEvent1 = this.uAF;
      getRecyclerView();
      paramMotionEvent1.b(this.uAI, paramFloat1, paramFloat2, paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY());
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.uAJ.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.uAK.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (ax(f1, f2))
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
          getRecyclerView().bj(getRecyclerView().getChildAt(i)).caK.getGlobalVisibleRect(this.mRect);
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
    label393:
    c localc;
    if (paramMotionEvent1 != null)
    {
      j = paramMotionEvent1.caO;
      Log.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label522;
      }
      P(paramMotionEvent2);
      localc = this.uAF;
      getRecyclerView();
      localc.b(this.uAI, paramFloat1, paramFloat2, paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY());
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.uAV);
        this.uAV = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.uAE);
        paramMotionEvent2 = this.uAF;
        getRecyclerView();
        if ((!paramMotionEvent2.cPn()) || (i == 2)) {
          break label563;
        }
        getRecyclerView();
      }
    }
    for (;;)
    {
      return true;
      j = -1;
      break;
      label522:
      if ((i != 3) && (i != 4))
      {
        localc = this.uAF;
        getRecyclerView();
        if (!localc.cPn()) {
          break label393;
        }
      }
      getRecyclerView();
      break label393;
      label563:
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.caO == 5))
      {
        paramMotionEvent1 = new b(paramMotionEvent1);
        this.uAE = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
      else
      {
        paramMotionEvent1 = new b(paramMotionEvent1);
        this.uAE = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 150L);
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.uAM) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramView = this.mQj;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      return true;
      boolean bool;
      int i;
      if (ax(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        bool = bZ(paramMotionEvent.getRawX());
        Log.i("MicroMsg.DragFeatureView", "handleDoAction %b", new Object[] { Boolean.valueOf(bool) });
        i = this.uAH;
        this.isActive = false;
        if (bool)
        {
          paramView = this.uAF;
          getRecyclerView();
          paramView.O(this.uAG);
          lq(true);
        }
        else
        {
          this.uAF.a(getRecyclerView(), this.uAG, i, true, false, null);
          this.uAH = -1;
          this.uAF.h(getRecyclerView(), this.uAG);
          if (this.uAI != null) {
            this.uAI.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
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
          removeCallbacks(this.uAE);
          removeCallbacks(this.uAV);
        }
      }
      else
      {
        lq(false);
        continue;
        if (ax(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          bool = bZ(paramMotionEvent.getRawX());
          Log.i("MicroMsg.DragFeatureView", "handleActive %b", new Object[] { Boolean.valueOf(bool) });
          if (!this.isActive)
          {
            if (this.uAL != null) {
              this.uAL.vibrate(10L);
            }
            paramView = getContext();
            if (bool)
            {
              i = ba.i.app_brand_desktop_accessibility_long_add;
              label409:
              announceForAccessibility(paramView.getString(i));
              this.uAQ = bool;
              label424:
              this.isActive = true;
              this.uAO.setActive(bool);
              paramView = this.uAP;
              if (bool) {
                break label532;
              }
            }
          }
          label532:
          for (bool = true;; bool = false)
          {
            paramView.setActive(bool);
            break;
            i = ba.i.app_brand_desktop_accessibility_long_delete;
            break label409;
            if (bool == this.uAQ) {
              break label424;
            }
            if (this.uAL != null) {
              this.uAL.vibrate(10L);
            }
            paramView = getContext();
            if (bool) {}
            for (i = ba.i.app_brand_desktop_accessibility_long_add;; i = ba.i.app_brand_desktop_accessibility_long_delete)
            {
              announceForAccessibility(paramView.getString(i));
              this.uAQ = bool;
              break;
            }
          }
        }
        cPI();
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(g paramg)
  {
    this.uAT = paramg;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(ba.f.rubbish_view);
    if (localView == null) {
      return;
    }
    Log.i("MicroMsg.DragFeatureView", "setRubbishViewVisible %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      localView.requestLayout();
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.uAW).start();
      return;
    }
    this.uAU = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.uAW).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.uAM = paramBoolean;
  }
  
  static final class a
    extends LinearLayout
  {
    private TextView dyR;
    private int iconRes;
    private WeImageView mpe;
    private int uAZ;
    private int uBa;
    private int uBb;
    private int uBc;
    private int uBd;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(324234);
      setOrientation(0);
      setOrientation(1);
      setGravity(17);
      paramContext = new LinearLayout.LayoutParams(0, -1);
      paramContext.weight = 1.0F;
      setLayoutParams(paramContext);
      AppMethodBeat.o(324234);
    }
    
    private float cPK()
    {
      AppMethodBeat.i(324236);
      float f = b.getScaleSize(getContext());
      AppMethodBeat.o(324236);
      return 12.0F * f;
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      AppMethodBeat.i(324240);
      this.iconRes = paramInt1;
      this.uAZ = paramInt2;
      this.uBa = paramInt3;
      this.uBb = paramInt4;
      this.uBc = paramInt5;
      this.uBd = paramInt6;
      setBackgroundResource(paramInt5);
      Object localObject = new WeImageView(getContext());
      ((WeImageView)localObject).setImageResource(paramInt1);
      ((WeImageView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = com.tencent.mm.cd.a.br(getContext(), ba.d.Edge_3A);
      localLayoutParams.height = com.tencent.mm.cd.a.br(getContext(), ba.d.Edge_3A);
      ((WeImageView)localObject).setIconColor(-1);
      ((WeImageView)localObject).setLayoutParams(localLayoutParams);
      this.mpe = ((WeImageView)localObject);
      addView((View)localObject);
      localObject = new TextView(getContext());
      ((TextView)localObject).setText(ba.i.app_brand_desktop_delete_normal_text);
      ((TextView)localObject).setTextSize(1, cPK());
      ((TextView)localObject).setTextColor(getContext().getResources().getColor(ba.c.white_text_color));
      ((TextView)localObject).setPadding(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 4), 0, 0);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.dyR = ((TextView)localObject);
      addView((View)localObject);
      AppMethodBeat.o(324240);
    }
    
    public final void setActive(boolean paramBoolean)
    {
      AppMethodBeat.i(324243);
      Object localObject = this.mpe;
      if (paramBoolean)
      {
        i = this.uAZ;
        ((WeImageView)localObject).setImageResource(i);
        if (!paramBoolean) {
          break label71;
        }
        i = this.uBd;
        label33:
        setBackgroundResource(i);
        localObject = this.dyR;
        if (!paramBoolean) {
          break label79;
        }
      }
      label71:
      label79:
      for (int i = this.uBb;; i = this.uBa)
      {
        ((TextView)localObject).setText(i);
        AppMethodBeat.o(324243);
        return;
        i = this.iconRes;
        break;
        i = this.uBc;
        break label33;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    final RecyclerView.v bVi;
    
    b(RecyclerView.v paramv)
    {
      this.bVi = paramv;
    }
    
    public final void run()
    {
      AppMethodBeat.i(49648);
      if (this.bVi == null)
      {
        AppMethodBeat.o(49648);
        return;
      }
      int i = DragFeatureView.a(DragFeatureView.this);
      int j = this.bVi.KJ();
      if ((j < 0) && (i < 0))
      {
        AppMethodBeat.o(49648);
        return;
      }
      if (DragFeatureView.this.uAG != this.bVi) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(DragFeatureView.b(DragFeatureView.this).g(DragFeatureView.this.getRecyclerView(), this.bVi)), Integer.valueOf(i), Integer.valueOf(j) });
        if ((DragFeatureView.this.uAG != this.bVi) && (DragFeatureView.b(DragFeatureView.this).g(DragFeatureView.this.getRecyclerView(), this.bVi)) && (DragFeatureView.b(DragFeatureView.this).a(DragFeatureView.this.getRecyclerView(), DragFeatureView.this.uAG, this.bVi, i, j))) {
          DragFeatureView.a(DragFeatureView.this, j);
        }
        AppMethodBeat.o(49648);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */