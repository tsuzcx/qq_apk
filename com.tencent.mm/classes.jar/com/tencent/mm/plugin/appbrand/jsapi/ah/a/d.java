package com.tencent.mm.plugin.appbrand.jsapi.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class d
{
  public String pIL = "";
  public String pIM = "";
  public int pIN;
  public boolean pIO = false;
  public int pIP;
  public boolean pIQ = false;
  public boolean pIR = false;
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.pIL);
    localJSONObject.put("BSSID", this.pIM);
    localJSONObject.put("secure", this.pIO);
    localJSONObject.put("signalStrength", this.pIN);
    localJSONObject.put("frequency", this.pIP);
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.pIL + '\'' + ", mBssid='" + this.pIM + '\'' + ", mSignalStrength=" + this.pIN + ", mSecurity=" + this.pIO + ", frequency=" + this.pIP + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.d
 * JD-Core Version:    0.7.0.1
 */