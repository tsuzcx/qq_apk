package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
{
  public int frequency;
  public String lAJ = "";
  public String lAK = "";
  public int lAL;
  public boolean lAM = false;
  public boolean lAN = false;
  public boolean lAO = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.lAJ);
    localJSONObject.put("BSSID", this.lAK);
    localJSONObject.put("secure", this.lAM);
    localJSONObject.put("signalStrength", this.lAL);
    localJSONObject.put("frequency", this.frequency);
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.lAJ + '\'' + ", mBssid='" + this.lAK + '\'' + ", mSignalStrength=" + this.lAL + ", mSecurity=" + this.lAM + ", frequency=" + this.frequency + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */