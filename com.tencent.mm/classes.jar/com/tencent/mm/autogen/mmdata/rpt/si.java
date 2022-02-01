package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class si
  extends a
{
  private String ilL = "";
  public long jxU = 0L;
  public long jxW = 0L;
  public long jxX = 0L;
  public long jxY = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jxW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxU);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.jxW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.jxX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.jxY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.jxU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
  
  public final si yW(String paramString)
  {
    AppMethodBeat.i(43480);
    this.ilL = F("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.si
 * JD-Core Version:    0.7.0.1
 */