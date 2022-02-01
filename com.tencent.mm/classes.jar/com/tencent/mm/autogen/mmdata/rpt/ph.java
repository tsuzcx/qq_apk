package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ph
  extends a
{
  public long iMe = 0L;
  private String iXn = "";
  private String ijk = "";
  private String ilz = "";
  public long ioV = 0L;
  public String iqw = "";
  private int jfD;
  public String jlL = "";
  public long jlM = 0L;
  public String jlN = "";
  public String jlO = "";
  public String jlP = "";
  public long jlQ;
  public long jlR;
  public String jlS = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369127);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilz);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369127);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369139);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Word:").append(this.jlL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.iXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.iMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.iqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalCount:").append(this.jlM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.jlN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.jfD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocalSearch:").append(this.jlO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.jlP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordType:").append(this.jlQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.jlR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecSessionId:").append(this.jlS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.ilz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369139);
    return localObject;
  }
  
  public final int getId()
  {
    return 10994;
  }
  
  public final ph wJ(String paramString)
  {
    AppMethodBeat.i(369116);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(369116);
    return this;
  }
  
  public final ph wK(String paramString)
  {
    AppMethodBeat.i(369122);
    this.ilz = F("ChatId", paramString, true);
    AppMethodBeat.o(369122);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ph
 * JD-Core Version:    0.7.0.1
 */