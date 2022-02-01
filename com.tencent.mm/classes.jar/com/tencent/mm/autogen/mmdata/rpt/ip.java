package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ip
  extends a
{
  public long iJM;
  public long iJP;
  public long iQu;
  public String ira = "";
  public String ixm = "";
  private long ize;
  
  public final String aIE()
  {
    AppMethodBeat.i(368733);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ize);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ira);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368733);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368737);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.ize);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.iJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.iJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.ira);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.iQu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368737);
    return localObject;
  }
  
  public final ip fc(long paramLong)
  {
    AppMethodBeat.i(368725);
    this.ize = paramLong;
    super.by("EnterTimeStampMs", this.ize);
    AppMethodBeat.o(368725);
    return this;
  }
  
  public final int getId()
  {
    return 20493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ip
 * JD-Core Version:    0.7.0.1
 */