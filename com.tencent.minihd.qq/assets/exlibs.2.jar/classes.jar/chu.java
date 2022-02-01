import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.observer.BusinessObserver;

public class chu
  implements BusinessObserver
{
  public chu(AccountDetailActivity paramAccountDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity);
    if (!paramBoolean)
    {
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(2131363617);
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity;
      paramBundle.b -= 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.b == 0) {
        AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity);
      }
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.SetFunctionFlagResponse localSetFunctionFlagResponse = new mobileqq_mp.SetFunctionFlagResponse();
          localSetFunctionFlagResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.get() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.set(this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.toByteArray();
            if (this.b == 3)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs = true;
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isAgreeSyncLbs = this.jdField_a_of_type_Boolean;
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, String.valueOf(this.jdField_a_of_type_Boolean));
              }
              AccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "状态切换成功");
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get() != 5) {
              continue;
            }
            paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
            if (!this.jdField_a_of_type_Boolean) {
              break label480;
            }
            paramInt = 1;
            paramBundle.mShowMsgFlag = paramInt;
            if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.mShowMsgFlag == 1)
            {
              AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, true);
              continue;
            }
            AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, false);
            continue;
          }
          AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "状态切换失败1");
          }
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(2131363617);
          break;
        }
        AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(2131363617);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "状态切换失败");
      }
      catch (Exception paramBundle) {}
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(2131363617);
      break;
      break;
      label480:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chu
 * JD-Core Version:    0.7.0.1
 */