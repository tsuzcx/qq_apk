package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
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

public class APSystemWebPage
  implements IAPWebPage
{
  private static final int HEADER_BACK = 1;
  private static final int HEADER_CLOSE = 2;
  private static final int HEADER_REFRESH = 4;
  private static final String TAG = "APSystemWebPage";
  private Activity activity;
  private APProgressDialog waitDialog;
  private APWebView webView;
  private IAPWebViewCallback webviewCallback;
  
  public APSystemWebPage()
  {
    AppMethodBeat.i(217130);
    this.webviewCallback = new IAPWebViewCallback()
    {
      public boolean WebChromeClientJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(217071);
        APLog.d("APSystemWebPage", "WebChromeClientJsAlert message=".concat(String.valueOf(paramAnonymousString2)));
        APWebProtocol.AnalyzeWebEntry(APSystemWebPage.this.activity, APSystemWebPage.this.webView.getWebView(), APSystemWebPage.this, paramAnonymousString2);
        AppMethodBeat.o(217071);
        return true;
      }
      
      public boolean WebChromeClientJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        return true;
      }
      
      public void WebViewClientPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(217087);
        if ((!APSystemWebPage.this.activity.isFinishing()) && (APSystemWebPage.this.waitDialog != null) && (APSystemWebPage.this.waitDialog.isShowing())) {
          APSystemWebPage.this.waitDialog.dismiss();
        }
        AppMethodBeat.o(217087);
      }
      
      public void WebViewClientPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(217097);
        APSystemWebPage.this.waitDialog.show();
        AppMethodBeat.o(217097);
      }
      
      public void WebViewClientReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(217103);
        if ((!APSystemWebPage.this.activity.isFinishing()) && (APSystemWebPage.this.waitDialog != null) && (APSystemWebPage.this.waitDialog.isShowing())) {
          APSystemWebPage.this.waitDialog.dismiss();
        }
        AppMethodBeat.o(217103);
      }
    };
    AppMethodBeat.o(217130);
  }
  
  protected APProgressDialog createDialog()
  {
    AppMethodBeat.i(217203);
    APProgressDialog localAPProgressDialog = new APProgressDialog(this.activity);
    localAPProgressDialog.setMessage("请稍候...");
    AppMethodBeat.o(217203);
    return localAPProgressDialog;
  }
  
  public void initHead(final Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217185);
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
            AppMethodBeat.i(217131);
            APLog.d("APSystemWebPage", "backBtn() clicked");
            if ((APSystemWebPage.this.webView != null) && (APSystemWebPage.this.webView.getWebView() != null)) {}
            for (boolean bool = true;; bool = false)
            {
              APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.back", "", "webviewNotNull=".concat(String.valueOf(bool)));
              if ((bool) && (APSystemWebPage.this.webView.getWebView().canGoBack())) {
                APSystemWebPage.this.webView.getWebView().goBack();
              }
              AppMethodBeat.o(217131);
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
            AppMethodBeat.i(217108);
            APLog.d("APSystemWebPage", "closeBtn() clicked");
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.close", "", "");
            paramAnonymousView = new APMidasResponse();
            paramAnonymousView.resultCode = 100;
            paramAnonymousView.resultMsg = "关闭";
            APMidasPayHelper.midasCallBack(paramAnonymousView);
            paramActivity.finish();
            AppMethodBeat.o(217108);
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
            AppMethodBeat.i(217126);
            APLog.d("APSystemWebPage", "refreshBtn() clicked");
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.refresh", "", "");
            if ((APSystemWebPage.this.webView != null) && (APSystemWebPage.this.webView.getWebView() != null)) {
              APSystemWebPage.this.webView.getWebView().reload();
            }
            AppMethodBeat.o(217126);
          }
        });
      }
      finally
      {
        AppMethodBeat.o(217185);
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
    AppMethodBeat.o(217185);
  }
  
  public void initUI(Activity paramActivity)
  {
    AppMethodBeat.i(217153);
    this.activity = paramActivity;
    paramActivity.setContentView(APMidasCommMethod.getLayoutId(paramActivity, "unipay_layout_activity_web"));
    this.webView = new APWebView(paramActivity, (WebView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "unipay_id_WebView")), this.webviewCallback);
    this.waitDialog = createDialog();
    this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(217153);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(217173);
    this.webView.loadUrl(paramString);
    AppMethodBeat.o(217173);
  }
  
  public void toPureH5Pay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(217163);
    this.activity = paramActivity;
    paramActivity.setContentView(APMidasCommMethod.getLayoutId(paramActivity, "unipay_layout_activity_web"));
    paramAPMidasBaseRequest = (WebView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "unipay_id_WebView"));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAPMidasBaseRequest.getLayoutParams();
    localLayoutParams.width = ((int)(localDisplayMetrics.widthPixels * 0.85F));
    localLayoutParams.height = ((int)(localDisplayMetrics.heightPixels * 0.85F));
    paramAPMidasBaseRequest.setLayoutParams(localLayoutParams);
    this.webView = new APWebView(paramActivity, paramAPMidasBaseRequest, this.webviewCallback);
    this.waitDialog = createDialog();
    this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(217163);
  }
  
  public void updateWebViewSize(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(217194);
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
      AppMethodBeat.o(217194);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APSystemWebPage
 * JD-Core Version:    0.7.0.1
 */