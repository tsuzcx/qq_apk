package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ll
  extends a
{
  public long gKR;
  public long gQQ;
  public long gef;
  public long ghT;
  
  public final String agH()
  {
    AppMethodBeat.i(284951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ghT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(284951);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(284952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.ghT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.gKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BanType:").append(this.gQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(284952);
    return localObject;
  }
  
  public final int getId()
  {
    return 21321;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ll
 * JD-Core Version:    0.7.0.1
 */