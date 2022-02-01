package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fg
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public long dZg = 0L;
  public String eag = "";
  public long eai = 0L;
  public a ebO;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43533);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ebO != null) {}
    for (int i = this.ebO.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.dZg);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43533);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43534);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ebO);
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
    ((StringBuffer)localObject).append("type:").append(this.dZg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43534);
    return localObject;
  }
  
  public final int getId()
  {
    return 16899;
  }
  
  public final fg ie(long paramLong)
  {
    AppMethodBeat.i(43530);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43530);
    return this;
  }
  
  public final fg jdMethod_if(long paramLong)
  {
    AppMethodBeat.i(43531);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43531);
    return this;
  }
  
  public final fg ig(long paramLong)
  {
    AppMethodBeat.i(43532);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43532);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43529);
      ebP = new a("release", 0, 1);
      ebQ = new a("debug", 1, 2);
      ebR = new a("demo", 2, 3);
      ebS = new a[] { ebP, ebQ, ebR };
      AppMethodBeat.o(43529);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iP(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ebP;
      case 2: 
        return ebQ;
      }
      return ebR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fg
 * JD-Core Version:    0.7.0.1
 */