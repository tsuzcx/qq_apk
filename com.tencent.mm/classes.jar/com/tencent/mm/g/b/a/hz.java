package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hz
  extends a
{
  public long dHY = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public long eaY = 0L;
  public String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  private long edv = 0L;
  private long edw = 0L;
  private long edx = 0L;
  public a eiO;
  
  public final String PR()
  {
    AppMethodBeat.i(43753);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eiO != null) {}
    for (int i = this.eiO.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43753);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43754);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eiO);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.eaY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43754);
    return localObject;
  }
  
  public final int getId()
  {
    return 16368;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43752);
      eiP = new a("release", 0, 1);
      eiQ = new a("debug", 1, 2);
      eiR = new a("demo", 2, 3);
      eiS = new a[] { eiP, eiQ, eiR };
      AppMethodBeat.o(43752);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jm(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eiP;
      case 2: 
        return eiQ;
      }
      return eiR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hz
 * JD-Core Version:    0.7.0.1
 */