package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gj
  extends a
{
  public long iAZ;
  public String iKT = "";
  private String iqk = "";
  public String irF = "";
  public long iyr;
  
  public final String aIE()
  {
    AppMethodBeat.i(369149);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iAZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369149);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ForwardType:").append(this.iAZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.iqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.irF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.iyr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MonmentSessionId:").append(this.iKT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369152);
    return localObject;
  }
  
  public final int getId()
  {
    return 21181;
  }
  
  public final gj qT(String paramString)
  {
    AppMethodBeat.i(369146);
    this.iqk = F("Feedid", paramString, true);
    AppMethodBeat.o(369146);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gj
 * JD-Core Version:    0.7.0.1
 */