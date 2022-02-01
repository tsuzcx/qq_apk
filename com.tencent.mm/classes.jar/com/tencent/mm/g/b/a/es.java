package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es
  extends a
{
  public long ejX;
  public int ejY;
  public int ejZ;
  public int eka;
  
  public final String RC()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eka);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.ejX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.ejY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.ejZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.eka);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19867);
    return localObject;
  }
  
  public final int getId()
  {
    return 18617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.es
 * JD-Core Version:    0.7.0.1
 */