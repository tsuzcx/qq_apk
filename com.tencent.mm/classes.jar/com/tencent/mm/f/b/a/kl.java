package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kl
  extends a
{
  public int gNA;
  public int gNB;
  public int gNx;
  public int gNy;
  public int gNz;
  
  public final String agH()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gNx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gNy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gNz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gNA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gNB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.gNx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.gNy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.gNz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.gNA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.gNB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94825);
    return localObject;
  }
  
  public final int getId()
  {
    return 17504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kl
 * JD-Core Version:    0.7.0.1
 */