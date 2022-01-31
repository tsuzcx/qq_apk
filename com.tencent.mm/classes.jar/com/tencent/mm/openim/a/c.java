package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public List<c.a> gfG;
  
  public c()
  {
    AppMethodBeat.i(128608);
    this.gfG = new LinkedList();
    AppMethodBeat.o(128608);
  }
  
  public final c wl(String paramString)
  {
    AppMethodBeat.i(128609);
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("custom_info");
      if (paramString == null)
      {
        AppMethodBeat.o(128609);
        return this;
      }
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        c.a locala = new c.a();
        this.gfG.add(locala.n(localJSONObject));
        i += 1;
      }
      return this;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.OpenIMCustomDetail", paramString, "parse", new Object[0]);
      AppMethodBeat.o(128609);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.a.c
 * JD-Core Version:    0.7.0.1
 */