package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import org.json.JSONObject;

public final class b
{
  public String gGV = "";
  public String gGW = "";
  public int gGX;
  public boolean gGY = false;
  public boolean gGZ = false;
  public boolean gHa = false;
  
  public final JSONObject rB()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.gGV);
    localJSONObject.put("BSSID", this.gGW);
    localJSONObject.put("secure", this.gGY);
    localJSONObject.put("signalStrength", this.gGX);
    return localJSONObject;
  }
  
  public final String toString()
  {
    return "WiFiItem{mSsid='" + this.gGV + '\'' + ", mBssid='" + this.gGW + '\'' + ", mSignalStrength=" + this.gGX + ", mSecurity=" + this.gGY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b
 * JD-Core Version:    0.7.0.1
 */