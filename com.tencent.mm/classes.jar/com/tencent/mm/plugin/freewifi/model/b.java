package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  b.a mKb;
  BroadcastReceiver mKc;
  
  private b()
  {
    AppMethodBeat.i(20692);
    this.mKb = new b.a((byte)0);
    this.mKc = new b.1(this);
    AppMethodBeat.o(20692);
  }
  
  static void a(b.a parama1, b.a parama2)
  {
    AppMethodBeat.i(20694);
    m.Oz("on mobile connected.");
    ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    com.tencent.mm.plugin.freewifi.f.b.kS(0);
    AppMethodBeat.o(20694);
  }
  
  static void b(b.a parama1, b.a parama2)
  {
    AppMethodBeat.i(20695);
    m.Oz("on wifi connected.");
    ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[] { parama1.toString(), parama2.toString() });
    if ((parama1.type == 1) && (parama1.ssid.equals(parama2.ssid)) && (!parama1.bssid.equals(parama2.bssid)))
    {
      String str = parama1.ssid;
      parama1 = parama1.bssid;
      parama2 = parama2.bssid;
      m.Oz("on wifi roaming.");
      ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[] { str, parama1, parama2 });
    }
    com.tencent.mm.plugin.freewifi.f.b.kS(1);
    AppMethodBeat.o(20695);
  }
  
  public final void bzQ()
  {
    AppMethodBeat.i(20693);
    try
    {
      ah.getContext().unregisterReceiver(this.mKc);
      AppMethodBeat.o(20693);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(20693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b
 * JD-Core Version:    0.7.0.1
 */