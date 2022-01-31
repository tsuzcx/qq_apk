package com.tencent.mm.openim.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public List<c.a> ePL = new LinkedList();
  
  public final c oT(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("custom_info");
        if (paramString != null) {
          break label81;
        }
        return this;
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        c.a locala;
        y.printErrStackTrace("MicroMsg.OpenIMCustomDetail", paramString, "parse", new Object[0]);
      }
      if (i < paramString.length())
      {
        localJSONObject = paramString.getJSONObject(i);
        locala = new c.a();
        this.ePL.add(locala.g(localJSONObject));
        i += 1;
      }
      else
      {
        return this;
        label81:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.a.c
 * JD-Core Version:    0.7.0.1
 */