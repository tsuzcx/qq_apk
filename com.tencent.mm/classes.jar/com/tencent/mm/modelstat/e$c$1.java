package com.tencent.mm.modelstat;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.List;

final class e$c$1
  implements Runnable
{
  e$c$1(e.c paramc) {}
  
  public final void run()
  {
    y.i("MicroMsg.IndoorReporter", "start wifi");
    for (;;)
    {
      int k;
      try
      {
        if (this.eDr.eDp)
        {
          long l = bk.UY();
          List localList = this.eDr.bci.getScanResults();
          Object localObject1 = "";
          if ((localList == null) || (localList.size() <= 0)) {
            break label404;
          }
          Collections.sort(localList, new e.c.1.1(this));
          k = 0;
          i = 0;
          j = i;
          localObject2 = localObject1;
          if (k < localList.size())
          {
            localObject2 = (ScanResult)localList.get(k);
            if ((localObject2 == null) || (bk.bl(((ScanResult)localObject2).BSSID)) || (bk.bl(((ScanResult)localObject2).SSID))) {
              break label401;
            }
            String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
            localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
            i += 1;
            if (i >= this.eDr.eCN) {
              break label420;
            }
            localObject1 = localObject2;
            break label413;
          }
          localObject1 = new StringBuilder().append(l - this.eDr.startTime).append(";");
          if (localList != null)
          {
            i = localList.size();
            localObject1 = i + ";" + j + ";" + (String)localObject2;
            y.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
            this.eDr.eDq.add(localObject1);
            this.eDr.bci.startScan();
            Thread.sleep(this.eDr.eDo);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
      }
      int i = 0;
      continue;
      label401:
      break label413;
      label404:
      int j = 0;
      Object localObject2 = localException;
      continue;
      label413:
      k += 1;
      continue;
      label420:
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.c.1
 * JD-Core Version:    0.7.0.1
 */