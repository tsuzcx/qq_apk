package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dw
  extends a
{
  public int dSL;
  public int dSM;
  public int dSN;
  public int dSO;
  public int dSP;
  
  public final String PR()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSP);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.dSL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.dSM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.dSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.dSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.dSP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94825);
    return localObject;
  }
  
  public final int getId()
  {
    return 17504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dw
 * JD-Core Version:    0.7.0.1
 */