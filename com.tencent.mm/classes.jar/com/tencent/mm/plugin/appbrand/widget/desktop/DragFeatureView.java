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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.j;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private RecyclerView alu;
  private Rect cQb = new Rect();
  private boolean canScroll = true;
  private GestureDetector kVo;
  Paint mPaint = new Paint();
  protected Rect mRect = new Rect();
  private Vibrator mtQ;
  private boolean mvO = false;
  protected int mxF;
  private Runnable mxG;
  private j mxH;
  private RecyclerView.w mxI;
  int mxJ = -1;
  private View mxK;
  protected Rect mxL = new Rect();
  protected Rect mxM = new Rect();
  private boolean mxN = true;
  private LinearLayout mxO;
  private ImageView mxP;
  private TextView mxQ;
  private boolean mxR = false;
  private g mxS = null;
  private boolean mxT = false;
  private Runnable mxU;
  private Animator.AnimatorListener mxV = new Animator.AnimatorListener()
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
  
  private boolean J(float paramFloat1, float paramFloat2)
  {
    return (getRubbishRect().contains((int)paramFloat1, (int)paramFloat2)) || (getRubbishRect().top < (int)paramFloat2);
  }
  
  private void bzb()
  {
    try
    {
      this.mxQ.setText(2131755381);
      this.mxQ.setTextSize(1, getRubbishViewTextSize());
      this.mxP.setImageResource(2131230962);
      this.mxO.setBackgroundColor(getContext().getResources().getColor(2131099935));
      return;
    }
    catch (Exception localException) {}
  }
  
  private View bzc()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131099935));
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.mxF);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setId(2131304271);
    localLinearLayout.setTranslationY(((FrameLayout.LayoutParams)localObject1).height);
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageResource(2131230962);
    ((ImageView)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ac.i("MicroMsg.DragFeatureView", "alvinluo rubbishView icon size: %d,%d", new Object[] { Integer.valueOf(((ImageView)localObject1).getMeasuredWidth()), Integer.valueOf(((ImageView)localObject1).getMeasuredHeight()) });
    ((LinearLayout.LayoutParams)localObject2).width = ((int)(((ImageView)localObject1).getMeasuredWidth() * d.eb(getContext())));
    ((LinearLayout.LayoutParams)localObject2).height = ((int)(((ImageView)localObject1).getMeasuredHeight() * d.eb(getContext())));
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
    this.mxO = localLinearLayout;
    this.mxP = ((ImageView)localObject1);
    this.mxQ = ((TextView)localObject2);
    return localLinearLayout;
  }
  
  private float getRubbishViewTextSize()
  {
    return 12.0F * d.eb(getContext());
  }
  
  private void hU(final boolean paramBoolean)
  {
    if (this.mxU == null)
    {
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49645);
          ac.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", new Object[] { Boolean.valueOf(paramBoolean) });
          RecyclerView localRecyclerView = DragFeatureView.this.getRecyclerView();
          if (paramBoolean)
          {
            i = -10;
            ac.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", new Object[] { Boolean.valueOf(localRecyclerView.canScrollVertically(i)) });
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
      this.mxU = local2;
      postDelayed(local2, 250L);
    }
  }
  
  private void init(Context paramContext)
  {
    this.mxF = ((int)getResources().getDimension(2131166753));
    setVisibility(8);
    this.kVo = new GestureDetector(paramContext, this);
    this.mtQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    addView(bzc());
  }
  
  private void setItemDragCallback(j paramj)
  {
    this.mxH = paramj;
  }
  
  protected abstract j N(RecyclerView.w paramw);
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.mxL != null) {
      paramCanvas.drawRect(this.mxL, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.mxM != null) {
      paramCanvas.drawRect(this.mxM, this.mPaint);
    }
  }
  
  protected RecyclerView.w e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.mxL.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.w localw = getRecyclerView().bh(getRecyclerView().getChildAt(i));
      localw.asD.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localw;
      }
      i += 1;
    }
    if (this.mxM.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  public Rect getBottomScrollRect()
  {
    return this.mxL;
  }
  
  public j getItemDragCallback()
  {
    return this.mxH;
  }
  
  public g getRecyclerScrollComputer()
  {
    return this.mxS;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.alu;
  }
  
  public Rect getRubbishRect()
  {
    return this.cQb;
  }
  
  public Rect getTopScrollRect()
  {
    return this.mxM;
  }
  
  public final void gv(boolean paramBoolean)
  {
    ac.i("MicroMsg.DragFeatureView", "alvinluo enableScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.canScroll = paramBoolean;
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
    getGlobalVisibleRect(this.mxL);
    this.mxL.set(this.mxL.left, this.mxL.bottom - this.mxF * 2, this.mxL.right, this.mxL.bottom - this.mxF);
    getRecyclerView().getGlobalVisibleRect(this.mxM);
    this.mxM.set(this.mxM.left, 0, this.mxM.right, this.mxM.top + this.mxF);
    findViewById(2131304271).getGlobalVisibleRect(this.cQb);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        if (this.mxR)
        {
          ac.w("MicroMsg.DragFeatureView", "alvinluo DragFeatureView onLongPress is in long press and ignore");
          this.mxR = false;
          return;
        }
        this.mxR = true;
        RecyclerView.w localw = e(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), true);
        setItemDragCallback(N(localw));
        if (localw == null) {
          break label215;
        }
        j localj = this.mxH;
        getRecyclerView();
        if (!localj.O(localw)) {
          break label215;
        }
        this.mxK = this.mxH.g(getRecyclerView(), localw);
        if (this.mxK != null)
        {
          setVisibility(8);
          this.mxJ = localw.lv();
          this.mxI = localw;
          this.mtQ.vibrate(30L);
          setRubbishViewVisible(0);
          setVisibility(0);
          paramMotionEvent.setAction(0);
          this.kVo.onTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(3);
          this.kVo.onTouchEvent(paramMotionEvent);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.DragFeatureView", localException, "alvinluo onLongPress exception", new Object[0]);
        paramMotionEvent.setAction(0);
        this.kVo.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(3);
        this.kVo.onTouchEvent(paramMotionEvent);
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
      paramMotionEvent2 = this.mxH;
      getRecyclerView();
      paramMotionEvent2.a(this.mxK, paramFloat1, paramFloat2, paramMotionEvent1, i);
      return false;
      if (f1 > this.mRect.right)
      {
        i = 4;
      }
      else if (this.mxL.contains((int)f1, (int)f2))
      {
        i = 2;
      }
      else if (this.mxM.contains((int)f1, (int)f2))
      {
        i = 1;
      }
      else if (J(f1, f2))
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
          getRecyclerView().bh(getRecyclerView().getChildAt(i)).asD.getGlobalVisibleRect(this.mRect);
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
      j = paramMotionEvent1.asH;
      label308:
      ac.v("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b, x: %f, y: %f, itemViewType: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(j) });
      if ((i != 1) && (i != 2) && (i != 6)) {
        break label615;
      }
      if (!getTopScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label541;
      }
      hU(true);
      label404:
      paramMotionEvent2 = this.mxH;
      getRecyclerView();
      paramMotionEvent2.a(this.mxK, paramFloat1, paramFloat2, paramMotionEvent1, i);
      if ((i != 1) && (i != 2))
      {
        removeCallbacks(this.mxU);
        this.mxU = null;
      }
      if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
      {
        removeCallbacks(this.mxG);
        paramMotionEvent2 = this.mxH;
        getRecyclerView();
        if ((!paramMotionEvent2.P(paramMotionEvent1)) || (i == 2)) {
          break label663;
        }
        this.mxH.m(getRecyclerView());
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
        hU(false);
        break label404;
      }
      if (!getRubbishRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label404;
      }
      removeCallbacks(this.mxG);
      removeCallbacks(this.mxU);
      this.mxU = null;
      break label404;
      label615:
      if ((i != 3) && (i != 4))
      {
        paramMotionEvent2 = this.mxH;
        getRecyclerView();
        if (!paramMotionEvent2.P(paramMotionEvent1)) {
          break label404;
        }
      }
      this.mxH.m(getRecyclerView());
      break label404;
      label663:
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.asH == 7))
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.mxG = paramMotionEvent1;
        postDelayed(paramMotionEvent1, 50L);
      }
      else
      {
        paramMotionEvent1 = new a(paramMotionEvent1);
        this.mxG = paramMotionEvent1;
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
    if (!this.mxN) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.kVo.onTouchEvent(paramMotionEvent);
      return true;
      if (J(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        this.mxJ = -1;
        this.mvO = false;
        this.mxH.h(getRecyclerView(), this.mxI);
        removeCallbacks(this.mxG);
        removeCallbacks(this.mxU);
        if (this.mxK != null) {
          this.mxK.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
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
        removeCallbacks(this.mxG);
        removeCallbacks(this.mxU);
        setRubbishViewVisible(8);
        int i = this.mxJ;
        this.mxJ = -1;
        this.mvO = false;
        this.mxH.a(getRecyclerView(), this.mxI, i, new Runnable()
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
        if (J(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          this.mxO.setBackgroundColor(getContext().getResources().getColor(2131099936));
          this.mxQ.setText(2131755386);
          this.mxQ.setTextSize(2, getRubbishViewTextSize());
          this.mxP.setImageResource(2131230964);
        }
        else
        {
          bzb();
        }
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.alu = paramRecyclerView;
  }
  
  public void setRecyclerViewScrollComputer(g paramg)
  {
    this.mxS = paramg;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(2131304271);
    if (localView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localView.animate().translationY(0.0F).setDuration(300L).setListener(this.mxV).start();
      return;
    }
    this.mxT = true;
    localView.animate().translationY(localView.getHeight()).setDuration(300L).setListener(this.mxV).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.mxN = paramBoolean;
  }
  
  final class a
    implements Runnable
  {
    final RecyclerView.w akK;
    
    a(RecyclerView.w paramw)
    {
      this.akK = paramw;
    }
    
    public final void run()
    {
      AppMethodBeat.i(49648);
      if (this.akK == null)
      {
        AppMethodBeat.o(49648);
        return;
      }
      int i = DragFeatureView.a(DragFeatureView.this);
      int j = this.akK.lv();
      if ((j < 0) && (i < 0))
      {
        AppMethodBeat.o(49648);
        return;
      }
      if (DragFeatureView.b(DragFeatureView.this) != this.akK) {}
      for (boolean bool = true;; bool = false)
      {
        j localj = DragFeatureView.c(DragFeatureView.this);
        DragFeatureView.this.getRecyclerView();
        DragFeatureView.b(DragFeatureView.this);
        ac.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localj.R(this.akK)), Integer.valueOf(i), Integer.valueOf(j) });
        if (DragFeatureView.b(DragFeatureView.this) != this.akK)
        {
          localj = DragFeatureView.c(DragFeatureView.this);
          DragFeatureView.this.getRecyclerView();
          DragFeatureView.b(DragFeatureView.this);
          if ((localj.R(this.akK)) && (DragFeatureView.c(DragFeatureView.this).a(DragFeatureView.this.getRecyclerView(), DragFeatureView.b(DragFeatureView.this), this.akK, i, j))) {
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