package com.tencent.mm.plugin.appbrand.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected a jhU;
  protected String jhV;
  protected String jhW;
  protected Map<String, String> jhX = new HashMap();
  protected String mUrl;
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.jhW = paramString2;
    this.jhV = aUD();
    this.jhU = a.jhZ;
  }
  
  protected final void a(a parama)
  {
    this.jhU = parama;
  }
  
  public abstract String aUD();
  
  protected final void aUF()
  {
    cs("Content-Type", "text/xml;charset=\"utf-8\"");
    cs("Connection", "close");
  }
  
  public final a aUG()
  {
    return this.jhU;
  }
  
  public final Map<String, String> aUH()
  {
    return this.jhX;
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    this.jhX.put(paramString1, paramString2);
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
      jhY = new a("GET", 0, "GET");
      jhZ = new a("POST", 1, "POST");
      jia = new a("NOTIFY", 2, "NOTIFY");
      jib = new a("M_SEARCH", 3, "M-SEARCH");
      jic = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      jid = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      jie = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      jif = new a("UNKNOWN", 7, "UNKNOWN");
      jig = new a[] { jhY, jhZ, jia, jib, jic, jid, jie, jif };
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