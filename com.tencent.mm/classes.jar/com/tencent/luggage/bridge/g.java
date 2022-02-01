package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  private JSONObject bZb;
  private String bZn;
  int bZo;
  boolean bZp;
  
  g(m paramm)
  {
    AppMethodBeat.i(140323);
    paramm = paramm.AG();
    this.bZn = paramm.getString("method");
    this.bZb = paramm.optJSONObject("data");
    if (this.bZb == null) {
      this.bZb = new JSONObject();
    }
    this.bZo = paramm.optInt("callbackId", 0);
    this.bZp = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */