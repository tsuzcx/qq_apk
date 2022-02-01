package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class me
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc;
  public long eYW;
  public long eZK;
  public long erW;
  public String exq = "";
  private long fac;
  private long fad;
  public long fae;
  public String fbm = "";
  public long fbo;
  public a fbu;
  public long fbv;
  public long fbw;
  public long fbx;
  
  public final String abV()
  {
    AppMethodBeat.i(43568);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fbu != null) {}
    for (int i = this.fbu.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbx);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43568);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43569);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fbu);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.fbv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSplitCodeLib:").append(this.fbw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.fbo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstPageRenderingCacheAccepted:").append(this.fbx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43569);
    return localObject;
  }
  
  public final me ajc()
  {
    AppMethodBeat.i(43567);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43567);
    return this;
  }
  
  public final int getId()
  {
    return 18798;
  }
  
  public final me vO(long paramLong)
  {
    AppMethodBeat.i(43565);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43565);
    return this;
  }
  
  public final me vP(long paramLong)
  {
    AppMethodBeat.i(43566);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43566);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43564);
      fby = new a("release", 0, 1);
      fbz = new a("debug", 1, 2);
      fbA = new a("demo", 2, 3);
      fbB = new a[] { fby, fbz, fbA };
      AppMethodBeat.o(43564);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ms(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fby;
      case 2: 
        return fbz;
      }
      return fbA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.me
 * JD-Core Version:    0.7.0.1
 */