package com.tencent.luggage.bridge;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class a
{
  protected b bVX;
  protected JSONObject bVY;
  
  final b Aj()
  {
    return this.bVX;
  }
  
  final JSONObject Ak()
  {
    return this.bVY;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.bVX.name());
    localHashMap.put("data", this.bVY);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.a
 * JD-Core Version:    0.7.0.1
 */