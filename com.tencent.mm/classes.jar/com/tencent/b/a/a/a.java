package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String cFV = "ts";
  public static String cFW = "times";
  public static String cFX = "mfreq";
  public static String cFY = "mdays";
  long cFR;
  int cFS;
  int cFT;
  int cFU;
  
  a()
  {
    this.cFR = 0L;
    this.cFS = 0;
    this.cFT = 100;
    this.cFU = 3;
  }
  
  a(String paramString)
  {
    AppMethodBeat.i(87622);
    this.cFR = 0L;
    this.cFS = 0;
    this.cFT = 100;
    this.cFU = 3;
    if (!s.dz(paramString))
    {
      AppMethodBeat.o(87622);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull(cFV)) {
        this.cFR = paramString.getLong(cFV);
      }
      if (!paramString.isNull(cFX)) {
        this.cFT = paramString.getInt(cFX);
      }
      if (!paramString.isNull(cFW)) {
        this.cFS = paramString.getInt(cFW);
      }
      if (!paramString.isNull(cFY))
      {
        this.cFU = paramString.getInt(cFY);
        AppMethodBeat.o(87622);
        return;
      }
    }
    catch (JSONException paramString)
    {
      s.IC();
      AppMethodBeat.o(87622);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87623);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put(cFV, this.cFR);
      ((JSONObject)localObject).put(cFW, this.cFS);
      ((JSONObject)localObject).put(cFX, this.cFT);
      ((JSONObject)localObject).put(cFY, this.cFU);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(87623);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        s.IC();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */