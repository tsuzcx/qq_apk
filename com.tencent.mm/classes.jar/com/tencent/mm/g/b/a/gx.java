package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gx
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  public a edO;
  public long edP = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43525);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.edO != null) {}
    for (int i = this.edO.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edP);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43525);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edO);
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
    ((StringBuffer)localObject).append("isFromAndroidRecents:").append(this.edP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43526);
    return localObject;
  }
  
  public final int getId()
  {
    return 16898;
  }
  
  public final gx lD(long paramLong)
  {
    AppMethodBeat.i(43522);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43522);
    return this;
  }
  
  public final gx lE(long paramLong)
  {
    AppMethodBeat.i(43523);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43523);
    return this;
  }
  
  public final gx lF(long paramLong)
  {
    AppMethodBeat.i(43524);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43524);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43521);
      edQ = new a("release", 0, 1);
      edR = new a("debug", 1, 2);
      edS = new a("demo", 2, 3);
      edT = new a[] { edQ, edR, edS };
      AppMethodBeat.o(43521);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iM(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edQ;
      case 2: 
        return edR;
      }
      return edS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gx
 * JD-Core Version:    0.7.0.1
 */