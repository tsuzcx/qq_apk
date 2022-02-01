package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import dtz;
import dub;
import duc;
import dud;
import due;
import duf;
import dug;
import duh;
import dui;
import duj;
import duk;
import dul;
import dum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailProfileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int G = 1000;
  static final int jdField_a_of_type_Int = 36;
  private static final long jdField_a_of_type_Long = 20000L;
  static final String jdField_a_of_type_JavaLangString = "DetailProfileActivity";
  private static final byte jdField_b_of_type_Byte = -1;
  static final int jdField_b_of_type_Int = 120;
  public static final String b = "param_switches_changed";
  static final int jdField_c_of_type_Int = 40;
  static final int jdField_d_of_type_Int = 50;
  static final int jdField_e_of_type_Int = 383;
  public static final int j = -1;
  static final int jdField_k_of_type_Int = 1000;
  static final int jdField_l_of_type_Int = 1001;
  static final int jdField_m_of_type_Int = 1002;
  static final int jdField_n_of_type_Int = 1003;
  static final int jdField_o_of_type_Int = 1004;
  static final int p = 1005;
  static final int q = 0;
  static final int r = 1;
  static final int s = 2;
  static final int t = 3;
  private static final int v = 0;
  private static final int w = 0;
  private static final int x = 0;
  private static final int y = -1;
  private int A = -1;
  private int B = -1;
  private int C = -1;
  private int D = -1;
  private int E = -1;
  private int F = -1;
  public byte a;
  public Dialog a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new duh(this);
  Handler jdField_a_of_type_AndroidOsHandler = new dui(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new dud(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new duc(this);
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new duk(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new dug(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new duf(this);
  public IphonePickerView a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public ActionSheet a;
  dum jdField_a_of_type_Dum;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  dum jdField_b_of_type_Dum;
  boolean jdField_b_of_type_Boolean = false;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  dum jdField_c_of_type_Dum;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private EditText jdField_d_of_type_AndroidWidgetEditText;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  dum jdField_d_of_type_Dum;
  boolean jdField_d_of_type_Boolean = false;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean;
  int jdField_i_of_type_Int;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean = false;
  private View jdField_j_of_type_AndroidViewView;
  private boolean jdField_j_of_type_Boolean = false;
  private View jdField_k_of_type_AndroidViewView;
  private boolean jdField_k_of_type_Boolean = false;
  private View jdField_l_of_type_AndroidViewView;
  private boolean jdField_l_of_type_Boolean = false;
  private boolean jdField_m_of_type_Boolean;
  private boolean jdField_n_of_type_Boolean;
  private boolean jdField_o_of_type_Boolean;
  public int u = 0;
  private int z = -1;
  
  public DetailProfileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.m = false;
    this.n = false;
    this.o = false;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Dum.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Dum.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Dum.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Dum.jdField_b_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (b());
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool = true;
    if (paramArrayOfString1 == paramArrayOfString2) {}
    for (;;)
    {
      return bool;
      try
      {
        int i1;
        if (paramArrayOfString1.length == paramArrayOfString2.length) {
          i1 = 0;
        }
        for (;;)
        {
          if ((i1 >= paramArrayOfString1.length) || (!paramArrayOfString1[i1].equals(paramArrayOfString2[i1])))
          {
            int i2 = paramArrayOfString1.length;
            if (i1 == i2) {
              break;
            }
            bool = false;
            break;
          }
          i1 += 1;
        }
        return false;
      }
      catch (Exception paramArrayOfString1) {}
    }
  }
  
  private boolean b()
  {
    return (this.o) || (this.jdField_i_of_type_Boolean) || (this.m) || (this.n) || (this.jdField_j_of_type_Boolean) || (this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean);
  }
  
  @SuppressLint({"CutPasteId"})
  private void c()
  {
    setContentView(2130903987);
    setContentBackgroundResource(2131427574);
    setTitle(2131368233);
    setRightHighlightButton(2131367064, this);
    enableRightHighlight(false);
    this.leftView.setOnClickListener(new due(this));
    this.leftView.setContentDescription("取消按钮");
    this.rightViewText.setContentDescription("完成按钮");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300346);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131300347));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131369624);
    this.jdField_a_of_type_Dum = new dum(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Dum);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131369623), "");
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300348);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300349));
    a(-1, false);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131300350);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131300351));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131300352);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131300353));
    a(0, 0, 0);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131300354);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300356));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300355));
    a(-1);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131300357);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_f_of_type_AndroidViewView.findViewById(2131300358));
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131369634);
    this.jdField_b_of_type_Dum = new dum(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Dum);
    a(this.jdField_f_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131369633), "");
    this.jdField_g_of_type_AndroidViewView = findViewById(2131300359);
    this.jdField_g_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)this.jdField_g_of_type_AndroidViewView.findViewById(2131300360));
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131369636);
    this.jdField_c_of_type_Dum = new dum(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Dum);
    a(this.jdField_g_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131369635), "");
    this.jdField_h_of_type_AndroidViewView = findViewById(2131300361);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131300362));
    a(null);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131300363);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_i_of_type_AndroidViewView.findViewById(2131300364));
    b(null);
    this.jdField_j_of_type_AndroidViewView = findViewById(2131300365);
    this.jdField_j_of_type_AndroidViewView.setClickable(false);
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)this.jdField_j_of_type_AndroidViewView.findViewById(2131300366));
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131369642);
    this.jdField_d_of_type_AndroidWidgetEditText.getInputType();
    this.jdField_d_of_type_Dum = new dum(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
    this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Dum);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_j_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131369641), "");
    this.jdField_k_of_type_AndroidViewView = findViewById(2131300367);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131300368));
    this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine(false);
    c(null);
    a(this.jdField_k_of_type_AndroidViewView, this.jdField_h_of_type_AndroidWidgetTextView, getString(2131369643), "");
    this.jdField_l_of_type_AndroidViewView = findViewById(2131300369);
    this.jdField_l_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Dum.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 1, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 2, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_g_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 3, 0, "", "", "", "");
      }
      if (this.jdField_h_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 4, 0, "", "", "", "");
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 5, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Dum.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 6, 0, "", "", "", "");
    }
    if (this.jdField_c_of_type_Dum.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 7, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 9, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 8, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Dum.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 10, 0, "", "", "", "");
    }
    if (this.jdField_f_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800486C", "0X800486C", 11, 0, "", "", "", "");
    }
  }
  
  void a()
  {
    int i2 = 0;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296635);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903932, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    int i1;
    if (this.jdField_a_of_type_Byte != 1) {
      i1 = 0;
    }
    for (;;)
    {
      ((IphonePickerView)localObject).setSelection(0, i1);
      if ((this.jdField_a_of_type_Byte != 0) && (this.jdField_a_of_type_Byte != 1))
      {
        i1 = i2;
        a(i1, true);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
        i1 = 1;
        continue;
        i1 = this.jdField_a_of_type_Byte;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("DetailProfileActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  void a(int paramInt)
  {
    boolean bool = false;
    Object localObject2;
    Object localObject1;
    label76:
    TextView localTextView;
    String str;
    if (NearbyProfileUtil.a(paramInt))
    {
      this.jdField_i_of_type_Int = paramInt;
      localObject2 = NearbyProfileUtil.e(this.jdField_i_of_type_Int);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_i_of_type_Int = -1;
        localObject1 = getString(2131369632);
      }
      if ((this.jdField_i_of_type_Int < NearbyProfileUtil.e.length - 1) && (this.jdField_i_of_type_Int > 0)) {
        break label149;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (this.jdField_i_of_type_Int == -1) {
        bool = true;
      }
      a((TextView)localObject2, (String)localObject1, bool);
      localObject2 = this.jdField_e_of_type_AndroidViewView;
      localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      str = getString(2131369631);
      if (this.jdField_i_of_type_Int == -1) {
        break label190;
      }
    }
    for (;;)
    {
      a((View)localObject2, localTextView, str, (String)localObject1);
      return;
      this.jdField_i_of_type_Int = -1;
      break;
      label149:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a[this.jdField_i_of_type_Int]);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[this.jdField_i_of_type_Int]);
      break label76;
      label190:
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_h_of_type_Int = paramInt3;
    Object localObject2;
    Object localObject1;
    boolean bool1;
    label44:
    label70:
    Object localObject3;
    label87:
    Object localObject4;
    if (paramInt1 == 0)
    {
      localObject2 = getString(2131369628);
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramInt1 != 0) {
        break label203;
      }
      bool1 = true;
      a((TextView)localObject1, (String)localObject2, bool1);
      if (this.jdField_h_of_type_Int != 0) {
        break label209;
      }
      localObject1 = getString(2131369630);
      localObject3 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_h_of_type_Int != 0) {
        break label221;
      }
      bool1 = bool2;
      a((TextView)localObject3, (String)localObject1, bool1);
      localObject3 = this.jdField_c_of_type_AndroidViewView;
      localObject4 = this.jdField_b_of_type_AndroidWidgetTextView;
      String str = getString(2131369627);
      if (paramInt1 == 0) {
        break label227;
      }
      label122:
      a((View)localObject3, (View)localObject4, str, (String)localObject2);
      localObject2 = this.jdField_d_of_type_AndroidViewView;
      localObject3 = this.jdField_c_of_type_AndroidWidgetTextView;
      localObject4 = getString(2131369629);
      if (this.jdField_h_of_type_Int == 0) {
        break label235;
      }
    }
    for (;;)
    {
      a((View)localObject2, (View)localObject3, (String)localObject4, (String)localObject1);
      return;
      localObject2 = String.valueOf(paramInt2) + "岁";
      break;
      label203:
      bool1 = false;
      break label44;
      label209:
      localObject1 = Utils.a(this.jdField_h_of_type_Int);
      break label70;
      label221:
      bool1 = false;
      break label87;
      label227:
      localObject2 = "";
      break label122;
      label235:
      localObject1 = "";
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.u = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if (paramInt == 3) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new duj(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str1 = getString(2131369626);
    Object localObject;
    TextView localTextView;
    String str2;
    if (paramInt == 0)
    {
      str1 = getString(2131366573);
      if (!paramBoolean) {
        break label100;
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, str1, 2131427938);
      localObject = this.jdField_b_of_type_AndroidViewView;
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      str2 = getString(2131369625);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label133;
      }
    }
    for (;;)
    {
      a((View)localObject, localTextView, str2, str1);
      return;
      if (paramInt != 1) {
        break;
      }
      str1 = getString(2131366574);
      break;
      label100:
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((paramInt != 0) && (paramInt != 1)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a((TextView)localObject, str1, paramBoolean);
        break;
      }
      label133:
      str1 = "";
    }
  }
  
  public void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    if ((paramView2 instanceof TextView))
    {
      paramView2.setContentDescription(str);
      return;
    }
    paramView2.setContentDescription(paramString1 + ",编辑框," + paramString2 + ",");
  }
  
  void a(TextView paramTextView, String paramString, int paramInt)
  {
    paramTextView.setTextColor(getResources().getColor(paramInt));
    paramTextView.setText(paramString);
  }
  
  void a(TextView paramTextView, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2131427579;; i1 = 2131427934)
    {
      a(paramTextView, paramString, i1);
      return;
    }
  }
  
  public void a(Card paramCard)
  {
    Object localObject2 = null;
    if ((!this.jdField_a_of_type_Dum.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strNick)))
    {
      this.jdField_a_of_type_Dum.jdField_a_of_type_Boolean = true;
      if (!TextUtils.isEmpty(paramCard.strNick)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCard.strNick);
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131369623), paramCard.strNick);
      if (!this.jdField_a_of_type_Boolean) {
        a(paramCard.shGender, false);
      }
      if (!this.jdField_b_of_type_Boolean) {
        a((int)paramCard.lBirthday, paramCard.age, paramCard.constellation);
      }
      if (!this.jdField_c_of_type_Boolean) {
        a(paramCard.iProfession);
      }
      if ((!this.jdField_b_of_type_Dum.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strCompany)))
      {
        this.jdField_b_of_type_Dum.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetEditText.setText(paramCard.strCompany);
        a(this.jdField_f_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131369633), paramCard.strCompany);
      }
      if (!this.jdField_d_of_type_Boolean) {
        if (paramCard.strLocationCodes == null) {
          break label535;
        }
      }
    }
    label535:
    for (Object localObject1 = paramCard.strLocationCodes.split("-");; localObject1 = null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      a(paramCard.strLocationDesc);
      if (!this.jdField_e_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (paramCard.strHometownCodes != null) {
          localObject1 = paramCard.strHometownCodes.split("-");
        }
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        b(paramCard.strHometownDesc);
      }
      if ((!this.jdField_c_of_type_Dum.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strSchool)))
      {
        this.jdField_c_of_type_Dum.jdField_a_of_type_Boolean = true;
        this.jdField_c_of_type_AndroidWidgetEditText.setText(paramCard.strSchool);
        a(this.jdField_g_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131369635), paramCard.strSchool);
      }
      if ((!this.jdField_d_of_type_Dum.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!this.jdField_d_of_type_AndroidWidgetEditText.getText().toString().equals(paramCard.strEmail)))
      {
        this.jdField_d_of_type_Dum.jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_AndroidWidgetEditText.setText(paramCard.strEmail);
        a(this.jdField_j_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131369641), paramCard.strEmail);
      }
      if (!this.jdField_f_of_type_Boolean)
      {
        c(paramCard.strPersonalNote);
        a(this.jdField_k_of_type_AndroidViewView, this.jdField_h_of_type_AndroidWidgetTextView, getString(2131369643), paramCard.strPersonalNote);
      }
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      break;
    }
  }
  
  void a(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131369638);
      bool = true;
    }
    a(this.jdField_f_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_h_of_type_AndroidViewView;
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    String str2 = getString(2131369637);
    if (bool) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(i1);
      if (QLog.isColorLevel()) {
        QLog.d("DetailProfileActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131367328, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131369485));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131369485));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    String[] arrayOfString1;
    if (paramInt == 1)
    {
      i1 = 2;
      localIntent.putExtra("param_req_type", i1);
      if (paramInt != 1) {
        break label278;
      }
      arrayOfString1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      label170:
      String[] arrayOfString2;
      if (arrayOfString1 != null)
      {
        arrayOfString2 = arrayOfString1;
        if (arrayOfString1.length == 4) {}
      }
      else
      {
        arrayOfString2 = new String[4];
        arrayOfString2[0] = "0";
        arrayOfString2[1] = "0";
        arrayOfString2[2] = "0";
        arrayOfString2[3] = "0";
      }
      localIntent.putExtra("param_is_popup", false);
      localIntent.putExtra("param_location", arrayOfString2);
      localIntent.putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString2));
      if (paramInt != 1) {
        break label286;
      }
    }
    label278:
    label286:
    for (paramInt = 1002;; paramInt = 1003)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      i1 = 3;
      break;
      arrayOfString1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      break label170;
    }
  }
  
  void b(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131369640);
      bool = true;
    }
    a(this.jdField_g_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_i_of_type_AndroidViewView;
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    String str2 = getString(2131369639);
    if (bool) {
      str1 = "";
    }
    a(paramString, localTextView, str2, str1);
  }
  
  void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = getString(2131369645);; str = paramString)
    {
      a(this.jdField_h_of_type_AndroidWidgetTextView, str, TextUtils.isEmpty(paramString));
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    if (paramInt2 != -1) {}
    for (;;)
    {
      return;
      if (paramInt1 == 1000)
      {
        paramInt1 = paramIntent.getShortExtra("param_year", (short)1990);
        paramInt2 = paramIntent.getByteExtra("param_month", (byte)1);
        int i1 = paramIntent.getByteExtra("param_day", (byte)1);
        int i2 = paramIntent.getIntExtra("param_age", 0);
        int i3 = paramIntent.getIntExtra("param_constellation_id", 0);
        int i4 = paramInt1 << 16 | paramInt2 << 8 | i1;
        bool2 = bool1;
        if (i4 != this.jdField_f_of_type_Int)
        {
          this.jdField_b_of_type_Boolean = true;
          a(i4, i2, i3);
          bool2 = true;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("DetailProfileActivity", 2, "onAgeSelectResult: year/month/day/age/constell" + paramInt1 + "  " + paramInt2 + "  " + i1 + "  " + i2 + "  " + i3 + "  " + bool2);
          bool1 = bool2;
        }
      }
      while (bool1)
      {
        enableRightHighlight(true);
        return;
        Object localObject;
        if (paramInt1 == 1003)
        {
          paramIntent = paramIntent.getStringArrayExtra("param_location");
          bool2 = bool3;
          if (!a(this.jdField_b_of_type_ArrayOfJavaLangString, paramIntent))
          {
            this.jdField_b_of_type_ArrayOfJavaLangString = paramIntent;
            this.jdField_e_of_type_Boolean = true;
          }
          try
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
            if (paramIntent != null)
            {
              localObject = paramIntent;
              if (!paramIntent.equals("不限")) {}
            }
            else
            {
              localObject = "";
            }
            b((String)localObject);
            bool2 = true;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("DetailProfileActivity", 2, "onHometownSelectResult: " + bool2);
            bool1 = bool2;
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              paramIntent = null;
            }
          }
        }
        else if (paramInt1 == 1002)
        {
          paramIntent = paramIntent.getStringArrayExtra("param_location");
          bool2 = bool4;
          if (!a(this.jdField_a_of_type_ArrayOfJavaLangString, paramIntent))
          {
            this.jdField_a_of_type_ArrayOfJavaLangString = paramIntent;
            this.jdField_d_of_type_Boolean = true;
          }
          try
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent);
            if (paramIntent != null)
            {
              localObject = paramIntent;
              if (!paramIntent.equals("不限")) {}
            }
            else
            {
              localObject = "";
            }
            a((String)localObject);
            bool2 = true;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("DetailProfileActivity", 2, "onLocationSelectResult: " + bool2);
            bool1 = bool2;
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              paramIntent = null;
            }
          }
        }
        else if (paramInt1 == 1004)
        {
          paramIntent = paramIntent.getStringExtra("result");
          bool1 = bool2;
          if (!paramIntent.equals(this.jdField_c_of_type_JavaLangString))
          {
            this.jdField_f_of_type_Boolean = true;
            c(paramIntent);
            bool1 = true;
          }
        }
        else if (paramInt1 == 1001)
        {
          paramInt1 = paramIntent.getIntExtra("param_id", -1);
          bool2 = bool5;
          if (this.jdField_i_of_type_Int != paramInt1)
          {
            this.jdField_c_of_type_Boolean = true;
            a(paramInt1);
            bool2 = true;
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("DetailProfileActivity", 2, "onJobSelectResult: " + paramInt1 + " changed: " + bool2);
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = bool2;
          if (paramInt1 == 1005)
          {
            if (paramIntent.hasExtra("param_interest_switch")) {
              this.z = paramIntent.getIntExtra("param_interest_switch", 0);
            }
            this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("param_interest_switch_changed", false);
            if (paramIntent.hasExtra("param_music_switch")) {
              this.A = paramIntent.getIntExtra("param_music_switch", 0);
            }
            this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("param_music_switch_changed", false);
            if (paramIntent.hasExtra("param_recent_activity_switch")) {
              this.B = paramIntent.getIntExtra("param_recent_activity_switch", 0);
            }
            this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("param_recent_activity_switch_changed", false);
            if (paramIntent.hasExtra("param_star_switch")) {
              this.C = paramIntent.getIntExtra("param_star_switch", 0);
            }
            this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("param_star_switch_changed", false);
            if (paramIntent.hasExtra("param_joined_group_switch")) {
              this.D = paramIntent.getIntExtra("param_joined_group_switch", 0);
            }
            this.m = paramIntent.getBooleanExtra("param_joined_group_switch_changed", false);
            if (paramIntent.hasExtra("param_ktv_switch")) {
              this.E = paramIntent.getIntExtra("param_ktv_switch", 0);
            }
            this.n = paramIntent.getBooleanExtra("param_ktv_switch_changed", false);
            if (paramIntent.hasExtra("param_eat_switch")) {
              this.F = paramIntent.getIntExtra("param_eat_switch", 0);
            }
            this.o = paramIntent.getBooleanExtra("param_eat_switch_changed", false);
            if ((!this.jdField_i_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && (!this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean) && (!this.m) && (!this.n))
            {
              bool1 = bool2;
              if (!this.o) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(57));
    c();
    this.app.a(new dtz(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131369650, 2131368634, 2131368225, new dul(this), new dub(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    }
    finish();
    overridePendingTransition(0, 2130968584);
    return false;
  }
  
  protected boolean onBackEvent2()
  {
    if (onBackEvent()) {
      finish();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, 2131367328, 0).b(getTitleBarHeight());
        return;
      }
      break;
    case 2131300348: 
      a();
      return;
    case 2131300350: 
    case 2131300352: 
      if (paramView.getId() == 2131300350) {
        this.jdField_g_of_type_Boolean = true;
      }
      for (;;)
      {
        paramView = new Intent(this, AgeSelectionActivity.class);
        paramView.putExtra("param_birthday", this.jdField_f_of_type_Int);
        startActivityForResult(paramView, 1000);
        return;
        this.jdField_h_of_type_Boolean = true;
      }
    case 2131300354: 
      paramView = new Intent(this, JobSelectionActivity.class);
      paramView.putExtra("param_id", this.jdField_i_of_type_Int);
      startActivityForResult(paramView, 1001);
      return;
    case 2131300361: 
      b(1);
      return;
    case 2131300363: 
      b(2);
      return;
    case 2131300367: 
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("title", 2131369643).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131369645).putExtra("multiLine", true).putExtra("current", this.jdField_c_of_type_JavaLangString).putExtra("key_title_style", 1).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
      startActivityForResult(paramView, 1004);
      return;
    case 2131300369: 
      paramView = new Intent(this, InterestSwitchEditActivity.class);
      if (-1 != this.F) {
        paramView.putExtra("param_eat_switch", this.F);
      }
      if (-1 != this.z) {
        paramView.putExtra("param_interest_switch", this.z);
      }
      if (-1 != this.D) {
        paramView.putExtra("param_joined_group_switch", this.D);
      }
      if (-1 != this.E) {
        paramView.putExtra("param_ktv_switch", this.E);
      }
      if (-1 != this.A) {
        paramView.putExtra("param_music_switch", this.A);
      }
      if (-1 != this.B) {
        paramView.putExtra("param_recent_activity_switch", this.B);
      }
      if (-1 != this.C) {
        paramView.putExtra("param_star_switch", this.C);
      }
      startActivityForResult(paramView, 1005);
      return;
    }
    if (this.jdField_d_of_type_Dum.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      if ((!TextUtils.isEmpty(paramView)) && (!SearchBaseActivity.a.matcher(paramView).matches()))
      {
        QQToast.a(this, "邮箱格式不正确", 0).b(getTitleBarHeight());
        return;
      }
    }
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Dum.jdField_b_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        break label999;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        localBundle.putByte("sex", this.jdField_a_of_type_Byte);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localBundle.putInt("birthday", this.jdField_f_of_type_Int);
        localBundle.putInt("age", this.jdField_g_of_type_Int);
        localBundle.putInt("key_constellation", this.jdField_h_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        localBundle.putInt("profession", this.jdField_i_of_type_Int);
      }
      if (this.jdField_b_of_type_Dum.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_Dum.jdField_b_of_type_Boolean) {
        localBundle.putString("college", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      }
      Object localObject;
      if (this.jdField_d_of_type_Boolean)
      {
        localBundle.putStringArray("location", this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putString("locationo_desc", this.jdField_f_of_type_AndroidWidgetTextView.getText().toString());
        localObject = null;
      }
      try
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putStringArray("location_name", paramView);
        if (this.jdField_e_of_type_Boolean)
        {
          localBundle.putStringArray("hometown", this.jdField_b_of_type_ArrayOfJavaLangString);
          localBundle.putString("hometown_desc", this.jdField_g_of_type_AndroidWidgetTextView.getText().toString());
        }
        if (this.jdField_d_of_type_Dum.jdField_b_of_type_Boolean) {
          localBundle.putString("email", this.jdField_d_of_type_AndroidWidgetEditText.getText().toString());
        }
        if (this.jdField_f_of_type_Boolean) {
          localBundle.putString("personalNote", this.jdField_c_of_type_JavaLangString);
        }
        if (this.jdField_i_of_type_Boolean) {
          localBundle.putShort("key_interest_switch", (short)this.z);
        }
        if (this.m) {
          localBundle.putShort("key_joined_group_switch", (short)this.D);
        }
        if (this.n) {
          localBundle.putShort("key_ktv_switch", (short)this.E);
        }
        if (this.jdField_j_of_type_Boolean) {
          localBundle.putShort("key_music_switch", (short)this.A);
        }
        if (this.jdField_k_of_type_Boolean) {
          localBundle.putShort("key_recent_activity_switch", (short)this.B);
        }
        if (this.jdField_l_of_type_Boolean) {
          localBundle.putShort("key_star_switch", (short)this.C);
        }
        if (this.o) {
          localBundle.putShort("key_eat_switch", (short)this.F);
        }
        if (localBundle.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(localBundle);
          a(3, getString(2131369646));
          return;
          label999:
          if (TextUtils.isEmpty(paramView.trim()))
          {
            QQToast.a(this, "昵称不可以为空", 0).b(getTitleBarHeight());
            return;
          }
          localBundle.putString("nick", paramView.trim());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("DetailProfileActivity", 2, "onClick", localException);
            paramView = localObject;
          }
        }
        finish();
        overridePendingTransition(0, 2130968584);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DetailProfileActivity
 * JD-Core Version:    0.7.0.1
 */