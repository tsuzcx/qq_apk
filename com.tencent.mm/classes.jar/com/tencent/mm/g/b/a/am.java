package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  private String dTr = "";
  private long dUl;
  private String dXA = "";
  private long dXB;
  private long dXC;
  private long dXD;
  private long dXE;
  private long dXF;
  private long dXy;
  private long dXz;
  
  public final String RC()
  {
    AppMethodBeat.i(189101);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXF);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189101);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189102);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dXy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.dXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.dXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.dXB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.dXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.dXD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.dXE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dUl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.dXF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189102);
    return localObject;
  }
  
  public final am RL()
  {
    this.dXB = 1L;
    return this;
  }
  
  public final am RM()
  {
    this.dXC = 1L;
    return this;
  }
  
  public final am RN()
  {
    this.dXE = 1L;
    return this;
  }
  
  public final am RO()
  {
    this.dUl = 1L;
    return this;
  }
  
  public final am de(long paramLong)
  {
    this.dXy = paramLong;
    return this;
  }
  
  public final am df(long paramLong)
  {
    this.dXz = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final am hO(String paramString)
  {
    AppMethodBeat.i(189099);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189099);
    return this;
  }
  
  public final am hP(String paramString)
  {
    AppMethodBeat.i(189100);
    this.dXA = t("FailReasonWording", paramString, true);
    AppMethodBeat.o(189100);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.am
 * JD-Core Version:    0.7.0.1
 */