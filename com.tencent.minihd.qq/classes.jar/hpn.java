import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgHandler;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_GetBaseInfo_Req;
import com.tencent.pb.secmsg.SecMsgComu.SecMsg_Req;
import com.tencent.qphone.base.util.QLog;

public class hpn
  implements OnPluginInstallListener
{
  public hpn(SecMsgHandler paramSecMsgHandler) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallBegin, pluginId:" + paramString);
    }
    SecMsgHandler.jdField_a_of_type_Boolean = true;
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
    SecMsgHandler.jdField_a_of_type_Boolean = true;
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    paramInt = SecMsgHandler.l;
    SecMsgHandler.l = paramInt - 1;
    if (paramInt > 0)
    {
      this.a.a();
      return;
    }
    SecMsgHandler.jdField_a_of_type_Boolean = false;
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallFinish, pluginId:" + paramString);
    }
    SecMsgHandler.jdField_a_of_type_Boolean = false;
    paramString = (SecMsgManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((paramString != null) && (paramString.c())) {
      paramString.a(true, NetConnInfoCenter.getServerTime());
    }
    paramString = new SecMsgComu.SecMsg_GetBaseInfo_Req();
    paramString.mask.set(-1L);
    SecMsgComu.SecMsg_Req localSecMsg_Req = SecMsgHandler.a(this.a, 6, SecMsgUtil.a());
    localSecMsg_Req.reqcmd_0x06.set(paramString);
    SecMsgHandler.a(this.a, 6, localSecMsg_Req.toByteArray(), 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpn
 * JD-Core Version:    0.7.0.1
 */