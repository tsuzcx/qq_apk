package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fx
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  private String dYa = "";
  private String eaK = "";
  private String eag = "";
  public long eai = 0L;
  public a eeH;
  private String eeI = "";
  public long eeJ = 0L;
  public long eeK = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eeH != null) {}
    for (int i = this.eeH.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dYa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eeH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.eeI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.eeJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.eeK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final fx a(a parama)
  {
    this.eeH = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final fx je(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fx jf(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fx jg(long paramLong)
  {
    this.eeJ = paramLong;
    return this;
  }
  
  public final fx jh(long paramLong)
  {
    this.eeK = paramLong;
    return this;
  }
  
  public final fx ji(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fx lD(String paramString)
  {
    AppMethodBeat.i(180162);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(180162);
    return this;
  }
  
  public final fx lE(String paramString)
  {
    AppMethodBeat.i(180163);
    this.eeI = t("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final fx lF(String paramString)
  {
    AppMethodBeat.i(180164);
    this.eaK = t("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public final fx lG(String paramString)
  {
    AppMethodBeat.i(180165);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(180165);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      eeL = new a("release", 0, 1);
      eeM = new a("debug", 1, 2);
      eeN = new a("demo", 2, 3);
      eeO = new a[] { eeL, eeM, eeN };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jd(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeL;
      case 2: 
        return eeM;
      }
      return eeN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fx
 * JD-Core Version:    0.7.0.1
 */