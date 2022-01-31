package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  public int cUA;
  public int cUB;
  public int cUC;
  public int cUD;
  public int cUE;
  
  public final String Ff()
  {
    AppMethodBeat.i(145231);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUE);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(145231);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(145232);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.cUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResourceAutoDownload:").append(this.cUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageSaveLocal:").append(this.cUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightSaveLocal:").append(this.cUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SightAutoPlay:").append(this.cUE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(145232);
    return localObject;
  }
  
  public final int getId()
  {
    return 17504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.al
 * JD-Core Version:    0.7.0.1
 */