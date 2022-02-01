package com.tencent.biz.troopbar;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import cog;
import coh;
import coi;
import coj;
import cok;
import col;
import com;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import coo;
import coq;
import cor;
import cos;
import cot;
import cou;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class TroopBarDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 0;
  public static final String d = "need_finish";
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  float jdField_a_of_type_Float;
  public int a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public PublicAccountHandler a;
  public QQAppInterface a;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  public String a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public boolean a;
  public int b;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  NewIntent jdField_b_of_type_MqqAppNewIntent;
  BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  boolean jdField_b_of_type_Boolean = true;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  NewIntent jdField_c_of_type_MqqAppNewIntent;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public boolean c;
  BusinessObserver jdField_d_of_type_MqqObserverBusinessObserver;
  public boolean d;
  public String e;
  public boolean e;
  protected String f;
  public boolean f;
  public boolean g = false;
  boolean h = false;
  private boolean i = false;
  
  public TroopBarDetailActivity()
  {
    this.jdField_a_of_type_JavaLangString = "com.tencent.biz.pubaccount.TroopBarDetailActivity";
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Int = 1008;
    this.jdField_b_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createGroupLayout exit");
    }
    return localLinearLayout;
  }
  
  private String a()
  {
    Intent localIntent = super.getIntent();
    String str = null;
    if (localIntent != null) {
      str = localIntent.getStringExtra("uin");
    }
    return str;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initView");
    }
    super.setContentView(2130903614);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296532));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296551));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296555));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296554));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296730));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296563));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296545));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131296544);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130840484, 0, 0, 0);
    super.setTitle(2131363604);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296549));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296557));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296565));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.rightViewText.setText("");
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838104);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setContentDescription(getResources().getString(2131363855));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initView exit");
    }
  }
  
  private void a(ViewGroup paramViewGroup, mobileqq_mp.ConfigInfo paramConfigInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addDetailItem");
    }
    Object localObject1 = super.getLayoutInflater();
    int j = (int)(10.0F * this.jdField_a_of_type_Float);
    int k = (int)(15.0F * this.jdField_a_of_type_Float);
    if (paramConfigInfo.type.get() == 3)
    {
      if (paramConfigInfo.event_id.get() == 3) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
    Object localObject2;
    label118:
    Object localObject3;
    if (paramConfigInfo.type.get() == 1)
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2130903352, null);
      ((View)localObject1).setOnClickListener(new cou(this, paramConfigInfo.url.get()));
      localObject2 = null;
      ((TextView)((View)localObject1).findViewById(2131297001)).setText(paramConfigInfo.title.get());
      switch (paramInt)
      {
      default: 
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, j, 0, j);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setBackgroundResource(2130838151);
        label210:
        if (paramConfigInfo.state_id.get() == 5)
        {
          paramViewGroup.addView((View)localObject2);
          if (paramConfigInfo.state_id.get() == 5)
          {
            localObject2 = getString(2131363642);
            if (paramConfigInfo.state.get() == 1)
            {
              paramViewGroup = getString(2131367642);
              ((View)localObject1).setContentDescription(String.format((String)localObject2, new Object[] { paramViewGroup }));
            }
          }
          else
          {
            if (paramConfigInfo.type.get() != 4) {
              break label739;
            }
            ((View)localObject1).setPadding(k, k, k, k);
          }
        }
        label266:
        label284:
        break;
      }
    }
    while (QLog.isColorLevel())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addDetailItem exit");
      return;
      if (paramConfigInfo.type.get() == 2)
      {
        label384:
        label414:
        AccountDetail localAccountDetail;
        if (paramConfigInfo.state_id.get() == 5)
        {
          localObject2 = ((LayoutInflater)localObject1).inflate(2130904468, null);
          localObject1 = ((View)localObject2).findViewById(2131302286);
          ((TextView)((View)localObject2).findViewById(2131302287)).setVisibility(0);
          localObject3 = (Switch)((View)localObject1).findViewById(2131297410);
          if (paramConfigInfo.state.get() != 1) {
            break label506;
          }
          ((Switch)localObject3).setChecked(true);
          if (paramConfigInfo.state_id.get() == 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs = true;
            localAccountDetail = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
            if (paramConfigInfo.state.get() != 1) {
              break label515;
            }
          }
        }
        label515:
        for (boolean bool = true;; bool = false)
        {
          localAccountDetail.isAgreeSyncLbs = bool;
          a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          ((Switch)localObject3).setOnCheckedChangeListener(new coh(this, paramConfigInfo, (Switch)localObject3, (View)localObject1));
          break;
          localObject1 = ((LayoutInflater)localObject1).inflate(2130904468, null);
          localObject2 = null;
          break label384;
          label506:
          ((Switch)localObject3).setChecked(false);
          break label414;
        }
      }
      if (paramConfigInfo.type.get() == 4)
      {
        localObject1 = ((LayoutInflater)localObject1).inflate(2130903261, null);
        ((TextView)((View)localObject1).findViewById(2131296744)).setText(paramConfigInfo.content.get());
        localObject2 = null;
        break label118;
      }
      localObject1 = ((LayoutInflater)localObject1).inflate(2130903261, null);
      localObject2 = null;
      break label118;
      localObject3 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, j, 0, j);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((View)localObject1).setBackgroundResource(2130838151);
      break label210;
      localObject3 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, j, 0, 0);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((View)localObject1).setBackgroundResource(2130838156);
      break label210;
      localObject3 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, 0, j);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((View)localObject1).setBackgroundResource(2130838153);
      break label210;
      ((View)localObject1).setBackgroundResource(2130838155);
      break label210;
      paramViewGroup = getString(2131367671);
      break label266;
      paramViewGroup.addView((View)localObject1);
      break label284;
      label739:
      ((View)localObject1).setPadding(k, j, k, j);
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveCache");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        localEntityManager.a(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveCache exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      localEntityManager.a(paramAccountDetail);
    }
  }
  
  private void a(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup");
    }
    ViewGroup localViewGroup = a();
    paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
    int m = paramConfigGroupInfo.size();
    int k = 0;
    if (k < m)
    {
      int j;
      if (m > 1) {
        if (k == 0) {
          j = 1;
        }
      }
      for (;;)
      {
        a(localViewGroup, (mobileqq_mp.ConfigInfo)paramConfigGroupInfo.get(k), j);
        if (k != m - 1) {}
        k += 1;
        break;
        if (k == m - 1)
        {
          j = 2;
        }
        else
        {
          j = 3;
          continue;
          if (m > 2)
          {
            if (paramInt1 == 1) {
              j = 1;
            } else if (paramInt1 == paramInt2 - 1) {
              j = 2;
            } else {
              j = 3;
            }
          }
          else {
            j = 0;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup exit");
    }
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    int j;
    if (paramConfigInfo.state.has())
    {
      j = paramConfigInfo.state.get();
      if (j != 1) {
        break label43;
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = false;
      paramSwitch.setChecked(bool);
      return;
      j = 0;
      break;
      label43:
      bool = false;
    }
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    b(2131363614);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    int k = paramConfigInfo.state_id.get();
    if (paramBoolean) {}
    for (int j = 1;; j = 2)
    {
      localSetFunctionFlagRequset.type.set(k);
      localSetFunctionFlagRequset.value.set(j);
      localSetFunctionFlagRequset.account_type.set(1);
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      this.jdField_d_of_type_MqqObserverBusinessObserver = new cos(this, paramConfigInfo, paramSwitch, j, k, paramBoolean);
      localNewIntent.setObserver(this.jdField_d_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      this.jdField_b_of_type_Int += 1;
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    paramString = paramString.replace("${puin}", this.jdField_b_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).replace("${sid}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("puin", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localIntent.putExtra("source_name", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    }
    super.startActivity(localIntent);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, Class paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(this, paramClass));
    paramClass = new Bundle();
    paramClass.putString("uin", paramString1);
    paramClass.putInt("uintype", paramInt);
    paramClass.putString("uinname", paramString2);
    localIntent.putExtras(paramClass);
    boolean bool = super.getIntent().getBooleanExtra("need_finish", false);
    if (this.jdField_c_of_type_Boolean)
    {
      localIntent.putExtra("forward_type", -1);
      localIntent.putExtra("forward_text", this.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
    }
    if (bool) {
      super.finish();
    }
    super.startActivity(localIntent);
  }
  
  private boolean a()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = ((AccountDetail)localEntityManager.a(AccountDetail.class, this.jdField_b_of_type_JavaLangString));
    localEntityManager.a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData);
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.groupInfoList = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.config_group_info.get();
      label85:
      return true;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("url", "https://find.qq.com/m/new/index.html?_wv=1026&_bid=320&_tab=1");
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("hide_operation_bar", true);
    super.finish();
    super.startActivity(localIntent);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cog(this, paramInt), 500L);
  }
  
  private void b(AccountDetail paramAccountDetail)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b(paramAccountDetail);
    localEntityManager.a();
  }
  
  private void b(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    this.g = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    if (paramConfigInfo.confirm_tips.has()) {}
    for (String str = paramConfigInfo.confirm_tips.get();; str = "")
    {
      localQQCustomDialog.setTitle("温馨提示");
      localQQCustomDialog.setMessage(str);
      paramConfigInfo = new cot(this, paramConfigInfo, paramSwitch, paramBoolean);
      localQQCustomDialog.setNegativeButton("取消", paramConfigInfo);
      localQQCustomDialog.setPositiveButton("确定", paramConfigInfo);
      try
      {
        localQQCustomDialog.show();
        return;
      }
      catch (Exception paramConfigInfo) {}
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    this.jdField_b_of_type_JavaLangString = a();
    Intent localIntent = getIntent();
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("extvalue");
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      if (!"2".equals(this.jdField_f_of_type_JavaLangString)) {
        break label99;
      }
      this.jdField_c_of_type_Boolean = true;
    }
    label99:
    do
    {
      while (this.jdField_b_of_type_JavaLangString == null)
      {
        return;
        if ("1".equals(this.jdField_f_of_type_JavaLangString)) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10));
      a();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "init exit");
  }
  
  private void c(int paramInt) {}
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update");
    }
    a(paramAccountDetail);
    if (this.jdField_a_of_type_Boolean)
    {
      l();
      m();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update exit");
      }
      return;
      l();
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow");
    }
    b(2131363615);
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    this.jdField_c_of_type_MqqObserverBusinessObserver = new col(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    this.jdField_b_of_type_Int += 1;
    PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow exit");
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow");
    }
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new com(this), 3000L);
    b(2131363616);
    this.jdField_b_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_d_of_type_Boolean)) {
      localFollowRequest.ext.set(this.jdField_e_of_type_JavaLangString);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new coo(this);
    this.jdField_b_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_b_of_type_MqqAppNewIntent);
    this.jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
    }
  }
  
  private void f()
  {
    Resources localResources;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      localResources = super.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        break label139;
      }
    }
    label139:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name)
    {
      str = String.format(localResources.getString(2131363609, new Object[] { str }), new Object[0]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363605, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new coq(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new cor(this));
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.i = false;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initData");
    }
    boolean bool;
    if (!a())
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label72;
      }
      c(2131363614);
      n();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initData exit");
      }
      return;
      bool = false;
      break;
      label72:
      l();
      o();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.displayNumber != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.displayNumber.length() > 0))
    {
      this.jdField_c_of_type_JavaLangString = String.format(super.getResources().getString(2131363603), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.displayNumber });
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    }
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new coi(this);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    i();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363605);
      this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131558814);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131363602);
    this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131558814);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.groupInfoList != null)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.groupInfoList.size();
      int j = 0;
      while (j < k)
      {
        a((mobileqq_mp.ConfigGroupInfo)this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.groupInfoList.get(j), j, k);
        j += 1;
      }
    }
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse != null) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.has()) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.get() == 2)) {
      k();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView exit");
      }
      return;
      h();
      j();
    }
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "firstFetch");
    }
    o();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "firstFetch exit");
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendDetailInfoRequest");
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
        label116:
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new coj(this);
        this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        this.jdField_b_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendDetailInfoRequest exit");
        }
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return super.dispatchTouchEvent(paramMotionEvent);
      } while (!this.jdField_f_of_type_Boolean);
      this.h = true;
      return true;
    } while (!this.h);
    this.h = false;
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetButton) {
      b();
    }
    do
    {
      do
      {
        return;
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
            e();
          }
          for (;;)
          {
            i();
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cok(this), 1000L);
            return;
            f();
          }
        }
        if (paramView != this.rightViewImg) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null);
      ShareMsgHelper.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_c_of_type_JavaLangString, "https://s.p.qq.com/pub/get_face?img_type=3&uin=" + this.jdField_b_of_type_JavaLangString, "https://s.p.qq.com/mpmobile/card/index.html?puin=" + this.jdField_b_of_type_JavaLangString, ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
      return;
    } while (paramView != this.jdField_a_of_type_AndroidViewView);
    if (ChatActivity.class.getName().endsWith(this.fromActivity))
    {
      finish();
      return;
    }
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_b_of_type_MqqAppNewIntent != null) {
      this.jdField_b_of_type_MqqAppNewIntent.setObserver(null);
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.g)) {
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.troopbar.TroopBarDetailActivity
 * JD-Core Version:    0.7.0.1
 */