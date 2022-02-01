package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class SecMsgServlet
  extends MSFServlet
{
  public static final String a = "cmd";
  public static final String b = "data";
  public static final String c = "timeout";
  private static final String d = "SecMsgServlet";
  private static final String e = "secmsg.";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd"));
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      SecMsgHandler localSecMsgHandler = (SecMsgHandler)((QQAppInterface)super.getAppRuntime()).a(42);
      if (localSecMsgHandler != null) {
        localSecMsgHandler.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgServlet", 2, "onReceive exit");
      }
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onSend cmd=" + paramIntent.getStringExtra("cmd"));
    }
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    paramPacket.setSSOCommand("secmsg." + str);
    paramPacket.setTimeout(l);
    if (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.a(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecMsgServlet
 * JD-Core Version:    0.7.0.1
 */