package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class py
  extends a
{
  private String iVg = "";
  public long ioV;
  public String ixm = "";
  public long jpO;
  public long jpP;
  private String jpQ = "";
  public long jpR;
  public long jpS;
  public String jpT = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369060);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369063);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.iVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCnt:").append(this.jpO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommCnt:").append(this.jpP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.jpQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextAction:").append(this.jpR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCnt:").append(this.jpS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextPublishId:").append(this.jpT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369063);
    return localObject;
  }
  
  public final int getId()
  {
    return 19750;
  }
  
  public final py xd(String paramString)
  {
    AppMethodBeat.i(369047);
    this.iVg = F("PublishId", paramString, true);
    AppMethodBeat.o(369047);
    return this;
  }
  
  public final py xe(String paramString)
  {
    AppMethodBeat.i(369052);
    this.ixm = F("Sessionid", paramString, true);
    AppMethodBeat.o(369052);
    return this;
  }
  
  public final py xf(String paramString)
  {
    AppMethodBeat.i(369057);
    this.jpQ = F("ActionTimeStamp", paramString, true);
    AppMethodBeat.o(369057);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.py
 * JD-Core Version:    0.7.0.1
 */