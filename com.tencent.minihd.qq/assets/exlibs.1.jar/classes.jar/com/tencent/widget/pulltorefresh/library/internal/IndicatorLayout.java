package com.tencent.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.Mode;

@SuppressLint({"ViewConstructor"})
public class IndicatorLayout
  extends FrameLayout
  implements Animation.AnimationListener
{
  static final int jdField_a_of_type_Int = 150;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Animation b;
  private final Animation c;
  private final Animation d;
  
  public IndicatorLayout(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    Drawable localDrawable = getResources().getDrawable(2130838467);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    int i = getResources().getDimensionPixelSize(2131493512);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    int j;
    switch (lug.a[paramMode.ordinal()])
    {
    default: 
      j = 2130968761;
      i = 2130968763;
      setBackgroundResource(2130838469);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, j);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.b = AnimationUtils.loadAnimation(paramContext, i);
      this.b.setAnimationListener(this);
      paramContext = new LinearInterpolator();
      this.c = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
      this.c.setInterpolator(paramContext);
      this.c.setDuration(150L);
      this.c.setFillAfter(true);
      this.d = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.d.setInterpolator(paramContext);
      this.d.setDuration(150L);
      this.d.setFillAfter(true);
      return;
      j = 2130968760;
      i = 2130968762;
      setBackgroundResource(2130838468);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
      paramMode = new Matrix();
      paramMode.setRotate(180.0F, localDrawable.getIntrinsicWidth() / 2.0F, localDrawable.getIntrinsicHeight() / 2.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(paramMode);
    }
  }
  
  public void a()
  {
    startAnimation(this.b);
  }
  
  public final boolean a()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null) {
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation != localAnimation) {}
    }
    while (getVisibility() == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.c);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.d);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.b)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      setVisibility(8);
    }
    for (;;)
    {
      clearAnimation();
      return;
      if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) {
        setVisibility(0);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.internal.IndicatorLayout
 * JD-Core Version:    0.7.0.1
 */