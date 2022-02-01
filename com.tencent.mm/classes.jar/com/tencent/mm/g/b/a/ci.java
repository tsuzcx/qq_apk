package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  public int dQW;
  public int dQX;
  public int dQY;
  public int dQZ;
  public int dRa;
  
  public final String PV()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRa);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.dQW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.dQY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.dQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.dRa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94825);
    return localObject;
  }
  
  public final int getId()
  {
    return 17504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ci
 * JD-Core Version:    0.7.0.1
 */