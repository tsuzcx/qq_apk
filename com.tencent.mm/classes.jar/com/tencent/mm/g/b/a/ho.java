package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ho
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  public long eep;
  public long eeq;
  public long egA;
  public long egB;
  public long egC;
  public long egD;
  public long egE;
  public long egF;
  public long egG;
  public long egH;
  public int egI = -1;
  public long egJ;
  public a egt;
  public long egu;
  public long egv;
  public long egw;
  public long egx;
  public long egy;
  public long egz;
  
  public final String PR()
  {
    AppMethodBeat.i(160521);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.egt != null) {}
    for (int i = this.egt.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eep);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egJ);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(160521);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(160522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.egt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.eep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willCheckStageTimeStamp:").append(this.egu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didCheckStageTimeStamp:").append(this.egv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkStageTimeCost:").append(this.egw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willFirstStepViewLayoutTimeStamp:").append(this.egx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didFirstStepViewLayoutTimeStamp:").append(this.egy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstStepViewLayoutTimeCost:").append(this.egz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willAllViewLayoutTimeStamp:").append(this.egA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didAllViewLayoutTimeStamp:").append(this.egB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allViewLayoutTimeCost:").append(this.egC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.eeq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowReceivedTimeStamp:").append(this.egD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowEventCostTime:").append(this.egE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallTimeStamp:").append(this.egF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallCostTime:").append(this.egG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdCostTime:").append(this.egH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("benchmarkLevel:").append(this.egI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prepareServiceCostTime:").append(this.egJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(160522);
    return localObject;
  }
  
  public final int getId()
  {
    return 18859;
  }
  
  public final ho mD(long paramLong)
  {
    AppMethodBeat.i(160518);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(160518);
    return this;
  }
  
  public final ho mE(long paramLong)
  {
    AppMethodBeat.i(160519);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(160519);
    return this;
  }
  
  public final ho mF(long paramLong)
  {
    AppMethodBeat.i(160520);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(160520);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(160517);
      egK = new a("release", 0, 1);
      egL = new a("debug", 1, 2);
      egM = new a("demo", 2, 3);
      egN = new a[] { egK, egL, egM };
      AppMethodBeat.o(160517);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ja(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egK;
      case 2: 
        return egL;
      }
      return egM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ho
 * JD-Core Version:    0.7.0.1
 */