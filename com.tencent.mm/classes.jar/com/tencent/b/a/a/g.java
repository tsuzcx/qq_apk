package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String bPz = null;
  String cDv = null;
  String cDw = "0";
  long cDx = 0L;
  
  private JSONObject Id()
  {
    AppMethodBeat.i(87660);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.bPz);
      s.a(localJSONObject, "mc", this.cDv);
      s.a(localJSONObject, "mid", this.cDw);
      localJSONObject.put("ts", this.cDx);
      AppMethodBeat.o(87660);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.Il();
      }
    }
  }
  
  static g dn(String paramString)
  {
    AppMethodBeat.i(87657);
    g localg = new g();
    if (s.jdMethod_do(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.bPz = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.cDv = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.cDw = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.cDx = paramString.getLong("ts");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        s.Il();
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
    if ((s.dp(this.cDw)) && (s.dp(paramg.cDw)))
    {
      if (this.cDw.equals(paramg.cDw))
      {
        AppMethodBeat.o(87658);
        return 0;
      }
      if (this.cDx >= paramg.cDx)
      {
        AppMethodBeat.o(87658);
        return 1;
      }
      AppMethodBeat.o(87658);
      return -1;
    }
    if (s.dp(this.cDw))
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
    String str = Id().toString();
    AppMethodBeat.o(87659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */