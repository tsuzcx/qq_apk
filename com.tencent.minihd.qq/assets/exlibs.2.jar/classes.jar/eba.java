import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class eba
  implements Runnable
{
  public eba(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if (this.a.app == null) {}
    FriendManager localFriendManager;
    do
    {
      return;
      localFriendManager = (FriendManager)this.a.app.getManager(8);
    } while (localFriendManager == null);
    Object localObject;
    if (this.a.a != null) {
      if (this.a.a.a == null) {
        localObject = null;
      }
    }
    for (;;)
    {
      localObject = localFriendManager.c((String)localObject);
      if ((localObject == null) || ((((Friends)localObject).abilityBits & 0x2) == 0L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "mReportPCCameraAblibityRunnable-->report");
      }
      ReportController.b(null, "CliOper", "", "", "0X8004991", "0X8004991", 0, 0, "", "", "", "");
      return;
      localObject = this.a.a.a.a;
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eba
 * JD-Core Version:    0.7.0.1
 */