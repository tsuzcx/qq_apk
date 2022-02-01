import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.FloatChatAdapter;
import com.tencent.mobileqq.activity.flaotaio.TroopFloatChatPie;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;

public class gnf
  extends BizTroopObserver
{
  public gnf(TroopFloatChatPie paramTroopFloatChatPie) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString))) {
      TroopFloatChatPie.a(this.a, paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo, true);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatChatAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gnf
 * JD-Core Version:    0.7.0.1
 */