package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.mm.h.a.dv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

public class ExdeviceWCLanSDKUtil$LanStateChangeReceiver
  extends BroadcastReceiver
{
  public ExdeviceWCLanSDKUtil$LanStateChangeReceiver(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        if (((NetworkInfo)paramContext).getState() != NetworkInfo.State.CONNECTED) {
          break label121;
        }
      }
    }
    label121:
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =" + bool);
      if ((this.jvF.jvC) || (this.jvF.jvB != bool))
      {
        paramContext = new dv();
        paramContext.bKt.bKu = bool;
        a.udP.m(paramContext);
        this.jvF.jvC = false;
        this.jvF.jvB = bool;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.LanStateChangeReceiver
 * JD-Core Version:    0.7.0.1
 */