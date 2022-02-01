package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
{
  public int frequency;
  public String mHX = "";
  public String mHY = "";
  public int mHZ;
  public boolean mIa = false;
  public boolean mIb = false;
  public boolean mIc = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.mHX);
    localJSONObject.put("BSSID", this.mHY);
    localJSONObject.put("secure", this.mIa);
    localJSONObject.put("signalStrength", this.mHZ);
    localJSONObject.put("frequency", this.frequency);
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.mHX + '\'' + ", mBssid='" + this.mHY + '\'' + ", mSignalStrength=" + this.mHZ + ", mSecurity=" + this.mIa + ", frequency=" + this.frequency + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c
 * JD-Core Version:    0.7.0.1
 */