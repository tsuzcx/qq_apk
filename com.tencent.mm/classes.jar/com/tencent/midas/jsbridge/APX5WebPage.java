package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APProgressDialog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;

public class APX5WebPage
  implements IAPWebPage
{
  private static final int HEADER_BACK = 1;
  private static final int HEADER_CLOSE = 2;
  private static final int HEADER_REFRESH = 4;
  private static final String TAG = "APX5WebPage";
  private Activity activity;
  protected ProgressDialog waitDialog;
  protected APX5WebView webView;
  private IAPX5WebViewCallback webviewCallback;
  
  public APX5WebPage()
  {
    AppMethodBeat.i(217017);
    this.webView = null;
    this.webviewCallback = new IAPX5WebViewCallback()
    {
      public boolean WebChromeClientJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(217089);
        APLog.d("APX5WebPage", "WebChromeClientJsAlert message=".concat(String.valueOf(paramAnonymousString2)));
        APWebProtocol.AnalyzeWebEntry(APX5WebPage.this.activity, APX5WebPage.this.webView.getWebView(), APX5WebPage.this, paramAnonymousString2);
        AppMethodBeat.o(217089);
        return true;
      }
      
      public boolean WebChromeClientJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        return true;
      }
      
      public void WebViewClientPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(217102);
        if ((!APX5WebPage.this.activity.isFinishing()) && (APX5WebPage.this.waitDialog != null) && (APX5WebPage.this.waitDialog.isShowing())) {
          APX5WebPage.this.waitDialog.dismiss();
        }
        AppMethodBeat.o(217102);
      }
      
      public void WebViewClientPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(217110);
        APX5WebPage.this.waitDialog.show();
        AppMethodBeat.o(217110);
      }
      
      public void WebViewClientReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(217115);
        if ((!APX5WebPage.this.activity.isFinishing()) && (APX5WebPage.this.waitDialog != null) && (APX5WebPage.this.waitDialog.isShowing())) {
          APX5WebPage.this.waitDialog.dismiss();
        }
        AppMethodBeat.o(217115);
      }
    };
    AppMethodBeat.o(217017);
  }
  
  protected APProgressDialog createDialog()
  {
    AppMethodBeat.i(217081);
    APProgressDialog localAPProgressDialog = new APProgressDialog(this.activity);
    localAPProgressDialog.setMessage("请稍候...");
    AppMethodBeat.o(217081);
    return localAPProgressDialog;
  }
  
  public void initHead(final Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217061);
    for (;;)
    {
      try
      {
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.head.init", "", "headControl=" + paramString1 + "&headTitle=" + paramString2);
        int i;
        try
        {
          i = Integer.valueOf(paramString1).intValue();
          paramString1 = paramString2;
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = APMidasTools.urlDecode(paramString2, 1);
          }
          paramString2 = (LinearLayout)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_layout"));
          if ((i <= 0) && (TextUtils.isEmpty(paramString1))) {
            paramString2.setVisibility(8);
          }
        }
        catch (Exception paramString1)
        {
          i = 0;
          continue;
          paramString2.setVisibility(0);
          paramString2 = (TextView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_title"));
          if (TextUtils.isEmpty(paramString1)) {
            break label282;
          }
        }
        paramString2.setVisibility(0);
        paramString2.setText(paramString1);
        paramString1 = (ImageButton)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_back"));
        if ((i & 0x1) != 1) {
          break label291;
        }
        paramString1.setVisibility(0);
        paramString1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217105);
            APLog.d("APX5WebPage", "backBtn() clicked");
            if ((APX5WebPage.this.webView != null) && (APX5WebPage.this.webView.getWebView() != null)) {}
            for (boolean bool = true;; bool = false)
            {
              APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.x5.back", "", "webviewNotNull=".concat(String.valueOf(bool)));
              if ((bool) && (APX5WebPage.this.webView.getWebView().canGoBack())) {
                APX5WebPage.this.webView.getWebView().goBack();
              }
              AppMethodBeat.o(217105);
              return;
            }
          }
        });
        paramString1 = (ImageButton)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_close"));
        if ((i & 0x2) != 2) {
          break label300;
        }
        paramString1.setVisibility(0);
        paramString1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217111);
            APLog.d("APX5WebPage", "closeBtn() clicked");
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.x5.close", "", "");
            paramAnonymousView = new APMidasResponse();
            paramAnonymousView.resultCode = 100;
            paramAnonymousView.resultMsg = "关闭";
            APMidasPayHelper.midasCallBack(paramAnonymousView);
            paramActivity.finish();
            AppMethodBeat.o(217111);
          }
        });
        paramActivity = (ImageButton)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_refresh"));
        if ((i & 0x4) != 4) {
          break;
        }
        paramActivity.setVisibility(0);
        paramActivity.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217129);
            APLog.d("APX5WebPage", "refreshBtn() clicked");
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.x5.refresh", "", "");
            if ((APX5WebPage.this.webView != null) && (APX5WebPage.this.webView.getWebView() != null)) {
              APX5WebPage.this.webView.getWebView().reload();
            }
            AppMethodBeat.o(217129);
          }
        });
      }
      finally
      {
        AppMethodBeat.o(217061);
        return;
      }
      label282:
      paramString2.setVisibility(8);
      continue;
      label291:
      paramString1.setVisibility(8);
      continue;
      label300:
      paramString1.setVisibility(8);
    }
    paramActivity.setVisibility(8);
    AppMethodBeat.o(217061);
  }
  
  public void initUI(Activity paramActivity)
  {
    AppMethodBeat.i(217045);
    this.activity = paramActivity;
    paramActivity.setContentView(APMidasCommMethod.getLayoutId(paramActivity, "unipay_layout_activity_web_x5"));
    this.webView = new APX5WebView(paramActivity, (WebView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "unipay_id_WebView")), this.webviewCallback);
    this.waitDialog = createDialog();
    this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(217045);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(217037);
    this.webView.loadUrl(paramString);
    AppMethodBeat.o(217037);
  }
  
  public void toPureH5Pay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(217028);
    this.activity = paramActivity;
    paramActivity.setContentView(APMidasCommMethod.getLayoutId(paramActivity, "unipay_layout_activity_web_x5"));
    paramAPMidasBaseRequest = (WebView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "unipay_id_WebView"));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAPMidasBaseRequest.getLayoutParams();
    localLayoutParams.width = ((int)(localDisplayMetrics.widthPixels * 0.85F));
    localLayoutParams.height = ((int)(localDisplayMetrics.heightPixels * 0.85F));
    paramAPMidasBaseRequest.setLayoutParams(localLayoutParams);
    this.webView = new APX5WebView(paramActivity, paramAPMidasBaseRequest, this.webviewCallback);
    this.waitDialog = createDialog();
    this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(217028);
  }
  
  public void updateWebViewSize(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(217072);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.webView.getWebView().getLayoutParams();
    APLog.i("webviewclient == ", "updateWebViewSize ");
    String str = APMidasTools.getUrlParamsValue(paramString, "mpwidth");
    if (!TextUtils.isEmpty(str)) {}
    for (int i = Integer.valueOf(str).intValue();; i = 0)
    {
      paramString = APMidasTools.getUrlParamsValue(paramString, "mpheight");
      if (!TextUtils.isEmpty(paramString)) {
        j = Integer.valueOf(paramString).intValue();
      }
      if ((j != 0) && (i != 0))
      {
        localLayoutParams.width = APMidasCommMethod.dip2px(this.activity, i);
        localLayoutParams.height = APMidasCommMethod.dip2px(this.activity, j);
        this.webView.getWebView().setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(217072);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APX5WebPage
 * JD-Core Version:    0.7.0.1
 */