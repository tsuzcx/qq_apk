package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.dh;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class j$9$1
  implements h.a
{
  j$9$1(j.9 param9, String paramString) {}
  
  public final void bR(List<ScanResult> paramList)
  {
    AppMethodBeat.i(20747);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(20747);
      return;
    }
    bwo localbwo = new bwo();
    localbwo.xJT = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ScanResult)paramList.next();
      if (localObject != null)
      {
        dh localdh = new dh();
        localdh.mac = ((ScanResult)localObject).BSSID;
        localdh.wpy = ((ScanResult)localObject).level;
        localdh.ssid = ((ScanResult)localObject).SSID;
        localbwo.xJT.add(localdh);
      }
    }
    paramList = m.bAg();
    Object localObject = com.tencent.mm.plugin.freewifi.k.bAc();
    ((k.a)localObject).kMp = paramList;
    ((k.a)localObject).mIF = k.b.mIX.mJq;
    ((k.a)localObject).mIG = k.b.mIX.name;
    ((k.a)localObject).cCy = 8;
    ((k.a)localObject).bAe().bAd();
    new com.tencent.mm.plugin.freewifi.d.k(this.mKT, localbwo, 8, paramList).c(null);
    AppMethodBeat.o(20747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.9.1
 * JD-Core Version:    0.7.0.1
 */