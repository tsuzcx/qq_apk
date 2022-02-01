package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nr
  extends a
{
  public long fij = 0L;
  public long fik = 0L;
  public long fil = 0L;
  public long fim = 0L;
  private long fin = 0L;
  private long fio = 0L;
  public long fip = 0L;
  public long fiq = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(91041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fij);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fim);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fin);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fio);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fip);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(91041);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(91042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isSuccessful:").append(this.fij);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanTime:").append(this.fik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusMode:").append(this.fil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalFrames:").append(this.fim);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("focusTime:").append(this.fin);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewStartTime:").append(this.fio);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasCodeTime:").append(this.fip);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scanMode:").append(this.fiq);
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
 * Qualified Name:     com.tencent.mm.g.b.a.nr
 * JD-Core Version:    0.7.0.1
 */