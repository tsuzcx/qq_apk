package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cx
  extends a
{
  private String dGR;
  public long dMT = 0L;
  public long dSK = 0L;
  private String dSO;
  public long dSY = 0L;
  public long dSZ = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(110293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(110293);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(110294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.dMT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.dSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dSO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110294);
    return localObject;
  }
  
  public final int getId()
  {
    return 18256;
  }
  
  public final cx jt(String paramString)
  {
    AppMethodBeat.i(110291);
    this.dGR = t("ChatName", paramString, true);
    AppMethodBeat.o(110291);
    return this;
  }
  
  public final cx ju(String paramString)
  {
    AppMethodBeat.i(110292);
    this.dSO = t("Identifier", paramString, true);
    AppMethodBeat.o(110292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cx
 * JD-Core Version:    0.7.0.1
 */