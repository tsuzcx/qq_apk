package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

class e
  extends a
{
  protected e(b paramb)
  {
    AppMethodBeat.i(140317);
    this.eie = paramb;
    this.eif = new JSONObject();
    AppMethodBeat.o(140317);
  }
  
  final void d(JSONObject paramJSONObject)
  {
    this.eif = paramJSONObject;
  }
  
  final void i(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140318);
    this.eif = new JSONObject(paramMap);
    AppMethodBeat.o(140318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.e
 * JD-Core Version:    0.7.0.1
 */