package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ul
  extends a
{
  public long jHp = 0L;
  public long jHq = 0L;
  public long jHr = 0L;
  public long jHs = 0L;
  private String jHt = "";
  private String jHu = "";
  public long jbA = 0L;
  
  public final ul Ai(String paramString)
  {
    AppMethodBeat.i(121785);
    this.jHt = F("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final ul Aj(String paramString)
  {
    AppMethodBeat.i(121786);
    this.jHu = F("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jHp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.jHp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.jHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.jHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.jbA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.jHs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.jHt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.jHu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ul
 * JD-Core Version:    0.7.0.1
 */