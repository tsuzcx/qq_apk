package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ls
  extends a
{
  private String eJx = "";
  private String eWb = "";
  private long eXc;
  private long eYW;
  private a eZu;
  private String eZv = "";
  private long eZw;
  private b eZx;
  private long eZy;
  private long eZz;
  private long erW;
  private String exq = "";
  
  public final ls a(a parama)
  {
    this.eZu = parama;
    return this;
  }
  
  public final ls a(b paramb)
  {
    this.eZx = paramb;
    return this;
  }
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.eZu != null) {}
    for (int i = this.eZu.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZw);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eZx != null) {
        i = this.eZx.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eWb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZz);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eZu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.eZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.eZw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.eZx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.eZy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.eZz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final int getId()
  {
    return 19280;
  }
  
  public final ls vh(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final ls vi(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final ls vj(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final ls vk(long paramLong)
  {
    this.eZz = paramLong;
    return this;
  }
  
  public final ls za(String paramString)
  {
    AppMethodBeat.i(180156);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final ls zb(String paramString)
  {
    AppMethodBeat.i(180157);
    this.eZv = x("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final ls zc(String paramString)
  {
    AppMethodBeat.i(180158);
    this.exq = x("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final ls zd(String paramString)
  {
    AppMethodBeat.i(180159);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(180152);
      eZA = new a("release", 0, 1);
      eZB = new a("debug", 1, 2);
      eZC = new a("demo", 2, 3);
      eZD = new a[] { eZA, eZB, eZC };
      AppMethodBeat.o(180152);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a md(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eZA;
      case 2: 
        return eZB;
      }
      return eZC;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(180155);
      eZE = new b("release", 0, 1);
      eZF = new b("debug", 1, 2);
      eZG = new b("demo", 2, 3);
      eZH = new b[] { eZE, eZF, eZG };
      AppMethodBeat.o(180155);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ls
 * JD-Core Version:    0.7.0.1
 */