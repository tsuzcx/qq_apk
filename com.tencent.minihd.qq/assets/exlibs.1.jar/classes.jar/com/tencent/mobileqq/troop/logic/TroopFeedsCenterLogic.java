package com.tencent.mobileqq.troop.logic;

import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kle;
import klf;
import klg;

public class TroopFeedsCenterLogic
  implements Observer
{
  protected static final int b = 250;
  protected int a;
  private Animation.AnimationListener a;
  public TranslateAnimation a;
  protected ImageView a;
  protected RelativeLayout a;
  public SessionInfo a;
  protected BaseActivity a;
  public QQAppInterface a;
  public TroopAioTips a;
  protected TroopFeedsDataManager a;
  public TroopAioFeedsCenterView a;
  protected String a;
  protected boolean a;
  public TranslateAnimation b;
  public ImageView b;
  protected RelativeLayout b;
  public boolean b;
  public boolean c = false;
  protected boolean d = false;
  protected boolean e = false;
  public boolean f = false;
  public boolean g = false;
  
  public TroopFeedsCenterLogic(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, TroopAioTips paramTroopAioTips, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new kle(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
    this.g = paramBoolean;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131493332);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = ((TroopInfoManager)paramQQAppInterface.getManager(36)).a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!a()) {}
    }
    while ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null))
    {
      return;
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297388));
      int i = AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      int j = AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841952);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.addRule(7, 2131297390);
      localLayoutParams.addRule(6, 2131297390);
      localLayoutParams.setMargins(0, j, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a()
  {
    if (a())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_fold", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363490));
      b();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363492));
    b(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      Interpolator localInterpolator = AnimationUtils.loadInterpolator(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 17432582);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int * -1);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(localInterpolator);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    if (!this.f) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Boolean))
    {
      this.c = true;
      c(false);
      TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
      this.jdField_a_of_type_JavaLangString = "1";
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = true;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        localObject = AnimationUtils.loadInterpolator(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 17432582);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Int * -1, 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillEnabled(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null) {
        break label373;
      }
      Object localObject = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView = new TroopAioFeedsCenterView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((TroopGagMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setFlingGestureListener(new klf(this));
      localObject = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView, (ViewGroup.LayoutParams)localObject);
      this.c = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      if (this.c) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.a();
      }
    }
    for (;;)
    {
      if (!this.c)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() > 0))
        {
          if (!paramBoolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            return;
            this.jdField_a_of_type_JavaLangString = "0";
            break;
            label373:
            if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.getVisibility() == 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setVisibility(4);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
            if (!this.c) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.a();
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", this.jdField_a_of_type_JavaLangString, "");
          return;
        }
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
    }
    this.e = true;
  }
  
  public void c()
  {
    d(false);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c = true;
      if (!a())
      {
        this.jdField_a_of_type_Boolean = true;
        d(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363491));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    d(false);
    this.jdField_b_of_type_Boolean = false;
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363492));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363490));
  }
  
  public void d()
  {
    this.c = true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() != 102) {
        break label27;
      }
      this.c = true;
    }
    for (;;)
    {
      return;
      label27:
      if (paramObservable.intValue() == 104)
      {
        this.c = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new klg(this));
        return;
      }
      if ((paramObservable.intValue() == 101) || (paramObservable.intValue() == 103))
      {
        if (this.e)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() <= 0)) {
            break label200;
          }
          if (this.d) {
            break label163;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
        }
        while (paramObservable.intValue() == 103)
        {
          this.c = true;
          return;
          label163:
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          continue;
          label200:
          if (!this.d) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          } else {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic
 * JD-Core Version:    0.7.0.1
 */