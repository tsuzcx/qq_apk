package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected a kfM;
  protected String kfN;
  protected String kfO;
  protected Map<String, String> kfP = new HashMap();
  protected String mUrl;
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.kfO = paramString2;
    this.kfN = bfN();
    this.kfM = a.kfR;
  }
  
  protected final void a(a parama)
  {
    this.kfM = parama;
  }
  
  public abstract String bfN();
  
  protected final void bfP()
  {
    cG("Content-Type", "text/xml;charset=\"utf-8\"");
    cG("Connection", "close");
  }
  
  public final a bfQ()
  {
    return this.kfM;
  }
  
  public final Map<String, String> bfR()
  {
    return this.kfP;
  }
  
  public final void cG(String paramString1, String paramString2)
  {
    this.kfP.put(paramString1, paramString2);
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
      kfQ = new a("GET", 0, "GET");
      kfR = new a("POST", 1, "POST");
      kfS = new a("NOTIFY", 2, "NOTIFY");
      kfT = new a("M_SEARCH", 3, "M-SEARCH");
      kfU = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      kfV = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      kfW = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      kfX = new a("UNKNOWN", 7, "UNKNOWN");
      kfY = new a[] { kfQ, kfR, kfS, kfT, kfU, kfV, kfW, kfX };
      AppMethodBeat.o(158886);
    }
    
    private a(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.e
 * JD-Core Version:    0.7.0.1
 */