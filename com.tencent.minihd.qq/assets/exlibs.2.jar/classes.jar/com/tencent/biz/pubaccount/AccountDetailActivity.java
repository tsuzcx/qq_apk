package com.tencent.biz.pubaccount;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import chr;
import chs;
import cht;
import chu;
import chv;
import chw;
import chx;
import chy;
import chz;
import cia;
import cib;
import cic;
import cid;
import cie;
import cif;
import cig;
import cih;
import cij;
import cik;
import cil;
import cim;
import cin;
import cio;
import cip;
import cir;
import cis;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class AccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final double jdField_a_of_type_Double = 0.79D;
  private static double jdField_b_of_type_Double = 0.64D;
  private static double jdField_c_of_type_Double = 0.9D;
  static final int jdField_c_of_type_Int = 1;
  public static final String d = "need_finish";
  private static final int h = 0;
  private static final int jdField_i_of_type_Int = 1;
  private static final int jdField_j_of_type_Int = 2;
  private static final int jdField_k_of_type_Int = 3;
  private static int l = 110;
  private static final int m = 50;
  private static final int n = 44;
  private static final int o = 1;
  private static final int p = 2;
  public float a;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new cig(this);
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AccountDetailBounceScrollView a;
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
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet = null;
  public String b;
  NewIntent jdField_b_of_type_MqqAppNewIntent;
  BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  boolean jdField_b_of_type_Boolean = true;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  NewIntent jdField_c_of_type_MqqAppNewIntent;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  public ImageView d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  BusinessObserver jdField_d_of_type_MqqObserverBusinessObserver;
  public boolean d;
  int jdField_e_of_type_Int = 0;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public String e;
  BusinessObserver jdField_e_of_type_MqqObserverBusinessObserver;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  protected String f;
  public boolean f;
  int g;
  public boolean g;
  public boolean h = false;
  boolean jdField_i_of_type_Boolean;
  private boolean jdField_j_of_type_Boolean;
  private boolean jdField_k_of_type_Boolean;
  
  public AccountDetailActivity()
  {
    this.jdField_a_of_type_JavaLangString = "com.tencent.biz.pubaccount.AccountDetailActivity";
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Int = 1008;
    this.jdField_b_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.j = false;
    this.k = false;
    this.i = false;
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
    super.setContentView(2130903041);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296532));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296551));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296552));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296555));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296554));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296563));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296545));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131296544);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130840484, 0, 0, 0);
    super.setTitle(2131363604);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296557));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296565));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initView exit");
    }
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296560);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296561));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131366374));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296562));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296559));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296550));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296558));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296546));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296556));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView = ((AccountDetailBounceScrollView)super.findViewById(2131296548));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOnScrollChangedListener(new chr(this));
  }
  
  private void a(View paramView, mobileqq_mp.ConfigInfo paramConfigInfo, int paramInt)
  {
    IconPopupWindow localIconPopupWindow = new IconPopupWindow(this);
    paramConfigInfo = new cia(this, paramConfigInfo, localIconPopupWindow);
    localIconPopupWindow.a(2131369879, paramConfigInfo);
    localIconPopupWindow.a(2131369880, paramConfigInfo);
    localIconPopupWindow.a(2131369881, paramConfigInfo);
    localIconPopupWindow.a(paramInt - 1);
    localIconPopupWindow.a(paramView, 4);
  }
  
  private void a(ViewGroup paramViewGroup, mobileqq_mp.ConfigInfo paramConfigInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addDetailItem");
    }
    Object localObject2 = super.getLayoutInflater();
    Switch localSwitch = null;
    View localView = null;
    int i1 = (int)(10.0F * this.jdField_a_of_type_Float);
    int i2 = (int)(15.0F * this.jdField_a_of_type_Float);
    Object localObject1;
    if (paramConfigInfo.type.get() == 3)
    {
      if (paramConfigInfo.event_id.get() == 3)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      localObject1 = localSwitch;
      if (paramConfigInfo.event_id.get() == 10)
      {
        localView = ((LayoutInflater)localObject2).inflate(2130904444, null);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297441));
        if (paramConfigInfo.state.get() == 1)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369879);
          label145:
          ((TextView)localView.findViewById(2131297001)).setText(paramConfigInfo.title.get());
          localView.setOnClickListener(new chx(this, paramConfigInfo));
          localObject1 = localSwitch;
        }
      }
      else
      {
        switch (paramInt)
        {
        default: 
          label184:
          localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          localView.setBackgroundResource(2130837509);
          label239:
          if (paramConfigInfo.state_id.get() == 5)
          {
            paramViewGroup.addView((View)localObject1);
            if (paramConfigInfo.state_id.get() == 5)
            {
              localObject1 = getString(2131363642);
              if (paramConfigInfo.state.get() == 1)
              {
                paramViewGroup = getString(2131367642);
                localView.setContentDescription(String.format((String)localObject1, new Object[] { paramViewGroup }));
              }
            }
            else
            {
              if (paramConfigInfo.type.get() != 4) {
                break label944;
              }
              localView.setPadding(i2, i2, i2, i2);
            }
          }
          label295:
          label313:
          break;
        }
      }
    }
    while (QLog.isColorLevel())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addDetailItem exit");
      return;
      if (paramConfigInfo.state.get() == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369880);
        break label145;
      }
      if (paramConfigInfo.state.get() != 3) {
        break label145;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369881);
      break label145;
      if (paramConfigInfo.type.get() == 1)
      {
        localView = ((LayoutInflater)localObject2).inflate(2130903352, null);
        localObject1 = paramConfigInfo.url.get();
        ((TextView)localView.findViewById(2131297001)).setText(paramConfigInfo.title.get());
        if (paramConfigInfo.title.get().contains("历史")) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_b_of_type_JavaLangString, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
        }
        localView.setOnClickListener(new chy(this, (String)localObject1));
        localObject1 = localSwitch;
        break label184;
      }
      if (paramConfigInfo.type.get() == 2)
      {
        if (paramConfigInfo.state_id.get() == 5)
        {
          localObject1 = ((LayoutInflater)localObject2).inflate(2130904468, null);
          localView = ((View)localObject1).findViewById(2131302286);
          ((TextView)((View)localObject1).findViewById(2131302287)).setVisibility(0);
          label588:
          ((TextView)localView.findViewById(2131297001)).setText(paramConfigInfo.title.get());
          localSwitch = (Switch)localView.findViewById(2131297410);
          if (paramConfigInfo.state.get() != 1) {
            break label731;
          }
          localSwitch.setChecked(true);
          label639:
          if (paramConfigInfo.state_id.get() == 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs = true;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
            if (paramConfigInfo.state.get() != 1) {
              break label740;
            }
          }
        }
        label731:
        label740:
        for (boolean bool = true;; bool = false)
        {
          ((AccountDetail)localObject2).isAgreeSyncLbs = bool;
          c(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          localSwitch.setOnCheckedChangeListener(new chz(this, paramConfigInfo, localSwitch, localView));
          break;
          localView = ((LayoutInflater)localObject2).inflate(2130904468, null);
          localObject1 = null;
          break label588;
          localSwitch.setChecked(false);
          break label639;
        }
      }
      if (paramConfigInfo.type.get() == 4)
      {
        localView = ((LayoutInflater)localObject2).inflate(2130903261, null);
        ((TextView)localView.findViewById(2131296744)).setText(paramConfigInfo.content.get());
        ((TextView)localView.findViewById(2131297001)).setText(paramConfigInfo.title.get());
        localObject1 = localSwitch;
        break label184;
      }
      localView = ((LayoutInflater)localObject2).inflate(2130903261, null);
      localObject1 = localSwitch;
      break label184;
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localView.setBackgroundResource(2130837509);
      break label239;
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localView.setBackgroundResource(2130837512);
      break label239;
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localView.setBackgroundResource(2130837510);
      break label239;
      localView.setBackgroundResource(2130837511);
      break label239;
      paramViewGroup = getString(2131367671);
      break label295;
      paramViewGroup.addView(localView);
      break label313;
      label944:
      if (paramConfigInfo.type.get() == 2) {
        localView.setPadding(i2, 0, i2, 0);
      } else {
        localView.setPadding(i2, i1, i2, i1);
      }
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.b().postDelayed(new cil(this, paramAccountDetail), 10L);
  }
  
  private void a(AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    ThreadManager.b().postDelayed(new cih(this, paramAccountDetail, paramBoolean), 10L);
  }
  
  private void a(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup");
    }
    ViewGroup localViewGroup = a();
    paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
    int i3 = paramConfigGroupInfo.size();
    int i2;
    label54:
    int i1;
    if (i3 == 4)
    {
      jdField_b_of_type_Double = 0.55D;
      i2 = 0;
      if (i2 >= i3) {
        break label184;
      }
      if (i3 <= 2) {
        break label142;
      }
      if (i2 != 0) {
        break label121;
      }
      i1 = 1;
    }
    label142:
    for (;;)
    {
      a(localViewGroup, (mobileqq_mp.ConfigInfo)paramConfigGroupInfo.get(i2), i1);
      if (i2 != i3 - 1) {}
      i2 += 1;
      break label54;
      jdField_b_of_type_Double = 0.64D;
      break;
      label121:
      if (i2 == i3 - 2)
      {
        i1 = 2;
      }
      else
      {
        i1 = 3;
        continue;
        if (i3 > 3)
        {
          if (paramInt1 == 1) {
            i1 = 1;
          } else if (paramInt1 == paramInt2 - 1) {
            i1 = 2;
          } else {
            i1 = 3;
          }
        }
        else {
          i1 = 0;
        }
      }
    }
    label184:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup exit");
    }
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo)
  {
    int i1;
    if (paramConfigInfo.state.has())
    {
      i1 = paramConfigInfo.state.get();
      this.jdField_f_of_type_Boolean = false;
      if (i1 != 1) {
        break label44;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369879);
    }
    label44:
    do
    {
      return;
      i1 = 0;
      break;
      if (i1 == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369880);
        return;
      }
    } while (i1 != 3);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369881);
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, int paramInt)
  {
    c(2131363614);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    int i1 = paramConfigInfo.state_id.get();
    localSetFunctionFlagRequset.type.set(i1);
    localSetFunctionFlagRequset.value.set(paramInt);
    localSetFunctionFlagRequset.account_type.set(1);
    localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    this.jdField_e_of_type_MqqObserverBusinessObserver = new cib(this, paramConfigInfo, paramInt, i1, paramInt);
    localNewIntent.setObserver(this.jdField_e_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    this.jdField_b_of_type_Int += 1;
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    int i1;
    if (paramConfigInfo.state.has())
    {
      i1 = paramConfigInfo.state.get();
      if (i1 != 1) {
        break label43;
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      paramSwitch.setChecked(bool);
      return;
      i1 = 0;
      break;
      label43:
      bool = false;
    }
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    c(2131363614);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    int i2 = paramConfigInfo.state_id.get();
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 2)
    {
      localSetFunctionFlagRequset.type.set(i2);
      localSetFunctionFlagRequset.value.set(i1);
      localSetFunctionFlagRequset.account_type.set(1);
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      this.jdField_d_of_type_MqqObserverBusinessObserver = new chu(this, paramConfigInfo, paramSwitch, i1, i2, paramBoolean);
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
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", paramInt);
    localBundle.putString("uinname", paramString2);
    localIntent.putExtras(localBundle);
    boolean bool = super.getIntent().getBooleanExtra("need_finish", false);
    if (this.jdField_d_of_type_Boolean)
    {
      localIntent.putExtra("forward_type", -1);
      localIntent.putExtra("forward_text", this.jdField_e_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = false;
    }
    if (bool) {
      super.finish();
    }
    if (!paramClass.getName().equals(this.fromActivity)) {
      super.startActivity(localIntent);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.b().postDelayed(new chs(this, paramBoolean), 10L);
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
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.config_group_info_new.get();
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
  
  private void b(AccountDetail paramAccountDetail)
  {
    ThreadManager.b().postDelayed(new cin(this, paramAccountDetail), 10L);
  }
  
  private void b(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    this.h = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    if (paramConfigInfo.confirm_tips.has()) {}
    for (String str = paramConfigInfo.confirm_tips.get();; str = "")
    {
      localQQCustomDialog.setTitle("温馨提示");
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.setOnCancelListener(new chv(this, paramConfigInfo, paramSwitch));
      paramConfigInfo = new chw(this, paramConfigInfo, paramSwitch, paramBoolean);
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
      this.jdField_d_of_type_Boolean = true;
    }
    label99:
    do
    {
      while (this.jdField_b_of_type_JavaLangString == null)
      {
        return;
        if ("1".equals(this.jdField_f_of_type_JavaLangString)) {
          this.jdField_e_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10));
      a();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "init exit");
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cic(this, paramInt), 500L);
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveCache");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((EntityManager)localObject).a(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      if ((paramAccountDetail != null) && (paramAccountDetail.followType == 1))
      {
        localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
        if (localObject != null)
        {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
          PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject).a());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveCache exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      ((EntityManager)localObject).a(paramAccountDetail);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow");
    }
    c(2131363615);
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    this.jdField_c_of_type_MqqObserverBusinessObserver = new cim(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    this.jdField_b_of_type_Int += 1;
    PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow exit");
    }
  }
  
  private void d(int paramInt) {}
  
  private void d(AccountDetail paramAccountDetail)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b(paramAccountDetail);
    localEntityManager.a();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow");
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cio(this), 3000L);
    c(2131363616);
    this.jdField_b_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_Boolean)) {
      localFollowRequest.ext.set(this.jdField_e_of_type_JavaLangString);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new cip(this);
    this.jdField_b_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_b_of_type_MqqAppNewIntent);
    this.jdField_b_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
    }
  }
  
  private void e(int paramInt)
  {
    int i2;
    int i1;
    if (paramInt >= 0)
    {
      if (!Build.BOARD.equals("mx")) {
        break label85;
      }
      i2 = 460;
      i1 = 443;
      paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        break label178;
      }
      if (paramInt > i1) {
        break label111;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    label85:
    label111:
    do
    {
      return;
      i2 = (int)(0.39D * this.jdField_g_of_type_Int);
      i1 = (int)(0.29D * this.jdField_g_of_type_Int);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade != 0))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    return;
    label178:
    if ((paramInt <= i2) && (paramInt >= i1))
    {
      float f1;
      if (paramInt - i1 <= 0.01D * this.jdField_g_of_type_Int) {
        f1 = 0.05F;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f1);
        this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(f1);
        this.jdField_f_of_type_AndroidWidgetTextView.setAlpha(f1);
        this.jdField_a_of_type_AndroidWidgetButton.setAlpha(f1);
        return;
        if (paramInt - i1 <= 0.02D * this.jdField_g_of_type_Int) {
          f1 = 0.15F;
        } else if (paramInt - i1 <= 0.03D * this.jdField_g_of_type_Int) {
          f1 = 0.25F;
        } else if (paramInt - i1 <= 0.04D * this.jdField_g_of_type_Int) {
          f1 = 0.35F;
        } else if (paramInt - i1 <= 0.05D * this.jdField_g_of_type_Int) {
          f1 = 0.45F;
        } else if (paramInt - i1 <= 0.06D * this.jdField_g_of_type_Int) {
          f1 = 0.55F;
        } else if (paramInt - i1 <= 0.07000000000000001D * this.jdField_g_of_type_Int) {
          f1 = 0.65F;
        } else if (paramInt - i1 <= this.jdField_g_of_type_Int * 0.08D) {
          f1 = 0.75F;
        } else if (paramInt - i1 <= this.jdField_g_of_type_Int * 0.08D) {
          f1 = 0.85F;
        } else {
          f1 = 0.95F;
        }
      }
    }
    if (paramInt < i1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.0F);
      this.jdField_f_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidWidgetButton.setAlpha(0.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    this.jdField_f_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setAlpha(1.0F);
  }
  
  private void e(AccountDetail paramAccountDetail)
  {
    ThreadManager.b().postDelayed(new cht(this, paramAccountDetail), 10L);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131363605, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new cir(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new cis(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.j = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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
      d(2131363614);
      o();
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
      m();
      p();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    publicAccountText.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cid(this);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838640);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838645);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton) {
        break label324;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor == "") || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor == null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6)));
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6)));
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription == "") {
        break;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      break;
      label324:
      j();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
  }
  
  private void i()
  {
    this.jdField_g_of_type_Int = getWindowManager().getDefaultDisplay().getHeight();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.scrollTo(0, 0);
    if (Build.BOARD.equals("mx"))
    {
      l = 90;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
        break label283;
      }
    }
    for (localLayoutParams1.height = ((int)(this.jdField_g_of_type_Int * jdField_b_of_type_Double));; localLayoutParams1.height = ((int)(this.jdField_g_of_type_Int * 0.79D))) {
      label283:
      do
      {
        localLayoutParams4.height = (this.jdField_g_of_type_Int - getResources().getDimensionPixelSize(2131492923) * 2);
        localLayoutParams2.height = ((int)(l * this.jdField_a_of_type_Float));
        localLayoutParams2.width = ((int)(l * this.jdField_a_of_type_Float));
        localLayoutParams2.topMargin = ((int)(localLayoutParams1.height * 0.35D - l * this.jdField_a_of_type_Float / 2.0F));
        localLayoutParams3.height = ((int)((l + 10) * this.jdField_a_of_type_Float));
        localLayoutParams3.width = localLayoutParams3.height;
        localLayoutParams3.topMargin = ((int)(localLayoutParams2.topMargin - 5.0F * this.jdField_a_of_type_Float));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams3);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams4);
        return;
        l = 110;
        break;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 2) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 3));
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131363605);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131363602);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList != null)
      {
        int i2 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          a((mobileqq_mp.ConfigGroupInfo)this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList.get(i1), i1, i2);
          i1 += 1;
        }
      }
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setVisibility(8);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse != null) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.has()) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.get() == 2)) {
      l();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.invalidate();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView exit");
      }
      return;
      h();
      if (this.jdField_c_of_type_Boolean) {
        k();
      }
      i();
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "firstFetch");
    }
    p();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.postDelayed(new cif(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "firstFetch exit");
    }
  }
  
  private void p()
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
        this.jdField_a_of_type_MqqObserverBusinessObserver = new cij(this);
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
  
  public void b(int paramInt)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - paramInt;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    double d1 = 1.0D;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    double d2;
    double d3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1)
    {
      d1 = jdField_b_of_type_Double;
      d2 = (0.35D * d1 - 0.05D) / (d1 - 0.3D);
      d3 = (i1 - this.jdField_g_of_type_Int * 0.3D) / ((d1 - 0.3D) * this.jdField_g_of_type_Int);
      if (i1 > this.jdField_g_of_type_Int * 0.3D) {
        break label272;
      }
      localLayoutParams1.height = ((int)(30.0F * this.jdField_a_of_type_Float));
      localLayoutParams1.width = ((int)(30.0F * this.jdField_a_of_type_Float));
      localLayoutParams1.topMargin = ((int)(this.jdField_g_of_type_Int * 0.1D * 0.5D - localLayoutParams1.height / 2 + paramInt));
      localLayoutParams2.height = ((int)(32.0F * this.jdField_a_of_type_Float));
      localLayoutParams2.width = localLayoutParams2.height;
      localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - 1.0F * this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new cie(this, localLayoutParams1, localLayoutParams2));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 2) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 3)) {
        break;
      }
      d1 = 0.79D;
      break;
      label272:
      if (i1 >= d1 * this.jdField_g_of_type_Int)
      {
        localLayoutParams1.height = ((int)(l * this.jdField_a_of_type_Float));
        localLayoutParams1.width = localLayoutParams1.height;
        localLayoutParams1.topMargin = ((int)(i1 * 0.35D - localLayoutParams1.height / 2 + paramInt));
        localLayoutParams2.height = ((int)(localLayoutParams1.height + 10.0F * this.jdField_a_of_type_Float));
        localLayoutParams2.width = localLayoutParams2.height;
        localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - 5.0F * this.jdField_a_of_type_Float));
      }
      else
      {
        localLayoutParams1.height = ((int)((30.0D + (l - 30) * d3) * this.jdField_a_of_type_Float));
        localLayoutParams1.width = localLayoutParams1.height;
        localLayoutParams1.topMargin = ((int)((i1 - 0.3D * this.jdField_g_of_type_Int) * d2 + this.jdField_g_of_type_Int * 0.1D * 0.5D - localLayoutParams1.height / 2 + paramInt));
        localLayoutParams2.height = ((int)(localLayoutParams1.height + (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float));
        localLayoutParams2.width = localLayoutParams2.height;
        localLayoutParams2.topMargin = ((int)(localLayoutParams1.topMargin - (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float / 2.0D));
      }
    }
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
      } while (!this.jdField_g_of_type_Boolean);
      this.i = true;
      return true;
    } while (!this.i);
    this.i = false;
    return true;
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    i();
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
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
          e();
        }
        for (;;)
        {
          j();
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cik(this), 1000L);
          return;
          f();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_b_of_type_JavaLangString, "0X8004E42", "0X8004E42", 0, 0, "", "", "", "");
        }
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_b_of_type_JavaLangString, "0X8004E44", "0X8004E44", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
      {
        finish();
        return;
      }
    } while ((paramView != this.jdField_c_of_type_AndroidWidgetImageView) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null));
    ShareMsgHelper.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_c_of_type_JavaLangString, "https://s.p.qq.com/pub/get_face?img_type=3&uin=" + this.jdField_b_of_type_JavaLangString, "https://s.p.qq.com/mpmobile/card/index.html?puin=" + this.jdField_b_of_type_JavaLangString, ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
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
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.h)) {
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */