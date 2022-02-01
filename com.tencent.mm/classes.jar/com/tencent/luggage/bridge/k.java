package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  public int cqA;
  private boolean cqB;
  private f cqE;
  boolean cqF;
  public String cqG;
  public JSONObject cqH;
  public JSONObject cqn;
  String cqz;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140325);
    this.cqE = paramf;
    paramf = paramm.NN();
    this.cqz = paramf.getString("method");
    this.cqn = paramf.optJSONObject("data");
    if (this.cqn == null) {
      this.cqn = new JSONObject("{}");
    }
    this.cqF = paramBoolean;
    this.cqA = paramf.optInt("callbackId", 0);
    this.cqB = false;
    this.cqH = new JSONObject();
    AppMethodBeat.o(140325);
  }
  
  final e NP()
  {
    AppMethodBeat.i(140328);
    c localc = new c(this.cqA, this.cqG, this.cqH, this.cqB);
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
    this.cqG = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.cqH = paramJSONObject;
      if (this.cqA != 0) {
        callback();
      }
      AppMethodBeat.o(140326);
      return;
      paramJSONObject = new JSONObject();
    }
  }
  
  public final void callback()
  {
    AppMethodBeat.i(140327);
    this.cqE.a(NP());
    AppMethodBeat.o(140327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.k
 * JD-Core Version:    0.7.0.1
 */