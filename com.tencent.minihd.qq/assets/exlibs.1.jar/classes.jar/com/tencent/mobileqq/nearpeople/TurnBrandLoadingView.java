package com.tencent.mobileqq.nearpeople;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import jkx;
import jky;

public class TurnBrandLoadingView
  extends RelativeLayout
{
  private static final int jdField_a_of_type_Int = 301;
  private static final String jdField_a_of_type_JavaLangString = "TurnBrandLoadingView";
  private static final int jdField_b_of_type_Int = 301;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d;
  
  public TurnBrandLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903973, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((TurnBrandActivity)this.jdField_a_of_type_AndroidContentContext).app;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300308));
    this.b = ((ImageView)findViewById(2131300312));
    paramContext = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (paramContext != null) {
      this.b.setImageDrawable(paramContext);
    }
    this.jdField_c_of_type_Int = AIOUtils.a(301.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.d = AIOUtils.a(301.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 359.0F, this.jdField_c_of_type_Int / 2, this.d / 2);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(3000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300309));
    this.jdField_c_of_type_AndroidWidgetImageView.post(new jkx(this));
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_c_of_type_Int, this.d, Bitmap.Config.ARGB_8888);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        return;
      }
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      RectF localRectF = new RectF(0.0F, 0.0F, this.jdField_c_of_type_Int, this.d);
      localPaint.setShader(new SweepGradient(this.jdField_c_of_type_Int / 2, this.d / 2, new int[] { 1604845, -15172371 }, null));
      localCanvas.drawArc(localRectF, 0.0F, 180.0F, true, localPaint);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TurnBrandLoadingView", 2, "createScanBitmap OutOfMemoryError happened!");
      }
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.post(new jky(this));
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.TurnBrandLoadingView
 * JD-Core Version:    0.7.0.1
 */