package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  private long dSV;
  private String dSb;
  private long dWg;
  private long dWh;
  private String dWi;
  private long dWj;
  private long dWk;
  private long dWl;
  private long dWm;
  private long dWn;
  
  public final String RD()
  {
    AppMethodBeat.i(209071);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWn);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209071);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209072);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.dWg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.dWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.dWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.dWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.dWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.dWn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209072);
    return localObject;
  }
  
  public final am RM()
  {
    this.dWj = 1L;
    return this;
  }
  
  public final am RN()
  {
    this.dWk = 1L;
    return this;
  }
  
  public final am RO()
  {
    this.dWm = 1L;
    return this;
  }
  
  public final am RP()
  {
    this.dSV = 1L;
    return this;
  }
  
  public final am de(long paramLong)
  {
    this.dWg = paramLong;
    return this;
  }
  
  public final am df(long paramLong)
  {
    this.dWh = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final am hG(String paramString)
  {
    AppMethodBeat.i(209069);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209069);
    return this;
  }
  
  public final am hH(String paramString)
  {
    AppMethodBeat.i(209070);
    this.dWi = t("FailReasonWording", paramString, true);
    AppMethodBeat.o(209070);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.am
 * JD-Core Version:    0.7.0.1
 */