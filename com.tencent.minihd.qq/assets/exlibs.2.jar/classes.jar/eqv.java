import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

public class eqv
  extends CustomWebChromeClient
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private IX5WebChromeClient.CustomViewCallback jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public eqv(QQBrowserActivity paramQQBrowserActivity) {}
  
  private void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "show custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getRequestedOrientation();
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getWindow().getAttributes().flags & 0x400);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setBackgroundColor(-16777216);
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.r = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.addView(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = paramCustomViewCallback;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(0);
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2130904511, null);
    }
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
        {
          str = paramString;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null) {
            str = "http://" + paramString + "/";
          }
        }
      }
    }
    paramGeolocationPermissionsCallback.invoke(str, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(str, "publicAccount.getLocation"), false);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "hide custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setKeepScreenOn(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback.onCustomViewHidden();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.removeAllViews();
      label61:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getWindow().setFlags(this.jdField_b_of_type_Int, 1024);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.r = false;
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.W != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.W.length() > 0)) {}
    while (paramString == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.i) {
      QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).postDelayed(new eqw(this, paramString), 50L);
    }
    for (;;)
    {
      QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setTitle(paramString);
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, 10, paramCustomViewCallback);
  }
  
  public void openFileChooser(ValueCallback paramValueCallback, String paramString1, String paramString2)
  {
    QQBrowserActivity.jdField_a_of_type_ComTencentSmttSdkValueCallback = paramValueCallback;
    paramValueCallback = new Intent("android.intent.action.GET_CONTENT");
    paramValueCallback.addCategory("android.intent.category.OPENABLE");
    paramValueCallback.setType("*/*");
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivityForResult(Intent.createChooser(paramValueCallback, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131367543)), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqv
 * JD-Core Version:    0.7.0.1
 */