package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String bZM = null;
  String cOA = null;
  String cOB = "0";
  long cOC = 0L;
  
  private JSONObject JD()
  {
    AppMethodBeat.i(87660);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.bZM);
      s.a(localJSONObject, "mc", this.cOA);
      s.a(localJSONObject, "mid", this.cOB);
      localJSONObject.put("ts", this.cOC);
      AppMethodBeat.o(87660);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.JL();
      }
    }
  }
  
  static g ej(String paramString)
  {
    AppMethodBeat.i(87657);
    g localg = new g();
    if (s.ek(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.bZM = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.cOA = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.cOB = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.cOC = paramString.getLong("ts");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        s.JL();
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
    if ((s.el(this.cOB)) && (s.el(paramg.cOB)))
    {
      if (this.cOB.equals(paramg.cOB))
      {
        AppMethodBeat.o(87658);
        return 0;
      }
      if (this.cOC >= paramg.cOC)
      {
        AppMethodBeat.o(87658);
        return 1;
      }
      AppMethodBeat.o(87658);
      return -1;
    }
    if (s.el(this.cOB))
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
    String str = JD().toString();
    AppMethodBeat.o(87659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */