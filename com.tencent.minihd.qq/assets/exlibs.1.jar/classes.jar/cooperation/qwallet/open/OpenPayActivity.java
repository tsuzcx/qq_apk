package cooperation.qwallet.open;

import VIP.BaseInfo;
import VIP.ReqCheckPayAuth;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletOpenHandler;
import com.tencent.mobileqq.app.QWalletOpenObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.security.MessageDigest;
import mac;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenPayActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "extra.key.pay.type";
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final int b = 1;
  public static final String b = "extra.key.pay.from";
  public static final int c = 2;
  public static final String c = "1";
  public static final String d = "0";
  private static final String jdField_e_of_type_JavaLangString = "Q.qwallet.open.OpenPayActivity";
  public Bundle a;
  private QWalletOpenHandler jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler;
  private QWalletOpenObserver jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver;
  protected QWalletPayProgressDialog a;
  private mac jdField_a_of_type_Mac;
  private int d;
  private int jdField_e_of_type_Int;
  
  public OpenPayActivity()
  {
    this.jdField_d_of_type_Int = -1;
    this.e = -1;
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private String a()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.a());
    }
    return "";
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
      localStringBuilder.append(':');
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver.a();
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver);
    }
    if (this.jdField_a_of_type_Mac != null) {
      this.jdField_a_of_type_Mac.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver = null;
    this.jdField_a_of_type_Mac = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler = null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog != null) {
        this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    while ((this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
  }
  
  private void b(Bundle paramBundle)
  {
    Object localObject3 = paramBundle.getString("appId");
    String str4 = paramBundle.getString("nonce");
    long l = paramBundle.getLong("timeStamp");
    String str5 = paramBundle.getString("sig");
    String str6 = paramBundle.getString("sigType");
    Object localObject1 = paramBundle.getString("tokenId");
    String str1 = paramBundle.getString("pubAcc");
    Object localObject4 = paramBundle.getString("bargainorId");
    String str7 = paramBundle.getString("qVersion");
    String str3 = paramBundle.getString("domain");
    String str2 = paramBundle.getString("packageName");
    paramBundle = paramBundle.getString("callbackScheme");
    if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str6)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4)))
    {
      a(-1007, "Parameters error.", null, null);
      return;
    }
    if ((this.e == 2) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(paramBundle))))
    {
      a(-1009, "Parameters error.", null, null);
      return;
    }
    a(true);
    paramBundle = new BaseInfo();
    paramBundle.appId = ((String)localObject3);
    paramBundle.nonce = str4;
    paramBundle.timeStamp = l;
    paramBundle.sig = str5;
    paramBundle.sigType = str6;
    paramBundle.qVersion = str7;
    paramBundle.phoneModel = Build.MODEL;
    paramBundle.phoneOS = "android";
    localObject3 = new ReqCheckPayAuth();
    ((ReqCheckPayAuth)localObject3).baseInfo = paramBundle;
    ((ReqCheckPayAuth)localObject3).tokenId = ((String)localObject1);
    ((ReqCheckPayAuth)localObject3).pubAcc = str1;
    ((ReqCheckPayAuth)localObject3).bargainorId = ((String)localObject4);
    if (this.e == 1)
    {
      ((ReqCheckPayAuth)localObject3).payFrom = 1;
      ((ReqCheckPayAuth)localObject3).p1 = str3;
      ((ReqCheckPayAuth)localObject3).p2 = "";
      ((ReqCheckPayAuth)localObject3).p3 = "";
      a();
      this.jdField_a_of_type_Mac = new mac(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver = new QWalletOpenObserver(this.jdField_a_of_type_Mac);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler = ((QWalletOpenHandler)this.app.a(32));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler.a((ReqCheckPayAuth)localObject3);
      return;
    }
    str1 = "";
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getPackageInfo(str2, 64);
        paramBundle = ((PackageInfo)localObject1).versionName;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = ((PackageInfo)localObject1).signatures;
          localObject4 = MessageDigest.getInstance("SHA1");
          ((MessageDigest)localObject4).reset();
          ((MessageDigest)localObject4).update(localObject1[0].toByteArray());
          localObject1 = a(((MessageDigest)localObject4).digest());
          ((ReqCheckPayAuth)localObject3).payFrom = 2;
          ((ReqCheckPayAuth)localObject3).p1 = str2;
          ((ReqCheckPayAuth)localObject3).p2 = paramBundle;
          ((ReqCheckPayAuth)localObject3).p3 = ((String)localObject1);
        }
        catch (Exception localException2)
        {
          Object localObject2;
          break label488;
        }
        localException1 = localException1;
        paramBundle = "";
      }
      label488:
      localException1.printStackTrace();
      localObject2 = str1;
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.e != 2)
    {
      super.finish();
      return;
    }
    Object localObject = new PayResponse();
    ((PayResponse)localObject).jdField_d_of_type_Int = 1;
    ((PayResponse)localObject).b = "pay";
    ((PayResponse)localObject).i = paramBundle.getString("callbackSn");
    ((PayResponse)localObject).jdField_c_of_type_Int = paramBundle.getInt("retCode");
    ((PayResponse)localObject).a = paramBundle.getString("retMsg");
    if (((PayResponse)localObject).a())
    {
      ((PayResponse)localObject).jdField_c_of_type_JavaLangString = paramBundle.getString("payChannelType");
      ((PayResponse)localObject).jdField_d_of_type_JavaLangString = paramBundle.getString("transactionId");
      ((PayResponse)localObject).e = paramBundle.getString("payTime");
      ((PayResponse)localObject).f = paramBundle.getString("totalFee");
      ((PayResponse)localObject).g = paramBundle.getString("callbackUrl");
      ((PayResponse)localObject).h = paramBundle.getString("spData");
    }
    paramBundle = new Bundle();
    ((PayResponse)localObject).a(paramBundle);
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString("packageName");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("callbackScheme");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      super.finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str + "://open_pay/pay"));
    localIntent.setPackage((String)localObject);
    localIntent.addFlags(268435456);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("com_tencent_mobileqq_open_pay", "com.tencent.mobileqq.open.pay");
    try
    {
      super.startActivity(localIntent);
      super.finish();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.open.OpenPayActivity", 2, "doAppCashPayResult error:" + paramBundle.getMessage());
        } else if (QLog.isDevelopLevel()) {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  private void d(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(false);
    String str1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("callbackSn");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", paramInt);
    localBundle.putString("retMsg", paramString1);
    localBundle.putString("callbackSn", str1);
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      String str2;
      try
      {
        localObject = new JSONObject(paramString2);
        if (((JSONObject)localObject).has("transaction_id"))
        {
          paramString1 = ((JSONObject)localObject).getString("transaction_id");
          if (!((JSONObject)localObject).has("pay_time")) {
            break label424;
          }
          paramString2 = ((JSONObject)localObject).getString("pay_time");
          if (!((JSONObject)localObject).has("total_fee")) {
            break label430;
          }
          paramString3 = ((JSONObject)localObject).getString("total_fee");
          if (!((JSONObject)localObject).has("callback_url")) {
            break label437;
          }
          str1 = ((JSONObject)localObject).getString("callback_url");
          if (!((JSONObject)localObject).has("sp_data")) {
            break label444;
          }
          str2 = ((JSONObject)localObject).getString("sp_data");
          if (!((JSONObject)localObject).has("iswechatpay")) {
            continue;
          }
          localObject = ((JSONObject)localObject).getString("iswechatpay");
          String str4 = "0";
          String str3 = str4;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            str3 = str4;
            if ("1".compareTo((String)localObject) == 0) {
              str3 = "1";
            }
          }
          localBundle.putString("payChannelType", str3);
          localBundle.putString("transactionId", paramString1);
          localBundle.putString("payTime", paramString2);
          localBundle.putString("totalFee", paramString3);
          localBundle.putString("callbackUrl", str1);
          localBundle.putString("spData", str2);
          localBundle.putString("tokenId", "");
        }
      }
      catch (JSONException paramString1)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qwallet.open.OpenPayActivity", 2, "doCashPayResult error:" + paramString1.getMessage());
          continue;
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramString1.printStackTrace();
        continue;
        d(localBundle);
        return;
      }
      switch (this.e)
      {
      default: 
        super.finish();
        return;
        paramString1 = "";
        continue;
        localObject = "0";
        break;
      case 1: 
      case 2: 
        c(localBundle);
        return;
        label424:
        paramString2 = "";
        continue;
        label430:
        paramString3 = "";
        continue;
        label437:
        str1 = "";
        continue;
        label444:
        str2 = "";
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("callbackSn");
    String str3 = this.app.a();
    String str4 = this.app.c();
    String str5 = paramBundle.getString("tokenId");
    String str6 = paramBundle.getString("bargainorId");
    String str7 = paramBundle.getString("appId");
    if (this.e == 2) {}
    for (String str1 = "thirdpartapp";; str1 = "thirdpartweb")
    {
      str1 = "appid#" + str7 + "|bargainor_id#" + str6 + "|channel#" + str1;
      str6 = paramBundle.getString("pubAcc");
      paramBundle = paramBundle.getString("pubAccHint");
      str7 = a();
      Bundle localBundle = new Bundle();
      localBundle.putString("callbackSn", str2);
      localBundle.putString("skey", str7);
      localBundle.putString("skey_type", "2");
      localBundle.putString("tokenId", str5);
      localBundle.putString("userId", str3);
      localBundle.putString("userName", str4);
      localBundle.putInt("comeForm", 4);
      localBundle.putString("appInfo", str1);
      if ((str6 != null) && (str6.length() > 0) && (paramBundle != null) && (paramBundle.length() > 0) && (!PublicAccountUtil.a(this.app, str6)))
      {
        localBundle.putString("pubAcc", str6);
        localBundle.putString("pubAccHint", paramBundle);
      }
      localBundle.putInt("PayInvokerId", 9);
      QWalletPayBridge.a(this, this.app, localBundle, this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.open.OpenPayActivity", 2, "onActivityResult request=" + paramInt1 + " result=" + paramInt2);
    }
    if (((paramIntent != null) && (paramInt1 == 3001)) || ((paramInt2 == -1) && (paramIntent.getIntExtra("PayInvokerId", -1) != 9)))
    {
      a(-1003, "PayResult parameters error.", null, null);
      return;
    }
    paramInt1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str1 = paramIntent.getStringExtra("callbackSn");
    Object localObject = paramIntent.getStringExtra("result");
    boolean bool = paramIntent.getBooleanExtra("isChoosePubAcc", false);
    String str2 = paramIntent.getStringExtra("pubAcc");
    paramIntent = paramIntent.getStringExtra("upload_data");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (paramInt1 != 1))
    {
      a(-1004, "PayResult parameters error.", null, str1);
      return;
    }
    if ((paramIntent != null) && (paramIntent.length() > 0)) {
      PayBridgeActivity.a(this.app, paramIntent);
    }
    if ((bool) && (!TextUtils.isEmpty(str2))) {
      PublicAccountUtil.a(this.app, this.app.a(), str2);
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (!((JSONObject)localObject).has("resultCode")) {
        break label320;
      }
      paramInt1 = ((JSONObject)localObject).getInt("resultCode");
      if (!((JSONObject)localObject).has("retmsg")) {
        break label327;
      }
      paramIntent = ((JSONObject)localObject).getString("retmsg");
      label263:
      if (!((JSONObject)localObject).has("data")) {
        break label333;
      }
      localObject = ((JSONObject)localObject).getString("data");
      label284:
      a(paramInt1, paramIntent, (String)localObject, str1);
      return;
    }
    catch (JSONException paramIntent)
    {
      if (!QLog.isDevelopLevel()) {
        break label339;
      }
    }
    paramIntent.printStackTrace();
    for (;;)
    {
      a(-1006, "PayResult JSONException", null, str1);
      return;
      label320:
      paramInt1 = -1005;
      break;
      label327:
      paramIntent = "";
      break label263;
      label333:
      localObject = null;
      break label284;
      label339:
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.open.OpenPayActivity", 2, "onActivityResult error:" + paramIntent.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getIntent().getExtras();
    if (paramBundle == null)
    {
      a(-1001, "Parameters error.", null, null);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_d_of_type_Int = paramBundle.getInt("extra.key.pay.type");
    this.e = paramBundle.getInt("extra.key.pay.from");
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      a(-1002, "Parameters error.", null, null);
      return;
    }
    b(paramBundle);
  }
  
  protected void onDestroy()
  {
    a();
    super.onDestroy();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.OpenPayActivity
 * JD-Core Version:    0.7.0.1
 */