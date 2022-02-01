package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  public long iuE;
  public String iuQ = "";
  public long iuR;
  public String iuS = "";
  public long iuT;
  
  public final String aIE()
  {
    AppMethodBeat.i(368296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368296);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368301);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.iuQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.iuE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.iuR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitUrl:").append(this.iuS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageCnt:").append(this.iuT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368301);
    return localObject;
  }
  
  public final int getId()
  {
    return 22251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ca
 * JD-Core Version:    0.7.0.1
 */