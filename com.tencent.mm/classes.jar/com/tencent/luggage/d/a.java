package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public abstract class a<CONTEXT extends b>
{
  CONTEXT bWQ;
  
  public abstract void a(a<CONTEXT>.a parama);
  
  public abstract String name();
  
  public final class a
  {
    public CONTEXT bWR;
    public k bWS;
    
    public a() {}
    
    public final void a(String paramString, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(140370);
      this.bWS.a(paramString, paramJSONObject);
      AppMethodBeat.o(140370);
    }
    
    public final void c(String paramString, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140369);
      k localk = this.bWS;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localk.bWr = str;
      if (paramMap != null) {}
      for (paramString = new JSONObject(paramMap);; paramString = null)
      {
        localk.bWs = paramString;
        if (localk.bWl != 0) {
          localk.Am();
        }
        AppMethodBeat.o(140369);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */