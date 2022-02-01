package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.Arrays;
import org.json.JSONObject;

public class MQPSecJsPlugin
  extends VasWebviewJsPlugin
  implements SMSBodyObserver
{
  public static final String NAMESPACE_DEV_LOCK = "EquipLockManager";
  public static final String NAMESPACE_PUZZLE_VERIFY_CODE = "CAPTCHA";
  public static final String NAMESPACE_SET_PWD = "SetPwdJsInterface";
  private static final String tag = "MQPSecJsPlugin";
  protected QQBrowserActivity activity = null;
  boolean isSubaccount;
  private String mEmergencyPhoneMask;
  private int mEmergencyPhoneState = 1;
  private boolean mOpenDevlockCalled = false;
  private int mSeq = -1;
  boolean needResult;
  private QQProgressDialog progressDialog = null;
  String resultMobileMask;
  boolean resultSetMobile = false;
  String resultSppkey = null;
  int resultState = 1;
  String resultUin;
  String subAccountUin;
  String tagRequest;
  private boolean waittingResponse = false;
  
  private void hideProgressDialog()
  {
    if (this.activity == null) {
      return;
    }
    this.activity.runOnUiThread(new MQPSecJsPlugin.3(this));
  }
  
  private boolean onBackEvent()
  {
    if ((this.resultState == 2) && (!TextUtils.isEmpty(this.resultSppkey)) && (!this.mOpenDevlockCalled))
    {
      this.mOpenDevlockCalled = true;
      openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
    }
    while (this.waittingResponse) {
      return true;
    }
    closeWeb(true);
    return false;
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new MQPSecJsPlugin.2(this));
  }
  
  public void changeEquipLockMobile(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 3;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    closeWeb(false);
  }
  
  public void closeWeb(boolean paramBoolean)
  {
    Intent localIntent;
    if (this.needResult)
    {
      localIntent = new Intent();
      localIntent.putExtra("resultMobileMask", this.resultMobileMask);
      localIntent.putExtra("resultUin", this.resultUin);
      localIntent.putExtra("resultSppkey", this.resultSppkey);
      localIntent.putExtra("resultState", this.resultState);
      if (!TextUtils.isEmpty(this.mEmergencyPhoneMask))
      {
        localIntent.putExtra("emergency_phone_mask", this.mEmergencyPhoneMask);
        localIntent.putExtra("emergency_phone_state", this.mEmergencyPhoneState);
      }
      if (this.resultState == 2) {
        localIntent.putExtra("resultSetMobile", this.resultSetMobile);
      }
      if (!paramBoolean) {
        break label149;
      }
      this.activity.setResult(0, localIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MQPSecJsPlugin", 2, "close Web");
      }
      hideProgressDialog();
      this.activity.finish();
      return;
      label149:
      this.activity.setResult(-1, localIntent);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2149629952L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("EquipLockManager".equalsIgnoreCase(paramString2)) || ("SetPwdJsInterface".equalsIgnoreCase(paramString2)) || ("CAPTCHA".equalsIgnoreCase(paramString2))) {
      return call(paramString3, Arrays.asList(paramVarArgs));
    }
    return false;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = Utils.c(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      callJs("_pushInputVcode", new String[] { paramString1 });
    }
  }
  
  public void handleWebError(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 1;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    closeWeb(false);
  }
  
  public void isNotNet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin isNotNet ");
    }
    new Handler(this.activity.getMainLooper()).post(new MQPSecJsPlugin.4(this));
  }
  
  void onBindedToClient()
  {
    if (this.activity == null) {}
    long l;
    do
    {
      return;
      Object localObject = this.activity.getIntent();
      l = ((Intent)localObject).getLongExtra("business", 0L);
      if ((0x8000 & l) != 0L)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", (String)localObject);
        sendRemoteReq(DataFactory.makeIPCRequestPacket("getA2", "", this.mOnRemoteResp.key, localBundle), true, false);
        hideProgressDialog();
        return;
      }
    } while ((l & 0x200000) == 0L);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("puzzle_verify_code_clearProgressDialog", "", this.mOnRemoteResp.key, new Bundle()), true, false);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.a());
    }
    Intent localIntent;
    long l;
    if (this.activity != null)
    {
      localIntent = this.activity.getIntent();
      l = localIntent.getLongExtra("business", 0L);
      if ((0x4000 & l) == 0L) {
        break label142;
      }
      this.tagRequest = localIntent.getStringExtra("tag");
      this.needResult = localIntent.getBooleanExtra("needResult", false);
      this.isSubaccount = localIntent.getBooleanExtra("isSubaccount", false);
      if (this.isSubaccount) {
        this.subAccountUin = localIntent.getStringExtra("subAccountUin");
      }
      ((TextView)this.activity.findViewById(2131297357)).setOnClickListener(new MQPSecJsPlugin.1(this));
    }
    label142:
    while ((l & 0x200000) == 0L) {
      return;
    }
    this.mSeq = localIntent.getIntExtra("seq", -1);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    hideProgressDialog();
  }
  
  public void onLoadIsSetPsw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onLoadIsSetPsw isSet =" + paramString);
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      sendRemoteReq(DataFactory.makeIPCRequestPacket("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    String str1;
    if (paramBundle != null)
    {
      str1 = paramBundle.getString("cmd");
      if (!TextUtils.isEmpty(str1)) {
        break label35;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MQPSecJsPlugin", 2, "cmd is empty.");
      }
    }
    label35:
    String str2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramBundle = paramBundle.getBundle("response");
                if (QLog.isColorLevel()) {
                  QLog.i("MQPSecJsPlugin", 2, "response:" + str1);
                }
                if (!str1.equalsIgnoreCase("openEquipmentLock")) {
                  break;
                }
              } while (paramBundle.getInt("checkDevLockSms_ret") >= 0);
              hideProgressDialog();
              closeWeb(false);
              return;
              if (!str1.equalsIgnoreCase("setWaitingResponse")) {
                break;
              }
              this.waittingResponse = paramBundle.getBoolean("isWaiting", false);
            } while (this.waittingResponse);
            hideProgressDialog();
            return;
            if (str1.equalsIgnoreCase("setMobileResult"))
            {
              this.resultSetMobile = paramBundle.getBoolean("setMobileResult", false);
              return;
            }
            if (str1.equalsIgnoreCase("closeWeb"))
            {
              closeWeb(paramBundle.getBoolean("isBack"));
              return;
            }
          } while (!str1.equalsIgnoreCase("getA2"));
          paramBundle = paramBundle.getString("A2");
          if (!TextUtils.isEmpty(paramBundle)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("MQPSecJsPlugin", 2, "a2 is empty.");
        return;
        str1 = this.activity.getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("MQPSecJsPlugin", 2, "url is empty.");
      return;
      str2 = Util.c(str1);
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MQPSecJsPlugin", 2, "domain is empty.");
    return;
    CookieSyncManager.createInstance(this.mRuntime.a().getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.setCookie(str1, String.format("A2=%1$s; domain=%2$s; path=/", new Object[] { paramBundle, str2 }));
    CookieSyncManager.getInstance().sync();
  }
  
  public void onTimeOut()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onTimeOut");
    }
    hideProgressDialog();
  }
  
  public void onVerifyCAPTCHA(String paramString)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        paramString = new JSONObject(paramString);
        if (Integer.parseInt(paramString.getString("result")) == 0)
        {
          paramString = paramString.getString("ticket");
          Bundle localBundle = new Bundle();
          localBundle.putInt("seq", this.mSeq);
          localBundle.putBoolean("result", bool);
          localBundle.putString("ticket", paramString);
          sendRemoteReq(DataFactory.makeIPCRequestPacket("puzzle_verify_code_setTicket", "", this.mOnRemoteResp.key, localBundle), true, false);
          if (this.activity != null) {
            this.activity.finish();
          }
          return;
        }
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MQPSecJsPlugin", 2, "onVerifyCAPTCHA error:" + paramString.getMessage());
      }
    }
  }
  
  public void onWebMakeSureBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onWebMakeSureBack");
    }
    showProgressDialog();
  }
  
  public void onWebMakeSureFinishBack(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onWebMakeSureFinishBack isSuccess =" + paramString);
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      sendRemoteReq(DataFactory.makeIPCRequestPacket("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
    hideProgressDialog();
  }
  
  public void openEquipmentLock(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 2;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    showProgressDialog();
    byte[] arrayOfByte = null;
    if (paramString3 != null) {
      arrayOfByte = paramString3.getBytes();
    }
    this.waittingResponse = true;
    paramString3 = new Bundle();
    paramString3.putString("uin", paramString1);
    paramString3.putString("mobileMask", paramString2);
    paramString3.putByteArray("sppkey", arrayOfByte);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("openEquipmentLock", "", this.mOnRemoteResp.key, paramString3), true, false);
  }
  
  public void pushMobileResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "pushMobileResult uin=" + paramString1 + " mobileMask=" + paramString2 + " state=" + paramString3 + " sppkey=" + paramString4);
    }
    updateResult(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void pushMobileReturn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin pushMobileReturn");
    }
    this.activity.finish();
  }
  
  public void pushMobileReturn(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "pushMobileReturn uin=" + paramString1 + " mobileMask=" + paramString2 + " state=" + paramString3 + " sppkey=" + paramString4);
    }
    if (TextUtils.isEmpty(paramString4))
    {
      updateResult(paramString1, paramString2, paramString3, paramString4);
      if ((this.resultState == 2) && (!TextUtils.isEmpty(this.resultSppkey)) && (!this.mOpenDevlockCalled))
      {
        this.mOpenDevlockCalled = true;
        openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
      }
    }
    do
    {
      return;
      closeWeb(false);
      return;
      if (!"1".equals(paramString3)) {
        break;
      }
    } while (this.mOpenDevlockCalled);
    this.mOpenDevlockCalled = true;
    openEquipmentLock(paramString1, paramString2, paramString4);
    return;
    if ("2".equals(paramString3))
    {
      changeEquipLockMobile(paramString1, paramString2, paramString4);
      return;
    }
    handleWebError(paramString1, paramString2, paramString4);
  }
  
  public void updateResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.resultUin = paramString1;
    if (TextUtils.isEmpty(paramString4))
    {
      this.mEmergencyPhoneMask = paramString2;
      if ("1".equals(paramString3))
      {
        this.mEmergencyPhoneState = 2;
        return;
      }
      if ("2".equals(paramString3))
      {
        this.mEmergencyPhoneState = 3;
        return;
      }
      this.mEmergencyPhoneState = 1;
      return;
    }
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString4;
    if ("1".equals(paramString3))
    {
      this.resultState = 2;
      return;
    }
    if ("2".equals(paramString3))
    {
      this.resultState = 3;
      return;
    }
    this.resultState = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin
 * JD-Core Version:    0.7.0.1
 */