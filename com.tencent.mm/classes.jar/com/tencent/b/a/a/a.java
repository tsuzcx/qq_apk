package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String dfr = "ts";
  public static String dfs = "times";
  public static String dft = "mfreq";
  public static String dfu = "mdays";
  long dfn;
  int dfo;
  int dfp;
  int dfq;
  
  a()
  {
    this.dfn = 0L;
    this.dfo = 0;
    this.dfp = 100;
    this.dfq = 3;
  }
  
  a(String paramString)
  {
    AppMethodBeat.i(87622);
    this.dfn = 0L;
    this.dfo = 0;
    this.dfp = 100;
    this.dfq = 3;
    if (!s.eY(paramString))
    {
      AppMethodBeat.o(87622);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull(dfr)) {
        this.dfn = paramString.getLong(dfr);
      }
      if (!paramString.isNull(dft)) {
        this.dfp = paramString.getInt(dft);
      }
      if (!paramString.isNull(dfs)) {
        this.dfo = paramString.getInt(dfs);
      }
      if (!paramString.isNull(dfu))
      {
        this.dfq = paramString.getInt(dfu);
        AppMethodBeat.o(87622);
        return;
      }
    }
    catch (JSONException paramString)
    {
      s.Ug();
      AppMethodBeat.o(87622);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87623);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(dfr, this.dfn);
      ((JSONObject)localObject).put(dfs, this.dfo);
      ((JSONObject)localObject).put(dft, this.dfp);
      ((JSONObject)localObject).put(dfu, this.dfq);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(87623);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.Ug();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */