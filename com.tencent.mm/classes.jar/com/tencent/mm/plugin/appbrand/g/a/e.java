package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected a kcv;
  protected String kcw;
  protected String kcx;
  protected Map<String, String> kcy = new HashMap();
  protected String mUrl;
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.kcx = paramString2;
    this.kcw = bff();
    this.kcv = a.kcA;
  }
  
  protected final void a(a parama)
  {
    this.kcv = parama;
  }
  
  public abstract String bff();
  
  protected final void bfh()
  {
    cE("Content-Type", "text/xml;charset=\"utf-8\"");
    cE("Connection", "close");
  }
  
  public final a bfi()
  {
    return this.kcv;
  }
  
  public final Map<String, String> bfj()
  {
    return this.kcy;
  }
  
  public final void cE(String paramString1, String paramString2)
  {
    this.kcy.put(paramString1, paramString2);
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
      kcz = new a("GET", 0, "GET");
      kcA = new a("POST", 1, "POST");
      kcB = new a("NOTIFY", 2, "NOTIFY");
      kcC = new a("M_SEARCH", 3, "M-SEARCH");
      kcD = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      kcE = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      kcF = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      kcG = new a("UNKNOWN", 7, "UNKNOWN");
      kcH = new a[] { kcz, kcA, kcB, kcC, kcD, kcE, kcF, kcG };
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