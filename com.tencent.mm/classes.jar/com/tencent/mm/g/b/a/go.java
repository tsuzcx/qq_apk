package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class go
  extends a
{
  public long dSa;
  public String dVa;
  private String ejz;
  public long eoO;
  public long eoP;
  private String eoQ;
  public long eoR;
  public long eoS;
  public String eoT;
  
  public final String RD()
  {
    AppMethodBeat.i(197552);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoT);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(197552);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(197553);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCnt:").append(this.eoO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommCnt:").append(this.eoP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eoQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextAction:").append(this.eoR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCnt:").append(this.eoS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextPublishId:").append(this.eoT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(197553);
    return localObject;
  }
  
  public final int getId()
  {
    return 19750;
  }
  
  public final go ph(String paramString)
  {
    AppMethodBeat.i(197549);
    this.ejz = t("PublishId", paramString, true);
    AppMethodBeat.o(197549);
    return this;
  }
  
  public final go pi(String paramString)
  {
    AppMethodBeat.i(197550);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(197550);
    return this;
  }
  
  public final go pj(String paramString)
  {
    AppMethodBeat.i(197551);
    this.eoQ = t("ActionTimeStamp", paramString, true);
    AppMethodBeat.o(197551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.go
 * JD-Core Version:    0.7.0.1
 */