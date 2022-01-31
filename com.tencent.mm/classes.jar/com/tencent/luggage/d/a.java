package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public abstract class a<CONTEXT extends b>
{
  CONTEXT byD;
  
  public abstract void a(a<CONTEXT>.a parama);
  
  public abstract String name();
  
  public final class a
  {
    public CONTEXT byE;
    public k byF;
    
    public a() {}
    
    public final void a(String paramString, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(90769);
      this.byF.a(paramString, paramJSONObject);
      AppMethodBeat.o(90769);
    }
    
    public final void c(String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(90768);
      k localk = this.byF;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localk.byd = str;
      if (paramMap != null) {}
      for (paramString = new JSONObject(paramMap);; paramString = null)
      {
        localk.bye = paramString;
        if (localk.bxX != 0) {
          localk.tU();
        }
        AppMethodBeat.o(90768);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */