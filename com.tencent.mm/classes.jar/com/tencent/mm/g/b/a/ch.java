package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ch
  extends a
{
  public long dQS;
  public int dQT;
  public int dQU;
  public int dQV;
  
  public final String PV()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.dQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.dQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.dQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.dQV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19867);
    return localObject;
  }
  
  public final int getId()
  {
    return 18617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ch
 * JD-Core Version:    0.7.0.1
 */