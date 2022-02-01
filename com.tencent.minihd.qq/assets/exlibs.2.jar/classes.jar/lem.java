import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.applist.WebAppActivity.HttpGetAppInfoAsyncTask;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.smtt.sdk.WebView;

public class lem
  extends Handler
{
  public lem(WebAppActivity paramWebAppActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    LogUtility.c("WebAppActivity", "handleMessage >>> " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = new WebAppActivity.HttpGetAppInfoAsyncTask(this.a);
        paramMessage = new Bundle();
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask.execute(new Bundle[] { paramMessage });
        return;
        if (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        this.a.a();
        if (TextUtils.isEmpty(CommonDataAdapter.a().a()))
        {
          ToastUtil.a().a(2131362577, 0);
          this.a.f();
          return;
        }
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = new WebAppActivity.HttpGetAppInfoAsyncTask(this.a);
        paramMessage = new Bundle();
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask.execute(new Bundle[] { paramMessage });
        return;
        if (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        this.a.g();
      } while (this.a.jdField_a_of_type_ComTencentSmttSdkWebView == null);
      this.a.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.a.f);
      return;
    case 5: 
      ToastUtil.a().a(2131362578, 0);
      this.a.f();
      return;
    case 6: 
      ToastUtil.a().a(2131362576, 0);
      this.a.f();
      return;
    case 7: 
      ToastUtil.a().a(2131362577, 0);
      this.a.f();
      return;
    }
    ToastUtil.a().a(2131362575, 0);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lem
 * JD-Core Version:    0.7.0.1
 */