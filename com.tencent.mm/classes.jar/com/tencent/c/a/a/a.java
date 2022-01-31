package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String bUm = "ts";
  public static String bUn = "times";
  public static String bUo = "mfreq";
  public static String bUp = "mdays";
  long bUi;
  int bUj;
  int bUk;
  int bUl;
  
  a()
  {
    this.bUi = 0L;
    this.bUj = 0;
    this.bUk = 100;
    this.bUl = 3;
  }
  
  a(String paramString)
  {
    AppMethodBeat.i(125740);
    this.bUi = 0L;
    this.bUj = 0;
    this.bUk = 100;
    this.bUl = 3;
    if (!s.cI(paramString))
    {
      AppMethodBeat.o(125740);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull(bUm)) {
        this.bUi = paramString.getLong(bUm);
      }
      if (!paramString.isNull(bUo)) {
        this.bUk = paramString.getInt(bUo);
      }
      if (!paramString.isNull(bUn)) {
        this.bUj = paramString.getInt(bUn);
      }
      if (!paramString.isNull(bUp))
      {
        this.bUl = paramString.getInt(bUp);
        AppMethodBeat.o(125740);
        return;
      }
    }
    catch (JSONException paramString)
    {
      s.zV();
      AppMethodBeat.o(125740);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(125741);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(bUm, this.bUi);
      ((JSONObject)localObject).put(bUn, this.bUj);
      ((JSONObject)localObject).put(bUo, this.bUk);
      ((JSONObject)localObject).put(bUp, this.bUl);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(125741);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.zV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */