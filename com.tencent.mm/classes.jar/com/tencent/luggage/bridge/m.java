package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class m
  extends a
{
  m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140329);
    this.eie = b.valueOf(paramJSONObject.getString("type"));
    this.eif = paramJSONObject.optJSONObject("data");
    if (this.eif == null) {
      this.eif = new JSONObject();
    }
    AppMethodBeat.o(140329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.m
 * JD-Core Version:    0.7.0.1
 */