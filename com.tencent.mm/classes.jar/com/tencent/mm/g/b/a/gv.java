package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class gv
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  private String ecm = "";
  public long eco = 0L;
  public a edD;
  public long edE = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    if (this.edD != null) {}
    for (int i = this.edD.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edE);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edD);
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
    ((StringBuffer)localObject).append("IsPreload:").append(this.edE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final gv SI()
  {
    AppMethodBeat.i(43508);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final gv ly(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final gv lz(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final gv oj(String paramString)
  {
    AppMethodBeat.i(43504);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final gv ok(String paramString)
  {
    AppMethodBeat.i(43505);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43503);
      edF = new a("release", 0, 1);
      edG = new a("debug", 1, 2);
      edH = new a("demo", 2, 3);
      edI = new a[] { edF, edG, edH };
      AppMethodBeat.o(43503);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iK(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edF;
      case 2: 
        return edG;
      }
      return edH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gv
 * JD-Core Version:    0.7.0.1
 */