package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fw
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  public long ecj;
  public long eck;
  public long eeA;
  public int eeB = -1;
  public long eeC;
  public a eem;
  public long een;
  public long eeo;
  public long eep;
  public long eeq;
  public long eer;
  public long ees;
  public long eet;
  public long eeu;
  public long eev;
  public long eew;
  public long eex;
  public long eey;
  public long eez;
  
  public final String PV()
  {
    AppMethodBeat.i(160521);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eem != null) {}
    for (int i = this.eem.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.een);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eep);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eer);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ees);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eet);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eev);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eck);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eew);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eex);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eey);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eez);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeC);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(160521);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(160522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eem);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.ecj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willCheckStageTimeStamp:").append(this.een);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didCheckStageTimeStamp:").append(this.eeo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkStageTimeCost:").append(this.eep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willFirstStepViewLayoutTimeStamp:").append(this.eeq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didFirstStepViewLayoutTimeStamp:").append(this.eer);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstStepViewLayoutTimeCost:").append(this.ees);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("willAllViewLayoutTimeStamp:").append(this.eet);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("didAllViewLayoutTimeStamp:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allViewLayoutTimeCost:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.eck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowReceivedTimeStamp:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shouldShowEventCostTime:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallTimeStamp:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showCallCostTime:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdCostTime:").append(this.eeA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("benchmarkLevel:").append(this.eeB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prepareServiceCostTime:").append(this.eeC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(160522);
    return localObject;
  }
  
  public final int getId()
  {
    return 18859;
  }
  
  public final fw jb(long paramLong)
  {
    AppMethodBeat.i(160518);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(160518);
    return this;
  }
  
  public final fw jc(long paramLong)
  {
    AppMethodBeat.i(160519);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(160519);
    return this;
  }
  
  public final fw jd(long paramLong)
  {
    AppMethodBeat.i(160520);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(160520);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(160517);
      eeD = new a("release", 0, 1);
      eeE = new a("debug", 1, 2);
      eeF = new a("demo", 2, 3);
      eeG = new a[] { eeD, eeE, eeF };
      AppMethodBeat.o(160517);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jc(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeD;
      case 2: 
        return eeE;
      }
      return eeF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fw
 * JD-Core Version:    0.7.0.1
 */