package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String cOi = "ts";
  public static String cOj = "times";
  public static String cOk = "mfreq";
  public static String cOl = "mdays";
  long cOe;
  int cOf;
  int cOg;
  int cOh;
  
  a()
  {
    this.cOe = 0L;
    this.cOf = 0;
    this.cOg = 100;
    this.cOh = 3;
  }
  
  a(String paramString)
  {
    AppMethodBeat.i(87622);
    this.cOe = 0L;
    this.cOf = 0;
    this.cOg = 100;
    this.cOh = 3;
    if (!s.ek(paramString))
    {
      AppMethodBeat.o(87622);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull(cOi)) {
        this.cOe = paramString.getLong(cOi);
      }
      if (!paramString.isNull(cOk)) {
        this.cOg = paramString.getInt(cOk);
      }
      if (!paramString.isNull(cOj)) {
        this.cOf = paramString.getInt(cOj);
      }
      if (!paramString.isNull(cOl))
      {
        this.cOh = paramString.getInt(cOl);
        AppMethodBeat.o(87622);
        return;
      }
    }
    catch (JSONException paramString)
    {
      s.JL();
      AppMethodBeat.o(87622);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87623);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(cOi, this.cOe);
      ((JSONObject)localObject).put(cOj, this.cOf);
      ((JSONObject)localObject).put(cOk, this.cOg);
      ((JSONObject)localObject).put(cOl, this.cOh);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(87623);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.JL();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */