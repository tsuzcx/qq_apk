package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tm
  extends a
{
  public long iVU = 0L;
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public a jDs;
  public long jDt = 0L;
  public b jDu;
  public long jax = 0L;
  private long jyH = 0L;
  public long jyI = 0L;
  private long jyJ = 0L;
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(368769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jDs != null) {}
    for (int i = this.jDs.value;; i = -1)
    {
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
      ((StringBuffer)localObject).append(this.jDt);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jDu != null) {
        i = this.jDu.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVU);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(368769);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jDs);
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
    ((StringBuffer)localObject).append("Ret:").append(this.jDt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.jDu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368778);
    return localObject;
  }
  
  public final int getId()
  {
    return 19986;
  }
  
  public final tm gr(long paramLong)
  {
    AppMethodBeat.i(368752);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(368752);
    return this;
  }
  
  public final tm gs(long paramLong)
  {
    AppMethodBeat.i(368758);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(368758);
    return this;
  }
  
  public final tm gt(long paramLong)
  {
    AppMethodBeat.i(368764);
    this.jyJ = paramLong;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(368764);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(369065);
      jDv = new a("release", 0, 1);
      jDw = new a("debug", 1, 2);
      jDx = new a("demo", 2, 3);
      jDy = new a[] { jDv, jDw, jDx };
      AppMethodBeat.o(369065);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a pd(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return jDv;
      case 2: 
        return jDw;
      }
      return jDx;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(369071);
      jDz = new b("sync", 0, 0);
      jDA = new b("async", 1, 1);
      jDB = new b[] { jDz, jDA };
      AppMethodBeat.o(369071);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tm
 * JD-Core Version:    0.7.0.1
 */