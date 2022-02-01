package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.minihd.qq.R.styleable;

public class TipsBar
  extends RelativeLayout
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private float jdField_a_of_type_Float;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public TipsBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.jdField_a_of_type_Float = localResources.getDisplayMetrics().density;
    this.f = localResources.getDimensionPixelSize(2131493360);
    this.g = localResources.getDimensionPixelSize(2131493361);
    this.h = localResources.getDimensionPixelSize(2131493362);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Z);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2);
    this.b = paramContext.getString(5);
    this.e = paramContext.getInt(0, 2);
    this.i = paramContext.getDimensionPixelSize(3, 0);
    this.j = paramContext.getDimensionPixelSize(4, 0);
    paramContext.recycle();
    a();
  }
  
  public static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131427948);
    case 1: 
      return paramResources.getColorStateList(2131427948);
    case 2: 
      return paramResources.getColorStateList(2131427957);
    }
    return paramResources.getColorStateList(2131427948);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130838084);
    case 1: 
      return paramResources.getDrawable(2130838090);
    case 2: 
      return paramResources.getDrawable(2130838090);
    }
    return paramResources.getDrawable(2130838084);
  }
  
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296435);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.e));
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    setTipsIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.i, this.j);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.g;
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296436);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    if (!TextUtils.isEmpty(this.b)) {
      b();
    }
    for (;;)
    {
      setBackgroundDrawable(b(localResources, this.e));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296436);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      localObject = c(localResources, this.e);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = this.g;
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public static ColorStateList b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131427938);
    case 1: 
      return paramResources.getColorStateList(2131427934);
    case 2: 
      return paramResources.getColorStateList(2131427938);
    case 3: 
      return paramResources.getColorStateList(2131427938);
    }
    return paramResources.getColorStateList(2131427999);
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130838163);
    case 1: 
      return paramResources.getDrawable(2130838164);
    case 2: 
      return paramResources.getDrawable(2130838163);
    case 3: 
      return paramResources.getDrawable(2130838160);
    }
    return paramResources.getDrawable(2130838164);
  }
  
  private void b()
  {
    Object localObject = getResources();
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131296436);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.b);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.b);
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(2, 15.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(a((Resources)localObject, this.e));
    this.jdField_a_of_type_AndroidWidgetButton.setMinWidth((int)(this.jdField_a_of_type_Float * 56.0F + 0.5D));
    this.jdField_a_of_type_AndroidWidgetButton.setMinHeight((int)(this.jdField_a_of_type_Float * 30.0F + 0.5D));
    this.jdField_a_of_type_AndroidWidgetButton.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetButton.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a((Resources)localObject, this.e));
    int k = (int)(this.jdField_a_of_type_Float * 11.0F + 0.5D);
    this.jdField_a_of_type_AndroidWidgetButton.setPadding(k, 0, k, 0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = this.g;
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetButton, (ViewGroup.LayoutParams)localObject);
  }
  
  public static Drawable c(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130838158);
    case 1: 
      return paramResources.getDrawable(2130838158);
    case 2: 
      return paramResources.getDrawable(2130838157);
    case 3: 
      return paramResources.getDrawable(2130838157);
    }
    return paramResources.getDrawable(2130838159);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.f);
  }
  
  public void setBarType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    if (paramInt == this.e) {}
    Resources localResources;
    do
    {
      return;
      this.e = paramInt;
      localResources = getResources();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.e));
      }
      setBackgroundDrawable(b(localResources, this.e));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        Drawable localDrawable = c(localResources, this.e);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    } while (this.jdField_a_of_type_AndroidWidgetButton == null);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(a(localResources, this.e));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(localResources, this.e));
  }
  
  public void setButtonText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.b = paramCharSequence.toString();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      if (this.jdField_a_of_type_AndroidWidgetButton == null) {
        b();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramCharSequence);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if ((!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_AndroidWidgetButton != null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    super.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void setTipsIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable.getIntrinsicHeight() > this.f)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.f);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setTipsIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.i = paramInt1;
        this.j = Math.min(this.f, paramInt2);
        paramDrawable.setBounds(0, 0, this.i, this.j);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setTipsIcon(paramDrawable);
  }
  
  public void setTipsText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TipsBar
 * JD-Core Version:    0.7.0.1
 */