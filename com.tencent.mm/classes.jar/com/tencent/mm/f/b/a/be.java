package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  public String glM = "";
  public long glN;
  public String glO = "";
  public long glP;
  public long glw;
  
  public final String agH()
  {
    AppMethodBeat.i(242787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.glM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(242787);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(242789);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.glM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.glN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitUrl:").append(this.glO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageCnt:").append(this.glP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(242789);
    return localObject;
  }
  
  public final int getId()
  {
    return 22251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.be
 * JD-Core Version:    0.7.0.1
 */