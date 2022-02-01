import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ebs
  implements Runnable
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  long b;
  
  public ebs(FriendProfileCardActivity paramFriendProfileCardActivity, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
  
  public void run()
  {
    FriendProfileCardActivity localFriendProfileCardActivity;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFriendProfileCardActivity == null) {}
    }
    for (;;)
    {
      try
      {
        localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateConfigBegin", "initTemplateConfig", false);
        if (FriendProfileCardActivity.a(localFriendProfileCardActivity) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig currentCardTemplate=" + FriendProfileCardActivity.a(localFriendProfileCardActivity).toString());
          }
          if ((FriendProfileCardActivity.a(localFriendProfileCardActivity) == null) || (!FriendProfileCardActivity.a(localFriendProfileCardActivity).a(localFriendProfileCardActivity.app, this.jdField_a_of_type_Long, this.b))) {
            break label303;
          }
          bool1 = true;
          boolean bool2 = localFriendProfileCardActivity.a(this.jdField_a_of_type_JavaLangString);
          localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initTemplateConfigEnd", "initTemplateConfig", false);
          if ((bool1) && (bool2))
          {
            localMessage = localFriendProfileCardActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(8);
            if (QLog.isColorLevel())
            {
              if ((FriendProfileCardActivity.a(localFriendProfileCardActivity) == null) || (FriendProfileCardActivity.a(localFriendProfileCardActivity).b == null)) {
                break label308;
              }
              i = FriendProfileCardActivity.a(localFriendProfileCardActivity).b.size();
              QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig result=" + localMessage.what + ",templateAttr size=" + i + ",initTemplateConfig=" + bool1 + ",loadBackground=" + bool2);
            }
            localFriendProfileCardActivity.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
            return;
          }
          Message localMessage = localFriendProfileCardActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig currentCardTemplate is null");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label303:
      boolean bool1 = false;
      continue;
      label308:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ebs
 * JD-Core Version:    0.7.0.1
 */