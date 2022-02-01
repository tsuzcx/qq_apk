package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  private long dKe = 0L;
  public long dON = 0L;
  private long dYT = 0L;
  private String dYa = "";
  private String eag = "";
  private long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  private long ebr = 0L;
  private String ecf;
  public long efA = 0L;
  private long efe = 0L;
  private a efx;
  public c efy;
  public gb.b efz;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(43700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.efx != null)
    {
      i = this.efx.value;
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
      if (this.efy == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.efy.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.efz != null) {
        i = this.efz.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dON);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efe);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43700);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efx);
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
    ((StringBuffer)localObject).append("Ret:").append(this.efy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.efz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.efA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.efe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43701);
    return localObject;
  }
  
  public final gb Sh()
  {
    this.efe = 1L;
    return this;
  }
  
  public final gb a(a parama)
  {
    this.efx = parama;
    return this;
  }
  
  public final gb a(gb.b paramb)
  {
    this.efz = paramb;
    return this;
  }
  
  public final gb a(c paramc)
  {
    this.efy = paramc;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final gb jD(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final gb jE(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final gb jF(long paramLong)
  {
    AppMethodBeat.i(43696);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43696);
    return this;
  }
  
  public final gb jG(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final gb jH(long paramLong)
  {
    AppMethodBeat.i(43697);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43697);
    return this;
  }
  
  public final gb jI(long paramLong)
  {
    AppMethodBeat.i(43698);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43698);
    return this;
  }
  
  public final gb jJ(long paramLong)
  {
    this.dON = paramLong;
    return this;
  }
  
  public final gb jK(long paramLong)
  {
    this.efA = paramLong;
    return this;
  }
  
  public final gb lO(String paramString)
  {
    AppMethodBeat.i(43694);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43694);
    return this;
  }
  
  public final gb lP(String paramString)
  {
    AppMethodBeat.i(43695);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43695);
    return this;
  }
  
  public final gb lQ(String paramString)
  {
    AppMethodBeat.i(43699);
    this.ecf = t("username", paramString, true);
    AppMethodBeat.o(43699);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43687);
      efB = new a("release", 0, 1);
      efC = new a("debug", 1, 2);
      efD = new a("demo", 2, 3);
      efE = new a[] { efB, efC, efD };
      AppMethodBeat.o(43687);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ji(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efB;
      case 2: 
        return efC;
      }
      return efD;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43693);
      efI = new c("ok", 0, 0);
      efJ = new c("common_fail", 1, 1);
      efK = new c("bundle_null", 2, 2);
      efL = new c("jsapi_control_bytes_null", 3, 3);
      efM = new c[] { efI, efJ, efK, efL };
      AppMethodBeat.o(43693);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gb
 * JD-Core Version:    0.7.0.1
 */