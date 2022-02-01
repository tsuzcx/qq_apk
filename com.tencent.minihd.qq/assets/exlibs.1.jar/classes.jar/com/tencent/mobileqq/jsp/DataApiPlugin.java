package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.HashMap;
import java.util.Iterator;
import jcf;
import jcg;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class DataApiPlugin
  extends WebViewPlugin
{
  static final String jdField_a_of_type_JavaLangString = "callback";
  public static final String b = DataApiPlugin.class.getSimpleName();
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  public Client.onRemoteRespObserver a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  
  public DataApiPlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new jcf(this);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("data".equals(paramString2)) {
      if ((!"userInfo".equals(paramString3)) || (paramVarArgs.length != 1)) {}
    }
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
        paramJsBridgeListener = this.mRuntime.a().getUrl();
        if ((paramJsBridgeListener == null) || (!paramJsBridgeListener.startsWith("file://"))) {
          break label2420;
        }
        paramJsBridgeListener = HtmlOffline.e(paramJsBridgeListener);
        localObject1 = this.mRuntime.a();
        if (((TextUtils.isEmpty(paramJsBridgeListener)) || (!((AppInterface)localObject1).isLogin())) && (!TextUtils.isEmpty(paramString1)))
        {
          callJs(paramString1, new String[] { "{}" });
          return true;
        }
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
          this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramJsBridgeListener))) {
          continue;
        }
        i = 1;
        bool1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramJsBridgeListener);
        bool2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramJsBridgeListener);
        paramString3 = (TicketManager)((AppInterface)localObject1).getManager(2);
        paramVarArgs = ((AppInterface)localObject1).getAccount();
        paramString2 = new JSONObject();
        paramString2.put("uin", paramVarArgs);
        paramString2.put("nick", ((AppInterface)localObject1).getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramVarArgs));
        if (i == 0) {
          break label2423;
        }
        paramString2.put("sid", paramString3.getSid(paramVarArgs));
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        continue;
      }
      Object localObject1 = Util.c(paramJsBridgeListener);
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      Object localObject2;
      if (bool1)
      {
        localObject2 = paramString3.getSkey(paramVarArgs);
        paramString2.put("skey", localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramJsBridgeListener, String.format("skey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { localObject2, localObject1 }));
        }
      }
      if (bool2)
      {
        paramString3 = paramString3.getVkey(paramVarArgs);
        paramString2.put("vkey", paramString3);
        if (!TextUtils.isEmpty(paramString3)) {
          this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramJsBridgeListener, String.format("vkey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { paramString3, localObject1 }));
        }
      }
      if (!TextUtils.isEmpty(paramString1)) {
        callJs(paramString1, new String[] { paramString2.toString() });
      }
      return true;
      int i = 0;
      continue;
      if ("getVipType".equals(paramString3))
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString1 = paramString1.optString("uin");
          if ((!paramString1.equals(this.mRuntime.a().getAccount())) || (TextUtils.isEmpty(paramJsBridgeListener))) {
            continue;
          }
          paramString2 = new Bundle();
          paramString2.putString("uin", paramString1);
          paramJsBridgeListener = DataFactory.makeIPCRequestPacket("getUserVipType", paramJsBridgeListener, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, paramString2);
          WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        String str1;
        if (("sendRequest".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          try
          {
            paramVarArgs = new JSONObject(paramVarArgs[0]);
            paramString2 = paramVarArgs.optString("url");
            paramString3 = paramVarArgs.optString("callback");
            if ((TextUtils.isEmpty(paramString2)) || ((!paramString2.startsWith("http://")) && (!paramString2.startsWith("https://"))))
            {
              if (TextUtils.isEmpty(paramString3)) {
                break;
              }
              callJs(paramString3, new String[] { "null", "0" });
              break;
            }
            paramJsBridgeListener = null;
            localObject1 = paramVarArgs.optJSONObject("params");
            if (localObject1 != null)
            {
              paramString1 = new Bundle();
              localObject2 = ((JSONObject)localObject1).keys();
              for (;;)
              {
                paramJsBridgeListener = paramString1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramJsBridgeListener = String.valueOf(((Iterator)localObject2).next());
                str1 = ((JSONObject)localObject1).optString(paramJsBridgeListener);
                if (str1 != null) {
                  paramString1.putString(paramJsBridgeListener, str1);
                }
              }
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          paramString1 = paramVarArgs.optJSONObject("options");
          if ((paramString1 != null) && ("POST".equalsIgnoreCase(paramString1.optString("method")))) {}
          for (paramString1 = "POST";; paramString1 = "GET")
          {
            paramVarArgs = new Bundle();
            if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
            {
              this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
              this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
            }
            localObject1 = this.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie(paramString2);
            if (localObject1 != null) {
              paramVarArgs.putString("Cookie", (String)localObject1);
            }
            ThreadManager.a(new jcg(this, paramString2, paramString1, paramJsBridgeListener, paramVarArgs, paramString3));
            break;
          }
        }
        else
        {
          if (("getSharedData".equals(paramString3)) && (paramVarArgs.length == 1)) {
            for (;;)
            {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                paramString1 = paramJsBridgeListener.optString("callback");
                if (TextUtils.isEmpty(paramString1)) {
                  break;
                }
                if ("qbrowserCount".equals(paramJsBridgeListener.optString("key")))
                {
                  callJs(paramString1, new String[] { Integer.toString(QQBrowserActivity.H) });
                  return true;
                }
                paramJsBridgeListener = null;
                paramString2 = this.mRuntime.a();
                if (paramString2 != null) {
                  paramJsBridgeListener = paramString2.getIntent().getStringExtra("sharedData");
                }
                if (paramJsBridgeListener != null) {
                  break label1005;
                }
                paramJsBridgeListener = "";
                callJs(paramString1, new String[] { paramJsBridgeListener });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
              break;
              label1005:
              paramJsBridgeListener = Util.b(paramJsBridgeListener);
            }
          }
          if (("setClipboard".equals(paramString3)) && (paramVarArgs.length == 1)) {}
          label1243:
          label1514:
          label2411:
          label2417:
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  for (;;)
                  {
                    try
                    {
                      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                      paramString1 = paramJsBridgeListener.optString("text");
                      paramJsBridgeListener = paramJsBridgeListener.optString("callback");
                      if (paramString1 != null) {
                        break label2417;
                      }
                      paramString1 = "";
                    }
                    catch (JSONException paramString1)
                    {
                      try
                      {
                        paramString2 = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
                        if (paramString2 != null)
                        {
                          paramString2.setText(paramString1);
                          if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                            callJs(paramJsBridgeListener, new String[] { "true" });
                          }
                          return true;
                        }
                        if (TextUtils.isEmpty(paramJsBridgeListener)) {
                          break;
                        }
                        callJs(paramJsBridgeListener, new String[] { "false" });
                      }
                      catch (JSONException paramString1)
                      {
                        for (;;)
                        {
                          int j;
                          int k;
                          String str2;
                          String str3;
                          String str4;
                          continue;
                          i = 1;
                        }
                      }
                      paramString1 = paramString1;
                      paramJsBridgeListener = null;
                    }
                    paramString1.printStackTrace();
                    continue;
                    if (("getClipboard".equals(paramString3)) && (paramVarArgs.length == 1)) {
                      for (;;)
                      {
                        try
                        {
                          paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
                          if (TextUtils.isEmpty(paramString1)) {
                            break;
                          }
                          paramJsBridgeListener = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
                          if (paramJsBridgeListener == null) {
                            break label1243;
                          }
                          paramJsBridgeListener = paramJsBridgeListener.getText().toString();
                          callJs(paramString1, new String[] { Util.b(paramJsBridgeListener) });
                        }
                        catch (JSONException paramJsBridgeListener)
                        {
                          paramJsBridgeListener.printStackTrace();
                        }
                        break;
                        paramJsBridgeListener = "";
                      }
                    }
                    if ((!"report".equals(paramString3)) || (paramVarArgs.length != 1)) {
                      break label1733;
                    }
                    try
                    {
                      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                      paramString2 = paramJsBridgeListener.optString("platform");
                      paramJsBridgeListener = paramJsBridgeListener.getJSONObject("payload");
                      paramString1 = this.mRuntime.a();
                      if (!"ads".equalsIgnoreCase(paramString2)) {
                        break label1544;
                      }
                      paramString2 = paramJsBridgeListener.optString("departKey", "");
                      paramString3 = paramJsBridgeListener.getString("logKey");
                      paramVarArgs = paramJsBridgeListener.getString("opType");
                      localObject1 = paramJsBridgeListener.getString("opName");
                      localObject2 = paramJsBridgeListener.optString("targetUin", "");
                      i = paramJsBridgeListener.optInt("opEntry", 0);
                      j = paramJsBridgeListener.optInt("opCount", 1);
                      k = paramJsBridgeListener.optInt("opResult", 0);
                      str1 = paramJsBridgeListener.optString("reserve2", "");
                      str2 = paramJsBridgeListener.optString("reserve3", "");
                      str3 = paramJsBridgeListener.optString("reserve4", "");
                      str4 = paramJsBridgeListener.optString("reserve5", "");
                      paramJsBridgeListener = null;
                      if ((paramString1 instanceof QQAppInterface)) {
                        paramJsBridgeListener = (QQAppInterface)paramString1;
                      }
                      if (!paramString1.isLogin()) {
                        break label1514;
                      }
                      ReportController.b(paramJsBridgeListener, paramString3, paramString2, (String)localObject2, paramVarArgs, (String)localObject1, i, j, k, str1, str2, str3, str4);
                    }
                    catch (JSONException paramJsBridgeListener) {}
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.w(b, 2, paramJsBridgeListener.getMessage());
                  break;
                  ReportController.a(paramJsBridgeListener, paramString3, paramString2, (String)localObject2, paramVarArgs, (String)localObject1, i, j, k, str1, str2, str3, str4);
                  break;
                  if ("rdm".equalsIgnoreCase(paramString2))
                  {
                    paramString2 = paramJsBridgeListener.getString("eventName");
                    bool1 = paramJsBridgeListener.optBoolean("reportNow", true);
                    bool2 = paramJsBridgeListener.optBoolean("isSucceed", true);
                    i = paramJsBridgeListener.optInt("elapse", 0);
                    j = paramJsBridgeListener.optInt("size", 0);
                    paramString3 = new HashMap();
                    paramJsBridgeListener = paramJsBridgeListener.optJSONObject("extra");
                    if (paramJsBridgeListener != null)
                    {
                      paramVarArgs = paramJsBridgeListener.keys();
                      while ((paramVarArgs != null) && (paramVarArgs.hasNext()))
                      {
                        localObject1 = (String)paramVarArgs.next();
                        paramString3.put(localObject1, paramJsBridgeListener.optString((String)localObject1));
                      }
                    }
                    paramJsBridgeListener = null;
                    if (paramString1.isLogin()) {
                      paramJsBridgeListener = paramString1.getAccount();
                    }
                    StatisticCollector.a(null).a(paramJsBridgeListener, paramString2, bool2, i, j, paramString3, "", bool1);
                    break;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.w(b, 2, "Unsupported report platform!");
                  break;
                  if (!"getFaceFile".equals(paramString3)) {
                    break label1893;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i(b, 2, "getFaceFile");
                  }
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                    if (TextUtils.isEmpty(paramJsBridgeListener)) {
                      break label1874;
                    }
                    paramString1 = new Bundle();
                    paramString1.putString("uin", this.mRuntime.a().getAccount());
                    paramJsBridgeListener = DataFactory.makeIPCRequestPacket("getFaceFilePath", paramJsBridgeListener, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, paramString1);
                    WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
                  }
                  catch (JSONException paramJsBridgeListener) {}
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.w(b, 2, "error, getFaceFile:" + paramJsBridgeListener.getMessage());
                break;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i(b, 2, "getFaceFile, callback");
                break;
                if ((!"setPskeyByDomain".equals(paramString3)) || (paramVarArgs.length != 1)) {
                  break label2249;
                }
                try
                {
                  paramString1 = new JSONObject(paramVarArgs[0]);
                  paramJsBridgeListener = paramString1.optString("callback");
                  paramString1 = paramString1.optString("domain");
                  if (TextUtils.isEmpty(paramString1)) {
                    break label2411;
                  }
                  paramString2 = this.mRuntime.a();
                  if ((paramString2 == null) || (!paramString2.isLogin())) {
                    break label2411;
                  }
                  paramVarArgs = paramString2.getAccount();
                  paramString2 = ((TicketManager)paramString2.getManager(2)).getPskey(paramVarArgs, paramString1);
                  if (TextUtils.isEmpty(paramString2)) {
                    break label2411;
                  }
                  paramString3 = new StringBuilder(111);
                  if (paramVarArgs.length() < 10)
                  {
                    i = paramVarArgs.length();
                    while (i < 10)
                    {
                      paramString3.append('0');
                      i += 1;
                    }
                  }
                  paramString3.append(paramVarArgs);
                  paramVarArgs = CookieManager.getInstance();
                  paramVarArgs.setAcceptCookie(true);
                  localObject1 = "http://" + paramString1 + '/';
                  paramVarArgs.setCookie((String)localObject1, "p_uin=" + paramString3 + "; PATH=/; DOMAIN=." + paramString1 + ';');
                  paramVarArgs.setCookie((String)localObject1, "p_skey=" + paramString2 + "; PATH=/; DOMAIN=." + paramString1 + ';');
                  i = 0;
                  if (TextUtils.isEmpty(paramJsBridgeListener)) {
                    break;
                  }
                  callJs(paramJsBridgeListener, new String[] { "{ret:" + i + "}" });
                }
                catch (JSONException paramJsBridgeListener) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w(b, 2, "error setPskeyByDomain", paramJsBridgeListener);
              break;
              if ((!"notifyWebStatus".equals(paramString3)) || (this.mRuntime == null)) {
                break;
              }
              paramJsBridgeListener = this.mRuntime.a();
              if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof QQBrowserActivity))) {
                break;
              }
              paramString1 = (QQBrowserActivity)paramJsBridgeListener;
              paramJsBridgeListener = new JSONObject();
              try
              {
                paramString2 = new JSONObject(paramVarArgs[0]);
                i = paramString2.getJSONObject("data").getInt("status");
                if (paramString1.E < i)
                {
                  paramString1.E = i;
                  paramString1.h = System.currentTimeMillis();
                }
                paramJsBridgeListener.put("result", 0);
                paramJsBridgeListener.put("msg", "");
                paramString2.optString("callback");
              }
              catch (JSONException paramString1)
              {
                try
                {
                  paramJsBridgeListener.put("result", -1);
                  paramJsBridgeListener.put("msg", "参数错误");
                }
                catch (JSONException paramJsBridgeListener) {}
              }
            }
            break;
            return false;
          }
          label1544:
          label1733:
          label1874:
          label1893:
          label2420:
          continue;
          label2249:
          label2423:
          if (!bool1) {
            if (!bool2) {}
          }
        }
      }
    }
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.getInstance().registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.getInstance().unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin
 * JD-Core Version:    0.7.0.1
 */