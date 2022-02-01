package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class h
  extends a
{
  public long ijA;
  public int ijZ;
  public String ikf = "";
  private long ikg;
  private long ikh;
  public String iki = "";
  public int ikj;
  public String ikk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368678);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368678);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeMs:").append(this.ikg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetTimeMs:").append(this.ikh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ijA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.iki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetStatus:").append(this.ikj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.ijZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.ikk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368689);
    return localObject;
  }
  
  public final h en(long paramLong)
  {
    AppMethodBeat.i(368663);
    this.ikg = paramLong;
    super.bw("StartTimeMs", this.ikg);
    AppMethodBeat.o(368663);
    return this;
  }
  
  public final h eo(long paramLong)
  {
    AppMethodBeat.i(368670);
    this.ikh = paramLong;
    super.bw("GetTimeMs", this.ikh);
    AppMethodBeat.o(368670);
    return this;
  }
  
  public final int getId()
  {
    return 21639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.h
 * JD-Core Version:    0.7.0.1
 */