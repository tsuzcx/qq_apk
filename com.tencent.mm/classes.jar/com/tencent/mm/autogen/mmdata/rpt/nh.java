package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nh
  extends a
{
  public int ioZ = 0;
  public int jeD = 0;
  public int jeE = 0;
  public int jeF = 0;
  public int jeG = 0;
  public String jeH = "";
  public String jeI = "";
  public String jeJ = "";
  public String jeK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367887);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jeD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367887);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367895);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContentW:").append(this.jeD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContentH:").append(this.jeE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickX:").append(this.jeF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickY:").append(this.jeG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.ioZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsId:").append(this.jeH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Uxinfo:").append(this.jeI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Extra1:").append(this.jeJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Extra2:").append(this.jeK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367895);
    return localObject;
  }
  
  public final int getId()
  {
    return 23600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nh
 * JD-Core Version:    0.7.0.1
 */