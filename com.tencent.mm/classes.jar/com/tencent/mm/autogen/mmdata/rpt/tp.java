package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class tp
  extends a
{
  public long iVU = 0L;
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long jAq;
  public String jCW = "";
  public a jDZ;
  public long jEa = 0L;
  public c jEb;
  public b jEc;
  public long jEd = 0L;
  private long jEe = 0L;
  private long jEf = 0L;
  private long jEg = 0L;
  public long jEh;
  public long jEi;
  public long jEj;
  public long jEk;
  public e jEl;
  public long jEm;
  public d jEn;
  public long jEo;
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  public long jyJ = 0L;
  public long jyp = 0L;
  public long jzT = 0L;
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jDZ != null)
    {
      i = this.jDZ.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEa);
      ((StringBuffer)localObject).append(",");
      if (this.jEb == null) {
        break label557;
      }
      i = this.jEb.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.jEc == null) {
        break label562;
      }
      i = this.jEc.value;
      label230:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jzT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEh);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEi);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEk);
      ((StringBuffer)localObject).append(",");
      if (this.jEl == null) {
        break label567;
      }
    }
    label557:
    label562:
    label567:
    for (int i = this.jEl.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jAq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jCW);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jEn != null) {
        i = this.jEn.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jEo);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
      i = -1;
      break label230;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jDZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.jyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.jyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.jyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PkgSize:").append(this.jEa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.jEb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.jEc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.jEd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.jEe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.jEf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.jyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.jEg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.jzT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.jEh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.jEi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.jEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.jEk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.jEl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.jEm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.jAq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkTypeStr:").append(this.jCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckAppidABTestInfoSync:").append(this.jEn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkAppidABTestInfoReadyT:").append(this.jEo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final tp aJi()
  {
    AppMethodBeat.i(43720);
    this.jyJ = Util.nowMilliSecond();
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final tp gA(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final tp gB(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.jEg = paramLong;
    super.bw("NonUICostTimeMs", this.jEg);
    AppMethodBeat.o(43721);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final tp gz(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43711);
      jEp = new a("release", 0, 1);
      jEq = new a("debug", 1, 2);
      jEr = new a("demo", 2, 3);
      jEs = new a[] { jEp, jEq, jEr };
      AppMethodBeat.o(43711);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a pg(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return jEp;
      case 2: 
        return jEq;
      }
      return jEr;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43714);
      jEt = new b("sync", 0, 0);
      jEu = new b("unsync", 1, 1);
      jEv = new b[] { jEt, jEu };
      AppMethodBeat.o(43714);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43717);
      jEw = new c("sync", 0, 0);
      jEx = new c("unsync", 1, 1);
      jEy = new c[] { jEw, jEx };
      AppMethodBeat.o(43717);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(368294);
      jEz = new d("sync", 0, 0);
      jEA = new d("unsync", 1, 1);
      jEB = new d[] { jEz, jEA };
      AppMethodBeat.o(368294);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(367960);
      jEC = new e("sync", 0, 0);
      jED = new e("unsync", 1, 1);
      jEE = new e[] { jEC, jED };
      AppMethodBeat.o(367960);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tp
 * JD-Core Version:    0.7.0.1
 */