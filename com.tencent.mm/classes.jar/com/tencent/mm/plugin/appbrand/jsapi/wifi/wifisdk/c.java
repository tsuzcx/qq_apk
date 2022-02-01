package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
{
  public int frequency;
  public String kZj = "";
  public String kZk = "";
  public int kZl;
  public boolean kZm = false;
  public boolean kZn = false;
  public boolean kZo = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.kZj);
    localJSONObject.put("BSSID", this.kZk);
    localJSONObject.put("secure", this.kZm);
    localJSONObject.put("signalStrength", this.kZl);
    localJSONObject.put("frequency", this.frequency);
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.kZj + '\'' + ", mBssid='" + this.kZk + '\'' + ", mSignalStrength=" + this.kZl + ", mSecurity=" + this.kZm + ", frequency=" + this.frequency + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */