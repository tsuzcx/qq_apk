import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZoneDistributedAppCtrl;

public class mdm
  implements Runnable
{
  public mdm(QZoneDistributedAppCtrl paramQZoneDistributedAppCtrl) {}
  
  public void run()
  {
    QZoneHelper.a(BaseApplicationImpl.getContext(), QZoneDistributedAppCtrl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdm
 * JD-Core Version:    0.7.0.1
 */