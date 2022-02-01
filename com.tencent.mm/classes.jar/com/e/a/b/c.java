package com.e.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.k.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends a
{
  final a bYO;
  final boolean bYP;
  public final Map<String, Object> map;
  
  public c(Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(153401);
    this.bYO = new a();
    this.map = paramMap;
    this.bYP = paramBoolean;
    AppMethodBeat.o(153401);
  }
  
  private Map<String, Object> AB()
  {
    AppMethodBeat.i(153403);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", this.bYO.result);
    AppMethodBeat.o(153403);
    return localHashMap;
  }
  
  private Map<String, Object> AC()
  {
    AppMethodBeat.i(153404);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("code", this.bYO.errorCode);
    localHashMap2.put("message", this.bYO.errorMessage);
    localHashMap2.put("data", this.bYO.bYQ);
    localHashMap1.put("error", localHashMap2);
    AppMethodBeat.o(153404);
    return localHashMap1;
  }
  
  public final boolean AA()
  {
    return this.bYP;
  }
  
  public final g Ay()
  {
    return this.bYO;
  }
  
  public final void H(List<Map<String, Object>> paramList)
  {
    AppMethodBeat.i(153406);
    if (!this.bYP) {
      paramList.add(AB());
    }
    AppMethodBeat.o(153406);
  }
  
  public final void I(List<Map<String, Object>> paramList)
  {
    AppMethodBeat.i(153407);
    if (!this.bYP) {
      paramList.add(AC());
    }
    AppMethodBeat.o(153407);
  }
  
  public final void a(k.d paramd)
  {
    AppMethodBeat.i(153405);
    paramd.a(this.bYO.errorCode, this.bYO.errorMessage, this.bYO.bYQ);
    AppMethodBeat.o(153405);
  }
  
  public final <T> T bK(String paramString)
  {
    AppMethodBeat.i(153402);
    paramString = this.map.get(paramString);
    AppMethodBeat.o(153402);
    return paramString;
  }
  
  public final class a
    implements g
  {
    Object bYQ;
    String errorCode;
    String errorMessage;
    Object result;
    
    public a() {}
    
    public final void a(String paramString1, String paramString2, Object paramObject)
    {
      this.errorCode = paramString1;
      this.errorMessage = paramString2;
      this.bYQ = paramObject;
    }
    
    public final void ay(Object paramObject)
    {
      this.result = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.b.c
 * JD-Core Version:    0.7.0.1
 */