package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.HorizontalListView;
import ehi;
import ehj;
import ehk;
import ehl;
import ehm;
import ehn;
import eho;
import ehp;
import ehq;
import ehr;
import ehs;
import eht;
import ehu;
import ehv;
import ehx;
import ehy;
import eia;
import eib;
import eic;
import eid;
import eie;
import eig;
import eih;
import eii;
import eik;
import eil;
import eim;
import ein;
import eio;
import eiq;
import eis;
import eit;
import eiu;
import eiv;
import eiw;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class LoginActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, TextWatcher, View.OnClickListener
{
  public static final int a = 3;
  private static LoginActivity jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
  public static final String a = "jump_action_from_h5";
  public static final int b = 4;
  public static final String b = "package_from_h5";
  public static final int c = 20140107;
  public static final String c = "from_register_guide";
  public static final int d = 20140319;
  private static final String jdField_d_of_type_JavaLangString = "LoginActivity";
  public static final int e = 20140325;
  private static final String jdField_e_of_type_JavaLangString = "!@#ewaGbhkc$!!=";
  private static final int jdField_g_of_type_Int = 0;
  private static final int jdField_h_of_type_Int = 1;
  private static final int jdField_i_of_type_Int = 2;
  private static final boolean jdField_i_of_type_Boolean = true;
  private static final int jdField_j_of_type_Int = 200;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new eig(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ehi(this);
  private View jdField_a_of_type_AndroidViewView;
  public AlphaAnimation a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CustomSafeEditText jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText;
  private DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  private InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  private PadQQCheckBox jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private eiw jdField_a_of_type_Eiw;
  private List jdField_a_of_type_JavaUtilList;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new eie(this);
  private boolean jdField_a_of_type_Boolean = true;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public TextWatcher b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new eik(this);
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView = null;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  public final int f;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString = null;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean = false;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = -1;
  
  public LoginActivity()
  {
    this.e = true;
    this.h = false;
    this.j = true;
    this.jdField_a_of_type_AndroidOsHandler = new ehj(this);
    this.jdField_f_of_type_Int = 2000;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    this.jdField_b_of_type_AndroidTextTextWatcher = new eil(this);
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this, 2131365948, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131365951, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
    {
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i1) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1)).getUin() == null)) {}
        while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1)).getUin().equals(str))
        {
          i1 += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("userguide", 2, "login");
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Boolean = false;
      showDialog(0);
      this.app.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      AlbumUtil.b();
      return;
      com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Boolean = true;
      try
      {
        showDialog(0);
        getAppRuntime().login(paramView, arrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void a(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    if (this.app.t())
    {
      paramButton.setText(getString(2131367652));
      return;
    }
    paramButton.setText(getString(2131365920));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    RecentDataListManager.a().a(paramQQAppInterface, paramQQAppInterface.a(), false);
    try
    {
      StatisticCollector.a(paramQQAppInterface.a()).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      SharedPreUtils.a(paramQQAppInterface.getApplication().getApplicationContext(), paramString, true);
      paramQQAppInterface.saveLastAccountState();
      paramQQAppInterface.getApplication().refreAccountList();
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
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this);
          b();
          return;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.b(paramSimpleAccount.getUin()));
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
          a(paramSimpleAccount.getUin());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private boolean a()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && ((((String)localObject).startsWith("mqqopensdkapi://bizAgent/")) || (((String)localObject).startsWith("https://qm.qq.com/cgi-bin/")) || (((String)localObject).startsWith("mqq://shop/")) || (((String)localObject).startsWith("mqqapi://wallet/open")) || (((String)localObject).startsWith("mqqmdpass://wallet/modify_pass")) || (((String)localObject).startsWith("mqqapi://qqdataline/openqqdataline")) || (((String)localObject).startsWith("mqqapi://dating/")) || (((String)localObject).startsWith("mqqapi://qlink/openqlink"))))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_g_of_type_Boolean = true;
    if (bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramString);
      setResult(-1, (Intent)localObject);
      return true;
    }
    if (JumpActivity.jdField_a_of_type_Boolean)
    {
      setResult(-1);
      return true;
    }
    paramString = getIntent().getStringExtra("scheme_content");
    if (getIntent().getBooleanExtra("isActionSend", false))
    {
      setResult(-1);
      return true;
    }
    Object localObject = getIntent().getStringExtra("pkg_name");
    if ((paramString != null) && (paramString.length() > 0))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, paramString);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localJumpAction.b((String)localObject);
        if (("share".equals(localJumpAction.cJ)) && ("to_qzone".equals(localJumpAction.cK))) {
          this.jdField_g_of_type_Boolean = false;
        }
        localJumpAction.b();
        return true;
      }
      if (("h5".equalsIgnoreCase(localJumpAction.a("jump_from"))) && (localJumpAction.c()))
      {
        getIntent().putExtra("package_from_h5", "pakage_from_h5");
        getIntent().putExtra("jump_action_from_h5", paramString);
        j();
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    String str2 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      if (this.jdField_a_of_type_AndroidWidgetButton.getBackground() != this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetButton.getBackground() == this.jdField_b_of_type_AndroidGraphicsDrawableDrawable) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private boolean b()
  {
    boolean bool = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (bool)
    {
      Intent localIntent = new Intent(this, ContactSyncJumpActivity.class);
      localIntent.putExtra("key_req_from_switch_account", true);
      localIntent.putExtra("key_change", true);
      localIntent.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity(localIntent);
      moveTaskToBack(true);
      finish();
    }
    return bool;
  }
  
  private void c()
  {
    this.jdField_k_of_type_Int = getResources().getDimensionPixelSize(2131493865);
    this.l = getResources().getDimensionPixelSize(2131493860);
    this.m = getResources().getDimensionPixelSize(2131493866);
    this.n = (this.jdField_k_of_type_Int * 2 + this.m);
    this.o = this.l;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838078);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838528);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297958));
    try
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838537);
      Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968640);
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297965));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131297964));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemLongClickListener(new eht(this));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new eih(this));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297971));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297972));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new eio(this));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297974));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new eiq(this));
      d();
      return;
    }
    catch (Error localError)
    {
      for (;;)
      {
        Log.e("app2", "load moutain error", localError);
      }
    }
  }
  
  private void c(String paramString)
  {
    int i1;
    if ((getIntent().getFlags() & 0x100000) != 0)
    {
      i1 = 1;
      if (!a()) {
        break label40;
      }
    }
    for (;;)
    {
      if (this.jdField_g_of_type_Boolean) {
        finish();
      }
      return;
      i1 = 0;
      break;
      label40:
      if (((i1 != 0) || (!a(paramString))) && (!b())) {
        if (getIntent().getParcelableExtra("shortcut_jump_key") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("shortcut_jump_key");
          paramString.setClass(this, ShortcutRouterActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getBooleanExtra("jump_shortcut_dataline", false))
        {
          paramString = new Intent();
          paramString.putExtras(getIntent().getExtras());
          paramString.setClass(this, qfileJumpActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = new Intent(this, JumpActivity.class);
          paramString.putExtra("_goto_qlink_when_login_suc_", true);
          paramString.putExtra("IS_LOGIN_SUC_CALL", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("qlink_share_intent_data") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("qlink_share_intent_data");
          paramString.putExtra("qlink_share_login_suc_flag", true);
          startActivity(paramString);
        }
        else
        {
          setResult(-1);
          if (!getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) {
            j();
          }
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, -(this.m + this.jdField_k_of_type_Int), this.o);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(new eis(this));
    this.jdField_d_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.o + this.m + this.jdField_k_of_type_Int));
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(200L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setAnimationListener(new eit(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.n);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new eiu(this));
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.n);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new eiv(this));
  }
  
  private void e()
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.clearAnimation();
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void f()
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.clearAnimation();
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.clearAnimation();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTop(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getTop() - this.o);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBottom(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getBottom() - this.o);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Eiw != null) {
      this.jdField_a_of_type_Eiw.notifyDataSetChanged();
    }
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      f();
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.setDropIconViewUp();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void i()
  {
    Object localObject = (ViewGroup)findViewById(2131297347);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131297738);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131297357);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      if (localBundle.containsKey("tab_index")) {
        localIntent.putExtra("tab_index", getIntent().getExtras().getInt("tab_index"));
      }
      if (localBundle.containsKey("jump_action_from_h5")) {
        localIntent.putExtra("jump_action_from_h5", getIntent().getExtras().getString("jump_action_from_h5"));
      }
      if (localBundle.containsKey("package_from_h5")) {
        localIntent.putExtra("package_from_h5", getIntent().getExtras().getString("package_from_h5"));
      }
    }
    startActivity(localIntent);
    overridePendingTransition(2130968641, 0);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return this.app.a(paramString, (byte)3, false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131365927);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131365928);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new eim(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ein(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new ehy(this, paramString));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_g_of_type_JavaLangString = null;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_g_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  protected void checkUnlockForSpecial()
  {
    if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.a()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    boolean bool1 = getIntent().getBooleanExtra("from_register_guide", false);
    boolean bool2 = getIntent().getBooleanExtra("isActionSend", false);
    if ((!bool1) && (!bool2))
    {
      paramBundle = getAppRuntime().getApplication().getAllAccounts();
      if ((paramBundle == null) || (paramBundle.isEmpty()))
      {
        paramBundle = getIntent();
        paramBundle.setClass(this, RegisterGuideActivity.class);
        paramBundle.addFlags(67108864);
        startActivity(paramBundle);
        overridePendingTransition(0, 0);
        finish();
      }
    }
    setContentView(2130903368);
    if (jdField_a_of_type_ComTencentMobileqqActivityLoginActivity != null) {
      jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.finish();
    }
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = this;
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131297738);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131297962)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131365931));
    bool1 = getIntent().getBooleanExtra("is_change_account", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText = ((CustomSafeEditText)findViewById(2131297966));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setContentDescription(getString(2131365932));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnEditorActionListener(new ehk(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297969));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131365933));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297976));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131365934));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131297957));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setBackgroundResource(2130838527);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131297960);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131297959);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new ehl(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(new ehm(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296567));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    catch (Throwable paramBundle)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838535);
        label439:
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131365935));
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131297975));
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131365924));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
        this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131297962));
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
        this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        c();
        b();
        label571:
        String str;
        int i1;
        int i2;
        label721:
        SimpleAccount localSimpleAccount;
        int i4;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramBundle = getAppRuntime().getApplication().getAllAccounts();
          if (paramBundle != null) {
            this.jdField_a_of_type_JavaUtilList.addAll(paramBundle);
          }
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this);
          if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
            break label1256;
          }
          this.jdField_a_of_type_Eiw = new eiw(this, this);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Eiw);
          if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (!bool1)) {
            break label876;
          }
          paramBundle = getIntent().getStringExtra("uin");
          str = getIntent().getStringExtra("befault_uin");
          if ((!bool1) || (paramBundle == null) || (paramBundle.length() <= 0)) {
            break label1236;
          }
          i1 = 0;
          i2 = -1;
          if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label860;
          }
          localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
          i4 = i2;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break label804;
            }
            i4 = i2;
          }
        }
        for (;;)
        {
          i1 += 1;
          i2 = i4;
          break label721;
          paramBundle = paramBundle;
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setBackgroundResource(2131427478);
          break;
          this.jdField_a_of_type_JavaUtilList.clear();
          break label571;
          label804:
          int i3 = i2;
          if (str != null)
          {
            i3 = i2;
            if (str.equals(localSimpleAccount.getUin())) {
              i3 = i1;
            }
          }
          i4 = i3;
          if (paramBundle.equals(localSimpleAccount.getUin()))
          {
            a(localSimpleAccount);
            i4 = i3;
          }
        }
        label860:
        if (i2 != -1) {
          this.jdField_a_of_type_JavaUtilList.remove(i2);
        }
        label876:
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new ehn(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnFocusChangeListener(new eho(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setLongClickable(false);
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new ehp(this));
        if (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false))
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          findViewById(2131297348).setVisibility(0);
          ((TextView)findViewById(2131297348)).setText(2131365955);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366374);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ehq(this));
          this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = findViewById(2131297961);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextClearedListener(new ehs(this));
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
          if ((getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
          {
            SharedPreUtils.a(this.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
          }
          i();
          if (getIntent().getBooleanExtra("reason_for_upgrade", false)) {
            showDialog(2);
          }
          if ((getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
          {
            ((TextView)findViewById(2131297348)).setText(2131369284);
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(getIntent().getStringExtra("key_uin_to_login"));
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.setOnDropdownViewDropIconClickListner(new ehu(this));
          return true;
          label1236:
          a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
          break;
          label1256:
          this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
          break;
          if (bool1)
          {
            this.jdField_d_of_type_AndroidViewView.setVisibility(0);
            findViewById(2131297348).setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366374);
            this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ehr(this));
          }
          else
          {
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          }
        }
      }
      catch (Error paramBundle)
      {
        break label439;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = null;
    this.app.a(getClass());
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_g_of_type_Boolean = true;
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("userguide", 2, "fight....loginActivity..................");
    }
    super.doOnPause();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    this.p = paramBundle.getInt("position", -1);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    h();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("main", 2, "onResume in LoginActivity");
    }
    if (this.app != null) {
      this.app.a(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putInt("position", this.p);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.e))
    {
      this.e = false;
      this.jdField_a_of_type_AndroidViewView.post(new ehv(this));
    }
    if (PrivacyPolicyHelper.a(0)) {
      runOnUiThread(new ehx(this));
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    this.app.a(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      String str = this.app.a();
      if (!this.jdField_f_of_type_JavaLangString.equalsIgnoreCase(str)) {
        SharedPreUtils.a(this.app.getApplication().getApplicationContext(), this.jdField_f_of_type_JavaLangString, true);
      }
    }
    if (PhoneNumLoginImpl.a().a()) {}
    do
    {
      return;
      a(this.app, this.app.getAccount());
      c(this.app.getAccount());
    } while (isFinishing());
    dismissDialog(0);
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  public boolean onBackEvent()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    if (getIntent().getBooleanExtra("key_req_by_contact_sync", false))
    {
      if (bool2) {
        moveTaskToBack(true);
      }
      for (;;)
      {
        finish();
        return true;
        this.app.b(false);
      }
    }
    if ((bool1) || (bool2))
    {
      if (bool1) {
        setResult(-1);
      }
      finish();
      return true;
    }
    finish();
    this.app.b(false);
    return true;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.p != -1)
    {
      paramDialogInterface = new QQProgressDialog(this, getTitleBarHeight());
      paramDialogInterface.d(true);
      paramDialogInterface.setContentView(2130904387);
      paramDialogInterface.b(2131366673);
      paramDialogInterface.show();
      eiw localeiw = this.jdField_a_of_type_Eiw;
      String str1 = localeiw.b(this.p);
      String str2 = localeiw.a(this.p);
      this.jdField_a_of_type_JavaUtilList.remove(this.p);
      this.p = -1;
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) || (str2.equals(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString())))
      {
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
      }
      localeiw.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_f_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_f_of_type_JavaLangString = null;
      }
      new Thread(new eii(this, str1, paramDialogInterface), "delete_account in login").start();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131297969) {
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        QQToast.a(this, 2131366845, 0).a();
      }
    }
    while ((i1 != 2131297976) || (!this.j))
    {
      return;
      a(paramView);
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    Intent localIntent = new Intent(this, RegisterPhoneNumActivity.class);
    localIntent.putExtra("key_register_now_account", paramView);
    startActivity(localIntent);
    this.j = false;
    new Handler().postDelayed(new eid(this), 1000L);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return null;
        localObject = new QQProgressDialog(this);
        ((QQProgressDialog)localObject).a(getString(2131365938));
        return localObject;
      } while (!isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject = getLayoutInflater().inflate(2130903273, null);
      return DialogUtil.a(this, 230).setTitle(getString(2131365956)).setPositiveButton(2131365959, this).setNegativeButton(2131365970, new eia(this)).addView((View)localObject);
    case 2: 
      localObject = getIntent();
      String str1 = ((Intent)localObject).getStringExtra("StrTitle");
      String str2 = ((Intent)localObject).getStringExtra("StrUpgradeDesc");
      ((Intent)localObject).getStringExtra("StrUrl");
      localObject = DialogUtil.a(this, 230).setTitle(str1).setMessage(str2);
      ((QQCustomDialog)localObject).setPositiveButton("升级", new eib(this));
      ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131366458));
      ((QQCustomDialog)localObject).setNegativeButton("取消", new eic(this));
      return localObject;
    }
    if (this.app != null) {}
    for (Object localObject = this.app.a();; localObject = "") {
      return PrivacyPolicyHelper.a(this, (String)localObject);
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131297136);
      String str = getString(2131365957);
      eiw localeiw = this.jdField_a_of_type_Eiw;
      if (this.p != -1) {
        localTextView.setText(str.replace("${account}", localeiw.a(this.p)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131297523));
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() != paramCharSequence.length()) && (paramInt3 != 0))
      {
        this.app.getApplication().refreAccountList();
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838078);
      }
      a(null);
      if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.jdField_g_of_type_JavaLangString.length() + 1))
        {
          this.app.getApplication().refreAccountList();
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838528);
          return;
        }
        if ((!paramCharSequence.substring(0, this.jdField_g_of_type_JavaLangString.length()).equals(this.jdField_g_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.jdField_g_of_type_JavaLangString.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(1);
    }
    this.jdField_g_of_type_JavaLangString = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.a()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */