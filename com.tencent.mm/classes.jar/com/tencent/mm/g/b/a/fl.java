package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fl
  extends a
{
  public String dRB;
  public long ekQ = 0L;
  public String ekU;
  public long elf = 0L;
  public long elg = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(215762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elg);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(215762);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(215763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.ekQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.ekU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.elf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.elg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215763);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fl
 * JD-Core Version:    0.7.0.1
 */