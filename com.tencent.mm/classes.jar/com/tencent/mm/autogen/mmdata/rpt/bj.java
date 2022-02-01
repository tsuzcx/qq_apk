package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bj
  extends a
{
  public long irg;
  public long irh;
  public long iri = 0L;
  public String irj = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368898);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iri);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368898);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMethod:").append(this.irg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadNum:").append(this.irh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpToChatType:").append(this.iri);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368905);
    return localObject;
  }
  
  public final int getId()
  {
    return 20134;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bj
 * JD-Core Version:    0.7.0.1
 */