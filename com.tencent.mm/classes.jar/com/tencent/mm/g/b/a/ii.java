package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ii
  extends a
{
  private long dWt = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public long evp;
  public long evs;
  public a ewQ;
  public String ewR = "";
  public long ewS;
  public long ewT;
  public long ewU;
  
  public final String RC()
  {
    AppMethodBeat.i(221947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ewQ != null) {}
    for (int i = this.ewQ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evs);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewU);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(221947);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ewQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.ewR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.evs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.ewS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ewT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.ewU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221948);
    return localObject;
  }
  
  public final int getId()
  {
    return 19266;
  }
  
  public final ii ob(long paramLong)
  {
    AppMethodBeat.i(221944);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(221944);
    return this;
  }
  
  public final ii oc(long paramLong)
  {
    AppMethodBeat.i(221945);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(221945);
    return this;
  }
  
  public final ii od(long paramLong)
  {
    AppMethodBeat.i(221946);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(221946);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(221943);
      ewV = new a("release", 0, 1);
      ewW = new a("debug", 1, 2);
      ewX = new a("demo", 2, 3);
      ewY = new a[] { ewV, ewW, ewX };
      AppMethodBeat.o(221943);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jp(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ewV;
      case 2: 
        return ewW;
      }
      return ewX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ii
 * JD-Core Version:    0.7.0.1
 */