package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b
{
  public String ihD = "";
  public String ihE = "";
  public int ihF;
  public boolean ihG = false;
  public boolean ihH = false;
  public boolean ihI = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(94380);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.ihD);
    localJSONObject.put("BSSID", this.ihE);
    localJSONObject.put("secure", this.ihG);
    localJSONObject.put("signalStrength", this.ihF);
    AppMethodBeat.o(94380);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94379);
    String str = "WiFiItem{mSsid='" + this.ihD + '\'' + ", mBssid='" + this.ihE + '\'' + ", mSignalStrength=" + this.ihF + ", mSecurity=" + this.ihG + '}';
    AppMethodBeat.o(94379);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b
 * JD-Core Version:    0.7.0.1
 */