package com.tencent.luggage.bridge;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class a
{
  protected b bZa;
  protected JSONObject bZb;
  
  final b AF()
  {
    return this.bZa;
  }
  
  final JSONObject AG()
  {
    return this.bZb;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.bZa.name());
    localHashMap.put("data", this.bZb);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.a
 * JD-Core Version:    0.7.0.1
 */