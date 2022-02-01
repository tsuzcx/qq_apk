package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class le
  extends a
{
  public long eXG = 0L;
  private String eXM = "";
  public long eXN = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXN);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.eXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.eXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.eXN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
  
  public final le yr(String paramString)
  {
    AppMethodBeat.i(91247);
    this.eXM = x("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.le
 * JD-Core Version:    0.7.0.1
 */