import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;

public class cke
  implements Runnable
{
  public cke(PubAccountAssistantManager paramPubAccountAssistantManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (PubAccountAssistantManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantManager))
    {
      Object[] arrayOfObject = PubAccountAssistantManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantManager).toArray();
      SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit(), "pubaccount_assistant_new_unread_list", arrayOfObject).commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cke
 * JD-Core Version:    0.7.0.1
 */