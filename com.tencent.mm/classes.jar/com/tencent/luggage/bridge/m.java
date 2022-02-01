package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class m
  extends a
{
  m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140329);
    this.csh = b.valueOf(paramJSONObject.getString("type"));
    this.csi = paramJSONObject.optJSONObject("data");
    if (this.csi == null) {
      this.csi = new JSONObject();
    }
    AppMethodBeat.o(140329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.m
 * JD-Core Version:    0.7.0.1
 */