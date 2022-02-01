package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class ProfileCardScrollImageView
  extends ImageView
{
  private static final String jdField_a_of_type_JavaLangString = "ProfileCard.VipProfileCardPreviewActivity";
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 3;
  private static final int g = 4;
  private static int h = 3;
  private int jdField_a_of_type_Int = 1500;
  private long jdField_a_of_type_Long;
  private AccelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  
  public ProfileCardScrollImageView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ProfileCardScrollImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ProfileCardScrollImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator == null) {
      this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(1.0F);
    }
  }
  
  public void a()
  {
    h = 3;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    h = 0;
    this.jdField_c_of_type_Boolean = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.onDraw(paramCanvas);
    }
    for (;;)
    {
      return;
      switch (h)
      {
      }
      while (!this.jdField_c_of_type_Boolean)
      {
        invalidate();
        return;
        super.onDraw(paramCanvas);
        continue;
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        h = 1;
        this.jdField_b_of_type_Boolean = false;
        super.onDraw(paramCanvas);
        continue;
        float f1;
        if (this.jdField_a_of_type_Long >= 0L)
        {
          f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Int;
          if (f1 < 1.0F) {
            break label208;
          }
          if (this.jdField_b_of_type_Boolean) {
            break label200;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
        for (;;)
        {
          if (this.jdField_c_of_type_Boolean) {
            h = 4;
          }
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.jdField_b_of_type_Int);
          super.onDraw(paramCanvas);
          paramCanvas.restore();
          if (!this.jdField_c_of_type_Boolean) {
            break;
          }
          invalidate();
          break;
          label200:
          this.jdField_c_of_type_Boolean = true;
          continue;
          label208:
          f1 = Math.min(f1, 1.0F);
          float f2;
          if (!this.jdField_b_of_type_Boolean)
          {
            f2 = this.jdField_c_of_type_Int;
            this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f1) * f2));
          }
          else
          {
            int i = this.jdField_c_of_type_Int;
            f2 = this.jdField_c_of_type_Int;
            this.jdField_b_of_type_Int = (i - (int)(this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f1) * f2));
          }
        }
        paramCanvas.save();
        paramCanvas.translate(0.0F, 0.0F);
        super.onDraw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }
  
  public void setIsScroll(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardScrollImageView
 * JD-Core Version:    0.7.0.1
 */