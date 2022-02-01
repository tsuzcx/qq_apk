package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  boolean csA;
  public String csB;
  public JSONObject csC;
  public JSONObject csi;
  String csu;
  public int csv;
  private boolean csw;
  private f csz;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140325);
    this.csz = paramf;
    paramf = paramm.KX();
    this.csu = paramf.getString("method");
    this.csi = paramf.optJSONObject("data");
    if (this.csi == null) {
      this.csi = new JSONObject("{}");
    }
    this.csA = paramBoolean;
    this.csv = paramf.optInt("callbackId", 0);
    this.csw = false;
    this.csC = new JSONObject();
    AppMethodBeat.o(140325);
  }
  
  final e KZ()
  {
    AppMethodBeat.i(140328);
    c localc = new c(this.csv, this.csB, this.csC, this.csw);
    AppMethodBeat.o(140328);
    return localc;
  }
  
  public final void c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140326);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.csB = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.csC = paramJSONObject;
      if (this.csv != 0) {
        callback();
      }
      AppMethodBeat.o(140326);
      return;
      paramJSONObject = new JSONObject();
    }
  }
  
  public final void callback()
  {
    AppMethodBeat.i(140327);
    this.csz.a(KZ());
    AppMethodBeat.o(140327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.k
 * JD-Core Version:    0.7.0.1
 */