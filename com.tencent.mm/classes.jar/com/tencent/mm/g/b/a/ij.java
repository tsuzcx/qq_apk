package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class ij
  extends a
{
  public long dWt;
  public String esa = "";
  public long etb;
  public long euA;
  public String euy = "";
  private long evH;
  public long evI;
  public long evJ;
  public String evc = "";
  public long evp;
  public String ewR = "";
  public long ewT;
  public a ewZ;
  public long exa;
  public long exb;
  public long exc;
  
  public final String RC()
  {
    AppMethodBeat.i(43568);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ewZ != null) {}
    for (int i = this.ewZ.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exc);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43568);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43569);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ewZ);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.exa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.exb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ewT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.exc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43569);
    return localObject;
  }
  
  public final ij Vl()
  {
    AppMethodBeat.i(43567);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43567);
    return this;
  }
  
  public final int getId()
  {
    return 18798;
  }
  
  public final ij oe(long paramLong)
  {
    AppMethodBeat.i(43565);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43565);
    return this;
  }
  
  public final ij of(long paramLong)
  {
    AppMethodBeat.i(43566);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43566);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43564);
      exd = new a("release", 0, 1);
      exe = new a("debug", 1, 2);
      exf = new a("demo", 2, 3);
      exg = new a[] { exd, exe, exf };
      AppMethodBeat.o(43564);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jq(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return exd;
      case 2: 
        return exe;
      }
      return exf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ij
 * JD-Core Version:    0.7.0.1
 */