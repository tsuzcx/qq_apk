package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ol
  extends a
{
  public long iUM;
  public long ikE;
  public long inO;
  public long jjm;
  
  public final String aIE()
  {
    AppMethodBeat.i(368037);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368037);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368039);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.inO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.iUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BanType:").append(this.jjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368039);
    return localObject;
  }
  
  public final int getId()
  {
    return 21321;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ol
 * JD-Core Version:    0.7.0.1
 */