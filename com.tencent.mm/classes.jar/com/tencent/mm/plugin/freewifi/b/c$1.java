package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class c$1
  implements f
{
  c$1(c paramc, LinkedList paramLinkedList, int paramInt, fi paramfi) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20673);
    synchronized (this.mJR)
    {
      paramm = ((j)paramm).bBc();
      this.mJR.kj(System.currentTimeMillis());
      localObject1 = this.mJR;
      int i;
      if (paramm.mJM <= 0) {
        i = 180;
      }
      for (;;)
      {
        ((c)localObject1).wk(i);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramm.mJL);
        if (paramm.mJL <= 0)
        {
          i = 200;
          label99:
          ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i)));
          this.mJR.wj(i);
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label1021;
          }
          paramString = paramm.xrr;
          localObject1 = null;
        }
        for (;;)
        {
          try
          {
            paramm = new MatrixCursor(c.arg());
          }
          catch (Exception paramString)
          {
            bcj localbcj;
            Object localObject2;
            paramm = (com.tencent.mm.ai.m)localObject1;
            continue;
            paramInt1 += 1;
            continue;
          }
          try
          {
            localObject1 = new HashMap();
            paramInt1 = 0;
            if (paramInt1 < paramString.size())
            {
              localbcj = (bcj)paramString.get(paramInt1);
              ((Map)localObject1).put(localbcj.ssid + "-" + localbcj.bssid, Integer.valueOf(paramInt1));
              paramInt1 += 1;
              continue;
              i = paramm.mJM;
              break;
              i = paramm.mJL;
              break label99;
            }
            paramInt1 = 0;
            if (paramInt1 >= this.mJO.size()) {
              continue;
            }
            localObject2 = (bci)this.mJO.get(paramInt1);
            localbcj = new bcj();
            localbcj.ssid = ((bci)localObject2).ssid;
            localbcj.bssid = ((bci)localObject2).bssid;
            localbcj.csT = ((bci)localObject2).csT;
            localbcj.xrs = 0;
            localbcj.xrt = null;
            localbcj.mIE = 0;
            localbcj.coX = null;
            if (((Map)localObject1).get(localbcj.ssid + "-" + localbcj.bssid) != null)
            {
              localObject2 = (Integer)((Map)localObject1).get(localbcj.ssid + "-" + localbcj.bssid);
              if (paramString.get(((Integer)localObject2).intValue()) != null)
              {
                localbcj.xrs = ((bcj)paramString.get(((Integer)localObject2).intValue())).xrs;
                localbcj.xrt = ((bcj)paramString.get(((Integer)localObject2).intValue())).xrt;
                localbcj.mIE = ((bcj)paramString.get(((Integer)localObject2).intValue())).mIE;
                localbcj.coX = ((bcj)paramString.get(((Integer)localObject2).intValue())).coX;
              }
            }
            if ((localbcj.mIE != 4) && (localbcj.mIE != 31))
            {
              paramm.addRow(new Object[] { localbcj.ssid, localbcj.bssid, Integer.valueOf(localbcj.csT), Integer.valueOf(0), null, Integer.valueOf(this.mJR.bAp()), Integer.valueOf(this.mJR.bAq()) });
              ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbcj.ssid, localbcj.bssid, Integer.valueOf(localbcj.csT), Integer.valueOf(0), null, Integer.valueOf(this.mJR.bAp()), Integer.valueOf(this.mJR.bAq()) });
            }
            else
            {
              paramm.addRow(new Object[] { localbcj.ssid, localbcj.bssid, Integer.valueOf(localbcj.csT), Integer.valueOf(localbcj.xrs), localbcj.xrt, Integer.valueOf(this.mJR.bAp()), Integer.valueOf(this.mJR.bAq()) });
              ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbcj.ssid, localbcj.bssid, Integer.valueOf(localbcj.csT), Integer.valueOf(localbcj.xrs), localbcj.xrt, Integer.valueOf(this.mJR.bAp()), Integer.valueOf(this.mJR.bAq()) });
              if ((localbcj.xrs == 1) && (this.mJP == 1))
              {
                a.a.bAm().e(localbcj.ssid, localbcj.bssid, localbcj.coX, localbcj.mIE);
                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localbcj.ssid, localbcj.bssid, localbcj.coX, Integer.valueOf(localbcj.mIE) });
              }
            }
          }
          catch (Exception paramString) {}
        }
      }
      if (paramm != null) {
        paramm.close();
      }
      ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
      c.a(this.mJR, this.mJQ, 1108, "cursor exception.");
      AppMethodBeat.o(20673);
      return;
      c.a(this.mJQ, paramm);
      AppMethodBeat.o(20673);
      return;
      label1021:
      if (paramInt2 == -30035)
      {
        c.a(this.mJR, this.mJQ, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + this.mJR.bAp() + ".");
        AppMethodBeat.o(20673);
        return;
      }
      c.a(this.mJR, this.mJQ, 1121, "Server returns errtype= " + paramInt1 + ", errcode=" + paramInt2 + ", errMsg=" + com.tencent.mm.plugin.freewifi.m.Ov(paramString) + ".");
      AppMethodBeat.o(20673);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c.1
 * JD-Core Version:    0.7.0.1
 */