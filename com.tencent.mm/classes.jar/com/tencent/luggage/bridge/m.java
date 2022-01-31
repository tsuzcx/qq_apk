package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class m
  extends a
{
  m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90729);
    this.bxJ = b.valueOf(paramJSONObject.getString("type"));
    this.bxK = paramJSONObject.optJSONObject("data");
    if (this.bxK == null) {
      this.bxK = new JSONObject();
    }
    AppMethodBeat.o(90729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.bridge.m
 * JD-Core Version:    0.7.0.1
 */