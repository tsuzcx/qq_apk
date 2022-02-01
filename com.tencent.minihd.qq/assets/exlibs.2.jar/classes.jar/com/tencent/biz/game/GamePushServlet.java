package com.tencent.biz.game;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class GamePushServlet
  extends MSFServlet
{
  private String[] a = { "OnlinePush.ReqPush.GameStatusPush" };
  
  public String[] getPreferSSOCommands()
  {
    return this.a;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    MSFToWebViewConnector localMSFToWebViewConnector = SensorAPIJavaScript.getMsfToWebViewConnector();
    if (localMSFToWebViewConnector != null) {
      localMSFToWebViewConnector.a(paramIntent, paramFromServiceMsg);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GamePushServlet", 2, "WebView not connect to msf");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.game.GamePushServlet
 * JD-Core Version:    0.7.0.1
 */