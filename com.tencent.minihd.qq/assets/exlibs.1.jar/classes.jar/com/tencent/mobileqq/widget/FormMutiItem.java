package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class FormMutiItem
  extends FormSimpleItem
{
  protected LinearLayout a;
  protected TextView a;
  protected CharSequence a;
  protected TextView b;
  protected CharSequence b;
  protected int h = 0;
  protected int i = 2;
  protected int j;
  protected int k;
  
  public FormMutiItem(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FormMutiItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.h));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.i));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131296439);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296441);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    setCustomHeight(getResources().getDimensionPixelSize(2131493299));
  }
  
  public void setFirstLineText(int paramInt)
  {
    this.jdField_a_of_type_JavaLangCharSequence = getResources().getString(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setFirstLineText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setFirstLineTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.h);
  }
  
  public void setFirstLineTextSize(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, this.j);
  }
  
  public void setSecondLineText(int paramInt)
  {
    this.jdField_b_of_type_JavaLangCharSequence = getResources().getString(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
  }
  
  public void setSecondLineText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
  }
  
  public void setSecondLineTextColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.i);
  }
  
  public void setSecondLineTextSize(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.k);
  }
  
  public void setSecondLineVisible(boolean paramBoolean)
  {
    boolean bool2 = false;
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      bool1 = true;
      if ((bool1 ^ paramBoolean))
      {
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label44;
        }
      }
    }
    label44:
    int m;
    for (boolean bool1 = bool2;; m = 8)
    {
      localTextView.setVisibility(bool1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */