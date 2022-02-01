package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.minihd.qq.R.styleable;

public class FormSimpleItem
  extends RelativeLayout
  implements FormItemConstants
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private Drawable c;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = getResources().getDimensionPixelSize(2131493297);
  private int q = getResources().getDimensionPixelSize(2131493298);
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public FormSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131493296);
    float f = getResources().getDisplayMetrics().density;
    this.v = ((int)(1.0F * f + 0.5F));
    this.s = ((int)(35.0F * f + 0.5D));
    this.t = ((int)(f * 15.0F + 0.5D));
    this.c = getResources().getDrawable(2130838068);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.u);
    this.o = paramContext.getDimensionPixelSize(3, i1);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(4);
    this.j = paramContext.getInt(6, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(5);
    this.h = paramContext.getDimensionPixelSize(1, 0);
    this.i = paramContext.getDimensionPixelSize(2, 0);
    this.i = Math.min(this.o, this.i);
    this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(7);
    this.m = paramContext.getInt(11, 2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(8);
    this.k = paramContext.getDimensionPixelSize(9, 0);
    this.l = paramContext.getDimensionPixelSize(10, 0);
    this.l = Math.min(this.o, this.l);
    this.n = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131427934);
    case 0: 
      return paramResources.getColorStateList(2131427934);
    case 2: 
      return paramResources.getColorStateList(2131427972);
    }
    return paramResources.getColorStateList(2131427938);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130838151);
    case 0: 
      return paramResources.getDrawable(2130838151);
    case 1: 
      return paramResources.getDrawable(2130838156);
    case 2: 
      return paramResources.getDrawable(2130838155);
    }
    return paramResources.getDrawable(2130838153);
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
  
  private boolean a()
  {
    if (getBackground() != null) {
      return false;
    }
    View localView = (View)getParent();
    return (localView == null) || (localView.getBackground() == null);
  }
  
  private void d()
  {
    int i3 = 0;
    int i2 = getResources().getDisplayMetrics().widthPixels - this.p * 2;
    int i1;
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean)) {
        i1 = this.s + this.p + this.t;
      }
      for (;;)
      {
        this.u = (i2 - i1);
        this.r = 0;
        return;
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean)) {
          i1 = this.s;
        } else if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean)) {
          i1 = this.t;
        } else {
          i1 = 0;
        }
      }
    }
    int i4 = i2 - this.p;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (this.h == 0)
      {
        i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i1 += this.p;
      }
    }
    for (;;)
    {
      i2 = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString()) + i1;
      i1 = i3;
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (this.k == 0)
        {
          i1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          label202:
          i1 = this.p + (i1 + 0);
        }
      }
      else
      {
        i3 = i1;
        if (this.jdField_a_of_type_Boolean)
        {
          i3 = this.c.getIntrinsicWidth();
          i3 = this.p + (i3 + i1);
        }
        i3 += (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());
        i1 = i4 / 2;
        if ((i2 < i1) || (i3 < i1)) {
          break label304;
        }
        i2 = i1;
      }
      for (;;)
      {
        this.u = i2;
        this.r = i1;
        return;
        i1 = this.h;
        break;
        i1 = this.k;
        break label202;
        label304:
        if ((i2 > i1) && (i3 < i1))
        {
          i2 = i4 - i3;
          i1 = i3;
        }
        else if ((i2 < i1) && (i3 > i1))
        {
          i1 = i4 - i2;
        }
        else
        {
          i1 = i3;
        }
      }
      i1 = 0;
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    do
    {
      do
      {
        return;
        d();
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.u);
        }
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.r);
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
        {
          if ((this.k > 0) && (this.l > 0))
          {
            this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
            return;
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
          }
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.k > 0) && (this.l > 0))
          {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
            return;
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
        }
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.c, null);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
          return;
        }
      } while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p / 2);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, this.c, null);
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.c, null);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
        return;
      }
    } while ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296439);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.j));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 18.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.h, this.i);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.u);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296441);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 18.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    e();
    localObject = new View(getContext());
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.v);
    localLayoutParams.leftMargin = this.p;
    localLayoutParams.rightMargin = this.p;
    localLayoutParams.addRule(12);
    addView((View)localObject, localLayoutParams);
    a(this.n);
  }
  
  public void a(boolean paramBoolean) {}
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void b()
  {
    Object localObject2 = (ImageView)findViewById(2131296440);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ImageView(getContext());
      ((ImageView)localObject1).setImageResource(2130841952);
      ((ImageView)localObject1).setId(2131296440);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296439);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = getResources().getDimensionPixelSize(2131492912);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    ((ImageView)localObject1).setVisibility(0);
  }
  
  public void c()
  {
    ImageView localImageView = (ImageView)findViewById(2131296440);
    if (localImageView != null) {
      removeView(localImageView);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (a()) {
      setBackgroundDrawable(a(getResources(), this.n));
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.o);
  }
  
  public void setArrowIcon(Drawable paramDrawable)
  {
    this.c = paramDrawable;
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.n = paramInt;
    a(paramInt);
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.o = paramInt;
      requestLayout();
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
    if (paramDrawable.getIntrinsicHeight() > this.o)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.o);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.q);
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
        this.h = paramInt1;
        this.i = Math.min(this.o, paramInt2);
        paramDrawable.setBounds(0, 0, paramInt1, this.i);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.q);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.j));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      this.j = paramInt;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.j));
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.v = ((int)(getResources().getDisplayMetrics().density * 1.0F + 0.5F));
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    setRightIcon(paramDrawable, 0, 0);
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    this.k = paramInt1;
    this.l = Math.min(this.o, paramInt2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    e();
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    e();
  }
  
  public void setRightTextColor(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      throw new RuntimeException("Parameter colorType is illegal!");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.m = paramInt;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(getResources(), this.m));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSimpleItem
 * JD-Core Version:    0.7.0.1
 */