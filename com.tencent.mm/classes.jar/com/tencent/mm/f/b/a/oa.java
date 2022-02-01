package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oa
  extends a
{
  public long hal = 0L;
  private String har = "";
  public long has = 0L;
  
  public final oa EJ(String paramString)
  {
    AppMethodBeat.i(91247);
    this.har = z("TransferUserName", paramString, true);
    AppMethodBeat.o(91247);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(91248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hal);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.har);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.has);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(91248);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(91249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.hal);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.har);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.has);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91249);
    return localObject;
  }
  
  public final int getId()
  {
    return 16016;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oa
 * JD-Core Version:    0.7.0.1
 */