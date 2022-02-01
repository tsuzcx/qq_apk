package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dv
  extends a
{
  public long dSH;
  public int dSI;
  public int dSJ;
  public int dSK;
  
  public final String PR()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSK);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.dSH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.dSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.dSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.dSK);
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
 * Qualified Name:     com.tencent.mm.g.b.a.dv
 * JD-Core Version:    0.7.0.1
 */