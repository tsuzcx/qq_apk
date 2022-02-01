package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fu
  extends a
{
  private long dKe = 0L;
  private long dYT = 0L;
  private String dYa = "";
  private String eag = "";
  private long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  private a edE;
  private long edF = 0L;
  private long edG = 0L;
  private String edH = "";
  private long edI = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.edE != null) {}
    for (int i = this.edE.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edI);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43639);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edE);
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
    ((StringBuffer)localObject).append("processNum:").append(this.edF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeNum:").append(this.edG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distribution:").append(this.edH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mmtoolsAlive:").append(this.edI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43640);
    return localObject;
  }
  
  public final fu a(a parama)
  {
    this.edE = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18032;
  }
  
  public final fu iV(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fu iW(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fu iX(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fu iY(long paramLong)
  {
    this.edF = paramLong;
    return this;
  }
  
  public final fu iZ(long paramLong)
  {
    this.edG = paramLong;
    return this;
  }
  
  public final fu ja(long paramLong)
  {
    this.edI = paramLong;
    return this;
  }
  
  public final fu lA(String paramString)
  {
    AppMethodBeat.i(43636);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43636);
    return this;
  }
  
  public final fu lB(String paramString)
  {
    AppMethodBeat.i(43637);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43637);
    return this;
  }
  
  public final fu lC(String paramString)
  {
    AppMethodBeat.i(43638);
    this.edH = t("distribution", paramString, true);
    AppMethodBeat.o(43638);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43635);
      edJ = new a("release", 0, 1);
      edK = new a("debug", 1, 2);
      edL = new a("demo", 2, 3);
      edM = new a[] { edJ, edK, edL };
      AppMethodBeat.o(43635);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ja(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edJ;
      case 2: 
        return edK;
      }
      return edL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fu
 * JD-Core Version:    0.7.0.1
 */