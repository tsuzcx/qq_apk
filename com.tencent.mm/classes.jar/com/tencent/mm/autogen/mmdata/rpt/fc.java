package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  public long iGF;
  public String iGG = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iGF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367779);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367785);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("opType:").append(this.iGF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("opDesc:").append(this.iGG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367785);
    return localObject;
  }
  
  public final int getId()
  {
    return 23850;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fc
 * JD-Core Version:    0.7.0.1
 */