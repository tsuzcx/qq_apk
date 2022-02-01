package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  public JSONObject bZb;
  String bZn;
  public int bZo;
  private boolean bZp;
  private f bZs;
  boolean bZt;
  public String bZu;
  public JSONObject bZv;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140325);
    this.bZs = paramf;
    paramf = paramm.AG();
    this.bZn = paramf.getString("method");
    this.bZb = paramf.optJSONObject("data");
    if (this.bZb == null) {
      this.bZb = new JSONObject("{}");
    }
    this.bZt = paramBoolean;
    this.bZo = paramf.optInt("callbackId", 0);
    this.bZp = false;
    this.bZv = new JSONObject();
    AppMethodBeat.o(140325);
  }
  
  public final void AI()
  {
    AppMethodBeat.i(140327);
    this.bZs.a(AJ());
    AppMethodBeat.o(140327);
  }
  
  final e AJ()
  {
    AppMethodBeat.i(140328);
    c localc = new c(this.bZo, this.bZu, this.bZv, this.bZp);
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
    this.bZu = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.bZv = paramJSONObject;
      if (this.bZo != 0) {
        AI();
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