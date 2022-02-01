package com.tencent.mobileqq.vaswebviewplugin;

import VIP.RespGetApiList;
import VIP.RespGetOpenId;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.OpenPayActivity;
import cooperation.qwallet.open.QWalletOpenApiCE;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletOpenJsPlugin
  extends VasWebviewJsPlugin
{
  private static final byte REQUET_CODE_OPEN_PAY_PAY = 50;
  private static final String TAG = "Q.qwallet.open.QWalletOpenJsPlugin";
  private final String API_OPENID = "open_userinfo_getOpenId";
  private final String API_PAY = "open_pay_pay";
  private final String API_TOKEN = "open_runtime_getOpenToken";
  private boolean mIsUsed = false;
  private int mOpenIdCallbackSn;
  private int mPayCallbackSn;
  private int mTokenCallbackSn;
  
  private boolean doGetOpenId(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      doGetOpenIdCallback(-1, "ipc error", null, null);
    }
    for (;;)
    {
      return true;
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "qwalletOpenOpenid");
      localBundle.putString("appId", paramString1);
      localBundle.putString("nonce", paramString2);
      localBundle.putLong("timeStamp", paramLong);
      localBundle.putString("sig", paramString3);
      localBundle.putString("sigType", paramString4);
      WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(localBundle);
    }
  }
  
  private void doGetOpenIdCallback(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("{ \"retCode\":" + paramInt + ", \"retMsg\":\"" + paramString1 + "\"");
    if (paramInt == 0) {
      localStringBuilder.append(", \"openId\":\"" + paramString2 + "\", \"openKey\":\"" + paramString3 + "\"");
    }
    localStringBuilder.append(" }");
    onCallback(this.mOpenIdCallbackSn, localStringBuilder.toString());
  }
  
  private boolean doGetToken(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      doGetTokenCallback(-1, "ipc error", "");
    }
    for (;;)
    {
      return true;
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "qwalletOpenToken");
      localBundle.putString("appId", paramString1);
      localBundle.putString("nonce", paramString2);
      localBundle.putLong("timeStamp", paramLong);
      localBundle.putString("sig", paramString3);
      localBundle.putString("sigType", paramString4);
      localBundle.putString("domain", getDomain());
      WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(localBundle);
    }
  }
  
  private void doGetTokenCallback(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "{ \"retCode\":" + paramInt + ", \"retMsg\":\"" + paramString1 + "\" , \"openToken\":\"" + paramString2 + "\" }";
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 4, paramString1);
    }
    onCallback(this.mTokenCallbackSn, paramString1);
  }
  
  private boolean doPay(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null)
    {
      doPayCallback(paramInt, -1, "", null);
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra.key.pay.type", 1);
    localBundle.putInt("extra.key.pay.from", 1);
    localBundle.putString("appId", paramString1);
    localBundle.putString("callbackSn", String.valueOf(paramInt));
    localBundle.putString("nonce", paramString6);
    localBundle.putLong("timeStamp", paramLong);
    localBundle.putString("sig", paramString7);
    localBundle.putString("sigType", paramString8);
    localBundle.putString("tokenId", paramString2);
    localBundle.putString("pubAcc", paramString3);
    localBundle.putString("pubAccHint", paramString4);
    localBundle.putString("bargainorId", paramString5);
    localBundle.putString("qVersion", "5.9.3");
    localBundle.putString("domain", getDomain());
    paramString1 = new Intent(localActivity, OpenPayActivity.class);
    paramString1.putExtras(localBundle);
    paramString1.addFlags(67108864);
    startActivityForResult(paramString1, (byte)50);
    return true;
  }
  
  private void doPayCallback(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("{ \"retCode\":" + paramInt2 + ", \"retMsg\":\"" + paramString + "\"");
    if ((paramInt2 == 0) && (paramBundle != null))
    {
      paramString = paramBundle.getString("payChannelType");
      localStringBuilder.append(", \"payChannelType\":\"" + paramString + "\",");
      localStringBuilder.append(" \"transactionId\":\"" + paramBundle.getString("transactionId") + "\",");
      localStringBuilder.append(" \"payTime\":\"" + paramBundle.getString("payTime") + "\",");
      localStringBuilder.append(" \"totalFee\":\"" + paramBundle.getString("totalFee") + "\",");
      localStringBuilder.append(" \"callbackUrl\":\"" + paramBundle.getString("callbackUrl") + "\",");
      localStringBuilder.append(" \"spData\":\"" + paramBundle.getString("spData") + "\"");
    }
    localStringBuilder.append(" }");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 4, localStringBuilder.toString());
    }
    onCallback(paramInt1, localStringBuilder.toString());
  }
  
  private String generateOpenToken()
  {
    String str = String.valueOf(new Random(System.currentTimeMillis()).nextInt());
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(str.getBytes());
      localObject = SecUtil.a(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return str;
  }
  
  private String getDomain()
  {
    try
    {
      String str = Uri.parse(this.mRuntime.a().getUrl()).getHost();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void onCallback(int paramInt, String paramString)
  {
    paramString = "'" + paramString.toString().replace("\\", "\\\\").replace("'", "\\'") + "'";
    callJs("window.JsBridge&&JsBridge.callback(" + paramInt + ",{'r':0,'result':" + paramString + "});");
  }
  
  protected long getPluginBusiness()
  {
    return 0L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs.length <= 0)) {
      return false;
    }
    String str1 = QWalletOpenApiCE.a(paramString2, paramString3);
    if ((!"open_runtime_getOpenToken".equals(str1)) && (!"open_pay_pay".equals(str1)) && (!"open_userinfo_getOpenId".equals(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 2, "can not handle method:" + paramString3);
      }
      return false;
    }
    this.mIsUsed = true;
    WebIPCOperator.getInstance().registerObserver(this.mOnRemoteResp);
    paramJsBridgeListener = paramVarArgs[0];
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 2, "HandleUrl params objectName=" + paramString2 + ",methodName=" + paramString3 + ",jsonParams=" + paramJsBridgeListener);
      }
      paramString1 = new JSONObject(paramJsBridgeListener);
      long l;
      if ("open_runtime_getOpenToken".equals(str1))
      {
        paramString2 = paramString1.optString("appId");
        paramString3 = paramString1.optString("nonce");
        l = paramString1.optLong("timeStamp");
        paramVarArgs = paramString1.optString("sig");
        str1 = paramString1.optString("sigType");
        this.mTokenCallbackSn = paramString1.optInt("callback");
        return doGetToken(paramString2, paramString3, l, paramVarArgs, str1);
      }
      if ("open_pay_pay".equals(str1))
      {
        paramString2 = paramString1.optString("appId");
        paramString3 = paramString1.optString("tokenId");
        paramVarArgs = paramString1.optString("pubAcc");
        str1 = paramString1.optString("pubAccHint");
        String str2 = paramString1.optString("bargainorId");
        String str3 = paramString1.optString("nonce");
        l = paramString1.optLong("timeStamp");
        String str4 = paramString1.optString("sig");
        String str5 = paramString1.optString("sigType");
        this.mPayCallbackSn = paramString1.optInt("callback");
        return doPay(paramString2, this.mPayCallbackSn, paramString3, paramVarArgs, str1, str2, str3, l, str4, str5);
      }
      if ("open_userinfo_getOpenId".equals(str1))
      {
        paramString2 = paramString1.optString("appId");
        paramString3 = paramString1.optString("nonce");
        l = paramString1.optLong("timeStamp");
        paramVarArgs = paramString1.optString("sig");
        str1 = paramString1.optString("sigType");
        this.mOpenIdCallbackSn = paramString1.optInt("callback");
        boolean bool = doGetOpenId(paramString2, paramString3, l, paramVarArgs, str1);
        return bool;
      }
      return false;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 2, "jsonParams JSONException,jsonParams=" + paramJsBridgeListener);
      }
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (!this.mIsUsed) {}
    do
    {
      return;
      switch (paramByte)
      {
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 4, "onActivityResult " + paramByte);
    return;
    if (paramIntent == null)
    {
      doPayCallback(this.mPayCallbackSn, -1, "", null);
      return;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      doPayCallback(this.mPayCallbackSn, -1, "", null);
      return;
    }
    int i = paramIntent.getInt("retCode");
    String str1 = paramIntent.getString("retMsg");
    String str2 = paramIntent.getString("callbackSn");
    if (!TextUtils.isEmpty(str2)) {}
    for (paramByte = Integer.valueOf(str2).intValue();; paramByte = -1)
    {
      paramInt = paramByte;
      if (paramByte == -1) {
        paramInt = this.mPayCallbackSn;
      }
      doPayCallback(paramInt, i, str1, paramIntent);
      return;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.getInstance().unRegisterObserver(this.mOnRemoteResp);
    this.mIsUsed = false;
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.open.QWalletOpenJsPlugin", 4, "onResponse i:" + toString() + " u" + this.mIsUsed);
    }
    if (!this.mIsUsed) {}
    int i;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle == null);
        localObject1 = paramBundle.getString("cmd");
      } while ((TextUtils.isEmpty((CharSequence)localObject1)) || ((((String)localObject1).compareTo("qwalletOpenToken") != 0) && (((String)localObject1).compareTo("qwalletOpenOpenid") != 0)));
      i = paramBundle.getInt("openpay.type");
      bool = paramBundle.getBoolean("openpay.isSuccess");
      paramBundle = paramBundle.getSerializable("openpay.data");
      if (1 == i)
      {
        if ((!bool) || (paramBundle == null))
        {
          doGetOpenIdCallback(-2, "Connection error", null, null);
          return;
        }
        paramBundle = (RespGetOpenId)paramBundle;
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.qwallet.open.QWalletOpenJsPlugin", 4, "getOpenUserInfo code:" + paramBundle.ret + " error:" + paramBundle.errMsg);
        }
        if (paramBundle.ret != 0)
        {
          doGetOpenIdCallback(paramBundle.ret, "Server error:" + paramBundle.errMsg, null, null);
          return;
        }
        doGetOpenIdCallback(paramBundle.ret, paramBundle.errMsg, paramBundle.openId, paramBundle.openKey);
        return;
      }
    } while (2 != i);
    if ((!bool) || (paramBundle == null))
    {
      doGetTokenCallback(-2, "Connection error", "");
      return;
    }
    paramBundle = (RespGetApiList)paramBundle;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.open.QWalletOpenJsPlugin", 4, "getOpenApis code:" + paramBundle.ret + " error:" + paramBundle.errMsg);
    }
    if (paramBundle.ret != 0)
    {
      doGetTokenCallback(paramBundle.ret, "Server error:" + paramBundle.errMsg, "");
      return;
    }
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramBundle.apiList))
    {
      localObject2 = (paramBundle.apiList + "#0").split("#");
      i = 0;
      while (i < localObject2.length - 1)
      {
        ((ArrayList)localObject1).add(localObject2[i]);
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramBundle.domains))
    {
      localObject2 = (paramBundle.domains + ";0").split(";");
      i = 0;
      while (i < localObject2.length - 1)
      {
        localArrayList.add(localObject2[i]);
        i += 1;
      }
    }
    Object localObject2 = generateOpenToken();
    QWalletOpenApiCE.a().a(paramBundle.appId, (String)localObject2, (List)localObject1, localArrayList);
    doGetTokenCallback(0, "Success.", (String)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletOpenJsPlugin
 * JD-Core Version:    0.7.0.1
 */