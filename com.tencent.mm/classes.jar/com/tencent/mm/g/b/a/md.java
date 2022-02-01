package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class md
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK;
  public long eZN;
  private long erW = 0L;
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public a fbl;
  public String fbm = "";
  public long fbn;
  public long fbo;
  public long fbp;
  
  public final String abV()
  {
    AppMethodBeat.i(226076);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fbl != null) {}
    for (int i = this.fbl.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fae);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbp);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(226076);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226077);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fbl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.fbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPatch:").append(this.fbn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.fbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingInEndT:").append(this.fbp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226077);
    return localObject;
  }
  
  public final int getId()
  {
    return 19266;
  }
  
  public final md vL(long paramLong)
  {
    AppMethodBeat.i(226073);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(226073);
    return this;
  }
  
  public final md vM(long paramLong)
  {
    AppMethodBeat.i(226074);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(226074);
    return this;
  }
  
  public final md vN(long paramLong)
  {
    AppMethodBeat.i(226075);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(226075);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(226072);
      fbq = new a("release", 0, 1);
      fbr = new a("debug", 1, 2);
      fbs = new a("demo", 2, 3);
      fbt = new a[] { fbq, fbr, fbs };
      AppMethodBeat.o(226072);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mr(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fbq;
      case 2: 
        return fbr;
      }
      return fbs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.md
 * JD-Core Version:    0.7.0.1
 */