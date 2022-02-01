import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class gcz
  implements Runnable
{
  gcz(gcy paramgcy, long paramLong, List paramList) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Gcy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localTroopManager.a(String.valueOf(this.jdField_a_of_type_Long))) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = localTroopManager.b(this.jdField_a_of_type_Gcy.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    } while ((localTroopInfo == null) || (StringUtil.b(localTroopInfo.troopowneruin)));
    localTroopInfo.Administrator = "";
    int i;
    int j;
    label87:
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label226;
      }
      localObject = (oidb_0x899.memberlist)this.jdField_a_of_type_JavaUtilList.get(j);
      if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {
        break label143;
      }
    }
    for (;;)
    {
      j += 1;
      break label87;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label143:
      localObject = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((localObject != null) && (!"".equals(((String)localObject).trim())) && (!localTroopInfo.troopowneruin.equals(((String)localObject).trim()))) {
        localTroopInfo.Administrator = (localTroopInfo.Administrator + (String)localObject + "|");
      }
    }
    label226:
    localTroopManager.b(localTroopInfo);
    if (QLog.isColorLevel()) {
      QLog.i("TroopChatPie", 2, localTroopInfo.Administrator);
    }
    TroopChatPie.a(this.jdField_a_of_type_Gcy.a).removeMessages(1);
    TroopChatPie.a(this.jdField_a_of_type_Gcy.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gcz
 * JD-Core Version:    0.7.0.1
 */