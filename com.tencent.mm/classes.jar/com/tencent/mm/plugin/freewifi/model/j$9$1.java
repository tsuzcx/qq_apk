package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.ScanResult;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.cy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class j$9$1
  implements h.a
{
  j$9$1(j.9 param9, String paramString) {}
  
  public final void bx(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    bmv localbmv = new bmv();
    localbmv.tGb = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ScanResult)paramList.next();
      if (localObject != null)
      {
        cy localcy = new cy();
        localcy.mac = ((ScanResult)localObject).BSSID;
        localcy.swm = ((ScanResult)localObject).level;
        localcy.ssid = ((ScanResult)localObject).SSID;
        localbmv.tGb.add(localcy);
      }
    }
    paramList = m.aTB();
    Object localObject = com.tencent.mm.plugin.freewifi.k.aTx();
    ((k.a)localObject).iGw = paramList;
    ((k.a)localObject).kmS = k.b.knk.knD;
    ((k.a)localObject).kmT = k.b.knk.name;
    ((k.a)localObject).bUR = 8;
    ((k.a)localObject).aTz().aTy();
    new com.tencent.mm.plugin.freewifi.d.k(this.kpg, localbmv, 8, paramList).b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.9.1
 * JD-Core Version:    0.7.0.1
 */