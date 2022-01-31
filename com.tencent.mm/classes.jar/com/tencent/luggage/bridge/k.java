package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  public JSONObject bxK;
  String bxW;
  public int bxX;
  private boolean bxY;
  private f byb;
  boolean byc;
  public String byd;
  public JSONObject bye;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(90725);
    this.byb = paramf;
    paramf = paramm.tS();
    this.bxW = paramf.getString("method");
    this.bxK = paramf.optJSONObject("data");
    if (this.bxK == null) {
      this.bxK = new JSONObject("{}");
    }
    this.byc = paramBoolean;
    this.bxX = paramf.optInt("callbackId", 0);
    this.bxY = false;
    this.bye = new JSONObject();
    AppMethodBeat.o(90725);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90726);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.byd = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.bye = paramJSONObject;
      if (this.bxX != 0) {
        tU();
      }
      AppMethodBeat.o(90726);
      return;
      paramJSONObject = new JSONObject();
    }
  }
  
  public final void tU()
  {
    AppMethodBeat.i(90727);
    this.byb.a(tV());
    AppMethodBeat.o(90727);
  }
  
  final e tV()
  {
    AppMethodBeat.i(90728);
    c localc = new c(this.bxX, this.byd, this.bye, this.bxY);
    AppMethodBeat.o(90728);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.k
 * JD-Core Version:    0.7.0.1
 */