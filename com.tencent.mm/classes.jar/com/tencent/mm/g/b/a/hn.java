package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hn
  extends a
{
  public long etA = 0L;
  private String etG = "";
  public long etH = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etH);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.etA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.etG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.etH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
  
  public final hn qx(String paramString)
  {
    AppMethodBeat.i(91247);
    this.etG = t("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hn
 * JD-Core Version:    0.7.0.1
 */