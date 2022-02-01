package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dx
  extends a
{
  private long dFd;
  private String dFe;
  private long dHY = 0L;
  private long dIt = 0L;
  private String dOH;
  private String dSQ;
  private String dSR;
  private long dSS = 0L;
  private long dST = 0L;
  private long dSU;
  private String dSV;
  private long dSW = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(188269);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dST);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIt);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(188269);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(188270);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.dOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.dSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.dSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.dST);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.dSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.dSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.dSW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.dIt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188270);
    return localObject;
  }
  
  public final dx Rd()
  {
    this.dHY = 59L;
    return this;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final dx in(long paramLong)
  {
    this.dSS = paramLong;
    return this;
  }
  
  public final dx io(long paramLong)
  {
    this.dST = paramLong;
    return this;
  }
  
  public final dx ip(long paramLong)
  {
    this.dSU = paramLong;
    return this;
  }
  
  public final dx iq(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final dx ir(long paramLong)
  {
    this.dIt = paramLong;
    return this;
  }
  
  public final dx lO(String paramString)
  {
    AppMethodBeat.i(188264);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(188264);
    return this;
  }
  
  public final dx lP(String paramString)
  {
    AppMethodBeat.i(188265);
    this.dOH = t("SearchId", paramString, true);
    AppMethodBeat.o(188265);
    return this;
  }
  
  public final dx lQ(String paramString)
  {
    AppMethodBeat.i(188266);
    this.dSQ = t("ClickMD5", paramString, true);
    AppMethodBeat.o(188266);
    return this;
  }
  
  public final dx lR(String paramString)
  {
    AppMethodBeat.i(188267);
    this.dSR = t("QueryMD5", paramString, true);
    AppMethodBeat.o(188267);
    return this;
  }
  
  public final dx lS(String paramString)
  {
    AppMethodBeat.i(188268);
    this.dSV = t("RequestId", paramString, true);
    AppMethodBeat.o(188268);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dx
 * JD-Core Version:    0.7.0.1
 */