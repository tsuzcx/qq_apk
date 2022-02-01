package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected String mUrl;
  protected a oee;
  protected String oef;
  protected String oeg;
  protected Map<String, String> oeh = new HashMap();
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.oeg = paramString2;
    this.oef = bMB();
    this.oee = a.oej;
  }
  
  protected final void a(a parama)
  {
    this.oee = parama;
  }
  
  public abstract String bMB();
  
  protected final void bMD()
  {
    de("Content-Type", "text/xml;charset=\"utf-8\"");
    de("Connection", "close");
  }
  
  public final a bME()
  {
    return this.oee;
  }
  
  public final Map<String, String> bMF()
  {
    return this.oeh;
  }
  
  public final void de(String paramString1, String paramString2)
  {
    this.oeh.put(paramString1, paramString2);
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
      oei = new a("GET", 0, "GET");
      oej = new a("POST", 1, "POST");
      oek = new a("NOTIFY", 2, "NOTIFY");
      oel = new a("M_SEARCH", 3, "M-SEARCH");
      oem = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      oen = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      oeo = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      oep = new a("UNKNOWN", 7, "UNKNOWN");
      oeq = new a[] { oei, oej, oek, oel, oem, oen, oeo, oep };
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