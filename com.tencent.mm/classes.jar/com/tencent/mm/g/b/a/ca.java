package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  public long cZS = 0L;
  public long cZU = 0L;
  private String cZV = "";
  public long cZW = 0L;
  public long cZX = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128644);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZS);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(128644);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.cZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.cZV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.cZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.cZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.cZS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128645);
    return localObject;
  }
  
  public final ca gZ(String paramString)
  {
    AppMethodBeat.i(128643);
    this.cZV = t("Appid", paramString, true);
    AppMethodBeat.o(128643);
    return this;
  }
  
  public final int getId()
  {
    return 15402;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ca
 * JD-Core Version:    0.7.0.1
 */