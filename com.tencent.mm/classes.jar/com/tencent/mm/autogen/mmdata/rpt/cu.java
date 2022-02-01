package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cu
  extends a
{
  public long ixD;
  public long ixE;
  public int ixF;
  public long ixG;
  
  public final String aIE()
  {
    AppMethodBeat.i(368143);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368143);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succ:").append(this.ixE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errCode:").append(this.ixF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cdnType:").append(this.ixG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368153);
    return localObject;
  }
  
  public final int getId()
  {
    return 25150;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cu
 * JD-Core Version:    0.7.0.1
 */