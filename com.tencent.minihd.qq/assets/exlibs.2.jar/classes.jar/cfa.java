import android.os.Bundle;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class cfa
  implements BusinessObserver
{
  public cfa(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.a(2131363617);
      }
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_a_of_type_Int -= 1;
      if (this.a.jdField_a_of_type_Int == 0) {
        EnterpriseDetailActivity.b(this.a);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("crmtest", 4, "receive sendDetailInfoResponse, ts=" + System.currentTimeMillis());
      }
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
          localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
          if ((((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() != 0) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) || (localGetEqqAccountDetailInfoResponse.seqno.get() == this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.seqno)))) {
            continue;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse = localGetEqqAccountDetailInfoResponse;
          paramBundle = new EqqDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse);
          if ((this.a.c) && (paramBundle.followType == 1))
          {
            EnterpriseDetailActivity.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
            this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b();
            EnterpriseDetailActivity.g(this.a);
            continue;
          }
          EnterpriseDetailActivity.d(this.a, paramBundle);
          continue;
        }
        if (this.a.jdField_a_of_type_Boolean) {
          continue;
        }
        this.a.a(2131363617);
      }
      catch (Exception paramBundle) {}
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.a(2131363617);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfa
 * JD-Core Version:    0.7.0.1
 */