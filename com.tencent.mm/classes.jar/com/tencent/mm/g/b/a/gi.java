package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  public long dSa = 0L;
  public String dSb;
  public long ebh = 0L;
  public String eev = "";
  private String ejX = "";
  public String enI = "";
  public long enJ = 0L;
  public String enK;
  private int enL;
  public String enM;
  public String enN;
  public long enO;
  public long enP;
  public String enQ;
  public String enR;
  
  public final String RD()
  {
    AppMethodBeat.i(219015);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219015);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219016);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Word:").append(this.enI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.ejX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.ebh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalCount:").append(this.enJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.enK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.enL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocalSearch:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.enN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordType:").append(this.enO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.enP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecSessionId:").append(this.enQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.enR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219016);
    return localObject;
  }
  
  public final int getId()
  {
    return 10994;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gi
 * JD-Core Version:    0.7.0.1
 */