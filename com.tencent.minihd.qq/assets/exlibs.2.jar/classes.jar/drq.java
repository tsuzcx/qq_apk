import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class drq
  extends BroadcastReceiver
{
  public drq(Contacts paramContacts) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("SmartDevice_clickOnDeviceList")) && (this.a.a.e(0)))
    {
      paramContext = (SmartDeviceProxyMgr)this.a.app.a(53);
      if (paramContext.a()) {
        paramContext.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drq
 * JD-Core Version:    0.7.0.1
 */