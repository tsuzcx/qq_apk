package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
{
  public int frequency;
  public String kxV = "";
  public String kxW = "";
  public int kxX;
  public boolean kxY = false;
  public boolean kxZ = false;
  public boolean kya = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.kxV);
    localJSONObject.put("BSSID", this.kxW);
    localJSONObject.put("secure", this.kxY);
    localJSONObject.put("signalStrength", this.kxX);
    localJSONObject.put("frequency", this.frequency);
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.kxV + '\'' + ", mBssid='" + this.kxW + '\'' + ", mSignalStrength=" + this.kxX + ", mSecurity=" + this.kxY + ", frequency=" + this.frequency + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */