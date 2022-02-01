import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class dle
  implements Runnable
{
  public dle(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        j = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).intValue();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
        localObject3 = ((EntityManager)localObject1).a(RecentEmotionData.class, false, null, null, null, null, null, null);
        if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
          continue;
        }
        localObject3 = new RecentEmotionData();
        ChatActivityFacade.a((RecentEmotionData)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, 5, j, (String)localObject2);
        ((EntityManager)localObject1).a((Entity)localObject3);
      }
      catch (Exception localException)
      {
        Object localObject1;
        int j;
        Object localObject2;
        int i;
        RecentEmotionData localRecentEmotionData;
        int k;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(ChatActivityFacade.a(), 2, localException.getMessage());
        return;
        Object localObject3 = new RecentEmotionData();
        ChatActivityFacade.a((RecentEmotionData)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), k, 5, j, (String)localObject2);
        localException.b((Entity)localObject3);
        continue;
      }
      ((EntityManager)localObject1).a();
      localObject1 = (EmoticonManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localObject1 == null) {
        return;
      }
      ((EmoticonManagerImp)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      localObject2 = ((EmoticonManagerImp)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if ((localObject2 == null) || (((EmoticonPackage)localObject2).status != 0)) {
        return;
      }
      ((EmoticonManagerImp)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      return;
      i = ChatActivityFacade.a((List)localObject3, 5, j, (String)localObject2);
      if (i >= 0)
      {
        localRecentEmotionData = (RecentEmotionData)((List)localObject3).get(i);
        ((List)localObject3).remove(localRecentEmotionData);
        ((EntityManager)localObject1).b(localRecentEmotionData);
      }
      k = ((List)localObject3).size();
      if (k != 100) {
        continue;
      }
      i = 0;
      if (i < k - 1)
      {
        localRecentEmotionData = (RecentEmotionData)((List)localObject3).get(i);
        localRecentEmotionData.type = ((RecentEmotionData)((List)localObject3).get(i + 1)).type;
        localRecentEmotionData.emoIndex = ((RecentEmotionData)((List)localObject3).get(i + 1)).emoIndex;
        localRecentEmotionData.emoPath = ((RecentEmotionData)((List)localObject3).get(i + 1)).emoPath;
        ((EntityManager)localObject1).a(localRecentEmotionData);
        i += 1;
      }
      else
      {
        localObject3 = (RecentEmotionData)((List)localObject3).get(k - 1);
        ChatActivityFacade.a((RecentEmotionData)localObject3, ((RecentEmotionData)localObject3).uin, ((RecentEmotionData)localObject3).emoId, 5, j, (String)localObject2);
        ((EntityManager)localObject1).a((Entity)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dle
 * JD-Core Version:    0.7.0.1
 */