package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  public long eqk;
  public String eqv = "";
  public long eqw;
  public String eqx = "";
  public long eqy;
  
  public final String abV()
  {
    AppMethodBeat.i(210794);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqy);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(210794);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(210795);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.eqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.eqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitUrl:").append(this.eqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageCnt:").append(this.eqy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210795);
    return localObject;
  }
  
  public final int getId()
  {
    return 22251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.av
 * JD-Core Version:    0.7.0.1
 */