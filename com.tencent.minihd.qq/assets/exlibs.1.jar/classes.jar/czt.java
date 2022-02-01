import com.tencent.device.file.DevShortVideoOperator;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;

public class czt
  implements Runnable
{
  public czt(DevShortVideoOperator paramDevShortVideoOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    int j = 0;
    ShortVideoUploadInfo localShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
    Object localObject = null;
    int i;
    if (localShortVideoUploadInfo.jdField_g_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.a(localShortVideoUploadInfo);
      i = 1;
    }
    while (localObject == null)
    {
      return;
      i = j;
      if (localShortVideoUploadInfo.jdField_g_of_type_Int == 1)
      {
        localObject = (MessageForShortVideo)localShortVideoUploadInfo.a;
        i = j;
      }
    }
    this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    if ((localObject instanceof MessageForDevShortVideo)) {
      ((MessageForDevShortVideo)localObject).videoFileStatus = 1002;
    }
    long l = System.currentTimeMillis();
    if (i != 0) {
      this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a().a(DeviceMsgHandle.c, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.jdField_g_of_type_JavaLangString, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop);
    Logger.a(this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     czt
 * JD-Core Version:    0.7.0.1
 */