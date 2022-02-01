package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.util.file.FileUtil;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CacheManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import eun;
import euo;
import eup;
import eur;
import eut;
import euv;
import java.io.File;
import java.util.Vector;
import mqq.app.MobileQQ;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int a = 0;
  public static final String a = "https://imgcache.qq.com/club/client/msgRoam/rel/index.html?_wv=5123&ADTAG=msgRoam";
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 1000;
  static final int jdField_d_of_type_Int = 0;
  static final int jdField_e_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new euo(this);
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new euv(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  public QQProgressDialog a;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new eup(this);
  private View jdField_b_of_type_AndroidViewView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_b_of_type_JavaLangString = "";
  private DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new eur(this);
  private View jdField_c_of_type_AndroidViewView;
  private DialogInterface.OnClickListener jdField_d_of_type_AndroidContentDialogInterface$OnClickListener = new eut(this);
  private View jdField_d_of_type_AndroidViewView;
  private View jdField_e_of_type_AndroidViewView;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public QQSettingMsgHistoryActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new eun(this);
  }
  
  private void a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(this, 230, getResources().getString(paramInt1), getResources().getString(paramInt2), getResources().getString(2131365736), getResources().getString(2131365737), paramOnClickListener1, paramOnClickListener2).show();
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length)
        {
          boolean bool = paramString[i].delete();
          if (QLog.isColorLevel())
          {
            QLog.d("AvatarUtil", 2, "path: " + paramString[i].getAbsolutePath());
            QLog.d("AvatarUtil", 2, "ret : " + bool);
          }
          i += 1;
        }
      }
    }
  }
  
  private void g()
  {
    int i = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), 0);
    Object localObject = null;
    switch (i)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        }
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131366505);
      break;
      localObject = getResources().getString(2131366504);
      break;
      localObject = getResources().getString(2131366503);
      break;
      localObject = getResources().getString(2131366502);
      break;
    }
    QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + i);
  }
  
  private void h()
  {
    if (URLDrawableHelper.a != null)
    {
      b(URLDrawableHelper.a.getAbsolutePath());
      Object localObject = this.app.a();
      if ((localObject instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl localBaseApplicationImpl = (BaseApplicationImpl)localObject;
        if (BaseApplicationImpl.a != null)
        {
          localObject = (BaseApplicationImpl)localObject;
          BaseApplicationImpl.a.evictAll();
        }
      }
    }
  }
  
  private void i()
  {
    b(AppConstants.aG + this.jdField_b_of_type_JavaLangString + "/" + "ptt/");
  }
  
  private void j()
  {
    try
    {
      this.app.a().f();
      this.app.a().g();
      this.app.a().h();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.app.a().g();
    a(true);
    i();
    e();
    j();
    h();
    b();
    Handler localHandler = this.app.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1009);
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(AppConstants.aG + this.jdField_b_of_type_JavaLangString + "/" + "photo/");
    }
    int i = 0;
    while (i < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      b(CardHandler.jdField_a_of_type_JavaLangString + ((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(CardHandler.jdField_a_of_type_JavaLangString + "background" + "/");
    b(AppConstants.aG + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(AppConstants.bV);
    b(CardHandler.jdField_a_of_type_JavaLangString + "voice" + "/");
    b(GCCommon.a() + "/");
  }
  
  void b()
  {
    ((NewFriendManager)this.app.getManager(33)).i();
  }
  
  public void c()
  {
    try
    {
      Object localObject = new Intent("qqplayer_exit_action");
      ((Intent)localObject).putExtra("musicplayer.isDelFileOnDonwloadThreadOver", true);
      sendBroadcast((Intent)localObject);
      QZoneHelper.a(this, this.app.a());
      a(false);
      d();
      e();
      h();
      MusicCacheManager.a();
      QfavHelper.a(this, this.app.a());
      PublicAccountJavascriptInterface.deleteAllH5Data(this.app);
      FileUtil.a(new File(PublicAccountJavascriptInterface.d + "/" + HexUtil.b(this.app.getAccount())));
      FileUtil.a(new File(AppConstants.aE + "/" + "tencent/MobileQQ/qbiz/"));
      localObject = CacheManager.getCacheFileBaseDir();
      if (localObject != null) {
        FileUtil.a((File)localObject);
      }
      ShortVideoUtils.a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AssitantSettingActivity", 2, "deleteOfflineData got exception:" + localException.getMessage());
    }
  }
  
  void d()
  {
    if (this.app.a() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    b(Utils.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904017);
    setTitle(2131369117);
    this.jdField_b_of_type_JavaLangString = this.app.a();
    setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300472));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.app.f() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131300475);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131300476);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131300477);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131300478);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300474));
      this.e = findViewById(2131300473);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setFocusable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
      this.e.setOnClickListener(this);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (!JumpQqPimSecureUtil.a(this)) {
        break;
      }
      ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, "", "", "", "");
      return true;
    }
    ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    g();
  }
  
  void e()
  {
    b(AppConstants.aG + "photo/");
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131367328, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (this.app.f() == 1) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    paramCompoundButton = this.app;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "", "", "", "");
      a(getResources().getString(2131368580));
      if (!paramBoolean) {
        break label153;
      }
    }
    label153:
    for (int i = j;; i = 0)
    {
      this.app.g(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131300478) {
      startActivity(new Intent(this, QQSpaceCleanActivity.class));
    }
    long l1;
    long l2;
    do
    {
      return;
      if (paramView.getId() == 2131300473)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://imgcache.qq.com/club/client/msgRoam/rel/index.html?_wv=5123&ADTAG=msgRoam");
        startActivity(paramView);
        return;
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300475: 
      a(2131367911, 2131367932, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return;
    case 2131300476: 
      a(2131367913, 2131367931, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return;
    }
    a(2131367912, 2131369118, this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131366676));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */