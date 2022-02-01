package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import egr;
import egt;
import egu;
import egv;
import egw;
import egx;
import egz;
import ehb;
import ehd;
import ehe;
import ehf;
import ehg;
import ehh;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 300;
  private static final long jdField_a_of_type_Long = 500L;
  private static final String jdField_a_of_type_JavaLangString = "编辑";
  private static final String jdField_b_of_type_JavaLangString = "完成";
  private LebaListMgrAdapter jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter;
  protected RedTouchObserver a;
  public DownloadIconsListener a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new egx(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public boolean a;
  private boolean jdField_b_of_type_Boolean;
  
  public LebaListMgrActivity()
  {
    this.b = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver = new egz(this);
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new ehb(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130903935, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = new LebaListMgrAdapter(this.app, this, LebaShowListManager.a().a(), this);
    }
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter);
    setTitle(2131366563);
    this.rightViewText.setText("编辑");
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    this.rightViewText.setContentDescription("编辑 按钮");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + LebaShowListManager.a().jdField_a_of_type_Boolean);
    }
    this.app.n();
    if (!LebaShowListManager.a().jdField_a_of_type_Boolean) {
      ThreadManager.b(new egr(this));
    }
  }
  
  private void b()
  {
    this.b = true;
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof LebaListMgrAdapter.ViewHolder)))
      {
        localObject = (LebaListMgrAdapter.ViewHolder)localObject;
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -(this.mDensity * 35.0F), 0.0F, 0.0F);
        localTranslateAnimation.setDuration(300L);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(180L);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localTranslateAnimation.setAnimationListener(new egt(this, (LebaListMgrAdapter.ViewHolder)localObject));
        ((LebaListMgrAdapter.ViewHolder)localObject).b.startAnimation(localAnimationSet);
        localTranslateAnimation = new TranslateAnimation(0.0F, -(this.mDensity * 35.0F), 0.0F, 0.0F);
        localTranslateAnimation.setDuration(300L);
        localTranslateAnimation.setAnimationListener(new egu(this, (LebaListMgrAdapter.ViewHolder)localObject));
        ((LebaListMgrAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.startAnimation(localTranslateAnimation);
        localTranslateAnimation = new TranslateAnimation(0.0F, -(this.mDensity * 35.0F), 0.0F, 0.0F);
        localTranslateAnimation.setDuration(300L);
        localTranslateAnimation.setAnimationListener(new egv(this, (LebaListMgrAdapter.ViewHolder)localObject));
        ((LebaListMgrAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.startAnimation(localTranslateAnimation);
        localTranslateAnimation = new TranslateAnimation(24.0F * this.mDensity, 0.0F, 0.0F, 0.0F);
        localTranslateAnimation.setDuration(300L);
        localTranslateAnimation.setFillAfter(true);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setStartOffset(60L);
        localAlphaAnimation.setDuration(240L);
        localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setFillAfter(true);
        ((LebaListMgrAdapter.ViewHolder)localObject).c.startAnimation(localAnimationSet);
        if (i == j - 1) {
          this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new egw(this), 300L);
        }
      }
      i += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LebaShowListManager.d |= 0x1;
    a();
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver, true);
    paramBundle = this.app.a();
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = null;
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver);
    LebaHelper localLebaHelper = this.app.a();
    if (localLebaHelper != null) {
      localLebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    sendBroadcast(new Intent("leba_list_refresh"));
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject4;
    if (paramView == this.rightViewText)
    {
      this.rightViewText.setClickable(false);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      localObject1 = this.rightViewText.getText().toString();
      if ("编辑".equals(localObject1))
      {
        this.b = false;
        i = 0;
        while (i < j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
          if ((localObject1 != null) && ((localObject1 instanceof LebaListMgrAdapter.ViewHolder)))
          {
            localObject1 = (LebaListMgrAdapter.ViewHolder)localObject1;
            localObject2 = new TranslateAnimation(-(35.0F * this.mDensity), 0.0F, 0.0F, 0.0F);
            ((TranslateAnimation)localObject2).setDuration(300L);
            localObject3 = new AlphaAnimation(0.0F, 1.0F);
            ((AlphaAnimation)localObject3).setStartOffset(120L);
            ((AlphaAnimation)localObject3).setDuration(180L);
            localObject4 = new AnimationSet(true);
            ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
            ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
            ((LebaListMgrAdapter.ViewHolder)localObject1).b.setVisibility(0);
            ((TranslateAnimation)localObject2).setAnimationListener(new ehd(this, (LebaListMgrAdapter.ViewHolder)localObject1));
            ((LebaListMgrAdapter.ViewHolder)localObject1).b.startAnimation((Animation)localObject4);
            localObject2 = new TranslateAnimation(0.0F, 35.0F * this.mDensity, 0.0F, 0.0F);
            ((TranslateAnimation)localObject2).setDuration(300L);
            ((TranslateAnimation)localObject2).setAnimationListener(new ehe(this, (LebaListMgrAdapter.ViewHolder)localObject1));
            ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
            localObject2 = new TranslateAnimation(0.0F, 35.0F * this.mDensity, 0.0F, 0.0F);
            ((TranslateAnimation)localObject2).setDuration(300L);
            ((TranslateAnimation)localObject2).setAnimationListener(new ehf(this, (LebaListMgrAdapter.ViewHolder)localObject1));
            ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject2);
            localObject2 = new TranslateAnimation(0.0F, 24.0F * this.mDensity, 0.0F, 0.0F);
            ((TranslateAnimation)localObject2).setDuration(300L);
            localObject3 = new AlphaAnimation(1.0F, 0.0F);
            ((AlphaAnimation)localObject3).setDuration(240L);
            localObject4 = new AnimationSet(true);
            ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
            ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
            ((AnimationSet)localObject4).setFillAfter(true);
            ((LebaListMgrAdapter.ViewHolder)localObject1).c.startAnimation((Animation)localObject4);
            if (i == j - 1) {
              paramView.postDelayed(new ehg(this), 300L);
            }
          }
          i += 1;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004D9A", "0X8004D9A", 0, 0, "", "", "", "");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!"完成".equals(localObject1));
        b();
        ReportController.b(this.app, "CliOper", "", "", "0X8004D9B", "0X8004D9B", 0, 0, "", "", "", "");
        return;
      } while (!this.b);
      this.b = false;
      paramView.postDelayed(new ehh(this), 500L);
      localObject2 = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
    } while ((localObject2 == null) || (((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem == null) || (((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a == null));
    int i = ((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.sResSubType;
    Object localObject1 = ((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strGotoUrl;
    Object localObject3 = ((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResName;
    if (i == 0)
    {
      paramView = (View)localObject1;
      if (((String)localObject1).indexOf("plg_auth=1") > -1) {
        paramView = (String)localObject1 + "&sid=" + this.app.getSid();
      }
      localObject1 = paramView;
      if (paramView.indexOf("plg_uin=1") > -1) {
        localObject1 = paramView + "&mqquin=" + this.app.a();
      }
      paramView = (View)localObject1;
      if (((String)localObject1).indexOf("plg_vkey=1") > -1) {
        paramView = (String)localObject1 + "&mqqvkey=" + this.app.e();
      }
      localObject1 = new Intent(this, QQBrowserActivity.class);
      if (paramView.indexOf("plg_nld=1") > -1) {
        ((Intent)localObject1).putExtra("reportNld", true);
      }
      ((Intent)localObject1).putExtra("uin", this.app.a());
      ((Intent)localObject1).putExtra("vkey", this.app.d());
      ((Intent)localObject1).putExtra("plugin_start_time", System.nanoTime());
      ((Intent)localObject1).putExtra("click_start_time", System.currentTimeMillis());
      startActivity(((Intent)localObject1).putExtra("url", paramView).putExtra("title", (String)localObject3));
    }
    do
    {
      do
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004D99", "0X8004D99", 0, 0, "" + ((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.uiResId, "", "", "");
        return;
      } while (i != 2);
      localObject3 = JumpParser.a(this.app, this, (String)localObject1);
    } while (localObject3 == null);
    if ((((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) || (((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResName.contains(this.app.a().getResources().getString(2131367584)))) {
      ((JumpAction)localObject3).c("platformId=qq_m");
    }
    ((JumpAction)localObject3).b(((LebaListMgrAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strPkgName);
    paramView = ((JumpAction)localObject3).a("cmp");
    localObject1 = ((JumpAction)localObject3).a("pkg");
    if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (paramView.equalsIgnoreCase("com.tencent.gamecenter.activities.GameCenterActivity")) && (((String)localObject1).equalsIgnoreCase("com.tencent.minihd.qq")))
    {
      i = 1;
      label1088:
      if (i != 0)
      {
        localObject1 = ((JumpAction)localObject3).a("url");
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = "https://gamecenter.qq.com/gamecenter/index/index.html";
        }
        localObject4 = paramView.trim();
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (QRUtils.d((String)localObject4)))
        {
          localObject1 = null;
          paramView = null;
          if (this.app != null)
          {
            localObject1 = this.app.getSid();
            paramView = this.app.a();
          }
          localObject1 = "plat=qq&tt=1&sid=" + (String)localObject1 + "&qappid=" + AppSetting.a + "&osv=" + Build.VERSION.RELEASE + "&_bid=" + 278 + "&_wv=" + 5127;
          if (TextUtils.isEmpty(paramView)) {
            break label1325;
          }
        }
      }
    }
    label1325:
    for (paramView = (String)localObject1 + "&uin=" + paramView;; paramView = (View)localObject1)
    {
      ((JumpAction)localObject3).a("url", HtmlOffline.a((String)localObject4, paramView + "&st=" + System.currentTimeMillis()));
      ((JumpAction)localObject3).b();
      break;
      i = 0;
      break label1088;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */