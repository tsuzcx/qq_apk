package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class b$1
  implements Runnable
{
  b$1(int paramInt) {}
  
  public final void run()
  {
    if (!b.access$000()) {
      return;
    }
    if (this.kqx == 0)
    {
      long l = System.currentTimeMillis() - i.a.aTw().pn("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
      y.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : " + l);
      if ((l >= 0L) && (l <= 86400000L))
      {
        y.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
        return;
      }
      i.a.aTw().D("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
    }
    b.bo(false);
    Object localObject = j.aUk();
    m.a("FreeWifiLog", f.kqA, (com.tencent.mm.sdk.e.i)localObject, "MicroMsg.FreeWifi.FreeWifiLogStorage");
    localObject = ((f)localObject).aUM();
    String str = "ServerReportSimpleLog:" + b.S((LinkedList)localObject);
    m.Dr(str);
    y.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
    if (((LinkedList)localObject).size() > 0)
    {
      new e((LinkedList)localObject).b(new b.1.1(this));
      return;
    }
    b.bo(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f.b.1
 * JD-Core Version:    0.7.0.1
 */