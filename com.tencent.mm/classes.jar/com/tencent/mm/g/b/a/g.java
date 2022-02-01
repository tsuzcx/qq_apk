package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class g
  extends a
{
  public long ejA = 0L;
  public String ejB = "";
  public long ejy;
  public String ejz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(185997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(185997);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(185998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Requestcode:").append(this.ejy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessName:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stack:").append(this.ejB);
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
 * Qualified Name:     com.tencent.mm.g.b.a.g
 * JD-Core Version:    0.7.0.1
 */