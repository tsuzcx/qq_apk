package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String cOS = "ts";
  public static String cOT = "times";
  public static String cOU = "mfreq";
  public static String cOV = "mdays";
  long cOO;
  int cOP;
  int cOQ;
  int cOR;
  
  a()
  {
    this.cOO = 0L;
    this.cOP = 0;
    this.cOQ = 100;
    this.cOR = 3;
  }
  
  a(String paramString)
  {
    AppMethodBeat.i(87622);
    this.cOO = 0L;
    this.cOP = 0;
    this.cOQ = 100;
    this.cOR = 3;
    if (!s.ep(paramString))
    {
      AppMethodBeat.o(87622);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull(cOS)) {
        this.cOO = paramString.getLong(cOS);
      }
      if (!paramString.isNull(cOU)) {
        this.cOQ = paramString.getInt(cOU);
      }
      if (!paramString.isNull(cOT)) {
        this.cOP = paramString.getInt(cOT);
      }
      if (!paramString.isNull(cOV))
      {
        this.cOR = paramString.getInt(cOV);
        AppMethodBeat.o(87622);
        return;
      }
    }
    catch (JSONException paramString)
    {
      s.JT();
      AppMethodBeat.o(87622);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87623);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(cOS, this.cOO);
      ((JSONObject)localObject).put(cOT, this.cOP);
      ((JSONObject)localObject).put(cOU, this.cOQ);
      ((JSONObject)localObject).put(cOV, this.cOR);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(87623);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.JT();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */