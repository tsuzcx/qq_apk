package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bj
  extends a
{
  public long dFd = 0L;
  private String dHr = "";
  private String dPD = "";
  private String dPE = "";
  private String dPF = "";
  private String dPG = "";
  
  public final String PV()
  {
    AppMethodBeat.i(196669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(196669);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(196670);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.dPD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.dPE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.dPF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.dPG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(196670);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
  
  public final bj ie(String paramString)
  {
    AppMethodBeat.i(196664);
    this.dPD = t("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(196664);
    return this;
  }
  
  public final bj jdMethod_if(String paramString)
  {
    AppMethodBeat.i(196665);
    this.dPE = t("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(196665);
    return this;
  }
  
  public final bj ig(String paramString)
  {
    AppMethodBeat.i(196666);
    this.dPF = t("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(196666);
    return this;
  }
  
  public final bj ih(String paramString)
  {
    AppMethodBeat.i(196667);
    this.dPG = t("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(196667);
    return this;
  }
  
  public final bj ii(String paramString)
  {
    AppMethodBeat.i(196668);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(196668);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bj
 * JD-Core Version:    0.7.0.1
 */