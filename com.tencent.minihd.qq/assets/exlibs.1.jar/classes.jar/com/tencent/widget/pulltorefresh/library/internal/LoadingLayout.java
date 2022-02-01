package com.tencent.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.widget.pulltorefresh.library.ILoadingLayout;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout
  extends FrameLayout
  implements ILoadingLayout
{
  static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  static final String jdField_a_of_type_JavaLangString = "PullToRefresh-LoadingLayout";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected final ImageView a;
  protected final ProgressBar a;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  protected final PullToRefreshBase.Mode a;
  protected final PullToRefreshBase.Orientation a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private CharSequence c;
  private CharSequence d;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Orientation = paramOrientation;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    switch (luh.b[paramOrientation.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(2130903421, this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298157));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131298159));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131298162));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131298160));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131298161));
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      switch (luh.a[paramMode.ordinal()])
      {
      default: 
        if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL)
        {
          i = 80;
          label183:
          localLayoutParams.gravity = i;
          this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131366930);
          this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131366932);
          this.c = paramContext.getString(2131366931);
          this.d = paramContext.getString(2131370016);
          if (paramTypedArray.hasValue(1))
          {
            paramOrientation = paramTypedArray.getDrawable(1);
            if (paramOrientation != null) {
              ViewCompat.a(this, paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(10))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(10, paramOrientation);
            b(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(11))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(11, paramOrientation);
            a(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(2))
          {
            paramOrientation = paramTypedArray.getColorStateList(2);
            if (paramOrientation != null) {
              b(paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(3))
          {
            paramOrientation = paramTypedArray.getColorStateList(3);
            if (paramOrientation != null) {
              a(paramOrientation);
            }
          }
          paramOrientation = null;
          if (paramTypedArray.hasValue(6)) {
            paramOrientation = paramTypedArray.getDrawable(6);
          }
          switch (luh.a[paramMode.ordinal()])
          {
          default: 
            if (paramTypedArray.hasValue(7)) {
              paramMode = paramTypedArray.getDrawable(7);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramOrientation = paramMode;
      if (paramMode == null) {
        paramOrientation = paramContext.getResources().getDrawable(a());
      }
      setLoadingDrawable(paramOrientation);
      i();
      return;
      LayoutInflater.from(paramContext).inflate(2130903420, this);
      break;
      a(paramContext, paramMode);
      break;
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {}
      for (i = 48;; i = 3)
      {
        localLayoutParams.gravity = i;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131370012);
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131370015);
        this.c = paramContext.getString(2131370014);
        this.d = paramContext.getString(2131370016);
        break;
      }
      i = 5;
      break label183;
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(17))
      {
        Utils.a("ptrDrawableTop", "ptrDrawableStart");
        paramMode = paramTypedArray.getDrawable(17);
        continue;
        if (paramTypedArray.hasValue(8))
        {
          paramMode = paramTypedArray.getDrawable(8);
        }
        else
        {
          paramMode = paramOrientation;
          if (paramTypedArray.hasValue(18))
          {
            Utils.a("ptrDrawableBottom", "ptrDrawableEnd");
            paramMode = paramTypedArray.getDrawable(18);
          }
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void a(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    switch (luh.a[paramMode.ordinal()])
    {
    default: 
      return;
    case 1: 
      LayoutInflater.from(paramContext).inflate(2130903421, this);
      return;
    }
    LayoutInflater.from(paramContext).inflate(2130903419, this);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label24;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label24:
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    } while (8 != this.jdField_b_of_type_AndroidWidgetTextView.getVisibility());
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void b(ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  protected abstract int a();
  
  protected abstract void a();
  
  protected abstract void a(float paramFloat);
  
  protected abstract void a(Drawable paramDrawable);
  
  public final void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public final int b()
  {
    switch (luh.b[this.jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$Orientation.ordinal()])
    {
    default: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    }
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
  }
  
  protected abstract void b();
  
  public final void b(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(paramFloat);
    }
  }
  
  protected int c()
  {
    return 0;
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  public final void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public final void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    a();
  }
  
  public final void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
    }
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      b();
    }
  }
  
  public final void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
    }
    c();
  }
  
  public final void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(a());
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      d();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public final void j()
  {
    if (4 == this.jdField_a_of_type_AndroidWidgetTextView.getVisibility()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (4 == this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility()) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if (4 == this.jdField_a_of_type_AndroidWidgetImageView.getVisibility()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (4 == this.jdField_b_of_type_AndroidWidgetTextView.getVisibility()) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_Boolean = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramTypeface);
  }
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.internal.LoadingLayout
 * JD-Core Version:    0.7.0.1
 */