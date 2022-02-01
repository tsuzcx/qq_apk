package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public abstract class b<CONTEXT extends c>
{
  CONTEXT crf;
  
  public abstract void a(b<CONTEXT>.a paramb);
  
  public abstract String name();
  
  public final class a
  {
    public CONTEXT crg;
    public k crh;
    
    public a() {}
    
    public final JSONObject NN()
    {
      return this.crh.cqn;
    }
    
    public final void NT()
    {
      AppMethodBeat.i(207490);
      a("", null);
      AppMethodBeat.o(207490);
    }
    
    public final void a(String paramString, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(140370);
      this.crh.a(paramString, paramJSONObject);
      AppMethodBeat.o(140370);
    }
    
    public final void d(String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140369);
      k localk = this.crh;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localk.cqG = str;
      if (paramMap != null) {}
      for (paramString = new JSONObject(paramMap);; paramString = null)
      {
        localk.cqH = paramString;
        if (localk.cqA != 0) {
          localk.callback();
        }
        AppMethodBeat.o(140369);
        return;
      }
    }
    
    public final void dr(String paramString)
    {
      AppMethodBeat.i(293003);
      a(paramString, null);
      AppMethodBeat.o(293003);
    }
    
    public final void e(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(207495);
      a("", paramJSONObject);
      AppMethodBeat.o(207495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */