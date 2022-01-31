package com.tencent.kinda.framework;

import android.content.Context;
import android.net.wifi.WifiInfo;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.wallet_core.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WxCrossServices$9
  extends n.a
{
  WxCrossServices$9(WxCrossServices paramWxCrossServices) {}
  
  public void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(144248);
    b.dRI();
    if ((!b.dpQ()) || (!WxCrossServices.access$100(this.this$0)) || (!KindaApp.appKinda().isInAnyUseCase()))
    {
      AppMethodBeat.o(144248);
      return;
    }
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    Object localObject1 = ah.getContext();
    if (!at.isConnected((Context)localObject1)) {
      localITransmitKvData.putString("type", "NON_NETWORK");
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      KindaApp.appKinda().networkChange(localITransmitKvData);
      AppMethodBeat.o(144248);
      return;
      if (!at.isWifi((Context)localObject1)) {
        break;
      }
      localITransmitKvData.putString("type", "WIFI");
      localObject2 = at.getWifiInfo((Context)localObject1);
      localObject1 = ((WifiInfo)localObject2).getSSID();
      localObject2 = ((WifiInfo)localObject2).getBSSID();
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = new HashMap();
        ((Map)localObject3).put("ssid", localObject1);
        ((Map)localObject3).put("bssid", localObject2);
        localObject1 = m.ak((Map)localObject3);
        localITransmitKvData.putString("info", ((aw)localObject1).wmS);
        localITransmitKvData.putString("info_key", ((aw)localObject1).wmT);
      }
    }
    if (at.is4G((Context)localObject1)) {
      localITransmitKvData.putString("type", "4G");
    }
    for (;;)
    {
      localObject1 = at.hc((Context)localObject1);
      if (((List)localObject1).size() <= 0) {
        break;
      }
      localObject3 = (at.a)((List)localObject1).get(0);
      localObject1 = ((at.a)localObject3).oEo;
      localObject2 = ((at.a)localObject3).oEm;
      localObject3 = ((at.a)localObject3).oEn;
      if ((localObject1 == null) || (localObject2 == null) || (localObject3 == null)) {
        break;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("cellid", localObject1);
      localHashMap.put("mcc", localObject2);
      localHashMap.put("mnc", localObject3);
      localObject1 = m.ak(localHashMap);
      localITransmitKvData.putString("info", ((aw)localObject1).wmS);
      localITransmitKvData.putString("info_key", ((aw)localObject1).wmT);
      break;
      if (at.is3G((Context)localObject1)) {
        localITransmitKvData.putString("type", "3G");
      } else if (at.is2G((Context)localObject1)) {
        localITransmitKvData.putString("type", "2G");
      } else {
        localITransmitKvData.putString("type", "UNKNOW");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.9
 * JD-Core Version:    0.7.0.1
 */