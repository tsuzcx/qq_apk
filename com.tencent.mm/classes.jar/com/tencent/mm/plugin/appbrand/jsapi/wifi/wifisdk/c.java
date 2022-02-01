package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
{
  public int frequency;
  public String lwl = "";
  public String lwm = "";
  public int lwn;
  public boolean lwo = false;
  public boolean lwp = false;
  public boolean lwq = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.lwl);
    localJSONObject.put("BSSID", this.lwm);
    localJSONObject.put("secure", this.lwo);
    localJSONObject.put("signalStrength", this.lwn);
    localJSONObject.put("frequency", this.frequency);
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.lwl + '\'' + ", mBssid='" + this.lwm + '\'' + ", mSignalStrength=" + this.lwn + ", mSecurity=" + this.lwo + ", frequency=" + this.frequency + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */