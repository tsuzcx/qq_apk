import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

public class dbl
  extends BroadcastReceiver
{
  public dbl(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l;
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst"))
    {
      paramContext = paramIntent.getExtras();
      l = paramContext.getLong("deviceopdin", 0L);
      if (paramContext.getInt("deviceoprstcode", 0) == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(l).toString(), 9501);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceAdminUnbind"))
          {
            l = paramIntent.getExtras().getLong("deviceopdin", 0L);
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(l).toString(), 9501);
            return;
          }
        } while (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveDPMsg"));
        paramContext = (DataPoint)paramIntent.getExtras().getParcelable("dataPoint");
        if (paramContext != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "dp is null in DeviceMsgHandler::onreceive");
      return;
      if (10004 == paramContext.mProperityId)
      {
        this.a.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a(paramContext);
        return;
      }
      if (10003 == paramContext.mProperityId)
      {
        this.a.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver.a(paramContext);
        return;
      }
    } while (10007 != paramContext.mProperityId);
    this.a.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbl
 * JD-Core Version:    0.7.0.1
 */