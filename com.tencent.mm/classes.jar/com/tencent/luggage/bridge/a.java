package com.tencent.luggage.bridge;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class a
{
  protected b bhj;
  protected JSONObject bhk;
  
  final b pN()
  {
    return this.bhj;
  }
  
  final JSONObject pO()
  {
    return this.bhk;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.bhj.name());
    localHashMap.put("data", this.bhk);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.bridge.a
 * JD-Core Version:    0.7.0.1
 */