package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jc
  extends a
{
  public long eLn;
  public long eQu;
  public long ejA;
  public long emN;
  
  public final String abV()
  {
    AppMethodBeat.i(231496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231496);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.emN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.eLn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BanType:").append(this.eQu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231497);
    return localObject;
  }
  
  public final int getId()
  {
    return 21321;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jc
 * JD-Core Version:    0.7.0.1
 */