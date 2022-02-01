package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public String ilL = "";
  public String ilM = "";
  public long ilN;
  public long ilO;
  public long ilP;
  public long ilQ;
  public long ilR;
  public long ilS;
  public long ilT;
  private String ilU = "";
  public long ilV;
  public long ilW = -1L;
  public long ilX = -1L;
  public long ilY = -1L;
  public long ilZ = -1L;
  public long ima;
  public long imb = -1L;
  public long imc = -1L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368588);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ima);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368588);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368602);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CheckSendShouldTimeStamp:").append(this.ilN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateStart:").append(this.ilO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateEnd:").append(this.ilP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadStatus:").append(this.ilQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkerCreateStatus:").append(this.ilR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingWorkerCreateCost:").append(this.ilS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllCostTime:").append(this.ilT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateFailErrorMsg:").append(this.ilU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowAdState:").append(this.ilV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartInjectJsTimestamp:").append(this.ilW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsInjectCost:").append(this.ilX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateCost:").append(this.ilY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CheckShowAdAllTime:").append(this.ilZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEnableAdWhenColdLaunch:").append(this.ima);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkerCreateEarlyTime:").append(this.imb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLoadingFinished:").append(this.imc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368602);
    return localObject;
  }
  
  public final int getId()
  {
    return 22732;
  }
  
  public final t kl(String paramString)
  {
    AppMethodBeat.i(368581);
    this.ilU = F("AdWorkerCreateFailErrorMsg", paramString, true);
    AppMethodBeat.o(368581);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.t
 * JD-Core Version:    0.7.0.1
 */