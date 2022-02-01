package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ib
  extends a
{
  public long dWt = 0L;
  public long ebQ = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  public long evI = 0L;
  public long evJ = 0L;
  public a evV;
  
  public final String RC()
  {
    AppMethodBeat.i(43517);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.evV != null) {}
    for (int i = this.evV.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ebQ);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43517);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43518);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evV);
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
    ((StringBuffer)localObject).append("type:").append(this.ebQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43518);
    return localObject;
  }
  
  public final int getId()
  {
    return 16895;
  }
  
  public final ib nG(long paramLong)
  {
    AppMethodBeat.i(43514);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43514);
    return this;
  }
  
  public final ib nH(long paramLong)
  {
    AppMethodBeat.i(43515);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43515);
    return this;
  }
  
  public final ib nI(long paramLong)
  {
    AppMethodBeat.i(43516);
    this.evJ = paramLong;
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43516);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43513);
      evW = new a("release", 0, 1);
      evX = new a("debug", 1, 2);
      evY = new a("demo", 2, 3);
      evZ = new a[] { evW, evX, evY };
      AppMethodBeat.o(43513);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jg(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return evW;
      case 2: 
        return evX;
      }
      return evY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ib
 * JD-Core Version:    0.7.0.1
 */