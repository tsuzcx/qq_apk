import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import mqq.observer.BusinessObserver;

class cjt
  implements Runnable
{
  cjt(cjs paramcjs, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_Cjs.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_Cjs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Cjs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse);
    if (this.jdField_a_of_type_Cjs.jdField_a_of_type_MqqObserverBusinessObserver != null) {
      this.jdField_a_of_type_Cjs.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjt
 * JD-Core Version:    0.7.0.1
 */