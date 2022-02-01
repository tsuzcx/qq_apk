package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mq
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long erW = 0L;
  private long fac = 0L;
  private long fad = 0L;
  private long fae = 0L;
  public long fbe;
  public long fbf;
  public long fdA;
  public long fdB;
  public long fdC;
  public int fdD = -1;
  public long fdE;
  public long fdF = 0L;
  public long fdG;
  public long fdH;
  public long fdI;
  public long fdJ;
  public long fdK;
  public long fdL;
  public long fdM;
  public long fdN;
  public long fdO = 0L;
  public long fdP;
  public a fdo;
  public long fdp;
  public long fdq;
  public long fdr;
  public long fds;
  public long fdt;
  public long fdu;
  public long fdv;
  public long fdw;
  public long fdx;
  public long fdy;
  public long fdz;
  
  public final String abV()
  {
    AppMethodBeat.i(160521);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fdo != null) {}
    for (int i = this.fdo.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fae);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fds);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fdP);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(160521);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(160522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fdo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.fbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willCheckStageTimeStamp:").append(this.fdp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didCheckStageTimeStamp:").append(this.fdq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkStageTimeCost:").append(this.fdr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willFirstStepViewLayoutTimeStamp:").append(this.fds);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didFirstStepViewLayoutTimeStamp:").append(this.fdt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstStepViewLayoutTimeCost:").append(this.fdu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willAllViewLayoutTimeStamp:").append(this.fdv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didAllViewLayoutTimeStamp:").append(this.fdw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allViewLayoutTimeCost:").append(this.fdx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.fbf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowReceivedTimeStamp:").append(this.fdy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowEventCostTime:").append(this.fdz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallTimeStamp:").append(this.fdA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallCostTime:").append(this.fdB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdCostTime:").append(this.fdC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("benchmarkLevel:").append(this.fdD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prepareServiceCostTime:").append(this.fdE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("notShowAdErrorCode:").append(this.fdF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallTime:").append(this.fdG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallReceivedTime:").append(this.fdH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallbackTime:").append(this.fdI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallbackReceivedTime:").append(this.fdJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperrateCallCostTime:").append(this.fdK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("adOperateCallClientCostTime:").append(this.fdL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("codeBlockTimeThreshold:").append(this.fdM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkAdTimeThreshold:").append(this.fdN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceInjectReady:").append(this.fdO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publicLibVersion:").append(this.fdP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(160522);
    return localObject;
  }
  
  public final int getId()
  {
    return 18859;
  }
  
  public final mq wA(long paramLong)
  {
    AppMethodBeat.i(160519);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(160519);
    return this;
  }
  
  public final mq wB(long paramLong)
  {
    AppMethodBeat.i(160520);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(160520);
    return this;
  }
  
  public final mq wz(long paramLong)
  {
    AppMethodBeat.i(160518);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(160518);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(160517);
      fdQ = new a("release", 0, 1);
      fdR = new a("debug", 1, 2);
      fdS = new a("demo", 2, 3);
      fdT = new a[] { fdQ, fdR, fdS };
      AppMethodBeat.o(160517);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mB(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fdQ;
      case 2: 
        return fdR;
      }
      return fdS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mq
 * JD-Core Version:    0.7.0.1
 */