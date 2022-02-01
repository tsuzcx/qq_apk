package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected a ljv;
  protected String ljw;
  protected String ljx;
  protected Map<String, String> ljy = new HashMap();
  protected String mUrl;
  
  public e(String paramString1, String paramString2)
  {
    this.mUrl = paramString1;
    this.ljx = paramString2;
    this.ljw = bBg();
    this.ljv = a.ljA;
  }
  
  protected final void a(a parama)
  {
    this.ljv = parama;
  }
  
  public abstract String bBg();
  
  protected final void bBi()
  {
    cV("Content-Type", "text/xml;charset=\"utf-8\"");
    cV("Connection", "close");
  }
  
  public final a bBj()
  {
    return this.ljv;
  }
  
  public final Map<String, String> bBk()
  {
    return this.ljy;
  }
  
  public final void cV(String paramString1, String paramString2)
  {
    this.ljy.put(paramString1, paramString2);
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
      ljz = new a("GET", 0, "GET");
      ljA = new a("POST", 1, "POST");
      ljB = new a("NOTIFY", 2, "NOTIFY");
      ljC = new a("M_SEARCH", 3, "M-SEARCH");
      ljD = new a("SUBSCRIBE", 4, "SUBSCRIBE");
      ljE = new a("UNSUBSCRIBE", 5, "UNSUBSCRIBE");
      ljF = new a("RENEW_SUBSCRIBE", 6, "SUBSCRIBE");
      ljG = new a("UNKNOWN", 7, "UNKNOWN");
      ljH = new a[] { ljz, ljA, ljB, ljC, ljD, ljE, ljF, ljG };
      AppMethodBeat.o(158886);
    }
    
    private a(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a.e
 * JD-Core Version:    0.7.0.1
 */