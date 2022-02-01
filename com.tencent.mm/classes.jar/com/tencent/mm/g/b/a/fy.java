package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fy
  extends a
{
  public long dKe = 0L;
  public long dON = 0L;
  public String dTc = "";
  public long dYT = 0L;
  private String dYa = "";
  private String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  public a eeP;
  public c eeQ;
  public fy.b eeR;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eeP != null)
    {
      i = this.eeP.value;
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
      if (this.eeQ == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.eeQ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eeR != null) {
        i = this.eeR.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dON);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dTc);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eeP);
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
    ((StringBuffer)localObject).append("Ret:").append(this.eeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dTc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final fy a(a parama)
  {
    this.eeP = parama;
    return this;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final fy jj(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fy jk(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fy jl(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final fy jm(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fy jn(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final fy jo(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final fy lH(String paramString)
  {
    AppMethodBeat.i(43663);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final fy lI(String paramString)
  {
    AppMethodBeat.i(43664);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      eeS = new a("release", 0, 1);
      eeT = new a("debug", 1, 2);
      eeU = new a("demo", 2, 3);
      eeV = new a[] { eeS, eeT, eeU };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a je(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeS;
      case 2: 
        return eeT;
      }
      return eeU;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43662);
      eeZ = new c("ok", 0, 0);
      efa = new c("common_fail", 1, 1);
      efb = new c[] { eeZ, efa };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fy
 * JD-Core Version:    0.7.0.1
 */