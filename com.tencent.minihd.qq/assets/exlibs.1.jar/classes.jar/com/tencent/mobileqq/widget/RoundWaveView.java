package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.minihd.qq.R.styleable;
import com.tencent.mobileqq.ptt.SoundLevelSource;
import com.tencent.qphone.base.util.QLog;
import kyw;

public class RoundWaveView
  extends View
{
  private static final String jdField_a_of_type_JavaLangString = "RoundWaveView";
  private final float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private SoundLevelSource jdField_a_of_type_ComTencentMobileqqPttSoundLevelSource;
  private kyw jdField_a_of_type_Kyw;
  private final float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private final float c;
  private float d;
  private final float e;
  private float f = -1.0F;
  private float g = -1.0F;
  
  public RoundWaveView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.O, paramInt, 0);
    this.jdField_a_of_type_Float = paramContext.getDimensionPixelOffset(0, 0);
    this.e = paramContext.getDimensionPixelOffset(1, 0);
    this.jdField_b_of_type_Float = paramContext.getDimensionPixelOffset(2, 0);
    if ((this.jdField_a_of_type_Float <= 0.0F) || (this.jdField_b_of_type_Float <= 0.0F)) {}
    for (this.c = 0.0F;; this.c = (this.jdField_b_of_type_Float / this.jdField_a_of_type_Float))
    {
      paramInt = paramContext.getColor(3, 872415231);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      paramInt = paramContext.getColor(4, 872415231);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
      paramContext.recycle();
      QLog.d("RoundWaveView", 4, String.format("RoundWaveView[maxWaveRadius:%f,minScale:%f] init", new Object[] { Float.valueOf(this.jdField_a_of_type_Float), Float.valueOf(this.c) }));
      this.jdField_a_of_type_ComTencentMobileqqPttSoundLevelSource = new SoundLevelSource();
      return;
    }
  }
  
  public void a()
  {
    QLog.i("RoundWaveView", 4, "start wave animation");
    b();
    this.jdField_a_of_type_Kyw = new kyw(this, 0.4F, 0.0F, this.jdField_b_of_type_Float, this.e, 1000L);
    ViewCompat.postOnAnimation(this, this.jdField_a_of_type_Kyw);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Kyw != null)
    {
      this.jdField_a_of_type_Kyw.a();
      this.jdField_a_of_type_Kyw = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    float f1 = this.c;
    float f2 = (1.0F - this.c) * this.d / 100.0F;
    paramCanvas.drawCircle(i, j, (f1 + f2) * this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    if ((this.f > 0.0F) && (this.g > 0.0F))
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * this.g));
      paramCanvas.drawCircle(i, j, this.f, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setLevelSource(SoundLevelSource paramSoundLevelSource)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttSoundLevelSource = paramSoundLevelSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundWaveView
 * JD-Core Version:    0.7.0.1
 */