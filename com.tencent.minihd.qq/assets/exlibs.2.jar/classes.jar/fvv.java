import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

public class fvv
  implements Runnable
{
  public fvv(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop == 1001) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.subVersion < 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
      return;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localTransferRequest.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop;
    localTransferRequest.jdField_b_of_type_Int = 2;
    localTransferRequest.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.d = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer;
    localTransferRequest.g = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSendFromOtherTerminal()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSend())) {
      bool = true;
    }
    localTransferRequest.jdField_b_of_type_Boolean = bool;
    localTransferRequest.e = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.md5;
    localTransferRequest.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileID;
    localTransferRequest.f = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileKeyStr;
    localTransferRequest.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.subVersion;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvv
 * JD-Core Version:    0.7.0.1
 */