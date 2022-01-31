package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

class e
  extends a
{
  protected e(b paramb)
  {
    AppMethodBeat.i(90717);
    this.bxJ = paramb;
    this.bxK = new JSONObject();
    AppMethodBeat.o(90717);
  }
  
  final void c(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(90718);
    this.bxK = new JSONObject(paramMap);
    AppMethodBeat.o(90718);
  }
  
  final void c(JSONObject paramJSONObject)
  {
    this.bxK = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.bridge.e
 * JD-Core Version:    0.7.0.1
 */