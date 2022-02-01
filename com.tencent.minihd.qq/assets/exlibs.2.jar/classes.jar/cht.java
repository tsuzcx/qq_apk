import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

public class cht
  implements Runnable
{
  public cht(AccountDetailActivity paramAccountDetailActivity, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, 2, "saveCacheInSubThread");
    }
    AccountDetailActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cht
 * JD-Core Version:    0.7.0.1
 */