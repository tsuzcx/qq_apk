package com.tencent.mm.plugin.freewifi.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class b$1
  implements Runnable
{
  b$1(int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(20869);
    if (!b.access$000())
    {
      AppMethodBeat.o(20869);
      return;
    }
    if (this.mMj == 0)
    {
      long l = System.currentTimeMillis() - i.a.bAb().lU("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
      ab.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : ".concat(String.valueOf(l)));
      if ((l >= 0L) && (l <= 86400000L))
      {
        ab.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
        AppMethodBeat.o(20869);
        return;
      }
      i.a.bAb().V("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
    }
    b.access$002(false);
    Object localObject1 = com.tencent.mm.plugin.freewifi.model.j.bAM();
    m.a("FreeWifiLog", f.mMm, (com.tencent.mm.sdk.e.j)localObject1, "MicroMsg.FreeWifi.FreeWifiLogStorage");
    Object localObject2 = ((f)localObject1).rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
    localObject1 = new LinkedList();
    while ((localObject2 != null) && (((Cursor)localObject2).moveToNext()))
    {
      aeb localaeb = new aeb();
      localaeb.id = ((Cursor)localObject2).getString(0);
      localaeb.mLg = ((Cursor)localObject2).getInt(1);
      localaeb.wWY = ((Cursor)localObject2).getString(2);
      localaeb.wWZ = ((Cursor)localObject2).getLong(3);
      ((LinkedList)localObject1).add(localaeb);
    }
    if (localObject2 != null) {
      ((Cursor)localObject2).close();
    }
    localObject2 = "ServerReportSimpleLog:" + b.U((LinkedList)localObject1);
    m.Oz((String)localObject2);
    ab.i("MicroMsg.FreeWifi.FreeWifiServerReporter", (String)localObject2);
    if (((LinkedList)localObject1).size() > 0)
    {
      new e((LinkedList)localObject1).c(new b.1.1(this));
      AppMethodBeat.o(20869);
      return;
    }
    b.access$002(true);
    AppMethodBeat.o(20869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f.b.1
 * JD-Core Version:    0.7.0.1
 */