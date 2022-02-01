package com.tencent.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.Orientation;

public class RotateLoadingLayout
  extends LoadingLayout
{
  static final int jdField_a_of_type_Int = 1200;
  private float jdField_a_of_type_Float;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private final Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private final boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(15, true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(1200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidGraphicsMatrix != null)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  protected int a()
  {
    return 2130841565;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
  }
  
  protected void a(float paramFloat) {}
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_Float = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.jdField_b_of_type_Float = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected int c()
  {
    return super.c();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.internal.RotateLoadingLayout
 * JD-Core Version:    0.7.0.1
 */