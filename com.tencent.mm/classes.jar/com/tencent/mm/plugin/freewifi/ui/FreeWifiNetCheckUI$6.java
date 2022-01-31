package com.tencent.mm.plugin.freewifi.ui;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.h.a;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.dh;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class FreeWifiNetCheckUI$6
  implements h.a
{
  FreeWifiNetCheckUI$6(FreeWifiNetCheckUI paramFreeWifiNetCheckUI, String paramString) {}
  
  public final void bR(List<ScanResult> paramList)
  {
    AppMethodBeat.i(21040);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.mOl.finish();
      FreeWifiNetCheckUI.c(this.mOl);
      AppMethodBeat.o(21040);
      return;
    }
    bwo localbwo = new bwo();
    localbwo.xJT = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ScanResult localScanResult = (ScanResult)paramList.next();
      if (localScanResult != null)
      {
        dh localdh = new dh();
        localdh.mac = localScanResult.BSSID;
        localdh.wpy = localScanResult.level;
        localdh.ssid = localScanResult.SSID;
        localbwo.xJT.add(localdh);
      }
    }
    paramList = com.tencent.mm.plugin.freewifi.k.bAc();
    paramList.kMp = m.U(FreeWifiNetCheckUI.b(this.mOl));
    paramList.mIF = k.b.mIX.mJq;
    paramList.mIG = k.b.mIX.name;
    paramList.cCy = 9;
    paramList.bAe().bAd();
    new com.tencent.mm.plugin.freewifi.d.k(this.mKT, localbwo, 9, m.U(this.mOl.getIntent())).c(new FreeWifiNetCheckUI.6.1(this));
    AppMethodBeat.o(21040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.6
 * JD-Core Version:    0.7.0.1
 */