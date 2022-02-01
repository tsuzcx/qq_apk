import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class fwc
  implements View.OnClickListener
{
  public fwc(QzoneFeedItemBuilder paramQzoneFeedItemBuilder, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getContext();
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.a();
    localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.c();
    localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getSid();
    QZoneHelper.a((Activity)paramView, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwc
 * JD-Core Version:    0.7.0.1
 */