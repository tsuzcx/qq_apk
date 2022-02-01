package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import dey;
import dez;
import dfa;
import dfb;
import dfc;
import dfd;
import dfe;
import dff;
import dfg;
import dfh;
import dfi;
import dfj;
import dfk;
import dfl;
import java.util.ArrayList;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener
{
  protected static final int a = 1;
  public static final String a = "AddFriendVerifyActivity";
  protected static final int b = 2;
  public static final boolean b = true;
  public static final int c = 30;
  private static final int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = "last_verify_msg";
  private static final String jdField_e_of_type_JavaLangString = "last_add_friend_verify_";
  private static final String f = "last_add_troop_verfity_";
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new dfk(this);
  public EditText a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new dfd(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dfl(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dez(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dfa(this);
  public FormSwitchItem a;
  public QQProgressDialog a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSwitchItem b;
  public String b;
  protected LinearLayout c;
  private TextView c;
  protected String c;
  public boolean c;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  private int jdField_e_of_type_Int;
  protected boolean e;
  private String g;
  
  public AddFriendVerifyActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
  }
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(1));
    this.jdField_d_of_type_Boolean = ((TroopManager)this.app.getManager(50)).d(this.jdField_b_of_type_JavaLangString);
    localSwitch.setChecked(this.jdField_d_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean == true) {}
    for (String str = getString(2131363974);; str = getString(2131363973))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    ((TroopHandler)this.app.a(19)).a(paramString1, paramString2, paramInt);
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != null))
    {
      boolean bool = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().isChecked();
      ((BizTroopHandler)this.app.a(21)).a(null, this.jdField_b_of_type_JavaLangString, 3, bool);
      if (!bool) {
        break label293;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_set_open", 0, 0, paramString1, "", "", "");
      if ((!this.jdField_a_of_type_Boolean) && (bool)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_open", 0, 0, paramString1, "", "", "");
      }
      if ((this.jdField_a_of_type_Boolean) && (!bool)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_close", 0, 0, paramString1, "", "", "");
      }
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean == true) && (!this.jdField_d_of_type_Boolean)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean == true)) {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      return;
      label293:
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "share_set_close", 0, 0, paramString1, "", "", "");
      break;
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private boolean a()
  {
    int i = getIntent().getExtras().getInt("source_id", 10004);
    return (i == 3003) || (i == 3006) || (i == 3007) || (i == 3009) || (i == 3013);
  }
  
  private void b()
  {
    ((BizTroopHandler)this.app.a(21)).a(null, this.jdField_b_of_type_JavaLangString, 1, false);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131363976, 0).b(getTitleBarHeight());
      a();
    }
    while (((TroopManager)this.app.getManager(50) == null) || (this.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    ((TroopHandler)this.app.a(19)).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramBoolean, true);
  }
  
  private void c(boolean paramBoolean)
  {
    if (((TroopInfoManager)this.app.getManager(36) == null) || (this.jdField_b_of_type_JavaLangString == null)) {}
    do
    {
      return;
      if (NetworkUtil.a(this) == 0)
      {
        QQToast.a(this, 2131363422, 0).b(getTitleBarHeight());
        a(paramBoolean);
        return;
      }
    } while (paramBoolean);
    DialogUtil.a(this, 230).setTitle(getString(2131365995)).setMessage(getString(2131364012)).setNegativeButton(getString(2131364013), new dfc(this)).setPositiveButton(getString(2131364014), new dfb(this, paramBoolean)).show();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), paramString).commit();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("msg", paramString);
    localIntent.putExtra("sig", paramArrayOfByte);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivityForResult(localIntent, 0);
      return;
    }
    startActivityForResult(localIntent, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    localSwitch.setTag(Integer.valueOf(2));
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      localSwitch.setContentDescription(getString(2131364010));
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewB(2130903071);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367219);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296684));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296685));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296687));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296688));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296689));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296691));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296692));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296693));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    Object localObject4 = getIntent();
    this.g = ((Intent)localObject4).getStringExtra("uin");
    this.jdField_e_of_type_Int = ((Intent)localObject4).getIntExtra("k_uin_type", 1);
    paramBundle = getIntent().getExtras().getString("nick_name");
    Object localObject2 = (ImageView)findViewById(2131296682);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296683));
    Object localObject3 = (TextView)findViewById(2131296572);
    Object localObject1;
    int i;
    if (this.jdField_e_of_type_Int == 4)
    {
      setTitle(2131368824);
      ((ImageView)localObject2).setImageDrawable(this.app.a(this.g));
      localObject4 = this.jdField_d_of_type_AndroidWidgetTextView;
      localObject1 = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        localObject1 = this.g;
      }
      ((TextView)localObject4).setText((CharSequence)localObject1);
      ((TextView)localObject3).setText(this.g);
      this.jdField_b_of_type_JavaLangString = this.g;
      this.jdField_c_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
      b();
      paramBundle = (TroopHandler)this.app.a(19);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_b_of_type_JavaLangString);
      }
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      ((TextView)localObject3).setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      i = getIntent().getExtras().getShort("group_option", (short)2);
      paramBundle = getIntent().getExtras().getString("troop_question");
      switch (i)
      {
      case 3: 
      default: 
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296694));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getResources().getString(2131364010));
        paramBundle = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        paramBundle.setTag(Integer.valueOf(2));
        paramBundle.setChecked(false);
        paramBundle.setContentDescription(getString(2131364010));
        this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296695));
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296696));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getResources().getString(2131363972));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        ((Switch)localObject1).setTag(Integer.valueOf(1));
        boolean bool = ((TroopManager)this.app.getManager(50)).d(this.jdField_b_of_type_JavaLangString);
        ((Switch)localObject1).setOnCheckedChangeListener(null);
        ((Switch)localObject1).setChecked(bool);
        ((Switch)localObject1).setOnCheckedChangeListener(this);
        if (bool == true)
        {
          paramBundle = getString(2131363974);
          label695:
          ((Switch)localObject1).setContentDescription(paramBundle);
          getWindow().setSoftInputMode(5);
        }
        break;
      }
    }
    for (;;)
    {
      enableRightHighlight(true);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(92.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_b_of_type_AndroidWidgetEditText.setGravity(48);
      this.jdField_b_of_type_AndroidWidgetEditText.setBackgroundResource(2130841913);
      i = AIOUtils.a(10.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetEditText.setPadding(i, i, i, i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("30");
      paramBundle = a(true);
      if (paramBundle != null)
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setText(paramBundle);
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131365256));
      }
      setRightHighlightButton(2131366313, new dey(this));
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367001) + ":" + paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(getString(2131367002));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinHeight((int)DisplayUtils.a(this, 44.0F));
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(44.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131365256));
      setRightHighlightButton(2131366313, new dfe(this));
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131367001) + ":" + paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(getString(2131367002));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinHeight((int)DisplayUtils.a(this, 44.0F));
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(44.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131365256));
      setRightHighlightButton(2131366313, new dff(this));
      break;
      paramBundle = getString(2131363973);
      break label695;
      setTitle(2131366870);
      ((TextView)localObject3).setVisibility(0);
      findViewById(2131296694).setVisibility(8);
      findViewById(2131296695).setVisibility(8);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      i = getIntent().getExtras().getInt("source_id", 10004);
      label1336:
      int j;
      if (this.jdField_e_of_type_Int == 2)
      {
        ((ImageView)localObject2).setImageDrawable(FaceDrawable.a(this.app, 11, this.g));
        localObject2 = this.jdField_d_of_type_AndroidWidgetTextView;
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject1 = this.g;
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject3).setText(this.g);
        j = ((Intent)localObject4).getIntExtra("friend_setting", 0);
        localObject1 = getIntent().getExtras().getStringArrayList("user_question");
        switch (j)
        {
        case 0: 
        case 2: 
        default: 
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(getString(2131366998));
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          paramBundle = null;
          if (this.jdField_e_of_type_Int == 3) {
            paramBundle = ((Intent)localObject4).getStringExtra("msg");
          }
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = a(false);
          }
          if (localObject1 != null) {
            this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
          }
          break;
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
        label1483:
        setRightHighlightButton(2131367271, new dfg(this));
        getWindow().setSoftInputMode(5);
        continue;
        if (this.jdField_e_of_type_Int == 3)
        {
          localObject1 = ((Intent)localObject4).getStringExtra("extra");
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(FaceDrawable.a(this.g, (String)localObject1)));
          ((TextView)localObject3).setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
          ((FriendListHandler)this.app.a(1)).a(this.g, getIntent().getStringExtra("extra"));
          break label1336;
        }
        if ((i == 3007) || (i == 2007) || (i == 3019) || (i == 2019)) {
          ((ImageView)localObject2).setImageDrawable(FaceDrawable.a(this.app, 3000, this.g, true));
        }
        for (;;)
        {
          localObject2 = ((FriendManager)this.app.getManager(8)).d(this.g);
          if (!a()) {
            break label1703;
          }
          if (paramBundle == null) {
            break;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
          break;
          ((ImageView)localObject2).setImageDrawable(FaceDrawable.a(this.app, 1, this.g));
        }
        label1703:
        Object localObject5 = this.jdField_d_of_type_AndroidWidgetTextView;
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject1 = localObject2;
        }
        ((TextView)localObject5).setText((CharSequence)localObject1);
        ((TextView)localObject3).setText((CharSequence)localObject2);
        break label1336;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramBundle = (String)((ArrayList)localObject1).get(0);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297136);
        localObject2 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299724);
        ((TextView)localObject1).setText(getString(2131367001) + ":" + paramBundle);
        ((EditText)localObject2).setSingleLine(true);
        ((EditText)localObject2).setContentDescription(getString(2131365256));
        setRightHighlightButton(2131367271, new dfh(this, (EditText)localObject2, j, i));
        getWindow().setSoftInputMode(5);
        continue;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localObject2 = new InputFilter.LengthFilter(10);
        findViewById(2131296686).setVisibility(0);
        localObject3 = new StringBuffer();
        i = 0;
        if (i < ((ArrayList)localObject1).size())
        {
          switch (i)
          {
          default: 
            paramBundle = getResources().getString(2131367001);
          }
          for (;;)
          {
            localObject4 = getLayoutInflater().inflate(2130903817, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            localObject5 = getLayoutInflater().inflate(2130903816, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            if (i > 0)
            {
              localObject6 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
              if (localObject6 != null)
              {
                ((LinearLayout.LayoutParams)localObject6).topMargin = ((int)DisplayUtils.a(this, 20.0F));
                ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
              }
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject5);
            Object localObject6 = (String)((ArrayList)localObject1).get(i);
            ((TextView)((View)localObject4).findViewById(2131297136)).setText(paramBundle + (String)localObject6);
            paramBundle = (EditText)((View)localObject5).findViewById(2131299724);
            paramBundle.setFilters(new InputFilter[] { localObject2 });
            paramBundle.setSingleLine(false);
            this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
            ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setContentDescription(getString(2131365256));
            j = i + 1;
            ((StringBuffer)localObject3).append(getString(2131367001) + j + ":" + (String)localObject6);
            ((StringBuffer)localObject3).append("\n");
            ((StringBuffer)localObject3).append(getString(2131367005) + ":${answer}");
            if (j != ((ArrayList)localObject1).size()) {
              ((StringBuffer)localObject3).append("\n");
            }
            i += 1;
            break;
            paramBundle = getResources().getString(2131367221);
            continue;
            paramBundle = getResources().getString(2131367222);
            continue;
            paramBundle = getResources().getString(2131367223);
            continue;
            paramBundle = getResources().getString(2131367224);
            continue;
            paramBundle = getResources().getString(2131367225);
          }
        }
        setRightHighlightButton(2131367271, new dfi(this, (StringBuffer)localObject3));
        findViewById(2131296681).setOnTouchListener(new dfj(this));
        getWindow().setSoftInputMode(4);
      }
      catch (Throwable paramBundle)
      {
        break label1483;
      }
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  public void finish()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 2);
    super.finish();
  }
  
  protected boolean onBackEvent()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (4 == this.jdField_e_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool);
      return super.onBackEvent();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {}
    while (((TroopManager)this.app.getManager(50) == null) || (this.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    case 1: 
      b(paramBoolean);
      return;
    }
    c(paramBoolean);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131299724) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */