package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import deq;
import der;
import des;
import det;
import deu;
import dev;
import dew;
import dex;
import java.util.ArrayList;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "k_uin_type";
  public static final int b = 2;
  public static String b;
  public static final int c = 3;
  public static final String c = "stat_option";
  public static final int d = 4;
  private static final String d = "last_activity";
  private static final int jdField_e_of_type_Int = 0;
  private static final int jdField_f_of_type_Int = 1;
  public DialogInterface.OnClickListener a;
  public DialogInterface.OnDismissListener a;
  public Handler a;
  protected OpenIdObserver a;
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private dex jdField_a_of_type_Dex;
  public boolean a;
  public DialogInterface.OnClickListener b;
  private QQCustomDialog b;
  private String jdField_e_of_type_JavaLangString;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private int h;
  private int i;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new des(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new det(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new deu(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new dew(this);
  }
  
  public static Intent a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(paramActivity, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static Intent a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(paramActivity, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    paramActivity = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramActivity = AutoRemarkActivity.a(paramString3);
    }
    localIntent.putExtra("nick_name", paramActivity);
    paramActivity = paramString4;
    if (paramString4 != null)
    {
      paramActivity = paramString4;
      if (paramString4.length() > 30) {
        paramActivity = paramString4.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramActivity);
    localIntent.putExtra("param_return_addr", paramString5);
    localIntent.putExtra("last_activity", paramString6);
    localIntent.putExtra("src_name", paramString7);
    return localIntent;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString4 = new Intent(paramContext, AddFriendLogicActivity.class);
    paramString4.putExtra("uin", paramString1);
    paramString4.putExtra("k_uin_type", paramInt1);
    paramString4.putExtra("extra", paramString2);
    paramString4.putExtra("source_id", paramInt2);
    paramString4.putExtra("sub_source_id", paramInt3);
    paramContext = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext = AutoRemarkActivity.a(paramString3);
    }
    paramString4.putExtra("nick_name", paramContext);
    paramString4.putExtra("last_activity", paramString6);
    return paramString4;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramContext = new Intent(paramContext, AddFriendLogicActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("k_uin_type", 4);
    paramContext.putExtra("group_option", paramShort);
    paramContext.putExtra("troop_question", paramString3);
    paramContext.putExtra("troop_answer", paramString4);
    paramContext.putExtra("nick_name", paramString2);
    paramContext.putExtra("stat_option", paramInt);
    paramContext.putExtra("param_return_addr", paramString5);
    paramContext.putExtra("last_activity", paramString6);
    return paramContext;
  }
  
  private boolean a()
  {
    Object localObject1 = getIntent();
    this.h = ((Intent)localObject1).getIntExtra("source_id", 10004);
    this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.jdField_g_of_type_Int, this.f)) {
      return false;
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.h == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
    {
      localObject1 = this.app.a().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).a(TroopMemberInfo.class, new String[] { this.jdField_g_of_type_JavaLangString, this.f });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).a();
    }
    this.jdField_a_of_type_Dex = new dex(this, null);
    addObserver(this.jdField_a_of_type_Dex);
    if (this.jdField_g_of_type_Int == 1) {
      ((FriendListHandler)this.app.a(1)).a("OidbSvc.0x476_147", Long.parseLong(this.f), 147);
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        c();
      } else {
        b();
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      finish();
      return false;
    case 1: 
      if (paramString.equals(this.app.a()))
      {
        QQToast.a(this, 2131366963, 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      try
      {
        Long.parseLong(paramString);
        if (((FriendManager)this.app.getManager(8)).b(paramString))
        {
          QQToast.a(this.app.getApplication(), 2131366964, 0).b(getTitleBarHeight());
          finish();
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
    case 2: 
      if (this.h == 10004)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.h = 3006;
      }
      break;
    }
    while (!NetworkUtil.e(this))
    {
      QQToast.a(this.app.getApplication(), 2131367328, 0).b(getTitleBarHeight());
      finish();
      return false;
      if (this.h == 10004)
      {
        this.h = 3016;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "openId source id is default!");
        }
      }
    }
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    ((FriendListHandler)this.app.a(1)).a(this.f, this.h, this.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366968);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new deq(this));
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private boolean b()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int j = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((FriendManager)this.app.getManager(8)).a(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131366966, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    if (j == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131365760);
      }
      QQToast.a(this.app.getApplication(), 2131366967, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("friend_setting", 9);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    startActivityForResult((Intent)localObject, 1);
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    OpenID localOpenID;
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      localOpenID = this.app.a().a(this.jdField_g_of_type_JavaLangString);
      if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366968);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new der(this), 3000L);
        this.app.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
        this.app.a().d(this.jdField_g_of_type_JavaLangString);
      }
    }
    else
    {
      return;
    }
    if (!jdField_b_of_type_JavaLangString.equals(localOpenID.openID))
    {
      a();
      return;
    }
    b();
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.i != 0))
    {
      localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.i);
      if (localObject1 == null) {
        break label479;
      }
    }
    label209:
    label479:
    for (Object localObject1 = ((Bundle)localObject1).getString("AlertTitle");; localObject1 = null)
    {
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.i);
      if (localObject2 != null) {}
      for (Object localObject3 = ((Bundle)localObject2).getString("AlertText");; localObject3 = null)
      {
        localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.i);
        if (localObject2 != null) {}
        for (localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");; localObject2 = null)
        {
          Object localObject4 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.i);
          if (localObject4 != null) {}
          for (localObject4 = ((Bundle)localObject4).getString("AlertRightBtnText");; localObject4 = null)
          {
            Object localObject5 = localObject1;
            int j;
            if (localObject1 == null)
            {
              if (this.i == 1)
              {
                j = 2131365714;
                localObject5 = getString(j);
              }
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                if (this.i != 1) {
                  break label333;
                }
                localObject1 = getString(2131365716);
              }
              if (localObject2 != null) {
                break label405;
              }
              if (this.i != 1) {
                break label393;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject3 = localObject2;
              label229:
              if (localObject4 != null) {
                break label440;
              }
              if (this.i != 1) {
                break label429;
              }
              localObject2 = getString(2131365720);
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject3, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
              if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
                this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131297379).setVisibility(8);
              }
              return;
              j = 2131365715;
              break;
              if (this.i == 2)
              {
                localObject1 = getString(2131365717);
                break label209;
              }
              if (this.i == 3)
              {
                localObject1 = getString(2131365718);
                break label209;
              }
              localObject1 = localObject3;
              if (this.i != 4) {
                break label209;
              }
              localObject1 = getString(2131365719);
              break label209;
              localObject3 = getString(2131365721);
              break label229;
              localObject3 = localObject2;
              if (!TextUtils.isEmpty(((String)localObject2).trim())) {
                break label229;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject3 = localObject2;
              break label229;
              localObject2 = getString(2131365722);
              continue;
              if (TextUtils.isEmpty(((String)localObject4).trim())) {
                this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
              }
              localObject2 = localObject4;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131363611);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131363691);
    dev localdev = new dev(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131365736, localdev);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131363612, localdev);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList, Class paramClass)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = new View(this);
    paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramBundle.setBackgroundResource(2130837687);
    setContentView(paramBundle);
    paramBundle = getIntent();
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.f = paramBundle.getStringExtra("uin");
    this.e = paramBundle.getStringExtra("last_activity");
    if ((this.f == null) || (this.f.length() < 5)) {
      return false;
    }
    if (this.jdField_g_of_type_Int == 4) {
      return b();
    }
    return a();
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_Dex != null) {
      removeObserver(this.jdField_a_of_type_Dex);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected String setLastActivityName()
  {
    if (this.e != null) {
      return this.e;
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */