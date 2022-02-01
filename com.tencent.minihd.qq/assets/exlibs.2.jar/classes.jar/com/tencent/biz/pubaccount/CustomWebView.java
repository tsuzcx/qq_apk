package com.tencent.biz.pubaccount;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import cje;
import cjf;
import cjg;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CustomWebView
  extends com.tencent.smtt.sdk.WebView
{
  public static final String a = "webviewLoad";
  public static final String b = "WEBVIEWCHECK";
  public static final String c;
  static final String d = "((0))";
  static final String e = "((1))";
  static final String f = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
  static String g = null;
  private static String h;
  CustomWebView.ScrollInterface jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface;
  protected WebViewPluginEngine a;
  boolean jdField_a_of_type_Boolean = true;
  public boolean b = false;
  private boolean c;
  
  static
  {
    jdField_c_of_type_JavaLangString = CustomWebView.class.getSimpleName();
    h = null;
  }
  
  public CustomWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  private void a()
  {
    try
    {
      b(this);
      if ((((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled()) && (Build.VERSION.SDK_INT < 19))
      {
        Object localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("isX5Core");
        ((Field)localObject1).setAccessible(true);
        if (!((Boolean)((Field)localObject1).get(this)).booleanValue())
        {
          localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("mSysWebView");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(this);
          Object localObject2 = android.webkit.WebView.class.getDeclaredField("mProvider");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          localObject2 = Class.forName("android.webkit.WebViewClassic").getDeclaredField("mAccessibilityInjector");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          Field localField = Class.forName("android.webkit.AccessibilityInjector").getDeclaredField("mTextToSpeech");
          localField.setAccessible(true);
          localObject1 = localField.get(localObject2);
          if (localObject1 != null)
          {
            localField.set(localObject2, null);
            localObject2 = Class.forName("android.webkit.AccessibilityInjector.TextToSpeechWrapper").getDeclaredMethod("shutdown", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            ((Method)localObject2).invoke(localObject1, new Object[0]);
          }
        }
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "destroy_webview", 0, 1, 0, localIllegalArgumentException.toString(), "", "", "");
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "destroy_webview", 0, 1, 0, localException.toString(), "", "", "");
      localException.printStackTrace();
    }
  }
  
  protected static void b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(h))) {
      return;
    }
    long l = System.currentTimeMillis();
    h = paramString;
    String str = paramString;
    if (paramString.length() > 512) {
      str = paramString.substring(0, 512);
    }
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    paramString = str;
    if (arrayOfStackTraceElement.length > 2) {
      paramString = str + " at " + arrayOfStackTraceElement[2].toString();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("webviewLoad", 4, "cost:" + (System.currentTimeMillis() - l) + " " + paramString);
    }
    StatisticCollector.a(null).a("webviewLoad", paramString);
  }
  
  public void a(String paramString)
  {
    if (this.b) {
      return;
    }
    super.loadUrl(paramString);
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_c_of_type_JavaLangString, 2, QLog.getStackTraceString(new Throwable("func is empty")));
      }
      return;
    }
    Object localObject;
    if (g == null)
    {
      localObject = AuthorizeConfig.a().a("jscallback", null);
      if ((localObject == null) || (!((String)localObject).contains("((0))")) || (!((String)localObject).contains("((1))"))) {
        break label153;
      }
    }
    label153:
    for (g = (String)localObject;; g = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);")
    {
      localObject = new StringBuilder();
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || ("".equals(paramVarArgs[0]))) {
        break;
      }
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      int i = 1;
      int j = paramVarArgs.length;
      while (i < j)
      {
        ((StringBuilder)localObject).append(',').append(paramVarArgs[i]);
        i += 1;
      }
    }
    ((StringBuilder)localObject).append("void(0)");
    c(g.replace("((0))", Util.b(paramString)).replace("((1))", (CharSequence)localObject));
  }
  
  public void c(String paramString)
  {
    if (this.b) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        super.loadUrl("javascript:" + paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    post(new cjg(this, paramString));
  }
  
  public void destroy()
  {
    this.b = true;
    if (!this.jdField_c_of_type_Boolean) {
      postDelayed(new cje(this), 1000L);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1);
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b("[" + Util.b(paramString1, new String[0]) + "]" + paramString2);
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.b) {}
    do
    {
      return;
      if ((paramString != null) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        b(Util.b(paramString, new String[0]));
      }
      if (QLog.isColorLevel())
      {
        QLog.d("WEBVIEWCHECK", 2, "CustomWebView loadUrl url:" + paramString);
        VipWebViewReportLog.a(paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null)
      {
        super.loadUrl(paramString);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.b(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(paramString)));
    super.loadUrl(paramString);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_c_of_type_Boolean = false;
    if (this.b) {
      postDelayed(new cjf(this), 1000L);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Boolean = true;
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Boolean = false;
    super.onResume();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnCustomScroolChangeListener(CustomWebView.ScrollInterface paramScrollInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface = paramScrollInterface;
  }
  
  public void setPluginEngine(WebViewPluginEngine paramWebViewPluginEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = paramWebViewPluginEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView
 * JD-Core Version:    0.7.0.1
 */