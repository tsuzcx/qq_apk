import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;

public final class kjt
  implements Runnable
{
  public kjt(int paramInt1, QQAppInterface paramQQAppInterface, String paramString, float paramFloat, int paramInt2, Handler paramHandler) {}
  
  public void run()
  {
    EntityManager localEntityManager;
    TroopBarUploadItemEntity localTroopBarUploadItemEntity;
    if (this.jdField_a_of_type_Int != 0)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localTroopBarUploadItemEntity = (TroopBarUploadItemEntity)localEntityManager.a(TroopBarUploadItemEntity.class, this.jdField_a_of_type_JavaLangString);
      if (localTroopBarUploadItemEntity != null)
      {
        if (this.jdField_a_of_type_Int != 1) {
          break label105;
        }
        if ((this.jdField_a_of_type_Float >= 0.0F) && (this.jdField_a_of_type_Float <= 1.0F)) {
          localTroopBarUploadItemEntity.mProgress = this.jdField_a_of_type_Float;
        }
        localTroopBarUploadItemEntity.mState = this.b;
        localEntityManager.a(localTroopBarUploadItemEntity);
      }
    }
    for (;;)
    {
      localEntityManager.a();
      this.jdField_a_of_type_AndroidOsHandler.post(new kju(this));
      return;
      label105:
      if (this.jdField_a_of_type_Int == 2) {
        localEntityManager.b(localTroopBarUploadItemEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjt
 * JD-Core Version:    0.7.0.1
 */