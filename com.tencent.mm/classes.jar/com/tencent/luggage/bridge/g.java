package com.tencent.luggage.bridge;

import org.json.JSONObject;

public final class g
{
  private JSONObject bhk;
  private String bhw;
  int bhx;
  boolean bhy;
  
  g(m paramm)
  {
    paramm = paramm.pO();
    this.bhw = paramm.getString("method");
    this.bhk = paramm.optJSONObject("data");
    if (this.bhk == null) {
      this.bhk = new JSONObject();
    }
    this.bhx = paramm.optInt("callbackId", 0);
    this.bhy = paramm.optBoolean("keepCallback", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.bridge.g
 * JD-Core Version:    0.7.0.1
 */