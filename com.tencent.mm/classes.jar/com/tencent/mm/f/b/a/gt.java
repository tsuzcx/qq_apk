package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gt
  extends a
{
  public String glF = "";
  public String gnO = "";
  private long gps;
  public long gxD;
  public long gxG;
  
  public final String agH()
  {
    AppMethodBeat.i(272056);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gps);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(272056);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(272057);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.gps);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.gxD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.gxG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.glF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(272057);
    return localObject;
  }
  
  public final int getId()
  {
    return 20493;
  }
  
  public final gt pq(long paramLong)
  {
    AppMethodBeat.i(272053);
    this.gps = paramLong;
    super.bm("EnterTimeStampMs", this.gps);
    AppMethodBeat.o(272053);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gt
 * JD-Core Version:    0.7.0.1
 */