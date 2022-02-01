package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gh
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public long dZg = 0L;
  public long eaX = 0L;
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  public a egI;
  
  public final String PV()
  {
    AppMethodBeat.i(43753);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.egI != null) {}
    for (int i = this.egI.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dZg);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43753);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43754);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.egI);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.dZg);
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
      egJ = new a("release", 0, 1);
      egK = new a("debug", 1, 2);
      egL = new a("demo", 2, 3);
      egM = new a[] { egJ, egK, egL };
      AppMethodBeat.o(43752);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jo(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egJ;
      case 2: 
        return egK;
      }
      return egL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gh
 * JD-Core Version:    0.7.0.1
 */