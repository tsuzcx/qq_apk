package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class el
  extends a
{
  private String dEE;
  public long dII = 0L;
  public long dNu = 0L;
  private String dUC;
  public long dUM = 0L;
  public long dUy = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(110293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dII);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(110293);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(110294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dII);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.dNu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.dUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dUC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110294);
    return localObject;
  }
  
  public final int getId()
  {
    return 18256;
  }
  
  public final el mj(String paramString)
  {
    AppMethodBeat.i(110291);
    this.dEE = t("ChatName", paramString, true);
    AppMethodBeat.o(110291);
    return this;
  }
  
  public final el mk(String paramString)
  {
    AppMethodBeat.i(110292);
    this.dUC = t("Identifier", paramString, true);
    AppMethodBeat.o(110292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.el
 * JD-Core Version:    0.7.0.1
 */