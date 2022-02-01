package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public String dQA = "";
  public long dQB = 0L;
  public String dQC = "";
  public long dQz;
  
  public final String RC()
  {
    AppMethodBeat.i(185997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQC);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(185997);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(185998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Requestcode:").append(this.dQz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessName:").append(this.dQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stack:").append(this.dQC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(185998);
    return localObject;
  }
  
  public final int getId()
  {
    return 19574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */