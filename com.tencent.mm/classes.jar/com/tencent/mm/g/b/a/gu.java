package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gu
  extends a
{
  public long eiW = 0L;
  public long eiX = 0L;
  public long eiY = 0L;
  public long eiZ = 0L;
  private long eja = 0L;
  private long ejb = 0L;
  public long ejc = 0L;
  public long ejd = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiY);
    ((StringBuffer)localObject).append(",");
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
    ams((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.eiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.eiY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.eiZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.eja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.ejb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.ejc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.ejd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91042);
    return localObject;
  }
  
  public final int getId()
  {
    return 14176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gu
 * JD-Core Version:    0.7.0.1
 */