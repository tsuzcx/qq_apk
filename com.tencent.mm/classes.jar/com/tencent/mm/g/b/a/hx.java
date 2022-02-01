package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class hx
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  public long eaM = 0L;
  public long eaY = 0L;
  private String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  private long edv = 0L;
  private long edw = 0L;
  public long edx = 0L;
  public a eiC;
  public long eiD = 0L;
  private String eiE = "";
  
  public final String PR()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eiC != null) {}
    for (int i = this.eiC.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiE);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.eaY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.eiD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.eiE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final hx Tc()
  {
    AppMethodBeat.i(43738);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final hx ny(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final hx nz(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public final hx oY(String paramString)
  {
    AppMethodBeat.i(43734);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final hx oZ(String paramString)
  {
    AppMethodBeat.i(43735);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final hx pa(String paramString)
  {
    AppMethodBeat.i(43739);
    this.eiE = t("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43733);
      eiF = new a("release", 0, 1);
      eiG = new a("debug", 1, 2);
      eiH = new a("demo", 2, 3);
      eiI = new a[] { eiF, eiG, eiH };
      AppMethodBeat.o(43733);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jk(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eiF;
      case 2: 
        return eiG;
      }
      return eiH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hx
 * JD-Core Version:    0.7.0.1
 */