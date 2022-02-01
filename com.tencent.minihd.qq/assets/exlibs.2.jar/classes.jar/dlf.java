import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;

public class dlf
  extends QZoneObserver
{
  public ChatAdapter1 a;
  public SessionInfo a;
  public QQAppInterface a;
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
      return;
    }
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof AIONewestFeedRsp))) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (AIONewestFeedRsp)paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(ChatActivityFacade.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dlf
 * JD-Core Version:    0.7.0.1
 */