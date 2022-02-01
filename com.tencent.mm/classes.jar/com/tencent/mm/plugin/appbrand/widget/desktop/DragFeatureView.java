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
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.j;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private RecyclerView akA;
  private Rect cSE = new Rect();
  private boolean canScroll = true;
  private GestureDetector ktZ;
  private Vibrator lRO;
  private boolean lTM = false;
  protected int lVD;
  private Runnable lVE;
  private j lVF;
  private RecyclerView.v lVG;
  int lVH = -1;
  private View lVI;
  protected Rect lVJ = new Rect();
  protected Rect lVK = new Rect();
  private boolean lVL = true;
  private LinearLayout lVM;
  private ImageView lVN;
  private TextView lVO;
  private boolean lVP = false;
  private g lVQ = null;
  private boolean lVR = false;
  private Runnable lVS;
  private Animator.AnimatorListener lVT = new Animator.AnimatorListener()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      AppMethodBeat.i(49647);
      DragFeatureView.e(DragFeatureView.this);
      DragFeatureView.this.requestLayout();
      if ((DragFeatureView.h(DragFeatureView.this)) && ((DragFeatureView.i(DragFeatureView.this) instanceof DragRecyclerView)))
      {
        ((DragRecyclerView)DragFeatureView.i(DragFeatureView.this)).setLongPress(false);
        DragFeatureView.j(DragFeatureView.this);
        DragFeatureView.k(DragFeatureView.this);
      }
      AppMethodBeat.o(49647);
    }
    
    public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
    
    public final void onAnimationStart(Animator paramAnonymousAnimator) {}
  };
  Paint mPaint = new Paint();
  protected Rect mRect = new Rect();
  
  public DragFeatureView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
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
  
  private boolean G(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private void bsb()
  {
    try
    {
      this.lVO.setText(2131755381);
      this.lVO.setTextSize(1, getRubbishViewTextSize());
      this.lVN.setImageResource(2131230962);
      this.lVM.setBackgroundColor(getContext().getResources().getColor(2131099935));
      return;
    }
    catch (Exception localException) {}
  }
  
  private View bsc()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131099935));
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.lVD);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setId(2131304271);
    localLinearLayout.setTranslationY(((FrameLayout.LayoutParams)localObject1).height);
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageResource(2131230962);
    ((ImageView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ad.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", new Object[] { Integer.valueOf(((ImageView)localObject1).getMeasuredWidth()), Integer.valueOf(((ImageView)localObject1).getMeasuredHeight()) });
    ((LinearLayout.LayoutParams)localObject2).width = ((int)(((ImageView)localObject1).getMeasuredWidth() * d.dT(getContext())));
    ((LinearLayout.LayoutParams)localObject2).height = ((int)(((ImageView)localObject1).getMeasuredHeight() * d.dT(getContext())));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setText(2131755381);
    ((TextView)localObject2).setTextSize(1, getRubbishViewTextSize());
    ((TextView)localObject2).setTextColor(getContext().getResources().getColor(2131101182));
    ((TextView)localObject2).setPadding(0, a.fromDPToPix(getContext(), 4), 0, 0);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView((View)localObject1);
    localLinearLayout.addView((View)localObject2);
    this.lVM = localLinearLayout;
    this.lVN = ((ImageView)localObject1);
    this.lVO = ((TextView)localObject2);
    return localLinearLayout;
  }
  
  private float getRubbishViewTextSize()
  {
    return 12.0F * d.dT(getContext());
  }
  
  private void hw(final boolean paramBoolean)
  {
    if (this.lVS == null)
    {
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49645);
          ad.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", new Object[] { Boolean.valueOf(paramBoolean) });
          RecyclerView localRecyclerView = DragFeatureView.this.getRecyclerView();
          if (paramBoolean)
          {
            i = -10;
            ad.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", new Object[] { Boolean.valueOf(localRecyclerView.canScrollVertically(i)) });
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
      this.lVS = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private void init(Context paramContext)
  {
    this.lVD = ((int)getResources().getDimension(2131166753));
    setVisibility(8);
    this.ktZ = new GestureDetector(paramContext, this);
    this.lRO = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(bsc());
  }
  
  private void setItemDragCallback(j paramj)
  {
    this.lVF = paramj;
  }
  
  protected abstract j N(RecyclerView.v paramv);
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.lVJ != null) {
      paramCanvas.drawRect(this.lVJ, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.lVK != null) {
      paramCanvas.drawRect(this.lVK, this.mPaint);
    }
  }
  
  protected RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.lVJ.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.v localv = getRecyclerView().bh(getRecyclerView().getChildAt(i));
      localv.arI.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localv;
      }
      i += 1;
    }
    if (this.lVK.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public final void fZ(boolean paramBoolean)
  {
    ad.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.canScroll = paramBoolean;
  }
  
  public Rect getBottomScrollRect()
  {
    return this.lVJ;
  }
  
  public j getItemDragCallback()
  {
    return this.lVF;
  }
  
  public g getRecyclerScrollComputer()
  {
    return this.lVQ;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.akA;
  }
  
  public Rect getRubbishRect()
  {
    return this.cSE;
  }
  
  public Rect getTopScrollRect()
  {
    return this.lVK;
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
    getGlobalVisibleRect(this.lVJ);
    this.lVJ.set(this.lVJ.left, this.lVJ.bottom - this.lVD * 2, this.lVJ.right, this.lVJ.bottom - this.lVD);
    getRecyclerView().getGlobalVisibleRect(this.lVK);
    this.lVK.set(this.lVK.left, 0, this.lVK.right, this.lVK.top + this.lVD);
    findViewById(2131304271).getGlobalVisibleRect(this.cSE);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        if (this.lVP)
        {
          ad.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
          this.lVP = false;
          return;
        }
        this.lVP = true;
        RecyclerView.v localv = e(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
        setItemDragCallback(N(localv));
        if (localv == null) {
          break label215;
        }
        j localj = this.lVF;
        getRecyclerView();
        if (!localj.O(localv)) {
          break label215;
        }
        this.lVI = this.lVF.g(getRecyclerView(), localv);
        if (this.lVI != null)
        {
          setVisibility(8);
          this.lVH = localv.ln();
          this.lVG = localv;
          this.lRO.vibrate(30L);
          setRubbishViewVisible(0);
          setVisibility(0);
          paramMotionEvent.setAction(0);
          this.ktZ.onTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(3);
          this.ktZ.onTouchEvent(paramMotionEvent);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.DragFeatureView", localException, "alvinluo onLongPress exception", new Object[0]);
        paramMotionEvent.setAction(0);
        this.ktZ.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(3);
        this.ktZ.onTouchEvent(paramMotionEvent);
        return;
      }
      setRubbishViewVisible(8);
      label215:
      setVisibility(8);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
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
      paramMotionEvent2 = this.lVF;
      getRecyclerView();
      paramMotionEvent2.a(this.lVI, paramFloat1, paramFloat2, paramMotionEvent1, i);
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.lVJ.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.lVK.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (G(f1, f2))
      {
        i = 6;
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= getRecyclerView().getChildCount()) {
            break label272;
          }
          getRecyclerView().bh(getRecyclerView().getChildAt(i)).arI.getGlobalVisibleRect(this.mRect);
          if (this.mRect.contains((int)f1, (int)f2))
          {
            i = 5;
            break;
          }
          i += 1;
        }
        label272:
        i = 7;
      }
    }
    boolean bool;
    int j;
    if (paramMotionEvent1 == null)
    {
      bool = true;
      f1 = paramMotionEvent2.getRawX();
      f2 = paramMotionEvent2.getRawY();
      if (paramMotionEvent1 == null) {
        break label535;
      }
      j = paramMotionEvent1.arM;
      label308:
      ad.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label615;
      }
      if (!getTopScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label541;
      }
      hw(true);
      label404:
      paramMotionEvent2 = this.lVF;
      getRecyclerView();
      paramMotionEvent2.a(this.lVI, paramFloat1, paramFloat2, paramMotionEvent1, i);
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.lVS);
        this.lVS = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.lVE);
        paramMotionEvent2 = this.lVF;
        getRecyclerView();
        if ((!paramMotionEvent2.P(paramMotionEvent1)) || (i == 2)) {
          break label663;
        }
        this.lVF.m(getRecyclerView());
      }
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label535:
      j = -1;
      break label308;
      label541:
      if (getBottomScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY()))
      {
        hw(false);
        break label404;
      }
      if (!getRubbishRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label404;
      }
      removeCallbacks(this.lVE);
      removeCallbacks(this.lVS);
      this.lVS = null;
      break label404;
      label615:
      if ((i != 3) && (i != 4))
      {
        paramMotionEvent2 = this.lVF;
        getRecyclerView();
        if (!paramMotionEvent2.P(paramMotionEvent1)) {
          break label404;
        }
      }
      this.lVF.m(getRecyclerView());
      break label404;
      label663:
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.arM == 7))
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.lVE = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
      else
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.lVE = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 150L);
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.lVL) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.ktZ.onTouchEvent(paramMotionEvent);
      return true;
      if (G(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        this.lVH = -1;
        this.lTM = false;
        this.lVF.h(getRecyclerView(), this.lVG);
        removeCallbacks(this.lVE);
        removeCallbacks(this.lVS);
        if (this.lVI != null) {
          this.lVI.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(49644);
              DragFeatureView.this.removeView(DragFeatureView.d(DragFeatureView.this));
              DragFeatureView.e(DragFeatureView.this);
              DragFeatureView.this.setRubbishViewVisible(8);
              AppMethodBeat.o(49644);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          }).setDuration(300L).start();
        }
      }
      else
      {
        removeCallbacks(this.lVE);
        removeCallbacks(this.lVS);
        setRubbishViewVisible(8);
        int i = this.lVH;
        this.lVH = -1;
        this.lTM = false;
        this.lVF.a(getRecyclerView(), this.lVG, i, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49646);
            DragFeatureView.this.setVisibility(8);
            DragFeatureView.f(DragFeatureView.this);
            DragFeatureView.g(DragFeatureView.this);
            AppMethodBeat.o(49646);
          }
        });
        continue;
        if (G(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          this.lVM.setBackgroundColor(getContext().getResources().getColor(2131099936));
          this.lVO.setText(2131755386);
          this.lVO.setTextSize(2, getRubbishViewTextSize());
          this.lVN.setImageResource(2131230964);
        }
        else
        {
          bsb();
        }
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.akA = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(g paramg)
  {
    this.lVQ = paramg;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(2131304271);
    if (localView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.lVT).start();
      return;
    }
    this.lVR = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.lVT).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.lVL = paramBoolean;
  }
  
  final class a
    implements Runnable
  {
    final RecyclerView.v ajQ;
    
    a(RecyclerView.v paramv)
    {
      this.ajQ = paramv;
    }
    
    public final void run()
    {
      AppMethodBeat.i(49648);
      if (this.ajQ == null)
      {
        AppMethodBeat.o(49648);
        return;
      }
      int i = DragFeatureView.a(DragFeatureView.this);
      int j = this.ajQ.ln();
      if ((j < 0) && (i < 0))
      {
        AppMethodBeat.o(49648);
        return;
      }
      if (DragFeatureView.b(DragFeatureView.this) != this.ajQ) {}
      for (boolean bool = true;; bool = false)
      {
        j localj = DragFeatureView.c(DragFeatureView.this);
        DragFeatureView.this.getRecyclerView();
        DragFeatureView.b(DragFeatureView.this);
        ad.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localj.R(this.ajQ)), Integer.valueOf(i), Integer.valueOf(j) });
        if (DragFeatureView.b(DragFeatureView.this) != this.ajQ)
        {
          localj = DragFeatureView.c(DragFeatureView.this);
          DragFeatureView.this.getRecyclerView();
          DragFeatureView.b(DragFeatureView.this);
          if ((localj.R(this.ajQ)) && (DragFeatureView.c(DragFeatureView.this).a(DragFeatureView.this.getRecyclerView(), DragFeatureView.b(DragFeatureView.this), this.ajQ, i, j))) {
            DragFeatureView.a(DragFeatureView.this, j);
          }
        }
        AppMethodBeat.o(49648);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */