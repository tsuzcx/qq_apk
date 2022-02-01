import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdk
  implements Runnable
{
  public mdk(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    QZoneHelper.b(BaseApplicationImpl.getContext(), QZoneDistributedAppCtrl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdk
 * JD-Core Version:    0.7.0.1
 */