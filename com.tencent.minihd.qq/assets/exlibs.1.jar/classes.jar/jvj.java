import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class jvj
  extends TimerTask
{
  public jvj(QZoneNotifyServlet paramQZoneNotifyServlet) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QZoneNotifyServlet.a(), 2, "QZONE GET UNREAD.QZoneFeedTimeTask run.");
    }
    AppRuntime localAppRuntime = this.a.getAppRuntime();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QZoneNotifyServlet.class);
    localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jvj
 * JD-Core Version:    0.7.0.1
 */