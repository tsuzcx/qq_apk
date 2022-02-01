package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class g
  extends a
{
  public String gdM = "";
  private long gdN;
  private long gdO;
  public String gdP = "";
  public int gdQ;
  public long gdk;
  
  public final String agH()
  {
    AppMethodBeat.i(240006);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(240006);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(240009);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.gdM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeMs:").append(this.gdN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetTimeMs:").append(this.gdO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.gdk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.gdP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetStatus:").append(this.gdQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(240009);
    return localObject;
  }
  
  public final g bX(long paramLong)
  {
    AppMethodBeat.i(240001);
    this.gdN = paramLong;
    super.bk("StartTimeMs", this.gdN);
    AppMethodBeat.o(240001);
    return this;
  }
  
  public final g bY(long paramLong)
  {
    AppMethodBeat.i(240004);
    this.gdO = paramLong;
    super.bk("GetTimeMs", this.gdO);
    AppMethodBeat.o(240004);
    return this;
  }
  
  public final int getId()
  {
    return 21639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.g
 * JD-Core Version:    0.7.0.1
 */