package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class na
  extends a
{
  public long jcW;
  public int jcX;
  public int jcY;
  public int jcZ;
  
  public final String aIE()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jcW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.jcW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.jcX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.jcY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.jcZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19867);
    return localObject;
  }
  
  public final int getId()
  {
    return 18617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.na
 * JD-Core Version:    0.7.0.1
 */