package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class fj
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  private String dYa = "";
  private String eaK = "";
  public long eaX = 0L;
  private String eag = "";
  public long eai = 0L;
  public long eba = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public a ece;
  private String ecf = "";
  public long ecg = 0L;
  public long ech = 0L;
  public long eci;
  public long ecj = 0L;
  public long eck = 0L;
  public long ecl = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ece != null) {}
    for (int i = this.ece.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ecf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eba);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ech);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eci);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eck);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecl);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ece);
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
    ((StringBuffer)localObject).append("username:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.ecg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.ech);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.eci);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.ecj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.eck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.ecl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
    return localObject;
  }
  
  public final long RR()
  {
    return this.ebq;
  }
  
  public final long RS()
  {
    return this.ebr;
  }
  
  public final fj RT()
  {
    AppMethodBeat.i(43557);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final fj RU()
  {
    this.eba = 0L;
    return this;
  }
  
  public final fj RV()
  {
    this.eaX = 0L;
    return this;
  }
  
  public final fj RW()
  {
    this.ech = 2L;
    return this;
  }
  
  public final fj RX()
  {
    this.eci = 0L;
    return this;
  }
  
  public final fj a(a parama)
  {
    this.ece = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
  
  public final fj ij(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fj ik(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fj il(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final fj im(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fj in(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final fj io(long paramLong)
  {
    this.ecg = paramLong;
    return this;
  }
  
  public final fj li(String paramString)
  {
    AppMethodBeat.i(43553);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final fj lj(String paramString)
  {
    AppMethodBeat.i(43554);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final fj lk(String paramString)
  {
    AppMethodBeat.i(43558);
    this.ecf = t("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final fj ll(String paramString)
  {
    AppMethodBeat.i(43559);
    this.eaK = t("networkType", paramString, true);
    AppMethodBeat.o(43559);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43552);
      ecm = new a("release", 0, 1);
      ecn = new a("debug", 1, 2);
      eco = new a("demo", 2, 3);
      ecp = new a[] { ecm, ecn, eco };
      AppMethodBeat.o(43552);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iS(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ecm;
      case 2: 
        return ecn;
      }
      return eco;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fj
 * JD-Core Version:    0.7.0.1
 */