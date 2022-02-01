package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  public int ipH = 0;
  public int iuL = 0;
  public int iuM = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(368748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipH);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368748);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368753);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptAppId:").append(this.iuL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.iuM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368753);
    return localObject;
  }
  
  public final int getId()
  {
    return 19988;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.by
 * JD-Core Version:    0.7.0.1
 */