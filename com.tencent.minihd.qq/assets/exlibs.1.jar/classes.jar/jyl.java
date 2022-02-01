import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.qphone.base.util.BaseApplication;

public class jyl
  implements Runnable
{
  public jyl(SystemMsgController paramSystemMsgController, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("unread_system_msg", this.jdField_a_of_type_Int).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jyl
 * JD-Core Version:    0.7.0.1
 */