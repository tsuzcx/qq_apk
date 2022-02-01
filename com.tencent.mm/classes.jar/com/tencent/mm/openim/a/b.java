package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public List<a> mxJ;
  
  public b()
  {
    AppMethodBeat.i(120689);
    this.mxJ = new LinkedList();
    AppMethodBeat.o(120689);
  }
  
  public final b ZC(String paramString)
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
        this.mxJ.add(locala.B(localJSONObject));
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
    public List<b.b> mya;
    public String title;
    
    public a()
    {
      AppMethodBeat.i(120686);
      this.title = "";
      this.mya = new LinkedList();
      AppMethodBeat.o(120686);
    }
    
    final a B(JSONObject paramJSONObject)
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
        b.b localb = new b.b();
        List localList = this.mya;
        localb.icon = localJSONObject.optString("icon");
        localb.desc = localJSONObject.optString("desc");
        localb.myb = localJSONObject.optInt("desc_type");
        localb.action = localJSONObject.optInt("action");
        localb.myc = localJSONObject.optString("action_param");
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
    String desc;
    public String icon;
    public int myb;
    public String myc;
    
    public final String ZD(String paramString)
    {
      AppMethodBeat.i(120688);
      if (this.myb == 1)
      {
        paramString = ((a)h.ae(a.class)).bR(paramString, this.desc);
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
 * Qualified Name:     com.tencent.mm.openim.a.b
 * JD-Core Version:    0.7.0.1
 */