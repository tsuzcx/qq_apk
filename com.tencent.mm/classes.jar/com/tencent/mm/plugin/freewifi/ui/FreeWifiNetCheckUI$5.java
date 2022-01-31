package com.tencent.mm.plugin.freewifi.ui;

import android.net.wifi.ScanResult;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.cy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class FreeWifiNetCheckUI$5
  implements h.a
{
  FreeWifiNetCheckUI$5(FreeWifiNetCheckUI paramFreeWifiNetCheckUI, String paramString) {}
  
  public final void bx(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.ksx.finish();
      FreeWifiNetCheckUI.c(this.ksx);
      return;
    }
    bmv localbmv = new bmv();
    localbmv.tGb = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ScanResult localScanResult = (ScanResult)paramList.next();
      if (localScanResult != null)
      {
        cy localcy = new cy();
        localcy.mac = localScanResult.BSSID;
        localcy.swm = localScanResult.level;
        localcy.ssid = localScanResult.SSID;
        localbmv.tGb.add(localcy);
      }
    }
    paramList = com.tencent.mm.plugin.freewifi.k.aTx();
    paramList.iGw = m.B(FreeWifiNetCheckUI.b(this.ksx));
    paramList.kmS = k.b.knk.knD;
    paramList.kmT = k.b.knk.name;
    paramList.bUR = 9;
    paramList.aTz().aTy();
    new com.tencent.mm.plugin.freewifi.d.k(this.kpg, localbmv, 9, m.B(this.ksx.getIntent())).b(new FreeWifiNetCheckUI.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.5
 * JD-Core Version:    0.7.0.1
 */