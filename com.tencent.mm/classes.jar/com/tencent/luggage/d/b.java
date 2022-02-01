package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public abstract class b<CONTEXT extends c>
{
  CONTEXT csZ;
  
  public abstract void a(b<CONTEXT>.a paramb);
  
  public abstract String name();
  
  public final class a
  {
    public CONTEXT cta;
    public k ctb;
    
    public a() {}
    
    public final void c(String paramString, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(140370);
      this.ctb.c(paramString, paramJSONObject);
      AppMethodBeat.o(140370);
    }
    
    public final void e(String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140369);
      k localk = this.ctb;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localk.csB = str;
      if (paramMap != null) {}
      for (paramString = new JSONObject(paramMap);; paramString = null)
      {
        localk.csC = paramString;
        if (localk.csv != 0) {
          localk.callback();
        }
        AppMethodBeat.o(140369);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */