package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String bUD = null;
  String bUE = "0";
  long bUF = 0L;
  String bpw = null;
  
  static g cH(String paramString)
  {
    AppMethodBeat.i(125775);
    g localg = new g();
    if (s.cI(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.bpw = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.bUD = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.bUE = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.bUF = paramString.getLong("ts");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        s.zV();
      }
    }
    AppMethodBeat.o(125775);
    return localg;
  }
  
  private JSONObject zN()
  {
    AppMethodBeat.i(125778);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.bpw);
      s.a(localJSONObject, "mc", this.bUD);
      s.a(localJSONObject, "mid", this.bUE);
      localJSONObject.put("ts", this.bUF);
      AppMethodBeat.o(125778);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.zV();
      }
    }
  }
  
  final int a(g paramg)
  {
    AppMethodBeat.i(125776);
    if (paramg == null)
    {
      AppMethodBeat.o(125776);
      return 1;
    }
    if ((s.cJ(this.bUE)) && (s.cJ(paramg.bUE)))
    {
      if (this.bUE.equals(paramg.bUE))
      {
        AppMethodBeat.o(125776);
        return 0;
      }
      if (this.bUF >= paramg.bUF)
      {
        AppMethodBeat.o(125776);
        return 1;
      }
      AppMethodBeat.o(125776);
      return -1;
    }
    if (s.cJ(this.bUE))
    {
      AppMethodBeat.o(125776);
      return 1;
    }
    AppMethodBeat.o(125776);
    return -1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(125777);
    String str = zN().toString();
    AppMethodBeat.o(125777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */