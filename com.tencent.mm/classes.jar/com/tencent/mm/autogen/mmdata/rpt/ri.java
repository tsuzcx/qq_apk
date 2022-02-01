package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ri
  extends a
{
  public long iqr = 0L;
  public long ixD = 0L;
  private String jvF = "";
  public long jvG = 0L;
  private long jvH = 0L;
  private long jvI = 0L;
  private String jvJ = "";
  public long jvK = 0L;
  private String jvL = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.jvF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.jvG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.jvH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ixD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.jvI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.jvJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.jvK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.jvL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
  
  public final ri ym(String paramString)
  {
    AppMethodBeat.i(149932);
    this.jvF = F("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final ri yn(String paramString)
  {
    AppMethodBeat.i(149933);
    this.jvJ = F("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
  
  public final ri yo(String paramString)
  {
    AppMethodBeat.i(149934);
    this.jvL = F("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ri
 * JD-Core Version:    0.7.0.1
 */