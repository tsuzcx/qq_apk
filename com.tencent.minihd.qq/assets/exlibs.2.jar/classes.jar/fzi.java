import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class fzi
  implements BusinessObserver
{
  public fzi(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    try
    {
      localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
      if (((mobileqq_mp.RetInfo)localGetEqqAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
      {
        paramBundle = new EqqDetail(localGetEqqAccountDetailInfoResponse);
        ThreadManager.a().post(new fzj(this, paramBundle));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzi
 * JD-Core Version:    0.7.0.1
 */