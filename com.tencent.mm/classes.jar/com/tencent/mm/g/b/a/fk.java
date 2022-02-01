package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fk
  extends a
{
  public String dSR = "";
  public long dXf = 0L;
  public String emB = "";
  public long emJ = 0L;
  public long emx = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(110284);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(110284);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(110285);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.dXf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.emJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110285);
    return localObject;
  }
  
  public final int getId()
  {
    return 18258;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fk
 * JD-Core Version:    0.7.0.1
 */