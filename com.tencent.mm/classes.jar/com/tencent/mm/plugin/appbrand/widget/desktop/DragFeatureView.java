package com.tencent.mm.plugin.appbrand.widget.desktop;

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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private RecyclerView adt;
  private boolean canScroll = true;
  private Rect cdW = new Rect();
  private GestureDetector idY;
  private Vibrator jbU;
  private boolean jdM = false;
  private RecyclerView.v jfA;
  int jfB = -1;
  private View jfC;
  protected Rect jfD = new Rect();
  protected Rect jfE = new Rect();
  private boolean jfF = true;
  private LinearLayout jfG;
  private ImageView jfH;
  private TextView jfI;
  private boolean jfJ = false;
  private g jfK = null;
  private boolean jfL = false;
  private Runnable jfM;
  private Animator.AnimatorListener jfN = new DragFeatureView.4(this);
  protected int jfx;
  private Runnable jfy;
  private c jfz;
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
  
  private boolean Q(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private void aPB()
  {
    try
    {
      this.jfI.setText(2131296613);
      this.jfI.setTextSize(1, getRubbishViewTextSize());
      this.jfH.setImageResource(2130837725);
      this.jfG.setBackgroundColor(getContext().getResources().getColor(2131689697));
      return;
    }
    catch (Exception localException) {}
  }
  
  private View aPC()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131689697));
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.jfx);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setId(2131820662);
    localLinearLayout.setTranslationY(((FrameLayout.LayoutParams)localObject1).height);
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageResource(2130837725);
    ((ImageView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ab.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", new Object[] { Integer.valueOf(((ImageView)localObject1).getMeasuredWidth()), Integer.valueOf(((ImageView)localObject1).getMeasuredHeight()) });
    ((LinearLayout.LayoutParams)localObject2).width = ((int)(((ImageView)localObject1).getMeasuredWidth() * d.dr(getContext())));
    ((LinearLayout.LayoutParams)localObject2).height = ((int)(((ImageView)localObject1).getMeasuredHeight() * d.dr(getContext())));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setText(2131296613);
    ((TextView)localObject2).setTextSize(1, getRubbishViewTextSize());
    ((TextView)localObject2).setTextColor(getContext().getResources().getColor(2131690709));
    ((TextView)localObject2).setPadding(0, a.fromDPToPix(getContext(), 4), 0, 0);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView((View)localObject1);
    localLinearLayout.addView((View)localObject2);
    this.jfG = localLinearLayout;
    this.jfH = ((ImageView)localObject1);
    this.jfI = ((TextView)localObject2);
    return localLinearLayout;
  }
  
  private void fi(boolean paramBoolean)
  {
    if (this.jfM == null)
    {
      DragFeatureView.2 local2 = new DragFeatureView.2(this, paramBoolean);
      this.jfM = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private float getRubbishViewTextSize()
  {
    return 12.0F * d.dr(getContext());
  }
  
  private void init(Context paramContext)
  {
    this.jfx = ((int)getResources().getDimension(2131428643));
    setVisibility(8);
    this.idY = new GestureDetector(paramContext, this);
    this.jbU = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(aPC());
  }
  
  private void setItemDragCallback(c paramc)
  {
    this.jfz = paramc;
  }
  
  protected abstract c N(RecyclerView.v paramv);
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.jfD != null) {
      paramCanvas.drawRect(this.jfD, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.jfE != null) {
      paramCanvas.drawRect(this.jfE, this.mPaint);
    }
  }
  
  protected RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.jfD.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.v localv = getRecyclerView().bb(getRecyclerView().getChildAt(i));
      localv.aku.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localv;
      }
      i += 1;
    }
    if (this.jfE.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public final void ek(boolean paramBoolean)
  {
    ab.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.canScroll = paramBoolean;
  }
  
  public Rect getBottomScrollRect()
  {
    return this.jfD;
  }
  
  public c getItemDragCallback()
  {
    return this.jfz;
  }
  
  public g getRecyclerScrollComputer()
  {
    return this.jfK;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.adt;
  }
  
  public Rect getRubbishRect()
  {
    return this.cdW;
  }
  
  public Rect getTopScrollRect()
  {
    return this.jfE;
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
    getGlobalVisibleRect(this.jfD);
    this.jfD.set(this.jfD.left, this.jfD.bottom - this.jfx * 2, this.jfD.right, this.jfD.bottom - this.jfx);
    getRecyclerView().getGlobalVisibleRect(this.jfE);
    this.jfE.set(this.jfE.left, 0, this.jfE.right, this.jfE.top + this.jfx);
    findViewById(2131820662).getGlobalVisibleRect(this.cdW);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        if (this.jfJ)
        {
          ab.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
          this.jfJ = false;
          return;
        }
        this.jfJ = true;
        RecyclerView.v localv = e(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
        setItemDragCallback(N(localv));
        if (localv == null) {
          break label215;
        }
        c localc = this.jfz;
        getRecyclerView();
        if (!localc.O(localv)) {
          break label215;
        }
        this.jfC = this.jfz.d(getRecyclerView(), localv);
        if (this.jfC != null)
        {
          setVisibility(8);
          this.jfB = localv.jN();
          this.jfA = localv;
          this.jbU.vibrate(30L);
          setRubbishViewVisible(0);
          setVisibility(0);
          paramMotionEvent.setAction(0);
          this.idY.onTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(3);
          this.idY.onTouchEvent(paramMotionEvent);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.DragFeatureView", localException, "alvinluo onLongPress exception", new Object[0]);
        paramMotionEvent.setAction(0);
        this.idY.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(3);
        this.idY.onTouchEvent(paramMotionEvent);
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
      paramMotionEvent2 = this.jfz;
      getRecyclerView();
      paramMotionEvent2.a(this.jfC, paramFloat1, paramFloat2, paramMotionEvent1, i);
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.jfD.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.jfE.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (Q(f1, f2))
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
          getRecyclerView().bb(getRecyclerView().getChildAt(i)).aku.getGlobalVisibleRect(this.mRect);
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
      j = paramMotionEvent1.aky;
      label308:
      ab.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label615;
      }
      if (!getTopScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label541;
      }
      fi(true);
      label404:
      paramMotionEvent2 = this.jfz;
      getRecyclerView();
      paramMotionEvent2.a(this.jfC, paramFloat1, paramFloat2, paramMotionEvent1, i);
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.jfM);
        this.jfM = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.jfy);
        paramMotionEvent2 = this.jfz;
        getRecyclerView();
        if ((!paramMotionEvent2.P(paramMotionEvent1)) || (i == 2)) {
          break label663;
        }
        this.jfz.m(getRecyclerView());
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
        fi(false);
        break label404;
      }
      if (!getRubbishRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label404;
      }
      removeCallbacks(this.jfy);
      removeCallbacks(this.jfM);
      this.jfM = null;
      break label404;
      label615:
      if ((i != 3) && (i != 4))
      {
        paramMotionEvent2 = this.jfz;
        getRecyclerView();
        if (!paramMotionEvent2.P(paramMotionEvent1)) {
          break label404;
        }
      }
      this.jfz.m(getRecyclerView());
      break label404;
      label663:
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.aky == 7))
      {
        paramMotionEvent1 = new DragFeatureView.a(this, paramMotionEvent1);
        this.jfy = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
      else
      {
        paramMotionEvent1 = new DragFeatureView.a(this, paramMotionEvent1);
        this.jfy = paramMotionEvent1;
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
    if (!this.jfF) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.idY.onTouchEvent(paramMotionEvent);
      return true;
      if (Q(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        this.jfB = -1;
        this.jdM = false;
        this.jfz.e(getRecyclerView(), this.jfA);
        removeCallbacks(this.jfy);
        removeCallbacks(this.jfM);
        if (this.jfC != null) {
          this.jfC.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new DragFeatureView.1(this)).setDuration(300L).start();
        }
      }
      else
      {
        removeCallbacks(this.jfy);
        removeCallbacks(this.jfM);
        setRubbishViewVisible(8);
        int i = this.jfB;
        this.jfB = -1;
        this.jdM = false;
        this.jfz.a(getRecyclerView(), this.jfA, i, new DragFeatureView.3(this));
        continue;
        if (Q(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          this.jfG.setBackgroundColor(getContext().getResources().getColor(2131689698));
          this.jfI.setText(2131296618);
          this.jfI.setTextSize(2, getRubbishViewTextSize());
          this.jfH.setImageResource(2130837727);
        }
        else
        {
          aPB();
        }
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.adt = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(g paramg)
  {
    this.jfK = paramg;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(2131820662);
    if (localView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.jfN).start();
      return;
    }
    this.jfL = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.jfN).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.jfF = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */