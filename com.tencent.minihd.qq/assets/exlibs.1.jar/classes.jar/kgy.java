import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class kgy
  implements Runnable
{
  public kgy(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    Object localObject = localEntityManager.a(TroopBarUploadItemEntity.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopBarUploadItemEntity localTroopBarUploadItemEntity = (TroopBarUploadItemEntity)((Iterator)localObject).next();
        if (localTroopBarUploadItemEntity.mState != 5)
        {
          localArrayList.add(0, localTroopBarUploadItemEntity);
          if (((localTroopBarUploadItemEntity.mState == 2) || (localTroopBarUploadItemEntity.mState == 1) || (localTroopBarUploadItemEntity.mState == 0)) && (!this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.b(localTroopBarUploadItemEntity.mId)))
          {
            localTroopBarUploadItemEntity.mState = 3;
            localEntityManager.a(localTroopBarUploadItemEntity);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarUploadManagerActivity", 2, "initData size =" + localArrayList.size());
    }
    if (this.a.jdField_a_of_type_Khd == null) {
      this.a.jdField_a_of_type_Khd = new khd(this.a, localArrayList);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      localEntityManager.a();
      return;
      this.a.jdField_a_of_type_Khd.a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgy
 * JD-Core Version:    0.7.0.1
 */