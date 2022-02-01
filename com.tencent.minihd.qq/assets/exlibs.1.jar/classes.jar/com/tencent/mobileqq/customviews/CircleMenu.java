package com.tencent.mobileqq.customviews;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.widget.UnaffectedFrameLayout;
import hye;
import hyf;
import hyg;
import hyh;
import hyi;
import hyj;
import hyk;
import hym;
import hyn;
import hyo;
import hyp;
import hyq;
import hyr;
import hys;
import hyt;

public class CircleMenu
{
  static int jdField_b_of_type_Int = -1;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private CircleMenu.MenuParams jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams;
  public boolean a;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public CircleMenu(CircleMenu.MenuParams paramMenuParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams = paramMenuParams;
    if (paramMenuParams.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidContentContext = paramMenuParams.jdField_a_of_type_AndroidViewViewGroup.getContext();
    }
    SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.d = a(32);
    this.jdField_c_of_type_Int = a(12);
    h();
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup.getHeight() - this.jdField_a_of_type_AndroidWidgetFrameLayout.getTop();
      if (i > 0) {
        jdField_b_of_type_Int = i;
      }
    }
    return jdField_b_of_type_Int;
  }
  
  private void h()
  {
    Object localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    ((ImageView)localObject2).setImageResource(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_Int);
    Object localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
    ((FrameLayout)localObject1).setBackgroundResource(2130838048);
    ((FrameLayout)localObject1).setPadding(0, 0, 0, a(4));
    Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject3).gravity = 17;
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if ((this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewView$OnClickListener != null) || ((this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfJavaLangCharSequence == null) && (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfInt == null)))
    {
      ((FrameLayout)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.d;
      localLayoutParams.rightMargin = this.d;
      localObject3 = new UnaffectedFrameLayout(this.jdField_a_of_type_AndroidContentContext);
      ((UnaffectedFrameLayout)localObject3).addView((View)localObject1, localLayoutParams);
      if (!(localObject2 instanceof FrameLayout)) {
        break label232;
      }
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      ((ViewGroup)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      return;
      ((FrameLayout)localObject1).setOnClickListener(new hye(this));
      break;
      label232:
      if ((localObject2 instanceof RelativeLayout)) {
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      } else {
        localObject1 = new ViewGroup.MarginLayoutParams(-1, -1);
      }
    }
  }
  
  private void i()
  {
    SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfJavaLangCharSequence != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfJavaLangCharSequence.length;
    }
    for (;;)
    {
      if (i == 0)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfInt != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfInt.length;
        }
      }
      else
      {
        FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        localFrameLayout.setOnTouchListener(new hym(this));
        Object localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
        ((View)localObject1).setBackgroundColor(Color.parseColor("#E5FFFFFF"));
        localFrameLayout.addView((View)localObject1);
        localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        ((LinearLayout)localObject1).setOrientation(1);
        ((LinearLayout)localObject1).setOnTouchListener(new hyn(this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
        int j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903172, null);
            TextView localTextView = (TextView)((View)localObject2).findViewById(2131297215);
            Object localObject3 = (ImageView)((View)localObject2).findViewById(2131297216);
            if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfJavaLangCharSequence != null) {
              localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfJavaLangCharSequence[j]);
            }
            try
            {
              label217:
              if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null) {
                ((ImageView)localObject3).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[j]);
              }
              for (;;)
              {
                label241:
                ((ImageView)localObject3).setOnClickListener(new hyo(this, j));
                localObject3 = new LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = this.jdField_c_of_type_Int;
                ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
                j += 1;
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfInt == null) {
                  break label217;
                }
                localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_ArrayOfInt[j]);
                break label217;
                if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.b != null) {
                  ((ImageView)localObject3).setImageResource(this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.b[j]);
                }
              }
            }
            catch (Exception localException)
            {
              break label241;
            }
          }
        }
        Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 85;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = (this.d + this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight());
        ((FrameLayout.LayoutParams)localObject2).rightMargin = this.d;
        localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidViewView = localFrameLayout;
        return;
      }
      i = 0;
    }
  }
  
  private void j()
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1;
    int i = j;
    while (i >= 0)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localView.setTag(Integer.valueOf((j - i) * 20));
      localView.setAlpha(0.0F);
      localView.setTranslationY(a(20));
      localView = localView.findViewById(2131297216);
      localView.setScaleX(0.0F);
      localView.setScaleY(0.0F);
      i -= 1;
    }
  }
  
  private void k()
  {
    j();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      int j = ((Integer)((View)localObject).getTag()).intValue();
      localValueAnimator.addUpdateListener(new hyt(this, (View)localObject));
      localValueAnimator.setDuration(250L);
      localValueAnimator.setInterpolator(new DecelerateInterpolator(4.0F));
      localValueAnimator.setStartDelay(j);
      localValueAnimator.start();
      i += 1;
    }
    Object localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).addUpdateListener(new hyf(this));
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator(4.0F));
    ((ValueAnimator)localObject).addListener(new hyg(this));
    ((ValueAnimator)localObject).start();
  }
  
  private void l()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new hyh(this));
    localValueAnimator.setDuration(250L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addListener(new hyi(this));
    localValueAnimator.start();
  }
  
  public int a(int paramInt)
  {
    return (int)(this.jdField_a_of_type_Float * paramInt + 0.5F);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    c(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
      }
      if (!this.jdField_a_of_type_AndroidWidgetFrameLayout.isShown())
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        if ((paramBoolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(250L);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new hyp(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new hyq(this));
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    b(true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.isShown())
      {
        if (!paramBoolean) {
          break label119;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(250L);
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new hyr(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new hys(this));
          this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
        }
      }
    }
    return;
    label119:
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void c()
  {
    c(true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      i();
    }
    if ((a()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      return;
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup;
      int i = localViewGroup.indexOfChild((View)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent());
      localViewGroup.addView(this.jdField_a_of_type_AndroidViewView, i);
    } while (!paramBoolean);
    k();
  }
  
  public void d()
  {
    d(true);
  }
  
  public void d(boolean paramBoolean)
  {
    if ((a()) && (!this.jdField_c_of_type_Boolean))
    {
      if (paramBoolean) {
        l();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsCircleMenu$MenuParams = null;
  }
  
  public void f()
  {
    int i = a();
    if (i <= 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(i);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationY", new float[] { i, 0.0F });
    localObjectAnimator.setDuration(150L);
    localObjectAnimator.setStartDelay(200L);
    localObjectAnimator.addListener(new hyj(this));
    localObjectAnimator.start();
  }
  
  public void g()
  {
    int i = a();
    if (i <= 0) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationY", new float[] { 0.0F, i });
    localObjectAnimator.setDuration(150L);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
    localObjectAnimator.addListener(new hyk(this));
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.CircleMenu
 * JD-Core Version:    0.7.0.1
 */