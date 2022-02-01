package com.tencent.mobileqq.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.widget.VerticalGallery;

public class TroopGagDurationSettingPannel
  extends LinearLayout
  implements NumberWheelView.ScrollStateListener
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private NumberWheelView jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView;
  public int b;
  private NumberWheelView b;
  public int c;
  private NumberWheelView c;
  private final int d = 30;
  private final int e = 24;
  private final int f = 60;
  private final int g = 60;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public TroopGagDurationSettingPannel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewLayoutInflater == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView == null) && (this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView == null) && (this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView == null))
    {
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903505, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView = ((NumberWheelView)findViewById(2131298560));
      this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView = ((NumberWheelView)findViewById(2131298562));
      this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView = ((NumberWheelView)findViewById(2131298564));
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView.setScrollStateListener(this);
      this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView.setScrollStateListener(this);
      this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView.setScrollStateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView.setmMaxRotationAngle(120);
      this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView.setmMaxRotationAngle(120);
      this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView.setmMaxRotationAngle(120);
      this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView.setRange(0, this.h - 1);
      this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView.setRange(0, 23);
      this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView.setRange(0, 59);
    }
    a(true);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.l != 1) || (this.m != 1) || (this.n != 1)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0) && (this.jdField_c_of_type_Int == 0))
      {
        this.jdField_c_of_type_Int = 1;
        this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView.setValue(this.jdField_c_of_type_Int);
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView.setValue(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView.setValue(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView.setValue(this.jdField_c_of_type_Int);
  }
  
  public int a()
  {
    return ((this.jdField_a_of_type_Int * 24 + this.jdField_b_of_type_Int) * 60 + this.jdField_c_of_type_Int) * 60;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, 30);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      this.h = paramInt4;
      if ((paramInt1 < 0) || (paramInt1 >= this.h)) {
        break label109;
      }
      label23:
      this.i = paramInt1;
      if ((paramInt2 < 0) || (paramInt2 >= 24)) {
        break label114;
      }
      label38:
      this.j = paramInt2;
      if ((paramInt3 < 0) || (paramInt3 >= 60)) {
        break label119;
      }
    }
    for (;;)
    {
      this.k = paramInt3;
      this.jdField_a_of_type_Int = this.i;
      this.jdField_b_of_type_Int = this.j;
      this.jdField_c_of_type_Int = this.k;
      this.l = 1;
      this.m = 1;
      this.n = 1;
      a();
      return;
      paramInt4 = 30;
      break;
      label109:
      paramInt1 = 0;
      break label23;
      label114:
      paramInt2 = 0;
      break label38;
      label119:
      paramInt3 = 0;
    }
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityNumberWheelView.a();
    this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqActivityNumberWheelView.a();
    this.jdField_c_of_type_Int = this.jdField_c_of_type_ComTencentMobileqqActivityNumberWheelView.a();
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagDurationSettingPannel
 * JD-Core Version:    0.7.0.1
 */