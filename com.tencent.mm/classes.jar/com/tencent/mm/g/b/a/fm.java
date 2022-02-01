package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fm
  extends a
{
  private String dSR = "";
  public long dXI = 0L;
  public long eee = 0L;
  private String emB = "";
  public long emL = 0L;
  public long emx = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(110293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eee);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(110293);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(110294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.eee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110294);
    return localObject;
  }
  
  public final int getId()
  {
    return 18256;
  }
  
  public final fm oR(String paramString)
  {
    AppMethodBeat.i(110291);
    this.dSR = t("ChatName", paramString, true);
    AppMethodBeat.o(110291);
    return this;
  }
  
  public final fm oS(String paramString)
  {
    AppMethodBeat.i(110292);
    this.emB = t("Identifier", paramString, true);
    AppMethodBeat.o(110292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fm
 * JD-Core Version:    0.7.0.1
 */