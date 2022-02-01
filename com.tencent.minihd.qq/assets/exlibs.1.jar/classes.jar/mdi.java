import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdi
  implements Runnable
{
  public mdi(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "restart QZone process");
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    QZoneHelper.a((Activity)BaseApplicationImpl.getContext(), QZoneDistributedAppCtrl.a(), localIntent, -1);
    QZoneDistributedAppCtrl.n += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdi
 * JD-Core Version:    0.7.0.1
 */