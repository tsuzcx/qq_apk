import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

public class jnu
  extends Handler
{
  public jnu(ProfileHeaderView paramProfileHeaderView, Looper paramLooper, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (ProfileHeaderView.d == paramMessage.what)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileHeaderView.a, 2, "ProfileHeaderView handleMessage msg what is check tips time=" + this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.l(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    while (ProfileHeaderView.f != paramMessage.what) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jnu
 * JD-Core Version:    0.7.0.1
 */