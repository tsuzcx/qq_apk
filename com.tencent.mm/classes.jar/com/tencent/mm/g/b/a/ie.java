package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class ie
  extends a
{
  public long dWt = 0L;
  public long ebQ = 0L;
  private String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  private String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  public long evJ = 0L;
  public long evp = 0L;
  public a ewl;
  public long ewm = 0L;
  private String ewn = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43543);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.ewl != null) {}
    for (int i = this.ewl.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ewn);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43543);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ewl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ebQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGame:").append(this.ewm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ewn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43544);
    return localObject;
  }
  
  public final ie Vd()
  {
    AppMethodBeat.i(43542);
    this.evJ = bu.fpO();
    super.bh("EndTimeStampMs", this.evJ);
    AppMethodBeat.o(43542);
    return this;
  }
  
  public final int getId()
  {
    return 15814;
  }
  
  public final ie nP(long paramLong)
  {
    AppMethodBeat.i(43540);
    this.evH = paramLong;
    super.bg("CostTimeMs", this.evH);
    AppMethodBeat.o(43540);
    return this;
  }
  
  public final ie nQ(long paramLong)
  {
    AppMethodBeat.i(43541);
    this.evI = paramLong;
    super.bh("StartTimeStampMs", this.evI);
    AppMethodBeat.o(43541);
    return this;
  }
  
  public final ie rf(String paramString)
  {
    AppMethodBeat.i(43538);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43538);
    return this;
  }
  
  public final ie rg(String paramString)
  {
    AppMethodBeat.i(43539);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43539);
    return this;
  }
  
  public final ie rh(String paramString)
  {
    AppMethodBeat.i(221934);
    this.ewn = t("engineVersion", paramString, true);
    AppMethodBeat.o(221934);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43537);
      ewo = new a("release", 0, 1);
      ewp = new a("debug", 1, 2);
      ewq = new a("demo", 2, 3);
      ewr = new a[] { ewo, ewp, ewq };
      AppMethodBeat.o(43537);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jj(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ewo;
      case 2: 
        return ewp;
      }
      return ewq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ie
 * JD-Core Version:    0.7.0.1
 */