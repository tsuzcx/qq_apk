package com.i.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends a
{
  final a edi;
  final boolean edj;
  public final Map<String, Object> map;
  
  public c(Map<String, Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(153401);
    this.edi = new a();
    this.map = paramMap;
    this.edj = paramBoolean;
    AppMethodBeat.o(153401);
  }
  
  private Map<String, Object> alA()
  {
    AppMethodBeat.i(153403);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", this.edi.result);
    AppMethodBeat.o(153403);
    return localHashMap;
  }
  
  private Map<String, Object> alB()
  {
    AppMethodBeat.i(153404);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("code", this.edi.cBH);
    localHashMap2.put("message", this.edi.cBF);
    localHashMap2.put("data", this.edi.edk);
    localHashMap1.put("error", localHashMap2);
    AppMethodBeat.o(153404);
    return localHashMap1;
  }
  
  public final void a(MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(153405);
    paramResult.error(this.edi.cBH, this.edi.cBF, this.edi.edk);
    AppMethodBeat.o(153405);
  }
  
  public final void aX(List<Map<String, Object>> paramList)
  {
    AppMethodBeat.i(153406);
    if (!this.edj) {
      paramList.add(alA());
    }
    AppMethodBeat.o(153406);
  }
  
  public final void aY(List<Map<String, Object>> paramList)
  {
    AppMethodBeat.i(153407);
    if (!this.edj) {
      paramList.add(alB());
    }
    AppMethodBeat.o(153407);
  }
  
  public final g alw()
  {
    return this.edi;
  }
  
  public final boolean alz()
  {
    return this.edj;
  }
  
  public final <T> T er(String paramString)
  {
    AppMethodBeat.i(153402);
    paramString = this.map.get(paramString);
    AppMethodBeat.o(153402);
    return paramString;
  }
  
  public final class a
    implements g
  {
    String cBF;
    String cBH;
    Object edk;
    Object result;
    
    public a() {}
    
    public final void error(String paramString1, String paramString2, Object paramObject)
    {
      this.cBH = paramString1;
      this.cBF = paramString2;
      this.edk = paramObject;
    }
    
    public final void success(Object paramObject)
    {
      this.result = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.b.c
 * JD-Core Version:    0.7.0.1
 */