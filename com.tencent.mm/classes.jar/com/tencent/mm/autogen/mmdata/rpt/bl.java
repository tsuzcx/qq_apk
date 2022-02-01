package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  public String irG = "";
  public long irH;
  public long irI;
  public long irJ;
  public long irK;
  public long irL;
  
  public final String aIE()
  {
    AppMethodBeat.i(368853);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368853);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368861);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("JsMd5:").append(this.irG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Step1:").append(this.irH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Step2:").append(this.irI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Step3:").append(this.irJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("All:").append(this.irK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EdgeResult:").append(this.irL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368861);
    return localObject;
  }
  
  public final int getId()
  {
    return 23494;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bl
 * JD-Core Version:    0.7.0.1
 */