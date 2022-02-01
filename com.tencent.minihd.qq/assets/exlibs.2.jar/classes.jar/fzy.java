import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;

public class fzy
  extends BroadcastReceiver
{
  public fzy(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst")) {
      if (paramIntent != null)
      {
        paramContext = paramIntent.getExtras();
        if (paramContext != null) {
          break label26;
        }
      }
    }
    label26:
    do
    {
      do
      {
        long l;
        do
        {
          return;
          l = paramContext.getLong("deviceopdin", 0L);
        } while ((paramContext.getInt("deviceoprstcode", 0) != 0) || (Long.parseLong(this.a.a.a) != l));
        this.a.v();
        return;
      } while ((!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ProductFetchRst")) || (paramIntent == null));
      paramContext = paramIntent.getExtras();
    } while ((paramContext == null) || (paramContext.getInt("deviceoprstcode", 0) != 0));
    this.a.ad();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzy
 * JD-Core Version:    0.7.0.1
 */