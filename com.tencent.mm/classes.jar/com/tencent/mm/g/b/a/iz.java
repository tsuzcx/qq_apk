package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iz
  extends a
{
  public long eQf = 0L;
  private String eQj = "";
  public long eQr = 0L;
  private String emL = "";
  public long etp = 0L;
  public long ewL = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(110293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(110293);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(110294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.ewL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.eQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110294);
    return localObject;
  }
  
  public final int getId()
  {
    return 18256;
  }
  
  public final iz wA(String paramString)
  {
    AppMethodBeat.i(110291);
    this.emL = x("ChatName", paramString, true);
    AppMethodBeat.o(110291);
    return this;
  }
  
  public final iz wB(String paramString)
  {
    AppMethodBeat.i(110292);
    this.eQj = x("Identifier", paramString, true);
    AppMethodBeat.o(110292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iz
 * JD-Core Version:    0.7.0.1
 */