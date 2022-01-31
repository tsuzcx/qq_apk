package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class dx$a
  extends Handler
{
  public dx$a(dx paramdx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      synchronized (dx.e(this.a))
      {
        switch (paramMessage.what)
        {
        case 1201: 
          return;
          dx.f(this.a);
        }
      }
      try
      {
        paramMessage = dx.g(this.a);
        if ((paramMessage != null) && (paramMessage.size() > 0)) {
          break label132;
        }
        j.a("TxWifiProvider", 6, "wifiList is null");
        if (dx.h(this.a)) {
          dx.d(this.a).b(ee.a);
        }
        dx.a(this.a, "");
      }
      catch (Throwable paramMessage)
      {
        j.a("TxWifiProvider", "process wifi list error!", paramMessage);
      }
      continue;
      label132:
      if ((dx.h(this.a)) && (de.a().d("up_wifis")))
      {
        dx.a(this.a, paramMessage);
        dx.i(this.a);
      }
      if (dx.j(this.a) == null) {
        dx.b(this.a, new ArrayList());
      }
      int i = 1;
      label401:
      for (;;)
      {
        try
        {
          dx.a(this.a, "");
          Iterator localIterator = paramMessage.iterator();
          if (localIterator.hasNext())
          {
            ScanResult localScanResult = (ScanResult)localIterator.next();
            if (i > 20) {
              break label401;
            }
            dx.a(this.a, dx.k(this.a) + localScanResult.SSID + "," + localScanResult.BSSID + "|");
            i += 1;
            continue;
          }
          if (dx.j(this.a) == null) {
            break;
          }
        }
        catch (Throwable localThrowable)
        {
          j.a("TxWifiProvider", 6, localThrowable.toString());
          dx.j(this.a).clear();
          dx.j(this.a).addAll(paramMessage);
          dy.a(dx.j(this.a));
        }
        if (dx.j(this.a).size() <= 0) {
          break;
        }
        Collections.sort(dx.j(this.a), dx.b());
        dx.l(this.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.dx.a
 * JD-Core Version:    0.7.0.1
 */