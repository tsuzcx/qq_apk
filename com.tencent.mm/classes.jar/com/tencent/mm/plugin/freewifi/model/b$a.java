package com.tencent.mm.plugin.freewifi.model;

final class b$a
{
  String bssid = "";
  long kor;
  String kos = "";
  String ssid = "";
  int type;
  
  public final a aTR()
  {
    a locala = new a();
    locala.kor = this.kor;
    locala.type = this.type;
    locala.ssid = this.ssid;
    locala.bssid = this.bssid;
    locala.kos = this.kos;
    return locala;
  }
  
  public final String toString()
  {
    return String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[] { Long.valueOf(this.kor), Integer.valueOf(this.type), this.ssid, this.bssid, this.kos });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.b.a
 * JD-Core Version:    0.7.0.1
 */