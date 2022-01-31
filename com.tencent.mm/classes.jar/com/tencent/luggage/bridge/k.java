package com.tencent.luggage.bridge;

import org.json.JSONObject;

public final class k
{
  private f bhB;
  boolean bhC;
  public String bhD;
  public JSONObject bhE;
  public JSONObject bhk;
  String bhw;
  public int bhx;
  private boolean bhy;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    this.bhB = paramf;
    paramf = paramm.pO();
    this.bhw = paramf.getString("method");
    this.bhk = paramf.optJSONObject("data");
    if (this.bhk == null) {
      this.bhk = new JSONObject("{}");
    }
    this.bhC = paramBoolean;
    this.bhx = paramf.optInt("callbackId", 0);
    this.bhy = false;
    this.bhE = new JSONObject();
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.bhD = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.bhE = paramJSONObject;
      if (this.bhx != 0) {
        pQ();
      }
      return;
      paramJSONObject = new JSONObject();
    }
  }
  
  public final void pQ()
  {
    this.bhB.a(pR());
  }
  
  final e pR()
  {
    return new c(this.bhx, this.bhD, this.bhE, this.bhy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.bridge.k
 * JD-Core Version:    0.7.0.1
 */