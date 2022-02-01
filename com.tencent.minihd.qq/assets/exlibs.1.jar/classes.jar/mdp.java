import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdp
  implements Runnable
{
  public mdp(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    QZoneAppCtrlUploadFileLogic.c(BaseApplicationImpl.getContext(), QZoneDistributedAppCtrl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdp
 * JD-Core Version:    0.7.0.1
 */