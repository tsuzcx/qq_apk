import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdo
  implements Runnable
{
  public mdo(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    QZoneAppCtrlUploadFileLogic.b(BaseApplicationImpl.getContext(), QZoneDistributedAppCtrl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdo
 * JD-Core Version:    0.7.0.1
 */