package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.dv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class j$9$1
  implements h.a
{
  j$9$1(j.9 param9, String paramString) {}
  
  public final void dG(List<ScanResult> paramList)
  {
    AppMethodBeat.i(24820);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(24820);
      return;
    }
    cry localcry = new cry();
    localcry.FEB = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ScanResult)paramList.next();
      if (localObject != null)
      {
        dv localdv = new dv();
        localdv.mac = ((ScanResult)localObject).BSSID;
        localdv.fLO = ((ScanResult)localObject).level;
        localdv.ssid = ((ScanResult)localObject).SSID;
        localcry.FEB.add(localdv);
      }
    }
    paramList = m.cIG();
    Object localObject = com.tencent.mm.plugin.freewifi.k.cIC();
    ((k.a)localObject).ovU = paramList;
    ((k.a)localObject).soE = k.b.soW.spp;
    ((k.a)localObject).soF = k.b.soW.name;
    ((k.a)localObject).channel = 8;
    ((k.a)localObject).cIE().cID();
    new com.tencent.mm.plugin.freewifi.d.k(this.sqQ, localcry, 8, paramList).c(null);
    AppMethodBeat.o(24820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j.9.1
 * JD-Core Version:    0.7.0.1
 */