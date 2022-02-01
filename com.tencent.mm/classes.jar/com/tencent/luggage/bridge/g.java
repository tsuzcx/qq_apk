package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g
{
  int cqA;
  boolean cqB;
  private JSONObject cqn;
  private String cqz;
  
  g(m paramm)
  {
    AppMethodBeat.i(140323);
    paramm = paramm.NN();
    this.cqz = paramm.getString("method");
    this.cqn = paramm.optJSONObject("data");
    if (this.cqn == null) {
      this.cqn = new JSONObject();
    }
    this.cqA = paramm.optInt("callbackId", 0);
    this.cqB = paramm.optBoolean("keepCallback", false);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */