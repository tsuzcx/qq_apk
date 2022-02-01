package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  public long dPl = 0L;
  private String dSb = "";
  private String egR = "";
  private String egS = "";
  private String egT = "";
  private String egU = "";
  
  public final String RD()
  {
    AppMethodBeat.i(211818);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.egR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211818);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.egR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.egS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.egT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.egU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211819);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
  
  public final dq mW(String paramString)
  {
    AppMethodBeat.i(211813);
    this.egR = t("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(211813);
    return this;
  }
  
  public final dq mX(String paramString)
  {
    AppMethodBeat.i(211814);
    this.egS = t("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(211814);
    return this;
  }
  
  public final dq mY(String paramString)
  {
    AppMethodBeat.i(211815);
    this.egT = t("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(211815);
    return this;
  }
  
  public final dq mZ(String paramString)
  {
    AppMethodBeat.i(211816);
    this.egU = t("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(211816);
    return this;
  }
  
  public final dq na(String paramString)
  {
    AppMethodBeat.i(211817);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(211817);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dq
 * JD-Core Version:    0.7.0.1
 */