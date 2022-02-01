package com.tencent.mm.plugin.appbrand.jsapi.ak.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class e
{
  public String sNF = "";
  public String sNG = "";
  public Integer sNH = null;
  public Boolean sNI = null;
  public Integer sNJ = null;
  public boolean sNK = false;
  public boolean sNL = false;
  
  public final JSONObject aZh()
  {
    AppMethodBeat.i(144695);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.sNF);
    localJSONObject.put("BSSID", this.sNG);
    if (this.sNI != null) {
      localJSONObject.put("secure", this.sNI);
    }
    if (this.sNH != null) {
      localJSONObject.put("signalStrength", this.sNH);
    }
    if (this.sNJ != null) {
      localJSONObject.put("frequency", this.sNJ);
    }
    AppMethodBeat.o(144695);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144694);
    String str = "WiFiItem{mSsid='" + this.sNF + '\'' + ", mBssid='" + this.sNG + '\'' + ", mSignalStrength=" + this.sNH + ", mSecurity=" + this.sNI + ", frequency=" + this.sNJ + '}';
    AppMethodBeat.o(144694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.e
 * JD-Core Version:    0.7.0.1
 */