package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class hd
  extends a
{
  public long dHY;
  public String dZT;
  public long eaM;
  public String ecQ;
  public String ecm;
  public long eco;
  public long edd;
  private long edv;
  public long edw;
  public long edx;
  public a eeF;
  public long eeG;
  public long eeH;
  public long eeI;
  public String eex;
  public long eez;
  
  public final String PR()
  {
    AppMethodBeat.i(43568);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eeF != null) {}
    for (int i = this.eeF.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eez);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeI);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43568);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43569);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eeF);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.eeG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.eeH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.eeI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43569);
    return localObject;
  }
  
  public final hd SR()
  {
    AppMethodBeat.i(43567);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43567);
    return this;
  }
  
  public final int getId()
  {
    return 18798;
  }
  
  public final hd lU(long paramLong)
  {
    AppMethodBeat.i(43565);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43565);
    return this;
  }
  
  public final hd lV(long paramLong)
  {
    AppMethodBeat.i(43566);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43566);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43564);
      eeJ = new a("release", 0, 1);
      eeK = new a("debug", 1, 2);
      eeL = new a("demo", 2, 3);
      eeM = new a[] { eeJ, eeK, eeL };
      AppMethodBeat.o(43564);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iS(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeJ;
      case 2: 
        return eeK;
      }
      return eeL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hd
 * JD-Core Version:    0.7.0.1
 */