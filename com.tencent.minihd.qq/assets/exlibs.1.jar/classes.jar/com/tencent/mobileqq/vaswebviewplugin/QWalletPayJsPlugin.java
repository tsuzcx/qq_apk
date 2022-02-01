package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletPayJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String METHOD_NAME_OPENSUPERVIP = "openSuperVip";
  private static final String OBJECT_NAME_NEW = "qw.pay";
  private static final String OBJECT_NAME_OLD = "pay";
  private static final String TAG = "QWalletPayJsHandler";
  public static SparseArray mFirstUrls = new SparseArray();
  public static ArrayList mSequence = new ArrayList();
  
  public static String getPayAppInfo()
  {
    if ((mFirstUrls != null) && (mSequence != null))
    {
      int i = mSequence.size() - 1;
      if (i >= 0)
      {
        Object localObject = (Integer)mSequence.get(i);
        if (localObject != null) {}
        int k;
        for (localObject = (String)mFirstUrls.get(((Integer)localObject).intValue());; localObject = null)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = ((String)localObject).indexOf("qqwallet_appinfo=");
            if (k != -1) {
              break label85;
            }
          }
          i -= 1;
          break;
        }
        label85:
        int j = ((String)localObject).indexOf('&', "qqwallet_appinfo=".length() + k);
        i = j;
        if (j == -1) {
          i = ((String)localObject).length();
        }
        return ((String)localObject).substring("qqwallet_appinfo=".length() + k, i);
      }
    }
    return "";
  }
  
  private boolean openSuperVip(String paramString)
  {
    String str2 = null;
    String str1 = null;
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      str1 = paramString;
      str2 = paramString;
      Object localObject = new JSONObject(paramString);
      str1 = paramString;
      str2 = paramString;
      String str3 = ((JSONObject)localObject).getString("data");
      str1 = paramString;
      str2 = paramString;
      localObject = ((JSONObject)localObject).getString("requestId");
      if (QLog.isColorLevel()) {
        QLog.i("QWalletPayJsHandler", 2, "HandleUrl params objectName=qw.pay,methodName=openSuperVip,jsonParams=" + paramString);
      }
      PayBridgeActivity.tenpay(this.mRuntime.a(), str3, 11, (String)localObject);
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletPayJsHandler", 2, "jsonParams UnsupportedEncodingException,jsonParams=" + str1);
      }
      paramString.printStackTrace();
      return false;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletPayJsHandler", 2, "jsonParams JSONException,jsonParams=" + str2);
      }
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void buyGoods(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "buyGoods requet params json=" + paramJSONObject.toString());
    }
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramJSONObject.toString(), 7, paramString);
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (9 == paramInt)
    {
      paramString = (Integer)paramMap.get("requestCode");
      if ((paramString != null) && (paramString.intValue() == 11))
      {
        paramMap = (Intent)paramMap.get("data");
        if (paramMap != null)
        {
          paramString = paramMap.getStringExtra("callbackSn");
          paramMap = paramMap.getStringExtra("result");
          callJs("qw.bridge.publicTube('" + paramString + "', '{\"code\":0, \"msg\":\"ok\", \"data\":" + paramMap + "}')");
        }
        return true;
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs.length <= 0)) {}
    do
    {
      do
      {
        return false;
        if (!"qw.pay".equals(paramString2)) {
          break;
        }
      } while (!"openSuperVip".equals(paramString3));
      return openSuperVip(paramVarArgs[0]);
    } while (!QLog.isColorLevel());
    QLog.i("QWalletPayJsHandler", 2, "can not handle objectname:" + paramString2);
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "pay");
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      Intent localIntent = localActivity.getIntent();
      if (localIntent != null)
      {
        String str2 = localIntent.getStringExtra("homepage");
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = localIntent.getStringExtra("url");
        }
        if (str1 != null)
        {
          mFirstUrls.append(localActivity.hashCode(), str1);
          mSequence.add(0, Integer.valueOf(localActivity.hashCode()));
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      mFirstUrls.remove(localActivity.hashCode());
      mSequence.remove(Integer.valueOf(localActivity.hashCode()));
    }
    super.onDestroy();
  }
  
  public void openService(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "openService requet params json=" + paramJSONObject.toString());
    }
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramJSONObject.toString(), 4, paramString);
  }
  
  public void openTenpayView(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "openTenpayView requet params json=" + paramJSONObject.toString());
    }
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramJSONObject.toString(), 5, paramString);
  }
  
  public void pay(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "pay requet params json=" + paramJSONObject.toString());
    }
    PayBridgeActivity.a(this.mRuntime.a(), paramJSONObject.toString(), 9, paramString, getPayAppInfo());
  }
  
  public void rechargeGameCurrency(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "rechargeCurrency requet params json=" + paramJSONObject.toString());
    }
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramJSONObject.toString(), 6, paramString);
  }
  
  public void rechargeQb(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "rechargeQb requet params json=" + paramJSONObject.toString());
    }
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramJSONObject.toString(), 8, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin
 * JD-Core Version:    0.7.0.1
 */