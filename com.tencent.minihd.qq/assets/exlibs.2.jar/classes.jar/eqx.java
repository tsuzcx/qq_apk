import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class eqx
  extends CustomWebViewClient
{
  public eqx(QQBrowserActivity paramQQBrowserActivity, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    String str1;
    int i;
    label216:
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.n) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.k))
    {
      str1 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
        str1 = "use bid " + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
      }
      int k = (int)((System.nanoTime() - QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L);
      Object localObject = HttpUtil.a() + "";
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Y;
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (!QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label632;
      }
      i = 1;
      if (!QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label637;
      }
      j = 1;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url", 0, 1, k, (String)localObject, str2, str1, j + (i << 1));
      str1 = HttpUtil.a() + "";
      l = (System.nanoTime() - QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L;
      if (!WebProcessManager.b()) {
        break label643;
      }
      i = 1;
      label302:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.t) {
        break label648;
      }
    }
    label643:
    label648:
    for (int j = 1;; j = 0)
    {
      ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, str1, String.valueOf(l), String.valueOf(i), String.valueOf(j));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_load_url, cost = " + (System.nanoTime() - QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L + ", url = " + Util.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Y, new String[0]) + ", isFromLeba = " + QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) + ", hasRedDot = " + QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.n = false;
      super.onPageFinished(paramWebView, paramString);
      if (paramWebView == this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizPubaccountCustomWebView)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.u)
        {
          if (!QQBrowserActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
          }
          QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
        }
      }
      if ((QQBrowserActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) && (!QQBrowserActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)))
      {
        QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, true);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, Util.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M, new String[0]), "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramWebView, paramString);
      if ((Build.VERSION.SDK_INT >= 19) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.k))
      {
        paramString = paramWebView.getTitle();
        QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).onReceivedTitle(paramWebView, paramString);
      }
      return;
      label632:
      i = 0;
      break;
      label637:
      j = 0;
      break label216;
      i = 0;
      break label302;
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    String str1;
    int i;
    label232:
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.m) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.k))
    {
      str1 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
        str1 = "use bid " + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
      }
      QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, System.nanoTime());
      int k = (int)((QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) - QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L);
      Object localObject = HttpUtil.a() + "";
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Y;
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (!QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label606;
      }
      i = 1;
      if (!QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label612;
      }
      j = 1;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_load_url", 0, 1, k, (String)localObject, str2, str1, j + (i << 1));
      str1 = HttpUtil.a() + "";
      l = (QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) - QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L;
      if (!WebProcessManager.b()) {
        break label618;
      }
      i = 1;
      label324:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.t) {
        break label624;
      }
    }
    label606:
    label612:
    label618:
    label624:
    for (int j = 1;; j = 0)
    {
      ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, str1, String.valueOf(l), String.valueOf(i), String.valueOf(j));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_load_url, cost = " + (QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) - QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L + ", url = " + Util.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Y, new String[0]) + ", isFromLeba = " + QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) + ", hasRedDot = " + QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity));
      }
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBitmap = null;
      if (!TextUtils.isEmpty(paramString)) {
        paramBitmap = Uri.parse(paramString);
      }
      if ((paramBitmap != null) && (paramBitmap.isHierarchical()) && ("simple".equals(paramBitmap.getQueryParameter("style"))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(false);
        QQBrowserActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.j = true;
      }
      QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.m)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.m = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_d_of_type_Long = System.currentTimeMillis();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b(paramWebView, paramString);
      return;
      i = 0;
      break;
      j = 0;
      break label232;
      i = 0;
      break label324;
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramWebView, paramInt, paramString1, paramString2);
    QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.e("QQBrowser", 2, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + Util.b(paramString2, new String[0]));
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    int j;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.l)
    {
      paramWebView = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
        if ((paramString1 != null) && ((paramString1 instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)paramString1);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
        paramWebView = "use bid " + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
      }
      j = (int)((System.nanoTime() - QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) / 1000000L);
      paramString1 = HttpUtil.a() + "";
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Y;
      localStringBuilder = new StringBuilder().append("");
      if (!QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label329;
      }
      paramInt = 1;
      if (!QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label334;
      }
    }
    label329:
    label334:
    for (int i = 1;; i = 0)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url_error", 0, 1, j, paramString1, paramString2, paramWebView, i + (paramInt << 1));
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "shouldOverrideUrlLoading " + Util.b(paramString, new String[0]));
    }
    if (("".equals(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {
      return true;
    }
    try
    {
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.q = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.f = System.currentTimeMillis();
        if ((QQBrowserActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) && (QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) == 0)) {
          QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setBackgroundResource(2130842088);
        }
      }
      if (super.shouldOverrideUrlLoading(paramWebView, paramString)) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramWebView, paramString)) {
        return true;
      }
      QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M = paramString;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M, 14, null))) {
          return true;
        }
        if (QQBrowserActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
      }
    }
    catch (RuntimeException paramWebView)
    {
      paramString = QLog.getStackTraceString(paramWebView);
      Toast.makeText(BaseApplicationImpl.getContext(), paramWebView.toString(), 1).show();
      if (paramString.length() <= 255) {}
    }
    for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("QQBrowser", 2, paramString);
      }
      Uri localUri;
      String str1;
      int i;
      do
      {
        if (QQBrowserActivity.j(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        return true;
        localUri = Uri.parse(paramString);
        str1 = localUri.getScheme();
        int j = 0;
        i = j;
        if ("androidqqmusic".equals(str1))
        {
          String str2 = localUri.getHost();
          i = j;
          if (str2 != null)
          {
            i = j;
            if (!str2.contains("action=download")) {
              i = 1;
            }
          }
        }
      } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isResume()) || ((System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.i >= 1000L) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), str1).booleanValue())) || (i != 0));
      paramWebView = new Intent("android.intent.action.VIEW", localUri);
      paramWebView.addFlags(268435456);
      if (paramString.startsWith("mqqapi://tenpay/pay?")) {
        paramWebView.putExtra("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
      }
      for (;;)
      {
        try
        {
          QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
        }
        catch (ActivityNotFoundException paramWebView) {}
        break;
        if (paramString.startsWith("mqqwpa://im")) {
          paramWebView.putExtra("from", "webview");
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqx
 * JD-Core Version:    0.7.0.1
 */