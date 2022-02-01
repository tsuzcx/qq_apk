package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dcv;
import dcw;
import dcy;
import dcz;
import dda;
import ddb;
import ddc;
import dde;
import ddf;
import ddg;
import ddh;
import ddi;
import ddk;
import ddl;
import ddo;
import ddp;
import ddr;
import ddt;
import ddu;
import ddv;
import ddw;
import ddx;
import ddy;
import ddz;
import deb;
import dec;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 9876;
  public static final String a = "IS_ADD_ACCOUNT";
  public static final boolean a = true;
  public static final int b = 5000;
  public static final String b = "is_change_account";
  public static final int c = 999;
  public static final String c = "login_from_account_change";
  public static final int d = 34;
  private static final String jdField_d_of_type_JavaLangString = "AccountManageActivity";
  public static final int e = 250;
  private static final String jdField_e_of_type_JavaLangString = "0X8004001";
  private static final int jdField_f_of_type_Int = 2010;
  private static final String jdField_f_of_type_JavaLangString = "0X8004002";
  private static final String jdField_g_of_type_JavaLangString = "0X8004456";
  private static final String h = "0X8004457";
  public float a;
  long jdField_a_of_type_Long;
  public Dialog a;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ddx(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new dcv(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dcy(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new dcw(this);
  public View a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ddl(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ddp(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new ddo(this);
  public QQCustomDialog a;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public SimpleAccount a;
  public ActionSheet a;
  private dec jdField_a_of_type_Dec = new dec(this);
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new dde(this);
  private float jdField_b_of_type_Float;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new ddy(this);
  SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new dcz(this);
  View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean b;
  private float jdField_c_of_type_Float;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ddv(this);
  private View jdField_c_of_type_AndroidViewView;
  QQCustomDialog jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean c;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new ddw(this);
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new dda(this);
  private boolean jdField_e_of_type_Boolean = false;
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new ddb(this);
  private boolean jdField_f_of_type_Boolean = false;
  private boolean jdField_g_of_type_Boolean;
  private String i;
  
  public AccountManageActivity()
  {
    this.g = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131296569);
    }
    return null;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.i, new deb(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.i);
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131296581);
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = (SubAccountManager)this.app.getManager(59);
    int n = ((SubAccountManager)localObject3).a();
    Object localObject1 = (LinearLayout)findViewById(2131296585);
    int k = 0;
    int m = 0;
    int j;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      j = m;
      if (!this.g)
      {
        j = m;
        if (n == 0)
        {
          if (!DBUtils.a().a()) {
            break label570;
          }
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(5000)) {
            break label545;
          }
          j = m;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (n <= 0) {
          break label575;
        }
        bool = true;
        label114:
        QLog.d("AccountManageActivity", 2, bool);
      }
      k = j;
      if (n == 0)
      {
        ThreadManager.b(new ddu(this));
        k = j;
      }
    }
    if ((k == 0) && (n == 1)) {
      if (DBUtils.a().a(this.app.a())) {
        j = k;
      }
    }
    for (;;)
    {
      label178:
      label221:
      Object localObject4;
      switch (j)
      {
      default: 
        if (((LinearLayout)localObject1).getVisibility() != 8) {
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if (((LinearLayout)localObject1).getVisibility() == 0) {
          ((LinearLayout)localObject1).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        }
        localObject2 = null;
        localObject1 = null;
        if (n == 1)
        {
          localObject4 = ((SubAccountManager)localObject3).a("sub.uin.default");
          localObject2 = localObject1;
          if (localObject4 != null)
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subuin))
            {
              localObject1 = ((SubAccountInfo)localObject4).subname;
              localObject3 = ContactUtils.c(this.app, ((SubAccountInfo)localObject4).subuin, true);
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subname))
                {
                  localObject2 = localObject1;
                  if (((String)localObject3).equals(((SubAccountInfo)localObject4).subname)) {}
                }
                else
                {
                  ((SubAccountInfo)localObject4).subname = ((String)localObject3);
                  localObject2 = localObject3;
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (localObject4 != null) {
              localObject1 = ((SubAccountInfo)localObject4).subuin;
            }
          }
          label382:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.a()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.g).append(" account2BindedNum=").append(n).append(" final action=").append(j).append(" sAccountName=");
            if (((String)localObject2).length() != 0) {
              break label949;
            }
            localObject1 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject2);
        return;
        label545:
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          j = m;
          if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
            break;
          }
        }
        j = 2;
        break;
        label570:
        j = 1;
        break;
        label575:
        bool = false;
        break label114;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 4)) {
          break label1029;
        }
        j = 3;
        break label178;
        DBUtils.a().a(true);
        e();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((LinearLayout)localObject1).getVisibility() == 8) {
          break label221;
        }
        ((LinearLayout)localObject1).setVisibility(8);
        break label221;
        ReportController.a(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((LinearLayout)localObject1).setTag("0X8004001");
        localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131296587);
        localObject4 = getString(2131368733);
        ((TextView)localObject2).setText((CharSequence)localObject4);
        ((LinearLayout)localObject1).setContentDescription((String)localObject4 + "触摸两次进入");
        if (((LinearLayout)localObject1).getVisibility() != 0) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
        ((LinearLayout)localObject1).setVisibility(8);
        e();
        break label221;
        ((LinearLayout)localObject1).setTag("0X8004456");
        localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131296587);
        localObject4 = getString(2131368734);
        ((TextView)localObject2).setText((CharSequence)localObject4);
        ((LinearLayout)localObject1).setContentDescription((String)localObject4 + "触摸两次进入");
        if (((LinearLayout)localObject1).getVisibility() != 0)
        {
          ReportController.a(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((LinearLayout)localObject1).setVisibility(0);
        }
        if (((LinearLayout)localObject1).getVisibility() != 0) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
        ((LinearLayout)localObject1).setVisibility(8);
        e();
        break label221;
        localObject1 = localObject2;
        if (n <= 1) {
          break label382;
        }
        localObject1 = n + "个";
        break label382;
        label949:
        if ((((String)localObject2).length() == 1) || (((String)localObject2).length() == 2)) {
          localObject1 = localObject2;
        } else if (((String)localObject2).length() > 2) {
          localObject1 = ((String)localObject2).substring(0, 2) + "|" + ((String)localObject2).length();
        } else {
          localObject1 = localObject2;
        }
      }
      label1029:
      j = k;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        if (this.app == null) {
          break label319;
        }
        localObject1 = (FriendManager)this.app.getManager(8);
        if (localObject1 == null) {
          break label319;
        }
        localObject1 = ((FriendManager)localObject1).a(this.app.a());
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
        localObject2 = localObject3;
        continue;
        FriendProfileCardActivity.jdField_a_of_type_Long = 30L;
        continue;
        if (((Card)localObject2).lLoginDays < FriendProfileCardActivity.jdField_a_of_type_Long) {
          continue;
        }
        localObject2 = String.format(getString(2131367928), new Object[] { Integer.valueOf((int)((Card)localObject2).lLoginDays) });
        continue;
        localObject2 = String.format(getString(2131367929), new Object[0]);
        continue;
        localObject2 = String.format(getString(2131367929), new Object[0]);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, getString(2131367923), (String)localObject2, getString(2131365736), getString(2131367926), this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      if (localObject1 != null) {
        if (((Card)localObject1).lQQMasterLogindays > 0L)
        {
          FriendProfileCardActivity.jdField_a_of_type_Long = ((Card)localObject1).lQQMasterLogindays;
          if ((((Card)localObject1).lLoginDays != 1L) && ((((Card)localObject1).lLoginDays <= 1L) || (((Card)localObject1).lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long))) {
            continue;
          }
          localObject1 = String.format(getString(2131367927), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.jdField_a_of_type_Long - ((Card)localObject1).lLoginDays)) });
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
      }
      label319:
      Object localObject2 = null;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903050);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296606)).setText(getString(2131366673));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      List localList = getAppRuntime().getApplication().getAllAccounts();
      if (localList != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(localList);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      m();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(j) == null)
      {
        localView = getLayoutInflater().inflate(2130903044, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296578));
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        j += 1;
        break;
        localView = getLayoutInflater().inflate(2130903045, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if (j == 0) {}
        localView.setTag(Integer.valueOf(j));
        ((ImageView)localView.findViewById(2131296551)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((Button)localView.findViewById(2131296570)).setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localView.findViewById(2131296580)).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    n();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int j;
    label28:
    View localView;
    int k;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        j = 0;
        if (j >= m) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject1 = localView.getTag();
      } while (localObject1 == null);
      k = ((Integer)localObject1).intValue();
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    } while (localSimpleAccount == null);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131296584);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131296551);
    TextView localTextView1 = (TextView)localView.findViewById(2131296582);
    TextView localTextView2 = (TextView)localView.findViewById(2131296583);
    localImageView2.clearAnimation();
    label191:
    Object localObject3;
    if ((localSimpleAccount.getUin() != null) && (localSimpleAccount.getUin().length() > 0) && (localSimpleAccount.getUin().equals(this.app.a())) && (!this.jdField_b_of_type_Boolean))
    {
      localImageView2.setVisibility(0);
      localObject3 = ContactUtils.g(this.app, localSimpleAccount.getUin());
      localObject1 = (SubAccountManager)this.app.getManager(59);
      if (localObject1 == null) {
        break label509;
      }
    }
    Object localObject2;
    label480:
    label509:
    for (Object localObject1 = ((SubAccountManager)localObject1).a(localSimpleAccount.getUin());; localObject2 = null)
    {
      try
      {
        if (((!localSimpleAccount.isLogined()) && ((localObject1 == null) || (((SubAccountInfo)localObject1).subuin == null) || (!((SubAccountInfo)localObject1).subuin.equalsIgnoreCase(localSimpleAccount.getUin())))) || ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(localSimpleAccount.getUin())))) {
          continue;
        }
        localObject1 = ((FriendManager)this.app.getManager(8)).a(localSimpleAccount.getUin());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
          continue;
          if (localImageView2.getVisibility() == 0) {}
          for (k = 1;; k = 0)
          {
            if (k == 0) {
              break label480;
            }
            localView.setContentDescription((String)localObject3 + "已登录");
            break;
          }
          localView.setContentDescription((String)localObject3 + "未登录");
        }
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = localSimpleAccount.getUin();
      }
      localTextView1.setText((CharSequence)localObject3);
      if (this.jdField_b_of_type_Boolean)
      {
        localView.setContentDescription((CharSequence)localObject3);
        localTextView2.setText(this.app.b(localSimpleAccount.getUin()));
        localObject1 = this.app.b(localSimpleAccount.getUin());
        if (localObject1 != null) {
          localImageView1.setBackgroundDrawable((Drawable)localObject1);
        }
        j += 1;
        break label28;
        break;
        localImageView2.setVisibility(8);
        break label191;
      }
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.app.a());
    startActivityForResult(localIntent, 9876);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onlogout");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    startActivity(localIntent);
    finish();
  }
  
  private void q()
  {
    if (("com.tencent.minihd.qq".equals(BaseApplicationImpl.processName)) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a())) && ((getActivity() instanceof SettingMe))) {
      startUnlockActivity();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968581);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968582);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  public long a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online) {}
    do
    {
      return 11L;
      if (paramStatus == AppRuntime.Status.invisiable) {
        return 41L;
      }
    } while (paramStatus != AppRuntime.Status.away);
    return 31L;
  }
  
  public void a()
  {
    r();
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131367082);
    localTextView.setOnClickListener(new ddi(this));
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2130903209, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131367064);
    this.rightHighLView.setOnClickListener(new ddr(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296589));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296592));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296288));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    a(this.app.a());
    this.jdField_c_of_type_AndroidViewView = findViewById(2131296599);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new ddt(this));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296591));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setFocusable(false);
    findViewById(2131296590).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    k();
    localObject = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float - 110.0F * this.mDensity);
    localTextView.setContentDescription("编辑按钮");
    this.rightHighLView.setContentDescription("完成");
    this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131367923));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2131230747);
      int j = 0;
      while (j < arrayOfString.length)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[j], 1);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_Dec.a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_Dec);
      localObject = getString(2131365957).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject).getUin();
    String str2 = this.app.a();
    this.i = str1;
    if (str1.equals(str2))
    {
      getAppRuntime().logout(true);
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.i, paramBoolean);
    HistoryChatMsgSearchKeyUtil.a(str1);
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(59);
    if ((localSubAccountManager != null) && (localSubAccountManager.a(str1)))
    {
      SubAccountControll.a(this.app, (byte)0, str1);
      localSubAccountManager.e(str1);
      localSubAccountManager.a(str1, null, true);
      localSubAccountManager.a(str1, 2);
      SubAccountControll.a(this.app, str1, 7);
      int j = 1 - this.app.a().a(str1, 7000);
      if (j != 0) {
        this.app.a().b(str1, 7000, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "deleteAccount() hint need to verify,msg num=1, subUin=" + str1);
      }
    }
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (((SimpleAccount)localObject).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject).getUin(), "delAccount");
        }
      }
    }
    new Thread(new ddc(this, paramBoolean, str1, paramInt)).start();
  }
  
  public void a(long paramLong)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.offline;
    if (paramLong == 11L) {
      localStatus = AppRuntime.Status.online;
    }
    for (;;)
    {
      a(localStatus);
      return;
      if (paramLong == 41L) {
        localStatus = AppRuntime.Status.invisiable;
      } else if (paramLong == 31L) {
        localStatus = AppRuntime.Status.away;
      }
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", 1);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    BadgeUtils.a(paramQQAppInterface.a(), 0);
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
    int j = QQSettingUtil.a(paramActivity, paramQQAppInterface.a());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.a(), j + 1);
    startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    finish();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new ddz(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097), Utils.a(this, 18.5F), Utils.a(this, 13.0F));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131366176) + getString(2131369333));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131366178) + getString(2131369334));
    }
    do
    {
      return;
      if (paramStatus == AppRuntime.Status.invisiable)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097), Utils.a(this, 18.5F), Utils.a(this, 13.0F));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131366176) + getString(2131369334));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131366178) + getString(2131369333));
        return;
      }
    } while (paramStatus != AppRuntime.Status.away);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label28:
    View localView;
    if (j < k)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      if (localView.getTag() != null) {
        break label106;
      }
      if (!paramBoolean) {
        break label80;
      }
      localView.setOnClickListener(null);
      localView.setBackground(null);
      localView.setEnabled(false);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      label80:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130838103);
      localView.setEnabled(true);
      continue;
      label106:
      ImageView localImageView = (ImageView)localView.findViewById(2131296584);
      TextView localTextView = (TextView)localView.findViewById(2131296582);
      if (j == 0)
      {
        if (paramBoolean)
        {
          localView.setOnClickListener(null);
          localView.setBackgroundDrawable(null);
          localImageView.setImageResource(2130842097);
        }
        else
        {
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setBackgroundResource(2130838103);
          localImageView.setImageResource(2130842098);
        }
      }
      else if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localView.setBackground(null);
        localImageView.setImageResource(2130842097);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setBackgroundResource(2130838103);
        localImageView.setImageResource(2130842098);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label28:
    Object localObject2;
    if (j < k)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    ImageView localImageView1;
    ImageView localImageView2;
    RelativeLayout localRelativeLayout;
    ImageView localImageView3;
    for (;;)
    {
      j += 1;
      break label28;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131296584);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131296551);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131296581);
      localImageView3 = (ImageView)((View)localObject2).findViewById(2131296580);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131296579);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label246;
      }
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130968577, 5);
      }
      localImageView3.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localImageView3.setImageResource(2130841636);
      a(localImageView3, 2130968578, 4);
      a((View)localObject2, 2130968578, 4);
      a(localImageView2, 2130968582, 0);
      a(localRelativeLayout, 2130968582, 0);
    }
    label246:
    localImageView3.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int m = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.a()))) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2130968578, 4);
      }
      a(localImageView3, 2130968577, 5);
      a((View)localObject2, 2130968577, 5);
      a(localImageView2, 2130968581, 1);
      a(localRelativeLayout, 2130968581, 1);
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int j;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        j = 0;
        if (j >= k) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int m = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131296584);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.a())) && (!this.jdField_b_of_type_Boolean)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  void d()
  {
    String str = this.app.getSid();
    int j = this.app.a();
    str = "https://fwd.3g.qq.com:8080/forward.jsp?bid=589&sid=" + str + "&currAppid=" + String.valueOf(j);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", getString(2131367936));
    localIntent.putExtra("uin", this.app.a());
    startActivity(localIntent.putExtra("url", str));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2010) {}
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 1000))
      {
        l();
        return;
      }
    } while ((paramInt2 != -1) || (paramInt1 != 9876));
    l();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903046);
    setTitle(2131369101);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a();
    l();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.a(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    e();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b(false);
    n();
    h();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5000);
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label34:
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
  
  public void f()
  {
    e();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131368649)).setMessage(getString(2131368660));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131368662), new ddf(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131365736), new ddg(this));
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368103);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  void i()
  {
    long l = System.currentTimeMillis();
    String str;
    if (ProfileActivity.a(this.jdField_a_of_type_Long, l))
    {
      this.jdField_a_of_type_Long = l;
      str = ((TicketManager)this.app.getManager(2)).getStweb(this.app.a());
      if ((str != null) && (str.length() != 0)) {
        break label64;
      }
      a(2131368266, 1);
    }
    label64:
    do
    {
      return;
      str = String.format("https://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.app.a(), str, "19", this.app.getSid() });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + str);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    this.app.a(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      n();
    }
    for (;;)
    {
      runOnUiThread(new ddh(this, this.app.a()));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      b(true);
      if (this.app != null)
      {
        this.app.saveLastAccountState();
        this.app.getApplication().refreAccountList();
      }
      TroopNotificationHelper.a();
      QvipSpecialCareManager.a(true);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ddk(this), 500L);
      return;
      l();
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    h();
    this.jdField_e_of_type_Boolean = false;
    o();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */