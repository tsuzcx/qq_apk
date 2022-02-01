package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hj
  extends a
{
  public long iOd = 0L;
  private String iOe = "";
  private String iOf = "";
  public long ikE = 0L;
  public long iqr = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.iOe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.iOf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120835);
    return localObject;
  }
  
  public final int getId()
  {
    return 17055;
  }
  
  public final hj rq(String paramString)
  {
    AppMethodBeat.i(369013);
    this.iOe = F("FileID", paramString, true);
    AppMethodBeat.o(369013);
    return this;
  }
  
  public final hj rr(String paramString)
  {
    AppMethodBeat.i(369016);
    this.iOf = F("AesKey", paramString, true);
    AppMethodBeat.o(369016);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hj
 * JD-Core Version:    0.7.0.1
 */