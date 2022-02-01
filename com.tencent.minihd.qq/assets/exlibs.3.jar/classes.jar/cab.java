import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;

public final class cab
  implements Runnable
{
  public cab(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage");
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addMessage end");
      }
      return;
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localQQMessageFacade != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))) {
        localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cab
 * JD-Core Version:    0.7.0.1
 */