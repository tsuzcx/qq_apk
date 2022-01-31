package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  private JSONObject bxK;
  private String bxW;
  int bxX;
  boolean bxY;
  
  g(m paramm)
  {
    AppMethodBeat.i(90723);
    paramm = paramm.tS();
    this.bxW = paramm.getString("method");
    this.bxK = paramm.optJSONObject("data");
    if (this.bxK == null) {
      this.bxK = new JSONObject();
    }
    this.bxX = paramm.optInt("callbackId", 0);
    this.bxY = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(90723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */