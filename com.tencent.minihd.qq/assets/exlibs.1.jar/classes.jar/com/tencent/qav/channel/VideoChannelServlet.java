package com.tencent.qav.channel;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class VideoChannelServlet
  extends MSFServlet
{
  public static final int a = 1;
  public static final String a = "req_type";
  public static final int b = 2;
  public static final String b = "wup_buffer";
  public static final int c = 3;
  public static final String c = "uin";
  public static final int d = 4;
  public static final String d = "app_id";
  public static final int e = 5;
  private static final String e = "VideoChannelServlet";
  public static final int f = 6;
  public static final int g = 7;
  protected AppRuntime a;
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "SharpSvr.c2s");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void a(String paramString, int paramInt)
  {
    VideoChannelImpl.a().receiveGatewayMsg(paramString, paramInt);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    VideoChannelImpl.a().receiveSharpVideoMsg(paramArrayOfByte);
  }
  
  private void b(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "SharpSvr.s2cack");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    VideoChannelImpl.a().receiveSharpVideoAck(paramArrayOfByte);
  }
  
  private void c(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "MultiVideo.c2s");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    VideoChannelImpl.a().receiveMultiVideoMsg(paramArrayOfByte);
  }
  
  private void d(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "MultiVideo.s2cack");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    VideoChannelImpl.a().receiveMultiVideoAck(paramArrayOfByte);
  }
  
  private void e(Intent paramIntent, Bundle paramBundle)
  {
    int i = paramBundle.getInt("app_id");
    paramBundle = MsfMsgUtil.getGatewayIpMsg(null);
    paramBundle.setTimeout(30000L);
    paramBundle.setNeedCallback(true);
    paramBundle.setNeedRemindSlowNetwork(false);
    paramBundle.setAppId(i);
    sendToMSF(paramIntent, paramBundle);
  }
  
  private void e(byte[] paramArrayOfByte)
  {
    VideoChannelImpl.a().receiveVideoConfig(paramArrayOfByte);
  }
  
  private void f(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "VideoCCSvc.Adaptation");
    localToServiceMsg.putWupBuffer(paramBundle);
    localToServiceMsg.setTimeout(10000L);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void g(Intent paramIntent, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("wup_buffer");
    paramBundle = new ToServiceMsg(null, String.valueOf(paramBundle.getLong("uin")), "CliLogSvc.UploadReq");
    paramBundle.putWupBuffer(arrayOfByte);
    paramBundle.setNeedCallback(false);
    sendToMSF(paramIntent, paramBundle);
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = getAppRuntime();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    do
    {
      return;
      paramIntent = paramFromServiceMsg.getServiceCmd();
      AVLog.d("VideoChannelServlet", String.format("onReceive cmd=%s", new Object[] { paramIntent }));
      if ("SharpSvr.s2c".equalsIgnoreCase(paramIntent))
      {
        a(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("SharpSvr.c2sack".equalsIgnoreCase(paramIntent))
      {
        b(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("MultiVideo.s2c".equalsIgnoreCase(paramIntent))
      {
        c(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("MultiVideo.c2sack".equalsIgnoreCase(paramIntent))
      {
        d(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if (!"cmd_getGatewayIp".equalsIgnoreCase(paramIntent)) {
        break;
      }
      paramIntent = (String)paramFromServiceMsg.getAttribute("cmd_getGatewayIp");
    } while (paramIntent == null);
    AVLog.d("VideoChannelServlet", String.format(">>> ip=%s", new Object[] { paramIntent }));
    a(paramIntent, 0);
    return;
    if ("VideoCCSvc.Adaptation".equalsIgnoreCase(paramIntent))
    {
      if (paramFromServiceMsg.isSuccess())
      {
        e(paramFromServiceMsg.getWupBuffer());
        return;
      }
      AVLog.e("VideoChannelServlet", String.format("onReceive get config fail, resultCode=%s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
      return;
    }
    AVLog.w("VideoChannelServlet", "onReceive handle not process cmd.");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = paramIntent.getExtras();
    if (paramPacket == null) {
      return;
    }
    int i = paramPacket.getInt("req_type", -1);
    AVLog.d("VideoChannelServlet", String.format("onSend reqType=%s", new Object[] { Integer.valueOf(i) }));
    switch (i)
    {
    default: 
      AVLog.w("VideoChannelServlet", "onSend handle not define reqType.");
      return;
    case 1: 
      a(paramIntent, paramPacket);
      return;
    case 2: 
      b(paramIntent, paramPacket);
      return;
    case 3: 
      c(paramIntent, paramPacket);
      return;
    case 4: 
      d(paramIntent, paramPacket);
      return;
    case 5: 
      e(paramIntent, paramPacket);
      return;
    case 6: 
      f(paramIntent, paramPacket);
      return;
    }
    g(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelServlet
 * JD-Core Version:    0.7.0.1
 */