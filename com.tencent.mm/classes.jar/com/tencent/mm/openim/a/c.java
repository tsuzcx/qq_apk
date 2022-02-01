package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public List<a> iHw;
  
  public c()
  {
    AppMethodBeat.i(120689);
    this.iHw = new LinkedList();
    AppMethodBeat.o(120689);
  }
  
  public final c IE(String paramString)
  {
    AppMethodBeat.i(120690);
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("custom_info");
      if (paramString == null)
      {
        AppMethodBeat.o(120690);
        return this;
      }
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        a locala = new a();
        this.iHw.add(locala.s(localJSONObject));
        i += 1;
      }
      return this;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.OpenIMCustomDetail", paramString, "parse", new Object[0]);
      AppMethodBeat.o(120690);
    }
  }
  
  public static final class a
  {
    public List<c.b> iHx;
    public String title;
    
    public a()
    {
      AppMethodBeat.i(120686);
      this.title = "";
      this.iHx = new LinkedList();
      AppMethodBeat.o(120686);
    }
    
    final a s(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(120687);
      this.title = paramJSONObject.optString("title", "");
      paramJSONObject = paramJSONObject.optJSONArray("detail");
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(120687);
        return this;
      }
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        c.b localb = new c.b();
        List localList = this.iHx;
        localb.dDH = localJSONObject.optString("icon");
        localb.desc = localJSONObject.optString("desc");
        localb.iHy = localJSONObject.optInt("desc_type");
        localb.action = localJSONObject.optInt("action");
        localb.iHz = localJSONObject.optString("action_param");
        localList.add(localb);
        i += 1;
      }
      AppMethodBeat.o(120687);
      return this;
    }
  }
  
  public static final class b
  {
    public int action;
    public String dDH;
    String desc;
    public int iHy;
    public String iHz;
    
    public final String IF(String paramString)
    {
      AppMethodBeat.i(120688);
      if (this.iHy == 1)
      {
        paramString = ((b)g.ab(b.class)).bC(paramString, this.desc);
        AppMethodBeat.o(120688);
        return paramString;
      }
      paramString = this.desc;
      AppMethodBeat.o(120688);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.a.c
 * JD-Core Version:    0.7.0.1
 */