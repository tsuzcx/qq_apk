import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class fyz
  implements Runnable
{
  public fyz(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a.size() == 0)) {
      return;
    }
    do
    {
      Object localObject2;
      do
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a.size());
        ((ArrayList)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a);
        localObject2 = ((ArrayList)localObject1).iterator();
      } while (!((Iterator)localObject2).hasNext());
      Object localObject1 = (MessageForPic)((Iterator)localObject2).next();
      if ((localObject1 == null) || (((MessageForPic)localObject1).uniseq != this.jdField_a_of_type_Long) || (((MessageForPic)localObject1).subMsgId != this.jdField_a_of_type_Int)) {
        break;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "payFlow,id:" + this.jdField_a_of_type_Long + ",subId:" + this.jdField_a_of_type_Int);
        }
        localObject2 = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.b);
        AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, (QQAppInterface)localObject2, (MessageForPic)localObject1);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "no appRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyz
 * JD-Core Version:    0.7.0.1
 */