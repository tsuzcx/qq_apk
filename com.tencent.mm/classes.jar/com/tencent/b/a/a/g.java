package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String bRR = null;
  String cGn = null;
  String cGo = "0";
  long cGp = 0L;
  
  private JSONObject Iu()
  {
    AppMethodBeat.i(87660);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.bRR);
      s.a(localJSONObject, "mc", this.cGn);
      s.a(localJSONObject, "mid", this.cGo);
      localJSONObject.put("ts", this.cGp);
      AppMethodBeat.o(87660);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.IC();
      }
    }
  }
  
  static g dy(String paramString)
  {
    AppMethodBeat.i(87657);
    g localg = new g();
    if (s.dz(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.bRR = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.cGn = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.cGo = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.cGp = paramString.getLong("ts");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        s.IC();
      }
    }
    AppMethodBeat.o(87657);
    return localg;
  }
  
  final int a(g paramg)
  {
    AppMethodBeat.i(87658);
    if (paramg == null)
    {
      AppMethodBeat.o(87658);
      return 1;
    }
    if ((s.dA(this.cGo)) && (s.dA(paramg.cGo)))
    {
      if (this.cGo.equals(paramg.cGo))
      {
        AppMethodBeat.o(87658);
        return 0;
      }
      if (this.cGp >= paramg.cGp)
      {
        AppMethodBeat.o(87658);
        return 1;
      }
      AppMethodBeat.o(87658);
      return -1;
    }
    if (s.dA(this.cGo))
    {
      AppMethodBeat.o(87658);
      return 1;
    }
    AppMethodBeat.o(87658);
    return -1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87659);
    String str = Iu().toString();
    AppMethodBeat.o(87659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */