package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import kzh;
import kzi;

public class TabBarView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a;
  private static final int b = 2;
  private static final int c;
  private static final int d;
  private static final int e;
  private static final int f;
  private static final int g;
  private static final int j = 10;
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private float jdField_a_of_type_Float;
  public long a;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new kzh(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public TabBarView.OnTabChangeListener a;
  public boolean a;
  public final Paint b;
  private int h = -1;
  private int i = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = TabBarView.class.getSimpleName();
    Context localContext = BaseApplicationImpl.getContext();
    c = (int)(44.0F * localContext.getResources().getDisplayMetrics().density + 0.5F);
    d = (int)(2.0F * localContext.getResources().getDisplayMetrics().density + 0.5F);
    e = (int)(1.0F * localContext.getResources().getDisplayMetrics().density + 0.5F);
    f = (int)(16.0F * localContext.getResources().getDisplayMetrics().density);
    g = (int)(localContext.getResources().getDisplayMetrics().density * 8.0F);
  }
  
  public TabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(a(getContext(), 1));
    this.b = new Paint();
    this.b.setColor(Color.parseColor("#E5E5E5"));
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 1;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getResources().getColor(2131427938);
    case 1: 
      return paramContext.getResources().getColor(2131427938);
    }
    return paramContext.getResources().getColor(2131427972);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(a(getContext(), 2));
    }
    localView = getChildAt(paramInt2);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(a(getContext(), 1));
    }
  }
  
  public int a()
  {
    return this.i;
  }
  
  public RedDotTextView a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  public void a()
  {
    this.i = -1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("index is not legal, please check!");
    }
    removeViewAt(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, 16);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, paramInt2);
    localRedDotTextView.setTextColor(a(getContext(), 2));
    localRedDotTextView.setSingleLine();
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setGravity(1);
    localRedDotTextView.setPadding(0, f, 0, g);
    localRedDotTextView.setOnClickListener(new kzi(this, paramInt1));
    addView(localRedDotTextView, paramInt1, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
  
  public void a(String paramString)
  {
    a(getChildCount(), paramString);
  }
  
  public int b()
  {
    return c;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.i);
    int i1;
    int n;
    if (localView1 != null)
    {
      i1 = localView1.getLeft();
      n = localView1.getRight();
      if (this.jdField_a_of_type_Float <= 0.0F) {
        break label209;
      }
      View localView2 = getChildAt(this.h);
      if (localView2 == null) {
        break label209;
      }
      i1 = (int)(localView1.getLeft() + this.jdField_a_of_type_Float * (localView2.getLeft() - localView1.getLeft()));
      float f1 = localView1.getRight();
      float f2 = this.jdField_a_of_type_Float;
      n = (int)(f1 + (localView2.getRight() - localView1.getRight()) * f2);
    }
    label209:
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        int i2 = getHeight() - (d - e) / 2;
        int i3 = e;
        paramCanvas.drawRect(getPaddingLeft(), i2 - i3, getWidth() - getPaddingRight(), i2, this.b);
      }
      paramCanvas.drawRect(i1 + 0, getHeight() - d, n - 0, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(c, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), c);
  }
  
  public void setOnTabChangeListener(TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = paramOnTabChangeListener;
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    int n = paramInt;
    if (paramInt < 0) {
      n = 0;
    }
    int i1 = getChildCount();
    paramInt = n;
    if (n >= i1) {
      paramInt = i1 - 1;
    }
    if (this.i != paramInt)
    {
      a(this.i, paramInt);
      if (paramBoolean)
      {
        this.h = paramInt;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    else
    {
      return;
    }
    this.h = paramInt;
    this.jdField_a_of_type_Float = 1.0F;
    b(this.i, paramInt);
    invalidate();
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */