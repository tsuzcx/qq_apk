package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  int cgA;
  boolean cgB;
  private JSONObject cgn;
  private String cgz;
  
  g(m paramm)
  {
    AppMethodBeat.i(140323);
    paramm = paramm.BI();
    this.cgz = paramm.getString("method");
    this.cgn = paramm.optJSONObject("data");
    if (this.cgn == null) {
      this.cgn = new JSONObject();
    }
    this.cgA = paramm.optInt("callbackId", 0);
    this.cgB = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */