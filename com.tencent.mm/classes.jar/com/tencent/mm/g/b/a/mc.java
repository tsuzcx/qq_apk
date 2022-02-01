package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class mc
  extends a
{
  private String eJx = "";
  private String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK = 0L;
  public long eZN = 0L;
  public long erW = 0L;
  private String exq = "";
  private String faT = "";
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public a fba;
  public long fbb = 0L;
  public long fbc = 0L;
  public long fbd;
  public long fbe = 0L;
  public long fbf = 0L;
  public long fbg = 0L;
  
  public final mc a(a parama)
  {
    this.fba = parama;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fba != null) {}
    for (int i = this.fba.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.faT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbg);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fba);
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
    ((StringBuffer)localObject).append("username:").append(this.faT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.fbb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.fbc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.fbd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.fbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.fbf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.fbg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
    return localObject;
  }
  
  public final long aiV()
  {
    return this.fad;
  }
  
  public final long aiW()
  {
    return this.fae;
  }
  
  public final mc aiX()
  {
    AppMethodBeat.i(43557);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final mc aiY()
  {
    this.eZN = 0L;
    return this;
  }
  
  public final mc aiZ()
  {
    this.eZK = 0L;
    return this;
  }
  
  public final mc aja()
  {
    this.fbc = 2L;
    return this;
  }
  
  public final mc ajb()
  {
    this.fbd = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
  
  public final mc vF(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mc vG(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mc vH(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final mc vI(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mc vJ(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final mc vK(long paramLong)
  {
    this.fbb = paramLong;
    return this;
  }
  
  public final mc zp(String paramString)
  {
    AppMethodBeat.i(43553);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final mc zq(String paramString)
  {
    AppMethodBeat.i(43554);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final mc zr(String paramString)
  {
    AppMethodBeat.i(43558);
    this.faT = x("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final mc zs(String paramString)
  {
    AppMethodBeat.i(43559);
    this.exq = x("networkType", paramString, true);
    AppMethodBeat.o(43559);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43552);
      fbh = new a("release", 0, 1);
      fbi = new a("debug", 1, 2);
      fbj = new a("demo", 2, 3);
      fbk = new a[] { fbh, fbi, fbj };
      AppMethodBeat.o(43552);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mq(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fbh;
      case 2: 
        return fbi;
      }
      return fbj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mc
 * JD-Core Version:    0.7.0.1
 */