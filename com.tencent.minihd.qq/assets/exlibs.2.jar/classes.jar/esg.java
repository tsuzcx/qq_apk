import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class esg
  implements Runnable
{
  public esg(QQLSActivity paramQQLSActivity, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "LS update isScreenLocked" + QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.isFinishing()) {}
    label206:
    do
    {
      Object localObject1;
      Object localObject2;
      do
      {
        FriendManager localFriendManager;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if ((this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof NewFriendMessage))) {
                        break label206;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "data is NewFriendMessage" + Thread.currentThread().getId());
                      }
                      if (((NewFriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(33)).a() != 0) {
                        break;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("QQLSActivity", 2, "data is NewFriendMessage unread=0 update return");
                    return;
                  } while ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getVisibility() == 0) && (!TextUtils.isEmpty(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getText())));
                  this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), AppConstants.ab, 4000, false);
                  QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
                  QQLSActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
                  return;
                  if ((this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof RecentItemVoteData))) {
                    break;
                  }
                  localObject1 = ((RecentItemVoteData)this.jdField_a_of_type_JavaLangObject).a();
                  this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), ((RecentUser)localObject1).uin, ((RecentUser)localObject1).msgType, false);
                } while ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getVisibility() == 0) && (!TextUtils.isEmpty(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getText())));
                QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
                if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ChatMessage))) {
                  break;
                }
              } while ((!QLog.isColorLevel()) || (this.jdField_a_of_type_JavaLangObject == null));
              QLog.d("QQLSActivity", 2, "update data is not chatMessage return" + this.jdField_a_of_type_JavaLangObject.getClass());
              return;
              localObject1 = (ChatMessage)this.jdField_a_of_type_JavaLangObject;
            } while ((((ChatMessage)localObject1).isSend()) || (((ChatMessage)localObject1).istroop == 6000) || (((ChatMessage)localObject1).istroop == 1009));
            if ((!MsgProxyUtils.b((MessageRecord)localObject1)) || (MsgProxyUtils.d(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageRecord)localObject1))) {
              break;
            }
            if (1001 == ((ChatMessage)localObject1).istroop)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), AppConstants.az, ((ChatMessage)localObject1).istroop, false);
              QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              return;
            }
          } while (1010 != ((ChatMessage)localObject1).istroop);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), AppConstants.aA, ((ChatMessage)localObject1).istroop, false);
          QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
          return;
          if (((ChatMessage)localObject1).istroop != 1) {
            break;
          }
          localObject2 = (HotChatManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(58);
          localFriendManager = (FriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(8);
        } while ((((HotChatManager)localObject2).d(((ChatMessage)localObject1).frienduin)) || (localFriendManager.f(((ChatMessage)localObject1).frienduin)));
        localObject2 = (RoamSettingController)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(30);
      } while ((localObject2 != null) && (((RoamSettingController)localObject2).a(((ChatMessage)localObject1).frienduin, 1) != 1));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), ((ChatMessage)localObject1).frienduin, ((ChatMessage)localObject1).istroop, false);
    } while ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getVisibility() == 0) && (!TextUtils.isEmpty(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getText())));
    QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     esg
 * JD-Core Version:    0.7.0.1
 */