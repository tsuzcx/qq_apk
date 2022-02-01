package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigHandler;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import emq;
import ems;
import emt;
import emu;
import emv;
import emw;
import emx;
import emy;
import emz;
import ena;
import enb;
import enc;
import end;
import ene;
import enf;
import eng;
import enh;
import eni;
import enk;
import enl;
import enm;
import enn;
import eno;
import enp;
import enq;
import ent;
import mqq.app.Constants.LogoutReason;
import org.json.JSONObject;

public class NotificationActivity
  extends BaseActivity
{
  public static final int a = 0;
  public static NotificationActivity a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  private static final String e = "sec_sig_tag";
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new enm(this);
  public String a;
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b = null;
  private String c = null;
  private String d = "";
  private int l;
  private int m;
  private final int n = 1;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
  }
  
  public NotificationActivity()
  {
    this.jdField_a_of_type_JavaLangString = "https://fwd.z.qq.com:8080/forward.jsp?bid=906";
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903387);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131298061);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131298060);
    localObject = (TextView)((Window)localObject).findViewById(2131298055);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131367562) + "5.9.3" + getString(2131367563));
    localButton1.setOnClickListener(new eni(this));
    localButton2.setOnClickListener(new enk(this));
    return localAlertDialog;
  }
  
  private void a(int paramInt)
  {
    int i2 = 1;
    int i1 = -1;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    int i3;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing()))
        {
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131366446)).setMessage(getString(2131366448)).setPositiveButton(2131366212, new eno(this)).setNegativeButton(2131367132, new enn(this));
        continue;
        this.b = getString(2131366447);
        this.c = getString(2131366449);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new enp(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131623938));
        localTextView.setTextColor(getResources().getColor(2131427355));
        if ((this.b != null) && (this.b.equals("true"))) {}
        for (;;)
        {
          try
          {
            String str1 = getPackageName();
            localTextView.setText(this.c);
            this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.c).addView(localTextView).setPositiveButton(2131369617, new enq(this, str1), false);
            paramInt = i2;
            if (paramInt != 0) {
              break;
            }
            localTextView.setText(2131365945);
            this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.c).addView(localTextView).setPositiveButton(2131366212, new ent(this));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          paramInt = 0;
        }
        try
        {
          this.jdField_a_of_type_AndroidAppDialog = a();
        }
        catch (Exception localException1)
        {
          a();
        }
      }
    case 5: 
      if (QQPlayerService.a()) {
        sendBroadcast(new Intent("qqplayer_exit_action"));
      }
      paramInt = 2131365737;
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
        paramInt = 2131368848;
      }
      if (this.c != null)
      {
        i3 = this.c.indexOf("https://110.qq.com/");
        i2 = i3;
        if (i3 > 0) {
          i1 = "https://110.qq.com/".length() + i3;
        }
      }
      break;
    }
    for (i2 = i3;; i2 = -1)
    {
      if (this.c != null) {}
      for (Object localObject1 = this.c;; localObject1 = "")
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        if ((i2 > 0) && (i1 > i2)) {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131427448)), i2, i1, 33);
        }
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage((CharSequence)localObject1).setNegativeButton(paramInt, new ems(this));
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.kicked) {
          break;
        }
        ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131365962, new emt(this));
        break;
      }
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new emu(this));
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new emv(this));
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131367653)).setMessage(getString(2131367656)).setPositiveButton(getString(2131367654), new emx(this)).setNegativeButton(getString(2131367655), new emw(this));
      break;
      if (this.m == 40)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), 231, getString(2131368834), this.c, 2131368833, 2131368832, new emy(this), new emz(this));
        break;
      }
      switch (this.m)
      {
      default: 
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.b(this, 230).setMessageWithUrl(this.c).setTitle(getString(2131366511)).setPositiveButton(17039370, new end(this));
        break;
      case 41: 
      case 116: 
        if (this.m == 41) {}
        for (localObject1 = getString(2131367657);; localObject1 = getString(2131367658))
        {
          str2 = getString(2131367667);
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage((CharSequence)localObject1).setTitle(str2).setNegativeButton(2131367659, new enb(this)).setPositiveButton(2131367660, new ena(this));
          break;
        }
        Object localObject2 = getIntent().getExtras();
        localObject1 = ((Bundle)localObject2).getString("dlg_title");
        String str2 = ((Bundle)localObject2).getString("dlg_content");
        String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
        String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
        localObject2 = ((Bundle)localObject2).getString("dlg_url");
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new enf(this, (String)localObject2)).setNegativeButton(str3, new ene(this));
        break;
        localObject1 = getResources().getString(2131369266);
        str2 = getResources().getString(2131369267);
        str3 = getResources().getString(2131369270);
        str4 = getResources().getString(2131369269);
        Object localObject3 = getResources().getString(2131369268);
        localObject2 = new CheckBox(this);
        ((CheckBox)localObject2).setText((CharSequence)localObject3);
        ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131623938));
        ((CheckBox)localObject2).setTextColor(getResources().getColor(2131427355));
        localObject3 = this.app.a().getSharedPreferences(this.app.getAccount(), 0);
        boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
        ((CheckBox)localObject2).setChecked(bool);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new enh(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new eng(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
        break;
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    if (localIntent != null)
    {
      localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
      this.app.a().sendBroadcast(localIntent);
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 41) && (paramInt != 116)) {
      return;
    }
    Object localObject;
    Intent localIntent;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      localObject = "https://haoma.qq.com/m/expire.html?num=" + this.d;
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      startActivity(localIntent);
      finish();
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("unit", "月");
        ((JSONObject)localObject).put("userId", this.d);
        ((JSONObject)localObject).put("openMonth", "3");
        ((JSONObject)localObject).put("offerId", "1450000833");
        ((JSONObject)localObject).put("aid", "mvip.gongneng.android.haoma_03");
        ((JSONObject)localObject).put("ticketValue", SecUtil.a(this.jdField_a_of_type_ArrayOfByte));
        ((JSONObject)localObject).put("ticketName", "vask_27");
        switch (paramInt)
        {
        case 41: 
          localIntent = new Intent(this, PayBridgeActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localIntent.putExtras(localBundle);
          localIntent.putExtra("payparmas_from_is_login_state", false);
          localIntent.putExtra("pay_requestcode", 4);
          startActivityForResult(localIntent, 1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        finish();
        return;
      }
      localException.put("serviceCode", "LTMCLUB");
      localException.put("serviceName", "QQ会员");
      continue;
      localException.put("serviceCode", "CJCLUBT");
      localException.put("serviceName", "QQ超级会员");
    }
  }
  
  private void c()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.a(4);
    if (localConfigHandler != null) {
      localConfigHandler.a();
    }
  }
  
  public void a()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.b(false);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903386);
    this.l = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramBundle))
    {
      this.l = 1;
      c();
    }
    for (;;)
    {
      this.b = getIntent().getStringExtra("title");
      this.c = getIntent().getStringExtra("msg");
      this.d = getIntent().getStringExtra("loginalias");
      this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("expiredSig");
      this.m = getIntent().getIntExtra("loginret", 0);
      this.jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.codeToEnum(getIntent().getIntExtra("reason", 0));
      Object localObject = getIntent().getStringExtra("securityScan");
      if ((localObject != null) && ("security_scan".equals(localObject))) {
        this.l = 7;
      }
      if (("mqq.intent.action.ACCOUNT_KICKED".equals(paramBundle)) && (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.secKicked))
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
          if (!paramBundle.has())
          {
            return false;
            if ("mqq.intent.action.ACCOUNT_TIPS".equals(paramBundle))
            {
              this.l = 6;
              continue;
            }
            if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramBundle))
            {
              b();
              c();
              this.l = 5;
              continue;
            }
            if ("mqq.intent.action.GRAY".equals(paramBundle))
            {
              this.l = 2;
              continue;
            }
            if (!"mqq.intent.action.SUSPEND".equals(paramBundle)) {
              continue;
            }
            this.l = 4;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          do
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            if ((paramBundle.str_left_button.has()) && (paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
          return false;
          SecSigHandler.a(paramBundle.u32_check_result.get());
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(paramBundle.str_right_button.get(), new enl(this, paramBundle)).setNegativeButton(paramBundle.str_left_button.get(), new enc(this));
          if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing()))
          {
            this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
            this.jdField_a_of_type_AndroidAppDialog.show();
          }
          return true;
        }
      }
    }
    a(this.l);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return false;
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131369618, new emq(this));
    }
  }
  
  protected void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.l == 3) {
      a();
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    super.finish();
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */