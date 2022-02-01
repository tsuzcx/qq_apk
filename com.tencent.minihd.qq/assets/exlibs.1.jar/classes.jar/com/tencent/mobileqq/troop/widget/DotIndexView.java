package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DotIndexView
  extends LinearLayout
{
  protected int a;
  protected Context a;
  protected LinearLayout a;
  protected int b = 0;
  protected int c = 8;
  
  public DotIndexView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130839515;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
  }
  
  public DotIndexView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130839515;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    a(0, paramInt);
  }
  
  public DotIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130839515;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
  }
  
  private void a(boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(this.c, 0, this.c, 0);
    localLayoutParams.gravity = 17;
    localImageView.setLayoutParams(localLayoutParams);
    try
    {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int));
      if (paramBoolean) {
        localImageView.setSelected(true);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localImageView.setImageResource(2130839515);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt2 != this.b))
    {
      removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      int i = 0;
      if (i < paramInt2)
      {
        if (i == paramInt1) {
          a(true);
        }
        for (;;)
        {
          i += 1;
          break;
          a(false);
        }
      }
      this.b = paramInt2;
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  public void setDotDrawable(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.b != 0))
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int);
        paramInt = 0;
        while (paramInt < this.b)
        {
          View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
          if ((localView != null) && ((localView instanceof ImageView))) {
            ((ImageView)localView).setImageDrawable(localDrawable);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void setDotSelected(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        int i = 0;
        while (i < this.b)
        {
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setSelected(false);
          }
          i += 1;
        }
      }
    } while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt) == null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setSelected(paramBoolean);
  }
  
  public void setMargin(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.DotIndexView
 * JD-Core Version:    0.7.0.1
 */