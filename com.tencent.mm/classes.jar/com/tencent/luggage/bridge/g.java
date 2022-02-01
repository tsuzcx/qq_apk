package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  private JSONObject csi;
  private String csu;
  int csv;
  boolean csw;
  
  g(m paramm)
  {
    AppMethodBeat.i(140323);
    paramm = paramm.KX();
    this.csu = paramm.getString("method");
    this.csi = paramm.optJSONObject("data");
    if (this.csi == null) {
      this.csi = new JSONObject();
    }
    this.csv = paramm.optInt("callbackId", 0);
    this.csw = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */