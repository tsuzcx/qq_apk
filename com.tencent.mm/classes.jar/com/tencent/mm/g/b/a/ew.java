package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ew
  extends a
{
  public int ekH;
  public int ekI;
  public int ekJ;
  public int ekK;
  public int ekL;
  
  public final String RC()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekL);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.ekI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.ekJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.ekK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.ekL);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ew
 * JD-Core Version:    0.7.0.1
 */