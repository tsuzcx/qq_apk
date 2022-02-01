package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  public String iph = "";
  public String ipi = "";
  public int ipj = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(121744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iph);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(121744);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.iph);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptScore:").append(this.ipi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptFlag:").append(this.ipj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121745);
    return localObject;
  }
  
  public final int getId()
  {
    return 15459;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.aq
 * JD-Core Version:    0.7.0.1
 */