import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

public class jct
  implements Runnable
{
  public jct(QQApiPlugin paramQQApiPlugin, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    int j = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && ((localObject instanceof QQBrowserActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)localObject).a().a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new jcu(this);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.r = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if ("audio".equals(this.jdField_a_of_type_JavaLangString))
    {
      localWXShareHelper = WXShareHelper.a();
      str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.r;
      str2 = this.b;
      str3 = this.c;
      str4 = this.d;
      if ("2".equals(this.e)) {}
      for (;;)
      {
        localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i, this.f);
        return;
        i = 1;
      }
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.r;
    String str2 = this.b;
    String str3 = this.c;
    String str4 = this.d;
    if ("2".equals(this.e)) {}
    for (i = j;; i = 1)
    {
      localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jct
 * JD-Core Version:    0.7.0.1
 */