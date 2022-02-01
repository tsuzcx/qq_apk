import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

public class dbd
  implements Runnable
{
  public dbd(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    DeviceAVFileMsgObserver localDeviceAVFileMsgObserver = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.a.a(51)).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt instanceof MessageForDevPtt)) {
      localDeviceAVFileMsgObserver.a((MessageForDevPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbd
 * JD-Core Version:    0.7.0.1
 */