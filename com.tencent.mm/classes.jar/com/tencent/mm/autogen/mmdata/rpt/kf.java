package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kf
  extends a
{
  public long iCW;
  public long iDn;
  public long iWi;
  public long iWj;
  
  public final String aIE()
  {
    AppMethodBeat.i(368858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368858);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EduType:").append(this.iWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.iDn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.iCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ListEduType:").append(this.iWj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368863);
    return localObject;
  }
  
  public final int getId()
  {
    return 22591;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kf
 * JD-Core Version:    0.7.0.1
 */