package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.minihd.qq.R.styleable;

public class ProgressWheel
  extends View
{
  private static final String jdField_a_of_type_JavaLangString = ProgressWheel.class.getSimpleName();
  private double jdField_a_of_type_Double = 0.0D;
  private float jdField_a_of_type_Float = 0.0F;
  private final int jdField_a_of_type_Int = 16;
  private final long jdField_a_of_type_Long = 200L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private ProgressWheel.ProgressCallback jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel$ProgressCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private double jdField_b_of_type_Double = 460.0D;
  private float jdField_b_of_type_Float = 230.0F;
  private final int jdField_b_of_type_Int = 270;
  private long jdField_b_of_type_Long = 0L;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 28;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int = 4;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 4;
  private boolean jdField_e_of_type_Boolean;
  private int f = -1442840576;
  private int g = 16777215;
  
  public ProgressWheel(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.K));
    d();
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel$ProgressCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel$ProgressCallback.a(paramFloat);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int m = getPaddingLeft();
    int n = getPaddingRight();
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = Math.min(Math.min(paramInt1 - m - n, paramInt2 - k - j), this.jdField_c_of_type_Int * 2 - this.jdField_d_of_type_Int * 2);
      paramInt1 = m + (paramInt1 - m - n - i) / 2;
      paramInt2 = j + (paramInt2 - j - k - i) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_d_of_type_Int + paramInt1, this.jdField_d_of_type_Int + paramInt2, paramInt1 + i - this.jdField_d_of_type_Int, paramInt2 + i - this.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(m + this.jdField_d_of_type_Int, j + this.jdField_d_of_type_Int, paramInt1 - n - this.jdField_d_of_type_Int, paramInt2 - k - this.jdField_d_of_type_Int);
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_b_of_type_Long >= 200L)
    {
      this.jdField_a_of_type_Double += paramLong;
      if (this.jdField_a_of_type_Double > this.jdField_b_of_type_Double)
      {
        this.jdField_a_of_type_Double -= this.jdField_b_of_type_Double;
        this.jdField_b_of_type_Long = 0L;
        if (this.jdField_b_of_type_Boolean) {
          break label109;
        }
      }
      label109:
      for (boolean bool = true;; bool = false)
      {
        this.jdField_b_of_type_Boolean = bool;
        f1 = (float)Math.cos((this.jdField_a_of_type_Double / this.jdField_b_of_type_Double + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_Float = (f1 * 254.0F);
        return;
      }
      float f1 = (1.0F - f1) * 254.0F;
      this.jdField_c_of_type_Float += this.jdField_a_of_type_Float - f1;
      this.jdField_a_of_type_Float = f1;
      return;
    }
    this.jdField_b_of_type_Long += paramLong;
  }
  
  private void a(TypedArray paramTypedArray)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.jdField_d_of_type_Int = ((int)TypedValue.applyDimension(1, this.jdField_d_of_type_Int, localDisplayMetrics));
    this.jdField_e_of_type_Int = ((int)TypedValue.applyDimension(1, this.jdField_e_of_type_Int, localDisplayMetrics));
    this.jdField_c_of_type_Int = ((int)TypedValue.applyDimension(1, this.jdField_c_of_type_Int, localDisplayMetrics));
    this.jdField_c_of_type_Int = ((int)paramTypedArray.getDimension(6, this.jdField_c_of_type_Int));
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(7, false);
    this.jdField_d_of_type_Int = ((int)paramTypedArray.getDimension(8, this.jdField_d_of_type_Int));
    this.jdField_e_of_type_Int = ((int)paramTypedArray.getDimension(3, this.jdField_e_of_type_Int));
    this.jdField_b_of_type_Float = (paramTypedArray.getFloat(4, this.jdField_b_of_type_Float / 360.0F) * 360.0F);
    this.jdField_b_of_type_Double = paramTypedArray.getInt(5, (int)this.jdField_b_of_type_Double);
    this.f = paramTypedArray.getColor(1, this.f);
    this.g = paramTypedArray.getColor(2, this.g);
    this.jdField_c_of_type_Boolean = paramTypedArray.getBoolean(9, false);
    if (paramTypedArray.getBoolean(0, false)) {
      c();
    }
    paramTypedArray.recycle();
  }
  
  @TargetApi(17)
  private void d()
  {
    float f1;
    if (Build.VERSION.SDK_INT >= 17)
    {
      f1 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      if (f1 == 0.0F) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = bool;
      return;
      f1 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Int);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel$ProgressCallback != null)
    {
      float f1 = Math.round(this.jdField_c_of_type_Float * 100.0F / 360.0F) / 100.0F;
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel$ProgressCallback.a(f1);
    }
  }
  
  public float a()
  {
    if (this.jdField_d_of_type_Boolean) {
      return -1.0F;
    }
    return this.jdField_c_of_type_Float / 360.0F;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float / 360.0F;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    invalidate();
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_d_of_type_Boolean = true;
    invalidate();
  }
  
  public int d()
  {
    return this.g;
  }
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 360.0F, 360.0F, false, this.jdField_b_of_type_AndroidGraphicsPaint);
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    float f1;
    if (this.jdField_d_of_type_Boolean)
    {
      i = 1;
      long l = SystemClock.uptimeMillis() - this.jdField_c_of_type_Long;
      f1 = (float)l * this.jdField_b_of_type_Float / 1000.0F;
      a(l);
      this.jdField_c_of_type_Float += f1;
      if (this.jdField_c_of_type_Float > 360.0F)
      {
        this.jdField_c_of_type_Float -= 360.0F;
        a(-1.0F);
      }
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      f1 = this.jdField_c_of_type_Float - 90.0F;
      f2 = 16.0F + this.jdField_a_of_type_Float;
      if (isInEditMode())
      {
        f2 = 135.0F;
        f1 = 0.0F;
      }
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f1, f2, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      label161:
      if (i != 0) {
        invalidate();
      }
    }
    else
    {
      f1 = this.jdField_c_of_type_Float;
      if (this.jdField_c_of_type_Float == this.jdField_d_of_type_Float) {
        break label338;
      }
      this.jdField_c_of_type_Float = Math.min((float)(SystemClock.uptimeMillis() - this.jdField_c_of_type_Long) / 1000.0F * this.jdField_b_of_type_Float + this.jdField_c_of_type_Float, this.jdField_d_of_type_Float);
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    }
    label338:
    for (int i = 1;; i = 0)
    {
      if (f1 != this.jdField_c_of_type_Float) {
        f();
      }
      f1 = this.jdField_c_of_type_Float;
      if (!this.jdField_c_of_type_Boolean)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - this.jdField_c_of_type_Float / 360.0F, 2.0F * 2.0F)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.jdField_c_of_type_Float / 360.0F, 2.0F)) * 360.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      for (;;)
      {
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, f2 - 90.0F, f1, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        break label161;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int k = this.jdField_c_of_type_Int + getPaddingLeft() + getPaddingRight();
    int i = this.jdField_c_of_type_Int + getPaddingTop() + getPaddingBottom();
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      if ((n != 1073741824) && (m != 1073741824)) {
        break label118;
      }
      paramInt2 = j;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      if (m == -2147483648)
      {
        paramInt1 = Math.min(k, paramInt1);
        break;
      }
      paramInt1 = k;
      break;
      label118:
      paramInt2 = i;
      if (n == -2147483648) {
        paramInt2 = Math.min(i, j);
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ProgressWheel.WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ProgressWheel.WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_c_of_type_Float = paramParcelable.jdField_a_of_type_Float;
    this.jdField_d_of_type_Float = paramParcelable.jdField_b_of_type_Float;
    this.jdField_d_of_type_Boolean = paramParcelable.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Float = paramParcelable.jdField_c_of_type_Float;
    this.jdField_d_of_type_Int = paramParcelable.jdField_a_of_type_Int;
    this.f = paramParcelable.jdField_b_of_type_Int;
    this.jdField_e_of_type_Int = paramParcelable.jdField_c_of_type_Int;
    this.g = paramParcelable.jdField_d_of_type_Int;
    this.jdField_c_of_type_Int = paramParcelable.jdField_e_of_type_Int;
    this.jdField_c_of_type_Boolean = paramParcelable.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Boolean = paramParcelable.jdField_c_of_type_Boolean;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState()
  {
    ProgressWheel.WheelSavedState localWheelSavedState = new ProgressWheel.WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
    localWheelSavedState.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
    localWheelSavedState.jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
    localWheelSavedState.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
    localWheelSavedState.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
    localWheelSavedState.jdField_b_of_type_Int = this.f;
    localWheelSavedState.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    localWheelSavedState.jdField_d_of_type_Int = this.g;
    localWheelSavedState.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
    localWheelSavedState.jdField_b_of_type_Boolean = this.jdField_c_of_type_Boolean;
    localWheelSavedState.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    return localWheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
    e();
    invalidate();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    }
  }
  
  public void setBarColor(int paramInt)
  {
    this.f = paramInt;
    e();
    if (!this.jdField_d_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setBarWidth(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (!this.jdField_d_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setCallback(ProgressWheel.ProgressCallback paramProgressCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel$ProgressCallback = paramProgressCallback;
    if (!this.jdField_d_of_type_Boolean) {
      f();
    }
  }
  
  public void setCircleRadius(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (!this.jdField_d_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setInstantProgress(float paramFloat)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_d_of_type_Boolean = false;
    }
    float f1;
    if (paramFloat > 1.0F) {
      f1 = paramFloat - 1.0F;
    }
    while (f1 == this.jdField_d_of_type_Float)
    {
      return;
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
    }
    this.jdField_d_of_type_Float = Math.min(f1 * 360.0F, 360.0F);
    this.jdField_c_of_type_Float = this.jdField_d_of_type_Float;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (!this.jdField_d_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_d_of_type_Boolean = false;
      f();
    }
    float f1;
    if (paramFloat > 1.0F) {
      f1 = paramFloat - 1.0F;
    }
    while (f1 == this.jdField_d_of_type_Float)
    {
      return;
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
    }
    if (this.jdField_c_of_type_Float == this.jdField_d_of_type_Float) {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_d_of_type_Float = Math.min(f1 * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt)
  {
    this.g = paramInt;
    e();
    if (!this.jdField_d_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setRimWidth(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (!this.jdField_d_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.jdField_b_of_type_Float = (360.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.ProgressWheel
 * JD-Core Version:    0.7.0.1
 */