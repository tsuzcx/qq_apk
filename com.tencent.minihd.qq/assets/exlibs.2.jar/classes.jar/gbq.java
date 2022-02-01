import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class gbq
  implements BusinessObserver
{
  public gbq(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      this.a.n(2131363617);
      if (paramInt != 0) {
        PublicAccountChatPie.g(this.a);
      }
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      for (;;)
      {
        int i;
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            break label248;
          }
          mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
          localFollowResponse.mergeFrom(paramBundle);
          i = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
          if (i == 0)
          {
            paramBundle = PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
            if (paramBundle != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramBundle);
              paramInt = 1;
            }
          }
        }
        catch (Exception paramBundle) {}
        try
        {
          PublicAccountChatPie.h(this.a, true);
          PublicAccountChatPie.i(this.a, true);
          PublicAccountChatPie.h(this.a);
        }
        catch (Exception paramBundle) {}
      }
      PublicAccountChatPie.b(this.a);
      paramInt = 0;
      continue;
      if (i == 58)
      {
        this.a.n(2131363621);
        paramInt = 1;
      }
      else
      {
        this.a.n(2131363617);
        break label248;
        this.a.n(2131363617);
        break label248;
        break;
        break;
        label248:
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbq
 * JD-Core Version:    0.7.0.1
 */