package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k
{
  public JSONObject eiA;
  public JSONObject eif;
  String eir;
  public int eit;
  private boolean eiu;
  private f eix;
  boolean eiy;
  public String eiz;
  
  k(f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140325);
    this.eix = paramf;
    paramf = paramm.anZ();
    this.eir = paramf.getString("method");
    this.eif = paramf.optJSONObject("data");
    if (this.eif == null) {
      this.eif = new JSONObject("{}");
    }
    this.eiy = paramBoolean;
    this.eit = paramf.optInt("callbackId", 0);
    this.eiu = false;
    this.eiA = new JSONObject();
    AppMethodBeat.o(140325);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140326);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.eiz = str;
    if (paramJSONObject != null) {}
    for (;;)
    {
      this.eiA = paramJSONObject;
      if (this.eit != 0) {
        callback();
      }
      AppMethodBeat.o(140326);
      return;
      paramJSONObject = new JSONObject();
    }
  }
  
  final e aoa()
  {
    AppMethodBeat.i(140328);
    c localc = new c(this.eit, this.eiz, this.eiA, this.eiu);
    AppMethodBeat.o(140328);
    return localc;
  }
  
  public final void callback()
  {
    AppMethodBeat.i(140327);
    this.eix.a(aoa());
    AppMethodBeat.o(140327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.k
 * JD-Core Version:    0.7.0.1
 */