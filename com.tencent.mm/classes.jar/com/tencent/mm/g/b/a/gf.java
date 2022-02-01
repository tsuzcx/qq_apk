package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class gf
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  private String dYa = "";
  public long dZg = 0L;
  public long eaX = 0L;
  private String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  public long ebr = 0L;
  public a egw;
  public long egx = 0L;
  private String egy = "";
  
  public final String PV()
  {
    AppMethodBeat.i(43740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.egw != null) {}
    for (int i = this.egw.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dZg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egy);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43740);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.egw);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.dZg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.egx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersionStr:").append(this.egy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43741);
    return localObject;
  }
  
  public final gf Sj()
  {
    AppMethodBeat.i(43738);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43738);
    return this;
  }
  
  public final int getId()
  {
    return 15813;
  }
  
  public final gf jW(long paramLong)
  {
    AppMethodBeat.i(43736);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43736);
    return this;
  }
  
  public final gf jX(long paramLong)
  {
    AppMethodBeat.i(43737);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43737);
    return this;
  }
  
  public final gf lT(String paramString)
  {
    AppMethodBeat.i(43734);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43734);
    return this;
  }
  
  public final gf lU(String paramString)
  {
    AppMethodBeat.i(43735);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43735);
    return this;
  }
  
  public final gf lV(String paramString)
  {
    AppMethodBeat.i(43739);
    this.egy = t("engineVersionStr", paramString, true);
    AppMethodBeat.o(43739);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43733);
      egz = new a("release", 0, 1);
      egA = new a("debug", 1, 2);
      egB = new a("demo", 2, 3);
      egC = new a[] { egz, egA, egB };
      AppMethodBeat.o(43733);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jm(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egz;
      case 2: 
        return egA;
      }
      return egB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gf
 * JD-Core Version:    0.7.0.1
 */