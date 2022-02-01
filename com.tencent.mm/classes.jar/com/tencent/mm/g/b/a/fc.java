package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  public long eBn;
  public String eBo = "";
  public long eBr;
  public String erU = "";
  private long etn;
  
  public final String abV()
  {
    AppMethodBeat.i(241584);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(241584);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(241585);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.etn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.eBn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.eBr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.eBo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(241585);
    return localObject;
  }
  
  public final int getId()
  {
    return 20493;
  }
  
  public final fc nf(long paramLong)
  {
    AppMethodBeat.i(241583);
    this.etn = paramLong;
    super.bj("EnterTimeStampMs", this.etn);
    AppMethodBeat.o(241583);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fc
 * JD-Core Version:    0.7.0.1
 */