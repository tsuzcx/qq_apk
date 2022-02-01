package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected String mUrl;
  protected a rhK;
  protected String rhL;
  protected String rhM;
  protected Map<String, String> rhN = new HashMap();
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.rhM = paramString2;
    this.rhL = cmR();
    this.rhK = a.rhP;
  }
  
  protected final void a(a parama)
  {
    this.rhK = parama;
  }
  
  public abstract String cmR();
  
  protected final void cmT()
  {
    dx("Content-Type", "text/xml;charset=\"utf-8\"");
    dx("Connection", "close");
  }
  
  public final a cmU()
  {
    return this.rhK;
  }
  
  public final Map<String, String> cmV()
  {
    return this.rhN;
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    this.rhN.put(paramString1, paramString2);
  }
  
  public final String getUrl()
  {
    return this.mUrl;
  }
  
  public static enum a
  {
    String name;
    
    static
    {
      AppMethodBeat.i(158886);
      rhO = new a("GET", 0, "GET");
      rhP = new a("POST", 1, "POST");
      rhQ = new a("NOTIFY", 2, "NOTIFY");
      rhR = new a("M_SEARCH", 3, "M-SEARCH");
      rhS = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      rhT = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      rhU = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      rhV = new a("UNKNOWN", 7, "UNKNOWN");
      rhW = new a[] { rhO, rhP, rhQ, rhR, rhS, rhT, rhU, rhV };
      AppMethodBeat.o(158886);
    }
    
    private a(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.e
 * JD-Core Version:    0.7.0.1
 */