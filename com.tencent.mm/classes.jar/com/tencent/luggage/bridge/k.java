package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  public int cgA;
  private boolean cgB;
  private f cgE;
  boolean cgF;
  public String cgG;
  public JSONObject cgH;
  public JSONObject cgn;
  String cgz;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140325);
    this.cgE = paramf;
    paramf = paramm.BI();
    this.cgz = paramf.getString("method");
    this.cgn = paramf.optJSONObject("data");
    if (this.cgn == null) {
      this.cgn = new JSONObject("{}");
    }
    this.cgF = paramBoolean;
    this.cgA = paramf.optInt("callbackId", 0);
    this.cgB = false;
    this.cgH = new JSONObject();
    AppMethodBeat.o(140325);
  }
  
  public final void BK()
  {
    AppMethodBeat.i(140327);
    this.cgE.a(BL());
    AppMethodBeat.o(140327);
  }
  
  final e BL()
  {
    AppMethodBeat.i(140328);
    c localc = new c(this.cgA, this.cgG, this.cgH, this.cgB);
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
    this.cgG = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.cgH = paramJSONObject;
      if (this.cgA != 0) {
        BK();
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