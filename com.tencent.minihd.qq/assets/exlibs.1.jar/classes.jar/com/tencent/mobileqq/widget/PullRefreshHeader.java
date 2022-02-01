package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class PullRefreshHeader
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  int d;
  
  public PullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
  }
  
  private void d(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131366938), TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd") }));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    String str = "";
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      paramInt = 2130841568;
      str = getResources().getString(2131366942);
      continue;
      paramInt = 2130841566;
      str = getResources().getString(2131366939);
      continue;
      paramInt = 2130841567;
      str = getResources().getString(2131366939);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      paramInt = 2130841568;
      continue;
      paramInt = 2130841566;
      continue;
      paramInt = 2130841567;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366936);
      label9:
      d(paramLong);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label9;
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366937);
    d(paramLong);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841565);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366935);
    d(paramLong);
  }
  
  protected void onAttachedToWindow() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131296735));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298156));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298154));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298155));
    c(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */