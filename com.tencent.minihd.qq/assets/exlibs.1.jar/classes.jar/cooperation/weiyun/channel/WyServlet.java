package cooperation.weiyun.channel;

import android.content.Intent;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WyServlet
  extends MSFServlet
{
  private static final String a = "WyServlet";
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i >= 0) {}
    }
    else
    {
      return;
    }
    byte[] arrayOfByte = new byte[i];
    PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    paramFromServiceMsg.putWupBuffer(arrayOfByte);
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l + 4];
      PkgTools.a(arrayOfByte, 0, 4L + l);
      PkgTools.a(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    a(paramFromServiceMsg);
    if (paramIntent == null) {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    for (;;)
    {
      WySender.a().a(paramIntent, paramFromServiceMsg);
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      QLog.e("WyServlet", 1, "onSend : req is null");
    }
    do
    {
      return;
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WyServlet", 1, "onSend : cmd[" + paramIntent.getServiceCmd() + "]");
      }
      a(paramIntent);
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
      paramPacket.setAttributes(paramIntent.getAttributes());
    } while (paramIntent.isNeedCallback());
    paramPacket.setNoResponse();
    return;
    QLog.e("WyServlet", 1, "onSend : toMsg is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.weiyun.channel.WyServlet
 * JD-Core Version:    0.7.0.1
 */