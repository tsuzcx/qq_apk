package cooperation.weiyun.channel;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWySender;
import com.weiyun.sdk.IWySender.IWySenderCallback;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class WySender
  implements IWySender
{
  private static final WySender jdField_a_of_type_CooperationWeiyunChannelWySender = new WySender();
  private static final String jdField_a_of_type_JavaLangString = "WySender";
  private static final String b = "sequence";
  private static final String c = "sendtimekey";
  private long jdField_a_of_type_Long = 1L;
  private IWySender.IWySenderCallback jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback;
  
  public static WySender a()
  {
    return jdField_a_of_type_CooperationWeiyunChannelWySender;
  }
  
  final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramToServiceMsg.extraData.getInt("sequence");
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      i = 0;
      if (i != 1002) {
        break label68;
      }
    }
    label68:
    for (this.jdField_a_of_type_Long += 1L;; this.jdField_a_of_type_Long = 1L)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.onRespond(j, i, paramFromServiceMsg.getWupBuffer());
      }
      return;
      i = paramFromServiceMsg.getResultCode();
      break;
    }
  }
  
  public void cancelCallback()
  {
    this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback = null;
  }
  
  public void sendRequest(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.e("WySender", 1, "sendRequest : seq[" + paramInt + "], cmd is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WySender", 1, "sendRequest : seq[" + paramInt + "], cmd[" + paramString + "]");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    paramString = new ToServiceMsg("mobileqq.service", String.valueOf(localAppRuntime.getLongAccountUin()), paramString);
    paramString.setTimeout(Math.min(60000L, (30000.0D * Math.pow(this.jdField_a_of_type_Long, 0.15D))));
    paramString.setEnableFastResend(true);
    paramString.putWupBuffer(paramArrayOfByte);
    paramString.extraData.putInt("sequence", paramInt);
    paramString.extraData.putLong("sendtimekey", System.currentTimeMillis());
    paramArrayOfByte = new NewIntent(localAppRuntime.getApplication(), WyServlet.class);
    paramArrayOfByte.putExtra(ToServiceMsg.class.getSimpleName(), paramString);
    localAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public void setCallback(IWySender.IWySenderCallback paramIWySenderCallback)
  {
    this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback = paramIWySenderCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.weiyun.channel.WySender
 * JD-Core Version:    0.7.0.1
 */