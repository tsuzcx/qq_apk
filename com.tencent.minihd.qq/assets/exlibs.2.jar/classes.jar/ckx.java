import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;

public class ckx
  implements Runnable
{
  public ckx(TroopBarAssistantManager paramTroopBarAssistantManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (TroopBarAssistantManager.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantManager))
    {
      Object[] arrayOfObject = TroopBarAssistantManager.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantManager).toArray();
      SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit(), "troopbar_assist_new_unread_list", arrayOfObject).commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ckx
 * JD-Core Version:    0.7.0.1
 */