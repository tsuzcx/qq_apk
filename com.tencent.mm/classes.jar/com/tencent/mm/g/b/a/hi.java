package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hi
  extends a
{
  private String dGd = "";
  private long dHY = 0L;
  private String dZT = "";
  private long eaM = 0L;
  private String ecQ = "";
  private String ecm = "";
  private long eco = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  private long eeY;
  private a efm;
  private long efn = 0L;
  private long efo = 0L;
  private String efp;
  
  public final String PR()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.efm != null) {}
    for (int i = this.efm.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dGd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efm);
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
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.efn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dGd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.efo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.efp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.eeY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final String SV()
  {
    return this.dZT;
  }
  
  public final hi a(a parama)
  {
    this.efm = parama;
    return this;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final hi mk(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hi ml(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hi mm(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hi mn(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final hi mo(long paramLong)
  {
    this.efn = paramLong;
    return this;
  }
  
  public final hi mp(long paramLong)
  {
    this.efo = paramLong;
    return this;
  }
  
  public final hi mq(long paramLong)
  {
    this.eeY = paramLong;
    return this;
  }
  
  public final hi oA(String paramString)
  {
    AppMethodBeat.i(43608);
    this.dGd = t("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public final hi ox(String paramString)
  {
    AppMethodBeat.i(43604);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final hi oy(String paramString)
  {
    AppMethodBeat.i(43605);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final hi oz(String paramString)
  {
    AppMethodBeat.i(186188);
    this.ecQ = t("networkType", paramString, true);
    AppMethodBeat.o(186188);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43603);
      efq = new a("release", 0, 1);
      efr = new a("debug", 1, 2);
      efs = new a("demo", 2, 3);
      eft = new a[] { efq, efr, efs };
      AppMethodBeat.o(43603);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iV(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efq;
      case 2: 
        return efr;
      }
      return efs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hi
 * JD-Core Version:    0.7.0.1
 */