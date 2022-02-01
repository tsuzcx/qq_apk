import android.app.Activity;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class jcs
  implements Runnable
{
  jcs(jcr paramjcr, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = this.jdField_a_of_type_Jcr.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      try
      {
        if (!"1".equals(this.jdField_a_of_type_Jcr.d)) {
          break;
        }
        QQApiPlugin.a(this.jdField_a_of_type_Jcr.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Jcr.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Jcr.d, this.jdField_a_of_type_Jcr.e, this.jdField_a_of_type_Jcr.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Jcr.g, this.c);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareMsg error: " + localJSONException.toString());
    return;
    if (("2".equals(this.jdField_a_of_type_Jcr.d)) || ("3".equals(this.jdField_a_of_type_Jcr.d)))
    {
      QQApiPlugin.b(this.jdField_a_of_type_Jcr.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Jcr.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Jcr.d, this.jdField_a_of_type_Jcr.e, this.jdField_a_of_type_Jcr.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Jcr.g, this.c);
      return;
    }
    QQApiPlugin.c(this.jdField_a_of_type_Jcr.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin, this.jdField_a_of_type_Jcr.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Jcr.d, this.jdField_a_of_type_Jcr.e, this.jdField_a_of_type_Jcr.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Jcr.g, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jcs
 * JD-Core Version:    0.7.0.1
 */