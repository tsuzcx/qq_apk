package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ie
  extends a
{
  public int eNt;
  public int eNu;
  public int eNv;
  public int eNw;
  public int eNx;
  
  public final String abV()
  {
    AppMethodBeat.i(94824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eNt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eNu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eNv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eNw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eNx);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94824);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.eNt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.eNu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.eNv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.eNw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.eNx);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ie
 * JD-Core Version:    0.7.0.1
 */