package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hd
  extends a
{
  public long erL = 0L;
  public long erM = 0L;
  public String erN = "";
  public String erO = "";
  public String erP = "";
  public String erQ = "";
  public String erR = "";
  
  public final String RD()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erR);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.erL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.erM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.erN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.erO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.erP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.erQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.erR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91244);
    return localObject;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hd
 * JD-Core Version:    0.7.0.1
 */