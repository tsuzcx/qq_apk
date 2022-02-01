package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public long dPj;
  public String dPk;
  public long dPl = 0L;
  public String dPm;
  
  public final String RD()
  {
    AppMethodBeat.i(185997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPm);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(185997);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(185998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Requestcode:").append(this.dPj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessName:").append(this.dPk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stack:").append(this.dPm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(185998);
    return localObject;
  }
  
  public final int getId()
  {
    return 19574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */