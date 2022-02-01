package com.tencent.mm.plugin.datareport.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public final Object mTarget;
  public final String xgD;
  public final Map<String, Object> xgE;
  public final List<Integer> xgF;
  
  public a(Object paramObject, String paramString, Map<String, Object> paramMap, List<Integer> paramList)
  {
    this.mTarget = paramObject;
    this.xgD = paramString;
    this.xgE = paramMap;
    this.xgF = paramList;
  }
  
  public static a dts()
  {
    AppMethodBeat.i(262888);
    a locala = new a((byte)0);
    AppMethodBeat.o(262888);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(262893);
    String str = "EventData{target=" + this.mTarget + ", eventId='" + this.xgD + '\'' + ", mRouteRule='" + this.xgF + '\'' + ", params=" + this.xgE + '}';
    AppMethodBeat.o(262893);
    return str;
  }
  
  public static final class a
  {
    public Object mTarget;
    public String xgD;
    private Map<String, Object> xgE;
    public List<Integer> xgG;
    
    private a()
    {
      AppMethodBeat.i(262881);
      this.xgE = new HashMap();
      this.xgG = new ArrayList();
      AppMethodBeat.o(262881);
    }
    
    public final a ac(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(262891);
      if ((paramMap != null) && (paramMap.size() > 0)) {
        this.xgE.putAll(paramMap);
      }
      AppMethodBeat.o(262891);
      return this;
    }
    
    public final a dtt()
    {
      AppMethodBeat.i(262897);
      a locala = new a(this.mTarget, this.xgD, this.xgE, this.xgG);
      AppMethodBeat.o(262897);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.a.b.a
 * JD-Core Version:    0.7.0.1
 */