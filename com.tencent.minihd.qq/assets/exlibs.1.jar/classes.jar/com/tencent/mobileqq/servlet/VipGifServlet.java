package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class VipGifServlet
  extends MSFServlet
{
  public static final String a = "gif_ui_show";
  public static final String b = "gif_ui_show_bid";
  public static final String c = "gif_ui_show_seq";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void service(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((str != null) && ("gif_ui_show".equals(str)))
    {
      int i = paramIntent.getIntExtra("gif_ui_show_bid", 0);
      long l = paramIntent.getLongExtra("gif_ui_show_seq", 0L);
      paramIntent = new Bundle();
      paramIntent.putInt("gif_ui_show_bid", i);
      paramIntent.putLong("gif_ui_show_seq", l);
      notifyObserver(null, 0, true, paramIntent, VipGifObserver.class);
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.VipGifServlet
 * JD-Core Version:    0.7.0.1
 */