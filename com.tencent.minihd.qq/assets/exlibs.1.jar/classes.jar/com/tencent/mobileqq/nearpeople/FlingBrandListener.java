package com.tencent.mobileqq.nearpeople;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import jkf;
import jkg;
import jkh;
import jki;
import jkj;

public class FlingBrandListener
  implements View.OnTouchListener
{
  private static final int jdField_a_of_type_Int = -1;
  private static final String jdField_a_of_type_JavaLangString = "FlingBrandListener";
  private static final int jdField_b_of_type_Int = 40;
  private float jdField_a_of_type_Float = (float)Math.cos(Math.toRadians(45.0D));
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final FlingBrandListener.FlingListener jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener;
  private final Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean = false;
  private final float jdField_b_of_type_Float;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 0;
  private final float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 1;
  private float jdField_e_of_type_Float;
  private final int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private final int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private final int jdField_g_of_type_Int;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int = -1;
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int;
  private int j;
  
  @TargetApi(11)
  public FlingBrandListener(Context paramContext, View paramView, Object paramObject, float paramFloat, FlingBrandListener.FlingListener paramFlingListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((TurnBrandActivity)paramContext).app;
    if (VersionUtils.e()) {
      this.jdField_b_of_type_Float = paramView.getX();
    }
    for (this.jdField_c_of_type_Float = paramView.getY();; this.jdField_c_of_type_Float = paramView.getTop())
    {
      this.jdField_e_of_type_Int = paramView.getHeight();
      this.jdField_f_of_type_Int = paramView.getWidth();
      this.jdField_d_of_type_Float = (this.jdField_f_of_type_Int / 2.0F);
      this.jdField_a_of_type_JavaLangObject = paramObject;
      this.jdField_g_of_type_Int = ((ViewGroup)paramView.getParent()).getWidth();
      this.jdField_e_of_type_Float = paramFloat;
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener = paramFlingListener;
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      paramObject = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramObject);
      ((FrameLayout)paramView.getParent()).addView(this.jdField_a_of_type_AndroidWidgetImageView);
      paramView.post(new jkf(this, paramContext));
      return;
      this.jdField_b_of_type_Float = paramView.getLeft();
    }
  }
  
  private float a(int paramInt)
  {
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = this.jdField_b_of_type_Float;
    arrayOfFloat1[1] = this.jdField_f_of_type_Float;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = this.jdField_c_of_type_Float;
    arrayOfFloat2[1] = this.jdField_g_of_type_Float;
    double d1 = 0.0D;
    double d2 = 0.0D;
    int k = 0;
    while (k < 2)
    {
      d1 += arrayOfFloat1[k];
      k += 1;
    }
    k = 0;
    while (k < 2)
    {
      d2 += arrayOfFloat2[k];
      k += 1;
    }
    double d4 = d1 / 2.0D;
    double d5 = d2 / 2.0D;
    double d3 = 0.0D;
    d2 = 0.0D;
    d1 = 0.0D;
    k = 0;
    while (k < 2)
    {
      d3 += (arrayOfFloat1[k] - d4) * (arrayOfFloat1[k] - d4);
      d2 += (arrayOfFloat2[k] - d5) * (arrayOfFloat2[k] - d5);
      d1 += (arrayOfFloat1[k] - d4) * (arrayOfFloat2[k] - d5);
      k += 1;
    }
    d1 /= d3;
    return (float)d1 * paramInt + (float)(d5 - d1 * d4);
  }
  
  private float a(boolean paramBoolean)
  {
    float f2 = this.jdField_e_of_type_Float * 2.0F * (this.jdField_g_of_type_Int - this.jdField_b_of_type_Float) / this.jdField_g_of_type_Int;
    float f1 = f2;
    if (this.jdField_i_of_type_Int == 1) {
      f1 = -f2;
    }
    f2 = f1;
    if (paramBoolean) {
      f2 = -f1;
    }
    return f2;
  }
  
  @TargetApi(12)
  private boolean a()
  {
    boolean bool = NetworkUtil.f(BaseApplication.getContext());
    if ((this.jdField_f_of_type_Float + this.jdField_d_of_type_Float < this.jdField_g_of_type_Int / 4.0F) && (bool))
    {
      a(true, a(-this.jdField_f_of_type_Int), 100L);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new jkg(this));
      if (QLog.isColorLevel()) {
        QLog.d("FlingBrandListener", 2, "resetCardViewOnStack: left swipe!");
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_Float = 0.0F;
      this.jdField_g_of_type_Float = 0.0F;
      this.jdField_h_of_type_Float = 0.0F;
      this.jdField_i_of_type_Float = 0.0F;
      return false;
      if ((this.jdField_f_of_type_Float + this.jdField_d_of_type_Float > this.jdField_g_of_type_Int * 3 / 4.0F) && (bool))
      {
        a(false, a(this.jdField_g_of_type_Int), 100L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new jkh(this));
        if (QLog.isColorLevel()) {
          QLog.d("FlingBrandListener", 2, "resetCardViewOnStack: right swipe!");
        }
      }
      else
      {
        if (VersionUtils.f()) {
          this.jdField_a_of_type_AndroidViewView.animate().setDuration(200L).setInterpolator(new OvershootInterpolator(1.5F)).x(this.jdField_b_of_type_Float).y(this.jdField_c_of_type_Float).rotation(0.0F);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener.a(false, false, 0.0F, 0.0F);
        if (QLog.isColorLevel()) {
          QLog.d("FlingBrandListener", 2, "resetCardViewOnStack: go back, isNet: " + bool);
        }
        if (!bool) {
          ((TurnBrandActivity)this.jdField_a_of_type_AndroidContentContext).a(2131369584);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(paramBoolean, this.jdField_c_of_type_Float, 200L);
    }
  }
  
  @TargetApi(12)
  public void a(boolean paramBoolean, float paramFloat, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramBoolean) {}
    for (float f1 = -this.jdField_f_of_type_Int / this.jdField_a_of_type_Float; VersionUtils.f(); f1 = this.jdField_g_of_type_Int + this.jdField_f_of_type_Int / this.jdField_a_of_type_Float - this.jdField_f_of_type_Int)
    {
      this.jdField_a_of_type_AndroidViewView.animate().cancel();
      this.jdField_a_of_type_AndroidViewView.animate().setDuration(paramLong).setInterpolator(new AccelerateInterpolator()).x(f1).y(paramFloat).setListener(new jki(this, paramBoolean)).rotation(a(paramBoolean));
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, f1, 0.0F, paramFloat);
    localTranslateAnimation.setDuration(paramLong);
    localTranslateAnimation.setAnimationListener(new jkj(this, paramBoolean));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  @TargetApi(11)
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = 0;
    float f1;
    float f2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    case 5: 
    default: 
    case 0: 
    case 1: 
    case 6: 
      for (;;)
      {
        return true;
        for (;;)
        {
          try
          {
            this.jdField_h_of_type_Int = paramMotionEvent.getPointerId(0);
            f1 = paramMotionEvent.getX(this.jdField_h_of_type_Int);
            f2 = paramMotionEvent.getY(this.jdField_h_of_type_Int);
            this.jdField_h_of_type_Float = f1;
            this.jdField_i_of_type_Float = f2;
            if (this.jdField_f_of_type_Float == 0.0F)
            {
              if (VersionUtils.e()) {
                this.jdField_f_of_type_Float = this.jdField_a_of_type_AndroidViewView.getX();
              }
            }
            else
            {
              if (this.jdField_g_of_type_Float == 0.0F)
              {
                if (!VersionUtils.e()) {
                  break label187;
                }
                this.jdField_g_of_type_Float = this.jdField_a_of_type_AndroidViewView.getY();
              }
              if (f2 >= this.jdField_e_of_type_Int / 2) {
                break;
              }
              this.jdField_i_of_type_Int = 0;
              return true;
            }
          }
          catch (IllegalArgumentException paramView)
          {
            paramView.printStackTrace();
            return true;
          }
          this.jdField_f_of_type_Float = this.jdField_a_of_type_AndroidViewView.getLeft();
          continue;
          this.jdField_g_of_type_Float = this.jdField_a_of_type_AndroidViewView.getTop();
        }
        this.jdField_i_of_type_Int = 1;
        return true;
        this.jdField_h_of_type_Int = -1;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        a();
        return true;
        try
        {
          int m = (paramMotionEvent.getAction() & 0xFF00) >> 8;
          if (paramMotionEvent.getPointerId(m) == this.jdField_h_of_type_Int)
          {
            if (m == 0) {
              k = 1;
            }
            this.jdField_h_of_type_Int = paramMotionEvent.getPointerId(k);
            return true;
          }
        }
        catch (IllegalArgumentException paramView)
        {
          paramView.printStackTrace();
          return true;
        }
      }
    case 2: 
      for (;;)
      {
        try
        {
          label187:
          k = paramMotionEvent.findPointerIndex(this.jdField_h_of_type_Int);
          f1 = paramMotionEvent.getX(k);
          f2 = paramMotionEvent.getY(k);
          float f3 = this.jdField_h_of_type_Float;
          float f4 = this.jdField_i_of_type_Float;
          this.jdField_f_of_type_Float = (f1 - f3 + this.jdField_f_of_type_Float);
          this.jdField_g_of_type_Float = (f2 - f4 + this.jdField_g_of_type_Float);
          f2 = (this.jdField_f_of_type_Float - this.jdField_b_of_type_Float) * this.jdField_e_of_type_Float / this.jdField_g_of_type_Int;
          f1 = f2;
          if (this.jdField_i_of_type_Int == 1) {
            f1 = -f2;
          }
          if (!VersionUtils.e()) {
            break label646;
          }
          this.jdField_a_of_type_AndroidViewView.setX(this.jdField_f_of_type_Float);
          this.jdField_a_of_type_AndroidViewView.setY(this.jdField_g_of_type_Float);
          this.jdField_a_of_type_AndroidViewView.setRotation(f1);
          if (this.jdField_f_of_type_Float - this.jdField_b_of_type_Float > 0.0F)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            f2 = Math.abs(this.jdField_f_of_type_Float - this.jdField_b_of_type_Float) / (this.jdField_f_of_type_Int / 3.0F);
            f1 = f2;
            if (f2 > 1.0F) {
              f1 = 1.0F;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().setAlpha((int)(f1 * 255.0F));
            if (this.jdField_f_of_type_Float - this.jdField_b_of_type_Float <= 0.0F) {
              break label601;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setX(this.jdField_f_of_type_Float + 40.0F);
            this.jdField_a_of_type_AndroidWidgetImageView.setY(this.jdField_g_of_type_Float + 40.0F);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener.a(true, false, this.jdField_f_of_type_Float - this.jdField_b_of_type_Float, this.jdField_g_of_type_Float - this.jdField_c_of_type_Float);
            return true;
          }
        }
        catch (IllegalArgumentException paramView)
        {
          paramView.printStackTrace();
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
        continue;
        label601:
        this.jdField_a_of_type_AndroidWidgetImageView.setX(this.jdField_f_of_type_Float + this.jdField_f_of_type_Int - 40.0F - this.j);
        this.jdField_a_of_type_AndroidWidgetImageView.setY(this.jdField_g_of_type_Float + 40.0F);
        continue;
        label646:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.layout((int)this.jdField_f_of_type_Float, (int)this.jdField_g_of_type_Float, (int)this.jdField_f_of_type_Float + this.jdField_f_of_type_Int, (int)this.jdField_g_of_type_Float + this.jdField_e_of_type_Int);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_h_of_type_Int = -1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.FlingBrandListener
 * JD-Core Version:    0.7.0.1
 */