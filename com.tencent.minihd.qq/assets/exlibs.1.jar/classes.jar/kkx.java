import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import java.util.Map;

class kkx
  implements Runnable
{
  kkx(kkw paramkkw) {}
  
  public void run()
  {
    if (TroopMessageManager.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager).b.containsKey(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      TroopMessageManager.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager).b.remove(MsgProxyUtils.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kkx
 * JD-Core Version:    0.7.0.1
 */