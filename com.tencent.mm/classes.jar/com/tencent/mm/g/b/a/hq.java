package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  public long eBn;
  public String eBo = "";
  public long eBr;
  public String erU = "";
  private long etn;
  
  public final String abV()
  {
    AppMethodBeat.i(241597);
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
    AppMethodBeat.o(241597);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(241598);
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
    AppMethodBeat.o(241598);
    return localObject;
  }
  
  public final int getId()
  {
    return 20491;
  }
  
  public final hq qR(long paramLong)
  {
    AppMethodBeat.i(241596);
    this.etn = paramLong;
    super.bj("EnterTimeStampMs", this.etn);
    AppMethodBeat.o(241596);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hq
 * JD-Core Version:    0.7.0.1
 */