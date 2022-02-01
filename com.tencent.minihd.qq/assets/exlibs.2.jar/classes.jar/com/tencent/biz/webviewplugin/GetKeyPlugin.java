package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class GetKeyPlugin
  extends WebViewPlugin
{
  protected final int a;
  protected AuthorizeConfig a;
  protected String a;
  protected Thread a;
  protected boolean a;
  protected final int b;
  protected String b;
  protected final int c;
  protected String c;
  protected final int d;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  public GetKeyPlugin()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
  }
  
  private boolean a(String paramString)
  {
    AppInterface localAppInterface = this.mRuntime.a();
    localObject7 = this.mRuntime.a().getIntent();
    if (((Intent)localObject7).getBooleanExtra("ignoreLoginWeb", false)) {
      return false;
    }
    localCookieManager = CookieManager.getInstance();
    localCookieManager.removeAllCookie();
    localCookieManager.setAcceptCookie(true);
    localObject4 = "0";
    Object localObject1 = localObject4;
    if (localAppInterface != null)
    {
      localObject1 = localObject4;
      if (localAppInterface.isLogin())
      {
        localObject1 = localAppInterface.getAccount();
        if (((String)localObject1).length() >= 10) {
          break label263;
        }
        localObject4 = new StringBuilder("o");
        i = ((String)localObject1).length();
        while (i < 10)
        {
          ((StringBuilder)localObject4).append("0");
          i += 1;
        }
      }
    }
    label263:
    for (localObject1 = (String)localObject1;; localObject1 = "o" + (String)localObject1)
    {
      localCookieManager.setCookie("https://ptlogin2.qq.com/", "superuin=" + (String)localObject1 + "; PATH=/; DOMAIN=.ptlogin2.qq.com;");
      localObject4 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        localObject5 = localObject4[i];
        localCookieManager.setCookie("https://www." + (String)localObject5 + '/', "uin=" + (String)localObject1 + "; PATH=/; DOMAIN=." + (String)localObject5 + ';');
        i += 1;
      }
    }
    localObject4 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b();
    j = localObject4.length;
    i = 0;
    while (i < j)
    {
      localObject5 = localObject4[i];
      localCookieManager.setCookie("https://www." + (String)localObject5 + '/', "p_uin=" + (String)localObject1 + "; PATH=/; DOMAIN=." + (String)localObject5 + ';');
      i += 1;
    }
    if ((localAppInterface != null) && (localAppInterface.isLogin()))
    {
      if (paramString.startsWith("file:"))
      {
        bool1 = true;
        bool2 = false;
        localObject5 = "";
        localObject4 = "qq.com";
        j = 0;
        localObject6 = "";
      }
      for (;;)
      {
        if (!((Intent)localObject7).getBooleanExtra("avoidLoginWeb", false)) {
          break label760;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c();
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject6 = localObject1[i];
            localCookieManager.setCookie("https://www." + (String)localObject6 + '/', "skey=; PATH=/; DOMAIN=." + (String)localObject6 + ';');
            i += 1;
            continue;
            localObject1 = Uri.parse(paramString);
            localObject4 = null;
            if (localObject1 != null) {}
            try
            {
              for (localObject1 = ((Uri)localObject1).getQueryParameter("refer");; localObject1 = null)
              {
                if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!"Qzone".equals(localObject1))) {
                  break label652;
                }
                localObject1 = "";
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label665;
                }
                i = 1;
                localObject4 = Util.c(paramString);
                localObject5 = Util.d(paramString);
                bool2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b((String)localObject5);
                bool1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString);
                j = i;
                localObject6 = localObject1;
                break;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
                localObject2 = localObject4;
                if (QLog.isColorLevel())
                {
                  QLog.d(this.TAG, 2, "GetKeyPluin: invalid refer");
                  localObject2 = localObject4;
                  continue;
                  label652:
                  localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString);
                  continue;
                  label665:
                  i = 0;
                }
              }
            }
          }
        }
      }
      localCookieManager.setCookie("https://ptlogin2.qq.com/", "superkey=; PATH=/; DOMAIN=.ptlogin2.qq.com; HttpOnly;");
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b((String)localObject5)) {
        localCookieManager.setCookie(paramString, "p_skey=; PATH=/; DOMAIN=." + (String)localObject5 + ';');
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString)) {
        localCookieManager.setCookie(paramString, "vkey=; PATH=/; DOMAIN=." + (String)localObject4 + ';');
      }
    }
    return false;
    label760:
    i = 0;
    try
    {
      localObject7 = Uri.parse(paramString).getQueryParameter("_bid");
      localObject2 = localObject7;
      if (TextUtils.isEmpty((CharSequence)localObject7)) {
        localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.b(paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        i = Integer.parseInt((String)localObject2);
      }
      k = i;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        long l1;
        localException2.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "GetKeyPluin: invalid bid");
        }
        int k = 0;
        continue;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          i = 1;
        }
        else if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          i = 2;
          continue;
          j = paramString.charAt(i - 1);
          if ((j != 63) && (j != 35) && (j != 38)) {
            continue;
          }
          if (i > -1)
          {
            j = localException2.length() + i;
            i = j;
            if (i < paramString.length())
            {
              k = paramString.charAt(i);
              if ((k != 38) && (k != 35)) {}
            }
            else
            {
              localObject3 = paramString.substring(0, j) + this.jdField_a_of_type_JavaLangString + paramString.substring(i);
              if (!TextUtils.isEmpty(this.e))
              {
                localCookieManager.setCookie("https://ptlogin2.qq.com/", "superkey=" + this.e + "; PATH=/; DOMAIN=.ptlogin2.qq.com; HttpOnly;");
                localCookieManager.setCookie("https://ptlogin2.qq.com/", "supertoken=" + this.g + "; PATH=/; DOMAIN=.ptlogin2.qq.com;");
              }
              paramString = (String)localObject3;
              if (bool2)
              {
                if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
                  break label1658;
                }
                localCookieManager.setCookie((String)localObject3, "p_skey=" + this.jdField_d_of_type_JavaLangString + "; PATH=/; DOMAIN=." + (String)localObject5 + ';');
                paramString = (String)localObject3;
              }
            }
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
            {
              localObject3 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c();
              j = localObject3.length;
              i = 0;
              for (;;)
              {
                if (i < j)
                {
                  localObject5 = localObject3[i];
                  localCookieManager.setCookie("https://www." + (String)localObject5 + '/', "skey=" + this.jdField_c_of_type_JavaLangString + "; PATH=/; DOMAIN=." + (String)localObject5 + ';');
                  i += 1;
                  continue;
                  i += 1;
                  break;
                  localObject3 = Uri.parse(paramString).buildUpon().appendQueryParameter((String)localObject6, this.jdField_a_of_type_JavaLangString).toString();
                  break label1384;
                  localObject5 = localCookieManager.getCookie((String)localObject3);
                  if (localObject5 != null)
                  {
                    paramString = (String)localObject3;
                    if (((String)localObject5).contains("p_skey=")) {
                      break label1522;
                    }
                  }
                  paramString = (String)localObject3;
                  if (TextUtils.isEmpty(this.f)) {
                    break label1522;
                  }
                  localObject5 = new StringBuilder("http");
                  if (this.jdField_a_of_type_Boolean)
                  {
                    paramString = "s";
                    localObject5 = ((StringBuilder)localObject5).append(paramString).append("://");
                    if (!this.jdField_a_of_type_Boolean) {
                      break label1833;
                    }
                    paramString = "ssl.";
                    localObject5 = ((StringBuilder)localObject5).append(paramString).append("ptlogin2.qq.com/jump?clientuin=").append((String)localObject7).append("&clientkey=").append(this.f).append("&keyindex=19&pt_mq=");
                    if (!((String)localObject3).startsWith("https://s.p.qq.com")) {
                      break label1839;
                    }
                  }
                  for (paramString = "1";; paramString = "0")
                  {
                    paramString = paramString + "&u1=" + URLEncoder.encode((String)localObject3);
                    break;
                    paramString = "";
                    break label1722;
                    paramString = "";
                    break label1747;
                  }
                }
              }
            }
          }
          if ((bool1) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
            localCookieManager.setCookie("https://www." + (String)localObject4 + '/', "vkey=" + this.jdField_b_of_type_JavaLangString + "; PATH=/; DOMAIN=." + (String)localObject4 + ';');
          }
          CookieSyncManager.getInstance().sync();
          if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
            ((QQBrowserActivity)this.mRuntime.a()).M = paramString;
          }
          return false;
        }
      }
    }
    l1 = System.currentTimeMillis();
    Object localObject2 = (TicketManager)localAppInterface.getManager(2);
    localObject7 = localAppInterface.getAccount();
    this.jdField_a_of_type_JavaLangString = ((TicketManager)localObject2).getSid((String)localObject7);
    this.jdField_b_of_type_JavaLangString = ((TicketManager)localObject2).getVkey((String)localObject7);
    this.jdField_c_of_type_JavaLangString = ((TicketManager)localObject2).getSkey((String)localObject7);
    this.e = ((TicketManager)localObject2).getSuperkey((String)localObject7);
    this.f = ((TicketManager)localObject2).getStweb((String)localObject7);
    if ((!bool2) || ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
    {
      i = 3;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "get_key_finish", OfflineDownloader.a(localAppInterface.getApplication()), 1, (int)(System.currentTimeMillis() - l1), "", "" + k, "" + i, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, "getkey time:" + (System.currentTimeMillis() - l1));
      }
      if (TextUtils.isEmpty(this.e)) {}
    }
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).update(this.e.getBytes());
      localObject2 = ((MessageDigest)localObject2).digest();
      i = localObject2.length;
      l1 = localObject2[(i - 4)] & 0xFF;
      long l2 = (localObject2[(i - 3)] & 0xFF) << 16;
      long l3 = (localObject2[(i - 2)] & 0xFF) << 8;
      this.g = Long.toString(localObject2[(i - 1)] & 0xFF | l1 << 24 | l2 | l3);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label1159:
      Object localObject3;
      break label1159;
      i = 0;
    }
    localObject2 = paramString;
    if (j != 0)
    {
      localObject2 = (String)localObject6 + '=';
      for (i = paramString.indexOf((String)localObject2);; i = paramString.indexOf((String)localObject2, i + ((String)localObject2).length()))
      {
        if (i == -1) {
          break label1307;
        }
        if (i != 0) {
          break;
        }
      }
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 21) {
      return a(paramString);
    }
    return false;
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    this.jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("ptlogin_flag" + this.mRuntime.a().getAccount(), false);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "mPtloginFlag: " + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.isAlive())) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.GetKeyPlugin
 * JD-Core Version:    0.7.0.1
 */