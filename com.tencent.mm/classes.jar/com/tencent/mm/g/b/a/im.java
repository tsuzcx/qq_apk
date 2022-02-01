package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class im
  extends a
{
  public long ela = 0L;
  public long elb = 0L;
  public long elc = 0L;
  public long eld = 0L;
  private long ele = 0L;
  private long elf = 0L;
  public long elg = 0L;
  public long elh = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ela);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eld);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ele);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elh);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.ela);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.elb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.elc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.eld);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.ele);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.elf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.elg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.elh);
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
 * Qualified Name:     com.tencent.mm.g.b.a.im
 * JD-Core Version:    0.7.0.1
 */