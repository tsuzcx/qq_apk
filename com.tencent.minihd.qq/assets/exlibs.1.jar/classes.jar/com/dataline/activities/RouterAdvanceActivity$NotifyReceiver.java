package com.dataline.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;

public class RouterAdvanceActivity$NotifyReceiver
  extends BroadcastReceiver
{
  public RouterAdvanceActivity$NotifyReceiver(RouterAdvanceActivity paramRouterAdvanceActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst"))
    {
      int i = paramIntent.getExtras().getInt("deviceoprstcode");
      paramContext = new Message();
      paramContext.what = 1;
      paramContext.arg1 = i;
      paramContext.obj = ((SmartDeviceProxyMgr)this.a.app.a(53)).a();
      this.a.a.sendMessage(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.RouterAdvanceActivity.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */