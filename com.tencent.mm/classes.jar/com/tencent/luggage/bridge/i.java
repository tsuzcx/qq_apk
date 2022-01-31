package com.tencent.luggage.bridge;

import org.json.JSONObject;

public final class i
{
  private JSONObject bhA;
  String bhz;
  
  i(m paramm)
  {
    paramm = paramm.pO();
    this.bhz = paramm.getString("event");
    this.bhA = paramm.optJSONObject("data");
    if (this.bhA == null) {
      this.bhA = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.i
 * JD-Core Version:    0.7.0.1
 */