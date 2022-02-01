package com.tencent.mm.plugin.appbrand.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected a jIj;
  protected String jIk;
  protected String jIl;
  protected Map<String, String> jIm = new HashMap();
  protected String mUrl;
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.jIl = paramString2;
    this.jIk = bbB();
    this.jIj = a.jIo;
  }
  
  protected final void a(a parama)
  {
    this.jIj = parama;
  }
  
  public abstract String bbB();
  
  protected final void bbD()
  {
    cC("Content-Type", "text/xml;charset=\"utf-8\"");
    cC("Connection", "close");
  }
  
  public final a bbE()
  {
    return this.jIj;
  }
  
  public final Map<String, String> bbF()
  {
    return this.jIm;
  }
  
  public final void cC(String paramString1, String paramString2)
  {
    this.jIm.put(paramString1, paramString2);
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
      jIn = new a("GET", 0, "GET");
      jIo = new a("POST", 1, "POST");
      jIp = new a("NOTIFY", 2, "NOTIFY");
      jIq = new a("M_SEARCH", 3, "M-SEARCH");
      jIr = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      jIs = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      jIt = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      jIu = new a("UNKNOWN", 7, "UNKNOWN");
      jIv = new a[] { jIn, jIo, jIp, jIq, jIr, jIs, jIt, jIu };
      AppMethodBeat.o(158886);
    }
    
    private a(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a.e
 * JD-Core Version:    0.7.0.1
 */