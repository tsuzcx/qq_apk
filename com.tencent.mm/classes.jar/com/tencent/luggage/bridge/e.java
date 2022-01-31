package com.tencent.luggage.bridge;

import java.util.Map;
import org.json.JSONObject;

class e
  extends a
{
  protected e(b paramb)
  {
    this.bhj = paramb;
    this.bhk = new JSONObject();
  }
  
  final void b(Map<String, Object> paramMap)
  {
    this.bhk = new JSONObject(paramMap);
  }
  
  final void c(JSONObject paramJSONObject)
  {
    this.bhk = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.bridge.e
 * JD-Core Version:    0.7.0.1
 */