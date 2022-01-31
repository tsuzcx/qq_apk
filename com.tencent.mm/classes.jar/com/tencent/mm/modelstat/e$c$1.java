package com.tencent.mm.modelstat;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.List;

final class e$c$1
  implements Runnable
{
  e$c$1(e.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(78723);
    ab.i("MicroMsg.IndoorReporter", "start wifi");
    for (;;)
    {
      int k;
      int i;
      try
      {
        if (!this.fTi.fTg) {
          break label411;
        }
        long l = bo.aoy();
        List localList = this.fTi.bsO.getScanResults();
        Object localObject1 = "";
        if ((localList == null) || (localList.size() <= 0)) {
          break label420;
        }
        Collections.sort(localList, new e.c.1.1(this));
        k = 0;
        i = 0;
        j = i;
        localObject2 = localObject1;
        if (k < localList.size())
        {
          localObject2 = (ScanResult)localList.get(k);
          if ((localObject2 == null) || (bo.isNullOrNil(((ScanResult)localObject2).BSSID)) || (bo.isNullOrNil(((ScanResult)localObject2).SSID))) {
            break label417;
          }
          String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
          localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
          i += 1;
          if (i >= this.fTi.fSE) {
            break label436;
          }
          localObject1 = localObject2;
          break label429;
        }
        localObject1 = new StringBuilder().append(l - this.fTi.startTime).append(";");
        if (localList != null)
        {
          i = localList.size();
          localObject1 = i + ";" + j + ";" + (String)localObject2;
          ab.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
          this.fTi.fTh.add(localObject1);
          this.fTi.bsO.startScan();
          Thread.sleep(this.fTi.fTf);
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(78723);
        return;
      }
      continue;
      label411:
      AppMethodBeat.o(78723);
      return;
      label417:
      break label429;
      label420:
      int j = 0;
      Object localObject2 = localException;
      continue;
      label429:
      k += 1;
      continue;
      label436:
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.c.1
 * JD-Core Version:    0.7.0.1
 */