package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qr
  extends a
{
  public long hlA = 0L;
  public long hlB = 0L;
  public long hlu = 0L;
  public long hlv = 0L;
  public long hlw = 0L;
  public long hlx = 0L;
  private long hly = 0L;
  private long hlz = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hlu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hly);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.hlu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.hlv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.hlw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.hlx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.hly);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.hlz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.hlA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.hlB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91042);
    return localObject;
  }
  
  public final int getId()
  {
    return 14176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qr
 * JD-Core Version:    0.7.0.1
 */