package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fk
  extends a
{
  private String dRB;
  public long dWq = 0L;
  public long ecJ = 0L;
  public long ekQ = 0L;
  private String ekU;
  public long ele = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(110293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ele);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(110293);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(110294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.ekQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.ecJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.ele);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110294);
    return localObject;
  }
  
  public final int getId()
  {
    return 18256;
  }
  
  public final fk ow(String paramString)
  {
    AppMethodBeat.i(110291);
    this.dRB = t("ChatName", paramString, true);
    AppMethodBeat.o(110291);
    return this;
  }
  
  public final fk ox(String paramString)
  {
    AppMethodBeat.i(110292);
    this.ekU = t("Identifier", paramString, true);
    AppMethodBeat.o(110292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fk
 * JD-Core Version:    0.7.0.1
 */