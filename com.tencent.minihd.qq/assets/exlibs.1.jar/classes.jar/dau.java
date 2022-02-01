import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class dau
  implements Runnable
{
  public dau(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(1, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.f);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.f, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dau
 * JD-Core Version:    0.7.0.1
 */