package com.pay.ui.marketing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import midas.x.a;
import midas.x.bs;
import midas.x.ec;
import midas.x.ed;
import midas.x.es;
import midas.x.fm;
import midas.x.fp;
import midas.x.gj;
import midas.x.jw;
import midas.x.kl;

public class APWebMarketActivity
  extends APActivity
{
  private String a = "";
  private boolean b = false;
  
  private void a()
  {
    if (this.o != null) {
      this.o.show();
    }
    bs.a().g(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        if (paramAnonymousjw.R() == 0)
        {
          paramAnonymousjw = APWebMarketActivity.k(APWebMarketActivity.this);
          APWebMarketActivity.this.a(paramAnonymousjw);
          return;
        }
        APWebMarketActivity.l(APWebMarketActivity.this).dismiss();
        APUICommonMethod.b();
        fm.a(2, 0, -1);
      }
      
      public void b(jw paramAnonymousjw)
      {
        APWebMarketActivity.m(APWebMarketActivity.this).dismiss();
        APUICommonMethod.b();
        fm.a(2, 0, -1);
      }
      
      public void c(jw paramAnonymousjw)
      {
        APWebMarketActivity.n(APWebMarketActivity.this).dismiss();
        APUICommonMethod.b();
        fm.a(2, 0, -1);
      }
    });
  }
  
  private void a(WebView paramWebView)
  {
    try
    {
      Method localMethod = paramWebView.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
      {
        localMethod.invoke(paramWebView, new Object[] { "searchBoxJavaBridge_" });
        return;
      }
    }
    catch (Exception paramWebView)
    {
      APLog.i("removeJavascriptInterface", paramWebView.toString());
    }
  }
  
  private void a(WebView paramWebView, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramWebView.getLayoutParams();
    APLog.i("webviewclient == ", "updateWebViewSize ");
    String str = APTools.a(paramString, "mpwidth");
    boolean bool = TextUtils.isEmpty(str);
    int j = 0;
    int i;
    if (!bool) {
      i = Integer.valueOf(str).intValue();
    } else {
      i = 0;
    }
    paramString = APTools.a(paramString, "mpheight");
    if (!TextUtils.isEmpty(paramString)) {
      j = Integer.valueOf(paramString).intValue();
    }
    if ((j != 0) && (i != 0))
    {
      localLayoutParams.width = APUICommonMethod.a(this, i);
      localLayoutParams.height = APUICommonMethod.a(this, j);
      paramWebView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b()
  {
    if (this.o != null) {
      this.o.show();
    }
    bs.a().g(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        if (paramAnonymousjw.R() == 0)
        {
          paramAnonymousjw = APWebMarketActivity.k(APWebMarketActivity.this);
          APWebMarketActivity.this.a(paramAnonymousjw);
          return;
        }
        APWebMarketActivity.o(APWebMarketActivity.this).dismiss();
        APUICommonMethod.b();
        fm.a(8, 0, -1);
      }
      
      public void b(jw paramAnonymousjw)
      {
        APWebMarketActivity.p(APWebMarketActivity.this).dismiss();
        APUICommonMethod.b();
        fm.a(8, 0, -1);
      }
      
      public void c(jw paramAnonymousjw)
      {
        APWebMarketActivity.q(APWebMarketActivity.this).dismiss();
        APUICommonMethod.b();
        fm.a(8, 0, -1);
      }
    });
  }
  
  private String c()
  {
    int i = fp.a().j();
    Object localObject1 = fp.a().k();
    String str2 = fp.a().l();
    Object localObject5 = fp.a().n();
    Object localObject3 = APDataReportManager.getInstance();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("sdk.market.send");
    ((StringBuilder)localObject4).append(i);
    ((APDataReportManager)localObject3).insertData(((StringBuilder)localObject4).toString(), this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("send flag == sdk.market.send");
    ((StringBuilder)localObject3).append(i);
    APLog.i("reResultURL", ((StringBuilder)localObject3).toString());
    String str1 = "";
    try
    {
      localObject4 = URLEncoder.encode((String)localObject1, "UTF-8");
      localObject1 = localObject4;
      localObject3 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      label163:
      label166:
      break label163;
    }
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label175;
      }
      localObject3 = URLEncoder.encode((String)localObject5, "UTF-8");
      localObject1 = localObject4;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      localObject2 = localObject4;
      break label166;
    }
    localObject1 = "";
    APLog.i("goods_name_des == ", (String)localObject1);
    localObject3 = str1;
    label175:
    str1 = fp.a().h();
    localObject4 = "";
    try
    {
      if (str1.contains("?"))
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(str1);
        ((StringBuilder)localObject5).append("&present_flag=");
        ((StringBuilder)localObject5).append(i);
        ((StringBuilder)localObject5).append("&goods_name=");
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append("&goods_num=");
        ((StringBuilder)localObject5).append(str2);
        ((StringBuilder)localObject5).append("&extend=");
        ((StringBuilder)localObject5).append((String)localObject3);
        localObject1 = ((StringBuilder)localObject5).toString();
      }
      else
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(str1);
        ((StringBuilder)localObject5).append("?present_flag=");
        ((StringBuilder)localObject5).append(i);
        ((StringBuilder)localObject5).append("&goods_name=");
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append("&goods_num=");
        ((StringBuilder)localObject5).append(str2);
        ((StringBuilder)localObject5).append("&extend=");
        ((StringBuilder)localObject5).append((String)localObject3);
        localObject1 = ((StringBuilder)localObject5).toString();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
      }
    }
    APUICommonMethod.b();
    if (this.a.equals("showBankResultActivity"))
    {
      fm.a(2, 0, -1);
      localObject1 = localObject4;
    }
    else
    {
      localObject1 = localObject4;
      if (this.a.equals("showWechatResultActivity"))
      {
        fm.a(8, 0, -1);
        localObject1 = localObject4;
      }
    }
    APLog.i("result url == ", (String)localObject1);
    return localObject1;
  }
  
  public void a(String paramString)
  {
    APLog.i("APWebMarketActivity url == ", paramString);
    try
    {
      WebView localWebView = (WebView)findViewById(2131099770);
      localWebView.setScrollBarStyle(0);
      a(localWebView);
      WebSettings localWebSettings = localWebView.getSettings();
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setSupportMultipleWindows(true);
      localWebSettings.setDomStorageEnabled(false);
      localWebSettings.setAppCacheMaxSize(2097152L);
      localWebSettings.setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
      localWebSettings.setAllowFileAccess(true);
      localWebSettings.setAppCacheEnabled(true);
      localWebSettings.setCacheMode(-1);
      localWebView.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          APLog.i("webviewclient == ", "onPageFinished ");
          APWebMarketActivity.a(APWebMarketActivity.this, false);
          if (APWebMarketActivity.e(APWebMarketActivity.this) != null) {
            APWebMarketActivity.f(APWebMarketActivity.this).dismiss();
          }
          ((WebView)APWebMarketActivity.this.findViewById(2131099770)).setVisibility(0);
        }
        
        public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          APWebMarketActivity.a(APWebMarketActivity.this, paramAnonymousWebView, paramAnonymousString);
          if (!APWebMarketActivity.g(APWebMarketActivity.this))
          {
            APLog.i("webviewclient == ", "onPageStarted ");
            paramAnonymousWebView.goBack();
            if (paramAnonymousString.startsWith("http://unipay.android.mp.pay")) {
              APDataReportManager.getInstance().insertData("sdk.market.sure", APWebMarketActivity.h(APWebMarketActivity.this), null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
            }
          }
          try
          {
            es.a().a(APWebMarketActivity.this, ed.b().n().a);
          }
          catch (Exception localException)
          {
            label98:
            break label98;
          }
          APUICommonMethod.a(APWebMarketActivity.this, "网络错误，请稍后重试");
          break label278;
          if (paramAnonymousString.startsWith("http://unipay.android.mp.back"))
          {
            APDataReportManager.getInstance().insertData("sdk.market.cancel", APWebMarketActivity.i(APWebMarketActivity.this), null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
            paramAnonymousWebView.stopLoading();
            fm.a(2, "");
            APWebMarketActivity.this.finish();
            APUICommonMethod.b(APWebMarketActivity.this);
          }
          else if (paramAnonymousString.startsWith("http://unipay.android.mp.retback"))
          {
            APDataReportManager.getInstance().insertData("sdk.market.result.cancel", APWebMarketActivity.j(APWebMarketActivity.this), null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
            APUICommonMethod.b();
            if (APWebMarketActivity.d(APWebMarketActivity.this).equals("showWechatResultActivity")) {
              fm.a(8, 0, 0);
            } else if (APWebMarketActivity.d(APWebMarketActivity.this).equals("showBankResultActivity")) {
              fm.a(2, 0, 0);
            }
          }
          label278:
          super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          APLog.i("webviewclient == ", "onReceivedError ");
          if (paramAnonymousString2.startsWith("http://unipay.android.mp.pay")) {
            paramAnonymousWebView.stopLoading();
          } else if (paramAnonymousString2.startsWith("http://unipay.android.mp.back")) {
            paramAnonymousWebView.stopLoading();
          }
          super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          APWebMarketActivity.a(APWebMarketActivity.this, paramAnonymousWebView, paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          if (paramAnonymousString.startsWith("http://unipay.android.mp.pay"))
          {
            APLog.i("webviewclient == ", "shouldOverrideUrlLoading");
            APDataReportManager.getInstance().insertData("sdk.market.sure", APWebMarketActivity.a(APWebMarketActivity.this), null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
          }
          try
          {
            es.a().a(APWebMarketActivity.this, ed.b().n().a);
          }
          catch (Exception localException)
          {
            label88:
            break label88;
          }
          APUICommonMethod.a(APWebMarketActivity.this, "网络错误，请稍后重试");
          break label268;
          if (paramAnonymousString.startsWith("http://unipay.android.mp.back"))
          {
            APDataReportManager.getInstance().insertData("sdk.market.cancel", APWebMarketActivity.b(APWebMarketActivity.this), null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
            paramAnonymousWebView.stopLoading();
            fm.a(2, "");
            APWebMarketActivity.this.finish();
            APUICommonMethod.b(APWebMarketActivity.this);
          }
          else if (paramAnonymousString.startsWith("http://unipay.android.mp.retback"))
          {
            APDataReportManager.getInstance().insertData("sdk.market.result.cancel", APWebMarketActivity.c(APWebMarketActivity.this), null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
            APUICommonMethod.b();
            if (APWebMarketActivity.d(APWebMarketActivity.this).equals("showWechatResultActivity")) {
              fm.a(8, 0, 0);
            } else if (APWebMarketActivity.d(APWebMarketActivity.this).equals("showBankResultActivity")) {
              fm.a(2, 0, 0);
            }
          }
          label268:
          APWebMarketActivity.a(APWebMarketActivity.this, true);
          return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
        }
      });
      a(localWebView, paramString);
      localWebView.loadUrl(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.o != null) {
      this.o.show();
    }
    a.a().f = true;
    paramBundle = getIntent().getExtras();
    try
    {
      this.a = paramBundle.getString("loadUI");
      label45:
      paramBundle = ed.b().n().a.mpInfo.discountUrl;
      if (this.a.equals("showStartActivity"))
      {
        setContentView(2131165237);
        a(ed.b().n().a.mpInfo.discountUrl);
        return;
      }
      if (this.a.equals("showBankResultActivity"))
      {
        setContentView(2131165239);
        a();
        return;
      }
      if (this.a.equals("showWechatResultActivity"))
      {
        setContentView(2131165239);
        b();
        return;
      }
      fm.a(-1, "活动url为空");
      return;
    }
    catch (Exception paramBundle)
    {
      break label45;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.o != null) {
        this.o.dismiss();
      }
      if (this.a.equals("showStartActivity"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.keyback", this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
        APUICommonMethod.b();
        fm.a(2, "");
      }
      else if (this.a.equals("showBankResultActivity"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.result.keyback", this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
        APUICommonMethod.b();
        fm.a(2, 0, -1);
      }
      else if (this.a.equals("showWechatResultActivity"))
      {
        APDataReportManager.getInstance().insertData("sdk.market.result.keyback", this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
        APUICommonMethod.b();
        fm.a(8, 0, -1);
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a.equals("showStartActivity"))
    {
      APDataReportManager.getInstance().insertData("sdk.market.show", this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
      return;
    }
    if (this.a.equals("showBankResultActivity"))
    {
      APDataReportManager.getInstance().insertData("sdk.market.result.show", this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
      APLog.i("onResume", "结果result show");
      return;
    }
    if (this.a.equals("showWechatResultActivity")) {
      APDataReportManager.getInstance().insertData("sdk.market.result.show", this.f, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.marketing.APWebMarketActivity
 * JD-Core Version:    0.7.0.1
 */