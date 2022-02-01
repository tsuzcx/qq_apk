import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.PendantInfo;
import java.io.File;

public class kvk
  implements Runnable
{
  public kvk(PendantInfo paramPendantInfo, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, 4));
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a((File)localObject, this.jdField_a_of_type_Int);
    if ((PendantInfo.b(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo) == 0) && (this.jdField_a_of_type_Int == 2)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    localObject = new Message();
    ((Message)localObject).what = 20;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvk
 * JD-Core Version:    0.7.0.1
 */