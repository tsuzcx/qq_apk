package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String cDd = "ts";
  public static String cDe = "times";
  public static String cDf = "mfreq";
  public static String cDg = "mdays";
  long cCZ;
  int cDa;
  int cDb;
  int cDc;
  
  a()
  {
    this.cCZ = 0L;
    this.cDa = 0;
    this.cDb = 100;
    this.cDc = 3;
  }
  
  a(String paramString)
  {
    AppMethodBeat.i(87622);
    this.cCZ = 0L;
    this.cDa = 0;
    this.cDb = 100;
    this.cDc = 3;
    if (!s.jdMethod_do(paramString))
    {
      AppMethodBeat.o(87622);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull(cDd)) {
        this.cCZ = paramString.getLong(cDd);
      }
      if (!paramString.isNull(cDf)) {
        this.cDb = paramString.getInt(cDf);
      }
      if (!paramString.isNull(cDe)) {
        this.cDa = paramString.getInt(cDe);
      }
      if (!paramString.isNull(cDg))
      {
        this.cDc = paramString.getInt(cDg);
        AppMethodBeat.o(87622);
        return;
      }
    }
    catch (JSONException paramString)
    {
      s.Il();
      AppMethodBeat.o(87622);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87623);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(cDd, this.cCZ);
      ((JSONObject)localObject).put(cDe, this.cDa);
      ((JSONObject)localObject).put(cDf, this.cDb);
      ((JSONObject)localObject).put(cDg, this.cDc);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(87623);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.Il();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */