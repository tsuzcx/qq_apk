package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  public JSONObject bVY;
  String bWk;
  public int bWl;
  private boolean bWm;
  private f bWp;
  boolean bWq;
  public String bWr;
  public JSONObject bWs;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140325);
    this.bWp = paramf;
    paramf = paramm.Ak();
    this.bWk = paramf.getString("method");
    this.bVY = paramf.optJSONObject("data");
    if (this.bVY == null) {
      this.bVY = new JSONObject("{}");
    }
    this.bWq = paramBoolean;
    this.bWl = paramf.optInt("callbackId", 0);
    this.bWm = false;
    this.bWs = new JSONObject();
    AppMethodBeat.o(140325);
  }
  
  public final void Am()
  {
    AppMethodBeat.i(140327);
    this.bWp.a(An());
    AppMethodBeat.o(140327);
  }
  
  final e An()
  {
    AppMethodBeat.i(140328);
    c localc = new c(this.bWl, this.bWr, this.bWs, this.bWm);
    AppMethodBeat.o(140328);
    return localc;
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140326);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.bWr = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.bWs = paramJSONObject;
      if (this.bWl != 0) {
        Am();
      }
      AppMethodBeat.o(140326);
      return;
      paramJSONObject = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.k
 * JD-Core Version:    0.7.0.1
 */