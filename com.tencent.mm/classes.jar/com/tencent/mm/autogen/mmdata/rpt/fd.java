package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fd
  extends a
{
  public long iCW;
  public long iDn;
  public long iGH;
  
  public final String aIE()
  {
    AppMethodBeat.i(367773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iGH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367773);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367775);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpoFrom:").append(this.iGH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.iDn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.iCW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367775);
    return localObject;
  }
  
  public final int getId()
  {
    return 23863;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fd
 * JD-Core Version:    0.7.0.1
 */