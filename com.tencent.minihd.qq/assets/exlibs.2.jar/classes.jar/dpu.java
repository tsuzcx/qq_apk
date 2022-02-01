import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dpu
  implements Runnable
{
  public dpu(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.a.app.a().createEntityManager();
        if (localObject3 == null) {
          break label182;
        }
        Object localObject1 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c }, null, null, null, null);
        ((EntityManager)localObject3).a();
        if (localObject1 == null) {
          break label179;
        }
        localObject3 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ((ArrayList)localObject3).add(((TroopMemberInfo)((Iterator)localObject1).next()).memberuin);
          continue;
        }
        if (this.a.jdField_a_of_type_AndroidOsHandler == null) {
          break label179;
        }
      }
      finally {}
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 13;
      localMessage.obj = localObject3;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      label179:
      return;
      label182:
      localMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpu
 * JD-Core Version:    0.7.0.1
 */