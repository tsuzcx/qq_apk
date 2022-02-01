package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eu
  extends a
{
  public int eiZ;
  public int eja;
  public int ejb;
  public int ejc;
  public int ejd;
  
  public final String RD()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejd);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.eiZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.eja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.ejb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.ejc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.ejd);
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
 * Qualified Name:     com.tencent.mm.g.b.a.eu
 * JD-Core Version:    0.7.0.1
 */