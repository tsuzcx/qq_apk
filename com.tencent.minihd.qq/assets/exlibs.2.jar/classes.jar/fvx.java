import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class fvx
  implements BluetoothProfile.ServiceListener
{
  public fvx(PttItemBuilder paramPttItemBuilder, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      Iterator localIterator = paramBluetoothProfile.getConnectedDevices().iterator();
      if (localIterator.hasNext())
      {
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)localIterator.next();
        HashMap localHashMap = new HashMap();
        if (AudioHelper.a(localBluetoothDevice)) {
          localHashMap.put("param_FailCode", String.valueOf(2));
        }
        for (;;)
        {
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttPlayBluetooth", false, 0L, 0L, localHashMap, "");
          break;
          localHashMap.put("param_FailCode", String.valueOf(1));
        }
      }
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvx
 * JD-Core Version:    0.7.0.1
 */