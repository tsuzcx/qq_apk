package com.tencent.luggage.bridge;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class a
{
  protected b csh;
  protected JSONObject csi;
  
  final b KW()
  {
    return this.csh;
  }
  
  final JSONObject KX()
  {
    return this.csi;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.csh.name());
    localHashMap.put("data", this.csi);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.a
 * JD-Core Version:    0.7.0.1
 */