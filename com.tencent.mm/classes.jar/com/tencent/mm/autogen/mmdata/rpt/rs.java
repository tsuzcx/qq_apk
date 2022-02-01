package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rs
  extends a
{
  public long jvV = 0L;
  private String jwb = "";
  public long jwc = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jvV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.jvV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.jwb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.jwc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
  
  public final rs yr(String paramString)
  {
    AppMethodBeat.i(91247);
    this.jwb = F("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rs
 * JD-Core Version:    0.7.0.1
 */