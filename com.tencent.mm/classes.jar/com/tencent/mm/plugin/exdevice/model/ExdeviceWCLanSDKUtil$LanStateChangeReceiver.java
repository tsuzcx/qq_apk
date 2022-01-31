package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class ExdeviceWCLanSDKUtil$LanStateChangeReceiver
  extends BroadcastReceiver
{
  public ExdeviceWCLanSDKUtil$LanStateChangeReceiver(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19289);
    if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null) {
        if (((NetworkInfo)paramContext).getState() != NetworkInfo.State.CONNECTED) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =".concat(String.valueOf(bool)));
      if ((this.lFe.lFb) || (this.lFe.lFa != bool))
      {
        paramContext = new dy();
        paramContext.crN.crO = bool;
        a.ymk.l(paramContext);
        this.lFe.lFb = false;
        this.lFe.lFa = bool;
      }
      AppMethodBeat.o(19289);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.LanStateChangeReceiver
 * JD-Core Version:    0.7.0.1
 */