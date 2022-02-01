package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String bZM = null;
  String cPk = null;
  String cPl = "0";
  long cPm = 0L;
  
  private JSONObject JL()
  {
    AppMethodBeat.i(87660);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.bZM);
      s.a(localJSONObject, "mc", this.cPk);
      s.a(localJSONObject, "mid", this.cPl);
      localJSONObject.put("ts", this.cPm);
      AppMethodBeat.o(87660);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.JT();
      }
    }
  }
  
  static g eo(String paramString)
  {
    AppMethodBeat.i(87657);
    g localg = new g();
    if (s.ep(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.bZM = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.cPk = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.cPl = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.cPm = paramString.getLong("ts");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        s.JT();
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
    if ((s.eq(this.cPl)) && (s.eq(paramg.cPl)))
    {
      if (this.cPl.equals(paramg.cPl))
      {
        AppMethodBeat.o(87658);
        return 0;
      }
      if (this.cPm >= paramg.cPm)
      {
        AppMethodBeat.o(87658);
        return 1;
      }
      AppMethodBeat.o(87658);
      return -1;
    }
    if (s.eq(this.cPl))
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
    String str = JL().toString();
    AppMethodBeat.o(87659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */