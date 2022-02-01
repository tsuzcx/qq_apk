import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

@SuppressLint({"NewApi"})
public class ldk
  extends WebChromeClient
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  
  public ldk(AppViewBaseActivity paramAppViewBaseActivity1, AppViewBaseActivity paramAppViewBaseActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppViewBaseActivity2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    LogUtility.c("WebConsole", paramString1 + " --From line " + paramInt + " of " + paramString2);
    if (Build.VERSION.SDK_INT == 7) {}
    try
    {
      paramString2 = (AppViewBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((paramString2 != null) && (!paramString2.isFinishing())) {
        paramString2.b(paramString1);
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (LogUtility.a()) {
      LogUtility.c("WebConsole", paramConsoleMessage.message() + " -- From line " + paramConsoleMessage.lineNumber() + " of " + paramConsoleMessage.sourceId());
    }
    if (Build.VERSION.SDK_INT > 7) {
      try
      {
        AppViewBaseActivity localAppViewBaseActivity = (AppViewBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localAppViewBaseActivity != null) && (!localAppViewBaseActivity.isFinishing()))
        {
          if (paramConsoleMessage == null) {}
          for (paramConsoleMessage = "";; paramConsoleMessage = paramConsoleMessage.message())
          {
            localAppViewBaseActivity.b(paramConsoleMessage);
            break;
          }
        }
        return true;
      }
      catch (Exception paramConsoleMessage) {}
    }
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramQuotaUpdater.updateQuota(2L * paramLong2);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    try
    {
      paramString1 = (AppViewBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((paramString1 != null) && (!paramString1.isFinishing()) && (paramString1.a.a(paramWebView, paramString2)))
      {
        paramJsResult.cancel();
        return true;
      }
    }
    catch (Exception paramWebView) {}
    return false;
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramQuotaUpdater.updateQuota(2L * paramLong1);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    if ((paramString.length() > 0) && (AppViewBaseActivity.a(this.jdField_a_of_type_ComTencentOpenAppcommonAppViewBaseActivity).getText().equals("应用宝")))
    {
      if (paramString.contains("应用详情")) {
        AppViewBaseActivity.b(this.jdField_a_of_type_ComTencentOpenAppcommonAppViewBaseActivity).setText("应用详情");
      }
    }
    else {
      return;
    }
    AppViewBaseActivity.c(this.jdField_a_of_type_ComTencentOpenAppcommonAppViewBaseActivity).setText(StringAddition.a(paramString, 16, true, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldk
 * JD-Core Version:    0.7.0.1
 */