package com.tencent.biz.troop;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cnq;
import cnr;
import cns;
import cnt;
import cnu;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class EditUniqueTitleActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "from";
  public static final int b = 1;
  public static final String b = "memberUin";
  public static final int c = 2;
  public static final String c = "troopUin";
  public static final String d = "memberRole";
  public static final String e = "uniqueTitle";
  public static final String f = "uniqueTitleExpire";
  private static final String jdField_g_of_type_JavaLangString = "EditUniqueTitleActivity";
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new cnr(this);
  protected View a;
  public EditText a;
  public ImageButton a;
  public TextView a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected TextView b;
  private final int d = 6;
  private int e = 0;
  private int f;
  private int jdField_g_of_type_Int;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private String i;
  private String j;
  private String k;
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    paramContext = new Intent(paramContext, EditUniqueTitleActivity.class);
    paramContext.putExtra("from", String.valueOf(paramInt1));
    paramContext.putExtra("memberUin", paramString2);
    paramContext.putExtra("troopUin", paramString1);
    paramContext.putExtra("memberRole", paramInt2);
    paramContext.putExtra("uniqueTitle", paramString3);
    paramContext.putExtra("uniqueTitleExpire", String.valueOf(paramInt3));
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    if (this.e != 2) {
      b();
    }
    if (paramInt == 0)
    {
      TroopManager localTroopManager = (TroopManager)this.app.getManager(50);
      localTroopManager.a(this.i, this.jdField_h_of_type_JavaLangString, false);
      localTroopManager.a(this.i, this.jdField_h_of_type_JavaLangString, this.k, this.jdField_h_of_type_Int);
      if (this.e == 2) {
        QQToast.a(this, getResources().getString(2131363998), 1).a();
      }
      setResult(-1, getIntent());
      finish();
      ((TroopHandler)this.app.a(19)).a(62, true, new Object[] { this.i, this.jdField_h_of_type_JavaLangString, this.k, Integer.valueOf(this.jdField_h_of_type_Int) });
    }
    for (;;)
    {
      return;
      if (this.e == 2)
      {
        setResult(0, getIntent());
        finish();
        QQToast.a(this, getResources().getString(2131364006), 1).a();
      }
      while (QLog.isColorLevel())
      {
        QLog.w("EditUniqueTitleActivity", 2, "set failed: " + paramInt);
        return;
        if (paramInt == 1281) {
          QQToast.a(this, getResources().getString(2131364004), 1).a();
        } else {
          QQToast.a(this, getResources().getString(2131363999), 1).a();
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
    Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
    Object localObject = (TroopManager)paramQQAppInterface.getManager(50);
    try
    {
      localObject = ((TroopManager)localObject).c(paramString1, paramString2);
      localReqBody.uint64_group_code.set(Long.parseLong(paramString1));
      localMemberInfo.uint64_uin.set(Long.parseLong(paramString2));
      localMemberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8((String)localObject));
      if (paramString3 != null) {
        localMemberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(paramString3));
      }
      localMemberInfo.uint32_special_title_expire_time.set(paramInt);
      localReqBody.rpt_mem_level_info.add(localMemberInfo);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2300);
      paramString1.uint32_service_type.set(2);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = new NewIntent(paramQQAppInterface.a(), ProtoServlet.class);
      paramString2.putExtra("cmd", "OidbSvc.0x8fc_2");
      paramString2.putExtra("data", paramString1.toByteArray());
      paramString2.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.e != 2) {
      a();
    }
    a(this.app, paramString1, paramString2, paramString3, paramInt, new cnu(this));
  }
  
  private boolean a()
  {
    boolean bool = true;
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.e = Integer.parseInt(localIntent.getStringExtra("from"));
        this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("memberUin");
        this.i = localIntent.getStringExtra("troopUin");
        this.f = localIntent.getIntExtra("memberRole", 1);
        this.j = localIntent.getStringExtra("uniqueTitle");
        this.g = Integer.parseInt(localIntent.getStringExtra("uniqueTitleExpire"));
        if (this.e == 2)
        {
          c();
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.i, "", "", "");
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return false;
  }
  
  private void c()
  {
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.app.getManager(50)).a(this.i, this.jdField_h_of_type_JavaLangString);
    if ((this.j != null) && (this.j.equals(localTroopMemberInfo.mUniqueTitle)))
    {
      if (localTroopMemberInfo.mUniqueTitleExpire == -1)
      {
        QQToast.a(this, getResources().getString(2131364002), 1).a();
        setResult(0, getIntent());
        finish();
        return;
      }
      if (localTroopMemberInfo.mUniqueTitleExpire != this.g)
      {
        QQToast.a(this, getResources().getString(2131364005), 1).a();
        setResult(0, getIntent());
        finish();
        return;
      }
      if (this.g - NetConnInfoCenter.getServerTime() <= 0L)
      {
        QQToast.a(this, getResources().getString(2131364003), 1).a();
        setResult(0, getIntent());
        finish();
        return;
      }
      long l = NetConnInfoCenter.getServerTime();
      this.k = this.j;
      this.jdField_h_of_type_Int = ((int)l + 2592000);
      a(this.i, this.jdField_h_of_type_JavaLangString, null, this.jdField_h_of_type_Int);
      return;
    }
    QQToast.a(this, getResources().getString(2131364003), 1).a();
    setResult(0, getIntent());
    finish();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131427975));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0/6");
    if (TextUtils.isEmpty(this.j)) {
      if (this.f == 2) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131365819));
      }
    }
    label168:
    label255:
    do
    {
      break label168;
      String str;
      if (this.f == 2)
      {
        str = getString(2131365819);
        if ((TextUtils.isEmpty(this.j)) || (str.equals(this.j))) {
          this.g = -1;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
        if (this.g != -1) {
          break label255;
        }
        this.b.setText(getResources().getString(2131363997) + getResources().getString(2131363996));
        return;
        if (this.f != 3) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText(getString(2131365820));
        break;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.j);
        break;
        if (this.f == 3)
        {
          str = getString(2131365820);
          if ((TextUtils.isEmpty(this.j)) || (str.equals(this.j))) {
            this.g = -1;
          }
        }
      }
      if (this.g == 0)
      {
        this.b.setVisibility(4);
        return;
      }
    } while (this.g <= NetConnInfoCenter.getServerTime());
    long l2 = (this.g - NetConnInfoCenter.getServerTime()) / 86400L + 1L;
    long l1 = l2;
    if (l2 > 30L) {
      l1 = 30L;
    }
    this.b.setText(getResources().getString(2131363997) + l1 + getResources().getString(2131363805));
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    this.k = str;
    this.jdField_h_of_type_Int = 0;
    switch (this.f)
    {
    default: 
      return;
    case 2: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131365819))))
      {
        f();
        return;
      }
      this.k = "";
      a(this.i, this.jdField_h_of_type_JavaLangString, this.k, this.jdField_h_of_type_Int);
      return;
    case 3: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131365820))))
      {
        this.jdField_h_of_type_Int = -1;
        a(this.i, this.jdField_h_of_type_JavaLangString, this.k, this.jdField_h_of_type_Int);
        return;
      }
      this.k = "";
      a(this.i, this.jdField_h_of_type_JavaLangString, this.k, this.jdField_h_of_type_Int);
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      f();
      return;
    }
    this.k = "";
    a(this.i, this.jdField_h_of_type_JavaLangString, this.k, this.jdField_h_of_type_Int);
  }
  
  private void f()
  {
    getString(2131363995);
    getString(2131363996);
    getString(2131365736);
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    cns localcns = new cns(this, localAlertDialog);
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2130903053, null);
    localViewGroup.setBackgroundColor(0);
    LinearLayout localLinearLayout = (LinearLayout)localViewGroup.findViewById(2131296638);
    View localView = LayoutInflater.from(this).inflate(2130903062, null);
    localView.setBackgroundDrawable(getResources().getDrawable(2130837534));
    localView.setOnClickListener(new cnt(this));
    TextView localTextView = (TextView)localView.findViewById(2131296646);
    localTextView.setVisibility(0);
    localTextView.setText(2131363994);
    localTextView.setContentDescription(getString(2131363994));
    localLinearLayout.addView(localView, 0);
    localView = LayoutInflater.from(this).inflate(2130903056, null);
    localTextView = (TextView)localView.findViewById(2131296640);
    localTextView.setText(2131363995);
    localTextView.setContentDescription(getString(2131363995) + "按钮");
    localTextView.setTextColor(getResources().getColor(2131427482));
    localView.setBackgroundDrawable(getResources().getDrawable(2130837527));
    localView.setId(0);
    localView.setOnClickListener(localcns);
    localLinearLayout.addView(localView);
    localView = LayoutInflater.from(this).inflate(2130903056, null);
    localTextView = (TextView)localView.findViewById(2131296640);
    localTextView.setText(2131363996);
    localTextView.setContentDescription(getString(2131363996) + "按钮");
    localTextView.setTextColor(getResources().getColor(2131427482));
    localView.setBackgroundDrawable(getResources().getDrawable(2130837527));
    localView.setId(1);
    localView.setOnClickListener(localcns);
    localLinearLayout.addView(localView);
    localView = LayoutInflater.from(this).inflate(2130903056, null);
    localTextView = (TextView)localView.findViewById(2131296640);
    localTextView.setText(2131365736);
    localTextView.setContentDescription(getString(2131365736) + "按钮");
    localTextView.setTextColor(getResources().getColor(2131427482));
    localView.setBackgroundDrawable(getResources().getDrawable(2130837524));
    localView.setId(2);
    localView.setOnClickListener(localcns);
    localLinearLayout.addView(localView);
    localAlertDialog.show();
    localAlertDialog.setContentView(localViewGroup);
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_valid", 0, 0, this.i, "", "", "");
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  public void b()
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
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2130903692);
    setTitle(2131363988);
    setLeftButton(2131365736, new cnq(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299332));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299333));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299334));
    this.b = ((TextView)findViewById(2131299335));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    setRightHighlightButton(2131367064, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299336);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.f == 2)
    {
      paramBundle = getString(2131365819);
      if ((!TextUtils.isEmpty(this.j)) && (!paramBundle.equals(this.j)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.i, "", "", "");
      }
    }
    for (;;)
    {
      d();
      return false;
      if (this.f == 3)
      {
        paramBundle = getString(2131365820);
        if ((!TextUtils.isEmpty(this.j)) && (!paramBundle.equals(this.j)))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.i, "", "", "");
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299333: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    case 2131297360: 
      e();
      return;
    }
    this.k = "";
    this.jdField_h_of_type_Int = -1;
    a(this.i, this.jdField_h_of_type_JavaLangString, this.k, this.jdField_h_of_type_Int);
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.i, "0", "0", "0");
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.i, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity
 * JD-Core Version:    0.7.0.1
 */