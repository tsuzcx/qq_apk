package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class i
{
  String bxZ;
  private JSONObject bya;
  
  i(m paramm)
  {
    AppMethodBeat.i(90724);
    paramm = paramm.tS();
    this.bxZ = paramm.getString("event");
    this.bya = paramm.optJSONObject("data");
    if (this.bya == null) {
      this.bya = new JSONObject();
    }
    AppMethodBeat.o(90724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.i
 * JD-Core Version:    0.7.0.1
 */