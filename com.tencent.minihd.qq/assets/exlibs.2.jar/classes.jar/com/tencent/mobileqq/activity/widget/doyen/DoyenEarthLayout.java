package com.tencent.mobileqq.activity.widget.doyen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import hcd;
import hce;
import hcf;
import java.util.Random;

public class DoyenEarthLayout
  extends RelativeLayout
{
  private static final int jdField_a_of_type_Int = 200;
  private static final int jdField_b_of_type_Int = 546;
  private static final int jdField_c_of_type_Int = 819;
  private static final int jdField_d_of_type_Int = 1092;
  private static final int jdField_e_of_type_Int = 1365;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new hcd(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private AnimationSet jdField_c_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private AnimationSet jdField_d_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  
  public DoyenEarthLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DoyenEarthLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DoyenEarthLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Animation a()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968618);
    localAnimation.setDuration(new Random().nextInt(1000) + 1000);
    return localAnimation;
  }
  
  private AnimationSet a(Context paramContext)
  {
    return (AnimationSet)AnimationUtils.loadAnimation(paramContext, 2130968616);
  }
  
  private void a()
  {
    if (this.m != null)
    {
      this.m.clearAnimation();
      this.m.setVisibility(4);
    }
    if (this.l != null)
    {
      this.l.clearAnimation();
      this.l.setVisibility(4);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2130903282, this);
    this.jdField_f_of_type_Int = getResources().getDimensionPixelSize(2131493486);
  }
  
  private void a(View[] paramArrayOfView)
  {
    int i1 = paramArrayOfView.length;
    int n = 0;
    while (n < i1)
    {
      paramArrayOfView[n].setVisibility(4);
      n += 1;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131297550));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.l = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297551));
      this.m = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297298));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297547));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297548));
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.0F);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297543));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297544));
      this.e = ((ImageView)findViewById(2131297545));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297546));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.l.clearAnimation();
    this.m.clearAnimation();
    d();
    this.l.setVisibility(4);
    this.m.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838262);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = a(getContext());
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = a(getContext());
    this.jdField_c_of_type_AndroidViewAnimationAnimationSet = a(getContext());
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet = a(getContext());
    h();
    invalidate();
    c();
    g();
  }
  
  private void b(View[] paramArrayOfView)
  {
    int i1 = paramArrayOfView.length;
    int n = 0;
    while (n < i1)
    {
      paramArrayOfView[n].startAnimation(a());
      n += 1;
    }
  }
  
  private void c()
  {
    this.l.setVisibility(0);
    this.l.setImageResource(2130838292);
    if ((this.l.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)this.l.getDrawable()).start();
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968620);
    localAnimation.setAnimationListener(new hce(this));
    this.l.startAnimation(localAnimation);
  }
  
  private void c(View[] paramArrayOfView)
  {
    int i1 = paramArrayOfView.length;
    int n = 0;
    while (n < i1)
    {
      View localView = paramArrayOfView[n];
      localView.clearAnimation();
      localView.setVisibility(4);
      n += 1;
    }
  }
  
  private void d()
  {
    if (this.h != null)
    {
      this.h.clearAnimation();
      this.h.setVisibility(4);
    }
    if (this.g != null)
    {
      this.g.clearAnimation();
      this.g.setVisibility(4);
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidViewViewStub == null)
    {
      this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131297549));
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewStub.inflate();
      this.h = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297552));
      this.g = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297556));
      this.i = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297553));
      this.j = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297554));
      this.k = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297555));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297547));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297548));
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297543));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297544));
      this.e = ((ImageView)findViewById(2131297545));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297546));
    }
    this.h.clearAnimation();
    this.g.clearAnimation();
    this.i.clearAnimation();
    this.j.clearAnimation();
    this.k.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    a();
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.i;
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.j;
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = this.k;
    this.g.setVisibility(4);
    this.h.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838262);
    this.h.setImageResource(2130838284);
    a(this.jdField_a_of_type_ArrayOfAndroidViewView);
    f();
    h();
  }
  
  private void f()
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968617);
    this.g.setVisibility(0);
    this.g.startAnimation(localAnimation1);
    this.h.setImageResource(2130838287);
    if ((this.h.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)this.h.getDrawable()).start();
    }
    Animation localAnimation2 = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968619);
    this.h.startAnimation(localAnimation2);
    localAnimation1.setAnimationListener(new hcf(this));
  }
  
  private void g()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(546, 400L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(819, 600L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1092, 800L);
  }
  
  private void h()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_d_of_type_AndroidWidgetImageView.clearAnimation();
    this.e.clearAnimation();
    this.jdField_f_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.e.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b();
      return;
    }
    e();
  }
  
  public void setEarthCoverAlpha(float paramFloat)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.doyen.DoyenEarthLayout
 * JD-Core Version:    0.7.0.1
 */