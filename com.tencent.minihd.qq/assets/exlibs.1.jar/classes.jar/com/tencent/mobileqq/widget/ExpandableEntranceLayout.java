package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.minihd.qq.R.styleable;
import kxx;

public class ExpandableEntranceLayout
  extends ViewGroup
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  private static final int c = 135;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ExpandableEntranceLayout.OnExpandedItemSelectListener jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnExpandedItemSelectListener;
  private ExpandableEntranceLayout.OnToggleListener jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnToggleListener;
  private boolean jdField_a_of_type_Boolean;
  private int d;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l;
  
  public ExpandableEntranceLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ExpandableEntranceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    a(paramContext, paramAttributeSet);
  }
  
  public ExpandableEntranceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a(paramContext, paramAttributeSet);
  }
  
  private int a(View paramView)
  {
    int n = getChildCount();
    int m = 0;
    while (m < n - 1)
    {
      if (getChildAt(m) == paramView) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private static int a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int m = paramInt2;
    if (paramBoolean) {
      m = paramInt1 - 1 - paramInt2;
    }
    return m;
  }
  
  private static long a(int paramInt1, boolean paramBoolean, int paramInt2, float paramFloat, long paramLong)
  {
    paramFloat = (float)paramLong * paramFloat;
    paramLong = (a(paramBoolean, paramInt1, paramInt2) * paramFloat);
    paramFloat *= paramInt1;
    return (paramFloat * ((float)paramLong / paramFloat));
  }
  
  private static Rect a(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    double d1 = paramInt1 + paramInt3 * Math.cos(Math.toRadians(paramFloat));
    double d2 = paramInt2 + paramInt3 * Math.sin(Math.toRadians(paramFloat));
    return new Rect((int)(d1 - paramInt4 / 2), (int)(d2 - paramInt4 / 2), (int)(d1 + paramInt4 / 2), (int)(d2 + paramInt4 / 2));
  }
  
  private Animation a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6)
  {
    if (this.d > -1)
    {
      float f1;
      if (paramInt1 == this.d)
      {
        paramInt1 = 1;
        localAnimationSet = new AnimationSet(true);
        if (paramInt1 == 0) {
          break label108;
        }
        f1 = 2.0F;
        label35:
        if (paramInt1 == 0) {
          break label114;
        }
      }
      label108:
      label114:
      for (float f2 = 2.0F;; f2 = 0.0F)
      {
        localAnimationSet.addAnimation(new ScaleAnimation(1.0F, f1, 1.0F, f2, 1, 0.5F, 1, 0.5F));
        localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
        localAnimationSet.setDuration(paramInt6);
        localAnimationSet.setInterpolator(new DecelerateInterpolator());
        return localAnimationSet;
        paramInt1 = 0;
        break;
        f1 = 0.0F;
        break label35;
      }
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l1 = paramInt6 / 2;
    RollingTranslateAnimation localRollingTranslateAnimation = new RollingTranslateAnimation(paramInt2, paramInt3, paramInt4, paramInt5, 360.0F, 720.0F);
    localRollingTranslateAnimation.setStartOffset(paramLong + l1);
    localRollingTranslateAnimation.setDuration(paramInt6 - l1);
    localRollingTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(paramLong + l1);
    localAlphaAnimation.setDuration(paramInt6 - l1);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAnimationSet.addAnimation(localRollingTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }
  
  private Animation a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
    localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.8F));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.5F));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setDuration(paramInt5);
    localAnimationSet.setStartOffset(paramLong);
    return localAnimationSet;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.n, 0, 0);
    try
    {
      this.e = paramContext.getDimensionPixelSize(1, 0);
      this.f = paramContext.getDimensionPixelSize(2, 0);
      this.g = paramContext.getInt(3, 0);
      this.h = paramContext.getInt(4, 0);
      this.i = paramContext.getInt(0, 0);
      this.j = paramContext.getInt(5, 0);
      this.k = paramContext.getInt(6, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void b()
  {
    c();
  }
  
  private void c()
  {
    float f1 = getResources().getDisplayMetrics().density;
    this.e = ((int)(this.e * f1));
    this.f = ((int)(f1 * this.f));
  }
  
  private void d()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setId(2131296429);
    localImageView.setImageResource(2130840424);
    addView(localImageView);
    localImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
  }
  
  private void e() {}
  
  public void a()
  {
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    Object localObject;
    float f1;
    label37:
    float f2;
    label47:
    int n;
    int m;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      localObject = getChildAt(getChildCount() - 1);
      if (!this.jdField_a_of_type_Boolean) {
        break label156;
      }
      f1 = 0.0F;
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      f2 = 135.0F;
      localObject = new RotateAnimation(f1, f2, ((View)localObject).getMeasuredWidth() / 2, ((View)localObject).getMeasuredHeight() / 2);
      ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
      ((Animation)localObject).setFillAfter(true);
      n = getChildCount() - 1;
      if (paramBoolean) {
        break label197;
      }
      ((Animation)localObject).setDuration(0L);
      m = 0;
      label113:
      if (m >= n) {
        break label176;
      }
      localObject = getChildAt(m);
      if (!this.jdField_a_of_type_Boolean) {
        break label167;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      m += 1;
      break label113;
      bool = false;
      break;
      label156:
      f1 = 135.0F;
      break label37;
      label162:
      f2 = 0.0F;
      break label47;
      label167:
      ((View)localObject).setVisibility(4);
    }
    label176:
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnToggleListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnToggleListener.a(this.jdField_a_of_type_Boolean);
    }
    label197:
    label249:
    do
    {
      return;
      ((Animation)localObject).setDuration(200L);
      int i1 = getMeasuredWidth() / 2;
      int i2 = getMeasuredHeight() / 2;
      m = 0;
      if (m < n)
      {
        View localView = getChildAt(m);
        int i3;
        int i4;
        if (this.l == 1)
        {
          f1 = 0.0F;
          i3 = this.e;
          f2 = this.h;
          localObject = a(i1, i2, i3, f1 * m + f2, this.f);
          i3 = i1 - (((Rect)localObject).left + ((Rect)localObject).width() / 2);
          i4 = ((Rect)localObject).top;
          i4 = i2 - (((Rect)localObject).height() / 2 + i4);
          if (!this.jdField_a_of_type_Boolean) {
            break label426;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label421;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          localObject = a(i3, 0, i4, 0, a(n, paramBoolean, m, 0.1F, this.j), this.j);
          ((Animation)localObject).setAnimationListener(new kxx(this, localView));
          localView.setAnimation((Animation)localObject);
          m += 1;
          break;
          f1 = (this.g - this.h) / (n - 1);
          break label249;
        }
        if (!this.jdField_a_of_type_Boolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localObject = a(m, 0, i3, 0, i4, a(n, paramBoolean, m, 0.1F, this.k), this.k);
          break;
        }
      }
      invalidate();
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnToggleListener == null);
    label421:
    label426:
    this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnToggleListener.a(this.jdField_a_of_type_Boolean);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.d = a(paramView);
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnExpandedItemSelectListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnExpandedItemSelectListener.a(paramView);
      }
      return;
    }
    e();
    a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      View localView = getChildAt(m);
      localView.setVisibility(4);
      localView.setOnClickListener(this);
      m += 1;
    }
    d();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.i;
    paramInt4 = getChildCount();
    label106:
    float f1;
    label124:
    float f2;
    int m;
    label147:
    Object localObject;
    switch (paramInt1 & 0x7)
    {
    case 2: 
    case 4: 
    default: 
      paramInt2 = this.f + this.e;
      switch (paramInt1 & 0x70)
      {
      default: 
        paramInt1 = this.f + this.e;
        if (paramInt4 <= 2)
        {
          f1 = this.g - this.h;
          f2 = this.h;
          m = getChildAt(paramInt4 - 1).getMeasuredHeight();
          paramInt3 = 0;
          if (paramInt3 >= paramInt4) {
            return;
          }
          if (paramInt3 != paramInt4 - 1) {
            break label337;
          }
          localObject = getChildAt(paramInt3);
          int n = ((View)localObject).getMeasuredWidth() / 2;
          int i1 = ((View)localObject).getMeasuredHeight() / 2;
          getChildAt(paramInt3).layout(paramInt2 - n, paramInt1 - i1, n + paramInt2, i1 + paramInt1);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramInt3 += 1;
      break label147;
      paramInt2 = this.f;
      break;
      paramInt2 = this.f + this.e;
      break;
      paramInt2 = this.f + this.e;
      break;
      paramInt1 = this.f;
      break label106;
      paramInt1 = this.f + this.e;
      break label106;
      if (this.l == 1)
      {
        paramInt1 = (this.f + this.e) * (paramInt4 - 1);
        break label106;
      }
      paramInt1 = this.f + this.e;
      break label106;
      f1 = (this.g - this.h) / (paramInt4 - 2);
      break label124;
      label337:
      localObject = a(paramInt2, paramInt1, this.e, f2, this.f);
      f2 += f1;
      if (this.l == 1) {
        getChildAt(paramInt3).layout(paramInt2 - this.f / 2, paramInt1 - m / 2 - (this.e + this.f / 3) * (paramInt3 + 1), this.f / 2 + paramInt2, paramInt1 - m / 2 - (this.e + this.f / 3) * (paramInt3 + 1) + this.f);
      } else {
        getChildAt(paramInt3).layout(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.e + this.f;
    int n = this.i;
    int m = getChildCount();
    label108:
    label116:
    View localView;
    switch (n & 0x7)
    {
    case 2: 
    case 4: 
    default: 
      paramInt2 = paramInt1 * 2;
      switch (n & 0x70)
      {
      default: 
        paramInt1 *= 2;
        setMeasuredDimension(paramInt2, paramInt1);
        paramInt1 = 0;
        if (paramInt1 >= m) {
          return;
        }
        localView = getChildAt(paramInt1);
        if (paramInt1 != m - 1) {}
        break;
      }
      break;
    }
    for (paramInt2 = View.MeasureSpec.makeMeasureSpec(this.f * 2, -2147483648);; paramInt2 = View.MeasureSpec.makeMeasureSpec(this.f, 1073741824))
    {
      localView.measure(paramInt2, paramInt2);
      paramInt1 += 1;
      break label116;
      paramInt2 = this.f + paramInt1;
      break;
      paramInt2 = paramInt1 * 2;
      break;
      paramInt2 = this.f + paramInt1;
      break;
      paramInt1 = this.f + paramInt1;
      break label108;
      paramInt1 *= 2;
      break label108;
      if (this.l == 1)
      {
        paramInt1 = (m - 1) * paramInt1 + this.f;
        break label108;
      }
      paramInt1 = this.f + paramInt1;
      break label108;
    }
  }
  
  public void setMode(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1))
    {
      this.l = 0;
      return;
    }
    this.l = paramInt;
  }
  
  public void setOnExpandedItemSelectListener(ExpandableEntranceLayout.OnExpandedItemSelectListener paramOnExpandedItemSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnExpandedItemSelectListener = paramOnExpandedItemSelectListener;
  }
  
  public void setOnToggleListener(ExpandableEntranceLayout.OnToggleListener paramOnToggleListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout$OnToggleListener = paramOnToggleListener;
  }
  
  public void setRootContentDescription(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ExpandableEntranceLayout
 * JD-Core Version:    0.7.0.1
 */