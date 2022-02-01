package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.GetKeyPlugin;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.VersionUtils;
import cooperation.qwallet.open.QWalletOpenApiCE;
import java.lang.reflect.Constructor;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewPluginEngine
{
  static final String jdField_a_of_type_JavaLangString = WebViewPluginEngine.class.getSimpleName();
  Activity jdField_a_of_type_AndroidAppActivity;
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  protected CustomWebView a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  List jdField_a_of_type_JavaUtilList;
  Map jdField_a_of_type_JavaUtilMap;
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    Object localObject = new AntiphingHandler();
    ((WebViewPlugin)localObject).initRuntime(paramCustomWebView, paramActivity, paramAppInterface);
    ((WebViewPlugin)localObject).onCreate();
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new WebViewJumpPlugin();
    ((WebViewPlugin)localObject).initRuntime(paramCustomWebView, paramActivity, paramAppInterface);
    ((WebViewPlugin)localObject).onCreate();
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new OfflinePlugin();
    ((WebViewPlugin)localObject).initRuntime(paramCustomWebView, paramActivity, paramAppInterface);
    ((WebViewPlugin)localObject).onCreate();
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new SosoPlugin();
    ((WebViewPlugin)localObject).initRuntime(paramCustomWebView, paramActivity, paramAppInterface);
    ((WebViewPlugin)localObject).onCreate();
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new ReportPlugin();
    ((WebViewPlugin)localObject).initRuntime(paramCustomWebView, paramActivity, paramAppInterface);
    ((WebViewPlugin)localObject).onCreate();
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new GetKeyPlugin();
    ((WebViewPlugin)localObject).initRuntime(paramCustomWebView, paramActivity, paramAppInterface);
    ((WebViewPlugin)localObject).onCreate();
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    int i = 0;
    while (i < WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo.length)
    {
      paramCustomWebView = WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo[i];
      if (!paramCustomWebView.jdField_a_of_type_Boolean)
      {
        paramCustomWebView = a(paramCustomWebView);
        if (paramCustomWebView != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramCustomWebView);
        }
      }
      i += 1;
    }
  }
  
  public WebViewPluginEngine(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface, List paramList)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    int i = 0;
    while (i < paramList.size())
    {
      a((WebViewPlugin)paramList.get(i));
      i += 1;
    }
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin)
  {
    paramWebViewPlugin = paramWebViewPlugin.getClass();
    int i = 0;
    int j = WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo.length;
    while (i < j)
    {
      if (paramWebViewPlugin == WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo[i].jdField_a_of_type_JavaLangClass) {
        return WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo[i].jdField_a_of_type_Int;
      }
      i += 1;
    }
    return -1;
  }
  
  private WebViewPlugin a(WebViewPluginConfig.PluginInfo paramPluginInfo)
  {
    try
    {
      System.currentTimeMillis();
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)a(paramPluginInfo.jdField_a_of_type_JavaLangClass, new Class[0]).newInstance(new Object[0]);
      a(localWebViewPlugin);
      return localWebViewPlugin;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "cannot create plugin " + paramPluginInfo.jdField_a_of_type_JavaLangClass.getSimpleName() + " : " + localException.toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(localException));
      }
    }
    return null;
  }
  
  private static Constructor a(Class paramClass, Class... paramVarArgs)
  {
    if (VersionUtils.e())
    {
      paramClass = paramClass.getConstructor(paramVarArgs);
      return paramClass;
    }
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      Constructor localConstructor = arrayOfConstructor[i];
      paramClass = localConstructor;
      if (a(paramVarArgs, localConstructor.getParameterTypes())) {
        break;
      }
      i += 1;
    }
    label59:
    throw new NoSuchMethodException();
  }
  
  private void a(WebViewPlugin paramWebViewPlugin)
  {
    paramWebViewPlugin.initRuntime(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    paramWebViewPlugin.onCreate();
  }
  
  private boolean a(WebViewPlugin paramWebViewPlugin, JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    try
    {
      System.currentTimeMillis();
      boolean bool = paramWebViewPlugin.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramArrayOfString);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "Exception in " + paramWebViewPlugin.getClass().getSimpleName() + " : " + paramJsBridgeListener.getMessage());
      }
    }
    return false;
  }
  
  private static boolean a(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length != paramArrayOfClass2.length) {
      return false;
    }
    int j = paramArrayOfClass1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label35;
      }
      if (paramArrayOfClass1[i] != paramArrayOfClass2[i]) {
        break;
      }
      i += 1;
    }
    label35:
    return true;
  }
  
  public WebViewPlugin a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo.length)) {
      return null;
    }
    Class localClass = WebViewPluginConfig.jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo[(paramInt - 1)].jdField_a_of_type_JavaLangClass;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      if (localWebViewPlugin.getClass() == localClass) {
        return localWebViewPlugin;
      }
    }
    return null;
  }
  
  public WebViewPlugin a(Class paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      if (localWebViewPlugin.getClass() == paramClass) {
        return localWebViewPlugin;
      }
    }
    return null;
  }
  
  public Object a(String paramString, int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
      System.currentTimeMillis();
      localObject1 = ((WebViewPlugin)localObject1).handleEvent(paramString, paramInt);
      if (localObject1 != null) {
        return localObject1;
      }
      i += 1;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      System.currentTimeMillis();
      localObject2 = ((WebViewPlugin)((Map.Entry)localObject2).getValue()).handleEvent(paramString, paramInt);
      if (localObject2 != null) {
        return localObject2;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)localIterator.next();
      System.currentTimeMillis();
      localWebViewPlugin.onDestroy();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        WebViewPlugin localWebViewPlugin = a((WebViewPluginConfig.PluginInfo)WebViewPluginConfig.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString[i]));
        if (localWebViewPlugin != null) {
          this.jdField_a_of_type_JavaUtilList.add(localWebViewPlugin);
        }
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if ((TextUtils.isEmpty(paramString)) || (localObject == null)) {}
    label135:
    for (;;)
    {
      return false;
      int i = paramString.indexOf(":");
      String str;
      if (i > 0)
      {
        str = paramString.substring(0, i);
        localObject = ((WebView)localObject).getUrl();
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
          this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
        }
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c((String)localObject, str)) {
          i = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label135;
          }
          localObject = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
          System.currentTimeMillis();
          if ((localObject != null) && (((WebViewPlugin)localObject).handleSchemaRequest(paramString, str)))
          {
            return true;
            str = "";
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", Integer.valueOf(paramInt2));
    paramInt2 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
        System.currentTimeMillis();
        if (localWebViewPlugin.handleEvent(paramString, paramInt1, localHashMap)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      paramInt2 += 1;
    }
  }
  
  public boolean a(String paramString, int paramInt, Map paramMap)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    Map.Entry localEntry;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        return false;
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localObject == null) {}
          do
          {
            i += 1;
            break;
            System.currentTimeMillis();
          } while (!((WebViewPlugin)localObject).handleEvent(paramString, paramInt, paramMap));
          return true;
        }
        localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      }
      localEntry = (Map.Entry)((Iterator)localObject).next();
      System.currentTimeMillis();
    } while (!((WebViewPlugin)localEntry.getValue()).handleEvent(paramString, paramInt, paramMap));
    return true;
  }
  
  public boolean b(String paramString)
  {
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localCustomWebView == null) {
      return false;
    }
    Object localObject1;
    String str;
    long l;
    int i;
    Object localObject3;
    Object localObject2;
    int j;
    if ((paramString != null) && (paramString.startsWith("jsbridge://")))
    {
      localObject1 = (paramString + "/#").split("/");
      if (localObject1.length < 5)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 4, "illegal jsbridge");
        }
        return true;
      }
      str = localObject1[2];
      l = -1L;
      if (localObject1.length == 5)
      {
        localObject1 = localObject1[3].split("#");
        if (localObject1.length > 1) {}
        for (;;)
        {
          try
          {
            i = Integer.parseInt(localObject1[1]);
            l = i;
            localObject3 = localObject1[0].split("\\?");
            if (localObject3.length <= 1) {
              break;
            }
            localObject2 = localObject3[1].split("&");
            i = 0;
            j = localObject2.length;
            localObject1 = localObject2;
            if (i >= j) {
              break label252;
            }
            int k = localObject2[i].indexOf('=');
            if (k != -1)
            {
              localObject2[i] = URLDecoder.decode(localObject2[i].substring(k + 1));
              i += 1;
            }
            else
            {
              localObject2[i] = "";
            }
          }
          catch (NumberFormatException paramString)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w(jdField_a_of_type_JavaLangString, 4, "illegal sn");
            }
            return true;
          }
        }
        localObject1 = new String[0];
        label252:
        localObject3 = localObject3[0];
        i = 0;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "calling " + str + "." + (String)localObject3);
      }
      JsBridgeListener localJsBridgeListener = new JsBridgeListener(localCustomWebView, l, paramString);
      localObject1 = localCustomWebView.getUrl();
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a((String)localObject1, str + "." + (String)localObject3))
      {
        localObject1 = null;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(str))
        {
          localObject1 = (WebViewPlugin)this.jdField_a_of_type_JavaUtilMap.get(str);
          if (localObject1 == null) {
            j = 0;
          }
        }
        else
        {
          for (;;)
          {
            for (;;)
            {
              if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
                break label671;
              }
              localObject1 = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(j);
              if (!a((WebViewPlugin)localObject1, localJsBridgeListener, paramString, str, (String)localObject3, (String[])localObject2)) {
                break label644;
              }
              this.jdField_a_of_type_JavaUtilMap.put(str, localObject1);
              return true;
              localObject3 = localObject1[3];
              try
              {
                l = Long.parseLong(localObject1[4]);
                i = localObject1.length - 6;
                localObject2 = new String[i];
                System.arraycopy(localObject1, 5, localObject2, 0, i);
                i = 0;
                j = localObject2.length;
                while (i < j)
                {
                  localObject2[i] = URLDecoder.decode(localObject2[i]);
                  i += 1;
                }
                if (!WebViewPluginConfig.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
                  break;
                }
              }
              catch (Exception paramString)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.w(jdField_a_of_type_JavaLangString, 4, "illegal sn");
                }
                return true;
              }
            }
            WebViewPlugin localWebViewPlugin = a((WebViewPluginConfig.PluginInfo)WebViewPluginConfig.jdField_a_of_type_JavaUtilMap.get(str));
            localObject1 = localWebViewPlugin;
            if (localWebViewPlugin == null) {
              break;
            }
            this.jdField_a_of_type_JavaUtilMap.put(str, localWebViewPlugin);
            this.jdField_a_of_type_JavaUtilList.add(localWebViewPlugin);
            localObject1 = localWebViewPlugin;
            break;
            label644:
            j += 1;
          }
        }
        if (a((WebViewPlugin)localObject1, localJsBridgeListener, paramString, str, (String)localObject3, (String[])localObject2)) {
          return true;
        }
        label671:
        if (i != 0) {
          if (l != -1L) {
            localCustomWebView.c("window.JsBridge&&JsBridge.callback(" + l + ",{'r':1,'result':'no such method'})");
          }
        }
      }
      for (;;)
      {
        return true;
        localObject1 = null;
        paramString = (String)localObject1;
        if (localObject2.length > 0)
        {
          paramString = (String)localObject1;
          if (!localObject2[0].startsWith("{")) {}
        }
        try
        {
          paramString = new JSONObject(localObject2[0]).optString("callback");
          if ((TextUtils.isEmpty(paramString)) && (l != -1L))
          {
            Long.toString(l);
            continue;
            localJsBridgeListener.a();
            continue;
            return false;
          }
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString = (String)localObject1;
          }
        }
      }
      i = 1;
    }
  }
  
  public boolean c(String paramString)
  {
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localCustomWebView == null) {
      return false;
    }
    if ((paramString == null) || (!paramString.startsWith("mqqopen://"))) {
      return false;
    }
    QWalletOpenApiCE localQWalletOpenApiCE = QWalletOpenApiCE.a();
    if (localQWalletOpenApiCE == null) {
      return true;
    }
    boolean bool = localQWalletOpenApiCE.a(paramString);
    String str1 = "";
    int i;
    if (!bool) {
      i = paramString.lastIndexOf('/');
    }
    for (;;)
    {
      try
      {
        localObject1 = paramString.substring(i + 1);
        if (((String)localObject1).indexOf("opentoken") == 0) {
          str1 = ((String)localObject1).substring("opentoken".length());
        }
        paramString = paramString.substring(0, i);
        paramString = "jsbridge://" + paramString.substring(10);
        localObject1 = str1;
        str1 = paramString;
        paramString = (str1 + "/#").split("/");
        if (paramString.length < 5)
        {
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 2, "illegal mqqopen protocol");
          }
          return true;
        }
      }
      catch (IndexOutOfBoundsException paramString)
      {
        paramString.printStackTrace();
        return true;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return true;
      }
      String str2 = paramString[2];
      long l = -1L;
      Object localObject2;
      String[] arrayOfString;
      int j;
      if (paramString.length == 5)
      {
        paramString = paramString[3].split("#");
        if (paramString.length > 1) {}
        for (;;)
        {
          try
          {
            i = Integer.parseInt(paramString[1]);
            l = i;
            localObject2 = paramString[0].split("\\?");
            if (localObject2.length <= 1) {
              break;
            }
            arrayOfString = localObject2[1].split("&");
            i = 0;
            j = arrayOfString.length;
            paramString = arrayOfString;
            if (i >= j) {
              break label368;
            }
            int k = arrayOfString[i].indexOf('=');
            if (k != -1)
            {
              arrayOfString[i] = URLDecoder.decode(arrayOfString[i].substring(k + 1));
              i += 1;
            }
            else
            {
              arrayOfString[i] = "";
            }
          }
          catch (NumberFormatException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.w(jdField_a_of_type_JavaLangString, 2, "illegal sn");
            }
            return true;
          }
        }
        paramString = new String[0];
        label368:
        arrayOfString = localObject2[0];
        localObject2 = paramString;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "calling " + str2 + "." + arrayOfString);
        }
        JsBridgeListener localJsBridgeListener = new JsBridgeListener(localCustomWebView, l, str1);
        if (localQWalletOpenApiCE.a(localCustomWebView.getUrl(), str1, str2, arrayOfString, bool, (String)localObject1, (String[])localObject2))
        {
          paramString = null;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(str2))
          {
            paramString = (WebViewPlugin)this.jdField_a_of_type_JavaUtilMap.get(str2);
            if (paramString == null) {
              i = 0;
            }
          }
          else
          {
            for (;;)
            {
              for (;;)
              {
                if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
                  break label740;
                }
                paramString = (WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i);
                if (!a(paramString, localJsBridgeListener, str1, str2, arrayOfString, (String[])localObject2)) {
                  break label713;
                }
                this.jdField_a_of_type_JavaUtilMap.put(str2, paramString);
                return true;
                arrayOfString = paramString[3];
                try
                {
                  l = Long.parseLong(paramString[4]);
                  i = paramString.length - 6;
                  localObject2 = new String[i];
                  System.arraycopy(paramString, 5, localObject2, 0, i);
                  i = 0;
                  j = localObject2.length;
                  while (i < j)
                  {
                    localObject2[i] = URLDecoder.decode(localObject2[i]);
                    i += 1;
                  }
                  if (!WebViewPluginConfig.jdField_a_of_type_JavaUtilMap.containsKey(str2)) {
                    break;
                  }
                }
                catch (Exception paramString)
                {
                  if (QLog.isColorLevel()) {
                    QLog.w(jdField_a_of_type_JavaLangString, 2, "illegal sn");
                  }
                  return true;
                }
              }
              localObject1 = a((WebViewPluginConfig.PluginInfo)WebViewPluginConfig.jdField_a_of_type_JavaUtilMap.get(str2));
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break;
              }
              this.jdField_a_of_type_JavaUtilMap.put(str2, localObject1);
              this.jdField_a_of_type_JavaUtilList.add(localObject1);
              paramString = (String)localObject1;
              break;
              label713:
              i += 1;
            }
          }
          if (a(paramString, localJsBridgeListener, str1, str2, arrayOfString, (String[])localObject2)) {
            return true;
          }
          label740:
          if (bool) {
            return true;
          }
          i = str1.indexOf(":");
          if (i > 0)
          {
            paramString = str1.substring(0, i);
            i = 0;
          }
          for (;;)
          {
            if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label820;
            }
            if (((WebViewPlugin)this.jdField_a_of_type_JavaUtilList.get(i)).handleSchemaRequest(str1, paramString))
            {
              return true;
              paramString = "";
              break;
            }
            i += 1;
          }
          label820:
          return true;
        }
        localJsBridgeListener.a();
        return true;
      }
      Object localObject1 = "";
      str1 = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPluginEngine
 * JD-Core Version:    0.7.0.1
 */