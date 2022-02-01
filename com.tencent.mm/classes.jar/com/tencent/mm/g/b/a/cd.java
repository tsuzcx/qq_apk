package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cd
  extends a
{
  public long dPl;
  public String dSe;
  public String dSh;
  public String dSi;
  public String dSk;
  public long dVd;
  public long ebU;
  public String ebV;
  public String ebW;
  public long ebX;
  public long ebY;
  public long ebZ;
  
  public final String RD()
  {
    AppMethodBeat.i(217630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(217630);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(217631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasReddot:").append(this.ebU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordList:").append(this.ebV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordVersion:").append(this.ebW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.dSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.dSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.ebX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.dSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ebY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgContentLength:").append(this.ebZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217631);
    return localObject;
  }
  
  public final int getId()
  {
    return 20257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cd
 * JD-Core Version:    0.7.0.1
 */