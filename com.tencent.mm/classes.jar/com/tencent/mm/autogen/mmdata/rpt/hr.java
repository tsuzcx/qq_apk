package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hr
  extends a
{
  private String iOP = "";
  public long iOQ = 0L;
  public long iOR = 0L;
  public long iqr;
  
  public final String aIE()
  {
    AppMethodBeat.i(184627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184627);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.iOP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.iOQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.iOR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184628);
    return localObject;
  }
  
  public final int getId()
  {
    return 19353;
  }
  
  public final hr rF(String paramString)
  {
    AppMethodBeat.i(184626);
    this.iOP = F("Roomid", paramString, true);
    AppMethodBeat.o(184626);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hr
 * JD-Core Version:    0.7.0.1
 */