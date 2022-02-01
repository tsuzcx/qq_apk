package com.tencent.map.tools.json;

import org.json.JSONObject;

public abstract interface JsonParser
{
  public abstract void parse(JSONObject paramJSONObject);
  
  public static abstract interface Deserializer<T>
  {
    public abstract T deserialize(Object paramObject1, String paramString, Object paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.json.JsonParser
 * JD-Core Version:    0.7.0.1
 */