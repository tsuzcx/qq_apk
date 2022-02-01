package com.tencent.mobileqq.compatible;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class PbServlet
  extends MSFServlet
{
  private static final String a = "PbServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = WupUtil.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      TroopHandler localTroopHandler = (TroopHandler)((QQAppInterface)getAppRuntime()).a(19);
      if (localTroopHandler != null) {
        localTroopHandler.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.compatible.PbServlet
 * JD-Core Version:    0.7.0.1
 */