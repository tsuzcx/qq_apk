package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class m
  extends a
{
  m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140329);
    this.bVX = b.valueOf(paramJSONObject.getString("type"));
    this.bVY = paramJSONObject.optJSONObject("data");
    if (this.bVY == null) {
      this.bVY = new JSONObject();
    }
    AppMethodBeat.o(140329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.m
 * JD-Core Version:    0.7.0.1
 */