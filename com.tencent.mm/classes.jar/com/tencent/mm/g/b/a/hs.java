package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private long dHY = 0L;
  public long dQE = 0L;
  private String dZT = "";
  private long eaM = 0L;
  private String ecm = "";
  private long eco = 0L;
  private long edv = 0L;
  public long edw = 0L;
  private long edx = 0L;
  private a ehu;
  public long ehv = 0L;
  public b ehw;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(186200);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ehu != null) {}
    for (int i = this.ehu.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ehv);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ehw != null) {
        i = this.ehw.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dQE);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(186200);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(186201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ehu);
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
    ((StringBuffer)localObject).append("Ret:").append(this.ehv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.ehw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186201);
    return localObject;
  }
  
  public final hs a(a parama)
  {
    this.ehu = parama;
    return this;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public final hs mZ(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hs na(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hs nb(long paramLong)
  {
    AppMethodBeat.i(186197);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(186197);
    return this;
  }
  
  public final hs nc(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hs nd(long paramLong)
  {
    AppMethodBeat.i(186198);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(186198);
    return this;
  }
  
  public final hs ne(long paramLong)
  {
    AppMethodBeat.i(186199);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(186199);
    return this;
  }
  
  public final hs oR(String paramString)
  {
    AppMethodBeat.i(186195);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(186195);
    return this;
  }
  
  public final hs oS(String paramString)
  {
    AppMethodBeat.i(186196);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(186196);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(186191);
      ehx = new a("release", 0, 1);
      ehy = new a("debug", 1, 2);
      ehz = new a("demo", 2, 3);
      ehA = new a[] { ehx, ehy, ehz };
      AppMethodBeat.o(186191);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ehx;
      case 2: 
        return ehy;
      }
      return ehz;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(186194);
      ehB = new b("sync", 0, 0);
      ehC = new b("async", 1, 1);
      ehD = new b[] { ehB, ehC };
      AppMethodBeat.o(186194);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hs
 * JD-Core Version:    0.7.0.1
 */