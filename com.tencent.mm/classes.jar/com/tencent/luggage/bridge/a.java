package com.tencent.luggage.bridge;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class a
{
  protected b cgm;
  protected JSONObject cgn;
  
  final b BG()
  {
    return this.cgm;
  }
  
  final JSONObject BH()
  {
    return this.cgn;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.cgm.name());
    localHashMap.put("data", this.cgn);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.a
 * JD-Core Version:    0.7.0.1
 */