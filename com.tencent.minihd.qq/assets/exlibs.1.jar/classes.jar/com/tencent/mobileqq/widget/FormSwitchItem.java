package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.minihd.qq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.Switch;

public class FormSwitchItem
  extends RelativeLayout
  implements FormItemConstants
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private int h;
  private int i;
  private int j = getResources().getDimensionPixelSize(2131493297);
  private int k;
  private int l;
  private int m;
  
  public FormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int n = getResources().getDimensionPixelSize(2131493296);
    this.k = ((int)(getResources().getDisplayMetrics().density * 1.0F + 0.5F));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.u);
    this.i = paramContext.getDimensionPixelSize(3, n);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(13);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.l = paramContext.getDimensionPixelSize(1, 0);
    this.m = paramContext.getDimensionPixelSize(2, 0);
    this.m = Math.min(this.i, this.m);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(14, false);
    this.h = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130841913);
    case 0: 
      return paramResources.getDrawable(2130841913);
    case 1: 
      return paramResources.getDrawable(2130841925);
    case 2: 
      return paramResources.getDrawable(2130841921);
    }
    return paramResources.getDrawable(2130841915);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296437);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 18.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427934));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.l, this.m);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296438);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setId(2131296438);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = this.j;
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetSwitch, (ViewGroup.LayoutParams)localObject);
    localObject = new View(getContext());
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.k);
    localLayoutParams.leftMargin = this.j;
    localLayoutParams.rightMargin = this.j;
    localLayoutParams.addRule(12);
    addView((View)localObject, localLayoutParams);
    a(this.h);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f2f2f2"));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
  }
  
  public Switch a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwitch;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
        }
      }
    }
    while ((this.jdField_a_of_type_ComTencentWidgetSwitch == null) || (this.jdField_a_of_type_ComTencentWidgetSwitch.getVisibility() == 0))
    {
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, getResources()), AIOUtils.a(24.0F, getResources()));
      localLayoutParams.rightMargin = this.j;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838127));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      return this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked();
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.i, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.i);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.h = paramInt;
    a(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(paramCharSequence);
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.i = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.i)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.i);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.j);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.l = paramInt1;
        this.m = Math.min(this.i, paramInt2);
        paramDrawable.setBounds(0, 0, this.l, this.m);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.j);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427934));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchItem
 * JD-Core Version:    0.7.0.1
 */