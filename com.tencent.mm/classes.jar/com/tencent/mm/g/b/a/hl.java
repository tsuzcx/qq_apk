package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hl
  extends a
{
  public long erT = 0L;
  private String erZ = "";
  public long esa = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esa);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.erT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.esa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
  
  public final hl qc(String paramString)
  {
    AppMethodBeat.i(91247);
    this.erZ = t("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hl
 * JD-Core Version:    0.7.0.1
 */