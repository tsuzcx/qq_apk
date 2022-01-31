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
import com.tencent.mm.plugin.appbrand.widget.desktop.a.b;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.y;

public abstract class DragFeatureView
  extends FrameLayout
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  public final int BOTTOM = 2;
  public final int LEFT = 3;
  public final int RIGHT = 4;
  public final int TOP = 1;
  public final int UNKNOWN = 7;
  private RecyclerView acI;
  private Rect bAZ = new Rect();
  private GestureDetector gEU;
  private boolean hpN = false;
  private Vibrator hpm;
  private int hqG;
  private Runnable hqH;
  private b hqI;
  private RecyclerView.v hqJ;
  int hqK = -1;
  private View hqL;
  private Rect hqM = new Rect();
  private Rect hqN = new Rect();
  private boolean hqO = true;
  private LinearLayout hqP;
  private ImageView hqQ;
  private TextView hqR;
  public final int hqS = 5;
  public final int hqT = 6;
  private Runnable hqU;
  private Animator.AnimatorListener hqV = new DragFeatureView.4(this);
  Paint mPaint = new Paint();
  protected Rect mRect = new Rect();
  
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
  
  private void arv()
  {
    this.hqR.setText(y.j.app_brand_desktop_delete_normal_text);
    this.hqR.setTextSize(2, 12.0F);
    this.hqQ.setImageResource(y.f.app_brand_desktop_delete_normal_icon);
    this.hqP.setBackgroundColor(getContext().getResources().getColor(y.d.app_brand_desktop_delete_normal_bg_color));
  }
  
  private void dQ(final boolean paramBoolean)
  {
    if (this.hqU == null)
    {
      Runnable local2 = new Runnable()
      {
        public final void run()
        {
          RecyclerView localRecyclerView = DragFeatureView.this.getRecyclerView();
          if (paramBoolean) {}
          for (int i = -20;; i = 20)
          {
            localRecyclerView.scrollBy(0, i);
            DragFeatureView.this.post(this);
            return;
          }
        }
      };
      this.hqU = local2;
      postDelayed(local2, 60L);
    }
  }
  
  private void init(Context paramContext)
  {
    this.hqG = ((int)getResources().getDimension(y.e.rubbish_height));
    setVisibility(8);
    this.gEU = new GestureDetector(paramContext, this);
    this.hpm = ((Vibrator)paramContext.getSystemService("vibrator"));
    paramContext = new LinearLayout(getContext());
    paramContext.setOrientation(1);
    paramContext.setGravity(17);
    paramContext.setBackgroundColor(getContext().getResources().getColor(y.d.app_brand_desktop_delete_normal_bg_color));
    Object localObject1 = new FrameLayout.LayoutParams(-1, this.hqG);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setId(y.g.rubbish_view);
    paramContext.setTranslationY(((FrameLayout.LayoutParams)localObject1).height);
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageResource(y.f.app_brand_desktop_delete_normal_icon);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).setMargins(0, a.aa(getContext(), y.e.SmallestPadding), 0, 0);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setText(y.j.app_brand_desktop_delete_normal_text);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(getContext().getResources().getColor(y.d.white));
    ((TextView)localObject2).setPadding(0, a.fromDPToPix(getContext(), 4), 0, 0);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramContext.addView((View)localObject1);
    paramContext.addView((View)localObject2);
    this.hqP = paramContext;
    this.hqQ = ((ImageView)localObject1);
    this.hqR = ((TextView)localObject2);
    addView(paramContext);
  }
  
  private void setItemDragCallback(b paramb)
  {
    this.hqI = paramb;
  }
  
  protected RecyclerView.v I(float paramFloat1, float paramFloat2)
  {
    if (this.hqM.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int i = 0;
    while (i < getRecyclerView().getChildCount())
    {
      RecyclerView.v localv = getRecyclerView().aT(getRecyclerView().getChildAt(i));
      localv.aie.getGlobalVisibleRect(this.mRect);
      if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
        return localv;
      }
      i += 1;
    }
    if (this.hqN.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    return null;
  }
  
  protected abstract b I(RecyclerView.v paramv);
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-65536);
    if (this.hqM != null) {
      paramCanvas.drawRect(this.hqM, this.mPaint);
    }
    this.mPaint.setColor(-16711936);
    if (this.hqN != null) {
      paramCanvas.drawRect(this.hqN, this.mPaint);
    }
  }
  
  public Rect getBottomScrollRect()
  {
    return this.hqM;
  }
  
  public b getItemDragCallback()
  {
    return this.hqI;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.acI;
  }
  
  public Rect getRubbishRect()
  {
    return this.bAZ;
  }
  
  public Rect getTopScrollRect()
  {
    return this.hqN;
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
    getGlobalVisibleRect(this.hqM);
    this.hqM.set(this.hqM.left, this.hqM.bottom - this.hqG * 2, this.hqM.right, this.hqM.bottom - this.hqG);
    getRecyclerView().getGlobalVisibleRect(this.hqN);
    this.hqN.set(this.hqN.left, 0, this.hqN.right, this.hqN.top + this.hqG);
    findViewById(y.g.rubbish_view).getGlobalVisibleRect(this.bAZ);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    RecyclerView.v localv = I(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    setItemDragCallback(I(localv));
    if (localv != null)
    {
      b localb = this.hqI;
      getRecyclerView();
      if (localb.J(localv))
      {
        this.hqL = this.hqI.c(getRecyclerView(), localv);
        this.hqK = localv.id();
        this.hqJ = localv;
        this.hpm.vibrate(30L);
        setRubbishViewVisible(0);
        setVisibility(0);
      }
    }
    for (;;)
    {
      paramMotionEvent.setAction(0);
      this.gEU.onTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(3);
      this.gEU.onTouchEvent(paramMotionEvent);
      return;
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
    boolean bool;
    if (!this.mRect.contains((int)f1, (int)f2)) {
      if (f1 < this.mRect.left)
      {
        i = 3;
        paramMotionEvent1 = I(paramMotionEvent2.getRawX(), paramMotionEvent2.getRawY());
        if (paramMotionEvent1 != null) {
          break label440;
        }
        bool = true;
        label88:
        y.i("MicroMsg.DragFeatureView", "alvinluo onScroll currentArea: %d, viewHolder == null: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
        if ((i != 1) && (i != 2) && (i != 6)) {
          break label520;
        }
        if (!getTopScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
          break label446;
        }
        dQ(true);
        label161:
        paramMotionEvent2 = this.hqI;
        getRecyclerView();
        paramMotionEvent2.a(this.hqL, paramFloat1, paramFloat2, paramMotionEvent1);
        if ((i != 1) && (i != 2))
        {
          removeCallbacks(this.hqU);
          this.hqU = null;
        }
        if ((Math.abs(paramFloat1) >= 3.0F) || (Math.abs(paramFloat2) >= 3.0F))
        {
          removeCallbacks(this.hqH);
          paramMotionEvent2 = this.hqI;
          getRecyclerView();
          if (!paramMotionEvent2.L(paramMotionEvent1)) {
            break label568;
          }
          this.hqI.i(getRecyclerView());
        }
      }
    }
    for (;;)
    {
      return true;
      if (f1 > this.mRect.right)
      {
        i = 4;
        break;
      }
      if (this.hqM.contains((int)f1, (int)f2))
      {
        i = 2;
        break;
      }
      if (this.hqN.contains((int)f1, (int)f2))
      {
        i = 1;
        break;
      }
      if (J(f1, f2))
      {
        i = 6;
        break;
      }
      i = 0;
      for (;;)
      {
        if (i >= getRecyclerView().getChildCount()) {
          break label433;
        }
        getRecyclerView().aT(getRecyclerView().getChildAt(i)).aie.getGlobalVisibleRect(this.mRect);
        if (this.mRect.contains((int)f1, (int)f2))
        {
          i = 5;
          break;
        }
        i += 1;
      }
      label433:
      i = 7;
      break;
      label440:
      bool = false;
      break label88;
      label446:
      if (getBottomScrollRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY()))
      {
        dQ(false);
        break label161;
      }
      if (!getRubbishRect().contains((int)paramMotionEvent2.getRawX(), (int)paramMotionEvent2.getRawY())) {
        break label161;
      }
      removeCallbacks(this.hqH);
      removeCallbacks(this.hqU);
      this.hqU = null;
      break label161;
      label520:
      if ((i != 3) && (i != 4)) {
        break label161;
      }
      paramMotionEvent2 = this.hqI;
      getRecyclerView();
      if (!paramMotionEvent2.L(paramMotionEvent1)) {
        break label161;
      }
      this.hqI.i(getRecyclerView());
      break label161;
      label568:
      paramMotionEvent1 = new DragFeatureView.a(this, paramMotionEvent1);
      this.hqH = paramMotionEvent1;
      postDelayed(paramMotionEvent1, 130L);
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.hqO) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.gEU.onTouchEvent(paramMotionEvent);
      return true;
      if (J(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
      {
        this.hqK = -1;
        this.hpN = false;
        this.hqI.d(getRecyclerView(), this.hqJ);
        removeCallbacks(this.hqH);
        removeCallbacks(this.hqU);
        if (this.hqL != null) {
          this.hqL.animate().alpha(0.0F).scaleX(0.0F).scaleY(0.0F).setListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              DragFeatureView.this.removeView(DragFeatureView.d(DragFeatureView.this));
              DragFeatureView.e(DragFeatureView.this);
              DragFeatureView.this.setRubbishViewVisible(8);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
            
            public final void onAnimationStart(Animator paramAnonymousAnimator) {}
          }).setDuration(250L).start();
        }
      }
      else
      {
        removeCallbacks(this.hqH);
        removeCallbacks(this.hqU);
        setRubbishViewVisible(8);
        int i = this.hqK;
        this.hqK = -1;
        this.hpN = false;
        this.hqI.a(getRecyclerView(), this.hqJ, i, new Runnable()
        {
          public final void run()
          {
            DragFeatureView.this.setVisibility(8);
            DragFeatureView.f(DragFeatureView.this);
            DragFeatureView.g(DragFeatureView.this);
          }
        });
        continue;
        if (J(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
        {
          this.hqP.setBackgroundColor(getContext().getResources().getColor(y.d.app_brand_desktop_delete_release_bg_color));
          this.hqR.setText(y.j.app_brand_desktop_release_delete_text);
          this.hqR.setTextSize(2, 12.0F);
          this.hqQ.setImageResource(y.f.app_brand_desktop_release_to_delete_icon);
        }
        else
        {
          arv();
        }
      }
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.acI = paramRecyclerView;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    View localView = findViewById(y.g.rubbish_view);
    if (localView == null) {
      return;
    }
    if (paramInt == 0)
    {
      localView.animate().translationY(0.0F).setDuration(250L).setListener(this.hqV).start();
      return;
    }
    localView.animate().translationY(localView.getHeight()).setDuration(250L).setListener(this.hqV).start();
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.hqO = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
 * JD-Core Version:    0.7.0.1
 */