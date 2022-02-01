package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mr
  extends a
{
  public long iIE;
  public long ikE;
  public String imN = "";
  public String jbY = "";
  public String jbZ = "";
  public long jca;
  
  public final String aIE()
  {
    AppMethodBeat.i(368354);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jca);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368354);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368361);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileSize:").append(this.iIE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileExt:").append(this.jbY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.jbZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LogVersionlog:").append(this.jca);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368361);
    return localObject;
  }
  
  public final int getId()
  {
    return 22579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mr
 * JD-Core Version:    0.7.0.1
 */