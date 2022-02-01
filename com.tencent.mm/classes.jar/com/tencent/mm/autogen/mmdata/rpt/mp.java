package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mp
  extends a
{
  private String iKT = "";
  public String irF = "";
  public long ixB;
  public long iyr;
  public long jbR;
  public long jbS = -1L;
  public long jbT = -1L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368345);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368345);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368350);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.irF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.iyr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MonmentSessionId:").append(this.iKT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("templateType:").append(this.jbR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsThumbExit:").append(this.jbS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsThumbBlack:").append(this.jbT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368350);
    return localObject;
  }
  
  public final int getId()
  {
    return 21746;
  }
  
  public final mp vb(String paramString)
  {
    AppMethodBeat.i(368342);
    this.iKT = F("MonmentSessionId", paramString, true);
    AppMethodBeat.o(368342);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mp
 * JD-Core Version:    0.7.0.1
 */