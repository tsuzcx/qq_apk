package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import cit;
import ciu;
import civ;
import ciw;
import cix;
import ciy;
import ciz;
import cja;
import cjb;
import cjc;
import cjd;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomWebChromeClient
  extends WebChromeClient
{
  public static final String a = "WEBVIEWCHECK";
  QQCustomDialog a;
  
  private String a(Context paramContext, String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("data:"))) {
      return paramContext.getString(2131368157);
    }
    try
    {
      paramContext = new URL(paramString).getHost();
      return paramContext;
    }
    catch (MalformedURLException paramContext) {}
    return paramString;
  }
  
  public void a()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    if (QLog.isColorLevel())
    {
      VipWebViewReportLog.a(paramConsoleMessage);
      QLog.d("WEBVIEWCHECK", 2, "CustomWebChromeClient onConsoleMessage consoleMessage:" + paramConsoleMessage.toString());
    }
    return !QLog.isColorLevel();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131365737, new cit(this, paramJsResult));
      this.a.setOnCancelListener(new ciw(this, paramJsResult));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramString1 = paramWebView.getContext();
    if (((paramString1 instanceof Activity)) && (!((Activity)paramString1).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(paramString1, 0);
      this.a.setTitle(2131368158);
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131368159, new cjd(this, paramJsResult));
      this.a.setNegativeButton(2131368160, new ciu(this, paramJsResult));
      this.a.setOnCancelListener(new civ(this, paramJsResult));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      this.a.setMessage(paramString2);
      this.a.setPositiveButton(2131365737, new cix(this, paramJsResult));
      this.a.setNegativeButton(2131365736, new ciy(this, paramJsResult));
      this.a.setOnCancelListener(new ciz(this, paramJsResult));
      this.a.show();
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).a)))
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = DialogUtil.a(localContext, 0);
      this.a.setTitle(a(localContext, paramString1));
      paramWebView = LayoutInflater.from(localContext).inflate(2130903351, null);
      paramString1 = (EditText)paramWebView.findViewById(2131297902);
      paramString1.setText(paramString3);
      ((TextView)paramWebView.findViewById(2131297901)).setText(paramString2);
      this.a.setView(paramWebView);
      this.a.setPositiveButton(2131365737, new cja(this, paramJsPromptResult, paramString1));
      this.a.setNegativeButton(2131365736, new cjb(this, paramJsPromptResult));
      this.a.setOnCancelListener(new cjc(this, paramJsPromptResult));
      this.a.show();
      return true;
    }
    paramJsPromptResult.cancel();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebChromeClient
 * JD-Core Version:    0.7.0.1
 */