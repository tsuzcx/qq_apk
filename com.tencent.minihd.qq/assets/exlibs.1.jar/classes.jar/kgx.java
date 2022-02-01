import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;

public class kgx
  implements Runnable
{
  public kgx(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.app.a().createEntityManager();
    Entity localEntity = ((EntityManager)localObject).a(TroopBarUploadItemEntity.class, this.jdField_a_of_type_JavaLangString);
    ((EntityManager)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.a.obtainMessage(3);
    if (localEntity != null) {}
    for (((Message)localObject).obj = localEntity;; ((Message)localObject).obj = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.a.sendMessage((Message)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgx
 * JD-Core Version:    0.7.0.1
 */