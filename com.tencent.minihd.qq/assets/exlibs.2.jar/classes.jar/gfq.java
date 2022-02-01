import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

public class gfq
  implements Runnable
{
  public gfq(AddContactsView paramAddContactsView, String paramString, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    List localList = AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
    String str = AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView, localList);
    if (!this.jdField_a_of_type_JavaLangString.equals(str))
    {
      AddContactsView.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView, localList);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView), StringUtil.a(AddContactsView.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView), ",")).commit();
      AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView).post(new gfr(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfq
 * JD-Core Version:    0.7.0.1
 */