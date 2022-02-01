package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jt
  extends a
{
  public long eDL = 0L;
  public long eDM = 0L;
  public long eDN = 0L;
  public long eDO = 0L;
  private long eDP = 0L;
  private long eDQ = 0L;
  public long eDR = 0L;
  public long eDS = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDS);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.eDL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.eDM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.eDN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.eDO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.eDP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.eDQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.eDR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.eDS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91042);
    return localObject;
  }
  
  public final int getId()
  {
    return 14176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jt
 * JD-Core Version:    0.7.0.1
 */