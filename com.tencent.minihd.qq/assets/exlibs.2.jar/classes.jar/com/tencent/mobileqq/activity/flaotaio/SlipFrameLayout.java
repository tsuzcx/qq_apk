package com.tencent.mobileqq.activity.flaotaio;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.util.SizeMeasure;
import gmv;
import gmw;
import gmx;

public class SlipFrameLayout
  extends FrameLayout
{
  public static float a = 0.0F;
  private static DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(1.5F);
  static final float jdField_b_of_type_Float = 0.8F;
  private static final boolean jdField_c_of_type_Boolean = true;
  private static final int g = 150;
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private RootCallBack jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack;
  public boolean a;
  int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 100.0F;
  int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 200;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 400;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 2000;
  
  static
  {
    jdField_a_of_type_Float = 0.0F;
  }
  
  public SlipFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlipFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private float a(View paramView)
  {
    float f1 = 1.0F;
    float f2 = paramView.getMeasuredWidth();
    float f3 = 0.8F * f2;
    float f4 = paramView.getTranslationX();
    if (f4 >= jdField_a_of_type_Float * f2) {
      f1 = 1.0F - (f4 - f2 * jdField_a_of_type_Float) / f3;
    }
    for (;;)
    {
      return Math.max(0.03F, f1);
      if (f4 < (1.0F - jdField_a_of_type_Float) * f2) {
        f1 = 1.0F + (f2 * jdField_a_of_type_Float + f4) / f3;
      }
    }
  }
  
  private ObjectAnimator a(View paramView, float paramFloat)
  {
    return ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat });
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_e_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Float = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledPagingTouchSlop();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    paramContext = getResources();
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2131493083);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(2131493084);
    int i = paramContext.getDimensionPixelSize(2131493085);
    this.jdField_c_of_type_Int = (paramContext.getDimensionPixelSize(2131493086) + i);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (!this.jdField_d_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        float f1 = paramMotionEvent.getX() - this.jdField_f_of_type_Float;
        if (f1 >= 0.0F)
        {
          this.jdField_a_of_type_AndroidViewView.setTranslationX(f1);
          this.jdField_a_of_type_AndroidViewView.setAlpha(a(this.jdField_a_of_type_AndroidViewView));
          continue;
          f1 = this.jdField_f_of_type_Int;
          float f2 = this.jdField_e_of_type_Float;
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, f1 * f2);
          f2 = this.jdField_c_of_type_Float;
          float f3 = this.jdField_e_of_type_Float;
          f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
          float f4 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
          int i;
          label189:
          int j;
          label223:
          int k;
          if (Math.abs(this.jdField_a_of_type_AndroidViewView.getTranslationX()) > 0.4D * this.jdField_a_of_type_AndroidViewView.getMeasuredWidth())
          {
            i = 1;
            if ((Math.abs(f1) <= f3 * f2) || (Math.abs(f1) <= Math.abs(f4))) {
              break label307;
            }
            if (f1 <= 0.0F) {
              break label295;
            }
            j = 1;
            if (this.jdField_a_of_type_AndroidViewView.getTranslationX() <= 0.0F) {
              break label301;
            }
            k = 1;
            label238:
            if (j != k) {
              break label307;
            }
            j = 1;
            label248:
            if (j == 0)
            {
              k = m;
              if (i == 0) {}
            }
            else
            {
              k = 1;
            }
            if (k == 0) {
              break label318;
            }
            paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
            if (j == 0) {
              break label313;
            }
          }
          for (;;)
          {
            a(paramMotionEvent, f1);
            break;
            i = 0;
            break label189;
            label295:
            j = 0;
            break label223;
            label301:
            k = 0;
            break label238;
            label307:
            j = 0;
            break label248;
            label313:
            f1 = 0.0F;
          }
          label318:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack.c(this.jdField_a_of_type_AndroidViewView);
          }
          b(this.jdField_a_of_type_AndroidViewView, f1);
        }
      }
    }
  }
  
  public void a()
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      localView.setTranslationX(0.0F);
      localView.setAlpha(1.0F);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    float f1 = paramView.getMeasuredWidth();
    int i = this.jdField_e_of_type_Int;
    if (paramFloat != 0.0F) {}
    for (i = Math.min(i, (int)(Math.abs(f1 - paramView.getTranslationX()) * 1000.0F / Math.abs(paramFloat)));; i = this.jdField_d_of_type_Int)
    {
      paramView.setLayerType(2, null);
      ObjectAnimator localObjectAnimator = a(paramView, f1);
      localObjectAnimator.setInterpolator(jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator);
      localObjectAnimator.setDuration(i);
      localObjectAnimator.addListener(new gmv(this, paramView));
      localObjectAnimator.addUpdateListener(new gmw(this, paramView));
      localObjectAnimator.start();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(View paramView, float paramFloat)
  {
    ObjectAnimator localObjectAnimator = a(paramView, 0.0F);
    localObjectAnimator.setDuration('');
    localObjectAnimator.setInterpolator(jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator);
    localObjectAnimator.addUpdateListener(new gmx(this, paramView));
    localObjectAnimator.start();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null) {
        bool = super.dispatchKeyEvent(paramKeyEvent);
      }
      do
      {
        do
        {
          return bool;
          if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
            break;
          }
          localDispatcherState = getKeyDispatcherState();
        } while (localDispatcherState == null);
        localDispatcherState.startTracking(paramKeyEvent, this);
        return true;
        if (paramKeyEvent.getAction() != 1) {
          break;
        }
        KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState == null) || (!localDispatcherState.isTracking(paramKeyEvent)) || (paramKeyEvent.isCanceled())) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack.p();
      return true;
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_d_of_type_Boolean;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = getChildAt(0);
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        this.jdField_f_of_type_Float = paramMotionEvent.getX();
        continue;
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
          if (paramMotionEvent.getX() - this.jdField_f_of_type_Float > this.jdField_d_of_type_Float)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack.a(this.jdField_a_of_type_AndroidViewView);
            }
            this.jdField_d_of_type_Boolean = true;
            this.jdField_f_of_type_Float = (paramMotionEvent.getX() - this.jdField_a_of_type_AndroidViewView.getTranslationX());
            continue;
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    SizeMeasure.b(getContext());
    if ((getChildCount() == 0) || (!this.jdField_a_of_type_Boolean))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getChildAt(0).getLayoutParams();
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i < this.jdField_a_of_type_Int + this.jdField_b_of_type_Int)
    {
      i -= this.jdField_b_of_type_Int;
      if (i > this.jdField_c_of_type_Int) {
        localLayoutParams.height = i;
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      localLayoutParams.height = this.jdField_c_of_type_Int;
      continue;
      if (localLayoutParams.height < this.jdField_a_of_type_Int) {
        localLayoutParams.height = this.jdField_a_of_type_Int;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (getChildCount() == 0) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        View localView = getChildAt(0);
        if ((paramMotionEvent.getAction() != 0) || ((i >= localView.getLeft()) && (i < localView.getLeft() + localView.getWidth()) && (j >= localView.getTop()) && (j < localView.getTop() + localView.getHeight()))) {
          break;
        }
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack.s();
      return true;
      if (paramMotionEvent.getAction() != 4) {
        break;
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack.s();
    return true;
    if ((a(paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
    a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack.i();
    }
  }
  
  public void setCallBack(RootCallBack paramRootCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioRootCallBack = paramRootCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.SlipFrameLayout
 * JD-Core Version:    0.7.0.1
 */