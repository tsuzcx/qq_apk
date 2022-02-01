import android.app.Activity;
import com.tencent.mobileqq.activity.widget.qqmusic.business.share.ShareHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class hdd
  implements Runnable
{
  hdd(hdc paramhdc, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Hdc.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_Hdc.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((!"1".equals(this.jdField_a_of_type_Hdc.d)) && (!"2".equals(this.jdField_a_of_type_Hdc.d)) && (!"3".equals(this.jdField_a_of_type_Hdc.d)))
          {
            ShareHelper.a(this.jdField_a_of_type_Hdc.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Hdc.d, this.jdField_a_of_type_Hdc.e, this.jdField_a_of_type_Hdc.f, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Hdc.g, this.c, this.jdField_a_of_type_Hdc.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Hdc.jdField_a_of_type_ComTencentCommonAppAppInterface);
            return;
          }
        }
        catch (JSONException localJSONException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("liwei", 2, "shareMsg error: " + localJSONException.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdd
 * JD-Core Version:    0.7.0.1
 */