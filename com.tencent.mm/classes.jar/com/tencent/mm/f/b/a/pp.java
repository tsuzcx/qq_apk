package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pp
  extends a
{
  public long gYL = 0L;
  public long gYN = 0L;
  public String gfn = "";
  public String gmF = "";
  public long gnP = 0L;
  public String gtA = "";
  private long hcT = 0L;
  private long hcU = 0L;
  private long hcV = 0L;
  public long hdV;
  public long hdW;
  public long hgA;
  public long hgB;
  public long hgC;
  public int hgD = -1;
  public long hgE;
  public long hgF = 0L;
  public long hgG;
  public long hgH;
  public long hgI;
  public long hgJ;
  public long hgK;
  public long hgL;
  public long hgM;
  public long hgN;
  public long hgO = 0L;
  public long hgP;
  public pp.a hgo;
  public long hgp;
  public long hgq;
  public long hgr;
  public long hgs;
  public long hgt;
  public long hgu;
  public long hgv;
  public long hgw;
  public long hgx;
  public long hgy;
  public long hgz;
  
  public final pp CA(long paramLong)
  {
    AppMethodBeat.i(160519);
    this.hcU = paramLong;
    super.bm("StartTimeStampMs", this.hcU);
    AppMethodBeat.o(160519);
    return this;
  }
  
  public final pp CB(long paramLong)
  {
    AppMethodBeat.i(160520);
    this.hcV = paramLong;
    super.bm("EndTimeStampMs", this.hcV);
    AppMethodBeat.o(160520);
    return this;
  }
  
  public final pp Cz(long paramLong)
  {
    AppMethodBeat.i(160518);
    this.hcT = paramLong;
    super.bk("CostTimeMs", this.hcT);
    AppMethodBeat.o(160518);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(160521);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hgo != null) {}
    for (int i = this.hgo.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgs);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hdW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hgP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gtA);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(160521);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(160522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hgo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.hcT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.hcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.hcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.hdV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willCheckStageTimeStamp:").append(this.hgp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didCheckStageTimeStamp:").append(this.hgq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkStageTimeCost:").append(this.hgr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willFirstStepViewLayoutTimeStamp:").append(this.hgs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didFirstStepViewLayoutTimeStamp:").append(this.hgt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstStepViewLayoutTimeCost:").append(this.hgu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willAllViewLayoutTimeStamp:").append(this.hgv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didAllViewLayoutTimeStamp:").append(this.hgw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allViewLayoutTimeCost:").append(this.hgx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.hdW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowReceivedTimeStamp:").append(this.hgy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowEventCostTime:").append(this.hgz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallTimeStamp:").append(this.hgA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallCostTime:").append(this.hgB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdCostTime:").append(this.hgC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("benchmarkLevel:").append(this.hgD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prepareServiceCostTime:").append(this.hgE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("notShowAdErrorCode:").append(this.hgF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallTime:").append(this.hgG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallReceivedTime:").append(this.hgH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallbackTime:").append(this.hgI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallbackReceivedTime:").append(this.hgJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperrateCallCostTime:").append(this.hgK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallClientCostTime:").append(this.hgL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("codeBlockTimeThreshold:").append(this.hgM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkAdTimeThreshold:").append(this.hgN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceInjectReady:").append(this.hgO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publicLibVersion:").append(this.hgP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(160522);
    return localObject;
  }
  
  public final int getId()
  {
    return 18859;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pp
 * JD-Core Version:    0.7.0.1
 */