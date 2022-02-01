package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  public long ebn = 0L;
  private String ebu = "";
  public long ebv = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebv);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.ebn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.ebu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.ebv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
  
  public final gi nD(String paramString)
  {
    AppMethodBeat.i(91247);
    this.ebu = t("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gi
 * JD-Core Version:    0.7.0.1
 */