package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fq
  extends a
{
  private long dKe = 0L;
  private String dTc = "";
  private long dYT = 0L;
  private String dYa = "";
  private String eaK = "";
  private String eag = "";
  private long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  private long ecS;
  private a edg;
  private long edh = 0L;
  private long edi = 0L;
  private String edj;
  
  public final String PV()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.edg != null) {}
    for (int i = this.edg.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edh);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dTc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edi);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecS);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edg);
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
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.edh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.edi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.edj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.ecS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final String Sc()
  {
    return this.dYa;
  }
  
  public final fq a(a parama)
  {
    this.edg = parama;
    return this;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final fq iI(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fq iJ(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fq iK(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fq iL(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final fq iM(long paramLong)
  {
    this.edh = paramLong;
    return this;
  }
  
  public final fq iN(long paramLong)
  {
    this.edi = paramLong;
    return this;
  }
  
  public final fq iO(long paramLong)
  {
    this.ecS = paramLong;
    return this;
  }
  
  public final fq ls(String paramString)
  {
    AppMethodBeat.i(43604);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final fq lt(String paramString)
  {
    AppMethodBeat.i(43605);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final fq lu(String paramString)
  {
    AppMethodBeat.i(195489);
    this.eaK = t("networkType", paramString, true);
    AppMethodBeat.o(195489);
    return this;
  }
  
  public final fq lv(String paramString)
  {
    AppMethodBeat.i(43608);
    this.dTc = t("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43603);
      edk = new a("release", 0, 1);
      edl = new a("debug", 1, 2);
      edm = new a("demo", 2, 3);
      edn = new a[] { edk, edl, edm };
      AppMethodBeat.o(43603);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iX(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edk;
      case 2: 
        return edl;
      }
      return edm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fq
 * JD-Core Version:    0.7.0.1
 */