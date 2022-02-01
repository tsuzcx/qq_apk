package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  private JSONObject eif;
  private String eir;
  int eit;
  boolean eiu;
  
  g(m paramm)
  {
    AppMethodBeat.i(140323);
    paramm = paramm.anZ();
    this.eir = paramm.getString("method");
    this.eif = paramm.optJSONObject("data");
    if (this.eif == null) {
      this.eif = new JSONObject();
    }
    this.eit = paramm.optInt("callbackId", 0);
    this.eiu = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */