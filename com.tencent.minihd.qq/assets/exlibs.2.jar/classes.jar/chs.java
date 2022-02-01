import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class chs
  implements Runnable
{
  public chs(AccountDetailActivity paramAccountDetailActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "saveCacheInSubThread");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PubAccountAssistantManager.a().d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b, "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
      return;
    }
    PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b, "mp_msg_ziliao_1", "share_click", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chs
 * JD-Core Version:    0.7.0.1
 */