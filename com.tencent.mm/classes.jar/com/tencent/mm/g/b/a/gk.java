package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gk
  extends a
{
  public long dTq = 0L;
  public String dTr = "";
  public long ecC = 0L;
  public String efV = "";
  private String elE = "";
  public String epq = "";
  public long epr = 0L;
  public String eps = "";
  private int ept;
  public String epu = "";
  public String epv = "";
  public long epw;
  public long epx;
  public String epy = "";
  public String epz = "";
  
  public final String RC()
  {
    AppMethodBeat.i(188493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eps);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ept);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epz);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(188493);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(188494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Word:").append(this.epq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.elE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.ecC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.efV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalCount:").append(this.epr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.eps);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.ept);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocalSearch:").append(this.epu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.epv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordType:").append(this.epw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.epx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecSessionId:").append(this.epy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.epz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188494);
    return localObject;
  }
  
  public final int getId()
  {
    return 10994;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gk
 * JD-Core Version:    0.7.0.1
 */