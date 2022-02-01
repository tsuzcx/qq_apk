package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class la
  extends a
{
  public long iYC;
  public long iYD;
  public long iYE;
  public long iYF;
  public long ila;
  
  public final String aIE()
  {
    AppMethodBeat.i(368231);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368231);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type_:").append(this.iYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status_:").append(this.iYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_expired_:").append(this.iYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("source_:").append(this.iYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368242);
    return localObject;
  }
  
  public final int getId()
  {
    return 24723;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.la
 * JD-Core Version:    0.7.0.1
 */