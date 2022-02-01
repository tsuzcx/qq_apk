package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import dht;
import dhu;
import dhv;
import friendlist.EAddFriendSourceID;
import java.io.UnsupportedEncodingException;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AutoRemarkActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final String a = "AutoRemarkActivity";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 1;
  public static final String b = "param_mode";
  public static final int c = 2;
  public static final String c = "param_return_addr";
  static final int jdField_d_of_type_Int = 0;
  public static final String d = "key_back_from_add_friend";
  public static final String e = "result_extra_direct_succeeded";
  private static final int i = 1000;
  private static final int j = 1001;
  private View jdField_a_of_type_AndroidViewView = null;
  public EditText a;
  public TextView a;
  public FriendListHandler a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dhu(this);
  public QQProgressDialog a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private dhv jdField_a_of_type_Dhv = new dhv(this, null);
  private View jdField_b_of_type_AndroidViewView = null;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private View c;
  private View jdField_d_of_type_AndroidViewView;
  public int e;
  int f;
  public String f;
  public int g;
  String g;
  public int h;
  
  public AutoRemarkActivity()
  {
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  private static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  public static String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int k = paramString.length();
      if ((k >= 2) && (Character.isHighSurrogate(paramString.charAt(k - 2)))) {
        paramString = paramString.substring(0, k - 2);
      } else {
        paramString = paramString.substring(0, k - 1);
      }
    }
    return paramString;
  }
  
  private void a(int paramInt)
  {
    if (this.e == 0)
    {
      paramInt = 2131367700;
      setTitle(paramInt);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131296784);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131296786);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296785));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296787));
      if (this.e != 0) {
        break label582;
      }
      paramInt = 2131366313;
      label71:
      setRightHighlightButton(paramInt, this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_g_of_type_Int));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("当前选中" + a(this.jdField_g_of_type_Int) + "分组, 双击进入修改分组界面");
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject = "";
      if (b())
      {
        String str = getIntent().getStringExtra("nick_name");
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("AutoRemarkActivity", 2, "initUI remark = " + str + ", source id=" + this.jdField_f_of_type_Int);
          localObject = str;
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject).length());
      }
      enableRightHighlight(true);
      if ((!EAddFriendSourceID.a(this.jdField_f_of_type_Int)) && (this.jdField_f_of_type_Int != 3016)) {
        break label589;
      }
    }
    label582:
    label589:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        this.c = findViewById(2131296788);
        this.c.setVisibility(0);
        findViewById(2131296792).setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131296789));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      if (this.e == 1)
      {
        this.d = findViewById(2131296790);
        this.d.setVisibility(0);
        findViewById(2131296792).setVisibility(0);
        ((TextView)findViewById(2131296792)).setText(2131369867);
        ((TextView)findViewById(2131296792)).setContentDescription(getString(2131369867));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131296791));
        this.d.setContentDescription("收起到不常联系好友 ");
        this.d.setFocusable(true);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new dht(this));
      }
      this.leftView.setContentDescription("返回" + this.leftView.getText().toString() + "界面");
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131366181) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
      if (paramInt == 0)
      {
        this.c.setFocusable(true);
        this.c.setContentDescription(getResources().getString(2131367696));
        findViewById(2131296792).setFocusable(true);
      }
      return;
      paramInt = 2131365750;
      break;
      paramInt = 2131367064;
      break label71;
    }
  }
  
  private boolean a()
  {
    return (!EAddFriendSourceID.a(this.jdField_f_of_type_Int)) && (this.jdField_f_of_type_Int != 3016) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.equals(String.valueOf(0L)));
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = FriendSystemMsgController.a().b();
    structmsg.StructMsg localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    int m;
    long l2;
    int n;
    int i1;
    int i2;
    int i3;
    Object localObject2;
    int k;
    Object localObject1;
    if (localStructMsg != null)
    {
      m = localStructMsg.msg_type.get();
      l1 = localStructMsg.msg_seq.get();
      l2 = localStructMsg.req_uin.get();
      n = localStructMsg.msg.sub_type.get();
      i1 = localStructMsg.msg.src_id.get();
      i2 = localStructMsg.msg.sub_src_id.get();
      i3 = localStructMsg.msg.group_msg_type.get();
      localObject2 = localStructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject2).size())
        {
          k = this.jdField_g_of_type_Int;
          localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (localObject1 != null) {
            break label381;
          }
          localObject1 = "";
        }
      }
    }
    label376:
    label381:
    for (;;)
    {
      localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject2).remark.set((String)localObject1);
      ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(k);
      localObject1 = new structmsg.AddFrdSNInfo();
      PBUInt32Field localPBUInt32Field = ((structmsg.AddFrdSNInfo)localObject1).uint32_not_see_dynamic;
      if (this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked())
      {
        k = 1;
        localPBUInt32Field.set(k);
        localPBUInt32Field = ((structmsg.AddFrdSNInfo)localObject1).uint32_set_sn;
        if (!this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          break label376;
        }
      }
      for (k = 1;; k = 0)
      {
        localPBUInt32Field.set(k);
        ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set((MessageMicro)localObject1);
        this.app.a().a().a(m, l1, l2, n, i1, i2, i3, (structmsg.SystemMsgActionInfo)localObject2, paramInt, localStructMsg, this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked());
        if (this.jdField_b_of_type_ComTencentWidgetSwitch.isChecked()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
        bool1 = true;
        return bool1;
        k = 0;
        break;
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {}
    while ((paramInt1 == 100) && (!paramBoolean)) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366988);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      Intent localIntent = getIntent();
      int m = localIntent.getIntExtra("friend_setting", 0);
      int k = m;
      if (m == 3) {
        k = 100;
      }
      m = localIntent.getIntExtra("source_id", 10004);
      boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
      String str = localIntent.getStringExtra("src_name");
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, localIntent.getStringExtra("extra"), k, (byte)this.jdField_g_of_type_Int, localIntent.getStringExtra("msg"), m, localIntent.getIntExtra("sub_source_id", 0), true, localIntent.getByteArrayExtra("sig"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), str);
      if (!a(k, m, bool)) {
        ((FriendManager)this.app.getManager(8)).a(this.jdField_f_of_type_JavaLangString, true);
      }
      return;
    }
    QQToast.a(this.app.a(), 1, getString(2131367136), 0).b(getTitleBarHeight());
  }
  
  private boolean b()
  {
    return (EAddFriendSourceID.a(this.jdField_f_of_type_Int)) || (this.jdField_f_of_type_Int == 3016) || (this.jdField_f_of_type_Int == 3003);
  }
  
  private void c()
  {
    if (NetworkUtil.e(this))
    {
      if (a(0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366988);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    QQToast.a(this.app.a(), 1, getString(2131367136), 0).b(getTitleBarHeight());
  }
  
  private void d()
  {
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366988);
      Intent localIntent = getIntent();
      long l1 = localIntent.getLongExtra("lToMobile", 0L);
      byte[] arrayOfByte = localIntent.getByteArrayExtra("sig");
      String str = localIntent.getStringExtra("nick_name");
      long l2 = localIntent.getLongExtra("infotime", 0L);
      long l3 = localIntent.getLongExtra("db_id", 0L);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(0, Long.parseLong(this.jdField_f_of_type_JavaLangString), l1, arrayOfByte, (byte)this.jdField_g_of_type_Int, str, l2, l3);
      return;
    }
    QQToast.a(this.app.a(), 1, getString(2131367136), 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {}
    while (((FriendManager)this.app.getManager(8)).a(this.jdField_f_of_type_JavaLangString) != null) {
      return;
    }
    QQAppInterface localQQAppInterface1 = this.app;
    QQAppInterface localQQAppInterface2 = this.app;
    ((FriendListHandler)localQQAppInterface1.a(1)).b(this.jdField_f_of_type_JavaLangString);
  }
  
  public String a(int paramInt)
  {
    Groups localGroups = ((FriendManager)this.app.getManager(8)).a(paramInt + "");
    if (localGroups != null) {
      return localGroups.group_name;
    }
    return "";
  }
  
  public void a()
  {
    String str = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + str);
    }
    if (str != null) {
      try
      {
        setResult(-1);
        finish();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "goBack | exception = ", localException);
        }
        localException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    setResult(-1);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (a(paramEditable) > 32)
    {
      int k = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      paramEditable = a(paramEditable);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
      if (k >= paramEditable.length()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
      }
    }
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131366181) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1000: 
      paramIntent = paramIntent.getStringExtra("result");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramInt1));
    this.jdField_b_of_type_AndroidViewView.setContentDescription("当前选中" + a(paramInt1) + "分组, 双击进入修改分组界面");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903090);
    setContentBackgroundResource(2130837687);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    Intent localIntent = getIntent();
    this.e = localIntent.getIntExtra("param_mode", 0);
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_f_of_type_Int = getIntent().getIntExtra("source_id", 10004);
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("src_name");
    a(this.jdField_f_of_type_Int);
    this.app.a(this.jdField_a_of_type_Dhv);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    if (((paramBundle == null) || (this.e == 1)) && (NetworkUtil.e(this)) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, getIntent().getIntExtra("source_id", 10004), getIntent().getIntExtra("sub_source_id", 0));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366594);
    }
    e();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_Dhv);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this.app.a(), 1, getString(2131367136), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        return;
      }
    }
    this.c.setContentDescription(getResources().getString(2131367696));
    paramCompoundButton = new Intent("com.tencent.qzone.action.OperateQZonePermission");
    paramCompoundButton.putExtra("qzone_permission_uin", this.jdField_f_of_type_JavaLangString);
    paramCompoundButton.putExtra("qzone_permission_operateType", 1);
    paramCompoundButton.putExtra("qzone_permission_value", paramBoolean);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.d = "QQ空间";
    localPluginParams.b = QzonePluginProxyActivity.a();
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.a();
    localPluginParams.e = "com.qzone.permissionsetting.business.QZonePermissionReciver";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramCompoundButton;
    IPluginManager.a(this.app.a(), localPluginParams);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("title", 2131367695).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("hint", getResources().getString(2131367699)).putExtra("multiLine", false);
      if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)) {
        paramView.putExtra("current", this.jdField_a_of_type_AndroidWidgetEditText.getText());
      }
      startActivityForResult(paramView, 1000);
    }
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidViewView)
      {
        paramView = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_g_of_type_Int);
        paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
        startActivityForResult(paramView, 1001);
        return;
      }
      if (paramView == this.c)
      {
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.app.a();
        paramView.b = this.app.c();
        paramView.c = this.app.getSid();
        QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue(), -1);
        return;
      }
      if (this.e == 0)
      {
        b();
        return;
      }
      if (this.e == 1)
      {
        c();
        return;
      }
    } while (this.e != 2);
    d();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */