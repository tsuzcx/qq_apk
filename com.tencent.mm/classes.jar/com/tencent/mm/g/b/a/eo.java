package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eo
  extends a
{
  public long eDQ;
  public String eDR = "";
  public String eDS = "";
  public long eDT;
  public long eDU;
  public long eiR;
  public long ejA;
  public String eno = "";
  public String enr = "";
  public String ens = "";
  public String enu = "";
  public long erW;
  
  public final String abV()
  {
    AppMethodBeat.i(187793);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ens);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDU);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187793);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187794);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.eno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasReddot:").append(this.eDQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordList:").append(this.eDR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordVersion:").append(this.eDS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.enr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.ens);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.eDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.enu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgContentLength:").append(this.eDU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187794);
    return localObject;
  }
  
  public final int getId()
  {
    return 20257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eo
 * JD-Core Version:    0.7.0.1
 */