package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  private JSONObject bVY;
  private String bWk;
  int bWl;
  boolean bWm;
  
  g(m paramm)
  {
    AppMethodBeat.i(140323);
    paramm = paramm.Ak();
    this.bWk = paramm.getString("method");
    this.bVY = paramm.optJSONObject("data");
    if (this.bVY == null) {
      this.bVY = new JSONObject();
    }
    this.bWl = paramm.optInt("callbackId", 0);
    this.bWm = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */