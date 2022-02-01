package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ne
  extends a
{
  public int jdF;
  public int jdG;
  public int jdH;
  public int jdI;
  public int jdJ;
  
  public final String aIE()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jdF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.jdF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.jdG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.jdH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.jdI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.jdJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94825);
    return localObject;
  }
  
  public final int getId()
  {
    return 17504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ne
 * JD-Core Version:    0.7.0.1
 */