package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class us
  extends a
{
  public long iEj;
  public int ilm;
  public String jHP = "";
  public int jkA;
  public String jlW = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iEj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368478);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368498);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.iEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.jHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.jlW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.jkA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368498);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.us
 * JD-Core Version:    0.7.0.1
 */