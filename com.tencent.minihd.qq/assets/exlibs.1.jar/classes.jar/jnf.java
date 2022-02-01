import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class jnf
  implements Runnable
{
  public jnf(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = new jng(this);
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(this.jdField_a_of_type_JavaLangString, (DownloadListener)localObject);
    if ((i == 19) || (i == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.obtainMessage(20);
      ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("style download success , url : %s, position : %d ", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.b.remove(this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.obtainMessage(21);
      ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.sendMessage((Message)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("styles download fail , url : %s, position : %d ", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jnf
 * JD-Core Version:    0.7.0.1
 */