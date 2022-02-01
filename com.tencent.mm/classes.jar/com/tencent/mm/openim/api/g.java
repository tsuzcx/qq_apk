package com.tencent.mm.openim.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public List<a> aYV;
  
  public g()
  {
    AppMethodBeat.i(120689);
    this.aYV = new LinkedList();
    AppMethodBeat.o(120689);
  }
  
  public final g RH(String paramString)
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
        this.aYV.add(locala.L(localJSONObject));
        i += 1;
      }
      return this;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.OpenIMCustomDetail", paramString, "parse", new Object[0]);
      AppMethodBeat.o(120690);
    }
  }
  
  public static final class a
  {
    public List<g.b> pre;
    public String title;
    
    public a()
    {
      AppMethodBeat.i(120686);
      this.title = "";
      this.pre = new LinkedList();
      AppMethodBeat.o(120686);
    }
    
    final a L(JSONObject paramJSONObject)
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
        g.b localb = new g.b();
        List localList = this.pre;
        localb.icon = localJSONObject.optString("icon");
        localb.desc = localJSONObject.optString("desc");
        localb.prf = localJSONObject.optInt("desc_type");
        localb.action = localJSONObject.optInt("action");
        localb.prg = localJSONObject.optString("action_param");
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
    public String desc;
    public String icon;
    public int prf;
    public String prg;
    
    public final String RI(String paramString)
    {
      AppMethodBeat.i(120688);
      if (this.prf == 1)
      {
        paramString = ((e)h.ax(e.class)).cc(paramString, this.desc);
        AppMethodBeat.o(120688);
        return paramString;
      }
      paramString = this.desc;
      AppMethodBeat.o(120688);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.api.g
 * JD-Core Version:    0.7.0.1
 */