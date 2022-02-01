package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hp
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  public long eaM = 0L;
  private String ecQ = "";
  private String ecm = "";
  public long eco = 0L;
  public a egO;
  private String egP = "";
  public long egQ = 0L;
  public long egR = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.egO != null) {}
    for (int i = this.egO.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dZT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.egO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.egP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.egQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.egR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final hp a(a parama)
  {
    this.egO = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final hp mG(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hp mH(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hp mI(long paramLong)
  {
    this.egQ = paramLong;
    return this;
  }
  
  public final hp mJ(long paramLong)
  {
    this.egR = paramLong;
    return this;
  }
  
  public final hp mK(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hp oI(String paramString)
  {
    AppMethodBeat.i(180162);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(180162);
    return this;
  }
  
  public final hp oJ(String paramString)
  {
    AppMethodBeat.i(180163);
    this.egP = t("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final hp oK(String paramString)
  {
    AppMethodBeat.i(180164);
    this.ecQ = t("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public final hp oL(String paramString)
  {
    AppMethodBeat.i(180165);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(180165);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      egS = new a("release", 0, 1);
      egT = new a("debug", 1, 2);
      egU = new a("demo", 2, 3);
      egV = new a[] { egS, egT, egU };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jb(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egS;
      case 2: 
        return egT;
      }
      return egU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hp
 * JD-Core Version:    0.7.0.1
 */