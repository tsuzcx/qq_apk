package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jr
  extends a
{
  public long eCc = 0L;
  public long eCd = 0L;
  public long eCe = 0L;
  public long eCf = 0L;
  private long eCg = 0L;
  private long eCh = 0L;
  public long eCi = 0L;
  public long eCj = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eCc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCj);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.eCc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.eCd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.eCe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.eCf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.eCg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.eCh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.eCi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.eCj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91042);
    return localObject;
  }
  
  public final int getId()
  {
    return 14176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jr
 * JD-Core Version:    0.7.0.1
 */