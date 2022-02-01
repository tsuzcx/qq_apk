import android.os.Bundle;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;

public class ckm
  implements BusinessObserver
{
  public ckm(PubAccountAssistantSettingAdapter paramPubAccountAssistantSettingAdapter, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            mobileqq_mp.SetFunctionFlagResponse localSetFunctionFlagResponse = new mobileqq_mp.SetFunctionFlagResponse();
            localSetFunctionFlagResponse.mergeFrom(paramBundle);
            if (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.get() == 0)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.messageSettingFlag != 0)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.messageSettingFlag == 2)
                {
                  PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter));
                  return;
                }
                PubAccountAssistantManager.a().d(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter));
                return;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mShowMsgFlag == 0)
              {
                PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter));
                return;
              }
              PubAccountAssistantManager.a().d(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter));
              return;
            }
          }
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ckm
 * JD-Core Version:    0.7.0.1
 */