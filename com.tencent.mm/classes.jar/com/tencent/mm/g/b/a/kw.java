package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kw
  extends a
{
  public String eXA = "";
  public String eXB = "";
  public String eXC = "";
  public String eXD = "";
  public String eXE = "";
  public long eXy = 0L;
  public long eXz = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eXy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXE);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.eXy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.eXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.eXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.eXB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.eXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.eXD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.eXE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91244);
    return localObject;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kw
 * JD-Core Version:    0.7.0.1
 */