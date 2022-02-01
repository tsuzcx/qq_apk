import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdh
  implements Runnable
{
  public mdh(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    QZoneAppCtrlUploadFileLogic.a(BaseApplicationImpl.getContext(), QZoneDistributedAppCtrl.a(), QZoneDistributedAppCtrl.a(this.a), QZoneDistributedAppCtrl.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdh
 * JD-Core Version:    0.7.0.1
 */