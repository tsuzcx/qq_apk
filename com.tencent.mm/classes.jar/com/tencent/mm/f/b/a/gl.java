package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gl
  extends a
{
  private long gCG;
  private long gCH;
  private long gCI;
  private long gCJ;
  private long gCK;
  private long gCL;
  private long gCM;
  private long gCN;
  private long gCO;
  
  public final String agH()
  {
    AppMethodBeat.i(215742);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCO);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(215742);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(215744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InitializeTime:").append(this.gCG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateSessionTime:").append(this.gCH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionType:").append(this.gCI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigDictTime:").append(this.gCJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCellDictTime:").append(this.gCK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitNetWorkTime:").append(this.gCL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshContactDictTime:").append(this.gCM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.gCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessStartTime:").append(this.gCO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215744);
    return localObject;
  }
  
  public final int getId()
  {
    return 22354;
  }
  
  public final gl oZ(long paramLong)
  {
    this.gCG = paramLong;
    return this;
  }
  
  public final gl pa(long paramLong)
  {
    this.gCH = paramLong;
    return this;
  }
  
  public final gl pb(long paramLong)
  {
    this.gCI = paramLong;
    return this;
  }
  
  public final gl pc(long paramLong)
  {
    this.gCJ = paramLong;
    return this;
  }
  
  public final gl pd(long paramLong)
  {
    this.gCK = paramLong;
    return this;
  }
  
  public final gl pe(long paramLong)
  {
    this.gCL = paramLong;
    return this;
  }
  
  public final gl pf(long paramLong)
  {
    this.gCM = paramLong;
    return this;
  }
  
  public final gl pg(long paramLong)
  {
    this.gCN = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gl
 * JD-Core Version:    0.7.0.1
 */