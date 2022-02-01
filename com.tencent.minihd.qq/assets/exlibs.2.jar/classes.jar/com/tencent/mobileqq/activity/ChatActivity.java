package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyAssistantChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ChatActivity
  extends BaseActivity
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  protected BaseChatPie a;
  private AIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.z();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.x();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u();
    }
  }
  
  private boolean a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      if (!this.app.isLogin())
      {
        this.jdField_a_of_type_Boolean = true;
        paramIntent = new Intent();
        paramIntent.setClass(this, LoginActivity.class);
        paramIntent.addFlags(262144);
        super.startActivity(paramIntent);
        finish();
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (b(paramIntent)) {
            break label175;
          }
          this.jdField_a_of_type_Boolean = true;
          finish();
          return true;
          if (!isFinishing()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("qqBaseActivity", 2, "onNewIntent isFinishing");
        return true;
        if (!ThridAppShareHelper.a().a(paramIntent, this, this.app)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("qqBaseActivity", 2, "onNewIntent ThridApp to chatactivity");
      return true;
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle == null) || (!localBundle.getBoolean("back_from_emojimall", false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
    return true;
    if (!b(paramIntent))
    {
      finish();
      return true;
    }
    label175:
    return false;
  }
  
  private void b()
  {
    int i = -1;
    if (this.b)
    {
      long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
      if (getIntent() != null) {
        i = getIntent().getIntExtra("uintype", -1);
      }
      if (QLog.isColorLevel())
      {
        String str2 = getIntent().getStringExtra("KEY_FROM");
        String str1 = str2;
        if (str2 == null)
        {
          ComponentName localComponentName = getCallingActivity();
          str1 = str2;
          if (localComponentName != null) {
            str1 = localComponentName.getClassName();
          }
        }
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + l + ",from:" + str1);
      }
      PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
      PerformanceReportUtils.a(this, this.app.a(), i, l);
      this.b = false;
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "AIOTime doOnWindowFocusChanged end Cost " + l + " AIOType: " + i);
      }
    }
  }
  
  private boolean b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("uintype", -1);
    if (str == null) {
      return false;
    }
    if (i == -1)
    {
      QQToast.a(this, getString(2131365964), 0).b(getTitleBarHeight());
      return false;
    }
    if (paramIntent.hasExtra("account"))
    {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
      if (!((FriendManager)this.app.getManager(8)).b(str))
      {
        paramIntent.removeExtra("account");
        paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
        paramIntent.setClassName(this, ShortcutRouterActivity.class.getName());
        super.startActivity(paramIntent);
        return false;
      }
    }
    if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((FriendManager)this.app.getManager(8)).b(str)))
    {
      QQToast.a(getApplicationContext(), getString(2131365780), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.D();
    }
    switch (paramIntent.getIntExtra("chat_subType", 0))
    {
    case 2: 
    default: 
      switch (paramIntent.getIntExtra("uintype", -1))
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "AIOTime getChatPie no Type at default");
        }
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BaseChatPie(this.app, this);
      }
      break;
    }
    for (;;)
    {
      bool = true;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return bool;
                        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)));
                        a();
                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BusinessCmrTmpChatPie(this.app, this);
                        return true;
                      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof MultiForwardChatPie)));
                      a();
                      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new MultiForwardChatPie(this.app, this);
                      return true;
                    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof FriendChatPie)) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)));
                    a();
                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new FriendChatPie(this.app, this);
                    break;
                  } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)));
                  a();
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new TroopChatPie(this.app, this);
                  break;
                } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie)));
                a();
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new DiscussChatPie(this.app, this);
                break;
              } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)));
              a();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BusinessCmrTmpChatPie(this.app, this);
              break;
            } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)));
            a();
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new PublicAccountChatPie(this.app, this);
            break;
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DeviceMsgChatPie)));
          a();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new DeviceMsgChatPie(this.app, this);
          break;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof NearbyAssistantChatPie)));
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new NearbyAssistantChatPie(this.app, this);
        break;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof StrangerChatPie)));
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new StrangerChatPie(this.app, this);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localIntent);
    }
    return false;
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramIntent);
    }
    return super.dataEquals(paramIntent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 7) && (paramInt2 == 888)) || ((paramInt1 == 6) && (paramInt2 == -1))) {
      doOnNewIntent(paramIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    BaseChatItemLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    StartupTracker.a(null, "AIO_Start_cost");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter = new AIOTimeReporter();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(0);
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.b = true;
    ThreadPriorityManager.a(true);
    StartupTracker.a(null, "AIO_Super_doOnCreate");
    super.doOnCreate(paramBundle);
    StartupTracker.a("AIO_Super_doOnCreate", "AIO_doOnCreate_BeforeEnterCost");
    if (a(true, super.getIntent())) {
      return false;
    }
    StartupTracker.a("AIO_doOnCreate_BeforeEnterCost", "AIO_doOnCreate");
    StartupTracker.a(null, "AIO_doOnCreate_uiCost");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    super.setContentView(2130903136);
    super.getWindow().setFeatureInt(7, 2130903224);
    super.getWindow().setBackgroundDrawable(null);
    setTitleBackground(2);
    BaseChatItemLayout.a(this);
    StartupTracker.a("AIO_doOnCreate_uiCost", "AIO_doOnCreate_getPieCost");
    a(super.getIntent());
    StartupTracker.a("AIO_doOnCreate_getPieCost", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(true);
    StartupTracker.a("AIO_doOnCreate", null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    StartupTracker.a(null, "AIO_Super_doOnDestroy");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u();
    }
    super.doOnDestroy();
    StartupTracker.a("AIO_Super_doOnDestroy", "AIO_doOnDestroy");
    if (this.jdField_a_of_type_Boolean)
    {
      StartupTracker.a("AIO_doOnDestroy", null);
      return;
    }
    StartupTracker.a("AIO_doOnDestroy", null);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_Super_doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    StartupTracker.a("AIO_Super_doOnNewIntent", null);
    if (a(false, paramIntent)) {
      return;
    }
    StartupTracker.a(null, "AIO_doOnNewIntent");
    super.setIntent(paramIntent);
    if (a(paramIntent))
    {
      super.setContentView(2130903136);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.y();
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnNewIntent", null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i(paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    StartupTracker.a(null, "AIO_Super_doOnPause");
    super.doOnPause();
    StartupTracker.a("AIO_Super_doOnPause", "AIO_doOnPause");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.A();
    }
    StartupTracker.a("AIO_doOnPause", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a();
    }
  }
  
  protected void doOnResume()
  {
    StartupTracker.a(null, "AIO_Super_doOnResume");
    super.doOnResume();
    StartupTracker.a("AIO_Super_doOnResume", "AIO_doOnResume");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C();
    }
    StartupTracker.a("AIO_doOnResume", "AIO_onDrawView");
  }
  
  protected void doOnStart()
  {
    StartupTracker.a(null, "AIO_Super_doOnStart");
    super.doOnStart();
    StartupTracker.a("AIO_Super_doOnStart", "AIO_doOnStart");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.y();
    }
    StartupTracker.a("AIO_doOnStart", null);
  }
  
  protected void doOnStop()
  {
    StartupTracker.a(null, "AIO_Super_doOnStop");
    super.doOnStop();
    StartupTracker.a("AIO_Super_doOnStop", "AIO_doOnStop");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.z();
    }
    StartupTracker.a("AIO_doOnStop", null);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      StartupTracker.a(null, "AIO_onWindowFocusChanged");
      b();
      StartupTracker.a("AIO_onDrawView", null);
      StartupTracker.a("AIO_Start_cost", "AIO_SysMsgCost");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a(1);
      }
      StartupTracker.a("AIO_onWindowFocusChanged", null);
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.x();
    }
    super.finish();
  }
  
  protected String getPreProcess()
  {
    return "com.tencent.minihd.qq:peak";
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.app);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d();
    }
    return super.onBackEvent();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt);
    }
    return null;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
    getWindow().setFormat(-3);
  }
  
  protected void setLefBtnBackground()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) && (((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).k())) {
      return;
    }
    super.setLefBtnBackground();
  }
  
  public boolean showPreview()
  {
    SetSplash.a(this);
    getWindow().setFeatureInt(7, 2130903222);
    try
    {
      this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131297386).getParent());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivity
 * JD-Core Version:    0.7.0.1
 */