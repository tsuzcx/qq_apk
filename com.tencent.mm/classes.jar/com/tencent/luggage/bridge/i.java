package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class i
{
  String bWn;
  private JSONObject bWo;
  
  i(m paramm)
  {
    AppMethodBeat.i(140324);
    paramm = paramm.Ak();
    this.bWn = paramm.getString("event");
    this.bWo = paramm.optJSONObject("data");
    if (this.bWo == null) {
      this.bWo = new JSONObject();
    }
    AppMethodBeat.o(140324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.i
 * JD-Core Version:    0.7.0.1
 */