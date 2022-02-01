package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQTabActivity;
import com.tencent.mobileqq.customviews.CircleMenu;
import com.tencent.mobileqq.customviews.CircleMenuManager;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.StartupTracker;
import mqq.app.BasePadActivity;

public class QQTabHost
  extends TabHost
{
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener;
  private QQTabHost.OnTabSelectionListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private boolean b = false;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof OnDrawCompleteListener)) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = ((OnDrawCompleteListener)paramContext);
    }
  }
  
  public QQTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    if ((paramContext instanceof OnDrawCompleteListener)) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = ((OnDrawCompleteListener)paramContext);
    }
  }
  
  private void a(View paramView, int[] paramArrayOfInt)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramArrayOfInt[0];
    arrayOfFloat[1] = paramArrayOfInt[1];
    arrayOfFloat[0] += paramView.getLeft();
    arrayOfFloat[1] += paramView.getTop();
    for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)) && (paramView != this); paramView = paramView.getParent())
    {
      paramView = (View)paramView;
      arrayOfFloat[0] += paramView.getLeft() - paramView.getScrollX();
      arrayOfFloat[1] += paramView.getTop() - paramView.getScrollY();
    }
    paramArrayOfInt[0] = Math.round(arrayOfFloat[0]);
    paramArrayOfInt[1] = Math.round(arrayOfFloat[1]);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject1 = CircleMenuManager.a();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((CircleMenu)localObject1).a();
      if ((localObject2 != null) && (!a((View)localObject2, paramMotionEvent)))
      {
        ((CircleMenu)localObject1).d();
        return true;
      }
    }
    else if ((getContext() instanceof QQTabActivity))
    {
      localObject1 = ((QQTabActivity)getContext()).b();
      if ((localObject1 instanceof Leba))
      {
        localObject2 = (ViewGroup)((Activity)localObject1).findViewById(2131297931);
        if ((localObject2 != null) && (((ViewGroup)localObject2).getChildCount() > 0) && (!a((View)localObject2, paramMotionEvent)))
        {
          paramMotionEvent = ((Activity)localObject1).getFragmentManager();
          ReflectionUtil.a(paramMotionEvent, paramMotionEvent.getClass(), "noteStateNotSaved", null, null);
          paramMotionEvent.popBackStackImmediate();
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    a(paramView, this.jdField_a_of_type_AndroidGraphicsRect);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  public void a(View paramView, Rect paramRect)
  {
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
    this.jdField_a_of_type_ArrayOfInt[1] = 0;
    a(paramView, this.jdField_a_of_type_ArrayOfInt);
    paramRect.set(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_ArrayOfInt[0] + paramView.getWidth(), this.jdField_a_of_type_ArrayOfInt[1] + paramView.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.b) {
      StartupTracker.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.b)
    {
      StartupTracker.a("Recent_Draw", null);
      this.b = false;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener.a();
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (BasePadActivity.sFragmentAnimating) {}
    while ((this.jdField_a_of_type_Boolean) || ((paramMotionEvent.getAction() == 0) && (a(paramMotionEvent)))) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.b) {
      StartupTracker.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b) {
      StartupTracker.a("Recent_OnLayout", null);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    SizeMeasure.b(getContext());
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCurrentTab(int paramInt)
  {
    int i = getTabWidget().getTabCount();
    if ((paramInt < 0) || (paramInt >= i)) {}
    do
    {
      return;
      i = getCurrentTab();
      super.setCurrentTab(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener.a(i, paramInt, this);
  }
  
  public void setFirstDrawTrue()
  {
    this.b = true;
  }
  
  public void setOnTabSelectionListener(QQTabHost.OnTabSelectionListener paramOnTabSelectionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener = paramOnTabSelectionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */