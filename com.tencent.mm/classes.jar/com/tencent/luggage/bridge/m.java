package com.tencent.luggage.bridge;

import org.json.JSONObject;

final class m
  extends a
{
  m(JSONObject paramJSONObject)
  {
    this.bhj = b.valueOf(paramJSONObject.getString("type"));
    this.bhk = paramJSONObject.optJSONObject("data");
    if (this.bhk == null) {
      this.bhk = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.bridge.m
 * JD-Core Version:    0.7.0.1
 */