package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es
  extends a
{
  private String dZC = "";
  public long dZD = 0L;
  public long dZv = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZD);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.dZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.dZC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.dZD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
  
  public final es kL(String paramString)
  {
    AppMethodBeat.i(91247);
    this.dZC = t("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.es
 * JD-Core Version:    0.7.0.1
 */