import android.content.SharedPreferences;
import com.tencent.biz.AuthorizeConfig;

public class cac
  implements Runnable
{
  public cac(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void run()
  {
    long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l != AuthorizeConfig.jdField_a_of_type_Long)
    {
      AuthorizeConfig.jdField_a_of_type_Long = l;
      this.a.f = null;
      this.a.jdField_a_of_type_OrgJsonJSONObject = null;
      this.a.jdField_e_of_type_OrgJsonJSONObject = null;
      this.a.jdField_e_of_type_OrgJsonJSONArray = null;
      this.a.jdField_c_of_type_OrgJsonJSONObject = null;
      this.a.jdField_d_of_type_OrgJsonJSONObject = null;
      this.a.jdField_b_of_type_ArrayOfJavaLangString = null;
      this.a.jdField_a_of_type_ArrayOfJavaLangString = null;
      this.a.jdField_c_of_type_ArrayOfJavaLangString = null;
      this.a.jdField_b_of_type_OrgJsonJSONObject = null;
      this.a.jdField_a_of_type_OrgJsonJSONArray = null;
      this.a.jdField_c_of_type_OrgJsonJSONArray = null;
      this.a.jdField_d_of_type_OrgJsonJSONArray = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cac
 * JD-Core Version:    0.7.0.1
 */