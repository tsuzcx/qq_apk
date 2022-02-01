package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gs
  extends a
{
  private long dHY;
  private String dZT;
  private long eaM;
  private a ecM;
  private String ecN;
  private long ecO;
  private b ecP;
  private String ecQ;
  private long ecR;
  private long ecS;
  private String ecm;
  private long eco;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ecM != null) {}
    for (int i = this.ecM.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecO);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ecP != null) {
        i = this.ecP.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dZT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecS);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.ecN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.ecO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.ecP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.ecR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.ecS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final gs a(a parama)
  {
    this.ecM = parama;
    return this;
  }
  
  public final gs a(b paramb)
  {
    this.ecP = paramb;
    return this;
  }
  
  public final int getId()
  {
    return 19280;
  }
  
  public final gs lr(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final gs ls(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final gs lt(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final gs lu(long paramLong)
  {
    this.ecS = paramLong;
    return this;
  }
  
  public final gs od(String paramString)
  {
    AppMethodBeat.i(180156);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final gs oe(String paramString)
  {
    AppMethodBeat.i(180157);
    this.ecN = t("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final gs of(String paramString)
  {
    AppMethodBeat.i(180158);
    this.ecQ = t("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final gs og(String paramString)
  {
    AppMethodBeat.i(180159);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(180152);
      ecT = new a("release", 0, 1);
      ecU = new a("debug", 1, 2);
      ecV = new a("demo", 2, 3);
      ecW = new a[] { ecT, ecU, ecV };
      AppMethodBeat.o(180152);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iG(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ecT;
      case 2: 
        return ecU;
      }
      return ecV;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(180155);
      ecX = new b("release", 0, 1);
      ecY = new b("debug", 1, 2);
      ecZ = new b("demo", 2, 3);
      eda = new b[] { ecX, ecY, ecZ };
      AppMethodBeat.o(180155);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gs
 * JD-Core Version:    0.7.0.1
 */