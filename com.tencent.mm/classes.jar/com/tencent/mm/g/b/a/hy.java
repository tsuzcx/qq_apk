package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class hy
  extends a
{
  public long dVd = 0L;
  private String eqt = "";
  private String esR = "";
  public long esT = 0L;
  private long eua = 0L;
  public long eub = 0L;
  public long euc = 0L;
  public a eui;
  public long euj = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    if (this.eui != null) {}
    for (int i = this.eui.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eua);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eub);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euj);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPreload:").append(this.euj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final hy UW()
  {
    AppMethodBeat.i(43508);
    this.euc = bt.flT();
    super.bg("EndTimeStampMs", this.euc);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final hy ns(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.eua = paramLong;
    super.bf("CostTimeMs", this.eua);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final hy nt(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.eub = paramLong;
    super.bg("StartTimeStampMs", this.eub);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final hy qI(String paramString)
  {
    AppMethodBeat.i(43504);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final hy qJ(String paramString)
  {
    AppMethodBeat.i(43505);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43503);
      euk = new a("release", 0, 1);
      eul = new a("debug", 1, 2);
      eum = new a("demo", 2, 3);
      eun = new a[] { euk, eul, eum };
      AppMethodBeat.o(43503);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jd(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return euk;
      case 2: 
        return eul;
      }
      return eum;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hy
 * JD-Core Version:    0.7.0.1
 */