package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;

public class NewVoteAnimHelper
  implements Handler.Callback, Animation.AnimationListener
{
  public static final int a = 0;
  static final long jdField_a_of_type_Long = 1000L;
  public static final int b = 1;
  public static final int c = 6;
  public static final int d = 7;
  public static final int e = 3;
  public static final int f = 11;
  static final int g = 0;
  static final int h = 1;
  static final int i = 2;
  static final int j = 3;
  static final int k = 0;
  static final int l = 1;
  static final int m = 2;
  static final int n = 0;
  static final int o = 1;
  static final int p = 2;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public NewVoteAnimHelper.NewVoteHolder a;
  public boolean a;
  private Animation b;
  public boolean b;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  
  public NewVoteAnimHelper(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Double = paramContext.getResources().getDisplayMetrics().density;
    this.s = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder = new NewVoteAnimHelper.NewVoteHolder();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) {
      return;
    }
    if (this.s == 1) {}
    for (RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b.getLayoutParams();; localLayoutParams1 = null)
    {
      String str2;
      String str1;
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        str2 = String.valueOf(this.t);
        str1 = str2;
        if (localLayoutParams1 != null)
        {
          localLayoutParams1.topMargin = 0;
          str1 = str2;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b.setText(str1);
        if (localLayoutParams1 == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b.setLayoutParams(localLayoutParams1);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i1;
      int i2;
      if (paramBoolean2)
      {
        i1 = 2130841953;
        if (this.s == 0) {
          localLayoutParams2.topMargin = ((int)(7.0D * this.jdField_a_of_type_Double));
        }
        for (;;)
        {
          localLayoutParams2.width = ((int)(6.0D * this.jdField_a_of_type_Double + 0.5D));
          localLayoutParams2.height = ((int)(6.0D * this.jdField_a_of_type_Double + 0.5D));
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          str2 = String.valueOf(this.t);
          i2 = i1;
          str1 = str2;
          if (localLayoutParams1 != null)
          {
            localLayoutParams1.topMargin = 0;
            str1 = str2;
            i2 = i1;
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(i2);
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
          break;
          if (this.s == 1)
          {
            localLayoutParams2.topMargin = 0;
            localLayoutParams2.rightMargin = ((int)(3.0D * this.jdField_a_of_type_Double + 0.5D));
          }
        }
      }
      if (this.s == 0)
      {
        i1 = 2130841959;
        localLayoutParams2.topMargin = 0;
      }
      for (;;)
      {
        localLayoutParams2.width = -2;
        localLayoutParams2.height = -2;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.u);
        str2 = String.valueOf(this.t - this.u);
        i2 = i1;
        str1 = str2;
        if (localLayoutParams1 == null) {
          break;
        }
        localLayoutParams1.topMargin = ((int)(11.0D * this.jdField_a_of_type_Double + 0.5D));
        i2 = i1;
        str1 = str2;
        break;
        if (this.s == 1)
        {
          i1 = 2130841956;
          localLayoutParams2.topMargin = 0;
          localLayoutParams2.rightMargin = 0;
        }
        else
        {
          i1 = 2130841956;
        }
      }
    }
  }
  
  public void a()
  {
    DatingUtil.a("voteAnim", new Object[] { "reset" });
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.q = 0;
    this.r = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
      a(false, false, 8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, TextView paramTextView1, TextView paramTextView2)
  {
    if ((paramView == null) || (paramTextView1 == null) || (paramTextView2 == null)) {
      label14:
      return;
    }
    int i2;
    label22:
    int i1;
    if (paramInt1 >= 0)
    {
      i2 = paramInt1;
      if (paramInt2 <= i2) {
        break label264;
      }
      i1 = i2 % 20;
    }
    for (;;)
    {
      label35:
      DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (i1 <= 0) {
        if (this.q != 0) {
          a();
        }
      }
      for (;;)
      {
        DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(this.t), Integer.valueOf(this.u), Integer.valueOf(this.q), Integer.valueOf(i2), Integer.valueOf(i1) });
        this.t = i2;
        this.u = i1;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b = paramTextView2;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView = paramView;
        switch (this.q)
        {
        case 1: 
        default: 
          return;
        case 0: 
          if (this.u <= 0) {
            break label395;
          }
          a(true, false, 4);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1500L);
          this.q = 1;
          this.r = 0;
          return;
          i2 = 0;
          break label22;
          label264:
          if (paramInt2 >= 0) {
            break label404;
          }
          i1 = 0;
          break label35;
          if ((this.t != i2) || (this.u != i1))
          {
            if ((this.q == 1) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a(paramView, paramTextView1, paramTextView2)))
            {
              this.v = paramInt1;
              this.w = paramInt2;
              if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
                break label14;
              }
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
              return;
            }
            a();
            continue;
          }
          if ((this.q == 2) && (this.jdField_b_of_type_Boolean)) {
            this.q = 3;
          }
          break;
        }
      }
      a(true, true, 0);
      return;
      a(true, false, 0);
      return;
      label395:
      a(false, false, 8);
      return;
      label404:
      i1 = paramInt2;
    }
  }
  
  protected void b()
  {
    DatingUtil.a("voteAnim", new Object[] { "finishAnim" });
    this.q = 2;
    this.r = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
      a(true, false, 0);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
    }
  }
  
  public void c()
  {
    DatingUtil.a("voteAnim", new Object[] { "endAnim", Integer.valueOf(this.q), Integer.valueOf(this.r) });
    if (this.q == 1)
    {
      if (this.r == 2) {
        b();
      }
    }
    else {
      return;
    }
    if (this.r == 0)
    {
      a();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if ((this.q == 1) && (this.r == 0) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()))
      {
        this.r = 1;
        if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 1.0F);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
          if (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) {
            break label292;
          }
          this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(400L);
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1100L);
        }
      }
      for (;;)
      {
        DatingUtil.a("voteAnim", new Object[] { "MSG_ANIM_1", Integer.valueOf(this.q), Integer.valueOf(this.r), this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder });
        return false;
        this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
        break;
        this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
        break label202;
        a();
      }
    case 1: 
      label202:
      a(this.v, this.w, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.b);
      label292:
      return false;
    }
    if ((this.q == 1) && (this.r == 1))
    {
      this.r = 2;
      b();
      return false;
    }
    c();
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = false;
    if (paramAnimation == null) {
      break label6;
    }
    label6:
    while ((paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) && (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation)) {
      return;
    }
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) {
        bool2 = true;
      }
      DatingUtil.a("voteAnim", new Object[] { "end", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if ((this.r != 1) || (this.q != 1)) {
        break;
      }
      this.r = 2;
      b();
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((paramAnimation == null) || (!this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a())) {}
    do
    {
      return;
      if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
      {
        DatingUtil.a("voteAnim", new Object[] { "start", "anim1_1" });
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation);
    DatingUtil.a("voteAnim", new Object[] { "start", "anim1_2" });
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NewVoteAnimHelper
 * JD-Core Version:    0.7.0.1
 */