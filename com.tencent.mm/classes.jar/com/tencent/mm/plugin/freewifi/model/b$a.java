package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
{
  String bssid = "";
  long mKe;
  String mKf = "";
  String ssid = "";
  int type;
  
  public final a bAu()
  {
    AppMethodBeat.i(20689);
    a locala = new a();
    locala.mKe = this.mKe;
    locala.type = this.type;
    locala.ssid = this.ssid;
    locala.bssid = this.bssid;
    locala.mKf = this.mKf;
    AppMethodBeat.o(20689);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20690);
    String str = String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[] { Long.valueOf(this.mKe), Integer.valueOf(this.type), this.ssid, this.bssid, this.mKf });
    AppMethodBeat.o(20690);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b.a
 * JD-Core Version:    0.7.0.1
 */