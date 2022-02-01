package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class um
  extends a
{
  private long jHA = 0L;
  public long jHB = 0L;
  public long jHC = 0L;
  public long jHv = 0L;
  public long jHw = 0L;
  public long jHx = 0L;
  public long jHy = 0L;
  private long jHz = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jHv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.jHv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.jHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.jHx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.jHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.jHz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.jHA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.jHB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.jHC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91042);
    return localObject;
  }
  
  public final int getId()
  {
    return 14176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.um
 * JD-Core Version:    0.7.0.1
 */