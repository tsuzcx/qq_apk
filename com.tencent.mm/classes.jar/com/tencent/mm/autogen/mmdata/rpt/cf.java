package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cf
  extends a
{
  public int ivK = -1;
  public long ivm;
  public long ivn;
  public long ivo;
  public int ivp;
  public int ivq;
  public int ivr;
  public int ivs;
  public long ivt;
  public long ivu;
  public long ivv;
  private String ivw = "";
  private String ivx = "";
  public int ivy;
  
  public final String aIE()
  {
    AppMethodBeat.i(368237);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ivm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368237);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368247);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResultCode:").append(this.ivm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AliveType:").append(this.ivn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalState:").append(this.ivo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PrepareCgiErrorCode:").append(this.ivp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigCgiErrorCode:").append(this.ivq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnErrorCode:").append(this.ivr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VerifyCgiErrorCode:").append(this.ivs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnCost:").append(this.ivt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LivenessCost:").append(this.ivu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetCount:").append(this.ivv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StateRecord:").append(this.ivw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AndroidStateRecord:").append(this.ivx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FaceReset:").append(this.ivy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorType:").append(this.ivK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368247);
    return localObject;
  }
  
  public final int getId()
  {
    return 21131;
  }
  
  public final cf lx(String paramString)
  {
    AppMethodBeat.i(368217);
    this.ivw = F("StateRecord", paramString, true);
    AppMethodBeat.o(368217);
    return this;
  }
  
  public final cf ly(String paramString)
  {
    AppMethodBeat.i(368225);
    this.ivx = F("AndroidStateRecord", paramString, true);
    AppMethodBeat.o(368225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cf
 * JD-Core Version:    0.7.0.1
 */