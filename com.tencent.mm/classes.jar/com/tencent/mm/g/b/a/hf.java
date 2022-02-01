package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class hf
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecQ = "";
  public String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  public long edg = 0L;
  private long edv = 0L;
  private long edw = 0L;
  public long edx = 0L;
  public a eeX;
  public long eeY;
  public String eex = "";
  public long eey = 0L;
  public long eez = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eeX != null) {}
    for (int i = this.eeX.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eex);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eey);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eez);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43581);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eeX);
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
    ((StringBuffer)localObject).append("path:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.eeY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43582);
    return localObject;
  }
  
  public final hf ST()
  {
    AppMethodBeat.i(43580);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43580);
    return this;
  }
  
  public final int getId()
  {
    return 16010;
  }
  
  public final hf lY(long paramLong)
  {
    AppMethodBeat.i(43578);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43578);
    return this;
  }
  
  public final hf lZ(long paramLong)
  {
    AppMethodBeat.i(43579);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43579);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43577);
      eeZ = new a("release", 0, 1);
      efa = new a("debug", 1, 2);
      efb = new a("demo", 2, 3);
      efc = new a[] { eeZ, efa, efb };
      AppMethodBeat.o(43577);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iT(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeZ;
      case 2: 
        return efa;
      }
      return efb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hf
 * JD-Core Version:    0.7.0.1
 */