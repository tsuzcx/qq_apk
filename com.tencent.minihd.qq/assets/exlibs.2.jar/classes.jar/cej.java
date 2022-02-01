import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class cej
  implements BusinessObserver
{
  public cej(Context paramContext, QQProgressDialog paramQQProgressDialog, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "success:" + String.valueOf(paramBoolean));
    }
    mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    for (;;)
    {
      try
      {
        localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
        {
          paramBundle = new EqqDetail(localGetEqqAccountDetailInfoResponse);
          CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
          CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
          if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, "<<<end getDetail, ts=" + System.currentTimeMillis());
          }
          CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramBundle, this.jdField_a_of_type_JavaLangString);
          CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131363617);
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
        return;
      }
      CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131363617);
      continue;
      CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131363617);
      continue;
      CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131363617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cej
 * JD-Core Version:    0.7.0.1
 */